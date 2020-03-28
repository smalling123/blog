package org.polariscode.SecuritySystem.model.Logistics;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;

@Component
public class EquipmentOutStock implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static EquipmentOutStock m_EquipmentOutStock;

	@PostConstruct 
	public void init(){
		m_EquipmentOutStock=this;
		m_EquipmentOutStock.dictionaryService=this.dictionaryService;
	}

	private int ID = 0;
	public int getID(){
		return this.ID;
	}
	public void setID(int value){
		this.ID = value;
	}

	private java.util.Date Date = null;
	//领用日期
	public java.util.Date getDate(){
		return this.Date;
	}
	public void setDate(java.util.Date value){
		this.Date = value;
	}

	private int OrgId = 0;
	//部门
	public int getOrgId(){
		return this.OrgId;
	}
	public void setOrgId(int value){
		this.OrgId = value;
	}

	private String OrgId_Convert="";
	public String getOrgId_Convert(){
		OrgId_Convert = m_EquipmentOutStock.dictionaryService.convertDictionary("Org", String.valueOf(OrgId));
		if(OrgId_Convert == null) OrgId_Convert = "";
		return OrgId_Convert;
	}
	public void setOrgId_Convert(String value){
		this.OrgId_Convert = value;
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
		SiteId_Convert = m_EquipmentOutStock.dictionaryService.convertDictionary("Site", String.valueOf(SiteId));
		if(SiteId_Convert == null) SiteId_Convert = "";
		return SiteId_Convert;
	}
	public void setSiteId_Convert(String value){
		this.SiteId_Convert = value;
	}

	private int UserId = 0;
	//领用人
	public int getUserId(){
		return this.UserId;
	}
	public void setUserId(int value){
		this.UserId = value;
	}

	private String UserId_Convert="";
	public String getUserId_Convert(){
		UserId_Convert = m_EquipmentOutStock.dictionaryService.convertDictionary("User", String.valueOf(UserId));
		if(UserId_Convert == null) UserId_Convert = "";
		return UserId_Convert;
	}
	public void setUserId_Convert(String value){
		this.UserId_Convert = value;
	}

	private String Describes = "";
	//备注
	public String getDescribes(){
		return this.Describes;
	}
	public void setDescribes(String value){
		this.Describes = value;
	}

	private boolean Isdelete = false;
	public boolean getIsdelete(){
		return this.Isdelete;
	}
	public void setIsdelete(boolean value){
		this.Isdelete = value;
	}

	private String CreateUser = "";
	//创建用户
	public String getCreateUser(){
		return this.CreateUser;
	}
	public void setCreateUser(String value){
		this.CreateUser = value;
	}

	private String CreateTime = "";
	//创建时间
	public String getCreateTime(){
		return this.CreateTime;
	}
	public void setCreateTime(String value){
		this.CreateTime = value;
	}

	private String ModifyUser = "";
	//修改用户
	public String getModifyUser(){
		return this.ModifyUser;
	}
	public void setModifyUser(String value){
		this.ModifyUser = value;
	}

	private String ModifyTime = "";
	//修改时间
	public String getModifyTime(){
		return this.ModifyTime;
	}
	public void setModifyTime(String value){
		this.ModifyTime = value;
	}

	private String DeleteUser = "";
	//删除用户
	public String getDeleteUser(){
		return this.DeleteUser;
	}
	public void setDeleteUser(String value){
		this.DeleteUser = value;
	}

	private String DeleteTime = "";
	//删除时间
	public String getDeleteTime(){
		return this.DeleteTime;
	}
	public void setDeleteTime(String value){
		this.DeleteTime = value;
	}

	private int WorkflowID = 0;
	public int getWorkflowID(){
		return this.WorkflowID;
	}
	public void setWorkflowID(int value){
		this.WorkflowID = value;
	}

}
