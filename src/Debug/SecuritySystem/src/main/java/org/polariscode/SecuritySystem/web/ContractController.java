package org.polariscode.SecuritySystem.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.polariscode.SecuritySystem.config.Global;
import org.polariscode.SecuritySystem.model.Result;
import org.polariscode.SecuritySystem.mapper.Contract.ContractMapper;
import org.polariscode.SecuritySystem.model.Table;
import org.polariscode.SecuritySystem.mapper.Contract.ContractEquipmentMapper;
import org.polariscode.SecuritySystem.mapper.Contract.ContractInvoiceMapper;
import org.polariscode.SecuritySystem.mapper.Contract.ContractPersonnelMapper;
import org.polariscode.SecuritySystem.mapper.Contract.SiteContractMapper;
import org.polariscode.SecuritySystem.mapper.Contract.SiteContractPostMapper;
import org.polariscode.SecuritySystem.config.WebConfig;
import org.springframework.transaction.annotation.Transactional;
import org.polariscode.SecuritySystem.model.Contract.Contract;
import org.polariscode.SecuritySystem.model.Contract.ContractEquipment;
import org.polariscode.SecuritySystem.model.Contract.ContractInvoice;
import org.polariscode.SecuritySystem.model.Contract.ContractPersonnel;
import org.polariscode.SecuritySystem.model.Base.Site;
import org.polariscode.SecuritySystem.mapper.Import.CustomerImportMapper;
import org.polariscode.SecuritySystem.model.Contract.SiteContract;
import org.polariscode.SecuritySystem.model.Contract.SiteContractPosts;

@RestController
public class ContractController{

	@Autowired
	private ContractMapper m_ContractMapper;

	@Autowired
	private ContractEquipmentMapper m_ContractEquipmentMapper;

	@Autowired
	private ContractInvoiceMapper m_ContractInvoiceMapper;

	@Autowired
	private ContractPersonnelMapper m_ContractPersonnelMapper;

	@Autowired
	private SiteContractMapper m_SiteContractMapper;

	@Autowired
	private SiteContractPostMapper m_SiteContractPostMapper;

	@Autowired
	private CustomerImportMapper m_CustomerImportMapper;

	@RequestMapping(value = "/Contract/getAllContract", method = RequestMethod.POST)
	public Result getAllContract(int pageNumber, int pageSize, String status, int type, String Expire) {
		Result result = new Result();
		try{
			result.setData(m_ContractMapper.getContractAll(pageNumber<=0?0:(pageNumber-1)*pageSize, pageSize, status, type, Expire));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		Table t = new Table();
		try{
			t = m_ContractMapper.getContractByCount();
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		result.setPageNumber(pageNumber);
		result.setPageSize(pageSize);
		result.setRecordCount(t.getCount());
		return result;
	}

	@RequestMapping(value = "/Contract/getContractById", method = RequestMethod.POST)
	public Result getContractById(int id) {
		Result result = new Result();
		try{
			result.setData(m_ContractMapper.getContractById(id));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	@RequestMapping(value = "/Contract/getContractEquipmentByContractID", method = RequestMethod.POST)
	public Result getContractEquipmentByContractID(int ContractID, int pageNumber, int pageSize) {
		Result result = new Result();
		result.setPageNumber(pageNumber);
		result.setPageSize(pageSize);
		Table t = new Table();
		try{
			result.setData(m_ContractEquipmentMapper.getContractEquipmentByContractID(ContractID, pageNumber<=0?0:(pageNumber-1)*pageSize, pageSize));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		try{
			t = m_ContractEquipmentMapper.getContractEquipmentByCount(ContractID);
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		result.setRecordCount(t.getCount());
		return result;
	}

	@RequestMapping(value = "/Contract/getContractEquipmentById", method = RequestMethod.POST)
	public Result getContractEquipmentById(int id) {
		Result result = new Result();
		try{
			result.setData(m_ContractEquipmentMapper.getContractEquipmentById(id));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	@RequestMapping(value = "/Contract/getContractInvoiceByContractID", method = RequestMethod.POST)
	public Result getContractInvoiceByContractID(int ContractID, int pageNumber, int pageSize) {
		Result result = new Result();
		Table t = new Table();
		result.setPageNumber(pageNumber);
		result.setPageSize(pageSize);
		try{
			result.setData(m_ContractInvoiceMapper.getContractInvoiceByContractID(ContractID, pageNumber<=0?0:(pageNumber-1)*pageSize, pageSize));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		try{
			t = m_ContractInvoiceMapper.getContractInvoiceByCount(ContractID);
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		result.setRecordCount(t.getCount());
		return result;
	}

	@RequestMapping(value = "/Contract/getContractInvoiceById", method = RequestMethod.POST)
	public Result getContractInvoiceById(int id) {
		Result result = new Result();
		try{
			result.setData(m_ContractInvoiceMapper.getContractInvoiceById(id));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	@RequestMapping(value = "/Contract/getContractPersonnelByContractID", method = RequestMethod.POST)
	public Result getContractPersonnelByContractID(int ContractID, int pageNumber, int pageSize) {
		Result result = new Result();
		Table t = new Table();
		result.setPageNumber(pageNumber);
		result.setPageSize(pageSize);
		try{
			result.setData(m_ContractPersonnelMapper.getContractPersonnelByContractID(ContractID, pageNumber<=0?0:(pageNumber-1)*pageSize, pageSize));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		try{
			t = m_ContractPersonnelMapper.getContractPersonnelByCount(ContractID);
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		result.setRecordCount(t.getCount());
		return result;
	}

	@RequestMapping(value = "/Contract/getContractPersonnelById", method = RequestMethod.POST)
	public Result getContractPersonnelById(int id) {
		Result result = new Result();
		try{
			result.setData(m_ContractPersonnelMapper.getContractPersonnelById(id));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	@RequestMapping(value = "/Contract/getMaxContractCode", method = RequestMethod.POST)
	public Result getMaxContractCode() {
		Result result = new Result();
		Table t = new Table();
		try{
			t = m_ContractMapper.getMaxContractCode();
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		if(t!=null&&t.getCount()>0){
			t.setCount(t.getCount()+1);
		}
		else{
			t=new Table();
			  java.text.SimpleDateFormat sdf = new  java.text.SimpleDateFormat("yyyy");
			       java.util.Date date = new java.util.Date();
			t.setCount(Integer.parseInt( sdf.format(date)+"0001"));
		}
		result.setData(t);
		return result;
	}

	@RequestMapping(value = "/Contract/getSiteContractByContractID", method = RequestMethod.POST)
	public Result getSiteContractByContractID(int ContractID, int pageNumber, int pageSize) {
		Result result = new Result();
		Table t = new Table();
		result.setPageNumber(pageNumber);
		result.setPageSize(pageSize);
		try{
			result.setData(m_SiteContractMapper.getSiteContractByContractID(pageNumber<=0?0:(pageNumber-1)*pageSize, pageSize, ContractID));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		try{
			t = m_SiteContractMapper.getSiteContractByCount(ContractID);
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		result.setRecordCount(t.getCount());
		return result;
	}

	@RequestMapping(value = "/Contract/getSiteContractById", method = RequestMethod.POST)
	public Result getSiteContractById(int id) {
		Result result = new Result();
		try{
			result.setData(m_SiteContractMapper.getSiteContractById(id));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	@RequestMapping(value = "/Contract/getSiteContractPostById", method = RequestMethod.POST)
	public Result getSiteContractPostById(int id) {
		Result result = new Result();
		try{
			result.setData(m_SiteContractPostMapper.getSiteContractPostById(id));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	@RequestMapping(value = "/Contract/updateContract", method = RequestMethod.POST)
	@Transactional
	public Result updateContract(@RequestBody Contract c) {
		Result result = new Result();
		String username = "";
		username = WebConfig.getUser();
		c.setCreateUser(username);
		if(c.getID()>0){
			try{
				m_ContractMapper.UpdateContract(c);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
		}
		else{
			try{
				m_ContractMapper.InsertContract(c);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
			try{
				result.setData(m_ContractMapper.getinsertContractByID());
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
		}
		return result;
	}

	@RequestMapping(value = "/Contract/updateContractEquipment", method = RequestMethod.POST)
	@Transactional
	public Result updateContractEquipment(@RequestBody ContractEquipment e) {
		Result result = new Result();
		String username = "";
		username = WebConfig.getUser();
		e.setCreateUser(username);
		if(e.getID()>0){
			try{
				m_ContractEquipmentMapper.updateContractEquipment(e);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
		}
		else{
			try{
				m_ContractEquipmentMapper.insertContractEquipment(e);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
		}
		return result;
	}

	@RequestMapping(value = "/Contract/updateContractInvoice", method = RequestMethod.POST)
	@Transactional
	public Result updateContractInvoice(@RequestBody ContractInvoice i) {
		Result result = new Result();
		String username = "";
		username = WebConfig.getUser();
		i.setCreateUser(username);
		if(i.getID()>0){
			try{
				m_ContractInvoiceMapper.updateContractInvoice(i);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
		}
		else{
			try{
				m_ContractInvoiceMapper.insertContractInvoice(i);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
		}
		return result;
	}

	@RequestMapping(value = "/Contract/updateContractPersonnel", method = RequestMethod.POST)
	@Transactional
	public Result updateContractPersonnel(@RequestBody ContractPersonnel p) {
		Result result = new Result();
		String username = "";
		username = WebConfig.getUser();
		p.setCreateUser(username);
		if(p.getID()>0){
			try{
				m_ContractPersonnelMapper.updateContractPersonnel(p);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
		}
		else{
			try{
				m_ContractPersonnelMapper.insertContractPersonnel(p);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
		}
		return result;
	}

	@RequestMapping(value = "/Contract/updateSiteContract", method = RequestMethod.POST)
	@Transactional
	public Result updateSiteContract(@RequestBody Site s) {
		Result result = new Result();
		String username = "";
		username = WebConfig.getUser();
		s.setCreateUser(username);
		if(s.getID()>0){
			try{
				m_SiteContractMapper.updateSite(s);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
		}
		else{
			Site sites = new Site();
			try{
				sites = m_CustomerImportMapper.getSiteByName(s.getName());
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
			if(sites!=null&&sites.getID()>0){
				result.setCode(500);
				result.setMsg("此驻点名称已存在，请验证后重试！");
				return result;
			}
			else{
				SiteContract cs = new SiteContract();
				Table t = new Table();
				try{
					m_SiteContractMapper.insertSite(s);
				}catch(Exception error){
					result.setCode(error.hashCode());
					result.setMsg(error.getMessage());
					throw error;
				}
				try{
					t = m_CustomerImportMapper.getInsertSiteID();
				}catch(Exception error){
					result.setCode(error.hashCode());
					result.setMsg(error.getMessage());
					throw error;
				}
				cs.setSiteId(t.getID());
				cs.setContractId(s.getCustomerID ());
				try{
					m_SiteContractMapper.insertSiteContract(cs);
				}catch(Exception error){
					result.setCode(error.hashCode());
					result.setMsg(error.getMessage());
					throw error;
				}
			}
		}
		return result;
	}

	@RequestMapping(value = "/Contract/updateSiteContractPost", method = RequestMethod.POST)
	public Result updateSiteContractPost(@RequestBody SiteContractPosts sitecontractposts) {
		Result result = new Result();
		try{
			m_SiteContractPostMapper.deleteById(sitecontractposts.getid());
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		try{
			if(sitecontractposts.getsiteContractPosts().size()>0){
				m_SiteContractPostMapper.insertSiteContractPost(sitecontractposts.getsiteContractPosts(), sitecontractposts.getid());
			}
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

}
