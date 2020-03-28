package org.polariscode.SecuritySystem.web.Base;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.polariscode.SecuritySystem.config.Global;
import org.polariscode.SecuritySystem.model.Result;
import org.polariscode.SecuritySystem.mapper.Base.PersonnelContractMapper;
import org.polariscode.SecuritySystem.model.Table;
import org.polariscode.SecuritySystem.model.Base.PersonnelContract;

@RestController
public class PersonnelContractController{

	@Autowired
	private PersonnelContractMapper m_PersonnelContractMapper;

	@RequestMapping(value = "/Base/PersonnelContract/getAllPersonnelContract", method = RequestMethod.POST)
	public Result getAllPersonnelContract(String month, String End, int pageNumber, int pageSize) {
		Result result = new Result();
		try{
			result.setData(m_PersonnelContractMapper.getAllPersonnelContract(month, End, pageNumber<=0?0:(pageNumber-1)*pageSize, pageSize));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		Table table = new Table();
		try{
			table = m_PersonnelContractMapper.getAllPersonnelContractCount(month, End);
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

	@RequestMapping(value = "/Base/PersonnelContract/getPersonnelContractById", method = RequestMethod.POST)
	public Result getPersonnelContractById(int id) {
		Result result = new Result();
		try{
			result.setData(m_PersonnelContractMapper.getPersonnelContractById(id));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	@RequestMapping(value = "/Base/PersonnelContract/updatePersonnelContract", method = RequestMethod.POST)
	public Result updatePersonnelContract(@RequestBody PersonnelContract pc) {
		Result result = new Result();
		if(pc.getID()>0){
			try{
				m_PersonnelContractMapper.UpdatePersonnelContract(pc);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				return result;
			}

		}
		else{
			try{
				m_PersonnelContractMapper.InsertPersonnelContract(pc);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				return result;
			}

		}
		return result;
	}

}
