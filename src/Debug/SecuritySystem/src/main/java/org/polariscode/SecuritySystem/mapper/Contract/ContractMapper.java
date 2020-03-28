package org.polariscode.SecuritySystem.mapper.Contract;

import java.util.List;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import org.polariscode.SecuritySystem.model.Contract.Contract;
import org.polariscode.SecuritySystem.model.Table;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

public interface ContractMapper {
	@Select("<script>select  *  from contract \n"
		+" where  isdelete=0 and Status=#{status} and type=#{type} \n"
		+"<choose>\n"
		+"<when test='Expire == 1'>and EndDate&lt;now()</when>\n"
		+"<when test='Expire == \"\"'></when>\n"
		+"<when test='Expire == null'></when>\n"
		+"<otherwise>and EndDate&gt;=now()</otherwise>\n"
		+"</choose>\n"
		+" \n"
		+"limit #{startIndex}, #{rowCount}</script>")
	List<Contract> getContractAll(@Param("startIndex") int startIndex, @Param("rowCount") int rowCount, @Param("status") String status, @Param("type") int type, @Param("Expire") String Expire);

	@Select("select  count(*) count  from contract where isdelete=0")
	Table getContractByCount();

	@Select("select  c.* ,c1.Name Customer from contract c \n"
		+"left join Customer c1 on c.CustomerID=c1.ID where c.id=#{id} and c.isdelete=0")
	Contract getContractById(@Param("id") int id);

	@Select("select MAX(left(ContractCode, 8)) Count from contract WHERE ContractCode like CONCAT(YEAR(now()),'%');")
	Table getMaxContractCode();

	@Select("select  max(ID) ID  from contract")
	Table getinsertContractByID();

	@Insert("Insert Into Contract(ContractCode, CustomerId, CompanyId, OrgId, BeginDate, EndDate, InDate, PNumber, AvgAmount, TotalAmount, MonthlyAmount, Wages, AAgent, ASubscriber, ASigningTtime, BAgent, BSubscriber, BSigningTtime, SpecialNeed, LogisticsEat, LogisticsHome, LogisticsNeed, SuperviseNeed, TrainNeed, Status, Type, CreateUser, CreateTime,wagesType, InvoiceCompany, InvoiceTitle, InvoiceTax)\n"
		+" Values(#{contract.ContractCode}, #{contract.CustomerId}, #{contract.CompanyId}, #{contract.OrgId}, #{contract.BeginDate}, #{contract.EndDate}, #{contract.InDate}, #{contract.PNumber}, #{contract.AvgAmount}, #{contract.TotalAmount}, #{contract.MonthlyAmount}, #{contract.Wages}, #{contract.AAgent}, #{contract.ASubscriber}, #{contract.ASigningTtime}, #{contract.BAgent}, #{contract.BSubscriber}, #{contract.BSigningTtime}, #{contract.SpecialNeed}, #{contract.LogisticsEat}, #{contract.LogisticsHome}, #{contract.LogisticsNeed}, #{contract.SuperviseNeed}, #{contract.TrainNeed}, #{contract.Status}, #{contract.Type}, #{contract.CreateUser},now(),#{contract.wagesType}, #{contract.InvoiceCompany}, #{contract.InvoiceTitle}, #{contract.InvoiceTax})")
	void InsertContract(@Param("contract") Contract contract);

	@Update("Update Contract Set\n"
		+"	ContractCode = #{contract.ContractCode},\n"
		+"	CustomerId = #{contract.CustomerId},\n"
		+"	CompanyId = #{contract.CompanyId},\n"
		+"	OrgId = #{contract.OrgId},\n"
		+"	BeginDate = #{contract.BeginDate},\n"
		+"	EndDate = #{contract.EndDate},\n"
		+"	InDate = #{contract.InDate},\n"
		+"	PNumber = #{contract.PNumber},\n"
		+"	AvgAmount = #{contract.AvgAmount},\n"
		+"	TotalAmount = #{contract.TotalAmount},\n"
		+"	MonthlyAmount = #{contract.MonthlyAmount},\n"
		+"	Wages = #{contract.Wages},\n"
		+"	AAgent = #{contract.AAgent},\n"
		+"	ASubscriber = #{contract.ASubscriber},\n"
		+"	ASigningTtime = #{contract.ASigningTtime},\n"
		+"	BAgent = #{contract.BAgent},\n"
		+"	BSubscriber = #{contract.BSubscriber},\n"
		+"	BSigningTtime = #{contract.BSigningTtime},\n"
		+"	SpecialNeed = #{contract.SpecialNeed},\n"
		+"	LogisticsEat = #{contract.LogisticsEat},\n"
		+"	LogisticsHome = #{contract.LogisticsHome},\n"
		+"	LogisticsNeed = #{contract.LogisticsNeed},\n"
		+"	SuperviseNeed = #{contract.SuperviseNeed},\n"
		+"	TrainNeed = #{contract.TrainNeed},\n"
		+"	Status = #{contract.Status},\n"
		+"	Type = #{contract.Type},\n"
		+"	ModifyUser= #{contract.CreateUser},\n"
		+"	ModifyTime = now(),\n"
		+"	wagesType = #{contract.wagesType},\n"
		+"	InvoiceCompany = #{contract.InvoiceCompany},\n"
		+"	InvoiceTitle = #{contract.InvoiceTitle},\n"
		+"	InvoiceTax = #{contract.InvoiceTax}\n"
		+" Where ID = #{contract.ID}")
	void UpdateContract(@Param("contract") Contract contract);

}
