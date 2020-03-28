package org.polariscode.SecuritySystem.mapper.ApplyFor;

import java.util.List;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import org.polariscode.SecuritySystem.model.ApplyFor.ToDoList;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.polariscode.SecuritySystem.model.Table;

//代办表操作
public interface DBToDoList {
	//查询代办表
	@Select("select * from ToDoList\n"
		+"limit #{startIndex}, #{rowCount}")
	List<ToDoList> getAllToDoList(@Param("startIndex") int startIndex, @Param("rowCount") int rowCount);

	//根据ID查询待办
	@Select("select * from ToDoList\n"
		+"where Id=#{id}")
	List<ToDoList> getToDoListById(@Param("id") int id);

	//添加待办
	@Insert("INSERT INTO todolist \n"
		+"( OwnerID, OwnerEn, \n"
		+"OwnerCn, CreatorID, CreatorEn, \n"
		+"CreatorCn, ApplicantID, ApplicantEn, \n"
		+"ApplicantCn, Title, ApplicationNo, \n"
		+"ProcName, `Status`, CreatedDate, ActivityName) \n"
		+"VALUES (#{toList.OwnerID}, #{toList.OwnerEn}, \n"
		+"#{toList.OwnerCn}, #{toList.CreatorID}, #{toList.CreatorEn}, \n"
		+"#{toList.CreatorCn},#{toList.ApplicantID}, #{toList.ApplicantEn}, \n"
		+"#{toList.ApplicantCn},#{toList.Title}, #{toList.ApplicationNo}, \n"
		+"#{toList.ProcName}, #{toList.Status}, Now(), #{toList.ActivityName})")
	void InsertToDoList(@Param("toList") ToDoList toList);

	//修改待办状态
	@Update("UPDATE todolist \n"
		+"SET  `Status` = 1, ModifiedDate=Now()\n"
		+"WHERE ActivityName =#{activity}  and ApplicationNo = #{id}")
	void UpdateToDoListStatus(@Param("activity") String activity, @Param("id") int id);

	//根据Account查询待办
	@Select("select * from\n"
		+"(select  tl.* from (\n"
		+" Select OrgRole.ID As OrgRoleID, Org.ID As OrgID, Org.Name As OrgName, Role.ID As RoleID, Role.Name As RoleName\n"
		+"From User Join UserRole on User.ID = UserRole.UserID\n"
		+"		Join OrgRole on UserRole.OrgRoleID = OrgRole.ID\n"
		+"		Join Org on Org.ID = OrgRole.OrgID\n"
		+"		Join Role on Role.ID = OrgRole.RoleID where User.LoginName=#{account}) r \n"
		+" join ProcessNode pn on r.RoleName=pn.ProcessRole \n"
		+" join employeeapplication ell on ell.`Status`=pn.ProcessNo \n"
		+" join todolist tl on ell.Id=tl.ApplicationNo and pn.ProcessNode=tl.ActivityName\n"
		+" order by tl.Id desc\n"
		+" ) tls\n"
		+"limit #{startIndex}, #{rowCount}")
	List<ToDoList> getToDoListByAccount(@Param("startIndex") int startIndex, @Param("rowCount") int rowCount, @Param("account") String account);

	//根据账号获取条数
	@Select("<script>select Count(*) Count from\n"
		+"(select  tl.* from (\n"
		+" Select OrgRole.ID As OrgRoleID, Org.ID As OrgID, Org.Name As OrgName, Role.ID As RoleID, Role.Name As RoleName\n"
		+"From User Join UserRole on User.ID = UserRole.UserID\n"
		+"		Join OrgRole on UserRole.OrgRoleID = OrgRole.ID\n"
		+"		Join Org on Org.ID = OrgRole.OrgID\n"
		+"		Join Role on Role.ID = OrgRole.RoleID where User.LoginName=#{account}) r \n"
		+" join ProcessNode pn on r.RoleName=pn.ProcessRole \n"
		+" join employeeapplication ell on ell.`Status`=pn.ProcessNo \n"
		+" join todolist tl on ell.Id=tl.ApplicationNo and pn.ProcessNode=tl.ActivityName\n"
		+" order by tl.Id desc\n"
		+" ) tls\n"
		+" where\n"
		+" ApplicantCn like &apos;%${applicantCn}%&apos;\n"
		+" and CreatorCn like &apos;%${creatorCn}%&apos;\n"
		+" \n"
		+"<choose>\n"
		+"<when test='begincreatedDate == \"\"'></when>\n"
		+"<otherwise>and CreatedDate&gt;#{begincreatedDate}</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+" \n"
		+"<choose>\n"
		+"<when test='endcreatedDate == \"\"'></when>\n"
		+"<otherwise>and CreatedDate&lt;#{endcreatedDate}</otherwise>\n"
		+"</choose>\n"
		+"</script>")
	Table getCountByAccount(@Param("account") String account, @Param("applicantCn") String applicantCn, @Param("creatorCn") String creatorCn, @Param("begincreatedDate") String begincreatedDate, @Param("endcreatedDate") String endcreatedDate);

	//查询所有的代办
	@Select("<script>select * from\n"
		+"(select  tl.* from (\n"
		+" Select OrgRole.ID As OrgRoleID, Org.ID As OrgID, Org.Name As OrgName, Role.ID As RoleID, Role.Name As RoleName\n"
		+"From User Join UserRole on User.ID = UserRole.UserID\n"
		+"		Join OrgRole on UserRole.OrgRoleID = OrgRole.ID\n"
		+"		Join Org on Org.ID = OrgRole.OrgID\n"
		+"		Join Role on Role.ID = OrgRole.RoleID where User.LoginName=#{account}) r \n"
		+" join ProcessNode pn on r.RoleName=pn.ProcessRole \n"
		+" join employeeapplication ell on ell.`Status`=pn.ProcessNo \n"
		+" join todolist tl on ell.Id=tl.ApplicationNo and pn.ProcessNode=tl.ActivityName\n"
		+" order by tl.Id desc\n"
		+" ) tls\n"
		+" where\n"
		+" ApplicantCn like &apos;%${applicantCn}%&apos;\n"
		+" and CreatorCn like &apos;%${creatorCn}%&apos;\n"
		+" \n"
		+"<choose>\n"
		+"<when test='begincreatedDate == \"\"'></when>\n"
		+"<otherwise>and CreatedDate&gt;#{begincreatedDate}</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+" \n"
		+"<choose>\n"
		+"<when test='endcreatedDate == \"\"'></when>\n"
		+"<otherwise>and CreatedDate&lt;#{endcreatedDate}</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+"limit #{startIndex}, #{rowCount}</script>")
	List<ToDoList> getToDoListDetails(@Param("account") String account, @Param("applicantCn") String applicantCn, @Param("creatorCn") String creatorCn, @Param("begincreatedDate") String begincreatedDate, @Param("endcreatedDate") String endcreatedDate, @Param("startIndex") int startIndex, @Param("rowCount") int rowCount);

}
