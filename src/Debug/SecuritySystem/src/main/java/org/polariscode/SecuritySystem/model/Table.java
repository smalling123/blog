package org.polariscode.SecuritySystem.model;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;

@Component
public class Table implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static Table m_Table;

	@PostConstruct 
	public void init(){
		m_Table=this;
		m_Table.dictionaryService=this.dictionaryService;
	}

	private int ID = 0;
	public int getID(){
		return this.ID;
	}
	public void setID(int value){
		this.ID = value;
	}

	private int Count = 0;
	public int getCount(){
		return this.Count;
	}
	public void setCount(int value){
		this.Count = value;
	}

}
