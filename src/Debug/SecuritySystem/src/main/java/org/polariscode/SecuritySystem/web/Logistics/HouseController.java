package org.polariscode.SecuritySystem.web.Logistics;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.polariscode.SecuritySystem.config.Global;
import org.polariscode.SecuritySystem.model.Result;
import org.polariscode.SecuritySystem.mapper.Logistics.HouseMapper;
import org.polariscode.SecuritySystem.model.Table;
import org.polariscode.SecuritySystem.config.WebConfig;
import org.polariscode.SecuritySystem.model.Logistics.House;
import org.polariscode.SecuritySystem.model.Logistics.HouseContract;

@RestController
public class HouseController{

	@Autowired
	private HouseMapper m_HouseMapper;

	@RequestMapping(value = "/Logistics/House/getAllHouse", method = RequestMethod.POST)
	public Result getAllHouse(String City, String Address, int org, int site, int pageNumber, int pageSize) {
		Result result = new Result();
		try{
			result.setData(m_HouseMapper.getAllHouse(pageNumber<=0?0:(pageNumber-1)*pageSize, pageSize, City, Address, org, site));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		Table table = new Table();
		try{
			table = m_HouseMapper.getHouseByCount(City, Address, org, site);
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

	@RequestMapping(value = "/Logistics/House/getHouseContractById", method = RequestMethod.POST)
	public Result getHouseContractById(int id) {
		Result result = new Result();
		try{
			result.setData(m_HouseMapper.getHouseContractById(id));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	@RequestMapping(value = "/Logistics/House/getHouseContractOne", method = RequestMethod.POST)
	public Result getHouseContractOne(int id) {
		Result result = new Result();
		try{
			result.setData(m_HouseMapper.getHouseContractOne(id));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	@RequestMapping(value = "/Logistics/House/getHouseOne", method = RequestMethod.POST)
	public Result getHouseOne(int id) {
		Result result = new Result();
		try{
			result.setData(m_HouseMapper.getHouseOne(id));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	@RequestMapping(value = "/Logistics/House/updateHouse", method = RequestMethod.POST)
	public Result updateHouse(@RequestBody House house) {
		Result result = new Result();
		String user = "";
		user = WebConfig.getUser();
		house.setCreateUser(user);
		if(house.getID()>0){
			try{
				m_HouseMapper.updateHouse(house);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				return result;
			}

		}
		else{
			try{
				m_HouseMapper.insertHouse(house);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				return result;
			}

		}
		return result;
	}

	@RequestMapping(value = "/Logistics/House/updateHouseContract", method = RequestMethod.POST)
	public Result updateHouseContract(@RequestBody HouseContract housecontract) {
		Result result = new Result();
		if(housecontract.getID()>0){
			try{
				m_HouseMapper.updateHouseContract(housecontract);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				return result;
			}

		}
		else{
			try{
				m_HouseMapper.insertHouseContract(housecontract);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				return result;
			}

		}
		return result;
	}

}
