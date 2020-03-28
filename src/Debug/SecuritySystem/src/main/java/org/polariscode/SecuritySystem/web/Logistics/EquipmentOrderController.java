package org.polariscode.SecuritySystem.web.Logistics;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.polariscode.SecuritySystem.config.Global;
import org.polariscode.SecuritySystem.model.Result;
import org.polariscode.SecuritySystem.mapper.Logistics.EquipmentOrderMapper;
import org.polariscode.SecuritySystem.model.Table;
import org.polariscode.SecuritySystem.config.WebConfig;
import org.polariscode.SecuritySystem.model.Logistics.EquipmentOrder;
import org.polariscode.SecuritySystem.model.Logistics.EquipmentOrderItem;

@RestController
public class EquipmentOrderController{

	@Autowired
	private EquipmentOrderMapper m_EquipmentOrderMapper;

	@RequestMapping(value = "/Logistics/EquipmentOrder/getAllEquipmentOrder", method = RequestMethod.POST)
	public Result getAllEquipmentOrder(String startdate, String enddate, int org, int site, int pageNumber, int pageSize) {
		Result result = new Result();
		try{
			result.setData(m_EquipmentOrderMapper.getAllEquipmentOrder(pageNumber<=0?0:(pageNumber-1)*pageSize, pageSize, startdate, enddate, org, site));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		Table table = new Table();
		try{
			table = m_EquipmentOrderMapper.getEquipmentOrderByCount(startdate, enddate, org, site);
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

	@RequestMapping(value = "/Logistics/EquipmentOrder/getEquipmentOrderItemById", method = RequestMethod.POST)
	public Result getEquipmentOrderItemById(int id) {
		Result result = new Result();
		try{
			result.setData(m_EquipmentOrderMapper.getEquipmentOrderItemById(id));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	@RequestMapping(value = "/Logistics/EquipmentOrder/getEquipmentOrderItemOne", method = RequestMethod.POST)
	public Result getEquipmentOrderItemOne(int id) {
		Result result = new Result();
		try{
			result.setData(m_EquipmentOrderMapper.getEquipmentOrderItemOne(id));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	@RequestMapping(value = "/Logistics/EquipmentOrder/getEquipmentOrderOne", method = RequestMethod.POST)
	public Result getEquipmentOrderOne(int id) {
		Result result = new Result();
		try{
			result.setData(m_EquipmentOrderMapper.getEquipmentOrderOne(id));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	@RequestMapping(value = "/Logistics/EquipmentOrder/updateEquipmentOrder", method = RequestMethod.POST)
	public Result updateEquipmentOrder(@RequestBody EquipmentOrder equipmentorder) {
		Result result = new Result();
		String user = "";
		user = WebConfig.getUser();
		equipmentorder.setCreateTime(user);
		if(equipmentorder.getID()>0){
			try{
				m_EquipmentOrderMapper.updateEquipmentOrder(equipmentorder);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				return result;
			}

		}
		else{
			try{
				m_EquipmentOrderMapper.insertEquipmentOrder(equipmentorder);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				return result;
			}

		}
		return result;
	}

	@RequestMapping(value = "/Logistics/EquipmentOrder/updateEquipmentOrderItem", method = RequestMethod.POST)
	public Result updateEquipmentOrderItem(@RequestBody EquipmentOrderItem equipmentorderitem) {
		Result result = new Result();
		if(equipmentorderitem.getID()>0){
			try{
				m_EquipmentOrderMapper.updateEquipmentOrderItem(equipmentorderitem);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				return result;
			}

		}
		else{
			try{
				m_EquipmentOrderMapper.insertEquipmentOrderItem(equipmentorderitem);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				return result;
			}

		}
		return result;
	}

}
