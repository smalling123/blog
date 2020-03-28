package org.polariscode.SecuritySystem.model.Finance;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;

@Component
public class Bill implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static Bill m_Bill;

	@PostConstruct 
	public void init(){
		m_Bill=this;
		m_Bill.dictionaryService=this.dictionaryService;
	}

	private int ID = 0;
	public int getID(){
		return this.ID;
	}
	public void setID(int value){
		this.ID = value;
	}

	private int SiteId = 0;
	public int getSiteId(){
		return this.SiteId;
	}
	public void setSiteId(int value){
		this.SiteId = value;
	}

	private int Year = 0;
	//年
	public int getYear(){
		return this.Year;
	}
	public void setYear(int value){
		this.Year = value;
	}

	private int Month = 0;
	//月
	public int getMonth(){
		return this.Month;
	}
	public void setMonth(int value){
		this.Month = value;
	}

	private double Amt = 0.0;
	//金额
	public double getAmt(){
		return this.Amt;
	}
	public void setAmt(double value){
		this.Amt = value;
	}

	private String Describes = "";
	//备注
	public String getDescribes(){
		return this.Describes;
	}
	public void setDescribes(String value){
		this.Describes = value;
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

	private int CustomerId = 0;
	//客户
	public int getCustomerId(){
		return this.CustomerId;
	}
	public void setCustomerId(int value){
		this.CustomerId = value;
	}

	private String CustomerId_Convert="";
	public String getCustomerId_Convert(){
		CustomerId_Convert = m_Bill.dictionaryService.convertDictionary("Customer", String.valueOf(CustomerId));
		if(CustomerId_Convert == null) CustomerId_Convert = "";
		return CustomerId_Convert;
	}
	public void setCustomerId_Convert(String value){
		this.CustomerId_Convert = value;
	}

	private int ContractId = 0;
	public int getContractId(){
		return this.ContractId;
	}
	public void setContractId(int value){
		this.ContractId = value;
	}

}
