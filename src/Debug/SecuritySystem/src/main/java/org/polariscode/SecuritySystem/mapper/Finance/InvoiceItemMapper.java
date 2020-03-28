package org.polariscode.SecuritySystem.mapper.Finance;

import java.util.List;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import org.polariscode.SecuritySystem.model.Finance.InvoiceItem;
import org.apache.ibatis.annotations.Insert;
import org.polariscode.SecuritySystem.model.Table;

public interface InvoiceItemMapper {
	@Select("select * from InvoiceItem where InvoiceId=#{InvoiceId}\n"
		+"limit #{startIndex}, #{rowCount}")
	List<InvoiceItem> getInvoiceItemByInvoiceId(@Param("InvoiceId") int InvoiceId, @Param("startIndex") int startIndex, @Param("rowCount") int rowCount);

	@Insert("<script>\n"
		+"Insert Into InvoiceItem(InvoiceId, Name, Amt, Describes, BillItemId, QTY)\n"
		+"select (select max(id) from Invoice ) as InvoiceId ,Name ,Amt,Describes ,ID as BillItemId, #{ids.size()} as QTY from BillFee \n"
		+" Where Id in (\n"
		+"<foreach collection='ids' item='c' index='index' separator=','>\n"
		+"#{c}\n"
		+"</foreach>\n"
		+")\n"
		+"</script>")
	void insertInvoiceItem(@Param("ids") List<String> ids);

	@Select("select count(*) Count from InvoiceItem where InvoiceId=#{InvoiceId}")
	Table getInvoiceItemByCount(@Param("InvoiceId") int InvoiceId);

}
