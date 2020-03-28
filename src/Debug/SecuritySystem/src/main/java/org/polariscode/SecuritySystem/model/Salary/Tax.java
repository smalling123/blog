package org.polariscode.SecuritySystem.model.Salary;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;
import java.util.List;
import java.util.ArrayList;
import org.polariscode.SecuritySystem.model.Salary.Taxm;
import org.polariscode.SecuritySystem.model.Salary.Taxy;

@Component
public class Tax implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static Tax m_Tax;

	@PostConstruct 
	public void init(){
		m_Tax=this;
		m_Tax.dictionaryService=this.dictionaryService;
	}

	private int ID = 0;
	public int getID(){
		return this.ID;
	}
	public void setID(int value){
		this.ID = value;
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

	private double Base = 0.0;
	//起征点
	public double getBase(){
		return this.Base;
	}
	public void setBase(double value){
		this.Base = value;
	}

	private List<Taxm> Taxms = new ArrayList<Taxm>();
	public List<Taxm> getTaxms(){
		return this.Taxms;
	}
	public void setTaxms(List<Taxm> value){
		this.Taxms = value;
	}

	private List<Taxy> Taxys = new ArrayList<Taxy>();
	public List<Taxy> getTaxys(){
		return this.Taxys;
	}
	public void setTaxys(List<Taxy> value){
		this.Taxys = value;
	}

}
