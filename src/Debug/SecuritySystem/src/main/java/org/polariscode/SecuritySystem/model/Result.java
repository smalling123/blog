package org.polariscode.SecuritySystem.model;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;

@Component
public class Result implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static Result m_Result;

	@PostConstruct 
	public void init(){
		m_Result=this;
		m_Result.dictionaryService=this.dictionaryService;
	}

	private int Code = 0;
	//返回编号
	public int getCode(){
		return this.Code;
	}
	public void setCode(int value){
		this.Code = value;
	}

	private String Msg = "";
	//错误消息
	public String getMsg(){
		return this.Msg;
	}
	public void setMsg(String value){
		this.Msg = value;
	}

	private String Token = "";
	//Token
	public String getToken(){
		return this.Token;
	}
	public void setToken(String value){
		this.Token = value;
	}

	private Object Data = null;
	//返回内容
	public Object getData(){
		return this.Data;
	}
	public void setData(Object value){
		this.Data = value;
	}

	private int PageNumber = 0;
	//页码
	public int getPageNumber(){
		return this.PageNumber;
	}
	public void setPageNumber(int value){
		this.PageNumber = value;
	}

	private int PageSize = 0;
	//每页大小
	public int getPageSize(){
		return this.PageSize;
	}
	public void setPageSize(int value){
		this.PageSize = value;
	}

	private int RecordCount = 0;
	//总记录数
	public int getRecordCount(){
		return this.RecordCount;
	}
	public void setRecordCount(int value){
		this.RecordCount = value;
	}

	private int Einzelband = 0;
	public int getEinzelband(){
		return this.Einzelband;
	}
	public void setEinzelband(int value){
		this.Einzelband = value;
	}

	private String Characters = "";
	public String getCharacters(){
		return this.Characters;
	}
	public void setCharacters(String value){
		this.Characters = value;
	}

}
