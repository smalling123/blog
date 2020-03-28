package org.polariscode.SecuritySystem.mapper.Permission;

import java.util.List;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import org.polariscode.SecuritySystem.model.Permission.User;
import org.polariscode.SecuritySystem.model.Table;
import org.polariscode.SecuritySystem.model.Permission.OrgRole;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;

//用户信息
public interface UserMapper {
	//根据LoginName获取用户对象
	@Select("Select User.ID,  User.LoginName, User.Name, User.Password, User.Phone, User.Gender, User.Email, User.QQ, User.Wechat, User.Address, User.Birthday, User.Describes, ifnull(OrgRole.OrgID,0) As OrgID, ifnull(Org.Name, '') As OrgName, User.Status\n"
		+"From User Left Join UserRole On User.ID = UserRole.UserID And UserRole.isMain = 1\n"
		+"		Left Join OrgRole On OrgRole.ID = UserRole.OrgRoleID \n"
		+"		Left Join Org On Org.ID = OrgRole.OrgID\n"
		+"Where LoginName = #{loginname} And Status = 0")
	User getUserOne(@Param("loginname") String loginname);

	//获取所有用户清单
	@Select("Select ID,  LoginName, Name, '' as Password, Phone, Gender, Email, QQ, Wechat, Address, Birthday, Describes, Status\n"
		+"From User\n"
		+"where LoginName like '%${loginName}%' and Name like '%${name}%'\n"
		+"Order By convert(Name using gbk) collate gbk_chinese_ci\n"
		+"limit #{startIndex}, #{rowCount}")
	List<User> getAllUsers(@Param("startIndex") int startIndex, @Param("rowCount") int rowCount, @Param("loginName") String loginName, @Param("name") String name);

	@Select("Select Count(1) As Count From User\n"
		+"where LoginName like '%${loginName}%' and Name like '%${name}%'")
	Table getUsersCount(@Param("loginName") String loginName, @Param("name") String name);

	//根据ID获取用户对旬
	@Select("Select ID,  LoginName, Name, '' as Password, Phone, Gender, Email, QQ, Wechat, Address, Birthday, Describes, Status\n"
		+"From User\n"
		+"Where ID = #{id}")
	User getUserById(@Param("id") int id);

	//获取用户拥有的角色清单
	@Select("Select OrgRole.ID As OrgRoleID, Org.ID As OrgID, Org.Name As OrgName, Role.ID As RoleID, Role.Name As RoleName\n"
		+"From User Join UserRole on User.ID = UserRole.UserID\n"
		+"		Join OrgRole on UserRole.OrgRoleID = OrgRole.ID\n"
		+"		Join Org on Org.ID = OrgRole.OrgID\n"
		+"		Join Role on Role.ID = OrgRole.RoleID\n"
		+"Where User.ID = #{id}\n"
		+"Order By IsMain desc")
	List<OrgRole> getUserRoles(@Param("id") int id);

	@Insert("Insert Into User(LoginName, Name, Password, Phone, Gender, Email, QQ, Wechat, Address, Birthday, Describes, Status)\n"
		+"Values(#{user.LoginName}, #{user.Name}, #{user.Password}, #{user.Phone}, #{user.Gender}, #{user.Email}, #{user.QQ}, #{user.Wechat}, #{user.Address}, #{user.Birthday}, #{user.Describes}, #{user.Status})")
	void InsertUser(@Param("user") User user);

	@Update("<script>Update User set LoginName  = #{user.LoginName}  , \n"
		+"Name = #{user.Name}  ,\n"
		+"Phone = #{user.Phone}  , \n"
		+"Gender = #{user.Gender}  , \n"
		+"Email = #{user.Email}  , \n"
		+"QQ = #{user.QQ}  , \n"
		+"Wechat = #{user.Wechat}  , \n"
		+"Address = #{user.Address}  , \n"
		+"\n"
		+"<choose>\n"
		+"<when test='user.getBirthday() == \"\"'></when>\n"
		+"<otherwise>Birthday = #{user.Birthday} ,</otherwise>\n"
		+"</choose>\n"
		+" \n"
		+"Describes = #{user.Describes}  , \n"
		+"Status = #{user.Status}\n"
		+"Where ID = #{user.ID}</script>")
	void UpdateUser(@Param("user") User user);

	@Insert("Insert Into UserRole(UserID, OrgRoleID)\n"
		+"Values( #{userid}, #{orgroleid} )")
	void InsertUserRole(@Param("userid") int userid, @Param("orgroleid") int orgroleid);

	@Delete("Delete From UserRole Where UserID = #{userid} And OrgRoleID = #{orgroleid}")
	void DeleteUserRole(@Param("userid") int userid, @Param("orgroleid") int orgroleid);

	//为用户设置主岗位，更新第一条记录为主岗
	@Update("Update UserRole Set IsMain = 0 Where UserID = #{userid};\n"
		+"Update UserRole Inner Join (Select Min(T1.ID) As ID From UserRole As T1 Where T1.UserID = #{userid}) T1\n"
		+"on UserRole.ID = T1.ID\n"
		+"Set UserRole.IsMain = 1")
	void UpdateUserRoleIsMain(@Param("userid") int userid);

	//根据账号查看是否存在用户
	@Select("select count(1) Count from User\n"
		+"where LoginName=#{name}")
	Table getCountByLoginName(@Param("name") String name);

	//获取员工ID
	@Select("select ID from User\n"
		+"where LoginName=#{name}")
	Table getUserId(@Param("name") String name);

	//根据账号获取ID
	@Select("select ID from user where LoginName=#{account}")
	Table getUIDByAccount(@Param("account") String account);

	//根据账号密码查询数据是否存在
	@Select("select Count(*) Count from user where LoginName=#{account} and Password=#{password}")
	Table getCountByAccountPwd(@Param("account") String account, @Param("password") String password);

	//修改密码
	@Update("Update User set \n"
		+"Password = #{password}\n"
		+"Where ID = #{id}")
	void UpdatePassword(@Param("id") int id, @Param("password") String password);

	//根据账号查询账户信息
	@Select("select * from User where LoginName=#{account}")
	User getUserByAccount(@Param("account") String account);

}
