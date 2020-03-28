package org.polariscode.SecuritySystem.model.Import;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;

@Component
public class SitelinkmanImport implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static SitelinkmanImport m_SitelinkmanImport;

	@PostConstruct 
	public void init(){
		m_SitelinkmanImport=this;
		m_SitelinkmanImport.dictionaryService=this.dictionaryService;
	}

	private int ID = 0;
	public int getID(){
		return this.ID;
	}
	public void setID(int value){
		this.ID = value;
	}

	private int SiteID = 0;
	public int getSiteID(){
		return this.SiteID;
	}
	public void setSiteID(int value){
		this.SiteID = value;
	}

	private String Name = "";
	public String getName(){
		return this.Name;
	}
	public void setName(String value){
		this.Name = value;
	}

	private int Gender = 0;
	public int getGender(){
		return this.Gender;
	}
	public void setGender(int value){
		this.Gender = value;
	}

	private String Phone = "";
	public String getPhone(){
		return this.Phone;
	}
	public void setPhone(String value){
		this.Phone = value;
	}

	private String Wchat = "";
	public String getWchat(){
		return this.Wchat;
	}
	public void setWchat(String value){
		this.Wchat = value;
	}

	private String QQ = "";
	public String getQQ(){
		return this.QQ;
	}
	public void setQQ(String value){
		this.QQ = value;
	}

	private String Email = "";
	public String getEmail(){
		return this.Email;
	}
	public void setEmail(String value){
		this.Email = value;
	}

	private int Type = 0;
	public int getType(){
		return this.Type;
	}
	public void setType(int value){
		this.Type = value;
	}

}
