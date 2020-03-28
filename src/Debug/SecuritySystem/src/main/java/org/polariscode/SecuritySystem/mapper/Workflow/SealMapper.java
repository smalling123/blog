package org.polariscode.SecuritySystem.mapper.Workflow;

import java.util.List;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import org.polariscode.SecuritySystem.model.Workflow.Seal;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

public interface SealMapper {
	//根据ID获取指定的印鉴申请实体
	@Select("Select ID, OrgID, UserID, Date, Content, Type, SealType, W1, W2, W3, W4, W5, W6, W7, W8, W9, W10, W11, Other, WorkflowID, File1\n"
		+"From Seal Where ID = #{id}")
	Seal getSealOne(@Param("id") int id);

	@Insert("Insert Into Seal(OrgID, UserID, Date, Content, Type, SealType, W1, W2, W3, W4, W5, W6, W7, W8, W9, W10, W11, Other, WorkflowID, File1)\n"
		+"Values(#{seal.OrgID}, #{seal.UserID}, Now(), #{seal.Content}, #{seal.Type}, #{seal.SealType}, #{seal.W1}, #{seal.W2}, #{seal.W3}, #{seal.W4}, #{seal.W5}, #{seal.W6}, #{seal.W7}, #{seal.W8}, #{seal.W9}, #{seal.W10}, #{seal.W11}, #{seal.Other}, 0, #{seal.File1})")
	void InsertSeal(@Param("seal") Seal seal);

	@Insert("Insert Into Workflow(WTID, Status, OrgID, UserID, DataID, Date, WIID) \n"
		+"Select 'Seal',0, OrgRole.OrgID, User.ID, #{dataid}, Now(), 0\n"
		+"From User Join UserRole On User.ID = UserRole.UserID And UserRole.isMain = 1\n"
		+"		Join OrgRole On OrgRole.ID = UserRole.OrgRoleID\n"
		+"Where User.LoginName = #{user}")
	void InsertSealWorkflow(@Param("dataid") int dataid, @Param("user") String user);

	@Insert("Insert Into WorkflowItem(WID, Title, UserID, Content, Date)\n"
		+"Select #{wid}, '部门负责人审批 ', UserRole.UserID, '', null\n"
		+"From OrgRole Join Role on OrgRole.RoleID = Role.ID And Role.Name = '部门负责人'\n"
		+"And OrgRole.OrgID = \n"
		+"(Select OrgRole.OrgID\n"
		+"From User Join UserRole On User.ID = UserRole.UserID And UserRole.isMain = 1\n"
		+"		Join OrgRole On OrgRole.ID = UserRole.OrgRoleID\n"
		+"Where User.LoginName = #{user})\n"
		+"	Join UserRole On OrgRole.ID = UserRole.OrgRoleID\n"
		+"limit 0, 1")
	void InsertSealW1(@Param("user") String user, @Param("wid") int wid);

	@Insert("Insert Into WorkflowItem(WID, Title, UserID, Content, Date)\n"
		+"Select #{wid}, '分公司总经理审批 ', UserRole.UserID, '', null\n"
		+"From OrgRole Join Role on OrgRole.RoleID = Role.ID And Role.Name = '分公司总经理'\n"
		+"And (OrgRole.OrgID = \n"
		+"(Select OrgRole.OrgID\n"
		+"From User Join UserRole On User.ID = UserRole.UserID And UserRole.isMain = 1\n"
		+"		Join OrgRole On OrgRole.ID = UserRole.OrgRoleID\n"
		+"Where User.LoginName = #{user})\n"
		+"	or OrgRole.OrgID =\n"
		+"(Select Org.PID\n"
		+"From User Join UserRole On User.ID = UserRole.UserID And UserRole.isMain = 1\n"
		+"		Join OrgRole On OrgRole.ID = UserRole.OrgRoleID\n"
		+"        Join Org On Org.ID = OrgRole.OrgID\n"
		+"Where User.LoginName = #{user})\n"
		+")\n"
		+"	Join UserRole On OrgRole.ID = UserRole.OrgRoleID\n"
		+"limit 0, 1")
	void InsertSealW2(@Param("user") String user, @Param("wid") int wid);

	@Insert("Insert Into WorkflowItem(WID, Title, UserID, Content, Date)\n"
		+"Select #{wid}, '业务条线审批人审批 ', UserRole.UserID, '', null\n"
		+"From Role Join OrgRole On Role.ID = OrgRole.RoleID\n"
		+"		Join UserRole On UserRole.OrgRoleID = OrgRole.ID\n"
		+"Where Role.Name = '业务条线审批人'\n"
		+"limit 0, 1")
	void InsertSealW3(@Param("wid") int wid);

	@Insert("Insert Into WorkflowItem(WID, Title, UserID, Content, Date)\n"
		+"Select #{wid}, '行政条线审批人审批 ', UserRole.UserID, '', null\n"
		+"From Role Join OrgRole On Role.ID = OrgRole.RoleID\n"
		+"		Join UserRole On UserRole.OrgRoleID = OrgRole.ID\n"
		+"Where Role.Name = '行政条线审批人'\n"
		+"limit 0, 1")
	void InsertSealW4(@Param("wid") int wid);

	@Insert("Insert Into WorkflowItem(WID, Title, UserID, Content, Date)\n"
		+"Select #{wid}, '总经理 ', UserRole.UserID, '', null\n"
		+"From Role Join OrgRole On Role.ID = OrgRole.RoleID\n"
		+"		Join UserRole On UserRole.OrgRoleID = OrgRole.ID\n"
		+"Where Role.Name = '总经理'\n"
		+"limit 0, 1")
	void InsertSealW5(@Param("wid") int wid);

	@Insert("Insert Into WorkflowItem(WID, Title, UserID, Content, Date)\n"
		+"Select #{wid}, '公章保管员审批 ', UserRole.UserID, '', null\n"
		+"From Role Join OrgRole On Role.ID = OrgRole.RoleID\n"
		+"		Join UserRole On UserRole.OrgRoleID = OrgRole.ID\n"
		+"Where Role.Name = '公章保管员'\n"
		+"limit 0, 1")
	void InsertSealW6(@Param("wid") int wid);

	@Update("Update Seal set WorkflowID = #{wid}\n"
		+"where ID = #{id}")
	void UpdateSealWorkflowID(@Param("id") int id, @Param("wid") int wid);

}
