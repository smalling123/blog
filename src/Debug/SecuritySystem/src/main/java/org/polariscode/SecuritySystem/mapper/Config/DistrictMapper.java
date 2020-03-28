package org.polariscode.SecuritySystem.mapper.Config;

import java.util.List;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import org.polariscode.SecuritySystem.model.Config.District;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.polariscode.SecuritySystem.model.Excel;
import org.apache.ibatis.annotations.Delete;

public interface DistrictMapper {
	@Select("Select * From District Where PID = #{pid}")
	List<District> getDistrictByPid(@Param("pid") int pid);

	@Insert("Insert Into District(ID, PID, Name, MergerName, ShortName, MergerShotName, Level, CityCode, ZipCode, PinYin, JianPin, FirstChar, Lng, Lat)\n"
		+"Values(#{district.ID}, #{district.PID}, #{district.Name}, #{district.MergerName}, #{district.ShortName}, #{district.MergerShotName}, #{district.Level}, #{district.CityCode}, #{district.ZipCode}, #{district.PinYin}, #{district.JianPin}, #{district.FirstChar}, #{district.Lng}, #{district.Lat})")
	void InsertDistrict(@Param("district") District district);

	@Update("Udate Dictrict  set\n"
		+"	PID = #{district.PID}, \n"
		+"	Name = #{district.Name}, \n"
		+"	MergerName = #{district.MergerName}, \n"
		+"	ShortName = #{district.ShortName}, \n"
		+"	MergerShotName = #{district.MergerShotName}, \n"
		+"	Level = #{district.Level}, \n"
		+"	CityCode = #{district.CityCode}, \n"
		+"	ZipCode = #{district.ZipCode}, \n"
		+"	PinYin = #{district.PinYin}, \n"
		+"	JianPin = #{district.JianPin}, \n"
		+"	FirstChar = #{district.FirstChar}, \n"
		+"	Lng = #{district.Lng}, \n"
		+"	Lat = #{district.Lat}\n"
		+"Where ID = #{district.ID}")
	void UpdateDistrict(@Param("district") District district);

	//导入
	@Insert("<script>Insert Into District(ID, PID, Name, MergerName, ShortName, MergerShotName, Level, CityCode, ZipCode, PinYin, JianPin, FirstChar, Lng, Lat) Values\n"
		+"<foreach collection='list' item='c' index='index' separator=','>\n"
		+"(#{c.A}, #{c.B}, #{c.C}, #{c.D}, #{c.E}, #{c.F}, #{c.G}, #{c.H}, #{c.I}, #{c.J}, #{c.K}, #{c.L}, #{c.M}, #{c.N})\n"
		+"</foreach>\n"
		+"</script>")
	void ImportDistrict(@Param("list") List<Excel> list);

	//删除所有记录
	@Delete("Delete From District")
	void DeleteAllDistrict();

	//获取指定的记录
	@Select("Select * From District Where ID = #{id}")
	District getDistrictOne(@Param("id") int id);

}
