package org.polariscode.SecuritySystem.model.ApplyFor;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;

@Component
public class Family implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static Family m_Family;

	@PostConstruct 
	public void init(){
		m_Family=this;
		m_Family.dictionaryService=this.dictionaryService;
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

	private String Appellation = "";
	//称谓
	public String getAppellation(){
		return this.Appellation;
	}
	public void setAppellation(String value){
		this.Appellation = value;
	}

	private String Name = "";
	//姓名
	public String getName(){
		return this.Name;
	}
	public void setName(String value){
		this.Name = value;
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

	private String Phone = "";
	//联络电话
	public String getPhone(){
		return this.Phone;
	}
	public void setPhone(String value){
		this.Phone = value;
	}

}
