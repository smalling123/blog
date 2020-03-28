package org.polariscode.SecuritySystem.model.Workflow;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;

//流程记录
@Component
public class Workflow implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static Workflow m_Workflow;

	@PostConstruct 
	public void init(){
		m_Workflow=this;
		m_Workflow.dictionaryService=this.dictionaryService;
	}

	private int ID = 0;
	public int getID(){
		return this.ID;
	}
	public void setID(int value){
		this.ID = value;
	}

	private String WTID = "";
	public String getWTID(){
		return this.WTID;
	}
	public void setWTID(String value){
		this.WTID = value;
	}

	private int Status = 0;
	public int getStatus(){
		return this.Status;
	}
	public void setStatus(int value){
		this.Status = value;
	}

	private int OrgID = 0;
	public int getOrgID(){
		return this.OrgID;
	}
	public void setOrgID(int value){
		this.OrgID = value;
	}

	private int UserID = 0;
	public int getUserID(){
		return this.UserID;
	}
	public void setUserID(int value){
		this.UserID = value;
	}

	private String Date = "";
	public String getDate(){
		return this.Date;
	}
	public void setDate(String value){
		this.Date = value;
	}

	private int WIID = 0;
	public int getWIID(){
		return this.WIID;
	}
	public void setWIID(int value){
		this.WIID = value;
	}

	private int DataID = 0;
	public int getDataID(){
		return this.DataID;
	}
	public void setDataID(int value){
		this.DataID = value;
	}

}
