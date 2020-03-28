package org.polariscode.SecuritySystem.mapper.Workflow;

import java.util.List;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import org.polariscode.SecuritySystem.model.Workflow.Expenses;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.polariscode.SecuritySystem.model.Workflow.ExpensesItems;

public interface ExpensesMapper {
	//根据ID获取指定的印鉴申请实体
	@Select("Select *\n"
		+"From Expenses Where ID = #{id}")
	Expenses getExpensesOne(@Param("id") int id);

	@Insert("Insert Into Workflow(WTID, Status, OrgID, UserID, DataID, Date, WIID) \n"
		+"Select 'Expenses',0, OrgRole.OrgID, User.ID, #{dataid}, Now(), 0\n"
		+"From User Join UserRole On User.ID = UserRole.UserID And UserRole.isMain = 1\n"
		+"		Join OrgRole On OrgRole.ID = UserRole.OrgRoleID\n"
		+"Where User.LoginName = #{user}")
	void InsertExpensesWorkflow(@Param("dataid") int dataid, @Param("user") String user);

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
	void InsertExpensesW1(@Param("user") String user, @Param("wid") int wid);

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
	void InsertExpensesW2(@Param("user") String user, @Param("wid") int wid);

	@Insert("Insert Into WorkflowItem(WID, Title, UserID, Content, Date)\n"
		+"Select #{wid}, '总经理 ', UserRole.UserID, '', null\n"
		+"From Role Join OrgRole On Role.ID = OrgRole.RoleID\n"
		+"		Join UserRole On UserRole.OrgRoleID = OrgRole.ID\n"
		+"Where Role.Name = '总经理'\n"
		+"limit 0, 1")
	void InsertExpensesW5(@Param("wid") int wid);

	@Insert("Insert Into WorkflowItem(WID, Title, UserID, Content, Date)\n"
		+"Select #{wid}, '财务审批 ', UserRole.UserID, '', null\n"
		+"From Role Join OrgRole On Role.ID = OrgRole.RoleID\n"
		+"		Join UserRole On UserRole.OrgRoleID = OrgRole.ID\n"
		+"Where Role.Name = '财务'\n"
		+"limit 0, 1")
	void InsertExpensesW6(@Param("wid") int wid);

	@Update("Update Expenses set WorkflowID = #{wid}\n"
		+"where ID = #{id}")
	void UpdateExpensesWorkflowID(@Param("id") int id, @Param("wid") int wid);

	@Insert("Insert Into Expenses(OrgID, UserID, ExUserID, Date, Content, Site, Amt, WorkflowID, File1)\n"
		+" Values(#{expenses.OrgID}, #{expenses.UserID}, #{expenses.ExUserID}, Now(), #{expenses.Content}, #{expenses.Site}, #{expenses.Amt}, #{expenses.WorkflowID}, #{expenses.File1})")
	void InsertExpenses(@Param("expenses") Expenses expenses);

	@Select("Select * From ExpensesItems Where ExpensesId = #{id}")
	List<ExpensesItems> getExpensesItems(@Param("id") int id);

	@Insert("<script>Insert Into ExpensesItems(ExpensesId, Type, Content, Amt) Values\n"
		+"<foreach collection='expensesitems' item='c' index='index' separator=','>\n"
		+"(#{id}, #{c.Type}, #{c.Content}, #{c.Amt})\n"
		+"</foreach>\n"
		+"</script>")
	void insertExpensesItems(@Param("expensesitems") List<ExpensesItems> expensesitems, @Param("id") int id);

	@Update("Update expenses \n"
		+"join (Select expensesId, Sum(Amt) As Amt From expensesitems Where expensesId = #{id} GROUP BY expensesId) items\n"
		+"on expenses.Id = items.ExpensesId\n"
		+"set expenses.Amt = items.Amt\n"
		+"Where expenses.Id = #{id}")
	void updateExpenses(@Param("id") int id);

}
