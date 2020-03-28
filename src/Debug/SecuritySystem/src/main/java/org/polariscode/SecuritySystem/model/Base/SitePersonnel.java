package org.polariscode.SecuritySystem.model.Base;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;

//驻点人员信息
@Component
public class SitePersonnel implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static SitePersonnel m_SitePersonnel;

	@PostConstruct 
	public void init(){
		m_SitePersonnel=this;
		m_SitePersonnel.dictionaryService=this.dictionaryService;
	}

	private int ID = 0;
	public int getID(){
		return this.ID;
	}
	public void setID(int value){
		this.ID = value;
	}

	private int SiteId = 0;
	//驻点
	public int getSiteId(){
		return this.SiteId;
	}
	public void setSiteId(int value){
		this.SiteId = value;
	}

	private String SiteId_Convert="";
	public String getSiteId_Convert(){
		SiteId_Convert = m_SitePersonnel.dictionaryService.convertDictionary("Site", String.valueOf(SiteId));
		if(SiteId_Convert == null) SiteId_Convert = "";
		return SiteId_Convert;
	}
	public void setSiteId_Convert(String value){
		this.SiteId_Convert = value;
	}

	private int PID = 0;
	public int getPID(){
		return this.PID;
	}
	public void setPID(int value){
		this.PID = value;
	}

	private String Name = "";
	//姓名
	public String getName(){
		return this.Name;
	}
	public void setName(String value){
		this.Name = value;
	}

	private java.util.Date BeginDate = null;
	//调入日期
	public java.util.Date getBeginDate(){
		return this.BeginDate;
	}
	public void setBeginDate(java.util.Date value){
		this.BeginDate = value;
	}

	private java.util.Date EndDate = null;
	//调出日期
	public java.util.Date getEndDate(){
		return this.EndDate;
	}
	public void setEndDate(java.util.Date value){
		this.EndDate = value;
	}

	private boolean IsMain = false;
	//是否主岗
	public boolean getIsMain(){
		return this.IsMain;
	}
	public void setIsMain(boolean value){
		this.IsMain = value;
	}

	private String Job = "";
	//职务
	public String getJob(){
		return this.Job;
	}
	public void setJob(String value){
		this.Job = value;
	}

	private String Job_Convert="";
	public String getJob_Convert(){
		switch(String.valueOf(Job)) {
		case "01":
			return "队员";
		case "02":
			return "领班";
		case "03":
			return "副队长";
		case "04":
			return "队长";
		}
		return Job_Convert;
	}
	public void setJob_Convert(String value){
		this.Job_Convert = value;
	}

	private String Level = "";
	//等级
	public String getLevel(){
		return this.Level;
	}
	public void setLevel(String value){
		this.Level = value;
	}

	private String Level_Convert="";
	public String getLevel_Convert(){
		switch(String.valueOf(Level)) {
		case "01":
			return "一级";
		}
		return Level_Convert;
	}
	public void setLevel_Convert(String value){
		this.Level_Convert = value;
	}

	private double PostSubsidy = 0.0;
	//津贴
	public double getPostSubsidy(){
		return this.PostSubsidy;
	}
	public void setPostSubsidy(double value){
		this.PostSubsidy = value;
	}

}
