package org.polariscode.SecuritySystem.web.Logistics;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.polariscode.SecuritySystem.config.Global;
import org.polariscode.SecuritySystem.model.Result;
import org.polariscode.SecuritySystem.mapper.Logistics.EquipmentOutStockMapper;
import org.polariscode.SecuritySystem.model.Table;
import org.polariscode.SecuritySystem.config.WebConfig;
import org.polariscode.SecuritySystem.model.Logistics.EquipmentOutStock;
import org.polariscode.SecuritySystem.model.Logistics.EquipmentOutStockItem;

@RestController
public class EquipmentOutStockController{

	@Autowired
	private EquipmentOutStockMapper m_EquipmentOutStockMapper;

	@RequestMapping(value = "/Logistics/EquipmentOutStock/getAllEquipmentOutStock", method = RequestMethod.POST)
	public Result getAllEquipmentOutStock(String startdate, String enddate, int org, int site, int pageNumber, int pageSize) {
		Result result = new Result();
		try{
			result.setData(m_EquipmentOutStockMapper.getAllEquipmentOutStock(pageNumber<=0?0:(pageNumber-1)*pageSize, pageSize, startdate, enddate, org, site));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		Table table = new Table();
		try{
			table = m_EquipmentOutStockMapper.getEquipmentOutStockByCount(startdate, enddate, org, site);
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

	@RequestMapping(value = "/Logistics/EquipmentOutStock/getEquipmentOutStockItemOne", method = RequestMethod.POST)
	public Result getEquipmentOutStockItemOne(int id) {
		Result result = new Result();
		try{
			result.setData(m_EquipmentOutStockMapper.getEquipmentOutStockItemOne(id));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	@RequestMapping(value = "/Logistics/EquipmentOutStock/getEquipmentOutStockItmeById", method = RequestMethod.POST)
	public Result getEquipmentOutStockItmeById(int id) {
		Result result = new Result();
		try{
			result.setData(m_EquipmentOutStockMapper.getEquipmentOutStockItmeById(id));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	@RequestMapping(value = "/Logistics/EquipmentOutStock/getEquipmentOutStockOne", method = RequestMethod.POST)
	public Result getEquipmentOutStockOne(int id) {
		Result result = new Result();
		try{
			result.setData(m_EquipmentOutStockMapper.getEquipmentOutStockOne(id));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	@RequestMapping(value = "/Logistics/EquipmentOutStock/updateEquipmentOutStock", method = RequestMethod.POST)
	public Result updateEquipmentOutStock(@RequestBody EquipmentOutStock equipmentoutstock) {
		Result result = new Result();
		String user = "";
		user = WebConfig.getUser();
		equipmentoutstock.setCreateUser(user);
		if(equipmentoutstock.getID()>0){
			try{
				m_EquipmentOutStockMapper.updateEquipmentOutStock(equipmentoutstock);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				return result;
			}

		}
		else{
			try{
				m_EquipmentOutStockMapper.updateEquipmentOutStock(equipmentoutstock);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				return result;
			}

		}
		return result;
	}

	@RequestMapping(value = "/Logistics/EquipmentOutStock/updateEquipmentOutStockItem", method = RequestMethod.POST)
	public Result updateEquipmentOutStockItem(@RequestBody EquipmentOutStockItem equipmentoutstockitem) {
		Result result = new Result();
		if(equipmentoutstockitem.getID()>0){
			try{
				m_EquipmentOutStockMapper.updateEquipmentOutStockItem(equipmentoutstockitem);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				return result;
			}

		}
		else{
			try{
				m_EquipmentOutStockMapper.insertEquipmentOutStockItem(equipmentoutstockitem);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				return result;
			}

		}
		return result;
	}

}
