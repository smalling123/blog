package org.polariscode.SecuritySystem.web.ApplyFor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.polariscode.SecuritySystem.config.Global;
import org.polariscode.SecuritySystem.model.Result;
import org.polariscode.SecuritySystem.mapper.ApplyFor.DBEmployeeApplication;
import org.polariscode.SecuritySystem.model.Table;
import org.polariscode.SecuritySystem.model.ApplyFor.EmployeeApplication;
import org.polariscode.SecuritySystem.mapper.ApplyFor.DBUserImg;
import org.polariscode.SecuritySystem.mapper.ApplyFor.DBFamily;
import org.polariscode.SecuritySystem.mapper.ApplyFor.DBEducationalTraining;
import org.polariscode.SecuritySystem.mapper.ApplyFor.DBWorkExperience;
import org.polariscode.SecuritySystem.config.WebConfig;
import org.polariscode.SecuritySystem.mapper.ApplyFor.DBToDoList;

@RestController
public class EmpLoyeeController{

	@Autowired
	private DBEmployeeApplication m_DBEmployeeApplication;

	@Autowired
	private DBUserImg m_DBUserImg;

	@Autowired
	private DBFamily m_DBFamily;

	@Autowired
	private DBEducationalTraining m_DBEducationalTraining;

	@Autowired
	private DBWorkExperience m_DBWorkExperience;

	@Autowired
	private DBToDoList m_DBToDoList;

	//查询所有申请流程
	@RequestMapping(value = "/ApplyFor/EmpLoyee/getAllEmpLoyee", method = RequestMethod.POST)
	public Result getAllEmpLoyee(int pageNumber, int pageSize) {
		Result result = new Result();
		try{
			result.setData(m_DBEmployeeApplication.getAllEmployeeApplication(pageNumber<=0?0:(pageNumber-1)*pageSize, pageSize));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		Table table = new Table();
		try{
			table = m_DBEmployeeApplication.getCount();
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

	//查询 EmpID
	@RequestMapping(value = "/ApplyFor/EmpLoyee/getEmpByCardNo", method = RequestMethod.POST)
	public Result getEmpByCardNo(String cardNo) {
		Result result = new Result();
		try{
			result.setData(m_DBEmployeeApplication.getEmpByCardNo(cardNo));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	//查询empID
	@RequestMapping(value = "/ApplyFor/EmpLoyee/getEmpID", method = RequestMethod.POST)
	public Result getEmpID(String account) {
		Result result = new Result();
		try{
			result.setData(m_DBEmployeeApplication.getID(account));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

	//根据ID查询用户申请流程
	@RequestMapping(value = "/ApplyFor/EmpLoyee/getEmpLoyeeById", method = RequestMethod.POST)
	public Result getEmpLoyeeById(int id) {
		Result result = new Result();
		EmployeeApplication Emp = new EmployeeApplication();
		try{
			Emp.setUserImgs(m_DBUserImg.getByEid(0));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		//根据ID查询基础信息
		try{
			Emp = m_DBEmployeeApplication.getEmployeeApplicationById(id);
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		//根据ID查询家庭信息
		try{
			Emp.setFamilys(m_DBFamily.getFamilyByEid(id));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		//根据ID查询教育信息
		try{
			Emp.setEducationalTrainings(m_DBEducationalTraining.getEducationalByEId(id));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		//根据ID查询工作信息
		try{
			Emp.setWorkExperiences(m_DBWorkExperience.getWorkByEid(id));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		try{
			Emp.setUserImgs(m_DBUserImg.getUserImgByEid(id, ""));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		result.setData(Emp);
		return result;
	}

	@RequestMapping(value = "/ApplyFor/EmpLoyee/getEmployeeT", method = RequestMethod.POST)
	public Result getEmployeeT(String name, String education, String gender, int pageNumber, int pageSize) {
		Result result = new Result();
		try{
			result.setData(m_DBEmployeeApplication.getEmployeeT(name, education, gender, pageNumber<=0?0:(pageNumber-1)*pageSize, pageSize));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		Table table = new Table();
		try{
			table = m_DBEmployeeApplication.getEmployeeTByCount(name, education, gender);
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

	//根据账号查看待办
	@RequestMapping(value = "/ApplyFor/EmpLoyee/getTolistByAccount", method = RequestMethod.POST)
	public Result getTolistByAccount(int pageNumber, int pageSize) {
		Result result = new Result();
		String account = "";
		account = WebConfig.getUser();
		try{
			result.setData(m_DBToDoList.getToDoListByAccount(pageNumber<=0?0:(pageNumber-1)*pageSize, pageSize, account));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		Table table = new Table();
		try{
			table = m_DBToDoList.getCountByAccount(account, "", "", "", "");
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

	//查询详情(全部)待办
	@RequestMapping(value = "/ApplyFor/EmpLoyee/getTolistDetails", method = RequestMethod.POST)
	public Result getTolistDetails(int pageNumber, int pageSize, String applicantCn, String creatorCn, String begincreatedDate, String endcreatedDate) {
		Result result = new Result();
		String account = "";
		account = WebConfig.getUser();
		try{
			result.setData(m_DBToDoList.getToDoListDetails(account, applicantCn, creatorCn, begincreatedDate, endcreatedDate, pageNumber<=0?0:(pageNumber-1)*pageSize, pageSize));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		Table table = new Table();
		try{
			table = m_DBToDoList.getCountByAccount(account, applicantCn, creatorCn, begincreatedDate, endcreatedDate);
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

	//查询未审批申查
	@RequestMapping(value = "/ApplyFor/EmpLoyee/getUnreviewedEmp", method = RequestMethod.POST)
	public Result getUnreviewedEmp(String name, String education, String gender, int pageNumber, int pageSize) {
		Result result = new Result();
		Table table = new Table();
		try{
			table = m_DBEmployeeApplication.getUnreviewedEmpCount(name, education, gender);
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		try{
			result.setData(m_DBEmployeeApplication.getUnreviewedEmp(pageNumber<=0?0:(pageNumber-1)*pageSize, pageSize, name, education, gender));
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

	//用户审批接口
	@RequestMapping(value = "/ApplyFor/EmpLoyee/getUserEmpLoyee", method = RequestMethod.POST)
	public Result getUserEmpLoyee(String name, String education, String gender, int pageNumber, int pageSize) {
		Result result = new Result();
		try{
			result.setData(m_DBEmployeeApplication.getEmployeeByAccount(name, education, gender, pageNumber<=0?0:(pageNumber-1)*pageSize, pageSize));
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		Table table = new Table();
		try{
			table = m_DBEmployeeApplication.getEmployeeCount(name, education, gender);
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

	//修改申请流程信息
	@RequestMapping(value = "/ApplyFor/EmpLoyee/UpdateEmpLoyee", method = RequestMethod.POST)
	public Result UpdateEmpLoyee(@RequestBody EmployeeApplication emp) {
		Result result = new Result();
		String Certificate = "";
		String CardType = "";
		int i = 0;
		int j = 0;
		while(i<emp.getCertificate().size()){
			Certificate+=emp.getCertificate().get(i)+",";
			i = i+1;
		}
		Certificate= Certificate.substring(0,Certificate.length() -1);
		while(j<emp.getCardType().size()){
			CardType+=emp.getCardType().get(j)+",";
			j = j+1;
		}
		CardType= CardType.substring(0,CardType.length() -1);
		try{
			m_DBEmployeeApplication.UpdateEmployeeApplication(emp, Certificate, CardType);
		}catch(Exception error){
			result.setCode(error.hashCode());
			result.setMsg(error.getMessage());
			return result;
		}

		return result;
	}

}
