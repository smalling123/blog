package org.polariscode.SecuritySystem.mapper.Permission;

import java.util.List;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import org.polariscode.SecuritySystem.model.Permission.Org;
import org.polariscode.SecuritySystem.model.Permission.OrgRole;
import org.polariscode.SecuritySystem.model.Permission.OrgType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;

public interface OrgMapper {
	//获取组织机构清单(不包含已停用记录)
	@Select("Select ID, PID, Name, Describes, Isdelete, OrgType\n"
		+"From Org\n"
		+"Where Isdelete = 0\n"
		+"Order By PID, convert(Name using gbk) collate gbk_chinese_ci")
	List<Org> m_getOrgs();

	static List<Org> getChild_getOrgs(List<Org> list, int pid){
		List<Org> result = new ArrayList<Org>();
		for(Org item : list){
			if(item.getPID()==pid){
				result.add(item);
				List<Org> items = getChild_getOrgs(list, item.getID());
				for(Org citem : items){
					item.getChildren().add(citem);
				}
			}
		}
		return result;
	}

	static List<Org> getOrgs(List<Org> list){
		List<Org> result = getChild_getOrgs(list, 0);
		return result;
	}
	//按层PID获取组织机构清单(包含已停用记录)
	@Select("Select Org.ID, Org.PID, Org.Name, Org.Describes, Org.Isdelete, Org.OrgType\n"
		+"From Org \n"
		+"Where PID = #{pid} /*And Isdelete = 0*/\n"
		+"Order By convert(Name using gbk) collate gbk_chinese_ci")
	List<Org> getOrgsByPid(@Param("pid") int pid);

	//根据ID获取组织机构对象
	@Select("Select ID, PID, Name, Describes, Isdelete, OrgType\n"
		+"From Org\n"
		+"Where ID = #{id}")
	Org getOrgById(@Param("id") int id);

	//获取组织机构包含的角色清单
	@Select("Select  OrgRole.ID as OrgRoleID, Org.ID As OrgID, Org.Name As OrgName, Role.ID As RoleID, Role.Name As RoleName\n"
		+"From Org Join OrgRole on Org.ID = OrgRole.OrgID\n"
		+"		Join Role On Role.ID = OrgRole.RoleID And Role.Isdelete = 0\n"
		+"Where Org.ID = #{id}")
	List<OrgRole> getOrgRoles(@Param("id") int id);

	@Select("Select ID, Name From OrgType")
	List<OrgType> getOrgTypes();

	@Insert("Insert Into Org(PID, Name, Describes, Isdelete, OrgType)\n"
		+"Values( #{org.PID}, #{org.Name}, #{org.Describes}, #{org.Isdelete}, #{org.OrgType} )")
	void InsertOrg(@Param("org") Org org);

	@Update("Update Org Set PID = #{org.PID}, Name=#{org.Name}, Describes=#{org.Describes}, Isdelete=#{org.Isdelete}, OrgType=#{org.OrgType}\n"
		+"Where ID = #{org.ID}")
	void UpdateOrg(@Param("org") Org org);

	//删除组织机构已分配的角色
	@Delete("Delete From OrgRole Where OrgID = #{orgid} And  RoleID = #{roleid}")
	void DeleteOrgRole(@Param("orgid") int orgid, @Param("roleid") int roleid);

	//为组织机构分配新的角色
	@Insert("Insert Into OrgRole(OrgID, RoleID)\n"
		+"Values(#{orgid}, #{roleid})")
	void InsertOrgRole(@Param("orgid") int orgid, @Param("roleid") int roleid);

	//删除用户绑定的角色
	@Delete("Delete From UserRole Where OrgRoleID in (Select ID From OrgRole Where OrgID = #{orgid} And RoleID=#{roleid})")
	void DeleteUserRole(@Param("orgid") int orgid, @Param("roleid") int roleid);

	@Select("Select OrgRole.ID, CONCAT('[',Org.Name,'] ', Role.Name) As Name \n"
		+"From OrgRole Join Org On OrgRole.OrgID = Org.ID\n"
		+"				Join Role On OrgRole.RoleID = Role.ID\n"
		+"Order By Org.ID")
	@Results({
		@Result(property = "OrgRoleID", column = "ID"),
		@Result(property = "RoleName", column = "Name")
	})
	List<OrgRole> getAllOrgRoles();

}
