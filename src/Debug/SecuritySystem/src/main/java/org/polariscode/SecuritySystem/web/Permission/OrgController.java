package org.polariscode.SecuritySystem.web.Permission;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.polariscode.SecuritySystem.config.Global;
import org.polariscode.SecuritySystem.model.Result;
import org.polariscode.SecuritySystem.mapper.Permission.OrgMapper;
import org.springframework.transaction.annotation.Transactional;
import org.polariscode.SecuritySystem.model.Permission.Org;

@RestController
public class OrgController{

	@Autowired
	private OrgMapper m_OrgMapper;

	//删除组织机构的角色
	@RequestMapping(value = "/Permission/Org/deleteOrgRole", method = RequestMethod.POST)
	@Transactional
	public Result deleteOrgRole(int orgid, int roleid) {
		Result result = new Result();
		//删除已分配给用户的角色（关联数据）
		try{
			m_OrgMapper.DeleteUserRole(orgid, roleid);
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		//删除分配给组机构的角色
		try{
			m_OrgMapper.DeleteOrgRole(orgid, roleid);
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		return result;
	}

	@RequestMapping(value = "/Permission/Org/getAllOrgRoles", method = RequestMethod.POST)
	public Result getAllOrgRoles() {
		Result result = new Result();
		try{
			result.setData(m_OrgMapper.getAllOrgRoles());
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	//根据ID获取组织机构对象
	@RequestMapping(value = "/Permission/Org/getOrgById", method = RequestMethod.POST)
	public Result getOrgById(int id) {
		Result result = new Result();
		Org org = new Org();
		try{
			org = m_OrgMapper.getOrgById(id);
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		try{
			org.setRoles(m_OrgMapper.getOrgRoles(id));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		result.setData(org);
		return result;
	}

	@RequestMapping(value = "/Permission/Org/getOrgRoles", method = RequestMethod.POST)
	public Result getOrgRoles(int id) {
		Result result = new Result();
		try{
			result.setData(m_OrgMapper.getOrgRoles(id));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	//获取组织机构清单
	@RequestMapping(value = "/Permission/Org/getOrgs", method = RequestMethod.POST)
	public Result getOrgs() {
		Result result = new Result();
		try{
			result.setData(OrgMapper.getOrgs(m_OrgMapper.m_getOrgs()));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	//根据ID获取指定层下面的所有组织机构清单
	@RequestMapping(value = "/Permission/Org/getOrgsByPid", method = RequestMethod.POST)
	public Result getOrgsByPid(int pid) {
		Result result = new Result();
		try{
			result.setData(m_OrgMapper.getOrgsByPid(pid));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	@RequestMapping(value = "/Permission/Org/getOrgTypes", method = RequestMethod.POST)
	public Result getOrgTypes() {
		Result result = new Result();
		try{
			result.setData(m_OrgMapper.getOrgTypes());
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	//为组织机构分配新的角色
	@RequestMapping(value = "/Permission/Org/insertOrgRole", method = RequestMethod.POST)
	public Result insertOrgRole(int orgid, int roleid) {
		Result result = new Result();
		try{
			m_OrgMapper.InsertOrgRole(orgid, roleid);
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	//更新组织机构信息
	@RequestMapping(value = "/Permission/Org/updateOrg", method = RequestMethod.POST)
	@Transactional
	public Result updateOrg(@RequestBody Org org) {
		Result result = new Result();
		if(org.getID() == 0){
			try{
				m_OrgMapper.InsertOrg(org);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
		}
		else{
			try{
				m_OrgMapper.UpdateOrg(org);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
		}
		return result;
	}

}
