package org.polariscode.SecuritySystem.model.Logistics;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;

@Component
public class HouseContract implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static HouseContract m_HouseContract;

	@PostConstruct 
	public void init(){
		m_HouseContract=this;
		m_HouseContract.dictionaryService=this.dictionaryService;
	}

	private int ID = 0;
	public int getID(){
		return this.ID;
	}
	public void setID(int value){
		this.ID = value;
	}

	private int HouseId = 0;
	public int getHouseId(){
		return this.HouseId;
	}
	public void setHouseId(int value){
		this.HouseId = value;
	}

	private java.util.Date BeginDate = null;
	//开始日期
	public java.util.Date getBeginDate(){
		return this.BeginDate;
	}
	public void setBeginDate(java.util.Date value){
		this.BeginDate = value;
	}

	private java.util.Date EndDate = null;
	//结束日期
	public java.util.Date getEndDate(){
		return this.EndDate;
	}
	public void setEndDate(java.util.Date value){
		this.EndDate = value;
	}

	private double Rent = 0.0;
	//每月租金
	public double getRent(){
		return this.Rent;
	}
	public void setRent(double value){
		this.Rent = value;
	}

	private int RentMonth = 0;
	//付几个月
	public int getRentMonth(){
		return this.RentMonth;
	}
	public void setRentMonth(int value){
		this.RentMonth = value;
	}

	private int Deposit = 0;
	//押几个月
	public int getDeposit(){
		return this.Deposit;
	}
	public void setDeposit(int value){
		this.Deposit = value;
	}

	private String Describes = "";
	//备注
	public String getDescribes(){
		return this.Describes;
	}
	public void setDescribes(String value){
		this.Describes = value;
	}

}
