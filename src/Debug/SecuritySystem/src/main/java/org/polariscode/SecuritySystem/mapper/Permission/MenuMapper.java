package org.polariscode.SecuritySystem.mapper.Permission;

import java.util.List;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import org.polariscode.SecuritySystem.model.Permission.Menu;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;

//菜单操作
public interface MenuMapper {
	//获取菜单清单
	@Select("Select ID, PID, Name, Name as Title, Icon, Openby, Url, FloatPrompt, TabType, Describes, Isdelete, Sequence\n"
		+"From Menu\n"
		+"Where Isdelete = 0\n"
		+"Order By PID, Sequence")
	List<Menu> m_getMenus();

	static List<Menu> getChild_getMenus(List<Menu> list, int pid){
		List<Menu> result = new ArrayList<Menu>();
		for(Menu item : list){
			if(item.getPID()==pid){
				result.add(item);
				List<Menu> items = getChild_getMenus(list, item.getID());
				for(Menu citem : items){
					item.getChildren().add(citem);
				}
			}
		}
		return result;
	}

	static List<Menu> getMenus(List<Menu> list){
		List<Menu> result = getChild_getMenus(list, 0);
		return result;
	}
	//根据ID获取菜单对象
	@Select("Select ID, PID, Name, Name as Title, Icon, Openby, Url, FloatPrompt, TabType, Describes, Isdelete, Sequence\n"
		+"From Menu\n"
		+"Where ID = #{id}")
	Menu getMenuById(@Param("id") int id);

	//获取所有菜单清单
	@Select("Select ID, PID, Name, Name as Title, Icon, Openby, Url, FloatPrompt, TabType, Describes, Isdelete, Sequence\n"
		+"From Menu\n"
		+"Order By PID, Sequence")
	List<Menu> m_getAllMenus();

	static List<Menu> getChild_getAllMenus(List<Menu> list, int pid){
		List<Menu> result = new ArrayList<Menu>();
		for(Menu item : list){
			if(item.getPID()==pid){
				result.add(item);
				List<Menu> items = getChild_getAllMenus(list, item.getID());
				for(Menu citem : items){
					item.getChildren().add(citem);
				}
			}
		}
		return result;
	}

	static List<Menu> getAllMenus(List<Menu> list){
		List<Menu> result = getChild_getAllMenus(list, 0);
		return result;
	}
	//获得角色菜单
	@Select("select distinct  m.*, m.Name as Title from User u  \n"
		+"join userrole ur on u.ID=ur.UserID\n"
		+"join orgrole orl on ur.OrgRoleID=orl.ID\n"
		+"join role r on orl.RoleID=r.ID\n"
		+"join rolemenu rm on rm.RoleID=r.ID\n"
		+"join menu m on rm.MenuID=m.ID\n"
		+"where u.LoginName=#{loginname}\n"
		+"order by Sequence ;")
	List<Menu> m_getUserMenus(@Param("loginname") String loginname);

	static List<Menu> getChild_getUserMenus(List<Menu> list, int pid){
		List<Menu> result = new ArrayList<Menu>();
		for(Menu item : list){
			if(item.getPID()==pid){
				result.add(item);
				List<Menu> items = getChild_getUserMenus(list, item.getID());
				for(Menu citem : items){
					item.getChildren().add(citem);
				}
			}
		}
		return result;
	}

	static List<Menu> getUserMenus(List<Menu> list){
		List<Menu> result = getChild_getUserMenus(list, 0);
		return result;
	}
	@Select("Select ID, PID, Name, Name as Title, Icon, Openby, Url, FloatPrompt, TabType, Describes, Isdelete, Sequence\n"
		+"From Menu\n"
		+"Where PID = #{pid}")
	List<Menu> getMenuByPID(@Param("pid") int pid);

	//添加菜单
	@Insert("INSERT INTO menu\n"
		+"(PID, Name, Icon, Openby, \n"
		+"Url, FloatPrompt, TabType, \n"
		+"Describes, Isdelete, Sequence) \n"
		+"VALUES (#{menu.PID}, #{menu.Name}, #{menu.Icon}, #{menu.Openby}, \n"
		+"#{menu.Url}, #{menu.FloatPrompt}, #{menu.TabType}, \n"
		+"#{menu.Describes}, #{menu.Isdelete}, #{menu.Sequence})")
	void InsertMenu(@Param("menu") Menu menu);

	//修改菜单
	@Update("UPDATE menu \n"
		+"SET PID = #{menu.PID}, Name = #{menu.Name}, Icon = #{menu.Icon}, \n"
		+"Openby = #{menu.Openby}, Url = #{menu.Url}, FloatPrompt = #{menu.FloatPrompt}, \n"
		+"TabType = #{menu.TabType}, Describes = #{menu.Describes}, Isdelete = #{menu.Isdelete}, \n"
		+"Sequence = #{menu.Sequence} \n"
		+"WHERE ID = #{menu.ID}")
	void UpdateMenu(@Param("menu") Menu menu);

	//删除菜单
	@Delete("delete from Menu\n"
		+"      where Id=#{id}")
	void DeleteMenu(@Param("id") int id);

	//删除子菜单
	@Delete("delete from Menu\n"
		+"      where PID=#{pid}")
	void DeleteMenuByPID(@Param("pid") int pid);

}
