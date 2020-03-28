package org.polariscode.SecuritySystem.model.ApplyFor;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;

@Component
public class Application implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static Application m_Application;

	@PostConstruct 
	public void init(){
		m_Application=this;
		m_Application.dictionaryService=this.dictionaryService;
	}

	private String Name = "";
	//姓名
	public String getName(){
		return this.Name;
	}
	public void setName(String value){
		this.Name = value;
	}

	private String Gender = "";
	//性别
	public String getGender(){
		return this.Gender;
	}
	public void setGender(String value){
		this.Gender = value;
	}

	private String CardNo = "";
	//身份证
	public String getCardNo(){
		return this.CardNo;
	}
	public void setCardNo(String value){
		this.CardNo = value;
	}

	private String Birthday = "";
	//生日
	public String getBirthday(){
		return this.Birthday;
	}
	public void setBirthday(String value){
		this.Birthday = value;
	}

	private String Address = "";
	//家庭住址
	public String getAddress(){
		return this.Address;
	}
	public void setAddress(String value){
		this.Address = value;
	}

	private String Fileimg1 = "";
	//身份证正面
	public String getFileimg1(){
		return this.Fileimg1;
	}
	public void setFileimg1(String value){
		this.Fileimg1 = value;
	}

	private String Fileimg2 = "";
	//身份证反面
	public String getFileimg2(){
		return this.Fileimg2;
	}
	public void setFileimg2(String value){
		this.Fileimg2 = value;
	}

}
