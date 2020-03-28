package org.polariscode.SecuritySystem.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.polariscode.SecuritySystem.config.Global;
import org.polariscode.SecuritySystem.model.Result;
import org.polariscode.SecuritySystem.mapper.Workflow.WorkflowMapper;
import org.polariscode.SecuritySystem.model.Table;
import org.springframework.transaction.annotation.Transactional;
import org.polariscode.SecuritySystem.model.Workflow.Expenses;
import org.polariscode.SecuritySystem.mapper.Workflow.ExpensesMapper;
import org.polariscode.SecuritySystem.mapper.Workflow.FeeMapper;
import org.polariscode.SecuritySystem.config.WebConfig;
import org.polariscode.SecuritySystem.mapper.Workflow.SealMapper;
import org.polariscode.SecuritySystem.model.Permission.User;
import org.polariscode.SecuritySystem.mapper.Permission.UserMapper;
import org.polariscode.SecuritySystem.mapper.DBMapper;
import org.polariscode.SecuritySystem.model.Workflow.Fee;
import org.polariscode.SecuritySystem.model.Workflow.Seal;

@RestController
public class WorkflowController{

	@Autowired
	private WorkflowMapper m_WorkflowMapper;

	@Autowired
	private ExpensesMapper m_ExpensesMapper;

	@Autowired
	private FeeMapper m_FeeMapper;

	@Autowired
	private SealMapper m_SealMapper;

	@Autowired
	private UserMapper m_UserMapper;

	@Autowired
	private DBMapper m_DBMapper;

	//提交审核
	@RequestMapping(value = "/Workflow/checkWorkflow", method = RequestMethod.POST)
	@Transactional
	public Result checkWorkflow(int id, int wid, String content, int status) {
		Result result = new Result();
		//更新WorkflowItem
		try{
			m_WorkflowMapper.UpdateWorkflowItem(content, status, id);
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		if(status == 2){
			//更新流程为不通过
			try{
				m_WorkflowMapper.UpdateWorkflow(wid, 2, id);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
		}
		else{
			Table table = new Table();
			//获取下一节点ID
			try{
				table = m_WorkflowMapper.getNextItem(wid, id);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
			if(table.getID() == 0){
				//更新流程为成功
				try{
					m_WorkflowMapper.UpdateWorkflow(wid, 1, id);
				}catch(Exception error){
					result.setCode(error.hashCode());
					result.setMsg(error.getMessage());
					throw error;
				}
			}
			else{
				//更新流程到下一节点
				try{
					m_WorkflowMapper.UpdateWorkflow(wid, 0, table.getID());
				}catch(Exception error){
					result.setCode(error.hashCode());
					result.setMsg(error.getMessage());
					throw error;
				}
			}
		}
		return result;
	}

	//获取印鉴记录
	@RequestMapping(value = "/Workflow/getExpensesById", method = RequestMethod.POST)
	public Result getExpensesById(int id) {
		Result result = new Result();
		Expenses expenses = new Expenses();
		try{
			expenses = m_ExpensesMapper.getExpensesOne(id);
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		try{
			expenses.setItems(m_ExpensesMapper.getExpensesItems(id));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		result.setData(expenses);
		return result;
	}

	//获取印鉴记录
	@RequestMapping(value = "/Workflow/getFeeById", method = RequestMethod.POST)
	public Result getFeeById(int id) {
		Result result = new Result();
		try{
			result.setData(m_FeeMapper.getFeeOne(id));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	@RequestMapping(value = "/Workflow/getMyOKTask", method = RequestMethod.POST)
	public Result getMyOKTask() {
		Result result = new Result();
		String user = "";
		user = WebConfig.getUser();
		try{
			result.setData(m_WorkflowMapper.getMyOKTask(user));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	//获取我的待审批记录
	@RequestMapping(value = "/Workflow/getMyTask", method = RequestMethod.POST)
	public Result getMyTask() {
		Result result = new Result();
		String user = "";
		user = WebConfig.getUser();
		try{
			result.setData(m_WorkflowMapper.getMyTask(user));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	//获取我提交的审批记录
	@RequestMapping(value = "/Workflow/getMyWorkflow", method = RequestMethod.POST)
	public Result getMyWorkflow() {
		Result result = new Result();
		String user = "";
		user = WebConfig.getUser();
		try{
			result.setData(m_WorkflowMapper.getMyWorkflow(user));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	//获取印鉴记录
	@RequestMapping(value = "/Workflow/getSealById", method = RequestMethod.POST)
	public Result getSealById(int id) {
		Result result = new Result();
		try{
			result.setData(m_SealMapper.getSealOne(id));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	//获取指定流程的审批明细
	@RequestMapping(value = "/Workflow/getWorkflowItems", method = RequestMethod.POST)
	public Result getWorkflowItems(int id) {
		Result result = new Result();
		try{
			result.setData(m_WorkflowMapper.getWorkflowItems(id));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	//获取指定流程的流转记录
	@RequestMapping(value = "/Workflow/getWorkflowItemsByCheck", method = RequestMethod.POST)
	public Result getWorkflowItemsByCheck(int id) {
		Result result = new Result();
		try{
			result.setData(m_WorkflowMapper.getWorkflowItemsByCheck(id));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	//提交新的印鉴申请
	@RequestMapping(value = "/Workflow/insertExpenses", method = RequestMethod.POST)
	@Transactional
	public Result insertExpenses(@RequestBody Expenses expenses) {
		Result result = new Result();
		String user = "";
		//获取当前登录用户名
		user = WebConfig.getUser();
		User u = new User();
		//根据user获取当前用户信息并赋值给u
		try{
			u = m_UserMapper.getUserOne(user);
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		//为Expenses赋值当前用户的ID
		expenses.setUserID(u.getID());
		expenses.setOrgID(u.getOrgID());
		//插入Expenses 
		try{
			m_ExpensesMapper.InsertExpenses(expenses);
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		Table table = new Table();
		//获取Expenses的自增ID
		try{
			table = m_DBMapper.getTableID();
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		//插入报销的明细项
		try{
			if(expenses.getItems().size()>0){
				m_ExpensesMapper.insertExpensesItems(expenses.getItems(), table.getID());
			}
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		//更新合计金额
		try{
			m_ExpensesMapper.updateExpenses(table.getID());
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		//生成Workflow
		try{
			m_ExpensesMapper.InsertExpensesWorkflow(table.getID(), user);
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		Table wf = new Table();
		//获取Workflow的自增ID
		try{
			wf = m_DBMapper.getTableID();
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		//生成WorkflowItem第1条
		try{
			m_ExpensesMapper.InsertExpensesW1(user, wf.getID());
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		Table workflow = new Table();
		//获取第一条WorkFlowItem的自增ID
		try{
			workflow = m_DBMapper.getTableID();
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		try{
			m_ExpensesMapper.InsertExpensesW2(user, wf.getID());
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		try{
			m_ExpensesMapper.InsertExpensesW5(wf.getID());
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		try{
			m_ExpensesMapper.InsertExpensesW6(wf.getID());
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		//更新Workflow当前节点为第1条记录
		try{
			m_WorkflowMapper.UpdateWorkflow(wf.getID(), 0, workflow.getID());
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		//更新Expenses的WorkflowID
		try{
			m_ExpensesMapper.UpdateExpensesWorkflowID(table.getID(), wf.getID());
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		//将Expenses的自增ID赋给Result.Data
		result.setData(table.getID());
		return result;
	}

	//提交新的印鉴申请
	@RequestMapping(value = "/Workflow/insertFee", method = RequestMethod.POST)
	@Transactional
	public Result insertFee(@RequestBody Fee fee) {
		Result result = new Result();
		String user = "";
		//获取当前登录用户名
		user = WebConfig.getUser();
		User u = new User();
		//根据user获取当前用户信息并赋值给u
		try{
			u = m_UserMapper.getUserOne(user);
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		//为Fee赋值当前用户的ID
		fee.setUserID(u.getID());
		fee.setOrgID(u.getOrgID());
		//往数据库中插入Fee 
		try{
			m_FeeMapper.InsertFee(fee);
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		Table table = new Table();
		//获取Fee的自增ID
		try{
			table = m_DBMapper.getTableID();
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		//生成Workflow
		try{
			m_FeeMapper.InsertFeeWorkflow(table.getID(), user);
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		Table wf = new Table();
		//获取Workflow的自增ID
		try{
			wf = m_DBMapper.getTableID();
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		//生成WorkflowItem第1条
		try{
			m_FeeMapper.InsertFeeW1(user, wf.getID());
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		Table workflow = new Table();
		//获取第一条WorkFlowItem的自增ID
		try{
			workflow = m_DBMapper.getTableID();
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		try{
			m_FeeMapper.InsertFeeW2(user, wf.getID());
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		try{
			m_FeeMapper.InsertFeeW5(wf.getID());
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		try{
			m_FeeMapper.InsertFeeW6(wf.getID());
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		//更新Workflow当前节点为第1条记录
		try{
			m_WorkflowMapper.UpdateWorkflow(wf.getID(), 0, workflow.getID());
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		//更新Fee的WorkflowID
		try{
			m_FeeMapper.UpdateFeeWorkflowID(table.getID(), wf.getID());
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		//将Fee的自增ID赋给Result.Data
		result.setData(table.getID());
		return result;
	}

	//提交新的印鉴申请
	@RequestMapping(value = "/Workflow/insertSeal", method = RequestMethod.POST)
	@Transactional
	public Result insertSeal(@RequestBody Seal seal) {
		Result result = new Result();
		String user = "";
		//获取当前登录用户名
		user = WebConfig.getUser();
		User u = new User();
		//根据user获取当前用户信息并赋值给u
		try{
			u = m_UserMapper.getUserOne(user);
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		//为seal赋值当前用户的ID
		seal.setUserID(u.getID());
		seal.setOrgID(u.getOrgID());
		//插入Seal 
		try{
			m_SealMapper.InsertSeal(seal);
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		Table table = new Table();
		//获取Seal的自增ID
		try{
			table = m_DBMapper.getTableID();
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		//生成Workflow
		try{
			m_SealMapper.InsertSealWorkflow(table.getID(), user);
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		Table wf = new Table();
		//获取Workflow的自增ID
		try{
			wf = m_DBMapper.getTableID();
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		//生成WorkflowItem第1条
		try{
			m_SealMapper.InsertSealW1(user, wf.getID());
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		Table workflow = new Table();
		//获取第一条WorkFlowItem的自增ID
		try{
			workflow = m_DBMapper.getTableID();
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		try{
			m_SealMapper.InsertSealW2(user, wf.getID());
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		if(seal.getType() == 0){
			try{
				m_SealMapper.InsertSealW3(wf.getID());
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
		}
		else{
			try{
				m_SealMapper.InsertSealW4(wf.getID());
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
		}
		try{
			m_SealMapper.InsertSealW5(wf.getID());
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		try{
			m_SealMapper.InsertSealW6(wf.getID());
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		//更新Workflow当前节点为第1条记录
		try{
			m_WorkflowMapper.UpdateWorkflow(wf.getID(), 0, workflow.getID());
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		//更新Seal的WorkflowID
		try{
			m_SealMapper.UpdateSealWorkflowID(table.getID(), wf.getID());
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		//将Seal的自增ID赋给Result.Data
		result.setData(table.getID());
		return result;
	}

}
