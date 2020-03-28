package org.polariscode.SecuritySystem.model.Base;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;

//客户信息
@Component
public class Customer implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static Customer m_Customer;

	@PostConstruct 
	public void init(){
		m_Customer=this;
		m_Customer.dictionaryService=this.dictionaryService;
	}

	private int ID = 0;
	public int getID(){
		return this.ID;
	}
	public void setID(int value){
		this.ID = value;
	}

	private String Name = "";
	//客户名称
	public String getName(){
		return this.Name;
	}
	public void setName(String value){
		this.Name = value;
	}

	private String ShortName = "";
	//简称
	public String getShortName(){
		return this.ShortName;
	}
	public void setShortName(String value){
		this.ShortName = value;
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
		OrgID_Convert = m_Customer.dictionaryService.convertDictionary("Org", String.valueOf(OrgID));
		if(OrgID_Convert == null) OrgID_Convert = "";
		return OrgID_Convert;
	}
	public void setOrgID_Convert(String value){
		this.OrgID_Convert = value;
	}

	private int Manager = 0;
	//项目经理
	public int getManager(){
		return this.Manager;
	}
	public void setManager(int value){
		this.Manager = value;
	}

	private String Manager_Convert="";
	public String getManager_Convert(){
		Manager_Convert = m_Customer.dictionaryService.convertDictionary("User", String.valueOf(Manager));
		if(Manager_Convert == null) Manager_Convert = "";
		return Manager_Convert;
	}
	public void setManager_Convert(String value){
		this.Manager_Convert = value;
	}

	private int Leader = 0;
	//分管领导
	public int getLeader(){
		return this.Leader;
	}
	public void setLeader(int value){
		this.Leader = value;
	}

	private String Leader_Convert="";
	public String getLeader_Convert(){
		Leader_Convert = m_Customer.dictionaryService.convertDictionary("User", String.valueOf(Leader));
		if(Leader_Convert == null) Leader_Convert = "";
		return Leader_Convert;
	}
	public void setLeader_Convert(String value){
		this.Leader_Convert = value;
	}

	private int District = 0;
	//所在城市
	public int getDistrict(){
		return this.District;
	}
	public void setDistrict(int value){
		this.District = value;
	}

	private String District_Convert="";
	public String getDistrict_Convert(){
		District_Convert = m_Customer.dictionaryService.convertDictionary("City", String.valueOf(District));
		if(District_Convert == null) District_Convert = "";
		return District_Convert;
	}
	public void setDistrict_Convert(String value){
		this.District_Convert = value;
	}

	private String Address = "";
	//地址
	public String getAddress(){
		return this.Address;
	}
	public void setAddress(String value){
		this.Address = value;
	}

	private String Describes = "";
	//备注
	public String getDescribes(){
		return this.Describes;
	}
	public void setDescribes(String value){
		this.Describes = value;
	}

	private int Type = 0;
	//客户类型
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
			return "商业物业";
		case "1":
			return "住宅小区";
		case "2":
			return "工厂";
		case "3":
			return "银行";
		case "4":
			return "医院";
		case "5":
			return "学校";
		case "9":
			return "其它";
		}
		return Type_Convert;
	}
	public void setType_Convert(String value){
		this.Type_Convert = value;
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
			return "新客户";
		case "1":
			return "已签约";
		case "2":
			return "未签约";
		case "3":
			return "老客户";
		case "4":
			return "已撤点";
		}
		return Status_Convert;
	}
	public void setStatus_Convert(String value){
		this.Status_Convert = value;
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
