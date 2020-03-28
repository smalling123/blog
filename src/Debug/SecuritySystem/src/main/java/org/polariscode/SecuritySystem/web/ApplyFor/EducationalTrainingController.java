package org.polariscode.SecuritySystem.web.ApplyFor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.polariscode.SecuritySystem.config.Global;
import org.polariscode.SecuritySystem.model.Result;
import org.polariscode.SecuritySystem.mapper.ApplyFor.DBEducationalTraining;
import org.polariscode.SecuritySystem.model.Table;
import org.polariscode.SecuritySystem.model.ApplyFor.EducationalTraining;

@RestController
public class EducationalTrainingController{

	@Autowired
	private DBEducationalTraining m_DBEducationalTraining;

	//删除工作经历
	@RequestMapping(value = "/ApplyFor/EducationalTraining/DeleteEducational", method = RequestMethod.POST)
	public Result DeleteEducational(int id) {
		Result result = new Result();
		try{
			m_DBEducationalTraining.DeleteEducational(id);
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	//查询所有教育培训
	@RequestMapping(value = "/ApplyFor/EducationalTraining/getAllEducational", method = RequestMethod.POST)
	public Result getAllEducational(int pageNumber, int pageSize) {
		Result result = new Result();
		try{
			result.setData(m_DBEducationalTraining.getAllEducational(pageNumber<=0?0:(pageNumber-1)*pageSize, pageSize));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		Table table = new Table();
		try{
			table = m_DBEducationalTraining.getEducationalCount();
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

	//根据员工编号查询教育经历
	@RequestMapping(value = "/ApplyFor/EducationalTraining/getEducationalByEId", method = RequestMethod.POST)
	public Result getEducationalByEId(int eid) {
		Result result = new Result();
		try{
			result.setData(m_DBEducationalTraining.getEducationalByEId(eid));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		Table table = new Table();
		try{
			table = m_DBEducationalTraining.getCountByEid(eid);
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		result.setEinzelband(table.getCount());
		return result;
	}

	//根据Id查询教育信息
	@RequestMapping(value = "/ApplyFor/EducationalTraining/getEducationalById", method = RequestMethod.POST)
	public Result getEducationalById(int id) {
		Result result = new Result();
		try{
			result.setData(m_DBEducationalTraining.getEducationalById(id));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	//添加修改工作经历信息
	@RequestMapping(value = "/ApplyFor/EducationalTraining/InstUpEducational", method = RequestMethod.POST)
	public Result InstUpEducational(@RequestBody EducationalTraining educational) {
		Result result = new Result();
		if(educational.getId()==0){
			try{
				m_DBEducationalTraining.InsertEducational(educational);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				return result;
			}

		}
		else{
			try{
				m_DBEducationalTraining.UpdateEducational(educational);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				return result;
			}

		}
		return result;
	}

}
