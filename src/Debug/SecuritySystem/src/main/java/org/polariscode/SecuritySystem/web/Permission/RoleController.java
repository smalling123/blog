package org.polariscode.SecuritySystem.web.Permission;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.polariscode.SecuritySystem.config.Global;
import org.polariscode.SecuritySystem.model.Result;
import org.polariscode.SecuritySystem.mapper.Permission.RoleMapper;
import org.polariscode.SecuritySystem.model.Table;
import org.polariscode.SecuritySystem.model.Permission.Role;
import org.polariscode.SecuritySystem.mapper.DBMapper;
import org.springframework.transaction.annotation.Transactional;

@RestController
public class RoleController{

	@Autowired
	private RoleMapper m_RoleMapper;

	@Autowired
	private DBMapper m_DBMapper;

	//获取所有角色清单
	@RequestMapping(value = "/Permission/Role/getAllRoles", method = RequestMethod.POST)
	public Result getAllRoles(int pageNumber, int pageSize) {
		Result result = new Result();
		try{
			result.setData(m_RoleMapper.getAllRoles(pageNumber==0?0:(pageNumber-1)*pageSize, pageSize));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		Table table = new Table();
		try{
			table = m_RoleMapper.getRolesCount();
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

	//根据ID获取角色对象
	@RequestMapping(value = "/Permission/Role/getRoleById", method = RequestMethod.POST)
	public Result getRoleById(int id) {
		Result result = new Result();
		Role role = new Role();
		try{
			role = m_RoleMapper.getRoleById(id);
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		try{
			role.setMenus(m_RoleMapper.getRoleMenu(id));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		result.setData(role);
		return result;
	}

	//获取角色清单
	@RequestMapping(value = "/Permission/Role/getRoles", method = RequestMethod.POST)
	public Result getRoles() {
		Result result = new Result();
		try{
			result.setData(m_RoleMapper.getRoles());
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	@RequestMapping(value = "/Permission/Role/updateRole", method = RequestMethod.POST)
	@Transactional
	public Result updateRole(@RequestBody Role role) {
		Result result = new Result();
		int roleid = role.getID();
		if(role.getID() == 0){
			try{
				m_RoleMapper.InsertRole(role);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
			Table table = new Table();
			try{
				table = m_DBMapper.getTableID();
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
			roleid = table.getID();
		}
		else{
			try{
				m_RoleMapper.UpdateRole(role);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
			try{
				m_RoleMapper.DeleteRoleMenu(role.getID());
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
		}
		if(role.getMenus().size() > 0){
			try{
				if(role.getMenus().size()>0){
					m_RoleMapper.InsertRoleMenu(role.getMenus(), roleid);
				}
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
		}
		return result;
	}

}
