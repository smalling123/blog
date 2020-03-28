package org.polariscode.SecuritySystem.model.Workflow;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;

//印鉴申请表
@Component
public class Seal implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static Seal m_Seal;

	@PostConstruct 
	public void init(){
		m_Seal=this;
		m_Seal.dictionaryService=this.dictionaryService;
	}

	private int ID = 0;
	public int getID(){
		return this.ID;
	}
	public void setID(int value){
		this.ID = value;
	}

	private int OrgID = 0;
	public int getOrgID(){
		return this.OrgID;
	}
	public void setOrgID(int value){
		this.OrgID = value;
	}

	private int UserID = 0;
	//申请人
	public int getUserID(){
		return this.UserID;
	}
	public void setUserID(int value){
		this.UserID = value;
	}

	private String UserID_Convert="";
	public String getUserID_Convert(){
		UserID_Convert = m_Seal.dictionaryService.convertDictionary("User", String.valueOf(UserID));
		if(UserID_Convert == null) UserID_Convert = "";
		return UserID_Convert;
	}
	public void setUserID_Convert(String value){
		this.UserID_Convert = value;
	}

	private java.util.Date Date = null;
	//申请日期
	public java.util.Date getDate(){
		return this.Date;
	}
	public void setDate(java.util.Date value){
		this.Date = value;
	}

	private String Content = "";
	//申请内容
	public String getContent(){
		return this.Content;
	}
	public void setContent(String value){
		this.Content = value;
	}

	private int Type = 0;
	//申请类型
	public int getType(){
		return this.Type;
	}
	public void setType(int value){
		this.Type = value;
	}

	private String Type_Convert="";
	public String getType_Convert(){
		switch(String.valueOf(Type)) {
		case "0":
			return "业务用章申请";
		case "1":
			return "行政用章申请";
		}
		return Type_Convert;
	}
	public void setType_Convert(String value){
		this.Type_Convert = value;
	}

	private int SealType = 0;
	//用章类型
	public int getSealType(){
		return this.SealType;
	}
	public void setSealType(int value){
		this.SealType = value;
	}

	private String SealType_Convert="";
	public String getSealType_Convert(){
		switch(String.valueOf(SealType)) {
		case "0":
			return "公章";
		case "1":
			return "合同章";
		case "2":
			return "人事章";
		case "3":
			return "财务章";
		case "4":
			return "法人章";
		}
		return SealType_Convert;
	}
	public void setSealType_Convert(String value){
		this.SealType_Convert = value;
	}

	private boolean W1 = false;
	//公章
	public boolean getW1(){
		return this.W1;
	}
	public void setW1(boolean value){
		this.W1 = value;
	}

	private boolean W2 = false;
	//合同章
	public boolean getW2(){
		return this.W2;
	}
	public void setW2(boolean value){
		this.W2 = value;
	}

	private boolean W3 = false;
	//人事章
	public boolean getW3(){
		return this.W3;
	}
	public void setW3(boolean value){
		this.W3 = value;
	}

	private boolean W4 = false;
	//财务章
	public boolean getW4(){
		return this.W4;
	}
	public void setW4(boolean value){
		this.W4 = value;
	}

	private boolean W5 = false;
	//法人章
	public boolean getW5(){
		return this.W5;
	}
	public void setW5(boolean value){
		this.W5 = value;
	}

	private boolean W6 = false;
	//营业执照正本
	public boolean getW6(){
		return this.W6;
	}
	public void setW6(boolean value){
		this.W6 = value;
	}

	private boolean W7 = false;
	//营业执照副本
	public boolean getW7(){
		return this.W7;
	}
	public void setW7(boolean value){
		this.W7 = value;
	}

	private boolean W8 = false;
	//银行开户证正本
	public boolean getW8(){
		return this.W8;
	}
	public void setW8(boolean value){
		this.W8 = value;
	}

	private boolean W9 = false;
	//银行开户证副本
	public boolean getW9(){
		return this.W9;
	}
	public void setW9(boolean value){
		this.W9 = value;
	}

	private boolean W10 = false;
	//其它
	public boolean getW10(){
		return this.W10;
	}
	public void setW10(boolean value){
		this.W10 = value;
	}

	private boolean W11 = false;
	public boolean getW11(){
		return this.W11;
	}
	public void setW11(boolean value){
		this.W11 = value;
	}

	private String Other = "";
	//其它
	public String getOther(){
		return this.Other;
	}
	public void setOther(String value){
		this.Other = value;
	}

	private int WorkflowID = 0;
	public int getWorkflowID(){
		return this.WorkflowID;
	}
	public void setWorkflowID(int value){
		this.WorkflowID = value;
	}

	private String File1 = "";
	//附件
	public String getFile1(){
		return this.File1;
	}
	public void setFile1(String value){
		this.File1 = value;
	}

}
