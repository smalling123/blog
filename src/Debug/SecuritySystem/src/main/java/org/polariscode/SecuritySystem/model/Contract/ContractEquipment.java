package org.polariscode.SecuritySystem.model.Contract;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;

@Component
public class ContractEquipment implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static ContractEquipment m_ContractEquipment;

	@PostConstruct 
	public void init(){
		m_ContractEquipment=this;
		m_ContractEquipment.dictionaryService=this.dictionaryService;
	}

	private int ID = 0;
	public int getID(){
		return this.ID;
	}
	public void setID(int value){
		this.ID = value;
	}

	private int ContractId = 0;
	//合同ID
	public int getContractId(){
		return this.ContractId;
	}
	public void setContractId(int value){
		this.ContractId = value;
	}

	private String Equipment = "";
	//装备名称
	public String getEquipment(){
		return this.Equipment;
	}
	public void setEquipment(String value){
		this.Equipment = value;
	}

	private String Qty = "";
	//数量
	public String getQty(){
		return this.Qty;
	}
	public void setQty(String value){
		this.Qty = value;
	}

	private String Describes = "";
	//备注，描述
	public String getDescribes(){
		return this.Describes;
	}
	public void setDescribes(String value){
		this.Describes = value;
	}

	private boolean Isdelete = false;
	public boolean getIsdelete(){
		return this.Isdelete;
	}
	public void setIsdelete(boolean value){
		this.Isdelete = value;
	}

	private String CreateUser = "";
	public String getCreateUser(){
		return this.CreateUser;
	}
	public void setCreateUser(String value){
		this.CreateUser = value;
	}

	private String CreateTime = "";
	public String getCreateTime(){
		return this.CreateTime;
	}
	public void setCreateTime(String value){
		this.CreateTime = value;
	}

	private String ModifyUser = "";
	public String getModifyUser(){
		return this.ModifyUser;
	}
	public void setModifyUser(String value){
		this.ModifyUser = value;
	}

	private String ModifyTime = "";
	public String getModifyTime(){
		return this.ModifyTime;
	}
	public void setModifyTime(String value){
		this.ModifyTime = value;
	}

	private String DeleteUser = "";
	public String getDeleteUser(){
		return this.DeleteUser;
	}
	public void setDeleteUser(String value){
		this.DeleteUser = value;
	}

	private String DeleteTime = "";
	public String getDeleteTime(){
		return this.DeleteTime;
	}
	public void setDeleteTime(String value){
		this.DeleteTime = value;
	}

}
