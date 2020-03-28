package org.polariscode.SecuritySystem.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.polariscode.SecuritySystem.config.Global;
import org.polariscode.SecuritySystem.model.Result;
import org.polariscode.SecuritySystem.mapper.Salary.AccfundMapper;
import org.polariscode.SecuritySystem.model.Table;
import org.polariscode.SecuritySystem.mapper.Salary.InsuranceMapper;
import org.polariscode.SecuritySystem.mapper.Salary.TaxMapper;
import org.polariscode.SecuritySystem.model.Salary.Insurance;
import org.polariscode.SecuritySystem.model.Salary.Accfund;
import org.polariscode.SecuritySystem.model.Salary.Accfunditem;
import org.polariscode.SecuritySystem.mapper.DBMapper;
import org.springframework.transaction.annotation.Transactional;
import org.polariscode.SecuritySystem.model.Salary.Taxy;
import org.polariscode.SecuritySystem.model.Salary.Tax;
import org.polariscode.SecuritySystem.model.Salary.Taxm;

@RestController
public class SalaryController{

	@Autowired
	private AccfundMapper m_AccfundMapper;

	@Autowired
	private InsuranceMapper m_InsuranceMapper;

	@Autowired
	private TaxMapper m_TaxMapper;

	@Autowired
	private DBMapper m_DBMapper;

	@RequestMapping(value = "/Salary/gatAccfunitemById", method = RequestMethod.POST)
	public Result gatAccfunitemById(int id) {
		Result result = new Result();
		try{
			result.setData(m_AccfundMapper.getAccfunditemById(id));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	@RequestMapping(value = "/Salary/getAccfunditemOne", method = RequestMethod.POST)
	public Result getAccfunditemOne(int id) {
		Result result = new Result();
		try{
			result.setData(m_AccfundMapper.getAccfunditemOne(id));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	@RequestMapping(value = "/Salary/getAccfundOne", method = RequestMethod.POST)
	public Result getAccfundOne(int id) {
		Result result = new Result();
		try{
			result.setData(m_AccfundMapper.getAccfundOne(id));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	@RequestMapping(value = "/Salary/getAllAccfund", method = RequestMethod.POST)
	public Result getAllAccfund(String City, String Name, int pageNumber, int pageSize) {
		Result result = new Result();
		try{
			result.setData(m_AccfundMapper.getAllAccfund(pageNumber<=0?0:(pageNumber-1)*pageSize, pageSize, City, Name));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		Table table = new Table();
		try{
			table = m_AccfundMapper.getAccfundByCount(City, Name);
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

	@RequestMapping(value = "/Salary/getAllInsurance", method = RequestMethod.POST)
	public Result getAllInsurance() {
		Result result = new Result();
		try{
			result.setData(m_InsuranceMapper.getAllInsurance());
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	@RequestMapping(value = "/Salary/getAllTax", method = RequestMethod.POST)
	public Result getAllTax(String Year, String Month, int pageNumber, int pageSize) {
		Result result = new Result();
		try{
			result.setData(m_TaxMapper.getAllTax(pageNumber<=0?0:(pageNumber-1)*pageSize, pageSize, Year, Month));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		Table table = new Table();
		try{
			table = m_TaxMapper.getTaxByCount(Year, Month);
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

	@RequestMapping(value = "/Salary/getInsuranceById", method = RequestMethod.POST)
	public Result getInsuranceById(int id) {
		Result result = new Result();
		Insurance data = new Insurance();
		try{
			data = m_InsuranceMapper.getInsuranceOne(id);
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		try{
			data.setItems(m_InsuranceMapper.getInsuraceItems(id));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		result.setData(data);
		return result;
	}

	@RequestMapping(value = "/Salary/getTaxmById", method = RequestMethod.POST)
	public Result getTaxmById(int id) {
		Result result = new Result();
		try{
			result.setData(m_TaxMapper.getTaxm(id));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	@RequestMapping(value = "/Salary/getTaxmOne", method = RequestMethod.POST)
	public Result getTaxmOne(int id) {
		Result result = new Result();
		try{
			result.setData(m_TaxMapper.getTaxmOne(id));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	@RequestMapping(value = "/Salary/getTaxOne", method = RequestMethod.POST)
	public Result getTaxOne(int id) {
		Result result = new Result();
		try{
			result.setData(m_TaxMapper.getTaxOne(id));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	@RequestMapping(value = "/Salary/getTaxyById", method = RequestMethod.POST)
	public Result getTaxyById(int id) {
		Result result = new Result();
		try{
			result.setData(m_TaxMapper.getTaxy(id));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	@RequestMapping(value = "/Salary/getTaxyOne", method = RequestMethod.POST)
	public Result getTaxyOne(int id) {
		Result result = new Result();
		try{
			result.setData(m_TaxMapper.getTaxyOne(id));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	@RequestMapping(value = "/Salary/updateAccfund", method = RequestMethod.POST)
	public Result updateAccfund(@RequestBody Accfund accfund) {
		Result result = new Result();
		if(accfund.getID()>0){
			try{
				m_AccfundMapper.updateAccfund(accfund);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				return result;
			}

		}
		else{
			try{
				m_AccfundMapper.insertAccfund(accfund);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				return result;
			}

		}
		return result;
	}

	@RequestMapping(value = "/Salary/updateAccfunditem", method = RequestMethod.POST)
	public Result updateAccfunditem(@RequestBody Accfunditem accfunditem) {
		Result result = new Result();
		if(accfunditem.getID()>0){
			try{
				m_AccfundMapper.updateAccfunditem(accfunditem);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				return result;
			}

		}
		else{
			try{
				m_AccfundMapper.insertAccfunditem(accfunditem);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				return result;
			}

		}
		return result;
	}

	@RequestMapping(value = "/Salary/updateInsurance", method = RequestMethod.POST)
	@Transactional
	public Result updateInsurance(@RequestBody Insurance data) {
		Result result = new Result();
		Table table = new Table();
		if(data.getID()==0){
			try{
				m_InsuranceMapper.insertInsurance(data);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
			try{
				table = m_DBMapper.getTableID();
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
			data.setID(table.getID());
		}
		else{
			try{
				m_InsuranceMapper.deleteInsuranceItem(data.getID());
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
			try{
				m_InsuranceMapper.updateInsurance(data);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
		}
		try{
			if(data.getItems().size()>0){
				m_InsuranceMapper.insertInsuranceItem(data.getItems(), data.getID());
			}
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		return result;
	}

	@RequestMapping(value = "/Salary/updateTamy", method = RequestMethod.POST)
	public Result updateTamy(@RequestBody Taxy taxy) {
		Result result = new Result();
		if(taxy.getID()>0){
			try{
				m_TaxMapper.updateTaxy(taxy);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				return result;
			}

		}
		else{
			try{
				m_TaxMapper.insertTaxy(taxy);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				return result;
			}

		}
		return result;
	}

	@RequestMapping(value = "/Salary/updateTax", method = RequestMethod.POST)
	public Result updateTax(@RequestBody Tax tax) {
		Result result = new Result();
		if(tax.getID()>0){
			try{
				m_TaxMapper.updateTax(tax);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				return result;
			}

		}
		else{
			try{
				m_TaxMapper.insertTax(tax);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				return result;
			}

		}
		return result;
	}

	@RequestMapping(value = "/Salary/updateTaxm", method = RequestMethod.POST)
	public Result updateTaxm(@RequestBody Taxm taxm) {
		Result result = new Result();
		if(taxm.getID()>0){
			try{
				m_TaxMapper.updateTaxm(taxm);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				return result;
			}

		}
		else{
			try{
				m_TaxMapper.insertTaxm(taxm);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				return result;
			}

		}
		return result;
	}

}
