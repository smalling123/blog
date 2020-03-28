package org.polariscode.SecuritySystem.model.System;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;

@Component
public class Bug implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static Bug m_Bug;

	@PostConstruct 
	public void init(){
		m_Bug=this;
		m_Bug.dictionaryService=this.dictionaryService;
	}

	private int ID = 0;
	//编号
	public int getID(){
		return this.ID;
	}
	public void setID(int value){
		this.ID = value;
	}

	private String ModuleName = "";
	//模块名称
	public String getModuleName(){
		return this.ModuleName;
	}
	public void setModuleName(String value){
		this.ModuleName = value;
	}

	private String Question = "";
	//问题描述
	public String getQuestion(){
		return this.Question;
	}
	public void setQuestion(String value){
		this.Question = value;
	}

	private int Type = 0;
	//类型
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
			return "Bug";
		case "1":
			return "新增需求";
		}
		return Type_Convert;
	}
	public void setType_Convert(String value){
		this.Type_Convert = value;
	}

	private int Level = 0;
	//等级
	public int getLevel(){
		return this.Level;
	}
	public void setLevel(int value){
		this.Level = value;
	}

	private String Level_Convert="";
	public String getLevel_Convert(){
		switch(String.valueOf(Level)) {
		case "0":
			return "一般";
		case "1":
			return "紧急";
		case "2":
			return "立即处理";
		case "3":
			return "可延迟处理";
		}
		return Level_Convert;
	}
	public void setLevel_Convert(String value){
		this.Level_Convert = value;
	}

	private String Finder = "";
	//发现者
	public String getFinder(){
		return this.Finder;
	}
	public void setFinder(String value){
		this.Finder = value;
	}

	private java.util.Date FindDate = null;
	//发现日期
	public java.util.Date getFindDate(){
		return this.FindDate;
	}
	public void setFindDate(java.util.Date value){
		this.FindDate = value;
	}

	private String Handler = "";
	//处理者
	public String getHandler(){
		return this.Handler;
	}
	public void setHandler(String value){
		this.Handler = value;
	}

	private java.util.Date EndTime = null;
	//预计完成日期
	public java.util.Date getEndTime(){
		return this.EndTime;
	}
	public void setEndTime(java.util.Date value){
		this.EndTime = value;
	}

	private int Status = 0;
	//状态
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
			return "未修改";
		case "1":
			return "修改中";
		case "2":
			return "已完成";
		case "3":
			return "无法处理";
		case "9":
			return "关闭";
		}
		return Status_Convert;
	}
	public void setStatus_Convert(String value){
		this.Status_Convert = value;
	}

	private String Description = "";
	//备注
	public String getDescription(){
		return this.Description;
	}
	public void setDescription(String value){
		this.Description = value;
	}

}
