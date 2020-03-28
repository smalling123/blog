package org.polariscode.SecuritySystem.model.Salary;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;
import java.util.List;
import java.util.ArrayList;
import org.polariscode.SecuritySystem.model.Salary.InsuranceItem;

@Component
public class Insurance implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static Insurance m_Insurance;

	@PostConstruct 
	public void init(){
		m_Insurance=this;
		m_Insurance.dictionaryService=this.dictionaryService;
	}

	private int ID = 0;
	public int getID(){
		return this.ID;
	}
	public void setID(int value){
		this.ID = value;
	}

	private String City = "";
	//城市
	public String getCity(){
		return this.City;
	}
	public void setCity(String value){
		this.City = value;
	}

	private String City_Convert="";
	public String getCity_Convert(){
		City_Convert = m_Insurance.dictionaryService.convertDictionary("City", String.valueOf(City));
		if(City_Convert == null) City_Convert = "";
		return City_Convert;
	}
	public void setCity_Convert(String value){
		this.City_Convert = value;
	}

	private String Name = "";
	//社保名称
	public String getName(){
		return this.Name;
	}
	public void setName(String value){
		this.Name = value;
	}

	private List<InsuranceItem> Items = new ArrayList<InsuranceItem>();
	//明细
	public List<InsuranceItem> getItems(){
		return this.Items;
	}
	public void setItems(List<InsuranceItem> value){
		this.Items = value;
	}

}
