package org.polariscode.SecuritySystem.web.Permission;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.polariscode.SecuritySystem.config.Global;
import org.polariscode.SecuritySystem.model.Result;
import org.polariscode.SecuritySystem.mapper.Permission.MenuMapper;
import org.polariscode.SecuritySystem.config.WebConfig;
import org.polariscode.SecuritySystem.model.Permission.Menu;

@RestController
public class MenuController{

	@Autowired
	private MenuMapper m_MenuMapper;

	//删除菜单
	@RequestMapping(value = "/Permission/Menu/DeleteMenu", method = RequestMethod.POST)
	public Result DeleteMenu(int id) {
		Result result = new Result();
		try{
			m_MenuMapper.DeleteMenu(id);
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		try{
			m_MenuMapper.DeleteMenuByPID(id);
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	@RequestMapping(value = "/Permission/Menu/getAllMenus", method = RequestMethod.POST)
	public Result getAllMenus() {
		Result result = new Result();
		try{
			result.setData(MenuMapper.getAllMenus(m_MenuMapper.m_getAllMenus()));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	@RequestMapping(value = "/Permission/Menu/getMenuById", method = RequestMethod.POST)
	public Result getMenuById(int id) {
		Result result = new Result();
		try{
			result.setData(m_MenuMapper.getMenuById(id));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	@RequestMapping(value = "/Permission/Menu/getMenuByPid", method = RequestMethod.POST)
	public Result getMenuByPid(int pid) {
		Result result = new Result();
		try{
			result.setData(m_MenuMapper.getMenuByPID(pid));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	@RequestMapping(value = "/Permission/Menu/getMenus", method = RequestMethod.POST)
	public Result getMenus() {
		Result result = new Result();
		try{
			result.setData(MenuMapper.getMenus(m_MenuMapper.m_getMenus()));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	@RequestMapping(value = "/Permission/Menu/getUserMenus", method = RequestMethod.POST)
	public Result getUserMenus() {
		Result result = new Result();
		String loginName = "";
		loginName = WebConfig.getUser();
		try{
			result.setData(MenuMapper.getUserMenus(m_MenuMapper.m_getUserMenus(loginName)));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	//添加、修改菜单
	@RequestMapping(value = "/Permission/Menu/instUpMenu", method = RequestMethod.POST)
	public Result instUpMenu(@RequestBody Menu menu) {
		Result result = new Result();
		if(menu.getID()==0){
			try{
				m_MenuMapper.InsertMenu(menu);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				return result;
			}

		}
		else{
			try{
				m_MenuMapper.UpdateMenu(menu);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				return result;
			}

		}
		return result;
	}

}
