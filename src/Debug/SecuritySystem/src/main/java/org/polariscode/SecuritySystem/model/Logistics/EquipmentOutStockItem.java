package org.polariscode.SecuritySystem.model.Logistics;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;

@Component
public class EquipmentOutStockItem implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static EquipmentOutStockItem m_EquipmentOutStockItem;

	@PostConstruct 
	public void init(){
		m_EquipmentOutStockItem=this;
		m_EquipmentOutStockItem.dictionaryService=this.dictionaryService;
	}

	private int ID = 0;
	public int getID(){
		return this.ID;
	}
	public void setID(int value){
		this.ID = value;
	}

	private int EquipmentOutStockId = 0;
	public int getEquipmentOutStockId(){
		return this.EquipmentOutStockId;
	}
	public void setEquipmentOutStockId(int value){
		this.EquipmentOutStockId = value;
	}

	private int EquipmentId = 0;
	//装备
	public int getEquipmentId(){
		return this.EquipmentId;
	}
	public void setEquipmentId(int value){
		this.EquipmentId = value;
	}

	private String EquipmentId_Convert="";
	public String getEquipmentId_Convert(){
		EquipmentId_Convert = m_EquipmentOutStockItem.dictionaryService.convertDictionary("Equipment", String.valueOf(EquipmentId));
		if(EquipmentId_Convert == null) EquipmentId_Convert = "";
		return EquipmentId_Convert;
	}
	public void setEquipmentId_Convert(String value){
		this.EquipmentId_Convert = value;
	}

	private int Qty = 0;
	//数量
	public int getQty(){
		return this.Qty;
	}
	public void setQty(int value){
		this.Qty = value;
	}

	private String Describes = "";
	//备注
	public String getDescribes(){
		return this.Describes;
	}
	public void setDescribes(String value){
		this.Describes = value;
	}

	private String Name = "";
	//装备
	public String getName(){
		return this.Name;
	}
	public void setName(String value){
		this.Name = value;
	}

}
