package org.polariscode.SecuritySystem.model.Finance;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;

@Component
public class TBill implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static TBill m_TBill;

	@PostConstruct 
	public void init(){
		m_TBill=this;
		m_TBill.dictionaryService=this.dictionaryService;
	}

	private int ID = 0;
	public int getID(){
		return this.ID;
	}
	public void setID(int value){
		this.ID = value;
	}

	private double Amount = 0.0;
	public double getAmount(){
		return this.Amount;
	}
	public void setAmount(double value){
		this.Amount = value;
	}

	private int YEAR = 0;
	public int getYEAR(){
		return this.YEAR;
	}
	public void setYEAR(int value){
		this.YEAR = value;
	}

	private int MONTH = 0;
	public int getMONTH(){
		return this.MONTH;
	}
	public void setMONTH(int value){
		this.MONTH = value;
	}

	private int YN = 0;
	public int getYN(){
		return this.YN;
	}
	public void setYN(int value){
		this.YN = value;
	}

	private int YNS = 0;
	public int getYNS(){
		return this.YNS;
	}
	public void setYNS(int value){
		this.YNS = value;
	}

}
