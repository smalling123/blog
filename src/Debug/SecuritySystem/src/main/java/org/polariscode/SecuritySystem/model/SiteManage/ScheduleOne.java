package org.polariscode.SecuritySystem.model.SiteManage;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;

@Component
public class ScheduleOne implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static ScheduleOne m_ScheduleOne;

	@PostConstruct 
	public void init(){
		m_ScheduleOne=this;
		m_ScheduleOne.dictionaryService=this.dictionaryService;
	}

	private int ID = 0;
	public int getID(){
		return this.ID;
	}
	public void setID(int value){
		this.ID = value;
	}

	private int SpiId = 0;
	public int getSpiId(){
		return this.SpiId;
	}
	public void setSpiId(int value){
		this.SpiId = value;
	}

	private java.util.Date Date = null;
	public java.util.Date getDate(){
		return this.Date;
	}
	public void setDate(java.util.Date value){
		this.Date = value;
	}

	private int PID = 0;
	public int getPID(){
		return this.PID;
	}
	public void setPID(int value){
		this.PID = value;
	}

	private int Status = 0;
	public int getStatus(){
		return this.Status;
	}
	public void setStatus(int value){
		this.Status = value;
	}

	private int BtcId = 0;
	public int getBtcId(){
		return this.BtcId;
	}
	public void setBtcId(int value){
		this.BtcId = value;
	}

	private int EtcId = 0;
	public int getEtcId(){
		return this.EtcId;
	}
	public void setEtcId(int value){
		this.EtcId = value;
	}

	private String History = "";
	public String getHistory(){
		return this.History;
	}
	public void setHistory(String value){
		this.History = value;
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

	private String ModifyUser = "";
	public String getModifyUser(){
		return this.ModifyUser;
	}
	public void setModifyUser(String value){
		this.ModifyUser = value;
	}

	private String ModifyTime = "";
	public String getModifyTime(){
		return this.ModifyTime;
	}
	public void setModifyTime(String value){
		this.ModifyTime = value;
	}

}
