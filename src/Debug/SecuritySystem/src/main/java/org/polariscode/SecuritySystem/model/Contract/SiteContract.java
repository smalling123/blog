package org.polariscode.SecuritySystem.model.Contract;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;

@Component
public class SiteContract implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static SiteContract m_SiteContract;

	@PostConstruct 
	public void init(){
		m_SiteContract=this;
		m_SiteContract.dictionaryService=this.dictionaryService;
	}

	private int ID = 0;
	public int getID(){
		return this.ID;
	}
	public void setID(int value){
		this.ID = value;
	}

	private int SiteId = 0;
	public int getSiteId(){
		return this.SiteId;
	}
	public void setSiteId(int value){
		this.SiteId = value;
	}

	private int ContractId = 0;
	public int getContractId(){
		return this.ContractId;
	}
	public void setContractId(int value){
		this.ContractId = value;
	}

}
