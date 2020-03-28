package org.polariscode.SecuritySystem.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.polariscode.SecuritySystem.config.Global;
import org.polariscode.SecuritySystem.model.Result;
import org.polariscode.SecuritySystem.mapper.Finance.BillMapper;
import org.polariscode.SecuritySystem.model.Table;
import org.polariscode.SecuritySystem.mapper.Finance.BillFeeMapper;
import org.polariscode.SecuritySystem.mapper.Finance.InvoiceMapper;
import org.polariscode.SecuritySystem.mapper.Finance.InvoiceItemMapper;
import org.polariscode.SecuritySystem.mapper.Finance.PayMapper;
import org.polariscode.SecuritySystem.mapper.Finance.PayCheckMapper;
import org.polariscode.SecuritySystem.model.Finance.TBill;
import org.polariscode.SecuritySystem.model.Finance.Bill;
import org.polariscode.SecuritySystem.config.WebConfig;
import org.polariscode.SecuritySystem.model.Finance.BillFee;
import org.polariscode.SecuritySystem.mapper.DBMapper;
import org.polariscode.SecuritySystem.model.Finance.Bs;
import org.polariscode.SecuritySystem.model.Finance.Ps;

@RestController
public class FinanceController{

	@Autowired
	private BillMapper m_BillMapper;

	@Autowired
	private BillFeeMapper m_BillFeeMapper;

	@Autowired
	private InvoiceMapper m_InvoiceMapper;

	@Autowired
	private InvoiceItemMapper m_InvoiceItemMapper;

	@Autowired
	private PayMapper m_PayMapper;

	@Autowired
	private PayCheckMapper m_PayCheckMapper;

	@Autowired
	private DBMapper m_DBMapper;

	@RequestMapping(value = "/Finance/getBillByContractId", method = RequestMethod.POST)
	public Result getBillByContractId(String customer, int pageNumber, int pageSize, int Year, int Month) {
		Result result = new Result();
		try{
			result.setData(m_BillMapper.getBillByContractId(customer, pageNumber<=0?0:(pageNumber-1)*pageSize, pageSize, Year, Month));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		Table table = new Table();
		try{
			table = m_BillMapper.getBillByCount(customer, Year, Month);
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

	@RequestMapping(value = "/Finance/getBillFeeBybid", method = RequestMethod.POST)
	public Result getBillFeeBybid(int bid, int pageNumber, int pageSize) {
		Result result = new Result();
		try{
			result.setData(m_BillFeeMapper.getBillFeeBybid(bid, pageNumber<=0?0:(pageNumber-1)*pageSize, pageSize));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		Table table = new Table();
		try{
			table = m_BillFeeMapper.getBillFeeByCount(bid);
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

	@RequestMapping(value = "/Finance/getBillFeeByCustomerId", method = RequestMethod.POST)
	public Result getBillFeeByCustomerId(int CustomerId, int Year, int Month, int pageNumber, int pageSize) {
		Result result = new Result();
		try{
			result.setData(m_BillFeeMapper.getBillFeeByCustomerId(CustomerId, Year, Month, pageNumber<=0?0:(pageNumber-1)*pageSize, pageSize));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		Table table = new Table();
		try{
			table = m_BillFeeMapper.getBillFeeCount(CustomerId, Year, Month);
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

	@RequestMapping(value = "/Finance/getinvoiceByCustomerId", method = RequestMethod.POST)
	public Result getinvoiceByCustomerId(int CustomerId, int pageNumber, int pageSize) {
		Result result = new Result();
		try{
			result.setData(m_InvoiceMapper.getinvoiceByCustomerId(CustomerId, pageNumber<=0?0:(pageNumber-1)*pageSize, pageSize));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		Table table = new Table();
		try{
			table = m_InvoiceMapper.getinvoiceByCount(CustomerId);
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

	@RequestMapping(value = "/Finance/getInvoiceById", method = RequestMethod.POST)
	public Result getInvoiceById(int id) {
		Result result = new Result();
		try{
			result.setData(m_InvoiceMapper.getInvoiceById(id));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	@RequestMapping(value = "/Finance/getInvoiceItemByInvoiceId", method = RequestMethod.POST)
	public Result getInvoiceItemByInvoiceId(int InvoiceId, int pageNumber, int pageSize) {
		Result result = new Result();
		try{
			result.setData(m_InvoiceItemMapper.getInvoiceItemByInvoiceId(InvoiceId, pageNumber<=0?0:(pageNumber-1)*pageSize, pageSize));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		Table table = new Table();
		try{
			table = m_InvoiceItemMapper.getInvoiceItemByCount(InvoiceId);
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

	@RequestMapping(value = "/Finance/getPayByCustomerId", method = RequestMethod.POST)
	public Result getPayByCustomerId(int CustomerId, int pageNumber, int pageSize) {
		Result result = new Result();
		try{
			result.setData(m_PayMapper.getPayByCustomerId(CustomerId, pageNumber<=0?0:(pageNumber-1)*pageSize, pageSize));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		Table table = new Table();
		try{
			table = m_PayMapper.getPayByCount(CustomerId);
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

	@RequestMapping(value = "/Finance/getPayById", method = RequestMethod.POST)
	public Result getPayById(int id) {
		Result result = new Result();
		try{
			result.setData(m_PayMapper.getPayById(id));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	@RequestMapping(value = "/Finance/getPayCheckByPayId", method = RequestMethod.POST)
	public Result getPayCheckByPayId(int PayId, int InvoiceItemId, int pageNumber, int pageSize) {
		Result result = new Result();
		try{
			result.setData(m_PayCheckMapper.getPayCheckByPayId(PayId, InvoiceItemId, pageNumber<=0?0:(pageNumber-1)*pageSize, pageSize));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		Table table = new Table();
		try{
			table = m_PayCheckMapper.getPayCheckByCount(PayId, InvoiceItemId);
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

	@RequestMapping(value = "/Finance/insertsBill", method = RequestMethod.POST)
	public Result insertsBill(int id, String describes) {
		Result result = new Result();
		int x = 0;
		TBill tbill = new TBill();
		java.util.List<TBill> tbills = new java.util.ArrayList<TBill>();
		Table t = new Table();
		try{
			tbills = m_BillMapper.getTBillById(id, 0);
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		while(x<tbills.size()){
			int i = 0;
			tbill = tbills.get(x);
			while(tbill.getYN()==1){
				if(tbill!=null && tbill.getYNS()==1){
					try{
						t = m_BillMapper.getBillCount(i, id, tbill.getID());
					}catch(Exception error){
						result.setCode(error.hashCode());
						result.setMsg(error.getMessage());
						return result;
					}

					if(t.getCount()>0){
					}
					else{
						Bill bill = new Bill();
						bill.setYear(tbill.getYEAR());
						bill.setMonth(tbill.getMONTH());
						bill.setAmt(tbill.getAmount());
						bill.setDescribes(describes);
						bill.setCustomerId(id);
						bill.setContractId(tbill.getID());
						bill.setCreateUser(WebConfig.getUser());
						try{
							m_BillMapper.InsertBills(bill, id, i, tbill.getID());
						}catch(Exception error){
							result.setCode(error.hashCode());
							result.setMsg(error.getMessage());
							return result;
						}

					}
				}
				else{
					tbill = new TBill();
				}
				i = i-1;
			}
			x = x+1;
		}
		return result;
	}

	@RequestMapping(value = "/Finance/replaceBillFee", method = RequestMethod.POST)
	public Result replaceBillFee(int bid) {
		Result result = new Result();
		java.util.List<BillFee> bf = new java.util.ArrayList<BillFee>();
		try{
			bf = m_BillFeeMapper.getBillFeeBybids(bid, 1);
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		if(bf.size()>0){
			result.setCode(500);
			result.setMsg("当前账单有内容以提交，请取消后重试！");
		}
		else{
			String user = "";
			user = WebConfig.getUser();
			try{
				m_BillFeeMapper.ReplaceBillFee(bid, user);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				return result;
			}

		}
		return result;
	}

	@RequestMapping(value = "/Finance/updateBill", method = RequestMethod.POST)
	public Result updateBill(@RequestBody Bill bill) {
		Result result = new Result();
		try{
			m_BillMapper.updateBill(bill);
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	@RequestMapping(value = "/Finance/updateBillFee", method = RequestMethod.POST)
	public Result updateBillFee(@RequestBody BillFee billfee) {
		Result result = new Result();
		try{
			m_BillFeeMapper.updateBillFee(billfee);
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	@RequestMapping(value = "/Finance/updateInvoice", method = RequestMethod.POST)
	public Result updateInvoice(@RequestBody Bs bs) {
		Result result = new Result();
		Table t = new Table();
		String user = "";
		user = WebConfig.getUser();
		bs.getinvoice().setCreateUser(user);
		if(bs.getinvoice().getID()>0){
			try{
				m_InvoiceMapper.updateInvoice(bs.getinvoice());
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				return result;
			}

		}
		else{
			try{
				m_InvoiceMapper.insertInvoice(bs.getinvoice());
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				return result;
			}

			try{
				t = m_DBMapper.getTableID();
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				return result;
			}

			try{
				if(bs.getids().size()>0){
					m_InvoiceMapper.updateBillFees(bs.getids(), t.getID());
				}
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				return result;
			}

			try{
				if(bs.getids().size()>0){
					m_InvoiceItemMapper.insertInvoiceItem(bs.getids());
				}
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				return result;
			}

		}
		return result;
	}

	@RequestMapping(value = "/Finance/updatePay", method = RequestMethod.POST)
	public Result updatePay(@RequestBody Ps ps) {
		Result result = new Result();
		String user = "";
		user = WebConfig.getUser();
		ps.getpay().setCreateUser(user);
		if(ps.getpay().getID()>0){
			try{
				m_PayMapper.updatePay(ps.getpay());
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				return result;
			}

		}
		else{
			try{
				m_PayMapper.insertPay(ps.getpay());
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				return result;
			}

			try{
				if(ps.getids().size()>0){
					m_PayCheckMapper.InsertsPayCheck(ps.getids(), user);
				}
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				return result;
			}

		}
		return result;
	}

}
