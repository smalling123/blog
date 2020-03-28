package org.polariscode.SecuritySystem.mapper.Logistics;

import java.util.List;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import org.polariscode.SecuritySystem.model.Logistics.Equipment;
import org.polariscode.SecuritySystem.model.Logistics.EquipmentInStock;
import org.polariscode.SecuritySystem.model.Logistics.EquipmentInStockItem;
import org.polariscode.SecuritySystem.model.Table;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

public interface EquipmentInStockMapper {
	@Select("select * from Equipment \n"
		+"limit #{startIndex}, #{rowCount}")
	List<Equipment> getAllEquipment(@Param("startIndex") int startIndex, @Param("rowCount") int rowCount);

	@Select("<script>select * from EquipmentInStock\n"
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
	List<EquipmentInStock> gatAllEquipmentInStock(@Param("startIndex") int startIndex, @Param("rowCount") int rowCount, @Param("startdate") String startdate, @Param("enddate") String enddate, @Param("org") int org, @Param("site") int site);

	@Select("select es.*,e.Name  from EquipmentInStockItem es\n"
		+"join Equipment e on es.Equipmentid=e.id\n"
		+"where es.EquipmentInStockId=#{id}")
	List<EquipmentInStockItem> getEquipmentInStockItemById(@Param("id") int id);

	@Select("<script>select  count(*) Count from EquipmentInStock\n"
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
	Table gatEquipmentInStockByCount(@Param("startdate") String startdate, @Param("enddate") String enddate, @Param("org") int org, @Param("site") int site);

	@Select("Select * From EquipmentInStock Where ID = #{id}")
	EquipmentInStock getEquipmentInStockOne(@Param("id") int id);

	@Insert("Insert Into EquipmentInStock(Date, OrgId, SiteId, Supplier, Bank, BankAccount, Describes, CreateUser, CreateTime, WorkflowID, File1)\n"
		+" Values(#{equipmentinstock.Date}, #{equipmentinstock.OrgId}, #{equipmentinstock.SiteId}, #{equipmentinstock.Supplier}, #{equipmentinstock.Bank}, #{equipmentinstock.BankAccount}, #{equipmentinstock.Describes}, #{equipmentinstock.CreateUser},Now(), #{equipmentinstock.WorkflowID}, #{equipmentinstock.File1})")
	void insertEquipmentInStock(@Param("equipmentinstock") EquipmentInStock equipmentinstock);

	@Update("Update EquipmentInStock Set\n"
		+"	Date = #{equipmentinstock.Date},\n"
		+"	OrgId = #{equipmentinstock.OrgId},\n"
		+"	SiteId = #{equipmentinstock.SiteId},\n"
		+"	Supplier = #{equipmentinstock.Supplier},\n"
		+"	Bank = #{equipmentinstock.Bank},\n"
		+"	BankAccount = #{equipmentinstock.BankAccount},\n"
		+"	Describes = #{equipmentinstock.Describes},\n"
		+"	ModifyUser = #{equipmentinstock.CreateUser},\n"
		+"	ModifyTime = Now(),\n"
		+"	WorkflowID = #{equipmentinstock.WorkflowID},\n"
		+"	File1 = #{equipmentinstock.File1}\n"
		+" Where ID = #{equipmentinstock.ID}")
	void updateEquipmentInStock(@Param("equipmentinstock") EquipmentInStock equipmentinstock);

	@Insert("Insert Into EquipmentInStockItem(EquipmentInStockId, EquipmentId, Qty, Price, Amt, Describes)\n"
		+" Values(#{equipmentinstockitem.EquipmentInStockId}, #{equipmentinstockitem.EquipmentId}, #{equipmentinstockitem.Qty}, #{equipmentinstockitem.Price}, #{equipmentinstockitem.Amt}, #{equipmentinstockitem.Describes})")
	void insertEquipmentInStockItem(@Param("equipmentinstockitem") EquipmentInStockItem equipmentinstockitem);

	@Update("Update EquipmentInStockItem Set\n"
		+"	EquipmentInStockId = #{equipmentinstockitem.EquipmentInStockId},\n"
		+"	EquipmentId = #{equipmentinstockitem.EquipmentId},\n"
		+"	Qty = #{equipmentinstockitem.Qty},\n"
		+"	Price = #{equipmentinstockitem.Price},\n"
		+"	Amt = #{equipmentinstockitem.Amt},\n"
		+"	Describes = #{equipmentinstockitem.Describes}\n"
		+" Where ID = #{equipmentinstockitem.ID}")
	void updateEquipmentInStockItem(@Param("equipmentinstockitem") EquipmentInStockItem equipmentinstockitem);

	@Select("select es.*,e.Name  from EquipmentInStockItem es\n"
		+"join Equipment e on es.Equipmentid=e.id\n"
		+"where es.Id=#{id}")
	EquipmentInStockItem getEquipmentInStockItemOne(@Param("id") int id);

}
