package org.polariscode.SecuritySystem.mapper.Workflow;

import java.util.List;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import org.polariscode.SecuritySystem.model.Workflow.Workflow;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Insert;
import org.polariscode.SecuritySystem.model.Workflow.WorkflowItem;
import org.polariscode.SecuritySystem.model.Workflow.WorkflowTask;
import org.polariscode.SecuritySystem.model.Table;

public interface WorkflowMapper {
	//获取所有行为办任务列表
	@Select("Select W.ID, W.WTID, W.Status, W.OrgID, W.UserID, W.Date, W.WIID, W.DataID\n"
		+"From Workflow  W\n"
		+"Where Status = 0 And WIID = #{userid}")
	List<Workflow> getWorkflowByUserID(@Param("userid") int userid);

	@Update("Update Workflow Set Status = #{status}, WIID=#{wiid}\n"
		+"Where ID = #{id}")
	void UpdateWorkflow(@Param("id") int id, @Param("status") int status, @Param("wiid") int wiid);

	@Insert("Insert into Workflow(WTID, Status, OrgID, UserID, Date, DataID)\n"
		+"Values(#{WTID}, #{Status}, #{OrgID}, #{UserID}, Now(), #{DataID})")
	void InsertWorkflow(@Param("workflow") Workflow workflow);

	//获取指定流程的节点
	@Select("Select WI.ID, WI.WID, WI.Title, WI.UserID, User.Name As UserName, WI.Content, WI.Status, WI.Date\n"
		+"From WorkflowItem WI Left Join User On WI.UserID = User.ID\n"
		+"Where WID = #{id}")
	List<WorkflowItem> getWorkflowItems(@Param("id") int id);

	@Insert("Insert Into WorkflowItem(WID, Title, UserID, Content)\n"
		+"Values(#{item.WID}, #{item.Title}, #{item.UserID}, #{item.Content})")
	void InsertWorkflowItem(@Param("item") WorkflowItem item);

	@Update("Update WorkflowItem set Content = #{content}, Status = #{status}, Date = Now()\n"
		+"Where ID = #{id}")
	void UpdateWorkflowItem(@Param("content") String content, @Param("status") int status, @Param("id") int id);

	//获取我的待审批记录
	@Select("Select WI.ID, W.ID As WID, WT.Name, U.Name As UserName, W.Date, WI.Status, WT.WebEditUrl, WT.WebViewUrl, WT.AppEditUrl, WT.AppViewUrl, W.DataID\n"
		+"From User Join WorkflowItem WI On User.ID = WI.UserID\n"
		+"		Join Workflow W On W.ID = WI.WID And W.WIID = WI.ID And W.Status = 0\n"
		+"        Join WorkflowTemplate WT on W.WTID = WT.ID\n"
		+"        Join User U On U.ID = W.UserID\n"
		+"Where User.LoginName = #{user}")
	List<WorkflowTask> getMyTask(@Param("user") String user);

	//获取流程下一节点的ID
	@Select("Select ifnull(Min(ID),0) As ID\n"
		+"From WorkflowItem\n"
		+"Where WID = #{wid} And ID > #{wiid}")
	Table getNextItem(@Param("wid") int wid, @Param("wiid") int wiid);

	//获取流转记录
	@Select("Select WI.ID, WI.WID, WI.Title, WI.UserID, User.Name As UserName, WI.Content, WI.Status, WI.Date\n"
		+"From WorkflowItem WI Left Join User On WI.UserID = User.ID\n"
		+"Where WID = #{id}")
	List<WorkflowItem> getWorkflowItemsByCheck(@Param("id") int id);

	//获取我的申请记录
	@Select("Select 0 As ID, W.ID As WID, WT.Name, User.Name As UserName, W.Date, WT.WebEditUrl, WT.WebViewUrl, WT.AppEditUrl, WT.AppViewUrl, W.DataID, W.Status As WStatus\n"
		+"From User Join Workflow W On W.UserID = User.ID\n"
		+"        Join WorkflowTemplate WT on W.WTID = WT.ID\n"
		+"Where User.LoginName = #{user} And (W.Status =0 || TO_DAYS(NOW()) - TO_DAYS(W.Date) <= 30)\n"
		+"Order By W.ID Desc")
	List<WorkflowTask> getMyWorkflow(@Param("user") String user);

	@Select("Select WI.ID, W.ID As WID, WT.Name, U.Name As UserName, W.Date, WI.Status, WT.WebEditUrl, WT.WebViewUrl, WT.AppEditUrl, WT.AppViewUrl, W.DataID\n"
		+"From User u1 Join WorkflowItem WI On u1.ID = WI.UserID\n"
		+"		 Join Workflow W On W.ID = WI.WID And WI.Status != 0\n"
		+"        Join WorkflowTemplate WT on W.WTID = WT.ID\n"
		+"        Join User U On U.ID = W.UserID\n"
		+"Where u1.LoginName = #{user} \n"
		+"And (W.Status =0 || TO_DAYS(NOW()) - TO_DAYS(W.Date) <= 30)\n"
		+"Order By W.ID Desc")
	List<WorkflowTask> getMyOKTask(@Param("user") String user);

}
