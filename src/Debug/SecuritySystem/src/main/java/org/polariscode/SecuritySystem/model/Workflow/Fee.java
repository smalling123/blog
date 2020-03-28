package org.polariscode.SecuritySystem.model.Workflow;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;

//费用申请表
@Component
public class Fee implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static Fee m_Fee;

	@PostConstruct 
	public void init(){
		m_Fee=this;
		m_Fee.dictionaryService=this.dictionaryService;
	}

	private int ID = 0;
	public int getID(){
		return this.ID;
	}
	public void setID(int value){
		this.ID = value;
	}

	private int OrgID = 0;
	//所属部门
	public int getOrgID(){
		return this.OrgID;
	}
	public void setOrgID(int value){
		this.OrgID = value;
	}

	private String OrgID_Convert="";
	public String getOrgID_Convert(){
		OrgID_Convert = m_Fee.dictionaryService.convertDictionary("Org", String.valueOf(OrgID));
		if(OrgID_Convert == null) OrgID_Convert = "";
		return OrgID_Convert;
	}
	public void setOrgID_Convert(String value){
		this.OrgID_Convert = value;
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
		UserID_Convert = m_Fee.dictionaryService.convertDictionary("User", String.valueOf(UserID));
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

	private String CompanyId = "";
	//付款公司
	public String getCompanyId(){
		return this.CompanyId;
	}
	public void setCompanyId(String value){
		this.CompanyId = value;
	}

	private String CompanyId_Convert="";
	public String getCompanyId_Convert(){
		CompanyId_Convert = m_Fee.dictionaryService.convertDictionary("Company", String.valueOf(CompanyId));
		if(CompanyId_Convert == null) CompanyId_Convert = "";
		return CompanyId_Convert;
	}
	public void setCompanyId_Convert(String value){
		this.CompanyId_Convert = value;
	}

	private String Company = "";
	//收款公司/人
	public String getCompany(){
		return this.Company;
	}
	public void setCompany(String value){
		this.Company = value;
	}

	private String AccountName = "";
	//收款银行名称
	public String getAccountName(){
		return this.AccountName;
	}
	public void setAccountName(String value){
		this.AccountName = value;
	}

	private String Account = "";
	//银行账号
	public String getAccount(){
		return this.Account;
	}
	public void setAccount(String value){
		this.Account = value;
	}

	private int Site = 0;
	//涉及驻点
	public int getSite(){
		return this.Site;
	}
	public void setSite(int value){
		this.Site = value;
	}

	private String Site_Convert="";
	public String getSite_Convert(){
		Site_Convert = m_Fee.dictionaryService.convertDictionary("Site", String.valueOf(Site));
		if(Site_Convert == null) Site_Convert = "";
		return Site_Convert;
	}
	public void setSite_Convert(String value){
		this.Site_Convert = value;
	}

	private int Type = 0;
	//费用类型
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
			return "招待费";
		case "1":
			return "交通费";
		case "2":
			return "通讯费";
		case "3":
			return "办公用品采购";
		case "4":
			return "装备采购";
		case "5":
			return "房租";
		case "11":
			return "社保";
		case "12":
			return "公积金";
		case "13":
			return "残疾人保障金";
		case "14":
			return "经济补偿金";
		case "99":
			return "其它";
		}
		return Type_Convert;
	}
	public void setType_Convert(String value){
		this.Type_Convert = value;
	}

	private double Amt = 0.0;
	//金额
	public double getAmt(){
		return this.Amt;
	}
	public void setAmt(double value){
		this.Amt = value;
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
