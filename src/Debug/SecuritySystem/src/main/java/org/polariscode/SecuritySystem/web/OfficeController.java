package org.polariscode.SecuritySystem.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.polariscode.SecuritySystem.config.Global;
import org.polariscode.SecuritySystem.model.Result;
import org.polariscode.SecuritySystem.mapper.Office.StaffMapper;
import org.polariscode.SecuritySystem.model.Table;
import org.polariscode.SecuritySystem.model.Office.Staff;
import org.springframework.transaction.annotation.Transactional;

@RestController
public class OfficeController{

	@Autowired
	private StaffMapper m_StaffMapper;

	@RequestMapping(value = "/Office/getAllStaff", method = RequestMethod.POST)
	public Result getAllStaff(String name, String orgname, String status, int pageNumber, int pageSize) {
		Result result = new Result();
		try{
			result.setData(m_StaffMapper.getAllStaff(name, orgname, status, pageNumber<=0?0:(pageNumber-1)*pageSize, pageSize));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		Table table = new Table();
		try{
			table = m_StaffMapper.getStaffCount(name, orgname, status);
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

	@RequestMapping(value = "/Office/getStaffById", method = RequestMethod.POST)
	public Result getStaffById(int id) {
		Result result = new Result();
		Staff staff = new Staff();
		try{
			staff = m_StaffMapper.getStaffByID(id);
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		try{
			staff.setMembers(m_StaffMapper.getStaffMembers(id));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		try{
			staff.setWork(m_StaffMapper.getStaffWork(id));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		try{
			staff.setEdu(m_StaffMapper.getStaffEdu(id));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		result.setData(staff);
		return result;
	}

	@RequestMapping(value = "/Office/updateStaff", method = RequestMethod.POST)
	@Transactional
	public Result updateStaff(@RequestBody Staff staff) {
		Result result = new Result();
		if(staff.getID() == 0){
			try{
				m_StaffMapper.InsertStaff(staff);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
		}
		else{
			try{
				m_StaffMapper.UpdateStaff(staff);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
			try{
				m_StaffMapper.DeleteStaffmembers(staff.getID());
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
			try{
				m_StaffMapper.DeleteStaffWork(staff.getID());
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
			try{
				m_StaffMapper.DeleteStaffEdu(staff.getID());
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
		}
		try{
			if(staff.getMembers().size()>0){
				m_StaffMapper.insertStaffMembers(staff.getMembers(), staff.getID());
			}
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		try{
			if(staff.getWork().size()>0){
				m_StaffMapper.insertStaffWork(staff.getWork(), staff.getID());
			}
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		try{
			if(staff.getEdu().size()>0){
				m_StaffMapper.insertStaffEdu(staff.getEdu(), staff.getID());
			}
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		return result;
	}

}
