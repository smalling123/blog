package org.polariscode.SecuritySystem.model.Salary;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;

@Component
public class Taxy implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static Taxy m_Taxy;

	@PostConstruct 
	public void init(){
		m_Taxy=this;
		m_Taxy.dictionaryService=this.dictionaryService;
	}

	private int ID = 0;
	public int getID(){
		return this.ID;
	}
	public void setID(int value){
		this.ID = value;
	}

	private int TaxId = 0;
	public int getTaxId(){
		return this.TaxId;
	}
	public void setTaxId(int value){
		this.TaxId = value;
	}

	private double MinValue = 0.0;
	//下限
	public double getMinValue(){
		return this.MinValue;
	}
	public void setMinValue(double value){
		this.MinValue = value;
	}

	private double MaxValue = 0.0;
	//上限
	public double getMaxValue(){
		return this.MaxValue;
	}
	public void setMaxValue(double value){
		this.MaxValue = value;
	}

	private double Value = 0.0;
	//速扣数
	public double getValue(){
		return this.Value;
	}
	public void setValue(double value){
		this.Value = value;
	}

}
