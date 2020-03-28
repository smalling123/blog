package org.polariscode.SecuritySystem.model.Contract;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;

@Component
public class ContractInvoice implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static ContractInvoice m_ContractInvoice;

	@PostConstruct 
	public void init(){
		m_ContractInvoice=this;
		m_ContractInvoice.dictionaryService=this.dictionaryService;
	}

	private int ID = 0;
	public int getID(){
		return this.ID;
	}
	public void setID(int value){
		this.ID = value;
	}

	private int ContractId = 0;
	//合同ID
	public int getContractId(){
		return this.ContractId;
	}
	public void setContractId(int value){
		this.ContractId = value;
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

	private String Content = "";
	//开票内容
	public String getContent(){
		return this.Content;
	}
	public void setContent(String value){
		this.Content = value;
	}

	private int PNumber = 0;
	//开票人数
	public int getPNumber(){
		return this.PNumber;
	}
	public void setPNumber(int value){
		this.PNumber = value;
	}

	private double Price = 0.0;
	//单价
	public double getPrice(){
		return this.Price;
	}
	public void setPrice(double value){
		this.Price = value;
	}

	private double Amount = 0.0;
	//每月金额
	public double getAmount(){
		return this.Amount;
	}
	public void setAmount(double value){
		this.Amount = value;
	}

	private double TotalAmount = 0.0;
	//合同总金额
	public double getTotalAmount(){
		return this.TotalAmount;
	}
	public void setTotalAmount(double value){
		this.TotalAmount = value;
	}

	private int Type = 0;
	//开票类型
	public int getType(){
		return this.Type;
	}
	public void setType(int value){
		this.Type = value;
	}

	private String Type_Convert="";
	public String getType_Convert(){
		switch(String.valueOf(Type)) {
		case "0":
			return "增值税专业发票";
		case "1":
			return "增值税普通发票";
		}
		return Type_Convert;
	}
	public void setType_Convert(String value){
		this.Type_Convert = value;
	}

	private int Day = 0;
	//开票日
	public int getDay(){
		return this.Day;
	}
	public void setDay(int value){
		this.Day = value;
	}

	private boolean Isdelete = false;
	//是否删除
	public boolean getIsdelete(){
		return this.Isdelete;
	}
	public void setIsdelete(boolean value){
		this.Isdelete = value;
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

	private String ModifyUser = "";
	//修改用户
	public String getModifyUser(){
		return this.ModifyUser;
	}
	public void setModifyUser(String value){
		this.ModifyUser = value;
	}

	private String ModifyTime = "";
	//修改时间
	public String getModifyTime(){
		return this.ModifyTime;
	}
	public void setModifyTime(String value){
		this.ModifyTime = value;
	}

	private String DeleteUser = "";
	//删除用户
	public String getDeleteUser(){
		return this.DeleteUser;
	}
	public void setDeleteUser(String value){
		this.DeleteUser = value;
	}

	private String DeleteTime = "";
	//删除时间
	public String getDeleteTime(){
		return this.DeleteTime;
	}
	public void setDeleteTime(String value){
		this.DeleteTime = value;
	}

	private int Invoicecycle = 0;
	//开票周期
	public int getInvoicecycle(){
		return this.Invoicecycle;
	}
	public void setInvoicecycle(int value){
		this.Invoicecycle = value;
	}

	private String Describes = "";
	//备注
	public String getDescribes(){
		return this.Describes;
	}
	public void setDescribes(String value){
		this.Describes = value;
	}

	private int Month = 0;
	//开票月
	public int getMonth(){
		return this.Month;
	}
	public void setMonth(int value){
		this.Month = value;
	}

}
