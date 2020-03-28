package org.polariscode.SecuritySystem.model.Salary;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;

@Component
public class Accfund implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static Accfund m_Accfund;

	@PostConstruct 
	public void init(){
		m_Accfund=this;
		m_Accfund.dictionaryService=this.dictionaryService;
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

	private String Name = "";
	//名称
	public String getName(){
		return this.Name;
	}
	public void setName(String value){
		this.Name = value;
	}

}
