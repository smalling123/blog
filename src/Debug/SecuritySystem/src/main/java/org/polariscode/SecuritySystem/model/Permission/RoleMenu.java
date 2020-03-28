package org.polariscode.SecuritySystem.model.Permission;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;

@Component
public class RoleMenu implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static RoleMenu m_RoleMenu;

	@PostConstruct 
	public void init(){
		m_RoleMenu=this;
		m_RoleMenu.dictionaryService=this.dictionaryService;
	}

	private int ID = 0;
	public int getID(){
		return this.ID;
	}
	public void setID(int value){
		this.ID = value;
	}

	private int RoleID = 0;
	public int getRoleID(){
		return this.RoleID;
	}
	public void setRoleID(int value){
		this.RoleID = value;
	}

	private int MenuID = 0;
	public int getMenuID(){
		return this.MenuID;
	}
	public void setMenuID(int value){
		this.MenuID = value;
	}

}
