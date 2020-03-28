package org.polariscode.SecuritySystem.mapper.Finance;

import java.util.List;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import org.polariscode.SecuritySystem.model.Finance.Invoice;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.polariscode.SecuritySystem.model.Table;

public interface InvoiceMapper {
	@Select("<script>select * from invoice where 1=1 \n"
		+"<choose>\n"
		+"<when test='CustomerId == 0'></when>\n"
		+"<otherwise>and CustomerId=#{CustomerId}</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+"limit #{startIndex}, #{rowCount}</script>")
	List<Invoice> getinvoiceByCustomerId(@Param("CustomerId") int CustomerId, @Param("startIndex") int startIndex, @Param("rowCount") int rowCount);

	@Insert("Insert Into Invoice(CompanyId, AppDate, UserId, OrgId, SiteId, CustomerId, TaxNo, Customer, Address, BankInfo, Date, Status, SendDate, SendAddress, SendName, SendPhone, Describes, CreateUser, CreateTime, KpUser, KpTime, CreateUser3, SendTime, InvoiceNo)\n"
		+" Values(#{invoice.CompanyId}, #{invoice.AppDate}, #{invoice.UserId}, #{invoice.OrgId}, #{invoice.SiteId}, #{invoice.CustomerId}, #{invoice.TaxNo}, #{invoice.Customer}, #{invoice.Address}, #{invoice.BankInfo}, #{invoice.Date}, #{invoice.Status}, #{invoice.SendDate}, #{invoice.SendAddress}, #{invoice.SendName}, #{invoice.SendPhone}, #{invoice.Describes}, #{invoice.CreateUser}, Now(), #{invoice.KpUser}, #{invoice.KpTime}, #{invoice.CreateUser3}, #{invoice.SendTime}, #{invoice.InvoiceNo});")
	void insertInvoice(@Param("invoice") Invoice invoice);

	@Update("Update Invoice Set\n"
		+"	CompanyId = #{invoice.CompanyId},\n"
		+"	AppDate = #{invoice.AppDate},\n"
		+"	UserId = #{invoice.UserId},\n"
		+"	OrgId = #{invoice.OrgId},\n"
		+"	SiteId = #{invoice.SiteId},\n"
		+"	CustomerId = #{invoice.CustomerId},\n"
		+"	TaxNo = #{invoice.TaxNo},\n"
		+"	Customer = #{invoice.Customer},\n"
		+"	Address = #{invoice.Address},\n"
		+"	BankInfo = #{invoice.BankInfo},\n"
		+"	Date = #{invoice.Date},\n"
		+"	Status = #{invoice.Status},\n"
		+"	SendDate = #{invoice.SendDate},\n"
		+"	SendAddress = #{invoice.SendAddress},\n"
		+"	SendName = #{invoice.SendName},\n"
		+"	SendPhone = #{invoice.SendPhone},\n"
		+"	Describes = #{invoice.Describes},\n"
		+"	CreateUser = #{invoice.CreateUser},\n"
		+"	CreateTime = Now(),\n"
		+"	KpUser = #{invoice.KpUser},\n"
		+"	KpTime = #{invoice.KpTime},\n"
		+"	CreateUser3 = #{invoice.CreateUser3},\n"
		+"	SendTime = #{invoice.SendTime},\n"
		+"	InvoiceNo = #{invoice.InvoiceNo}\n"
		+" Where ID = #{invoice.ID}")
	void updateInvoice(@Param("invoice") Invoice invoice);

	@Select("Select * From Invoice Where ID = #{id}")
	Invoice getInvoiceById(@Param("id") int id);

	@Select("<script>select Count(*) Count from invoice where 1=1 \n"
		+"<choose>\n"
		+"<when test='CustomerId == 0'></when>\n"
		+"<otherwise>and  CustomerId=#{CustomerId}</otherwise>\n"
		+"</choose>\n"
		+"</script>")
	Table getinvoiceByCount(@Param("CustomerId") int CustomerId);

	@Update("<script>\n"
		+"Update BillFee Set\n"
		+"	InvoiceItemId = #{id}\n"
		+" Where ID in (\n"
		+"<foreach collection='ids' item='c' index='index' separator=','>\n"
		+"#{c}\n"
		+"</foreach>\n"
		+")\n"
		+"</script>")
	void updateBillFees(@Param("ids") List<String> ids, @Param("id") int id);

}
