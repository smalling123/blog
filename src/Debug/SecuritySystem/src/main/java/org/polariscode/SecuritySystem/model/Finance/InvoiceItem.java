package org.polariscode.SecuritySystem.model.Finance;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;

@Component
public class InvoiceItem implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static InvoiceItem m_InvoiceItem;

	@PostConstruct 
	public void init(){
		m_InvoiceItem=this;
		m_InvoiceItem.dictionaryService=this.dictionaryService;
	}

	private int ID = 0;
	public int getID(){
		return this.ID;
	}
	public void setID(int value){
		this.ID = value;
	}

	private int InvoiceId = 0;
	public int getInvoiceId(){
		return this.InvoiceId;
	}
	public void setInvoiceId(int value){
		this.InvoiceId = value;
	}

	private String Name = "";
	//发票内容
	public String getName(){
		return this.Name;
	}
	public void setName(String value){
		this.Name = value;
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

	private int BillItemId = 0;
	public int getBillItemId(){
		return this.BillItemId;
	}
	public void setBillItemId(int value){
		this.BillItemId = value;
	}

	private int QTY = 0;
	//数量
	public int getQTY(){
		return this.QTY;
	}
	public void setQTY(int value){
		this.QTY = value;
	}

}
