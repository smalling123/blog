package org.polariscode.SecuritySystem.model.Base;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;

//员工信息(简化)
@Component
public class PersonnelEx implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static PersonnelEx m_PersonnelEx;

	@PostConstruct 
	public void init(){
		m_PersonnelEx=this;
		m_PersonnelEx.dictionaryService=this.dictionaryService;
	}

	private int ID = 0;
	public int getID(){
		return this.ID;
	}
	public void setID(int value){
		this.ID = value;
	}

	private String FileNumber = "";
	//档案号
	public String getFileNumber(){
		return this.FileNumber;
	}
	public void setFileNumber(String value){
		this.FileNumber = value;
	}

	private String SiteName = "";
	//驻点
	public String getSiteName(){
		return this.SiteName;
	}
	public void setSiteName(String value){
		this.SiteName = value;
	}

	private String Name = "";
	//姓名
	public String getName(){
		return this.Name;
	}
	public void setName(String value){
		this.Name = value;
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

	private String CardCode = "";
	//身份证号
	public String getCardCode(){
		return this.CardCode;
	}
	public void setCardCode(String value){
		this.CardCode = value;
	}

	private java.util.Date CardDate = null;
	//身份证有效期
	public java.util.Date getCardDate(){
		return this.CardDate;
	}
	public void setCardDate(java.util.Date value){
		this.CardDate = value;
	}

	private String Native = "";
	//籍贯
	public String getNative(){
		return this.Native;
	}
	public void setNative(String value){
		this.Native = value;
	}

	private String Native_Convert="";
	public String getNative_Convert(){
		Native_Convert = m_PersonnelEx.dictionaryService.convertDictionary("Province", String.valueOf(Native));
		if(Native_Convert == null) Native_Convert = "";
		return Native_Convert;
	}
	public void setNative_Convert(String value){
		this.Native_Convert = value;
	}

	private String Phone = "";
	//电话
	public String getPhone(){
		return this.Phone;
	}
	public void setPhone(String value){
		this.Phone = value;
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
	//职级
	public String getLevel(){
		return this.Level;
	}
	public void setLevel(String value){
		this.Level = value;
	}

	private java.util.Date InDate = null;
	//入职日期
	public java.util.Date getInDate(){
		return this.InDate;
	}
	public void setInDate(java.util.Date value){
		this.InDate = value;
	}

	private java.util.Date HTBeginDate = null;
	//合同开始日期
	public java.util.Date getHTBeginDate(){
		return this.HTBeginDate;
	}
	public void setHTBeginDate(java.util.Date value){
		this.HTBeginDate = value;
	}

	private java.util.Date HTEndDate = null;
	//合同结束日期
	public java.util.Date getHTEndDate(){
		return this.HTEndDate;
	}
	public void setHTEndDate(java.util.Date value){
		this.HTEndDate = value;
	}

	private java.util.Date OutDate = null;
	//离职日期
	public java.util.Date getOutDate(){
		return this.OutDate;
	}
	public void setOutDate(java.util.Date value){
		this.OutDate = value;
	}

	private int PoliticalTrial = 0;
	//政审
	public int getPoliticalTrial(){
		return this.PoliticalTrial;
	}
	public void setPoliticalTrial(int value){
		this.PoliticalTrial = value;
	}

	private String PoliticalTrial_Convert="";
	public String getPoliticalTrial_Convert(){
		switch(String.valueOf(PoliticalTrial)) {
		case "0":
			return "未做政审";
		case "1":
			return "政审通过";
		case "2":
			return "政审不通过";
		}
		return PoliticalTrial_Convert;
	}
	public void setPoliticalTrial_Convert(String value){
		this.PoliticalTrial_Convert = value;
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
		case "3":
			return "自离";
		}
		return Status_Convert;
	}
	public void setStatus_Convert(String value){
		this.Status_Convert = value;
	}

	private String Reference = "";
	//推荐人
	public String getReference(){
		return this.Reference;
	}
	public void setReference(String value){
		this.Reference = value;
	}

	private int PhotoCount = 0;
	//照片张数
	public int getPhotoCount(){
		return this.PhotoCount;
	}
	public void setPhotoCount(int value){
		this.PhotoCount = value;
	}

	private String CreateUser = "";
	//创建人
	public String getCreateUser(){
		return this.CreateUser;
	}
	public void setCreateUser(String value){
		this.CreateUser = value;
	}

	private java.util.Date CreateTime = null;
	//创建时间
	public java.util.Date getCreateTime(){
		return this.CreateTime;
	}
	public void setCreateTime(java.util.Date value){
		this.CreateTime = value;
	}

}
