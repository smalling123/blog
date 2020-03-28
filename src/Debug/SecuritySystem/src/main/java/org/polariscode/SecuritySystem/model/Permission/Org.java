package org.polariscode.SecuritySystem.model.Permission;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;
import java.util.List;
import java.util.ArrayList;
import org.polariscode.SecuritySystem.model.Permission.OrgRole;
import org.polariscode.SecuritySystem.model.Permission.Org;

//组织机构
@Component
public class Org implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static Org m_Org;

	@PostConstruct 
	public void init(){
		m_Org=this;
		m_Org.dictionaryService=this.dictionaryService;
	}

	private int ID = 0;
	public int getID(){
		return this.ID;
	}
	public void setID(int value){
		this.ID = value;
	}

	private int PID = 0;
	public int getPID(){
		return this.PID;
	}
	public void setPID(int value){
		this.PID = value;
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

	private int OrgType = 0;
	//机构类型
	public int getOrgType(){
		return this.OrgType;
	}
	public void setOrgType(int value){
		this.OrgType = value;
	}

	private String OrgType_Convert="";
	public String getOrgType_Convert(){
		OrgType_Convert = m_Org.dictionaryService.convertDictionary("OrgType", String.valueOf(OrgType));
		if(OrgType_Convert == null) OrgType_Convert = "";
		return OrgType_Convert;
	}
	public void setOrgType_Convert(String value){
		this.OrgType_Convert = value;
	}

	private List<OrgRole> Roles = new ArrayList<OrgRole>();
	//包含角色
	public List<OrgRole> getRoles(){
		return this.Roles;
	}
	public void setRoles(List<OrgRole> value){
		this.Roles = value;
	}

	private List<Org> Children = new ArrayList<Org>();
	//子部门
	public List<Org> getChildren(){
		return this.Children;
	}
	public void setChildren(List<Org> value){
		this.Children = value;
	}

}
