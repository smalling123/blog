package org.polariscode.SecuritySystem.mapper.Permission;

import java.util.List;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import org.polariscode.SecuritySystem.model.Permission.Role;
import org.polariscode.SecuritySystem.model.Table;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import org.polariscode.SecuritySystem.model.Permission.RoleMenu;

public interface RoleMapper {
	//获取角色清单(不包含已停用的记录)
	@Select("Select ID, Name, Describes, Isdelete \n"
		+"From Role\n"
		+"Where Isdelete = 0\n"
		+"Order By convert(Name using gbk) collate gbk_chinese_ci")
	List<Role> getRoles();

	@Select("Select Count(1) As Count From Role")
	Table getRolesCount();

	//根据ID获取角色对象
	@Select("Select ID, Name, Describes, Isdelete From Role Where ID = #{id}")
	Role getRoleById(@Param("id") int id);

	//获取所有角色浦单(包含已停用的记录)
	@Select("Select ID, Name, Describes, Isdelete \n"
		+"From Role\n"
		+"Order By convert(Name using gbk) collate gbk_chinese_ci \n"
		+"limit #{startIndex} ,  #{rowCount}")
	List<Role> getAllRoles(@Param("startIndex") int startIndex, @Param("rowCount") int rowCount);

	@Insert("Insert Into Role(Name, Describes, Isdelete)\n"
		+"Values(#{role.Name}, #{role.Describes}, #{role.Isdelete})")
	void InsertRole(@Param("role") Role role);

	@Update("Update Role Set Name = #{role.Name}, Describes = #{role.Describes}, Isdelete = #{role.Isdelete}\n"
		+"Where ID = #{role.ID}")
	void UpdateRole(@Param("role") Role role);

	@Delete("Delete From Role Where ID = #{id}")
	void DeleteRole(@Param("id") int id);

	@Select("Select * From RoleMenu Where RoleID = #{roleid}")
	List<RoleMenu> getRoleMenu(@Param("roleid") int roleid);

	@Delete("Delete From RoleMenu Where RoleID = #{roleid}")
	void DeleteRoleMenu(@Param("roleid") int roleid);

	@Insert("<script>Insert Into RoleMenu(RoleID, MenuID) Values\n"
		+"<foreach collection='rolemenus' item='c' index='index' separator=','>\n"
		+"(#{roleid}, #{c.MenuID})\n"
		+"</foreach>\n"
		+"</script>")
	void InsertRoleMenu(@Param("rolemenus") List<RoleMenu> rolemenus, @Param("roleid") int roleid);

}
