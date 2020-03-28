package org.polariscode.SecuritySystem.model.Office;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;

@Component
public class StaffE implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static StaffE m_StaffE;

	@PostConstruct 
	public void init(){
		m_StaffE=this;
		m_StaffE.dictionaryService=this.dictionaryService;
	}

	private int ID = 0;
	public int getID(){
		return this.ID;
	}
	public void setID(int value){
		this.ID = value;
	}

	private String Name = "";
	//姓名
	public String getName(){
		return this.Name;
	}
	public void setName(String value){
		this.Name = value;
	}

	private String CardCode = "";
	//证件号
	public String getCardCode(){
		return this.CardCode;
	}
	public void setCardCode(String value){
		this.CardCode = value;
	}

	private int Gender = 0;
	//性别
	public int getGender(){
		return this.Gender;
	}
	public void setGender(int value){
		this.Gender = value;
	}

	private String Gender_Convert="";
	public String getGender_Convert(){
		switch(String.valueOf(Gender)) {
		case "1":
			return "男";
		case "0":
			return "女";
		}
		return Gender_Convert;
	}
	public void setGender_Convert(String value){
		this.Gender_Convert = value;
	}

	private java.util.Date Birthday = null;
	//出生日期
	public java.util.Date getBirthday(){
		return this.Birthday;
	}
	public void setBirthday(java.util.Date value){
		this.Birthday = value;
	}

	private int Status = 0;
	//状态
	public int getStatus(){
		return this.Status;
	}
	public void setStatus(int value){
		this.Status = value;
	}

	private String Status_Convert="";
	public String getStatus_Convert(){
		switch(String.valueOf(Status)) {
		case "0":
			return "待分配";
		case "1":
			return "在职";
		case "2":
			return "离职";
		}
		return Status_Convert;
	}
	public void setStatus_Convert(String value){
		this.Status_Convert = value;
	}

	private java.util.Date RegisterDate = null;
	//入职日期
	public java.util.Date getRegisterDate(){
		return this.RegisterDate;
	}
	public void setRegisterDate(java.util.Date value){
		this.RegisterDate = value;
	}

	private int OrgID = 0;
	public int getOrgID(){
		return this.OrgID;
	}
	public void setOrgID(int value){
		this.OrgID = value;
	}

	private String OrgName = "";
	//部门
	public String getOrgName(){
		return this.OrgName;
	}
	public void setOrgName(String value){
		this.OrgName = value;
	}

	private String Photo = "";
	//照片
	public String getPhoto(){
		return this.Photo;
	}
	public void setPhoto(String value){
		this.Photo = value;
	}

}
