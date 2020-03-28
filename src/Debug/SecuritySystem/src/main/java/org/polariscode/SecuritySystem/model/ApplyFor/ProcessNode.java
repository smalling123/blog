package org.polariscode.SecuritySystem.model.ApplyFor;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;

//流程节点表
@Component
public class ProcessNode implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static ProcessNode m_ProcessNode;

	@PostConstruct 
	public void init(){
		m_ProcessNode=this;
		m_ProcessNode.dictionaryService=this.dictionaryService;
	}

	private int Id = 0;
	//序号
	public int getId(){
		return this.Id;
	}
	public void setId(int value){
		this.Id = value;
	}

	private String ProcessName = "";
	//流程名
	public String getProcessName(){
		return this.ProcessName;
	}
	public void setProcessName(String value){
		this.ProcessName = value;
	}

	private String ProcessNode = "";
	//流程节点名
	public String getProcessNode(){
		return this.ProcessNode;
	}
	public void setProcessNode(String value){
		this.ProcessNode = value;
	}

	private String ProcessNo = "";
	//流程序号
	public String getProcessNo(){
		return this.ProcessNo;
	}
	public void setProcessNo(String value){
		this.ProcessNo = value;
	}

	private String ProcessRole = "";
	//流程角色
	public String getProcessRole(){
		return this.ProcessRole;
	}
	public void setProcessRole(String value){
		this.ProcessRole = value;
	}

	private String ProcessRole_Convert="";
	public String getProcessRole_Convert(){
		ProcessRole_Convert = m_ProcessNode.dictionaryService.convertDictionary("Org", String.valueOf(ProcessRole));
		if(ProcessRole_Convert == null) ProcessRole_Convert = "";
		return ProcessRole_Convert;
	}
	public void setProcessRole_Convert(String value){
		this.ProcessRole_Convert = value;
	}

	private int Order = 0;
	//排序号
	public int getOrder(){
		return this.Order;
	}
	public void setOrder(int value){
		this.Order = value;
	}

}
