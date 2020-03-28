package org.polariscode.SecuritySystem.model.Import;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;

@Component
public class BaselnfoExcle implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static BaselnfoExcle m_BaselnfoExcle;

	@PostConstruct 
	public void init(){
		m_BaselnfoExcle=this;
		m_BaselnfoExcle.dictionaryService=this.dictionaryService;
	}

	private String SName = "";
	//驻点名称
	public String getSName(){
		return this.SName;
	}
	public void setSName(String value){
		this.SName = value;
	}

	private String CName = "";
	//客户名称
	public String getCName(){
		return this.CName;
	}
	public void setCName(String value){
		this.CName = value;
	}

	private String COrgID = "";
	//所属部门
	public String getCOrgID(){
		return this.COrgID;
	}
	public void setCOrgID(String value){
		this.COrgID = value;
	}

	private String COrgID_Convert="";
	public String getCOrgID_Convert(){
		COrgID_Convert = m_BaselnfoExcle.dictionaryService.convertDictionary("OrgType", String.valueOf(COrgID));
		if(COrgID_Convert == null) COrgID_Convert = "";
		return COrgID_Convert;
	}
	public void setCOrgID_Convert(String value){
		this.COrgID_Convert = value;
	}

	private String CDistrict = "";
	//所在城市
	public String getCDistrict(){
		return this.CDistrict;
	}
	public void setCDistrict(String value){
		this.CDistrict = value;
	}

	private String CAddress = "";
	//驻点地址
	public String getCAddress(){
		return this.CAddress;
	}
	public void setCAddress(String value){
		this.CAddress = value;
	}

	private String CContacts = "";
	//联系人
	public String getCContacts(){
		return this.CContacts;
	}
	public void setCContacts(String value){
		this.CContacts = value;
	}

	private String CContactNumber = "";
	//联系电话
	public String getCContactNumber(){
		return this.CContactNumber;
	}
	public void setCContactNumber(String value){
		this.CContactNumber = value;
	}

	private String Cmanager = "";
	//项目经理
	public String getCmanager(){
		return this.Cmanager;
	}
	public void setCmanager(String value){
		this.Cmanager = value;
	}

	private String CType = "";
	//客户类型
	public String getCType(){
		return this.CType;
	}
	public void setCType(String value){
		this.CType = value;
	}

}
