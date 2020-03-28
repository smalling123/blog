package org.polariscode.SecuritySystem.model.Base;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;

//家庭成员
@Component
public class PersonnelMembers implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static PersonnelMembers m_PersonnelMembers;

	@PostConstruct 
	public void init(){
		m_PersonnelMembers=this;
		m_PersonnelMembers.dictionaryService=this.dictionaryService;
	}

	private int PersonnelID = 0;
	public int getPersonnelID(){
		return this.PersonnelID;
	}
	public void setPersonnelID(int value){
		this.PersonnelID = value;
	}

	private String Name = "";
	//姓名
	public String getName(){
		return this.Name;
	}
	public void setName(String value){
		this.Name = value;
	}

	private int Relation = 0;
	//关系
	public int getRelation(){
		return this.Relation;
	}
	public void setRelation(int value){
		this.Relation = value;
	}

	private String Relation_Convert="";
	public String getRelation_Convert(){
		switch(String.valueOf(Relation)) {
		case "0":
			return "父";
		case "1":
			return "母";
		case "2":
			return "配偶";
		case "3":
			return "子女";
		case "4":
			return "兄弟";
		case "5":
			return "姐妹";
		case "6":
			return "其它";
		}
		return Relation_Convert;
	}
	public void setRelation_Convert(String value){
		this.Relation_Convert = value;
	}

	private String Phone = "";
	//电话
	public String getPhone(){
		return this.Phone;
	}
	public void setPhone(String value){
		this.Phone = value;
	}

	private int Age = 0;
	//年龄
	public int getAge(){
		return this.Age;
	}
	public void setAge(int value){
		this.Age = value;
	}

	private String Company = "";
	//工作单位
	public String getCompany(){
		return this.Company;
	}
	public void setCompany(String value){
		this.Company = value;
	}

}
