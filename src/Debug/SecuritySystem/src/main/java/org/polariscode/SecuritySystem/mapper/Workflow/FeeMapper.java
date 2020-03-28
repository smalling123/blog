package org.polariscode.SecuritySystem.mapper.Workflow;

import java.util.List;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import org.polariscode.SecuritySystem.model.Workflow.Fee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

public interface FeeMapper {
	//根据ID获取指定的印鉴申请实体
	@Select("Select *\n"
		+"From Fee Where ID = #{id}")
	Fee getFeeOne(@Param("id") int id);

	@Insert("Insert Into Workflow(WTID, Status, OrgID, UserID, DataID, Date, WIID) \n"
		+"Select 'Fee',0, OrgRole.OrgID, User.ID, #{dataid}, Now(), 0\n"
		+"From User Join UserRole On User.ID = UserRole.UserID And UserRole.isMain = 1\n"
		+"		Join OrgRole On OrgRole.ID = UserRole.OrgRoleID\n"
		+"Where User.LoginName = #{user}")
	void InsertFeeWorkflow(@Param("dataid") int dataid, @Param("user") String user);

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
	void InsertFeeW1(@Param("user") String user, @Param("wid") int wid);

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
	void InsertFeeW2(@Param("user") String user, @Param("wid") int wid);

	@Insert("Insert Into WorkflowItem(WID, Title, UserID, Content, Date)\n"
		+"Select #{wid}, '总经理 ', UserRole.UserID, '', null\n"
		+"From Role Join OrgRole On Role.ID = OrgRole.RoleID\n"
		+"		Join UserRole On UserRole.OrgRoleID = OrgRole.ID\n"
		+"Where Role.Name = '总经理'\n"
		+"limit 0, 1")
	void InsertFeeW5(@Param("wid") int wid);

	@Insert("Insert Into WorkflowItem(WID, Title, UserID, Content, Date)\n"
		+"Select #{wid}, '财务审批 ', UserRole.UserID, '', null\n"
		+"From Role Join OrgRole On Role.ID = OrgRole.RoleID\n"
		+"		Join UserRole On UserRole.OrgRoleID = OrgRole.ID\n"
		+"Where Role.Name = '财务'\n"
		+"limit 0, 1")
	void InsertFeeW6(@Param("wid") int wid);

	@Update("Update Fee set WorkflowID = #{wid}\n"
		+"where ID = #{id}")
	void UpdateFeeWorkflowID(@Param("id") int id, @Param("wid") int wid);

	@Insert("Insert Into Fee(OrgID, UserID, Date, Content, CompanyId, Type, Site, Amt, Company, AccountName, Account, WorkflowID, File1)\n"
		+" Values(#{fee.OrgID}, #{fee.UserID}, Now(), #{fee.Content}, #{fee.CompanyId},#{fee.Type}, #{fee.Site}, #{fee.Amt}, #{fee.Company}, #{fee.AccountName}, #{fee.Account}, #{fee.WorkflowID}, #{fee.File1})")
	void InsertFee(@Param("fee") Fee fee);

}
