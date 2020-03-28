package org.polariscode.SecuritySystem.model.Workflow;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;
import java.util.List;
import java.util.ArrayList;
import org.polariscode.SecuritySystem.model.Workflow.ExpensesItems;

//报销申请表
@Component
public class Expenses implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static Expenses m_Expenses;

	@PostConstruct 
	public void init(){
		m_Expenses=this;
		m_Expenses.dictionaryService=this.dictionaryService;
	}

	private int ID = 0;
	public int getID(){
		return this.ID;
	}
	public void setID(int value){
		this.ID = value;
	}

	private int OrgID = 0;
	//部门
	public int getOrgID(){
		return this.OrgID;
	}
	public void setOrgID(int value){
		this.OrgID = value;
	}

	private String OrgID_Convert="";
	public String getOrgID_Convert(){
		OrgID_Convert = m_Expenses.dictionaryService.convertDictionary("Org", String.valueOf(OrgID));
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
		UserID_Convert = m_Expenses.dictionaryService.convertDictionary("User", String.valueOf(UserID));
		if(UserID_Convert == null) UserID_Convert = "";
		return UserID_Convert;
	}
	public void setUserID_Convert(String value){
		this.UserID_Convert = value;
	}

	private int ExUserID = 0;
	//报销人
	public int getExUserID(){
		return this.ExUserID;
	}
	public void setExUserID(int value){
		this.ExUserID = value;
	}

	private String ExUserID_Convert="";
	public String getExUserID_Convert(){
		ExUserID_Convert = m_Expenses.dictionaryService.convertDictionary("User", String.valueOf(ExUserID));
		if(ExUserID_Convert == null) ExUserID_Convert = "";
		return ExUserID_Convert;
	}
	public void setExUserID_Convert(String value){
		this.ExUserID_Convert = value;
	}

	private String Date = "";
	//日期
	public String getDate(){
		return this.Date;
	}
	public void setDate(String value){
		this.Date = value;
	}

	private String Content = "";
	//备注
	public String getContent(){
		return this.Content;
	}
	public void setContent(String value){
		this.Content = value;
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
		Site_Convert = m_Expenses.dictionaryService.convertDictionary("Site", String.valueOf(Site));
		if(Site_Convert == null) Site_Convert = "";
		return Site_Convert;
	}
	public void setSite_Convert(String value){
		this.Site_Convert = value;
	}

	private double Amt = 0.0;
	//报销金额
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

	private List<ExpensesItems> Items = new ArrayList<ExpensesItems>();
	public List<ExpensesItems> getItems(){
		return this.Items;
	}
	public void setItems(List<ExpensesItems> value){
		this.Items = value;
	}

}
