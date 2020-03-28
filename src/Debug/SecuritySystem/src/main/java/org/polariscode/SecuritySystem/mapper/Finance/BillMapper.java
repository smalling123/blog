package org.polariscode.SecuritySystem.mapper.Finance;

import java.util.List;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import org.polariscode.SecuritySystem.model.Finance.Bill;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.polariscode.SecuritySystem.model.Finance.TBill;
import org.polariscode.SecuritySystem.model.Table;

public interface BillMapper {
	@Select("<script>select b.* from bill b\n"
		+"join customer c on c.id= b.customerId\n"
		+"  where 1=1 \n"
		+"<choose>\n"
		+"<when test='customer == \"\"'></when>\n"
		+"<otherwise>and  c.Name like&apos;%${customer}%&apos;</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+"\n"
		+"<choose>\n"
		+"<when test='Year == 0'></when>\n"
		+"<otherwise>and Year =#{Year}</otherwise>\n"
		+"</choose>\n"
		+" \n"
		+"<choose>\n"
		+"<when test='Month == 0'></when>\n"
		+"<otherwise>and Month=#{Month}</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+"limit #{startIndex}, #{rowCount}</script>")
	List<Bill> getBillByContractId(@Param("customer") String customer, @Param("startIndex") int startIndex, @Param("rowCount") int rowCount, @Param("Year") int Year, @Param("Month") int Month);

	@Insert("Insert Into Bill(SiteId, Year, Month, Amt, Describes, CreateUser, CreateTime)\n"
		+" Values(#{bill.SiteId}, #{bill.Year}, #{bill.Month}, #{bill.Amt}, #{bill.Describes}, #{bill.CreateUser}, Now())")
	void insertBill(@Param("bill") Bill bill);

	@Update("Update Bill Set\n"
		+"	SiteId = #{bill.SiteId},\n"
		+"	Year = #{bill.Year},\n"
		+"	Month = #{bill.Month},\n"
		+"	Amt = #{bill.Amt},\n"
		+"	Describes = #{bill.Describes},\n"
		+"	CreateUser = #{bill.CreateUser},\n"
		+"	CreateTime = now()\n"
		+" Where ID = #{bill.ID}")
	void updateBill(@Param("bill") Bill bill);

	@Select("select c.ID,  ci.Amount ,\n"
		+"YEAR(date_add(DATE(CONCAT(YEAR(now()),'-',MONTH(now()),'-',DAY(c.BeginDate))), interval #{month} MONTH)) `YEAR`, \n"
		+"MONTH(date_add(DATE(CONCAT(YEAR(now()),'-',MONTH(now()),'-',DAY(c.BeginDate))), interval #{month} MONTH)) `MONTH`,\n"
		+"c.BeginDate<=date_add(DATE(CONCAT(YEAR(now()),'-',MONTH(now()),'-',DAY(c.BeginDate))), interval (#{month}-2) MONTH) YN,\n"
		+" ci.BeginDate<=date_add(DATE(CONCAT(YEAR(now()),'-',MONTH(now()),'-',DAY(c.BeginDate))), interval #{month} MONTH) YNS\n"
		+" from contract c\n"
		+"JOIN contractinvoice ci on c.id =ci.ContractId\n"
		+"where c.CustomerId=#{id}\n"
		+"and c.BeginDate<=date_add(DATE(CONCAT(YEAR(now()),'-',MONTH(now()),'-',DAY(c.BeginDate))), interval (#{month}-1) MONTH) \n"
		+"and c.EndDate>=DATE(CONCAT(YEAR(now()),'-',MONTH(now()),'-',DAY(c.BeginDate)))\n"
		+"and ci.BeginDate>=date_add(DATE(CONCAT(YEAR(now()),'-',MONTH(now()),'-',DAY(c.BeginDate))), interval  (#{month}-1) MONTH) \n"
		+"GROUP BY c.ID, ci.Amount")
	List<TBill> getTBillById(@Param("id") int id, @Param("month") int month);

	@Insert("Insert Into Bill(SiteId, Year, Month, Amt, Describes, CreateUser, CreateTime,CustomerId,ContractId)\n"
		+" Values(#{bill.SiteId}, #{bill.Year}, #{bill.Month}, #{bill.Amt}, #{bill.Describes}, #{bill.CreateUser}, Now(), #{bill.ID},0);\n"
		+"Insert Into BillFee(BillId, ContractInvoiceId, Name, Amt, Describes, CreateUser, CreateTime, InvoiceItemId)\n"
		+"select  @@IDENTITY as BillId, ci.ID as ContractInvoiceId, ci.Content as Name, ci.Amount  as Amt,ci.Describes, #{bill.CreateUser} as CreateUser,now() as CreateTime,0 as InvoiceItemId\n"
		+" from contract c\n"
		+"JOIN contractinvoice ci on c.id =ci.ContractId\n"
		+"where c.CustomerId=#{id} and c.id=#{cid}\n"
		+"and c.BeginDate<=date_add(DATE(CONCAT(YEAR(now()),'-',MONTH(now()),'-',DAY(c.BeginDate))), interval (#{month}-1) MONTH) \n"
		+"and c.EndDate>=DATE(CONCAT(YEAR(now()),'-',MONTH(now()),'-',DAY(c.BeginDate)))\n"
		+"and ci.BeginDate>=date_add(DATE(CONCAT(YEAR(now()),'-',MONTH(now()),'-',DAY(c.BeginDate))), interval  (#{month}-1) MONTH) \n"
		+"and ci.BeginDate<=date_add(DATE(CONCAT(YEAR(now()),'-',MONTH(now()),'-',DAY(c.BeginDate))), interval #{month} MONTH);")
	void InsertBills(@Param("bill") Bill bill, @Param("id") int id, @Param("month") int month, @Param("cid") int cid);

	@Select("select Count(*) Count from Bill \n"
		+"where Year=YEAR(date_add(now(), interval #{month} MONTH)) \n"
		+"and Month=MONTH(date_add(now(), interval #{month} MONTH))\n"
		+"and ContractId = #{cid} and CustomerId=#{id}")
	Table getBillCount(@Param("month") int month, @Param("id") int id, @Param("cid") int cid);

	@Select("Select * From Bill Where ID = #{id}")
	Bill getBillById(@Param("id") int id);

	@Select("<script>select count(*) Count from bill b\n"
		+"join customer c on c.id= b.customerId\n"
		+"  where 1=1 \n"
		+"<choose>\n"
		+"<when test='customer == \"\"'></when>\n"
		+"<otherwise>and  c.Name like&apos;%${customer}%&apos;</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+"and Year =#{Year} \n"
		+"<choose>\n"
		+"<when test='Month == 0'></when>\n"
		+"<otherwise>and Month=#{Month}</otherwise>\n"
		+"</choose>\n"
		+"</script>")
	Table getBillByCount(@Param("customer") String customer, @Param("Year") int Year, @Param("Month") int Month);

}
