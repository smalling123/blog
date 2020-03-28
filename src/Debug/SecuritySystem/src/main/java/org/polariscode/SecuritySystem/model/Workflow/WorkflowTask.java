package org.polariscode.SecuritySystem.model.Workflow;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;

//待办任务
@Component
public class WorkflowTask implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static WorkflowTask m_WorkflowTask;

	@PostConstruct 
	public void init(){
		m_WorkflowTask=this;
		m_WorkflowTask.dictionaryService=this.dictionaryService;
	}

	private int ID = 0;
	public int getID(){
		return this.ID;
	}
	public void setID(int value){
		this.ID = value;
	}

	private int WID = 0;
	public int getWID(){
		return this.WID;
	}
	public void setWID(int value){
		this.WID = value;
	}

	private String Name = "";
	public String getName(){
		return this.Name;
	}
	public void setName(String value){
		this.Name = value;
	}

	private String UserName = "";
	public String getUserName(){
		return this.UserName;
	}
	public void setUserName(String value){
		this.UserName = value;
	}

	private String Date = "";
	public String getDate(){
		return this.Date;
	}
	public void setDate(String value){
		this.Date = value;
	}

	private int Status = 0;
	public int getStatus(){
		return this.Status;
	}
	public void setStatus(int value){
		this.Status = value;
	}

	private String Status_Convert="";
	public String getStatus_Convert(){
		switch(String.valueOf(Status)) {
		case "0":
			return "未审核";
		case "1":
			return "同意";
		case "2":
			return "不同意";
		}
		return Status_Convert;
	}
	public void setStatus_Convert(String value){
		this.Status_Convert = value;
	}

	private String WebEditUrl = "";
	public String getWebEditUrl(){
		return this.WebEditUrl;
	}
	public void setWebEditUrl(String value){
		this.WebEditUrl = value;
	}

	private String WebViewUrl = "";
	public String getWebViewUrl(){
		return this.WebViewUrl;
	}
	public void setWebViewUrl(String value){
		this.WebViewUrl = value;
	}

	private String AppEditUrl = "";
	public String getAppEditUrl(){
		return this.AppEditUrl;
	}
	public void setAppEditUrl(String value){
		this.AppEditUrl = value;
	}

	private String AppViewUrl = "";
	public String getAppViewUrl(){
		return this.AppViewUrl;
	}
	public void setAppViewUrl(String value){
		this.AppViewUrl = value;
	}

	private int DataID = 0;
	public int getDataID(){
		return this.DataID;
	}
	public void setDataID(int value){
		this.DataID = value;
	}

	private int WStatus = 0;
	public int getWStatus(){
		return this.WStatus;
	}
	public void setWStatus(int value){
		this.WStatus = value;
	}

	private String WStatus_Convert="";
	public String getWStatus_Convert(){
		switch(String.valueOf(WStatus)) {
		case "0":
			return "审核中";
		case "1":
			return "审核通过";
		case "2":
			return "不通过";
		}
		return WStatus_Convert;
	}
	public void setWStatus_Convert(String value){
		this.WStatus_Convert = value;
	}

}
