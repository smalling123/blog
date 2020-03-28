package org.polariscode.SecuritySystem.model.Finance;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;

@Component
public class Pay implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static Pay m_Pay;

	@PostConstruct 
	public void init(){
		m_Pay=this;
		m_Pay.dictionaryService=this.dictionaryService;
	}

	private int ID = 0;
	public int getID(){
		return this.ID;
	}
	public void setID(int value){
		this.ID = value;
	}

	private java.util.Date Date = null;
	//到款日期
	public java.util.Date getDate(){
		return this.Date;
	}
	public void setDate(java.util.Date value){
		this.Date = value;
	}

	private String BankNo = "";
	//银行交易号
	public String getBankNo(){
		return this.BankNo;
	}
	public void setBankNo(String value){
		this.BankNo = value;
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
		CustomerId_Convert = m_Pay.dictionaryService.convertDictionary("Customer", String.valueOf(CustomerId));
		if(CustomerId_Convert == null) CustomerId_Convert = "";
		return CustomerId_Convert;
	}
	public void setCustomerId_Convert(String value){
		this.CustomerId_Convert = value;
	}

	private double Amt = 0.0;
	//金额
	public double getAmt(){
		return this.Amt;
	}
	public void setAmt(double value){
		this.Amt = value;
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
			return "未认领";
		case "1":
			return "已认领";
		case "2":
			return "部分核销";
		case "3":
			return "已核销";
		}
		return Status_Convert;
	}
	public void setStatus_Convert(String value){
		this.Status_Convert = value;
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
	//创建用户
	public String getCreateUser(){
		return this.CreateUser;
	}
	public void setCreateUser(String value){
		this.CreateUser = value;
	}

	private String CreateTime = "";
	//创建时间
	public String getCreateTime(){
		return this.CreateTime;
	}
	public void setCreateTime(String value){
		this.CreateTime = value;
	}

	private String ClaimUser = "";
	//认领用户
	public String getClaimUser(){
		return this.ClaimUser;
	}
	public void setClaimUser(String value){
		this.ClaimUser = value;
	}

	private String ClaimTime = "";
	//认领时间
	public String getClaimTime(){
		return this.ClaimTime;
	}
	public void setClaimTime(String value){
		this.ClaimTime = value;
	}

	private String CheckUser = "";
	//核销用户
	public String getCheckUser(){
		return this.CheckUser;
	}
	public void setCheckUser(String value){
		this.CheckUser = value;
	}

	private String CheckTime = "";
	//核销时间
	public String getCheckTime(){
		return this.CheckTime;
	}
	public void setCheckTime(String value){
		this.CheckTime = value;
	}

}
