package org.polariscode.SecuritySystem.model.Permission;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;

//组织机构关联的角色
@Component
public class OrgRole implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static OrgRole m_OrgRole;

	@PostConstruct 
	public void init(){
		m_OrgRole=this;
		m_OrgRole.dictionaryService=this.dictionaryService;
	}

	private int OrgRoleID = 0;
	public int getOrgRoleID(){
		return this.OrgRoleID;
	}
	public void setOrgRoleID(int value){
		this.OrgRoleID = value;
	}

	private int OrgID = 0;
	//组织机构ID
	public int getOrgID(){
		return this.OrgID;
	}
	public void setOrgID(int value){
		this.OrgID = value;
	}

	private String OrgName = "";
	//组织机构名称
	public String getOrgName(){
		return this.OrgName;
	}
	public void setOrgName(String value){
		this.OrgName = value;
	}

	private int RoleID = 0;
	//角色ID
	public int getRoleID(){
		return this.RoleID;
	}
	public void setRoleID(int value){
		this.RoleID = value;
	}

	private String RoleName = "";
	//角色名称
	public String getRoleName(){
		return this.RoleName;
	}
	public void setRoleName(String value){
		this.RoleName = value;
	}

}
