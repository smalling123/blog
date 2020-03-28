package org.polariscode.SecuritySystem.model.ApplyFor;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;

//教育培训记录
@Component
public class EducationalTraining implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static EducationalTraining m_EducationalTraining;

	@PostConstruct 
	public void init(){
		m_EducationalTraining=this;
		m_EducationalTraining.dictionaryService=this.dictionaryService;
	}

	private int Id = 0;
	//序号
	public int getId(){
		return this.Id;
	}
	public void setId(int value){
		this.Id = value;
	}

	private int Eid = 0;
	//员工ID
	public int getEid(){
		return this.Eid;
	}
	public void setEid(int value){
		this.Eid = value;
	}

	private String Education = "";
	//学历
	public String getEducation(){
		return this.Education;
	}
	public void setEducation(String value){
		this.Education = value;
	}

	private String Education_Convert="";
	public String getEducation_Convert(){
		switch(String.valueOf(Education)) {
		case "0":
			return "无";
		case "1":
			return "小学";
		case "2":
			return "初中";
		case "3":
			return "高中";
		case "4":
			return "大专";
		case "5":
			return "本科";
		case "6":
			return "硕士";
		case "7":
			return "博士";
		}
		return Education_Convert;
	}
	public void setEducation_Convert(String value){
		this.Education_Convert = value;
	}

	private String BeiginDate = "";
	//开始时间
	public String getBeiginDate(){
		return this.BeiginDate;
	}
	public void setBeiginDate(String value){
		this.BeiginDate = value;
	}

	private String EndDate = "";
	//结束时间
	public String getEndDate(){
		return this.EndDate;
	}
	public void setEndDate(String value){
		this.EndDate = value;
	}

	private String School = "";
	//学校或教育机构
	public String getSchool(){
		return this.School;
	}
	public void setSchool(String value){
		this.School = value;
	}

	private String Department = "";
	//科(系)别
	public String getDepartment(){
		return this.Department;
	}
	public void setDepartment(String value){
		this.Department = value;
	}

	private String Certificate = "";
	//证书类型
	public String getCertificate(){
		return this.Certificate;
	}
	public void setCertificate(String value){
		this.Certificate = value;
	}

}
