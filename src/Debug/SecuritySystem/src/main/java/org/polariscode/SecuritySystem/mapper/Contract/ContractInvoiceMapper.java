package org.polariscode.SecuritySystem.mapper.Contract;

import java.util.List;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import org.polariscode.SecuritySystem.model.Contract.ContractInvoice;
import org.polariscode.SecuritySystem.model.Table;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

public interface ContractInvoiceMapper {
	@Select("select * from ContractInvoice where ContractID=#{ContractID}  and isdelete=0\n"
		+"limit #{startIndex}, #{rowCount}")
	List<ContractInvoice> getContractInvoiceByContractID(@Param("ContractID") int ContractID, @Param("startIndex") int startIndex, @Param("rowCount") int rowCount);

	@Select("select count(*) Count  from ContractInvoice  where ContractID=#{ContractID}  and isdelete=0")
	Table getContractInvoiceByCount(@Param("ContractID") int ContractID);

	@Select("select * from ContractInvoice  where ID=#{id}  and isdelete=0")
	ContractInvoice getContractInvoiceById(@Param("id") int id);

	@Insert("Insert Into ContractInvoice(ContractId, BeginDate, EndDate, Content, PNumber, Price, Amount, TotalAmount, Type, Day, CreateUser, CreateTime,Invoicecycle,Describes,Month)\n"
		+" Values(#{contractinvoice.ContractId}, #{contractinvoice.BeginDate}, #{contractinvoice.EndDate}, #{contractinvoice.Content}, #{contractinvoice.PNumber}, #{contractinvoice.Price}, #{contractinvoice.Amount}, #{contractinvoice.TotalAmount}, #{contractinvoice.Type}, #{contractinvoice.Day},  #{contractinvoice.CreateUser}, Now(),#{contractinvoice.Invoicecycle},#{contractinvoice.Describes},#{contractinvoice.Month})")
	void insertContractInvoice(@Param("contractinvoice") ContractInvoice contractinvoice);

	@Update("Update ContractInvoice Set\n"
		+"	ContractId = #{contractinvoice.ContractId},\n"
		+"	BeginDate = #{contractinvoice.BeginDate},\n"
		+"	EndDate = #{contractinvoice.EndDate},\n"
		+"	Content = #{contractinvoice.Content},\n"
		+"	PNumber = #{contractinvoice.PNumber},\n"
		+"	Price = #{contractinvoice.Price},\n"
		+"	Amount = #{contractinvoice.Amount},\n"
		+"	TotalAmount = #{contractinvoice.TotalAmount},\n"
		+"	Type = #{contractinvoice.Type},\n"
		+"	Day = #{contractinvoice.Day},\n"
		+"	`Month`=#{contractinvoice.Month},\n"
		+"	ModifyUser = #{contractinvoice.CreateUser},\n"
		+"	Invoicecycle= #{contractinvoice.Invoicecycle},\n"
		+"	Describes= #{contractinvoice.Describes},\n"
		+"	ModifyTime = Now()\n"
		+" Where ID = #{contractinvoice.ID}")
	void updateContractInvoice(@Param("contractinvoice") ContractInvoice contractinvoice);

}
