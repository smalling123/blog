package org.polariscode.SecuritySystem.web.ApplyFor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.polariscode.SecuritySystem.config.Global;
import org.polariscode.SecuritySystem.model.Result;
import org.polariscode.SecuritySystem.mapper.ApplyFor.DBFamily;
import org.polariscode.SecuritySystem.model.Table;
import org.polariscode.SecuritySystem.model.ApplyFor.Family;

@RestController
public class FamilyController{

	@Autowired
	private DBFamily m_DBFamily;

	//删除家庭信息
	@RequestMapping(value = "/ApplyFor/Family/DeleteFamily", method = RequestMethod.POST)
	public Result DeleteFamily(int id) {
		Result result = new Result();
		try{
			m_DBFamily.DeleteFamily(id);
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	//获取所有家庭信息
	@RequestMapping(value = "/ApplyFor/Family/getAllFamily", method = RequestMethod.POST)
	public Result getAllFamily(int pageNumber, int pageSize) {
		Result result = new Result();
		try{
			result.setData(m_DBFamily.getAllFamily(pageNumber<=0?0:(pageNumber-1)*pageSize, pageSize));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		Table table = new Table();
		try{
			table = m_DBFamily.getFamilyCount();
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

	//根据员工编号查看家庭信息
	@RequestMapping(value = "/ApplyFor/Family/getFamilyByEid", method = RequestMethod.POST)
	public Result getFamilyByEid(int eid) {
		Result result = new Result();
		try{
			result.setData(m_DBFamily.getFamilyByEid(eid));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		Table table = new Table();
		try{
			table = m_DBFamily.getCountByEid(eid);
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		result.setEinzelband(table.getCount());
		return result;
	}

	//根据Id查询家庭信息
	@RequestMapping(value = "/ApplyFor/Family/getFamilyById", method = RequestMethod.POST)
	public Result getFamilyById(int id) {
		Result result = new Result();
		try{
			result.setData(m_DBFamily.getFamilyById(id));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	//添加、修改家庭信息
	@RequestMapping(value = "/ApplyFor/Family/InstUpFamily", method = RequestMethod.POST)
	public Result InstUpFamily(@RequestBody Family family) {
		Result result = new Result();
		if(family.getId()==0){
			try{
				m_DBFamily.InsertFamily(family);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				return result;
			}

		}
		else{
			try{
				m_DBFamily.UpdateFamily(family);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				return result;
			}

		}
		return result;
	}

}
