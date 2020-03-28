package org.polariscode.SecuritySystem.mapper.Salary;

import java.util.List;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import org.polariscode.SecuritySystem.model.Salary.Taxs;
import org.polariscode.SecuritySystem.model.Table;
import org.polariscode.SecuritySystem.model.Salary.Tax;
import org.polariscode.SecuritySystem.model.Salary.Taxm;
import org.polariscode.SecuritySystem.model.Salary.Taxy;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Insert;

public interface TaxMapper {
	@Select("SELECT t.`Year`,t.`Month`,t.Base,tm.ID Mid ,tm.MinValue  MinVM,tm.`MaxValue` MaxVM,tm.Rate,\n"
		+"ty.ID Yid ,ty.MinValue MinVY,ty.`MaxValue` MaxVY,ty.`Value` from tax t\n"
		+"LEFT join taxm tm on t.id =tm.TaxId\n"
		+"LEFT join taxy ty on t.id =ty.TaxId\n"
		+"where t.`Year` =#{Year} and t.`Month` =#{Month} \n"
		+"limit #{startIndex}, #{rowCount}")
	List<Taxs> getAllTaxs(@Param("startIndex") int startIndex, @Param("rowCount") int rowCount, @Param("Year") String Year, @Param("Month") String Month);

	@Select("<script>select Count(*) Count from Tax \n"
		+"where 1=1 and  `Year` =#{Year} and `Month` =#{Month}</script>")
	Table getTaxByCount(@Param("Year") String Year, @Param("Month") String Month);

	@Select("<script>select * from Tax \n"
		+"where 1=1 \n"
		+"<choose>\n"
		+"<when test='Year == \"\"'></when>\n"
		+"<otherwise>and  `Year` =#{Year}</otherwise>\n"
		+"</choose>\n"
		+" \n"
		+"<choose>\n"
		+"<when test='Month == \"\"'></when>\n"
		+"<otherwise>and `Month` =#{Month}</otherwise>\n"
		+"</choose>\n"
		+" \n"
		+"limit #{startIndex}, #{rowCount}</script>")
	List<Tax> getAllTax(@Param("startIndex") int startIndex, @Param("rowCount") int rowCount, @Param("Year") String Year, @Param("Month") String Month);

	@Select("select * from taxm\n"
		+"where TaxId =#{id}")
	List<Taxm> getTaxm(@Param("id") int id);

	@Select("select * from taxy\n"
		+"where TaxId =#{id}")
	List<Taxy> getTaxy(@Param("id") int id);

	@Select("Select * From Tax Where ID = #{id}")
	Tax getTaxOne(@Param("id") int id);

	@Update("Update Tax Set\n"
		+"	`Year` = #{tax.Year},\n"
		+"	`Month` = #{tax.Month},\n"
		+"	`Base` = #{tax.Base}\n"
		+" Where ID = #{tax.ID}")
	void updateTax(@Param("tax") Tax tax);

	@Insert("Insert Into Tax(`Year`, `Month`, `Base`)\n"
		+" Values(#{tax.Year}, #{tax.Month}, #{tax.Base})")
	void insertTax(@Param("tax") Tax tax);

	@Insert("Insert Into Taxm(TaxId, MinValue, `MaxValue`, Rate)\n"
		+" Values(#{taxm.TaxId}, #{taxm.MinValue}, #{taxm.MaxValue}, #{taxm.Rate})")
	void insertTaxm(@Param("taxm") Taxm taxm);

	@Update("Update Taxm Set\n"
		+"	TaxId = #{taxm.TaxId},\n"
		+"	MinValue = #{taxm.MinValue},\n"
		+"	`MaxValue` = #{taxm.MaxValue},\n"
		+"	Rate = #{taxm.Rate}\n"
		+" Where ID = #{taxm.ID}")
	void updateTaxm(@Param("taxm") Taxm taxm);

	@Select("Select * From Taxm Where ID = #{id}")
	Taxm getTaxmOne(@Param("id") int id);

	@Select("Select * From Taxy Where ID = #{id}")
	Taxy getTaxyOne(@Param("id") int id);

	@Insert("Insert Into Taxy(`TaxId`, `MinValue`, `MaxValue`,` Value`)\n"
		+" Values(#{taxy.TaxId}, #{taxy.MinValue}, #{taxy.MaxValue}, #{taxy.Value})")
	void insertTaxy(@Param("taxy") Taxy taxy);

	@Update("Update Taxy Set\n"
		+"	`TaxId` = #{taxy.TaxId},\n"
		+"	`MinValue` = #{taxy.MinValue},\n"
		+"	`MaxValue` = #{taxy.MaxValue},\n"
		+"	`Value` = #{taxy.Value}\n"
		+" Where ID = #{taxy.ID}")
	void updateTaxy(@Param("taxy") Taxy taxy);

}
