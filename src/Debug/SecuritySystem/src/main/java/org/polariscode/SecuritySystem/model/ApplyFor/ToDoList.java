package org.polariscode.SecuritySystem.model.ApplyFor;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;

//代办表
@Component
public class ToDoList implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static ToDoList m_ToDoList;

	@PostConstruct 
	public void init(){
		m_ToDoList=this;
		m_ToDoList.dictionaryService=this.dictionaryService;
	}

	private int Id = 0;
	//序号
	public int getId(){
		return this.Id;
	}
	public void setId(int value){
		this.Id = value;
	}

	private String OwnerID = "";
	//待办所属角色
	public String getOwnerID(){
		return this.OwnerID;
	}
	public void setOwnerID(String value){
		this.OwnerID = value;
	}

	private String OwnerEn = "";
	//待办所属角色英文名
	public String getOwnerEn(){
		return this.OwnerEn;
	}
	public void setOwnerEn(String value){
		this.OwnerEn = value;
	}

	private String OwnerCn = "";
	//待办所属角色中文名
	public String getOwnerCn(){
		return this.OwnerCn;
	}
	public void setOwnerCn(String value){
		this.OwnerCn = value;
	}

	private int CreatorID = 0;
	//创建人
	public int getCreatorID(){
		return this.CreatorID;
	}
	public void setCreatorID(int value){
		this.CreatorID = value;
	}

	private String CreatorEn = "";
	//创建人英文名
	public String getCreatorEn(){
		return this.CreatorEn;
	}
	public void setCreatorEn(String value){
		this.CreatorEn = value;
	}

	private String CreatorCn = "";
	//创建人中文名
	public String getCreatorCn(){
		return this.CreatorCn;
	}
	public void setCreatorCn(String value){
		this.CreatorCn = value;
	}

	private int ApplicantID = 0;
	//提交人
	public int getApplicantID(){
		return this.ApplicantID;
	}
	public void setApplicantID(int value){
		this.ApplicantID = value;
	}

	private String ApplicantEn = "";
	//提交人英文名
	public String getApplicantEn(){
		return this.ApplicantEn;
	}
	public void setApplicantEn(String value){
		this.ApplicantEn = value;
	}

	private String ApplicantCn = "";
	//提交人中文名
	public String getApplicantCn(){
		return this.ApplicantCn;
	}
	public void setApplicantCn(String value){
		this.ApplicantCn = value;
	}

	private String Title = "";
	//流程任务标题
	public String getTitle(){
		return this.Title;
	}
	public void setTitle(String value){
		this.Title = value;
	}

	private int ApplicationNo = 0;
	//流程编号
	public int getApplicationNo(){
		return this.ApplicationNo;
	}
	public void setApplicationNo(int value){
		this.ApplicationNo = value;
	}

	private String ProcName = "";
	//流程名
	public String getProcName(){
		return this.ProcName;
	}
	public void setProcName(String value){
		this.ProcName = value;
	}

	private int Status = 0;
	//流程状态
	public int getStatus(){
		return this.Status;
	}
	public void setStatus(int value){
		this.Status = value;
	}

	private String CreatedDate = "";
	//创建时间
	public String getCreatedDate(){
		return this.CreatedDate;
	}
	public void setCreatedDate(String value){
		this.CreatedDate = value;
	}

	private String ModifiedDate = "";
	//修改时间
	public String getModifiedDate(){
		return this.ModifiedDate;
	}
	public void setModifiedDate(String value){
		this.ModifiedDate = value;
	}

	private String ActivityName = "";
	//流程节点名
	public String getActivityName(){
		return this.ActivityName;
	}
	public void setActivityName(String value){
		this.ActivityName = value;
	}

}
