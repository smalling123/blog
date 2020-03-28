package org.polariscode.SecuritySystem.web.Base;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.polariscode.SecuritySystem.config.Global;
import org.polariscode.SecuritySystem.model.Result;
import org.polariscode.SecuritySystem.mapper.Base.PersnnnelMapper;
import org.polariscode.SecuritySystem.model.Table;
import org.polariscode.SecuritySystem.model.Base.Personnel;
import org.polariscode.SecuritySystem.mapper.DBMapper;
import org.springframework.transaction.annotation.Transactional;

@RestController
public class PersonnelController{

	@Autowired
	private PersnnnelMapper m_PersnnnelMapper;

	@Autowired
	private DBMapper m_DBMapper;

	@RequestMapping(value = "/Base/Personnel/getAllPersonnels", method = RequestMethod.POST)
	public Result getAllPersonnels(String name, String gender, String cardcode, String native1, int age1, int age2, int weight, int height, String status, String education, String indate1, String indate2, String outdate1, String outdate2, String bankcard, String siteid, String politicaltrial, String f1, String photo, int pageNumber, int pageSize) {
		Result result = new Result();
		try{
			result.setData(m_PersnnnelMapper.getAllPersonnels(name, gender, cardcode, native1, age1, age2, weight, height, status, education, indate1, indate2, outdate1, outdate2, bankcard, siteid, politicaltrial, f1, photo, pageNumber<=0?0:(pageNumber-1)*pageSize, pageSize));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		Table table = new Table();
		try{
			table = m_PersnnnelMapper.getPersonnelCount(name, gender, cardcode, native1, age1, age2, weight, height, status, education, indate1, indate2, outdate1, outdate2, bankcard, siteid, politicaltrial, f1, photo);
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

	@RequestMapping(value = "/Base/Personnel/getPersonnelById", method = RequestMethod.POST)
	public Result getPersonnelById(int id) {
		Result result = new Result();
		Personnel personnel = new Personnel();
		try{
			personnel = m_PersnnnelMapper.getPersonnelOne(id);
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		try{
			personnel.setPersonnelJob(m_PersnnnelMapper.getPersonnelJob(id));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		try{
			personnel.setPersonnelMembers(m_PersnnnelMapper.getPersonnelMembers(id));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		try{
			personnel.setPersonnelPhoto(m_PersnnnelMapper.getPersonnelPhoto(id));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		try{
			personnel.setPersonnelCert(m_PersnnnelMapper.getPersonnelCert(id));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		try{
			personnel.setPersonnelContract(m_PersnnnelMapper.getPersonnelContract(id));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		result.setData(personnel);
		return result;
	}

	@RequestMapping(value = "/Base/Personnel/updatePersonnel", method = RequestMethod.POST)
	@Transactional
	public Result updatePersonnel(@RequestBody Personnel personnel) {
		Result result = new Result();
		if(personnel.getID()==0){
			try{
				m_PersnnnelMapper.insertPersonnel(personnel);
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
			personnel.setID(table.getID());
		}
		else{
			try{
				m_PersnnnelMapper.updatePersonnel(personnel);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
			try{
				m_PersnnnelMapper.DeletePersonnelJob(personnel.getID());
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
			try{
				m_PersnnnelMapper.DeletePersonnelMembers(personnel.getID());
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
			try{
				m_PersnnnelMapper.DeletePersonnelPhoto(personnel.getID());
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
			try{
				m_PersnnnelMapper.DeletePersonnelCert(personnel.getID());
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
			try{
				m_PersnnnelMapper.DeletePersonnelContract(personnel.getID());
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
		}
		try{
			if(personnel.getPersonnelJob().size()>0){
				m_PersnnnelMapper.insertPersonnelJob(personnel.getPersonnelJob(), personnel.getID());
			}
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		try{
			if(personnel.getPersonnelMembers().size()>0){
				m_PersnnnelMapper.insertPersonnelMembers(personnel.getPersonnelMembers(), personnel.getID());
			}
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		try{
			if(personnel.getPersonnelPhoto().size()>0){
				m_PersnnnelMapper.insertPersonnelPhoto(personnel.getPersonnelPhoto(), personnel.getID());
			}
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		try{
			if(personnel.getPersonnelCert().size()>0){
				m_PersnnnelMapper.insertPersonnelCert(personnel.getPersonnelCert(), personnel.getID());
			}
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		try{
			if(personnel.getPersonnelContract().size()>0){
				m_PersnnnelMapper.insertPersonnelContract(personnel.getPersonnelContract(), personnel.getID());
			}
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		return result;
	}

}
