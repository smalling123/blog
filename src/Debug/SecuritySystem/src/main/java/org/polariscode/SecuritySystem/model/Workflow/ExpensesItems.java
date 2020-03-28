package org.polariscode.SecuritySystem.model.Workflow;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;

//报销明细
@Component
public class ExpensesItems implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static ExpensesItems m_ExpensesItems;

	@PostConstruct 
	public void init(){
		m_ExpensesItems=this;
		m_ExpensesItems.dictionaryService=this.dictionaryService;
	}

	private int ID = 0;
	public int getID(){
		return this.ID;
	}
	public void setID(int value){
		this.ID = value;
	}

	private int ExpensesId = 0;
	public int getExpensesId(){
		return this.ExpensesId;
	}
	public void setExpensesId(int value){
		this.ExpensesId = value;
	}

	private String Content = "";
	//报销内容
	public String getContent(){
		return this.Content;
	}
	public void setContent(String value){
		this.Content = value;
	}

	private int Type = 0;
	//类型
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
			return "招待费";
		case "1":
			return "交通费";
		case "2":
			return "通讯费";
		case "3":
			return "办公用品采购";
		case "4":
			return "装备采购";
		case "5":
			return "房租";
		case "11":
			return "社保";
		case "12":
			return "公积金";
		case "13":
			return "残疾人保障金";
		case "14":
			return "经济补偿金";
		case "99":
			return "其它";
		}
		return Type_Convert;
	}
	public void setType_Convert(String value){
		this.Type_Convert = value;
	}

	private double Amt = 0.0;
	//报销金额
	public double getAmt(){
		return this.Amt;
	}
	public void setAmt(double value){
		this.Amt = value;
	}

}
