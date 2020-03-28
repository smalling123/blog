package org.polariscode.SecuritySystem.mapper.Logistics;

import java.util.List;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import org.polariscode.SecuritySystem.model.Logistics.EquipmentOrder;
import org.polariscode.SecuritySystem.model.Logistics.EquipmentOrderItem;
import org.polariscode.SecuritySystem.model.Table;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

public interface EquipmentOrderMapper {
	@Select("<script>select * from EquipmentOrder \n"
		+"where 1=1 \n"
		+"\n"
		+"<choose>\n"
		+"<when test='startdate == \"\"'></when>\n"
		+"<otherwise>and date&gt;=#{startdate}</otherwise>\n"
		+"</choose>\n"
		+" \n"
		+"\n"
		+"<choose>\n"
		+"<when test='enddate == \"\"'></when>\n"
		+"<otherwise>and date&lt;=#{enddate}</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+"\n"
		+"<choose>\n"
		+"<when test='org == 0'></when>\n"
		+"<otherwise>and orgid=#{org}</otherwise>\n"
		+"</choose>\n"
		+" \n"
		+"\n"
		+"<choose>\n"
		+"<when test='site == 0'></when>\n"
		+"<otherwise>and siteid=#{site}</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+"limit #{startIndex}, #{rowCount}</script>")
	List<EquipmentOrder> getAllEquipmentOrder(@Param("startIndex") int startIndex, @Param("rowCount") int rowCount, @Param("startdate") String startdate, @Param("enddate") String enddate, @Param("org") int org, @Param("site") int site);

	@Select("select eo.*,e.Name from EquipmentOrderItem eo\n"
		+"join Equipment e on  eo.EquipmentId=e.id\n"
		+"where eo.EquipmentOrderId=#{id}")
	List<EquipmentOrderItem> getEquipmentOrderItemById(@Param("id") int id);

	@Select("<script>select Count(*) Count  from EquipmentOrder \n"
		+"where 1=1 \n"
		+"\n"
		+"<choose>\n"
		+"<when test='startdate == \"\"'></when>\n"
		+"<otherwise>and date&gt;=#{startdate}</otherwise>\n"
		+"</choose>\n"
		+" \n"
		+"\n"
		+"<choose>\n"
		+"<when test='enddate == \"\"'></when>\n"
		+"<otherwise>and date&lt;=#{enddate}</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+"\n"
		+"<choose>\n"
		+"<when test='org == 0'></when>\n"
		+"<otherwise>and orgid=#{org}</otherwise>\n"
		+"</choose>\n"
		+" \n"
		+"\n"
		+"<choose>\n"
		+"<when test='site == 0'></when>\n"
		+"<otherwise>and siteid=#{site}</otherwise>\n"
		+"</choose>\n"
		+"</script>")
	Table getEquipmentOrderByCount(@Param("startdate") String startdate, @Param("enddate") String enddate, @Param("org") int org, @Param("site") int site);

	@Select("Select * From EquipmentOrder Where ID = #{id}")
	EquipmentOrder getEquipmentOrderOne(@Param("id") int id);

	@Insert("Insert Into EquipmentOrder(Date, Bank, BankAccount, Supplier, Describes, UserId, OrgId, SiteId, CreateUser, CreateTime, WorkflowID, File1)\n"
		+" Values(#{equipmentorder.Date}, #{equipmentorder.Bank}, #{equipmentorder.BankAccount}, #{equipmentorder.Supplier}, #{equipmentorder.Describes}, #{equipmentorder.UserId}, #{equipmentorder.OrgId}, #{equipmentorder.SiteId}, #{equipmentorder.CreateUser}, Now(), #{equipmentorder.WorkflowID}, #{equipmentorder.File1})")
	void insertEquipmentOrder(@Param("equipmentorder") EquipmentOrder equipmentorder);

	@Update("Update EquipmentOrder Set\n"
		+"	Date = #{equipmentorder.Date},\n"
		+"	Bank = #{equipmentorder.Bank},\n"
		+"	BankAccount = #{equipmentorder.BankAccount},\n"
		+"	Supplier = #{equipmentorder.Supplier},\n"
		+"	Describes = #{equipmentorder.Describes},\n"
		+"	UserId = #{equipmentorder.UserId},\n"
		+"	OrgId = #{equipmentorder.OrgId},\n"
		+"	SiteId = #{equipmentorder.SiteId},\n"
		+"	Isdelete = #{equipmentorder.Isdelete},\n"
		+"	ModifyUser = #{equipmentorder.CreateUser},\n"
		+"	ModifyTime = Now(),\n"
		+"	WorkflowID = #{equipmentorder.WorkflowID},\n"
		+"	File1 = #{equipmentorder.File1}\n"
		+" Where ID = #{equipmentorder.ID}")
	void updateEquipmentOrder(@Param("equipmentorder") EquipmentOrder equipmentorder);

	@Select("select eo.*,e.Name from EquipmentOrderItem eo\n"
		+"join Equipment e on  eo.EquipmentId=e.id\n"
		+"where eo.Id=#{id}")
	EquipmentOrderItem getEquipmentOrderItemOne(@Param("id") int id);

	@Insert("Insert Into EquipmentOrderItem(EquipmentOrderId, EquipmentId, Qty, Price, Amt, Describes)\n"
		+" Values(#{equipmentorderitem.EquipmentOrderId}, #{equipmentorderitem.EquipmentId}, #{equipmentorderitem.Qty}, #{equipmentorderitem.Price}, #{equipmentorderitem.Amt}, #{equipmentorderitem.Describes})")
	void insertEquipmentOrderItem(@Param("equipmentorderitem") EquipmentOrderItem equipmentorderitem);

	@Update("Update EquipmentOrderItem Set\n"
		+"	EquipmentOrderId = #{equipmentorderitem.EquipmentOrderId},\n"
		+"	EquipmentId = #{equipmentorderitem.EquipmentId},\n"
		+"	Qty = #{equipmentorderitem.Qty},\n"
		+"	Price = #{equipmentorderitem.Price},\n"
		+"	Amt = #{equipmentorderitem.Amt},\n"
		+"	Describes = #{equipmentorderitem.Describes},\n"
		+" Where ID = #{equipmentorderitem.ID}")
	void updateEquipmentOrderItem(@Param("equipmentorderitem") EquipmentOrderItem equipmentorderitem);

}
