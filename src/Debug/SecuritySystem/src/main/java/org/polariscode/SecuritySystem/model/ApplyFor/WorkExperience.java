package org.polariscode.SecuritySystem.model.ApplyFor;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;

//工作经历
@Component
public class WorkExperience implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static WorkExperience m_WorkExperience;

	@PostConstruct 
	public void init(){
		m_WorkExperience=this;
		m_WorkExperience.dictionaryService=this.dictionaryService;
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

	private String Company = "";
	//公司名称
	public String getCompany(){
		return this.Company;
	}
	public void setCompany(String value){
		this.Company = value;
	}

	private String Phone = "";
	//公司电话
	public String getPhone(){
		return this.Phone;
	}
	public void setPhone(String value){
		this.Phone = value;
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

	private String Position = "";
	//职位
	public String getPosition(){
		return this.Position;
	}
	public void setPosition(String value){
		this.Position = value;
	}

	private double salary = 0.0;
	//薪资
	public double getsalary(){
		return this.salary;
	}
	public void setsalary(double value){
		this.salary = value;
	}

	private String Witness = "";
	//证明人
	public String getWitness(){
		return this.Witness;
	}
	public void setWitness(String value){
		this.Witness = value;
	}

	private String WitnessPhone = "";
	//证明电话
	public String getWitnessPhone(){
		return this.WitnessPhone;
	}
	public void setWitnessPhone(String value){
		this.WitnessPhone = value;
	}

	private String LeavingReasons = "";
	//离职原因
	public String getLeavingReasons(){
		return this.LeavingReasons;
	}
	public void setLeavingReasons(String value){
		this.LeavingReasons = value;
	}

}
