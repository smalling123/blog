package org.polariscode.SecuritySystem.web.Base;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.polariscode.SecuritySystem.config.Global;
import org.polariscode.SecuritySystem.model.Result;
import org.polariscode.SecuritySystem.model.Base.SitePost;
import org.polariscode.SecuritySystem.mapper.Base.SitePostMapper;
import org.polariscode.SecuritySystem.config.WebConfig;
import org.springframework.transaction.annotation.Transactional;

@RestController
public class SitePostController{

	@Autowired
	private SitePostMapper m_SitePostMapper;

	@RequestMapping(value = "/Base/SitePost/getEditSitePost", method = RequestMethod.POST)
	@Transactional
	public Result getEditSitePost(int siteid) {
		Result result = new Result();
		SitePost sp = new SitePost();
		//获取未发布的执勤配置表
		try{
			sp = m_SitePostMapper.getEditSitePostI(siteid);
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		if(sp == null){
			String user = "";
			//获取登录用户名
			user = WebConfig.getUser();
			//生成新的执勤表数据
			try{
				m_SitePostMapper.createEditSitePost(siteid, user);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
			try{
				sp = m_SitePostMapper.getEditSitePostI(siteid);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
		}
		try{
			sp.setItems(m_SitePostMapper.getSitePostItem(sp.getID()));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		result.setData(sp);
		return result;
	}

	@RequestMapping(value = "/Base/SitePost/getSitePost", method = RequestMethod.POST)
	public Result getSitePost(int siteid) {
		Result result = new Result();
		try{
			result.setData(m_SitePostMapper.getSitePost(siteid));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	@RequestMapping(value = "/Base/SitePost/getSitePostItems", method = RequestMethod.POST)
	public Result getSitePostItems(int id) {
		Result result = new Result();
		try{
			result.setData(m_SitePostMapper.getSitePostItem(id));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	//更新执勤配置表
	@RequestMapping(value = "/Base/SitePost/updateSitePost", method = RequestMethod.POST)
	@Transactional
	public Result updateSitePost(@RequestBody SitePost sitepost) {
		Result result = new Result();
		SitePost sp = new SitePost();
		//判断执勤配置是否发布
		if(sitepost.getStatus()){
			//获取最新一个发布的版本，赋值给sp
			try{
				sp = m_SitePostMapper.getLastSitePost(sitepost.getSiteId());
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
			//判断sp不为空
			if(sp!=null){
				//sp开始日期大于等于提交的开始日期 
				if(sp.getBeginDate().compareTo(sitepost.getBeginDate())>=0){
					result.setCode(99);
					result.setMsg("开始日期不能早于上一个版本的开始日期！");
					return result;
				}
				else{
					try{
						m_SitePostMapper.updateSitePostEndDate(sp.getID(), sitepost.getBeginDate());
					}catch(Exception error){
						result.setCode(error.hashCode());
						result.setMsg(error.getMessage());
						throw error;
					}
				}
			}
		}
		try{
			m_SitePostMapper.updateSitePost(sitepost);
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		try{
			m_SitePostMapper.deleteSitePostItem(sitepost.getID());
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		try{
			if(sitepost.getItems().size()>0){
				m_SitePostMapper.insertSitePostItem(sitepost.getItems(), sitepost.getID());
			}
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		return result;
	}

}
