package org.polariscode.SecuritySystem.mapper.SiteManage;

import java.util.List;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import org.polariscode.SecuritySystem.model.SiteManage.SitePostWeek;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.polariscode.SecuritySystem.model.SiteManage.ScheduleOne;

public interface SiteManageMapper {
	@Select("Select SPI.Post, SPI.Schedule, SPI.BeginTime, SPI.EndTime, Max(PosNumber) As PosNumber,\n"
		+"	DATE_ADD(#{date},interval (0-#{week}) DAY) as D1, \n"
		+"	DATE_ADD(#{date},interval (1-#{week}) DAY) as D2, \n"
		+"	DATE_ADD(#{date},interval (2-#{week}) DAY) as D3, \n"
		+"	DATE_ADD(#{date},interval (3-#{week}) DAY) as D4, \n"
		+"	DATE_ADD(#{date},interval (4-#{week}) DAY) as D5, \n"
		+"	DATE_ADD(#{date},interval (5-#{week}) DAY) as D6, \n"
		+"	DATE_ADD(#{date},interval (6-#{week}) DAY) as D7,\n"
		+"	SUM(CASE WHEN SP.BeginDate <= DATE_ADD(#{date},interval (0-#{week}) DAY) And SP.EndDate >= DATE_ADD(#{date},interval (0-#{week}) DAY) THEN SPI.PosNumber ELSE 0 ENd ) As N1,\n"
		+"	SUM(CASE WHEN SP.BeginDate <= DATE_ADD(#{date},interval (1-#{week}) DAY) And SP.EndDate >= DATE_ADD(#{date},interval (1-#{week}) DAY) THEN SPI.PosNumber ELSE 0 ENd ) As N2,\n"
		+"	SUM(CASE WHEN SP.BeginDate <= DATE_ADD(#{date},interval (2-#{week}) DAY) And SP.EndDate >= DATE_ADD(#{date},interval (2-#{week}) DAY) THEN SPI.PosNumber ELSE 0 ENd ) As N3,\n"
		+"	SUM(CASE WHEN SP.BeginDate <= DATE_ADD(#{date},interval (3-#{week}) DAY) And SP.EndDate >= DATE_ADD(#{date},interval (3-#{week}) DAY) THEN SPI.PosNumber ELSE 0 ENd ) As N4,\n"
		+"	SUM(CASE WHEN SP.BeginDate <= DATE_ADD(#{date},interval (4-#{week}) DAY) And SP.EndDate >= DATE_ADD(#{date},interval (4-#{week}) DAY) THEN SPI.PosNumber ELSE 0 ENd ) As N5,\n"
		+"	SUM(CASE WHEN SP.BeginDate <= DATE_ADD(#{date},interval (5-#{week}) DAY) And SP.EndDate >= DATE_ADD(#{date},interval (5-#{week}) DAY) THEN SPI.PosNumber ELSE 0 ENd ) As N6,\n"
		+"	SUM(CASE WHEN SP.BeginDate <= DATE_ADD(#{date},interval (6-#{week}) DAY) And SP.EndDate >= DATE_ADD(#{date},interval (6-#{week}) DAY) THEN SPI.PosNumber ELSE 0 ENd ) As N7,\n"
		+"	MAX(CASE WHEN SP.BeginDate <= DATE_ADD(#{date},interval (0-#{week}) DAY) And SP.EndDate >= DATE_ADD(#{date},interval (0-#{week}) DAY) THEN SPI.ID ELSE 0 ENd ) As SPI1,\n"
		+"	MAX(CASE WHEN SP.BeginDate <= DATE_ADD(#{date},interval (1-#{week}) DAY) And SP.EndDate >= DATE_ADD(#{date},interval (1-#{week}) DAY) THEN SPI.ID ELSE 0 ENd ) As SPI2,\n"
		+"	MAX(CASE WHEN SP.BeginDate <= DATE_ADD(#{date},interval (2-#{week}) DAY) And SP.EndDate >= DATE_ADD(#{date},interval (2-#{week}) DAY) THEN SPI.ID ELSE 0 ENd ) As SPI3,\n"
		+"	MAX(CASE WHEN SP.BeginDate <= DATE_ADD(#{date},interval (3-#{week}) DAY) And SP.EndDate >= DATE_ADD(#{date},interval (3-#{week}) DAY) THEN SPI.ID ELSE 0 ENd ) As SPI4,\n"
		+"	MAX(CASE WHEN SP.BeginDate <= DATE_ADD(#{date},interval (4-#{week}) DAY) And SP.EndDate >= DATE_ADD(#{date},interval (4-#{week}) DAY) THEN SPI.ID ELSE 0 ENd ) As SPI5,\n"
		+"	MAX(CASE WHEN SP.BeginDate <= DATE_ADD(#{date},interval (5-#{week}) DAY) And SP.EndDate >= DATE_ADD(#{date},interval (5-#{week}) DAY) THEN SPI.ID ELSE 0 ENd ) As SPI6,\n"
		+"	MAX(CASE WHEN SP.BeginDate <= DATE_ADD(#{date},interval (6-#{week}) DAY) And SP.EndDate >= DATE_ADD(#{date},interval (6-#{week}) DAY) THEN SPI.ID ELSE 0 ENd ) As SPI7\n"
		+"From SitePost SP Join SitePostItem SPI on SP.ID = SPI.SItePostId\n"
		+"Where SP.Status = 1 And SP.SiteId = #{siteid}\n"
		+"		And (  (SP.BeginDate <= DATE_ADD(#{date},interval (6-#{week}) DAY) And SP.EndDate >= DATE_ADD(#{date},interval (0-#{week}) DAY)  )\n"
		+"			or (SP.BeginDate >= DATE_ADD(#{date},interval (0-#{week}) DAY) And SP.EndDate <= DATE_ADD(#{date},interval (6-#{week}) DAY)  )  )\n"
		+"Group By SPI.Post, SPI.Schedule, SPI.BeginTime, SPI.EndTime")
	List<SitePostWeek> getSitePostByWeek(@Param("date") java.util.Date date, @Param("siteid") int siteid, @Param("week") int week);

	@Insert("Insert Into Schedule(Spiid, Date, PID, CreateUser, CreateTime)\n"
		+"Values(#{spiid}, #{date}, #{pid}, #{user}, now())")
	void insertSchedule(@Param("spiid") int spiid, @Param("date") java.util.Date date, @Param("pid") int pid, @Param("user") String user);

	@Update("Update Schedule Set PID = #{pid},  History = CONCAT(IFNULL(History,''), #{pid}, ','), ModifyUser = #{user}, ModifyTime = Now()\n"
		+"Where  id = #{id}")
	void updateSchedule(@Param("id") int id, @Param("pid") int pid, @Param("user") String user);

	@Select("Select S.* \n"
		+"From Schedule S Join SitePostItem SPI on S.SpiId = SPI.ID \n"
		+"		Join SitePost SP on SPI.SitePostId = SP.ID\n"
		+"Where  SP.SiteID = #{siteid} And S.Date = DATE_ADD(#{date},interval (0-#{week}) DAY)")
	List<ScheduleOne> getScheduleByDay(@Param("siteid") int siteid, @Param("date") java.util.Date date, @Param("week") int week);

	@Update("Update Schedule Set Status = #{status}, ModifyUser = #{user}, ModifyTime = Now()\n"
		+"Where  id = #{id}")
	void updateScheduleStatus(@Param("id") int id, @Param("status") int status, @Param("user") String user);

	@Update("Update Site set Leader = #{pid} Where id = #{siteid}")
	void updateLeader(@Param("pid") int pid, @Param("siteid") int siteid);

}
