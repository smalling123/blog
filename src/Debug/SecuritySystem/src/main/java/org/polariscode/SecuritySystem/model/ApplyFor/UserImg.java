package org.polariscode.SecuritySystem.model.ApplyFor;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;

@Component
public class UserImg implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static UserImg m_UserImg;

	@PostConstruct 
	public void init(){
		m_UserImg=this;
		m_UserImg.dictionaryService=this.dictionaryService;
	}

	private int Id = 0;
	//编号
	public int getId(){
		return this.Id;
	}
	public void setId(int value){
		this.Id = value;
	}

	private int UserID = 0;
	//用户ID
	public int getUserID(){
		return this.UserID;
	}
	public void setUserID(int value){
		this.UserID = value;
	}

	private int Eid = 0;
	//申请ID
	public int getEid(){
		return this.Eid;
	}
	public void setEid(int value){
		this.Eid = value;
	}

	private String Img = "";
	//图片
	public String getImg(){
		return this.Img;
	}
	public void setImg(String value){
		this.Img = value;
	}

	private String Type = "";
	//类型
	public String getType(){
		return this.Type;
	}
	public void setType(String value){
		this.Type = value;
	}

	private String Type_Convert="";
	public String getType_Convert(){
		switch(String.valueOf(Type)) {
		case "0":
			return "头像";
		case "1":
			return "身份证正面";
		case "2":
			return "身份证反面";
		case "3":
			return "保安员证";
		case "4":
			return "驾驶A证";
		case "5":
			return "驾驶B证";
		case "6":
			return "驾驶C证";
		case "7":
			return "建筑物消防员";
		case "8":
			return "五级保卫员证";
		case "9":
			return "四级保卫员证";
		case "10":
			return "三级保卫师证";
		case "11":
			return "二级保卫师证";
		case "12":
			return "一级保卫师证";
		}
		return Type_Convert;
	}
	public void setType_Convert(String value){
		this.Type_Convert = value;
	}

	private String Status = "";
	//状态
	public String getStatus(){
		return this.Status;
	}
	public void setStatus(String value){
		this.Status = value;
	}

	private java.util.Date CreateTime = null;
	//创建时间
	public java.util.Date getCreateTime(){
		return this.CreateTime;
	}
	public void setCreateTime(java.util.Date value){
		this.CreateTime = value;
	}

}
