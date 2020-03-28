package org.polariscode.SecuritySystem.web.Logistics;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.polariscode.SecuritySystem.config.Global;
import org.polariscode.SecuritySystem.model.Result;
import org.polariscode.SecuritySystem.mapper.Logistics.EquipmentMapper;
import org.polariscode.SecuritySystem.model.Table;
import org.polariscode.SecuritySystem.config.WebConfig;
import org.polariscode.SecuritySystem.model.Logistics.Equipment;

@RestController
public class EquipmentController{

	@Autowired
	private EquipmentMapper m_EquipmentMapper;

	@RequestMapping(value = "/Logistics/Equipment/getAllEquipment", method = RequestMethod.POST)
	public Result getAllEquipment(String Name, int pageNumber, int pageSize) {
		Result result = new Result();
		try{
			result.setData(m_EquipmentMapper.getAllEquipment(Name, pageNumber<=0?0:(pageNumber-1)*pageSize, pageSize));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		Table table = new Table();
		try{
			table = m_EquipmentMapper.getEquipmentByCount(Name);
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

	@RequestMapping(value = "/Logistics/Equipment/getEquipmentById", method = RequestMethod.POST)
	public Result getEquipmentById(int id) {
		Result result = new Result();
		try{
			result.setData(m_EquipmentMapper.getEquipmentById(id));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	@RequestMapping(value = "/Logistics/Equipment/updateEquipment", method = RequestMethod.POST)
	public Result updateEquipment(@RequestBody Equipment equipment) {
		Result result = new Result();
		String user = "";
		user = WebConfig.getUser();
		equipment.setCreateUser(user);
		if(equipment.getID()>0){
			try{
				m_EquipmentMapper.updateEquipment(equipment);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				return result;
			}

		}
		else{
			try{
				m_EquipmentMapper.updateEquipment(equipment);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				return result;
			}

		}
		return result;
	}

}
