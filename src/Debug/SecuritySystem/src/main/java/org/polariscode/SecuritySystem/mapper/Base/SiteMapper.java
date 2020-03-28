package org.polariscode.SecuritySystem.mapper.Base;

import java.util.List;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import org.polariscode.SecuritySystem.model.Base.Site;
import org.polariscode.SecuritySystem.model.Table;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.polariscode.SecuritySystem.model.Base.SitePersonnel;

public interface SiteMapper {
	@Select("<script>Select *\n"
		+"From Site\n"
		+"Where Name Like &apos;%${name}%&apos;\n"
		+"	\n"
		+"<choose>\n"
		+"<when test='city == \"\"'></when>\n"
		+"<otherwise>And District = #{city}</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+"	\n"
		+"<choose>\n"
		+"<when test='org == \"\"'></when>\n"
		+"<otherwise>And OrgID = #{org}</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+"	\n"
		+"<choose>\n"
		+"<when test='manager == \"\"'></when>\n"
		+"<otherwise>And Manager = #{manager}</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+"	\n"
		+"<choose>\n"
		+"<when test='status == \"\"'></when>\n"
		+"<otherwise>And Status = #{status}</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+"	\n"
		+"<choose>\n"
		+"<when test='orgid == 0'></when>\n"
		+"<otherwise>And OrgID = #{orgid}</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+"limit #{startIndex}, #{rowCount}</script>")
	List<Site> getAllSites(@Param("name") String name, @Param("city") String city, @Param("status") String status, @Param("org") String org, @Param("manager") String manager, @Param("startIndex") int startIndex, @Param("rowCount") int rowCount, @Param("orgid") int orgid);

	@Select("<script>Select Count(1) As Count \n"
		+"From Site\n"
		+"Where Name Like &apos;%${name}%&apos;\n"
		+"	\n"
		+"<choose>\n"
		+"<when test='city == \"\"'></when>\n"
		+"<otherwise>And District = #{city}</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+"	\n"
		+"<choose>\n"
		+"<when test='org == \"\"'></when>\n"
		+"<otherwise>And OrgID = #{org}</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+"	\n"
		+"<choose>\n"
		+"<when test='manager == \"\"'></when>\n"
		+"<otherwise>And Manager = #{manager}</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+"	\n"
		+"<choose>\n"
		+"<when test='status == \"\"'></when>\n"
		+"<otherwise>And Status = #{status}</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+"	\n"
		+"<choose>\n"
		+"<when test='orgid == 0'></when>\n"
		+"<otherwise>And OrgID = #{orgid}</otherwise>\n"
		+"</choose>\n"
		+"</script>")
	Table getAllSitesCount(@Param("name") String name, @Param("city") String city, @Param("status") String status, @Param("org") String org, @Param("manager") String manager, @Param("orgid") int orgid);

	@Insert("Insert Into Site(Name, CustomerID, Leader, OrgID, Manager, District, Address, Describes, Type, Status, InDate, OutDate, Kq, Lng, Lat, Isdelete, CreateUser, CreateTime)\n"
		+" Values(#{site.Name}, #{site.CustomerID}, #{site.Leader}, #{site.OrgID}, #{site.Manager}, #{site.District}, #{site.Address}, #{site.Describes}, #{site.Type}, #{site.Status}, #{site.InDate}, #{site.OutDate}, #{site.Kq}, #{site.Lng}, #{site.Lat}, #{site.Isdelete}, #{site.CreateUser}, Now())")
	void insertSite(@Param("site") Site site);

	@Update("Update Site Set\n"
		+"	Name = #{site.Name},\n"
		+"	CustomerID = #{site.CustomerID},\n"
		+"	Leader = #{site.Leader},\n"
		+"	OrgID = #{site.OrgID},\n"
		+"	Manager = #{site.Manager},\n"
		+"	District = #{site.District},\n"
		+"	Address = #{site.Address},\n"
		+"	Describes = #{site.Describes},\n"
		+"	Type = #{site.Type},\n"
		+"	Status = #{site.Status},\n"
		+"	InDate = #{site.InDate},\n"
		+"	OutDate = #{site.OutDate},\n"
		+"	Kq = #{site.Kq},\n"
		+"	Lng = #{site.Lng},\n"
		+"	Lat = #{site.Lat},\n"
		+"	Isdelete = #{site.Isdelete},\n"
		+"	CreateUser = #{site.CreateUser},\n"
		+"	CreateTime = #{site.CreateTime},\n"
		+"	ModifyUser = #{site.ModifyUser},\n"
		+"	ModifyTime = #{site.ModifyTime},\n"
		+"	DeleteUser = #{site.DeleteUser},\n"
		+"	DeleteTime = #{site.DeleteTime}\n"
		+" Where ID = #{site.ID}")
	void updateSite(@Param("site") Site site);

	@Select("Select * From Site Where ID=#{id}")
	Site getSiteById(@Param("id") int id);

	@Select("Select SP.ID, SP.PID, CONCAT(P.Name, SUBSTR(CardCode, 9,2)) As Name, SP.BeginDate, SP.EndDate, SP.IsMain, SP.Job, SP.Level, SP.PostSubsidy\n"
		+"From Personnel P Join SitePersonnel SP On P.ID = SP.PID \n"
		+"Where SP.SiteID = #{siteid} \n"
		+"And SP.BeginDate <= #{enddate} And IFNULL(EndDate, '2100-1-1') >= #{begdate}\n"
		+"Order By convert(Name using gbk) collate gbk_chinese_ci")
	List<SitePersonnel> getPersonnelBySite(@Param("siteid") int siteid, @Param("begdate") java.util.Date begdate, @Param("enddate") java.util.Date enddate);

}
