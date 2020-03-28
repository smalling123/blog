package org.polariscode.SecuritySystem.model.Finance;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;

@Component
public class Invoice implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static Invoice m_Invoice;

	@PostConstruct 
	public void init(){
		m_Invoice=this;
		m_Invoice.dictionaryService=this.dictionaryService;
	}

	private int ID = 0;
	public int getID(){
		return this.ID;
	}
	public void setID(int value){
		this.ID = value;
	}

	private int CompanyId = 0;
	//开票单位
	public int getCompanyId(){
		return this.CompanyId;
	}
	public void setCompanyId(int value){
		this.CompanyId = value;
	}

	private String CompanyId_Convert="";
	public String getCompanyId_Convert(){
		CompanyId_Convert = m_Invoice.dictionaryService.convertDictionary("Company", String.valueOf(CompanyId));
		if(CompanyId_Convert == null) CompanyId_Convert = "";
		return CompanyId_Convert;
	}
	public void setCompanyId_Convert(String value){
		this.CompanyId_Convert = value;
	}

	private java.util.Date AppDate = null;
	//申请日期
	public java.util.Date getAppDate(){
		return this.AppDate;
	}
	public void setAppDate(java.util.Date value){
		this.AppDate = value;
	}

	private int UserId = 0;
	//申请人
	public int getUserId(){
		return this.UserId;
	}
	public void setUserId(int value){
		this.UserId = value;
	}

	private String UserId_Convert="";
	public String getUserId_Convert(){
		UserId_Convert = m_Invoice.dictionaryService.convertDictionary("User", String.valueOf(UserId));
		if(UserId_Convert == null) UserId_Convert = "";
		return UserId_Convert;
	}
	public void setUserId_Convert(String value){
		this.UserId_Convert = value;
	}

	private int OrgId = 0;
	//部门
	public int getOrgId(){
		return this.OrgId;
	}
	public void setOrgId(int value){
		this.OrgId = value;
	}

	private String OrgId_Convert="";
	public String getOrgId_Convert(){
		OrgId_Convert = m_Invoice.dictionaryService.convertDictionary("Org", String.valueOf(OrgId));
		if(OrgId_Convert == null) OrgId_Convert = "";
		return OrgId_Convert;
	}
	public void setOrgId_Convert(String value){
		this.OrgId_Convert = value;
	}

	private int SiteId = 0;
	//驻点
	public int getSiteId(){
		return this.SiteId;
	}
	public void setSiteId(int value){
		this.SiteId = value;
	}

	private String SiteId_Convert="";
	public String getSiteId_Convert(){
		SiteId_Convert = m_Invoice.dictionaryService.convertDictionary("Site", String.valueOf(SiteId));
		if(SiteId_Convert == null) SiteId_Convert = "";
		return SiteId_Convert;
	}
	public void setSiteId_Convert(String value){
		this.SiteId_Convert = value;
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
		CustomerId_Convert = m_Invoice.dictionaryService.convertDictionary("Customer", String.valueOf(CustomerId));
		if(CustomerId_Convert == null) CustomerId_Convert = "";
		return CustomerId_Convert;
	}
	public void setCustomerId_Convert(String value){
		this.CustomerId_Convert = value;
	}

	private String TaxNo = "";
	//税号
	public String getTaxNo(){
		return this.TaxNo;
	}
	public void setTaxNo(String value){
		this.TaxNo = value;
	}

	private String Customer = "";
	//开票抬头
	public String getCustomer(){
		return this.Customer;
	}
	public void setCustomer(String value){
		this.Customer = value;
	}

	private String Address = "";
	//地址
	public String getAddress(){
		return this.Address;
	}
	public void setAddress(String value){
		this.Address = value;
	}

	private String BankInfo = "";
	//银行
	public String getBankInfo(){
		return this.BankInfo;
	}
	public void setBankInfo(String value){
		this.BankInfo = value;
	}

	private java.util.Date Date = null;
	//开票日期
	public java.util.Date getDate(){
		return this.Date;
	}
	public void setDate(java.util.Date value){
		this.Date = value;
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
			return "未提交";
		case "1":
			return "已提交";
		case "2":
			return "已开";
		case "3":
			return "已寄";
		}
		return Status_Convert;
	}
	public void setStatus_Convert(String value){
		this.Status_Convert = value;
	}

	private java.util.Date SendDate = null;
	//快递日期
	public java.util.Date getSendDate(){
		return this.SendDate;
	}
	public void setSendDate(java.util.Date value){
		this.SendDate = value;
	}

	private String SendAddress = "";
	//快递地址
	public String getSendAddress(){
		return this.SendAddress;
	}
	public void setSendAddress(String value){
		this.SendAddress = value;
	}

	private String SendName = "";
	//快递收件人
	public String getSendName(){
		return this.SendName;
	}
	public void setSendName(String value){
		this.SendName = value;
	}

	private String SendPhone = "";
	//电话
	public String getSendPhone(){
		return this.SendPhone;
	}
	public void setSendPhone(String value){
		this.SendPhone = value;
	}

	private String Describes = "";
	//备注
	public String getDescribes(){
		return this.Describes;
	}
	public void setDescribes(String value){
		this.Describes = value;
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

	private String KpUser = "";
	//开票用户
	public String getKpUser(){
		return this.KpUser;
	}
	public void setKpUser(String value){
		this.KpUser = value;
	}

	private String KpTime = "";
	//开票时间
	public String getKpTime(){
		return this.KpTime;
	}
	public void setKpTime(String value){
		this.KpTime = value;
	}

	private String KpTime_Convert="";
	public String getKpTime_Convert(){
		switch(String.valueOf(KpTime)) {
		case "0000":
			return "00:00";
		case "0030":
			return "00:30";
		case "0100":
			return "01:00";
		case "0130":
			return "01:30";
		case "0200":
			return "02:00";
		case "0230":
			return "02:30";
		case "0300":
			return "03:00";
		case "0330":
			return "03:30";
		case "0400":
			return "04:00";
		case "0430":
			return "04:30";
		case "0500":
			return "05:00";
		case "0530":
			return "05:30";
		case "0600":
			return "06:00";
		case "0630":
			return "06:30";
		case "0700":
			return "07:00";
		case "0730":
			return "07:30";
		case "0800":
			return "08:00";
		case "0830":
			return "08:30";
		case "0900":
			return "09:00";
		case "0930":
			return "09:30";
		case "1000":
			return "10:00";
		case "1030":
			return "10:30";
		case "1100":
			return "11:00";
		case "1130":
			return "11:30";
		case "1200":
			return "12:00";
		case "1230":
			return "12:30";
		case "1300":
			return "13:00";
		case "1330":
			return "13:30";
		case "1400":
			return "14:00";
		case "1430":
			return "14:30";
		case "1500":
			return "15:00";
		case "1530":
			return "15:30";
		case "1600":
			return "16:00";
		case "1630":
			return "16:30";
		case "1700":
			return "17:00";
		case "1730":
			return "17:30";
		case "1800":
			return "18:00";
		case "1830":
			return "18:30";
		case "1900":
			return "19:00";
		case "1930":
			return "19:30";
		case "2000":
			return "20:00";
		case "2030":
			return "20:30";
		case "2100":
			return "21:00";
		case "2130":
			return "21:30";
		case "2200":
			return "22:00";
		case "2230":
			return "22:30";
		case "2300":
			return "23:00";
		case "2330":
			return "23:30";
		}
		return KpTime_Convert;
	}
	public void setKpTime_Convert(String value){
		this.KpTime_Convert = value;
	}

	private String CreateUser3 = "";
	//快递用户
	public String getCreateUser3(){
		return this.CreateUser3;
	}
	public void setCreateUser3(String value){
		this.CreateUser3 = value;
	}

	private String SendTime = "";
	//快递时间
	public String getSendTime(){
		return this.SendTime;
	}
	public void setSendTime(String value){
		this.SendTime = value;
	}

	private String SendTime_Convert="";
	public String getSendTime_Convert(){
		switch(String.valueOf(SendTime)) {
		case "0000":
			return "00:00";
		case "0030":
			return "00:30";
		case "0100":
			return "01:00";
		case "0130":
			return "01:30";
		case "0200":
			return "02:00";
		case "0230":
			return "02:30";
		case "0300":
			return "03:00";
		case "0330":
			return "03:30";
		case "0400":
			return "04:00";
		case "0430":
			return "04:30";
		case "0500":
			return "05:00";
		case "0530":
			return "05:30";
		case "0600":
			return "06:00";
		case "0630":
			return "06:30";
		case "0700":
			return "07:00";
		case "0730":
			return "07:30";
		case "0800":
			return "08:00";
		case "0830":
			return "08:30";
		case "0900":
			return "09:00";
		case "0930":
			return "09:30";
		case "1000":
			return "10:00";
		case "1030":
			return "10:30";
		case "1100":
			return "11:00";
		case "1130":
			return "11:30";
		case "1200":
			return "12:00";
		case "1230":
			return "12:30";
		case "1300":
			return "13:00";
		case "1330":
			return "13:30";
		case "1400":
			return "14:00";
		case "1430":
			return "14:30";
		case "1500":
			return "15:00";
		case "1530":
			return "15:30";
		case "1600":
			return "16:00";
		case "1630":
			return "16:30";
		case "1700":
			return "17:00";
		case "1730":
			return "17:30";
		case "1800":
			return "18:00";
		case "1830":
			return "18:30";
		case "1900":
			return "19:00";
		case "1930":
			return "19:30";
		case "2000":
			return "20:00";
		case "2030":
			return "20:30";
		case "2100":
			return "21:00";
		case "2130":
			return "21:30";
		case "2200":
			return "22:00";
		case "2230":
			return "22:30";
		case "2300":
			return "23:00";
		case "2330":
			return "23:30";
		}
		return SendTime_Convert;
	}
	public void setSendTime_Convert(String value){
		this.SendTime_Convert = value;
	}

	private String InvoiceNo = "";
	//发票编号
	public String getInvoiceNo(){
		return this.InvoiceNo;
	}
	public void setInvoiceNo(String value){
		this.InvoiceNo = value;
	}

}
