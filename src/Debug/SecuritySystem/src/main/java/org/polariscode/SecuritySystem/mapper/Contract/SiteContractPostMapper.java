package org.polariscode.SecuritySystem.mapper.Contract;

import java.util.List;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import org.polariscode.SecuritySystem.model.Contract.SiteContractPost;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Delete;

public interface SiteContractPostMapper {
	@Select("select * from sitecontractpost where SiteContractId =#{id}")
	List<SiteContractPost> getSiteContractPostById(@Param("id") int id);

	@Insert("<script>Insert Into SiteContractPost(SiteContractId, Post, Schedule, Type, BeginTime, EndTime, PosNumber, ContractNumber, WorkNumber, BeginDate, EndDate, Day1, Day2, Day3, Day4, Day5, Day6, Day7, DayH, CalcTime, Describes, FullTime, SalaryType, SalaryBase) Values\n"
		+"<foreach collection='sitecontractpost' item='c' index='index' separator=','>\n"
		+"(#{id}, #{c.Post}, #{c.Schedule}, #{c.Type}, #{c.BeginTime}, #{c.EndTime}, #{c.PosNumber}, #{c.ContractNumber}, #{c.WorkNumber}, #{c.BeginDate}, #{c.EndDate}, #{c.Day1}, #{c.Day2}, #{c.Day3}, #{c.Day4}, #{c.Day5}, #{c.Day6}, #{c.Day7}, #{c.DayH}, #{c.CalcTime}, #{c.Describes}, #{c.FullTime}, #{c.SalaryType}, #{c.SalaryBase})\n"
		+"</foreach>\n"
		+"</script>")
	void insertSiteContractPost(@Param("sitecontractpost") List<SiteContractPost> sitecontractpost, @Param("id") int id);

	@Delete("delete from sitecontractpost  where SiteContractId =#{id}")
	void deleteById(@Param("id") int id);

}
