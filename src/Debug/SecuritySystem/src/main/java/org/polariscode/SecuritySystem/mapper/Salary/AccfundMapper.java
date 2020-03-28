package org.polariscode.SecuritySystem.mapper.Salary;

import java.util.List;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import org.polariscode.SecuritySystem.model.Salary.Accfund;
import org.polariscode.SecuritySystem.model.Table;
import org.polariscode.SecuritySystem.model.Salary.Accfunditem;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Insert;

public interface AccfundMapper {
	@Select("select  *  from accfund \n"
		+"where City like '%${City}%' and  Name like '%${Name}%'\n"
		+"limit #{startIndex}, #{rowCount}")
	List<Accfund> getAllAccfund(@Param("startIndex") int startIndex, @Param("rowCount") int rowCount, @Param("City") String City, @Param("Name") String Name);

	@Select("select Count(*) Count  from accfund \n"
		+"where City like '%${City}%' and Name like '%${Name}%'")
	Table getAccfundByCount(@Param("City") String City, @Param("Name") String Name);

	@Select("select * from accfunditem\n"
		+"where AccfundId=#{id} and 1=1")
	List<Accfunditem> getAccfunditemById(@Param("id") int id);

	@Select("Select * From Accfund Where ID = #{id}")
	Accfund getAccfundOne(@Param("id") int id);

	@Update("Update Accfund Set\n"
		+"	City = #{accfund.City},\n"
		+"	Name = #{accfund.Name}\n"
		+" Where ID = #{accfund.ID}")
	void updateAccfund(@Param("accfund") Accfund accfund);

	@Insert("Insert Into Accfund(City, Name)\n"
		+" Values(#{accfund.City}, #{accfund.Name})")
	void insertAccfund(@Param("accfund") Accfund accfund);

	@Select("Select * From Accfunditem Where ID = #{id}")
	Accfunditem getAccfunditemOne(@Param("id") int id);

	@Insert("Insert Into Accfunditem(AccfundId, Year, Month, BaseMin, BaseMax, CRate, CMinValue, CMaxValue, PRate, PMinValue, PMaxValue)\n"
		+" Values(#{accfunditem.AccfundId}, #{accfunditem.Year}, #{accfunditem.Month}, #{accfunditem.BaseMin}, #{accfunditem.BaseMax}, #{accfunditem.CRate}, #{accfunditem.CMinValue}, #{accfunditem.CMaxValue}, #{accfunditem.PRate}, #{accfunditem.PMinValue}, #{accfunditem.PMaxValue})")
	void insertAccfunditem(@Param("accfunditem") Accfunditem accfunditem);

	@Update("Update Accfunditem Set\n"
		+"	AccfundId = #{accfunditem.AccfundId},\n"
		+"	Year = #{accfunditem.Year},\n"
		+"	Month = #{accfunditem.Month},\n"
		+"	BaseMin = #{accfunditem.BaseMin},\n"
		+"	BaseMax = #{accfunditem.BaseMax},\n"
		+"	CRate = #{accfunditem.CRate},\n"
		+"	CMinValue = #{accfunditem.CMinValue},\n"
		+"	CMaxValue = #{accfunditem.CMaxValue},\n"
		+"	PRate = #{accfunditem.PRate},\n"
		+"	PMinValue = #{accfunditem.PMinValue},\n"
		+"	PMaxValue = #{accfunditem.PMaxValue}\n"
		+" Where ID = #{accfunditem.ID}")
	void updateAccfunditem(@Param("accfunditem") Accfunditem accfunditem);

}
