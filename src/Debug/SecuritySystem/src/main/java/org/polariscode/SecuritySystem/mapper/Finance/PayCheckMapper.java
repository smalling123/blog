package org.polariscode.SecuritySystem.mapper.Finance;

import java.util.List;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import org.polariscode.SecuritySystem.model.Finance.PayCheck;
import org.apache.ibatis.annotations.Insert;
import org.polariscode.SecuritySystem.model.Table;

public interface PayCheckMapper {
	@Select("<script>select * from PayCheck where 1=1 \n"
		+"<choose>\n"
		+"<when test='PayId == 0'></when>\n"
		+"<otherwise>and  PayId=#{PayId}</otherwise>\n"
		+"</choose>\n"
		+" \n"
		+"<choose>\n"
		+"<when test='InvoiceItemId == 0'></when>\n"
		+"<otherwise>and InvoiceItemId=#{InvoiceItemId}</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+"limit #{startIndex}, #{rowCount}</script>")
	List<PayCheck> getPayCheckByPayId(@Param("PayId") int PayId, @Param("InvoiceItemId") int InvoiceItemId, @Param("startIndex") int startIndex, @Param("rowCount") int rowCount);

	@Insert("<script>\n"
		+"Insert Into PayCheck(PayId, InvoiceItemId, Amt, Describes, CreateUser, CreateTime)\n"
		+"select  (select max(ID) from Pay) PayId,ID InvoiceItemId,Amt,Describes,#{CreateUser},now() from InvoiceItem \n"
		+"where Invoice in(\n"
		+"<foreach collection='ids' item='c' index='index' separator=','>\n"
		+"#{c}\n"
		+"</foreach>\n"
		+")\n"
		+"</script>")
	void InsertsPayCheck(@Param("ids") List<String> ids, @Param("CreateUser") String CreateUser);

	@Select("<script>select Count(*) Count from PayCheck where 1=1 \n"
		+"<choose>\n"
		+"<when test='PayId == 0'></when>\n"
		+"<otherwise>and  PayId=#{PayId}</otherwise>\n"
		+"</choose>\n"
		+" \n"
		+"<choose>\n"
		+"<when test='InvoiceItemId == 0'></when>\n"
		+"<otherwise>and InvoiceItemId=#{InvoiceItemId}</otherwise>\n"
		+"</choose>\n"
		+"</script>")
	Table getPayCheckByCount(@Param("PayId") int PayId, @Param("InvoiceItemId") int InvoiceItemId);

}
