package org.polariscode.SecuritySystem.web.ApplyFor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.polariscode.SecuritySystem.config.Global;
import org.polariscode.SecuritySystem.model.Result;
import org.polariscode.SecuritySystem.mapper.ApplyFor.DBWorkExperience;
import org.polariscode.SecuritySystem.model.Table;
import org.polariscode.SecuritySystem.model.ApplyFor.WorkExperience;

@RestController
public class WorkExperienceController{

	@Autowired
	private DBWorkExperience m_DBWorkExperience;

	//删除工作经历
	@RequestMapping(value = "/ApplyFor/WorkExperience/DeleteWork", method = RequestMethod.POST)
	public Result DeleteWork(int id) {
		Result result = new Result();
		try{
			m_DBWorkExperience.DeleteWorkExperience(id);
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	//查询所有工作记录
	@RequestMapping(value = "/ApplyFor/WorkExperience/getAllWorkExperience", method = RequestMethod.POST)
	public Result getAllWorkExperience(int pageNumber, int pageSize) {
		Result result = new Result();
		try{
			result.setData(m_DBWorkExperience.getAllWorkExperience(pageNumber<=0?0:(pageNumber-1)*pageSize, pageSize));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		Table table = new Table();
		try{
			table = m_DBWorkExperience.getWorkCount();
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

	//根据用户编号查询工作经历
	@RequestMapping(value = "/ApplyFor/WorkExperience/getWorkByEid", method = RequestMethod.POST)
	public Result getWorkByEid(int eid) {
		Result result = new Result();
		try{
			result.setData(m_DBWorkExperience.getWorkByEid(eid));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		Table table = new Table();
		try{
			table = m_DBWorkExperience.getCountByEid(eid);
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		result.setEinzelband(table.getCount());
		return result;
	}

	//根据ID查询工作经历
	@RequestMapping(value = "/ApplyFor/WorkExperience/getWorkById", method = RequestMethod.POST)
	public Result getWorkById(int id) {
		Result result = new Result();
		try{
			result.setData(m_DBWorkExperience.getWorkById(id));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	//添加、修改工作经历
	@RequestMapping(value = "/ApplyFor/WorkExperience/instUpWork", method = RequestMethod.POST)
	public Result instUpWork(@RequestBody WorkExperience work) {
		Result result = new Result();
		if(work.getId()==0){
			try{
				m_DBWorkExperience.InsertWorkExperience(work);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				return result;
			}

		}
		else{
			try{
				m_DBWorkExperience.UpdateWorkExperience(work);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				return result;
			}

		}
		return result;
	}

}
