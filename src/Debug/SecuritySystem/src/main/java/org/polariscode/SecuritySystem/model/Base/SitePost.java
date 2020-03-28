package org.polariscode.SecuritySystem.model.Base;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;
import java.util.List;
import java.util.ArrayList;
import org.polariscode.SecuritySystem.model.Base.SitePostItem;

//执勤配置表
@Component
public class SitePost implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static SitePost m_SitePost;

	@PostConstruct 
	public void init(){
		m_SitePost=this;
		m_SitePost.dictionaryService=this.dictionaryService;
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
		SiteId_Convert = m_SitePost.dictionaryService.convertDictionary("Site", String.valueOf(SiteId));
		if(SiteId_Convert == null) SiteId_Convert = "";
		return SiteId_Convert;
	}
	public void setSiteId_Convert(String value){
		this.SiteId_Convert = value;
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

	private boolean Status = false;
	//是否发布
	public boolean getStatus(){
		return this.Status;
	}
	public void setStatus(boolean value){
		this.Status = value;
	}

	private String Describes = "";
	//备注
	public String getDescribes(){
		return this.Describes;
	}
	public void setDescribes(String value){
		this.Describes = value;
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

	private String ApplyUser = "";
	public String getApplyUser(){
		return this.ApplyUser;
	}
	public void setApplyUser(String value){
		this.ApplyUser = value;
	}

	private String ApplyTime = "";
	public String getApplyTime(){
		return this.ApplyTime;
	}
	public void setApplyTime(String value){
		this.ApplyTime = value;
	}

	private List<SitePostItem> Items = new ArrayList<SitePostItem>();
	//明细
	public List<SitePostItem> getItems(){
		return this.Items;
	}
	public void setItems(List<SitePostItem> value){
		this.Items = value;
	}

	private java.util.Date SiteBeginDate = null;
	//驻点合同开始日期
	public java.util.Date getSiteBeginDate(){
		return this.SiteBeginDate;
	}
	public void setSiteBeginDate(java.util.Date value){
		this.SiteBeginDate = value;
	}

	private java.util.Date SiteEndDate = null;
	//驻点合同结束日期
	public java.util.Date getSiteEndDate(){
		return this.SiteEndDate;
	}
	public void setSiteEndDate(java.util.Date value){
		this.SiteEndDate = value;
	}

}
