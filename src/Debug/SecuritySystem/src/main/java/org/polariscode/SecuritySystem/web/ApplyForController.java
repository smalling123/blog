package org.polariscode.SecuritySystem.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.polariscode.SecuritySystem.config.Global;
import org.polariscode.SecuritySystem.model.Result;
import org.polariscode.SecuritySystem.model.ApplyFor.EmployeeApplication;
import org.polariscode.SecuritySystem.model.Table;
import org.polariscode.SecuritySystem.mapper.ApplyFor.DBEmployeeApplication;
import org.polariscode.SecuritySystem.model.ApplyFor.UserImg;
import org.polariscode.SecuritySystem.mapper.ApplyFor.DBUserImg;
import org.springframework.transaction.annotation.Transactional;
import org.polariscode.SecuritySystem.model.ApplyFor.Application;
import org.polariscode.SecuritySystem.model.ApplyFor.ProcessNode;
import org.polariscode.SecuritySystem.config.WebConfig;
import org.polariscode.SecuritySystem.mapper.ApplyFor.DBProcessNode;
import org.polariscode.SecuritySystem.model.ApplyFor.ToDoList;
import org.polariscode.SecuritySystem.mapper.ApplyFor.DBToDoList;
import org.polariscode.SecuritySystem.model.Permission.User;
import org.polariscode.SecuritySystem.mapper.Permission.UserMapper;

@RestController
public class ApplyForController{

	@Autowired
	private DBEmployeeApplication m_DBEmployeeApplication;

	@Autowired
	private DBUserImg m_DBUserImg;

	@Autowired
	private DBProcessNode m_DBProcessNode;

	@Autowired
	private DBToDoList m_DBToDoList;

	@Autowired
	private UserMapper m_UserMapper;

	//用户上传图片申请
	@RequestMapping(value = "/ApplyFor/Application", method = RequestMethod.POST)
	@Transactional
	public Result Application(@RequestBody Application application) {
		Result result = new Result();
		int gender = 0;
		if(application.getGender().equals("男")==true){
			gender = 1;
		}
		else{
			gender = 0;
		}
		EmployeeApplication emp = new EmployeeApplication();
		emp.setName(application.getName());
		emp.setGender(gender);
		emp.setBirthday(application.getBirthday());
		emp.setCardNo(application.getCardNo());
		emp.setPassword("123456");
		emp.setAddress(application.getAddress());
		emp.setStatus(-1);
		Table tb = new Table();
		try{
			tb = m_DBEmployeeApplication.getCountByCardNo(application.getCardNo());
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		Table tabId = new Table();
		if(tb.getCount()>0){
			try{
				tabId = m_DBEmployeeApplication.getEmpByCardNo(application.getCardNo());
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
			try{
				m_DBEmployeeApplication.UpdateEmployee(emp, tabId.getID());
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
		}
		else{
			try{
				m_DBEmployeeApplication.InsertEmployee(emp);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
			try{
				tabId = m_DBEmployeeApplication.getEmpByCardNo(application.getCardNo());
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
		}
		Table table = new Table();
		try{
			table = m_DBEmployeeApplication.getEmpByCardNo(application.getCardNo());
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		UserImg userImg1 = new UserImg();
		userImg1.setEid(table.getID());
		userImg1.setImg(application.getFileimg1());
		userImg1.setType("1");
		userImg1.setStatus("0");
		if(tb.getCount()>0){
		}
		else{
			try{
				m_DBUserImg.InsertUserImg(userImg1);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
		}
		UserImg userImg2 = new UserImg();
		userImg2.setEid(table.getID());
		userImg2.setImg(application.getFileimg2());
		userImg2.setType("2");
		userImg2.setStatus("0");
		if(tb.getCount()>0){
		}
		else{
			try{
				m_DBUserImg.InsertUserImg(userImg2);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
		}
		result.setData(tabId.getID());
		return result;
	}

	//添加语言技能
	@RequestMapping(value = "/ApplyFor/LanguageApplication", method = RequestMethod.POST)
	public Result LanguageApplication(@RequestBody EmployeeApplication emp) {
		Result result = new Result();
		try{
			m_DBEmployeeApplication.UpdateLanguage(emp);
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	//审核
	@RequestMapping(value = "/ApplyFor/ManagementApproval", method = RequestMethod.POST)
	@Transactional
	public Result ManagementApproval(int id) {
		Result result = new Result();
		EmployeeApplication emp = new EmployeeApplication();
		//根据Id获取申请信息
		try{
			emp = m_DBEmployeeApplication.getEmployeeApplicationById(id);
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		ProcessNode Process = new ProcessNode();
		String user = "";
		user = WebConfig.getUser();
		int ProcessNo = 0;
		ProcessNo = 2;
		//查询当前用户所对角色
		try{
			Process = m_DBProcessNode.getUserProcessNode(user, emp.getStatus());
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		Table Table = new Table();
		//获取最大待办
		try{
			Table = m_DBProcessNode.getMax();
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		ToDoList toList = new ToDoList();
		//判断是否为最后一步审批
		if(Table.getID()==emp.getStatus()){
			//修改上一个待办
			try{
				m_DBToDoList.UpdateToDoListStatus(Process.getProcessNode(), id);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
			emp.setStatus(ProcessNo);
			emp.setPeoples(user);
			//修改申请流程流程状态
			try{
				m_DBEmployeeApplication.UpdateStatus(emp);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
			toList.setOwnerID(Process.getProcessRole());
			toList.setCreatorCn(emp.getName());
			toList.setApplicantCn(user);
			toList.setApplicationNo(id);
			toList.setProcName(Process.getProcessName());
			toList.setStatus(0);
			toList.setActivityName(Process.getProcessNode());
			//添加此条待办
			try{
				m_DBToDoList.InsertToDoList(toList);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
			User DBUser = new User();
			DBUser.setLoginName(emp.getAccount());
			DBUser.setName(emp.getName());
			DBUser.setPassword(emp.getPassword());
			DBUser.setPhone(emp.getMobile());
			DBUser.setGender(emp.getGender());
			DBUser.setEmail(emp.getEMail());
			DBUser.setAddress(emp.getAddress());
			DBUser.setBirthday(emp.getBirthday());
			DBUser.setStatus(0);
			//添加到用户表
			try{
				m_UserMapper.InsertUser(DBUser);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
			Table tabe = new Table();
			//根据账号查询用户ID
			try{
				tabe = m_UserMapper.getUserId(emp.getAccount());
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
			emp.setUse_id(tabe.getID());
			try{
				m_DBEmployeeApplication.UpdateStatus(emp);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
			//在图像表里面插入用户ID
			try{
				m_DBUserImg.UpdateUserId(id, tabe.getID());
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
		}
		else{
			//修改上一个待办
			try{
				m_DBToDoList.UpdateToDoListStatus(Process.getProcessNode(), id);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
			emp.setStatus(ProcessNo);
			emp.setPeoples(user);
			//修改申请流程表里面的待办状态
			try{
				m_DBEmployeeApplication.UpdateStatus(emp);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
			ProcessNode proc = new ProcessNode();
			//获取待办
			try{
				proc = m_DBProcessNode.getProcessNode(ProcessNo);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
			toList.setActivityName(proc.getProcessNode());
			toList.setOwnerID(Process.getProcessRole());
			toList.setCreatorCn(emp.getName());
			toList.setApplicantCn(user);
			toList.setApplicationNo(id);
			toList.setProcName(Process.getProcessName());
			toList.setStatus(0);
			//添加此条待办
			try{
				m_DBToDoList.InsertToDoList(toList);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
		}
		return result;
	}

	@RequestMapping(value = "/ApplyFor/ManagementApprovals", method = RequestMethod.POST)
	public Result ManagementApprovals(int id) {
		Result result = new Result();
		try{
			m_DBEmployeeApplication.UpdateEmployeeByStatus(id);
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	//添加其他填写
	@RequestMapping(value = "/ApplyFor/TheuserApplication", method = RequestMethod.POST)
	@Transactional
	public Result TheuserApplication(@RequestBody EmployeeApplication emp) {
		Result result = new Result();
		EmployeeApplication em = new EmployeeApplication();
		//根据ID获取当前条的流程信息
		try{
			em = m_DBEmployeeApplication.getEmployeeApplicationById(emp.getId());
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		emp.setStatus(0);
		//添加其他修改并修改申请流程表中的流程状态
		try{
			m_DBEmployeeApplication.UpdateRests(emp);
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		ProcessNode Process = new ProcessNode();
		//查询到第一个流程节点信息
		try{
			Process = m_DBProcessNode.getProcessNodeToList();
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		ToDoList todolist = new ToDoList();
		todolist.setOwnerID(Process.getProcessRole());
		todolist.setCreatorCn(em.getName());
		todolist.setApplicantCn(em.getName());
		todolist.setApplicationNo(em.getId());
		todolist.setProcName(Process.getProcessName());
		todolist.setStatus(0);
		todolist.setActivityName(Process.getProcessNode());
		//添加待办
		try{
			m_DBToDoList.InsertToDoList(todolist);
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		return result;
	}

	//添加基础信息
	@RequestMapping(value = "/ApplyFor/TwoApplication", method = RequestMethod.POST)
	@Transactional
	public Result TwoApplication(@RequestBody EmployeeApplication emp) {
		Result result = new Result();
		Table Count1 = new Table();
		Table Count2 = new Table();
		try{
			Count1 = m_DBEmployeeApplication.getByAccount(emp.getAccount());
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		try{
			Count2 = m_UserMapper.getCountByLoginName(emp.getAccount());
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			throw error;
		}
		if(Count1.getCount()==0 & Count2.getCount()==0){
			try{
				m_DBEmployeeApplication.UpdateTowEmployee(emp);
			}catch(Exception error){
				result.setCode(error.hashCode());
				result.setMsg(error.getMessage());
				throw error;
			}
		}
		else{
			result.setCode(99);
			result.setMsg("系统提示：账号已存在！");
		}
		return result;
	}

}
