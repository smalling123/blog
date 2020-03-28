package org.polariscode.SecuritySystem.model.Workflow;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;

//流程节点明细
@Component
public class WorkflowItem implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static WorkflowItem m_WorkflowItem;

	@PostConstruct 
	public void init(){
		m_WorkflowItem=this;
		m_WorkflowItem.dictionaryService=this.dictionaryService;
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

	private String Title = "";
	public String getTitle(){
		return this.Title;
	}
	public void setTitle(String value){
		this.Title = value;
	}

	private int UserID = 0;
	public int getUserID(){
		return this.UserID;
	}
	public void setUserID(int value){
		this.UserID = value;
	}

	private String UserName = "";
	public String getUserName(){
		return this.UserName;
	}
	public void setUserName(String value){
		this.UserName = value;
	}

	private String Content = "";
	public String getContent(){
		return this.Content;
	}
	public void setContent(String value){
		this.Content = value;
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

	private String Date = "";
	public String getDate(){
		return this.Date;
	}
	public void setDate(String value){
		this.Date = value;
	}

}
