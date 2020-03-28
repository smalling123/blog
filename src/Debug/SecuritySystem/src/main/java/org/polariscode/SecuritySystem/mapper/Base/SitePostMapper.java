package org.polariscode.SecuritySystem.mapper.Base;

import java.util.List;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import org.polariscode.SecuritySystem.model.Base.SitePost;
import org.polariscode.SecuritySystem.model.Base.SitePostItem;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;

public interface SitePostMapper {
	//获取驻点执勤配置表
	@Select("Select *\n"
		+"From SitePost\n"
		+"Where SiteID = #{siteid} And Status = 1\n"
		+"Order By ID Desc")
	List<SitePost> getSitePost(@Param("siteid") int siteid);

	//获取执勤配置表明细
	@Select("Select *\n"
		+"From SitePostItem\n"
		+"Where SitePostID = #{id}")
	List<SitePostItem> getSitePostItem(@Param("id") int id);

	@Select("Select *\n"
		+"From SitePost\n"
		+"Where SiteID = #{siteid} And Status = 0")
	SitePost getEditSitePostI(@Param("siteid") int siteid);

	//获取指定ID的执勤表
	@Select("Select * From SitePost Where ID = #{id}")
	SitePost getSitePostOne(@Param("id") int id);

	//创建新的执勤配置表
	@Insert("Insert Into SitePost(siteid, begindate, enddate, createUser, createTime)\n"
		+"values(#{siteid}, now(), '2100-1-1', #{user}, now());\n"
		+"Insert Into SitePostItem(SitePostID, Post, Schedule, Type, BeginTime, EndTime, PosNumber, ContractNumber, WorkNumber, BeginDate, EndDate, Day1, Day2, Day3, Day4, Day5, Day6, Day7, DayH, CalcTime, FullTime, Describes, OldId)\n"
		+"Select LAST_INSERT_ID() ,Post, Schedule, Type, BeginTime, EndTime, PosNumber, ContractNumber, WorkNumber, BeginDate, EndDate, Day1, Day2, Day3, Day4, Day5, Day6, Day7, DayH, CalcTime, FullTime, Describes, Id\n"
		+"From SitePostItem\n"
		+"Where SitePostID = (Select Max(ID) From SitePost Where Status=1 And SiteID = #{siteid});")
	void createEditSitePost(@Param("siteid") int siteid, @Param("user") String user);

	@Update("Update SitePost Set\n"
		+"	SiteId = #{sitepost.SiteId},\n"
		+"	BeginDate = #{sitepost.BeginDate},\n"
		+"	EndDate = #{sitepost.EndDate},\n"
		+"	Status = #{sitepost.Status},\n"
		+"	Describes = #{sitepost.Describes},\n"
		+"	ApplyUser = #{sitepost.ApplyUser},\n"
		+"	ApplyTime = Now()\n"
		+" Where ID = #{sitepost.ID}")
	void updateSitePost(@Param("sitepost") SitePost sitepost);

	@Insert("<script>Insert Into SitePostItem(SitePostId, Post, Schedule, Type, BeginTime, EndTime, PosNumber, ContractNumber, WorkNumber, BeginDate, EndDate, Day1, Day2, Day3, Day4, Day5, Day6, Day7, DayH, CalcTime, FullTime, Describes, OldId) Values\n"
		+"<foreach collection='sitepostitem' item='c' index='index' separator=','>\n"
		+"(#{id}, #{c.Post}, #{c.Schedule}, #{c.Type}, #{c.BeginTime}, #{c.EndTime}, #{c.PosNumber}, #{c.ContractNumber}, #{c.WorkNumber}, #{c.BeginDate}, #{c.EndDate}, #{c.Day1}, #{c.Day2}, #{c.Day3}, #{c.Day4}, #{c.Day5}, #{c.Day6}, #{c.Day7}, #{c.DayH}, #{c.CalcTime}, #{c.FullTime}, #{c.Describes}, #{c.OldId})\n"
		+"</foreach>\n"
		+"</script>")
	void insertSitePostItem(@Param("sitepostitem") List<SitePostItem> sitepostitem, @Param("id") int id);

	@Delete("Delete From SitePostItem Where SitePostID = #{id}")
	void deleteSitePostItem(@Param("id") int id);

	//获取最新一个已发布的执勤表
	@Select("Select *\n"
		+"From SitePost\n"
		+"Where SiteID = #{siteid} And Status = 1\n"
		+"Order By ID Desc\n"
		+"LIMIT 0, 1")
	SitePost getLastSitePost(@Param("siteid") int siteid);

	//更新执勤配置表的结束日期
	@Update("Update SitePost Set EndDate = adddate(#{date},-1) Where ID = #{id}")
	void updateSitePostEndDate(@Param("id") int id, @Param("date") java.util.Date date);

}
