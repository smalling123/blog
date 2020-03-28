package org.polariscode.SecuritySystem.model.Office;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;

@Component
public class StaffEdu implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static StaffEdu m_StaffEdu;

	@PostConstruct 
	public void init(){
		m_StaffEdu=this;
		m_StaffEdu.dictionaryService=this.dictionaryService;
	}

	private int ID = 0;
	public int getID(){
		return this.ID;
	}
	public void setID(int value){
		this.ID = value;
	}

	private int StaffID = 0;
	public int getStaffID(){
		return this.StaffID;
	}
	public void setStaffID(int value){
		this.StaffID = value;
	}

	private String Date = "";
	//起止日期
	public String getDate(){
		return this.Date;
	}
	public void setDate(String value){
		this.Date = value;
	}

	private String School = "";
	//学校
	public String getSchool(){
		return this.School;
	}
	public void setSchool(String value){
		this.School = value;
	}

	private String Major = "";
	//专业
	public String getMajor(){
		return this.Major;
	}
	public void setMajor(String value){
		this.Major = value;
	}

	private String Degree = "";
	//学历
	public String getDegree(){
		return this.Degree;
	}
	public void setDegree(String value){
		this.Degree = value;
	}

	private String Degree_Convert="";
	public String getDegree_Convert(){
		switch(String.valueOf(Degree)) {
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
		return Degree_Convert;
	}
	public void setDegree_Convert(String value){
		this.Degree_Convert = value;
	}

	private String Study = "";
	//学习方式
	public String getStudy(){
		return this.Study;
	}
	public void setStudy(String value){
		this.Study = value;
	}

	private boolean Cert = false;
	//是否取得证书
	public boolean getCert(){
		return this.Cert;
	}
	public void setCert(boolean value){
		this.Cert = value;
	}

}
