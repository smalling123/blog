package org.polariscode.SecuritySystem.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.polariscode.SecuritySystem.config.Global;
import org.polariscode.SecuritySystem.model.Result;
import org.polariscode.SecuritySystem.model.Permission.User;
import org.polariscode.SecuritySystem.mapper.Permission.UserMapper;
import javax.annotation.Resource;
import org.polariscode.SecuritySystem.config.JwtConfig;
import org.polariscode.SecuritySystem.config.WebConfig;

@RestController
public class PermissionController{
	@Resource
	private JwtConfig jwtConfig;

	@Autowired
	private UserMapper m_UserMapper;

	//登录接口，生成Token
	@RequestMapping(value = "/Permission/login", method = RequestMethod.POST)
	public Result login(String LoginName, String Password) {
		Result result = new Result();
		User user = new User();
		try{
			user = m_UserMapper.getUserOne(LoginName);
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		if(user != null){
			if(user.getPassword().equalsIgnoreCase(Password)){
				user.setPassword("");
				result.setData(user);
				result.setToken(jwtConfig.getToken(user.getLoginName()));
			}
			else{
				result.setCode(-98);
				result.setMsg("密码错误！");
			}
		}
		else{
			result.setCode(-99);
			result.setMsg("用户名\""+LoginName+"\"不存在！");
		}
		return result;
	}

	@RequestMapping(value = "/Permission/ValidToken", method = RequestMethod.POST)
	public Result ValidToken(String token) {
		Result result = new Result();
		result.setData(WebConfig.getUser());
		result.setToken(jwtConfig.getToken(String.valueOf(result.getData())));
		return result;
	}

}
