package org.polariscode.SecuritySystem.web.Base;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.polariscode.SecuritySystem.config.Global;
import org.polariscode.SecuritySystem.model.Result;
import org.polariscode.SecuritySystem.model.Permission.User;
import org.polariscode.SecuritySystem.config.WebConfig;
import org.polariscode.SecuritySystem.mapper.Permission.UserMapper;
import org.polariscode.SecuritySystem.mapper.Base.SiteMapper;
import org.polariscode.SecuritySystem.model.Table;
import org.springframework.transaction.annotation.Transactional;
import org.polariscode.SecuritySystem.model.Base.Site;

@RestController
public class SiteController{

	@Autowired
	private UserMapper m_UserMapper;

	@Autowired
	private SiteMapper m_SiteMapper;

	@RequestMapping(value = "/Base/Site/getAllSites", method = RequestMethod.POST)
	public Result getAllSites(String name, String city, String status, String orgid, String manager, int pageNumber, int pageSize) {
		Result result = new Result();
		String user = "";
		User u = new User();
		user = WebConfig.getUser();
		try{
			u = m_UserMapper.getUserOne(user);
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		try{
			result.setData(m_SiteMapper.getAllSites(name, city, status, orgid, manager, pageNumber<=0?0:(pageNumber-1)*pageSize, pageSize, u.getSiteOrg()));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		Table table = new Table();
		try{
			table = m_SiteMapper.getAllSitesCount(name, city, status, orgid, manager, u.getSiteOrg());
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

	//获取驻点人员清单
	@RequestMapping(value = "/Base/Site/getPersonnelBySite", method = RequestMethod.POST)
	public Result getPersonnelBySite(int siteid, java.util.Date begdate, java.util.Date enddate) {
		Result result = new Result();
		try{
			result.setData(m_SiteMapper.getPersonnelBySite(siteid, begdate, enddate));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	@RequestMapping(value = "/Base/Site/getSiteById", method = RequestMethod.POST)
	public Result getSiteById(int id) {
		Result result = new Result();
		try{
			result.setData(m_SiteMapper.getSiteById(id));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	@RequestMapping(value = "/Base/Site/updateSite", method = RequestMethod.POST)
	@Transactional
	public Result updateSite(@RequestBody Site site) {
		Result result = new Result();
		String user = "";
		user = WebConfig.getUser();
		if(site.getID()==0){
			site.setCreateUser(user);
			try{
				m_SiteMapper.insertSite(site);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
		}
		else{
			site.setModifyUser(user);
			try{
				m_SiteMapper.updateSite(site);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
		}
		return result;
	}

}
