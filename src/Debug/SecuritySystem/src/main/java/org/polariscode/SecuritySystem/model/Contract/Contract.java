package org.polariscode.SecuritySystem.model.Contract;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;

@Component
public class Contract implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static Contract m_Contract;

	@PostConstruct 
	public void init(){
		m_Contract=this;
		m_Contract.dictionaryService=this.dictionaryService;
	}

	private int ID = 0;
	public int getID(){
		return this.ID;
	}
	public void setID(int value){
		this.ID = value;
	}

	private String ContractCode = "";
	//合同编号
	public String getContractCode(){
		return this.ContractCode;
	}
	public void setContractCode(String value){
		this.ContractCode = value;
	}

	private int CustomerId = 0;
	//客户
	public int getCustomerId(){
		return this.CustomerId;
	}
	public void setCustomerId(int value){
		this.CustomerId = value;
	}

	private String CustomerId_Convert="";
	public String getCustomerId_Convert(){
		CustomerId_Convert = m_Contract.dictionaryService.convertDictionary("Customer", String.valueOf(CustomerId));
		if(CustomerId_Convert == null) CustomerId_Convert = "";
		return CustomerId_Convert;
	}
	public void setCustomerId_Convert(String value){
		this.CustomerId_Convert = value;
	}

	private int CompanyId = 0;
	//我方公司
	public int getCompanyId(){
		return this.CompanyId;
	}
	public void setCompanyId(int value){
		this.CompanyId = value;
	}

	private String CompanyId_Convert="";
	public String getCompanyId_Convert(){
		CompanyId_Convert = m_Contract.dictionaryService.convertDictionary("Company", String.valueOf(CompanyId));
		if(CompanyId_Convert == null) CompanyId_Convert = "";
		return CompanyId_Convert;
	}
	public void setCompanyId_Convert(String value){
		this.CompanyId_Convert = value;
	}

	private int OrgId = 0;
	//所属部门
	public int getOrgId(){
		return this.OrgId;
	}
	public void setOrgId(int value){
		this.OrgId = value;
	}

	private String OrgId_Convert="";
	public String getOrgId_Convert(){
		OrgId_Convert = m_Contract.dictionaryService.convertDictionary("SiteOrg", String.valueOf(OrgId));
		if(OrgId_Convert == null) OrgId_Convert = "";
		return OrgId_Convert;
	}
	public void setOrgId_Convert(String value){
		this.OrgId_Convert = value;
	}

	private java.util.Date BeginDate = null;
	//开始日期
	public java.util.Date getBeginDate(){
		return this.BeginDate;
	}
	public void setBeginDate(java.util.Date value){
		this.BeginDate = value;
	}

	private java.util.Date EndDate = null;
	//结束日期
	public java.util.Date getEndDate(){
		return this.EndDate;
	}
	public void setEndDate(java.util.Date value){
		this.EndDate = value;
	}

	private java.util.Date InDate = null;
	//进场日期
	public java.util.Date getInDate(){
		return this.InDate;
	}
	public void setInDate(java.util.Date value){
		this.InDate = value;
	}

	private int PNumber = 0;
	//合同人数
	public int getPNumber(){
		return this.PNumber;
	}
	public void setPNumber(int value){
		this.PNumber = value;
	}

	private double AvgAmount = 0.0;
	//合同单价
	public double getAvgAmount(){
		return this.AvgAmount;
	}
	public void setAvgAmount(double value){
		this.AvgAmount = value;
	}

	private double TotalAmount = 0.0;
	//总金额
	public double getTotalAmount(){
		return this.TotalAmount;
	}
	public void setTotalAmount(double value){
		this.TotalAmount = value;
	}

	private String MonthlyAmount = "";
	//每月金额
	public String getMonthlyAmount(){
		return this.MonthlyAmount;
	}
	public void setMonthlyAmount(String value){
		this.MonthlyAmount = value;
	}

	private double Wages = 0.0;
	//建议工资
	public double getWages(){
		return this.Wages;
	}
	public void setWages(double value){
		this.Wages = value;
	}

	private String AAgent = "";
	//甲方经办人
	public String getAAgent(){
		return this.AAgent;
	}
	public void setAAgent(String value){
		this.AAgent = value;
	}

	private String ASubscriber = "";
	//甲方签约人
	public String getASubscriber(){
		return this.ASubscriber;
	}
	public void setASubscriber(String value){
		this.ASubscriber = value;
	}

	private java.util.Date ASigningTtime = null;
	//甲方签约时间
	public java.util.Date getASigningTtime(){
		return this.ASigningTtime;
	}
	public void setASigningTtime(java.util.Date value){
		this.ASigningTtime = value;
	}

	private String BAgent = "";
	//乙方经办人
	public String getBAgent(){
		return this.BAgent;
	}
	public void setBAgent(String value){
		this.BAgent = value;
	}

	private String BSubscriber = "";
	//乙方签约人
	public String getBSubscriber(){
		return this.BSubscriber;
	}
	public void setBSubscriber(String value){
		this.BSubscriber = value;
	}

	private java.util.Date BSigningTtime = null;
	//乙方签约时间
	public java.util.Date getBSigningTtime(){
		return this.BSigningTtime;
	}
	public void setBSigningTtime(java.util.Date value){
		this.BSigningTtime = value;
	}

	private String SpecialNeed = "";
	//特殊需求
	public String getSpecialNeed(){
		return this.SpecialNeed;
	}
	public void setSpecialNeed(String value){
		this.SpecialNeed = value;
	}

	private int LogisticsEat = 0;
	//餐饮需求
	public int getLogisticsEat(){
		return this.LogisticsEat;
	}
	public void setLogisticsEat(int value){
		this.LogisticsEat = value;
	}

	private String LogisticsEat_Convert="";
	public String getLogisticsEat_Convert(){
		switch(String.valueOf(LogisticsEat)) {
		case "0":
			return "无需求";
		case "1":
			return "甲方提供工作餐";
		case "2":
			return "我方提供工作餐";
		case "3":
			return "我方提供餐费";
		}
		return LogisticsEat_Convert;
	}
	public void setLogisticsEat_Convert(String value){
		this.LogisticsEat_Convert = value;
	}

	private int LogisticsHome = 0;
	//住宿需求
	public int getLogisticsHome(){
		return this.LogisticsHome;
	}
	public void setLogisticsHome(int value){
		this.LogisticsHome = value;
	}

	private String LogisticsHome_Convert="";
	public String getLogisticsHome_Convert(){
		switch(String.valueOf(LogisticsHome)) {
		case "0":
			return "客户安排住宿";
		case "1":
			return "我方安排住宿";
		}
		return LogisticsHome_Convert;
	}
	public void setLogisticsHome_Convert(String value){
		this.LogisticsHome_Convert = value;
	}

	private String LogisticsNeed = "";
	//后勤其它需求
	public String getLogisticsNeed(){
		return this.LogisticsNeed;
	}
	public void setLogisticsNeed(String value){
		this.LogisticsNeed = value;
	}

	private String SuperviseNeed = "";
	//督导需求
	public String getSuperviseNeed(){
		return this.SuperviseNeed;
	}
	public void setSuperviseNeed(String value){
		this.SuperviseNeed = value;
	}

	private String TrainNeed = "";
	//培训需求
	public String getTrainNeed(){
		return this.TrainNeed;
	}
	public void setTrainNeed(String value){
		this.TrainNeed = value;
	}

	private int Status = 0;
	//状态
	public int getStatus(){
		return this.Status;
	}
	public void setStatus(int value){
		this.Status = value;
	}

	private String Status_Convert="";
	public String getStatus_Convert(){
		switch(String.valueOf(Status)) {
		case "0":
			return "未审核";
		case "1":
			return "同意";
		case "2":
			return "不同意";
		}
		return Status_Convert;
	}
	public void setStatus_Convert(String value){
		this.Status_Convert = value;
	}

	private int Type = 0;
	//类型
	public int getType(){
		return this.Type;
	}
	public void setType(int value){
		this.Type = value;
	}

	private String Type_Convert="";
	public String getType_Convert(){
		switch(String.valueOf(Type)) {
		case "0":
			return "新上点";
		case "1":
			return "临保";
		case "2":
			return "合同变更";
		case "3":
			return "续签合同";
		case "4":
			return "其他";
		}
		return Type_Convert;
	}
	public void setType_Convert(String value){
		this.Type_Convert = value;
	}

	private boolean Isdelete = false;
	//是否删除
	public boolean getIsdelete(){
		return this.Isdelete;
	}
	public void setIsdelete(boolean value){
		this.Isdelete = value;
	}

	private String CreateUser = "";
	//创建用户
	public String getCreateUser(){
		return this.CreateUser;
	}
	public void setCreateUser(String value){
		this.CreateUser = value;
	}

	private String CreateTime = "";
	//创建时间
	public String getCreateTime(){
		return this.CreateTime;
	}
	public void setCreateTime(String value){
		this.CreateTime = value;
	}

	private String ModifyUser = "";
	//修改用户
	public String getModifyUser(){
		return this.ModifyUser;
	}
	public void setModifyUser(String value){
		this.ModifyUser = value;
	}

	private String ModifyTime = "";
	//修改时间
	public String getModifyTime(){
		return this.ModifyTime;
	}
	public void setModifyTime(String value){
		this.ModifyTime = value;
	}

	private String DeleteUser = "";
	//删除用户
	public String getDeleteUser(){
		return this.DeleteUser;
	}
	public void setDeleteUser(String value){
		this.DeleteUser = value;
	}

	private String DeleteTime = "";
	//删除时间
	public String getDeleteTime(){
		return this.DeleteTime;
	}
	public void setDeleteTime(String value){
		this.DeleteTime = value;
	}

	private String wagesType = "";
	//工资类型
	public String getwagesType(){
		return this.wagesType;
	}
	public void setwagesType(String value){
		this.wagesType = value;
	}

	private String wagesType_Convert="";
	public String getwagesType_Convert(){
		switch(String.valueOf(wagesType)) {
		case "0":
			return "每月工资";
		case "1":
			return "每班工资";
		}
		return wagesType_Convert;
	}
	public void setwagesType_Convert(String value){
		this.wagesType_Convert = value;
	}

	private int InvoiceCompany = 0;
	//开票单位
	public int getInvoiceCompany(){
		return this.InvoiceCompany;
	}
	public void setInvoiceCompany(int value){
		this.InvoiceCompany = value;
	}

	private String InvoiceCompany_Convert="";
	public String getInvoiceCompany_Convert(){
		InvoiceCompany_Convert = m_Contract.dictionaryService.convertDictionary("Company", String.valueOf(InvoiceCompany));
		if(InvoiceCompany_Convert == null) InvoiceCompany_Convert = "";
		return InvoiceCompany_Convert;
	}
	public void setInvoiceCompany_Convert(String value){
		this.InvoiceCompany_Convert = value;
	}

	private String InvoiceTitle = "";
	//发票抬头
	public String getInvoiceTitle(){
		return this.InvoiceTitle;
	}
	public void setInvoiceTitle(String value){
		this.InvoiceTitle = value;
	}

	private String InvoiceTax = "";
	//税号
	public String getInvoiceTax(){
		return this.InvoiceTax;
	}
	public void setInvoiceTax(String value){
		this.InvoiceTax = value;
	}

}
