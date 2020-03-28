package org.polariscode.SecuritySystem.web.Base;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.polariscode.SecuritySystem.config.Global;
import org.polariscode.SecuritySystem.model.Result;
import org.polariscode.SecuritySystem.model.Permission.User;
import org.polariscode.SecuritySystem.config.WebConfig;
import org.polariscode.SecuritySystem.mapper.Permission.UserMapper;
import org.polariscode.SecuritySystem.mapper.Base.CustomerMapper;
import org.polariscode.SecuritySystem.model.Table;
import org.springframework.transaction.annotation.Transactional;
import org.polariscode.SecuritySystem.model.Base.Customer;

@RestController
public class CustomerController{

	@Autowired
	private UserMapper m_UserMapper;

	@Autowired
	private CustomerMapper m_CustomerMapper;

	@RequestMapping(value = "/Base/Customer/getAllCustomers", method = RequestMethod.POST)
	public Result getAllCustomers(String org, String name, String type, String status, int pageNumber, int pageSize) {
		Result result = new Result();
		String user = "";
		User u = new User();
		user = WebConfig.getUser();
		try{
			u = m_UserMapper.getUserOne(user);
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		try{
			result.setData(m_CustomerMapper.getAllCustomers(name, type, status, pageNumber<=0?0:(pageNumber-1)*pageSize, pageSize, org, u.getSiteOrg()));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		Table table = new Table();
		try{
			table = m_CustomerMapper.getCustomerCount(name, type, status, org, u.getSiteOrg());
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

	@RequestMapping(value = "/Base/Customer/getCustomerById", method = RequestMethod.POST)
	public Result getCustomerById(int id) {
		Result result = new Result();
		try{
			result.setData(m_CustomerMapper.getCustomerOne(id));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	@RequestMapping(value = "/Base/Customer/updateCustomer", method = RequestMethod.POST)
	@Transactional
	public Result updateCustomer(@RequestBody Customer customer) {
		Result result = new Result();
		String user = "";
		user = WebConfig.getUser();
		if(customer.getID()==0){
			customer.setCreateUser(user);
			try{
				m_CustomerMapper.insertCustomer(customer);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
		}
		else{
			customer.setModifyUser(user);
			try{
				m_CustomerMapper.updateCustomer(customer);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
		}
		return result;
	}

}
