package org.polariscode.SecuritySystem.model.Office;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;

@Component
public class StaffWork implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static StaffWork m_StaffWork;

	@PostConstruct 
	public void init(){
		m_StaffWork=this;
		m_StaffWork.dictionaryService=this.dictionaryService;
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

	private String Company = "";
	//工作单位
	public String getCompany(){
		return this.Company;
	}
	public void setCompany(String value){
		this.Company = value;
	}

	private String Post = "";
	//职务
	public String getPost(){
		return this.Post;
	}
	public void setPost(String value){
		this.Post = value;
	}

	private String Salary = "";
	//收入
	public String getSalary(){
		return this.Salary;
	}
	public void setSalary(String value){
		this.Salary = value;
	}

	private String Phone = "";
	//电话
	public String getPhone(){
		return this.Phone;
	}
	public void setPhone(String value){
		this.Phone = value;
	}

	private String Leaving = "";
	//离职原因
	public String getLeaving(){
		return this.Leaving;
	}
	public void setLeaving(String value){
		this.Leaving = value;
	}

}
