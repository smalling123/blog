package org.polariscode.SecuritySystem.web.Permission;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.polariscode.SecuritySystem.config.Global;
import org.polariscode.SecuritySystem.model.Result;
import org.polariscode.SecuritySystem.mapper.Permission.UserMapper;
import org.springframework.transaction.annotation.Transactional;
import org.polariscode.SecuritySystem.model.Table;
import org.polariscode.SecuritySystem.model.Permission.User;
import org.polariscode.SecuritySystem.config.WebConfig;
import org.polariscode.SecuritySystem.model.Permission.UserPwd;

@RestController
public class UserController{

	@Autowired
	private UserMapper m_UserMapper;

	//移除用户的角色
	@RequestMapping(value = "/Permission/User/deleteUserRole", method = RequestMethod.POST)
	@Transactional
	public Result deleteUserRole(int userid, int orgroleid) {
		Result result = new Result();
		try{
			m_UserMapper.DeleteUserRole(userid, orgroleid);
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		//重置用户主岗
		try{
			m_UserMapper.UpdateUserRoleIsMain(userid);
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		return result;
	}

	//查询用户
	@RequestMapping(value = "/Permission/User/getAllUsers", method = RequestMethod.POST)
	public Result getAllUsers(int pageNumber, int pageSize, String loginName, String name) {
		Result result = new Result();
		try{
			result.setData(m_UserMapper.getAllUsers(pageNumber<=0?0:(pageNumber-1)*pageSize, pageSize, loginName, name));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		Table table = new Table();
		try{
			table = m_UserMapper.getUsersCount(loginName, name);
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		result.setRecordCount(table.getCount());
		result.setPageNumber(pageNumber);
		result.setPageSize(pageSize);
		return result;
	}

	//根据账号查询账号信息
	@RequestMapping(value = "/Permission/User/getUserByAccount", method = RequestMethod.POST)
	public Result getUserByAccount(String account) {
		Result result = new Result();
		try{
			result.setData(m_UserMapper.getUserByAccount(account));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	//根据Id查询账号信息
	@RequestMapping(value = "/Permission/User/getUserById", method = RequestMethod.POST)
	public Result getUserById(int id) {
		Result result = new Result();
		User user = new User();
		try{
			user = m_UserMapper.getUserById(id);
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		try{
			user.setRoles(m_UserMapper.getUserRoles(id));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		result.setData(user);
		return result;
	}

	@RequestMapping(value = "/Permission/User/getUserRoles", method = RequestMethod.POST)
	public Result getUserRoles(int id) {
		Result result = new Result();
		try{
			result.setData(m_UserMapper.getUserRoles(id));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	//为用户分配角色
	@RequestMapping(value = "/Permission/User/insertUserRole", method = RequestMethod.POST)
	@Transactional
	public Result insertUserRole(int userid, int orgroleid) {
		Result result = new Result();
		try{
			m_UserMapper.InsertUserRole(userid, orgroleid);
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		//重置用户主岗
		try{
			m_UserMapper.UpdateUserRoleIsMain(userid);
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		return result;
	}

	//修改密码
	@RequestMapping(value = "/Permission/User/updatePassword", method = RequestMethod.POST)
	public Result updatePassword(@RequestBody UserPwd pwd) {
		Result result = new Result();
		String account = "";
		account = WebConfig.getUser();
		Table table = new Table();
		try{
			table = m_UserMapper.getCountByAccountPwd(account, pwd.getoldPassword());
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		if(table.getCount()>0){
			Table user = new Table();
			try{
				user = m_UserMapper.getUIDByAccount(account);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				return result;
			}

			try{
				m_UserMapper.UpdatePassword(user.getID(), pwd.getnewPassword());
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				return result;
			}

			result.setMsg("修改成功！");
		}
		else{
			result.setCode(99);
			result.setMsg("旧密码错误！");
		}
		return result;
	}

	//修改用户信息
	@RequestMapping(value = "/Permission/User/updateUser", method = RequestMethod.POST)
	public Result updateUser(@RequestBody User user) {
		Result result = new Result();
		if(user.getID() == 0){
			try{
				m_UserMapper.InsertUser(user);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				return result;
			}

		}
		else{
			try{
				m_UserMapper.UpdateUser(user);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				return result;
			}

		}
		return result;
	}

}
