package org.polariscode.SecuritySystem.model.Permission;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;

@Component
public class UserPwd implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static UserPwd m_UserPwd;

	@PostConstruct 
	public void init(){
		m_UserPwd=this;
		m_UserPwd.dictionaryService=this.dictionaryService;
	}

	private String oldPassword = "";
	//旧密码
	public String getoldPassword(){
		return this.oldPassword;
	}
	public void setoldPassword(String value){
		this.oldPassword = value;
	}

	private String newPassword = "";
	//新密码
	public String getnewPassword(){
		return this.newPassword;
	}
	public void setnewPassword(String value){
		this.newPassword = value;
	}

}
