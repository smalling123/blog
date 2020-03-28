package org.polariscode.SecuritySystem.model.Import;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;

@Component
public class SitepersonnelImport implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static SitepersonnelImport m_SitepersonnelImport;

	@PostConstruct 
	public void init(){
		m_SitepersonnelImport=this;
		m_SitepersonnelImport.dictionaryService=this.dictionaryService;
	}

	private int ID = 0;
	public int getID(){
		return this.ID;
	}
	public void setID(int value){
		this.ID = value;
	}

	private int SiteId = 0;
	public int getSiteId(){
		return this.SiteId;
	}
	public void setSiteId(int value){
		this.SiteId = value;
	}

	private int PID = 0;
	public int getPID(){
		return this.PID;
	}
	public void setPID(int value){
		this.PID = value;
	}

	private java.util.Date BeginDate = null;
	public java.util.Date getBeginDate(){
		return this.BeginDate;
	}
	public void setBeginDate(java.util.Date value){
		this.BeginDate = value;
	}

	private java.util.Date EndDate = null;
	public java.util.Date getEndDate(){
		return this.EndDate;
	}
	public void setEndDate(java.util.Date value){
		this.EndDate = value;
	}

	private boolean IsMain = false;
	public boolean getIsMain(){
		return this.IsMain;
	}
	public void setIsMain(boolean value){
		this.IsMain = value;
	}

	private String Job = "";
	public String getJob(){
		return this.Job;
	}
	public void setJob(String value){
		this.Job = value;
	}

	private String Level = "";
	public String getLevel(){
		return this.Level;
	}
	public void setLevel(String value){
		this.Level = value;
	}

	private double PostSubsidy = 0.0;
	public double getPostSubsidy(){
		return this.PostSubsidy;
	}
	public void setPostSubsidy(double value){
		this.PostSubsidy = value;
	}

	private String CreateUser = "";
	public String getCreateUser(){
		return this.CreateUser;
	}
	public void setCreateUser(String value){
		this.CreateUser = value;
	}

	private String CreateTime = "";
	public String getCreateTime(){
		return this.CreateTime;
	}
	public void setCreateTime(String value){
		this.CreateTime = value;
	}

}
