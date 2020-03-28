package org.polariscode.SecuritySystem.model.Office;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;

@Component
public class StaffMembers implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static StaffMembers m_StaffMembers;

	@PostConstruct 
	public void init(){
		m_StaffMembers=this;
		m_StaffMembers.dictionaryService=this.dictionaryService;
	}

	private int ID = 0;
	public int getID(){
		return this.ID;
	}
	public void setID(int value){
		this.ID = value;
	}

	private int StaffID = 0;
	public int getStaffID(){
		return this.StaffID;
	}
	public void setStaffID(int value){
		this.StaffID = value;
	}

	private String Name = "";
	//姓名
	public String getName(){
		return this.Name;
	}
	public void setName(String value){
		this.Name = value;
	}

	private String Appellation = "";
	//关系
	public String getAppellation(){
		return this.Appellation;
	}
	public void setAppellation(String value){
		this.Appellation = value;
	}

	private String Appellation_Convert="";
	public String getAppellation_Convert(){
		switch(String.valueOf(Appellation)) {
		case "0":
			return "父";
		case "1":
			return "母";
		case "2":
			return "配偶";
		case "3":
			return "子女";
		case "4":
			return "兄弟";
		case "5":
			return "姐妹";
		case "6":
			return "其它";
		}
		return Appellation_Convert;
	}
	public void setAppellation_Convert(String value){
		this.Appellation_Convert = value;
	}

	private String Age = "";
	//年龄
	public String getAge(){
		return this.Age;
	}
	public void setAge(String value){
		this.Age = value;
	}

	private String Company = "";
	//工作单位
	public String getCompany(){
		return this.Company;
	}
	public void setCompany(String value){
		this.Company = value;
	}

	private String Post = "";
	//职务
	public String getPost(){
		return this.Post;
	}
	public void setPost(String value){
		this.Post = value;
	}

	private String Phone = "";
	//电话
	public String getPhone(){
		return this.Phone;
	}
	public void setPhone(String value){
		this.Phone = value;
	}

}
