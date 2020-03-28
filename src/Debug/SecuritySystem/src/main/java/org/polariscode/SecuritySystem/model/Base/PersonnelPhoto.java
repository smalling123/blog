package org.polariscode.SecuritySystem.model.Base;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;

//照片
@Component
public class PersonnelPhoto implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static PersonnelPhoto m_PersonnelPhoto;

	@PostConstruct 
	public void init(){
		m_PersonnelPhoto=this;
		m_PersonnelPhoto.dictionaryService=this.dictionaryService;
	}

	private int ID = 0;
	public int getID(){
		return this.ID;
	}
	public void setID(int value){
		this.ID = value;
	}

	private int PersonnelID = 0;
	public int getPersonnelID(){
		return this.PersonnelID;
	}
	public void setPersonnelID(int value){
		this.PersonnelID = value;
	}

	private String PhotoName = "";
	//照片名称
	public String getPhotoName(){
		return this.PhotoName;
	}
	public void setPhotoName(String value){
		this.PhotoName = value;
	}

	private String PhotoUrl = "";
	//地址
	public String getPhotoUrl(){
		return this.PhotoUrl;
	}
	public void setPhotoUrl(String value){
		this.PhotoUrl = value;
	}

}
