package org.polariscode.SecuritySystem.mapper.Logistics;

import java.util.List;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import org.polariscode.SecuritySystem.model.Logistics.EquipmentOutStock;
import org.polariscode.SecuritySystem.model.Logistics.EquipmentOutStockItem;
import org.polariscode.SecuritySystem.model.Table;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

public interface EquipmentOutStockMapper {
	@Select("<script>select * from EquipmentOutStock\n"
		+"where 1=1 \n"
		+"\n"
		+"<choose>\n"
		+"<when test='startdate == 0'></when>\n"
		+"<otherwise>and date&gt;=#{startdate}</otherwise>\n"
		+"</choose>\n"
		+" \n"
		+"\n"
		+"<choose>\n"
		+"<when test='enddate == 0'></when>\n"
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
	List<EquipmentOutStock> getAllEquipmentOutStock(@Param("startIndex") int startIndex, @Param("rowCount") int rowCount, @Param("startdate") String startdate, @Param("enddate") String enddate, @Param("org") int org, @Param("site") int site);

	@Select("select eos.*,e.`Name` from EquipmentOutstockItem eos \n"
		+"join equipment e on eos.EquipmentId=e.id\n"
		+"where eos.EquipmentOutStockId=#{id}")
	List<EquipmentOutStockItem> getEquipmentOutStockItmeById(@Param("id") int id);

	@Select("<script>select Count(*) Count from EquipmentOutStock\n"
		+"where 1=1 \n"
		+"\n"
		+"<choose>\n"
		+"<when test='startdate == 0'></when>\n"
		+"<otherwise>and date&gt;=#{startdate}</otherwise>\n"
		+"</choose>\n"
		+" \n"
		+"\n"
		+"<choose>\n"
		+"<when test='enddate == 0'></when>\n"
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
	Table getEquipmentOutStockByCount(@Param("startdate") String startdate, @Param("enddate") String enddate, @Param("org") int org, @Param("site") int site);

	@Select("Select * From EquipmentOutStock Where ID = #{id}")
	EquipmentOutStock getEquipmentOutStockOne(@Param("id") int id);

	@Insert("Insert Into EquipmentOutStock(Date, OrgId, SiteId, UserId, Describes, CreateUser, CreateTime, WorkflowID)\n"
		+" Values(#{equipmentoutstock.Date}, #{equipmentoutstock.OrgId}, #{equipmentoutstock.SiteId}, #{equipmentoutstock.UserId}, #{equipmentoutstock.Describes}, #{equipmentoutstock.CreateUser},Now(), #{equipmentoutstock.WorkflowID})")
	void insertEquipmentOutStock(@Param("equipmentoutstock") EquipmentOutStock equipmentoutstock);

	@Update("Update EquipmentOutStock Set\n"
		+"	Date = #{equipmentoutstock.Date},\n"
		+"	OrgId = #{equipmentoutstock.OrgId},\n"
		+"	SiteId = #{equipmentoutstock.SiteId},\n"
		+"	UserId = #{equipmentoutstock.UserId},\n"
		+"	Describes = #{equipmentoutstock.Describes},\n"
		+"	ModifyUser = #{equipmentoutstock.CreateUser},\n"
		+"	ModifyTime = Now(),\n"
		+"	WorkflowID = #{equipmentoutstock.WorkflowID}\n"
		+" Where ID = #{equipmentoutstock.ID}")
	void updateEquipmentOutStock(@Param("equipmentoutstock") EquipmentOutStock equipmentoutstock);

	@Select("select eos.*,e.`Name` from EquipmentOutstockItem eos \n"
		+"join equipment e on eos.EquipmentId=e.id\n"
		+"where eos.Id=#{id}")
	EquipmentOutStockItem getEquipmentOutStockItemOne(@Param("id") int id);

	@Insert("Insert Into EquipmentOutStockItem(EquipmentOutStockId, EquipmentId, Qty, Describes)\n"
		+" Values(#{equipmentoutstockitem.EquipmentOutStockId}, #{equipmentoutstockitem.EquipmentId}, #{equipmentoutstockitem.Qty}, #{equipmentoutstockitem.Describes})")
	void insertEquipmentOutStockItem(@Param("equipmentoutstockitem") EquipmentOutStockItem equipmentoutstockitem);

	@Update("Update EquipmentOutStockItem Set\n"
		+"	EquipmentOutStockId = #{equipmentoutstockitem.EquipmentOutStockId},\n"
		+"	EquipmentId = #{equipmentoutstockitem.EquipmentId},\n"
		+"	Qty = #{equipmentoutstockitem.Qty},\n"
		+"	Describes = #{equipmentoutstockitem.Describes}\n"
		+" Where ID = #{equipmentoutstockitem.ID}")
	void updateEquipmentOutStockItem(@Param("equipmentoutstockitem") EquipmentOutStockItem equipmentoutstockitem);

}
