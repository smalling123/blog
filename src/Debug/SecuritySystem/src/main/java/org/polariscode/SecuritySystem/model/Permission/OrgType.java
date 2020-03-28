package org.polariscode.SecuritySystem.model.Permission;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;

@Component
public class OrgType implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static OrgType m_OrgType;

	@PostConstruct 
	public void init(){
		m_OrgType=this;
		m_OrgType.dictionaryService=this.dictionaryService;
	}

	private int ID = 0;
	public int getID(){
		return this.ID;
	}
	public void setID(int value){
		this.ID = value;
	}

	private String Name = "";
	public String getName(){
		return this.Name;
	}
	public void setName(String value){
		this.Name = value;
	}

}
