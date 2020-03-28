package org.polariscode.SecuritySystem.model.Finance;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;

@Component
public class PayCheck implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static PayCheck m_PayCheck;

	@PostConstruct 
	public void init(){
		m_PayCheck=this;
		m_PayCheck.dictionaryService=this.dictionaryService;
	}

	private int ID = 0;
	public int getID(){
		return this.ID;
	}
	public void setID(int value){
		this.ID = value;
	}

	private int PayId = 0;
	public int getPayId(){
		return this.PayId;
	}
	public void setPayId(int value){
		this.PayId = value;
	}

	private int InvoiceItemId = 0;
	public int getInvoiceItemId(){
		return this.InvoiceItemId;
	}
	public void setInvoiceItemId(int value){
		this.InvoiceItemId = value;
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

}
