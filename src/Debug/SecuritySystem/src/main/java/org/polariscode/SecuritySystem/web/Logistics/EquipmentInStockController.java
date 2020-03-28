package org.polariscode.SecuritySystem.web.Logistics;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.polariscode.SecuritySystem.config.Global;
import org.polariscode.SecuritySystem.model.Result;
import org.polariscode.SecuritySystem.mapper.Logistics.EquipmentInStockMapper;
import org.polariscode.SecuritySystem.model.Table;
import org.polariscode.SecuritySystem.config.WebConfig;
import org.polariscode.SecuritySystem.model.Logistics.EquipmentInStock;
import org.polariscode.SecuritySystem.model.Logistics.EquipmentInStockItem;

@RestController
public class EquipmentInStockController{

	@Autowired
	private EquipmentInStockMapper m_EquipmentInStockMapper;

	@RequestMapping(value = "/Logistics/EquipmentInStock/gatAllEquipmentInStock", method = RequestMethod.POST)
	public Result gatAllEquipmentInStock(String startdate, String enddate, int org, int site, int pageNumber, int pageSize) {
		Result result = new Result();
		try{
			result.setData(m_EquipmentInStockMapper.gatAllEquipmentInStock(pageNumber<=0?0:(pageNumber-1)*pageSize, pageSize, startdate, enddate, org, site));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		Table table = new Table();
		try{
			table = m_EquipmentInStockMapper.gatEquipmentInStockByCount(startdate, enddate, org, site);
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

	@RequestMapping(value = "/Logistics/EquipmentInStock/getEquipmentInStockItemById", method = RequestMethod.POST)
	public Result getEquipmentInStockItemById(int id) {
		Result result = new Result();
		try{
			result.setData(m_EquipmentInStockMapper.getEquipmentInStockItemById(id));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	@RequestMapping(value = "/Logistics/EquipmentInStock/getEquipmentInStockItemOne", method = RequestMethod.POST)
	public Result getEquipmentInStockItemOne(int id) {
		Result result = new Result();
		try{
			result.setData(m_EquipmentInStockMapper.getEquipmentInStockItemOne(id));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	@RequestMapping(value = "/Logistics/EquipmentInStock/getEquipmentInStockOne", method = RequestMethod.POST)
	public Result getEquipmentInStockOne(int id) {
		Result result = new Result();
		try{
			result.setData(m_EquipmentInStockMapper.getEquipmentInStockOne(id));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	@RequestMapping(value = "/Logistics/EquipmentInStock/updateEquipmentInStock", method = RequestMethod.POST)
	public Result updateEquipmentInStock(@RequestBody EquipmentInStock equipmentinstock) {
		Result result = new Result();
		String user = "";
		user = WebConfig.getUser();
		equipmentinstock.setCreateUser(user);
		if(equipmentinstock.getID()>0){
			try{
				m_EquipmentInStockMapper.updateEquipmentInStock(equipmentinstock);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				return result;
			}

		}
		else{
			try{
				m_EquipmentInStockMapper.insertEquipmentInStock(equipmentinstock);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				return result;
			}

		}
		return result;
	}

	@RequestMapping(value = "/Logistics/EquipmentInStock/updateEquipmentInStockItem", method = RequestMethod.POST)
	public Result updateEquipmentInStockItem(@RequestBody EquipmentInStockItem equipmentinstockitem) {
		Result result = new Result();
		if(equipmentinstockitem.getID()>0){
			try{
				m_EquipmentInStockMapper.updateEquipmentInStockItem(equipmentinstockitem);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				return result;
			}

		}
		else{
			try{
				m_EquipmentInStockMapper.insertEquipmentInStockItem(equipmentinstockitem);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				return result;
			}

		}
		return result;
	}

}
