package org.polariscode.SecuritySystem.mapper.Logistics;

import java.util.List;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import org.polariscode.SecuritySystem.model.Logistics.Equipment;
import org.polariscode.SecuritySystem.model.Table;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

public interface EquipmentMapper {
	@Select("Select * From Equipment\n"
		+"where Name like '%${Name}%'\n"
		+"limit #{startIndex}, #{rowCount}")
	List<Equipment> getAllEquipment(@Param("Name") String Name, @Param("startIndex") int startIndex, @Param("rowCount") int rowCount);

	@Select("Select Count(*) Count From Equipment\n"
		+"where Name like '%${Name}%'")
	Table getEquipmentByCount(@Param("Name") String Name);

	@Select("Select * From Equipment Where ID = #{id}")
	Equipment getEquipmentById(@Param("id") int id);

	@Insert("Insert Into Equipment(Name, Unit, Describes, Price, CreateUser, CreateTime)\n"
		+" Values(#{equipment.Name}, #{equipment.Unit}, #{equipment.Describes}, #{equipment.Price},  #{equipment.CreateUser}, Now())")
	void insertEquipment(@Param("equipment") Equipment equipment);

	@Update("Update Equipment Set\n"
		+"	Name = #{equipment.Name},\n"
		+"	Unit = #{equipment.Unit},\n"
		+"	Describes = #{equipment.Describes},\n"
		+"	Price = #{equipment.Price},\n"
		+"	ModifyUser = #{equipment.CreateUser},\n"
		+"	ModifyTime = Now(),\n"
		+" Where ID = #{equipment.ID}")
	void updateEquipment(@Param("equipment") Equipment equipment);

}
