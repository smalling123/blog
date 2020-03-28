package org.polariscode.SecuritySystem.mapper.Salary;

import java.util.List;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import org.polariscode.SecuritySystem.model.Salary.Insurance;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.polariscode.SecuritySystem.model.Salary.InsuranceItem;
import org.apache.ibatis.annotations.Delete;

public interface InsuranceMapper {
	@Select("<script>Select * \n"
		+"From Insurance</script>")
	List<Insurance> getAllInsurance();

	@Insert("Insert Into Insurance(City, Name)\n"
		+" Values(#{insurance.City}, #{insurance.Name})")
	void insertInsurance(@Param("insurance") Insurance insurance);

	@Update("Update Insurance Set\n"
		+"	City = #{insurance.City},\n"
		+"	Name = #{insurance.Name}\n"
		+" Where ID = #{insurance.ID}")
	void updateInsurance(@Param("insurance") Insurance insurance);

	@Select("Select * From Insurance Where ID = #{id}")
	Insurance getInsuranceOne(@Param("id") int id);

	@Select("Select * From InsuranceItem Where InsuranceId = #{id}\n"
		+"Order By Year, Month")
	List<InsuranceItem> getInsuraceItems(@Param("id") int id);

	@Insert("<script>Insert Into InsuranceItem(InsuranceId, Year, Month, BaseMin, BaseMax, CTotalRate, CTotalValue, C1Rate, C1Value, C2Rate, C2Value, C3Rate, C3Value, C4Rate, C4Value, C5Rate, C5Value, C6Rate, C6Value, P1Rate, P1Value, P2Rate, P3Rate, P2Value, P3Value) Values\n"
		+"<foreach collection='insuranceitem' item='c' index='index' separator=','>\n"
		+"(#{insuranceId}, #{c.Year}, #{c.Month}, #{c.BaseMin}, #{c.BaseMax}, #{c.CTotalRate}, #{c.CTotalValue}, #{c.C1Rate}, #{c.C1Value}, #{c.C2Rate}, #{c.C2Value}, #{c.C3Rate}, #{c.C3Value}, #{c.C4Rate}, #{c.C4Value}, #{c.C5Rate}, #{c.C5Value}, #{c.C6Rate}, #{c.C6Value}, #{c.P1Rate}, #{c.P1Value}, #{c.P2Rate}, #{c.P3Rate}, #{c.P2Value}, #{c.P3Value})\n"
		+"</foreach>\n"
		+"</script>")
	void insertInsuranceItem(@Param("insuranceitem") List<InsuranceItem> insuranceitem, @Param("insuranceId") int insuranceId);

	@Delete("Delete From InsuranceItem Where InsuranceId = #{id}")
	void deleteInsuranceItem(@Param("id") int id);

}
