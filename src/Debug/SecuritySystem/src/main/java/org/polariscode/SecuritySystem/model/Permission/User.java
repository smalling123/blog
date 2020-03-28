package org.polariscode.SecuritySystem.model.Permission;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;
import java.util.List;
import java.util.ArrayList;
import org.polariscode.SecuritySystem.model.Permission.OrgRole;

//系统用户
@Component
public class User implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static User m_User;

	@PostConstruct 
	public void init(){
		m_User=this;
		m_User.dictionaryService=this.dictionaryService;
	}

	private int ID = 0;
	public int getID(){
		return this.ID;
	}
	public void setID(int value){
		this.ID = value;
	}

	private String LoginName = "";
	//登录名
	public String getLoginName(){
		return this.LoginName;
	}
	public void setLoginName(String value){
		this.LoginName = value;
	}

	private String Name = "";
	//姓名
	public String getName(){
		return this.Name;
	}
	public void setName(String value){
		this.Name = value;
	}

	private String Password = "";
	//密码
	public String getPassword(){
		return this.Password;
	}
	public void setPassword(String value){
		this.Password = value;
	}

	private String Phone = "";
	//电话
	public String getPhone(){
		return this.Phone;
	}
	public void setPhone(String value){
		this.Phone = value;
	}

	private int Gender = 0;
	//性别
	public int getGender(){
		return this.Gender;
	}
	public void setGender(int value){
		this.Gender = value;
	}

	private String Gender_Convert="";
	public String getGender_Convert(){
		switch(String.valueOf(Gender)) {
		case "1":
			return "男";
		case "0":
			return "女";
		}
		return Gender_Convert;
	}
	public void setGender_Convert(String value){
		this.Gender_Convert = value;
	}

	private String Email = "";
	//Email
	public String getEmail(){
		return this.Email;
	}
	public void setEmail(String value){
		this.Email = value;
	}

	private String QQ = "";
	//QQ
	public String getQQ(){
		return this.QQ;
	}
	public void setQQ(String value){
		this.QQ = value;
	}

	private String Wechat = "";
	//微信
	public String getWechat(){
		return this.Wechat;
	}
	public void setWechat(String value){
		this.Wechat = value;
	}

	private String Address = "";
	//地址
	public String getAddress(){
		return this.Address;
	}
	public void setAddress(String value){
		this.Address = value;
	}

	private String Birthday = "";
	//生日
	public String getBirthday(){
		return this.Birthday;
	}
	public void setBirthday(String value){
		this.Birthday = value;
	}

	private String Describes = "";
	//备注
	public String getDescribes(){
		return this.Describes;
	}
	public void setDescribes(String value){
		this.Describes = value;
	}

	private int OrgID = 0;
	//部门ID
	public int getOrgID(){
		return this.OrgID;
	}
	public void setOrgID(int value){
		this.OrgID = value;
	}

	private String OrgName = "";
	//部门
	public String getOrgName(){
		return this.OrgName;
	}
	public void setOrgName(String value){
		this.OrgName = value;
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
			return "启用";
		case "1":
			return "禁用";
		}
		return Status_Convert;
	}
	public void setStatus_Convert(String value){
		this.Status_Convert = value;
	}

	private List<OrgRole> Roles = new ArrayList<OrgRole>();
	//拥有角色
	public List<OrgRole> getRoles(){
		return this.Roles;
	}
	public void setRoles(List<OrgRole> value){
		this.Roles = value;
	}

	private int SiteOrg = 0;
	public int getSiteOrg(){
		return this.SiteOrg;
	}
	public void setSiteOrg(int value){
		this.SiteOrg = value;
	}

}
