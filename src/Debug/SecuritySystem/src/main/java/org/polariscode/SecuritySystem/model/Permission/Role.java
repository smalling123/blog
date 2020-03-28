package org.polariscode.SecuritySystem.model.Permission;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;
import java.util.List;
import java.util.ArrayList;
import org.polariscode.SecuritySystem.model.Permission.RoleMenu;

//角色
@Component
public class Role implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static Role m_Role;

	@PostConstruct 
	public void init(){
		m_Role=this;
		m_Role.dictionaryService=this.dictionaryService;
	}

	private int ID = 0;
	public int getID(){
		return this.ID;
	}
	public void setID(int value){
		this.ID = value;
	}

	private String Name = "";
	//名称
	public String getName(){
		return this.Name;
	}
	public void setName(String value){
		this.Name = value;
	}

	private String Describes = "";
	//描述
	public String getDescribes(){
		return this.Describes;
	}
	public void setDescribes(String value){
		this.Describes = value;
	}

	private boolean Isdelete = false;
	//是否停用
	public boolean getIsdelete(){
		return this.Isdelete;
	}
	public void setIsdelete(boolean value){
		this.Isdelete = value;
	}

	private List<RoleMenu> Menus = new ArrayList<RoleMenu>();
	public List<RoleMenu> getMenus(){
		return this.Menus;
	}
	public void setMenus(List<RoleMenu> value){
		this.Menus = value;
	}

}
