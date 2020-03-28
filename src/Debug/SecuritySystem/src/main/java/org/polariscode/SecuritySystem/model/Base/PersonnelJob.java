package org.polariscode.SecuritySystem.model.Base;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;

//工作经历
@Component
public class PersonnelJob implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static PersonnelJob m_PersonnelJob;

	@PostConstruct 
	public void init(){
		m_PersonnelJob=this;
		m_PersonnelJob.dictionaryService=this.dictionaryService;
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

	private String Company = "";
	//工作单位
	public String getCompany(){
		return this.Company;
	}
	public void setCompany(String value){
		this.Company = value;
	}

	private String Job = "";
	//职务
	public String getJob(){
		return this.Job;
	}
	public void setJob(String value){
		this.Job = value;
	}

	private java.util.Date InDate = null;
	//开始日期
	public java.util.Date getInDate(){
		return this.InDate;
	}
	public void setInDate(java.util.Date value){
		this.InDate = value;
	}

	private java.util.Date OutDate = null;
	//结束日期
	public java.util.Date getOutDate(){
		return this.OutDate;
	}
	public void setOutDate(java.util.Date value){
		this.OutDate = value;
	}

	private String LinkMan = "";
	//联系人
	public String getLinkMan(){
		return this.LinkMan;
	}
	public void setLinkMan(String value){
		this.LinkMan = value;
	}

	private String LinkManPhone = "";
	//电话
	public String getLinkManPhone(){
		return this.LinkManPhone;
	}
	public void setLinkManPhone(String value){
		this.LinkManPhone = value;
	}

}
