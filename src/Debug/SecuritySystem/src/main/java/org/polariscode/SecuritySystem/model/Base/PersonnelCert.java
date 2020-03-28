package org.polariscode.SecuritySystem.model.Base;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;

@Component
public class PersonnelCert implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static PersonnelCert m_PersonnelCert;

	@PostConstruct 
	public void init(){
		m_PersonnelCert=this;
		m_PersonnelCert.dictionaryService=this.dictionaryService;
	}

	private int ID = 0;
	public int getID(){
		return this.ID;
	}
	public void setID(int value){
		this.ID = value;
	}

	private int PersonnelID = 0;
	public int getPersonnelID(){
		return this.PersonnelID;
	}
	public void setPersonnelID(int value){
		this.PersonnelID = value;
	}

	private int CertType = 0;
	//证件类型
	public int getCertType(){
		return this.CertType;
	}
	public void setCertType(int value){
		this.CertType = value;
	}

	private String CertType_Convert="";
	public String getCertType_Convert(){
		switch(String.valueOf(CertType)) {
		case "0":
			return "身份证";
		case "1":
			return "保安员证";
		case "3":
			return "监控证";
		case "4":
			return "电梯证";
		case "5":
			return "消防证";
		case "6":
			return "驾驶执照";
		case "7":
			return "健康证";
		case "8":
			return "无犯罪记录证明";
		case "9":
			return "交金证明";
		case "10":
			return "学历证明";
		}
		return CertType_Convert;
	}
	public void setCertType_Convert(String value){
		this.CertType_Convert = value;
	}

	private String Level = "";
	//等级
	public String getLevel(){
		return this.Level;
	}
	public void setLevel(String value){
		this.Level = value;
	}

	private String CertUrl = "";
	//地址
	public String getCertUrl(){
		return this.CertUrl;
	}
	public void setCertUrl(String value){
		this.CertUrl = value;
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
