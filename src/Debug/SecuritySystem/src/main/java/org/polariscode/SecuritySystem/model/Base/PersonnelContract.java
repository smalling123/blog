package org.polariscode.SecuritySystem.model.Base;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;

@Component
public class PersonnelContract implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static PersonnelContract m_PersonnelContract;

	@PostConstruct 
	public void init(){
		m_PersonnelContract=this;
		m_PersonnelContract.dictionaryService=this.dictionaryService;
	}

	private int ID = 0;
	public int getID(){
		return this.ID;
	}
	public void setID(int value){
		this.ID = value;
	}

	private int PersonnelID = 0;
	public int getPersonnelID(){
		return this.PersonnelID;
	}
	public void setPersonnelID(int value){
		this.PersonnelID = value;
	}

	private String PersonnelID_Convert="";
	public String getPersonnelID_Convert(){
		PersonnelID_Convert = m_PersonnelContract.dictionaryService.convertDictionary("Personnel", String.valueOf(PersonnelID));
		if(PersonnelID_Convert == null) PersonnelID_Convert = "";
		return PersonnelID_Convert;
	}
	public void setPersonnelID_Convert(String value){
		this.PersonnelID_Convert = value;
	}

	private int Type = 0;
	//合同类型
	public int getType(){
		return this.Type;
	}
	public void setType(int value){
		this.Type = value;
	}

	private String Type_Convert="";
	public String getType_Convert(){
		switch(String.valueOf(Type)) {
		case "1":
			return "一年";
		case "2":
			return "二年";
		case "3":
			return "三年";
		case "4":
			return "四年";
		case "5":
			return "五年";
		case "99":
			return "无固定期限";
		}
		return Type_Convert;
	}
	public void setType_Convert(String value){
		this.Type_Convert = value;
	}

	private java.util.Date BeginDate = null;
	//开始日期
	public java.util.Date getBeginDate(){
		return this.BeginDate;
	}
	public void setBeginDate(java.util.Date value){
		this.BeginDate = value;
	}

	private java.util.Date EndDate = null;
	//结束日期
	public java.util.Date getEndDate(){
		return this.EndDate;
	}
	public void setEndDate(java.util.Date value){
		this.EndDate = value;
	}

	private int CompanyId = 0;
	//签约单位
	public int getCompanyId(){
		return this.CompanyId;
	}
	public void setCompanyId(int value){
		this.CompanyId = value;
	}

	private String CompanyId_Convert="";
	public String getCompanyId_Convert(){
		CompanyId_Convert = m_PersonnelContract.dictionaryService.convertDictionary("Company", String.valueOf(CompanyId));
		if(CompanyId_Convert == null) CompanyId_Convert = "";
		return CompanyId_Convert;
	}
	public void setCompanyId_Convert(String value){
		this.CompanyId_Convert = value;
	}

}
