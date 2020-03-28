package org.polariscode.SecuritySystem.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.polariscode.SecuritySystem.config.Global;
import org.polariscode.SecuritySystem.model.Result;
import org.polariscode.SecuritySystem.mapper.System.BugMapper;
import org.polariscode.SecuritySystem.model.Table;
import org.polariscode.SecuritySystem.model.System.Bug;

@RestController
public class SystemController{

	@Autowired
	private BugMapper m_BugMapper;

	@RequestMapping(value = "/System/getBug", method = RequestMethod.POST)
	public Result getBug(String handler, String modulename, String question, String type, String level, String status, int pageNumber, int pageSize) {
		Result result = new Result();
		try{
			result.setData(m_BugMapper.getBug(pageNumber<=0?0:(pageNumber-1)*pageSize, pageSize, handler, modulename, question, type, level, status));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		Table table = new Table();
		try{
			table = m_BugMapper.getBugCount(handler, modulename, question, type, level, status);
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

	//根据ID查询Bug信息
	@RequestMapping(value = "/System/getBugById", method = RequestMethod.POST)
	public Result getBugById(int id) {
		Result result = new Result();
		try{
			result.setData(m_BugMapper.getBugById(id));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	//添加修改Bug信息
	@RequestMapping(value = "/System/InstUpBug", method = RequestMethod.POST)
	public Result InstUpBug(@RequestBody Bug bug) {
		Result result = new Result();
		if(bug.getID()==0){
			//添加Bug信息
			try{
				m_BugMapper.insertBug(bug);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				return result;
			}

		}
		else{
			//修改Bug信息
			try{
				m_BugMapper.updateBug(bug);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				return result;
			}

		}
		return result;
	}

}
