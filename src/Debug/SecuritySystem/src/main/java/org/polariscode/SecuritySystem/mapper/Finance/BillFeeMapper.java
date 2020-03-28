package org.polariscode.SecuritySystem.mapper.Finance;

import java.util.List;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import org.polariscode.SecuritySystem.model.Finance.BillFee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.polariscode.SecuritySystem.model.Table;

public interface BillFeeMapper {
	@Select("select * from BillFee where BillId =#{bid}\n"
		+"limit #{startIndex}, #{rowCount}")
	List<BillFee> getBillFeeBybid(@Param("bid") int bid, @Param("startIndex") int startIndex, @Param("rowCount") int rowCount);

	@Insert("Insert Into BillFee(BillId, ContractInvoiceId, Name, Amt, Describes, CreateUser, CreateTime, InvoiceItemId)\n"
		+" Values(#{billfee.BillId}, #{billfee.ContractInvoiceId}, #{billfee.Name}, #{billfee.Amt}, #{billfee.Describes}, #{billfee.CreateUser},Now(), #{billfee.InvoiceItemId})")
	void insertBillFee(@Param("billfee") BillFee billfee);

	@Update("Update BillFee Set\n"
		+"	BillId = #{billfee.BillId},\n"
		+"	ContractInvoiceId = #{billfee.ContractInvoiceId},\n"
		+"	Name = #{billfee.Name},\n"
		+"	Amt = #{billfee.Amt},\n"
		+"	Describes = #{billfee.Describes},\n"
		+"	CreateUser = #{billfee.CreateUser},\n"
		+"	CreateTime = Now(),\n"
		+"	InvoiceItemId = #{billfee.InvoiceItemId}\n"
		+" Where ID = #{billfee.ID}")
	void updateBillFee(@Param("billfee") BillFee billfee);

	@Select("select Count(*) Count from BillFee where BillId =#{bid}")
	Table getBillFeeByCount(@Param("bid") int bid);

	@Select("Select * From BillFee Where ID = #{id}")
	BillFee getBillFeeById(@Param("id") int id);

	@Select("<script>select * from BillFee where BillId =#{bid} \n"
		+"<choose>\n"
		+"<when test='InvoiceItemId == 0'></when>\n"
		+"<otherwise>and  InvoiceItemId !=0</otherwise>\n"
		+"</choose>\n"
		+"</script>")
	List<BillFee> getBillFeeBybids(@Param("bid") int bid, @Param("InvoiceItemId") int InvoiceItemId);

	@Insert("delete from BillFee  where  BillId = #{id};\n"
		+"Insert Into BillFee(BillId, ContractInvoiceId, Name, Amt, Describes, CreateUser, CreateTime, InvoiceItemId)\n"
		+"select  #{id} as BillId, ci.ID as ContractInvoiceId, ci.Content as Name, ci.Amount  as Amt,ci.Describes, #{CreateUser} as CreateUser,now() as CreateTime,0 as InvoiceItemId\n"
		+" from contract c\n"
		+" JOIN contractinvoice ci on c.id =ci.ContractId\n"
		+"where c.CustomerId=(select  CustomerId from Bill where id= #{id})\n"
		+"and c.ContractId=(select  ContractIdfrom Bill where id= #{id})\n"
		+"and c.BeginDate<=date_add(DATE(CONCAT(YEAR(now()),'-',MONTH(now()),'-',DAY(c.BeginDate))), interval (#{month}-1) MONTH) \n"
		+"and c.EndDate>=DATE(CONCAT(YEAR(now()),'-',MONTH(now()),'-',DAY(c.BeginDate)))\n"
		+"and ci.BeginDate>=DATE(CONCAT((select  Year from Bill where id= #{id}),'-',(select  Month-1 from Bill where id= #{id}),'-',DAY(c.BeginDate)))\n"
		+"and ci.BeginDate<=DATE((select  Year from Bill where id= #{id}),'-',(select  Month from Bill where id= #{id}),'-',DAY(c.BeginDate)));")
	void ReplaceBillFee(@Param("id") int id, @Param("CreateUser") String CreateUser);

	@Select("<script>select bf.* from BillFee bf\n"
		+"join Bill  b on b.id =bf.Billid\n"
		+"where b.CustomerId =#{CustomerId}\n"
		+"\n"
		+"<choose>\n"
		+"<when test='Year == 0'></when>\n"
		+"<otherwise>and b.Year=#{Year}</otherwise>\n"
		+"</choose>\n"
		+" \n"
		+"<choose>\n"
		+"<when test='Month == 0'></when>\n"
		+"<otherwise>and b.Month=#{Month}</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+"limit #{startIndex}, #{rowCount}</script>")
	List<BillFee> getBillFeeByCustomerId(@Param("CustomerId") int CustomerId, @Param("Year") int Year, @Param("Month") int Month, @Param("startIndex") int startIndex, @Param("rowCount") int rowCount);

	@Select("<script>select Count(*) Count from BillFee bf\n"
		+"join Bill  b on b.id =bf.Billid\n"
		+"where b.CustomerId =#{CustomerId}\n"
		+"\n"
		+"<choose>\n"
		+"<when test='Year == 0'></when>\n"
		+"<otherwise>and b.Year=#{Year}</otherwise>\n"
		+"</choose>\n"
		+" \n"
		+"<choose>\n"
		+"<when test='Month == 0'></when>\n"
		+"<otherwise>and b.Month=#{Month}</otherwise>\n"
		+"</choose>\n"
		+"</script>")
	Table getBillFeeCount(@Param("CustomerId") int CustomerId, @Param("Year") int Year, @Param("Month") int Month);

}
