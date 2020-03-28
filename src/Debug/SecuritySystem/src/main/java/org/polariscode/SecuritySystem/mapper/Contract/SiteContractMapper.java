package org.polariscode.SecuritySystem.mapper.Contract;

import java.util.List;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import org.polariscode.SecuritySystem.model.Base.Site;
import org.polariscode.SecuritySystem.model.Table;
import org.apache.ibatis.annotations.Insert;
import org.polariscode.SecuritySystem.model.Contract.SiteContract;
import org.apache.ibatis.annotations.Update;

public interface SiteContractMapper {
	@Select("select  s.ID ,s.Name,s.Address ,s.Leader,s.Leadership,s.Manager,\n"
		+"s.District ,s.Type ,s.Status,sc.ContractID CustomerID \n"
		+"from  SiteContract sc\n"
		+"join Site s on sc.siteID=s.id\n"
		+" where sc.id=#{id}")
	Site getSiteContractById(@Param("id") int id);

	@Select("select count(*) Count\n"
		+"from  SiteContract sc\n"
		+"join Site s on sc.siteID=s.id\n"
		+" where sc.ContractID=#{ContractID}  and isdelete=0")
	Table getSiteContractByCount(@Param("ContractID") int ContractID);

	@Insert("Insert Into SiteContract(SiteId, ContractId)\n"
		+" Values(#{sitecontract.SiteId}, #{sitecontract.ContractId})")
	void insertSiteContract(@Param("sitecontract") SiteContract sitecontract);

	@Select("select sc.ID, s.Name,s.Address ,s.Leader,s.Leadership,s.Manager,\n"
		+"s.District ,s.Type ,s.Status\n"
		+"from  SiteContract sc\n"
		+"join Site s on sc.siteID=s.id\n"
		+" where sc.ContractID=#{ContractID}  and isdelete=0\n"
		+"limit #{startIndex}, #{rowCount}")
	List<Site> getSiteContractByContractID(@Param("startIndex") int startIndex, @Param("rowCount") int rowCount, @Param("ContractID") int ContractID);

	@Insert("Insert Into Site(Name, CustomerID, Leader, Leadership, \n"
		+"OrgID, Manager, District, Address, Describes, \n"
		+"Type, Status, InDate, OutDate, Kq, CreateUser, CreateTime, \n"
		+"LeaderName, LeaderPhone, Lng, Lat)\n"
		+" Values(#{site.Name}, (select  CustomerID from Contract   where id= #{site.CustomerID}), \n"
		+"#{site.Leader}, #{site.Leadership},  (select  OrgID  from Contract   where id= #{site.CustomerID}), \n"
		+"#{site.Manager}, #{site.District}, #{site.Address}, \n"
		+"#{site.Describes}, #{site.Type}, #{site.Status}, #{site.InDate},\n"
		+" #{site.OutDate}, #{site.Kq},  #{site.CreateUser}, Now(),\n"
		+"   #{site.LeaderName}, #{site.LeaderPhone}, #{site.Lng}, #{site.Lat});")
	void insertSite(@Param("site") Site site);

	@Update("Update Site Set\n"
		+"	Name = #{site.Name},\n"
		+"	CustomerID = (select  CustomerID from Contract  where id= #{site.CustomerID}),\n"
		+"	Leader = #{site.Leader},\n"
		+"	Leadership = #{site.Leadership},\n"
		+"	OrgID = (select OrgID  from Contract  where id= #{site.CustomerID}),\n"
		+"	Manager = #{site.Manager},\n"
		+"	District = #{site.District},\n"
		+"	Address = #{site.Address},\n"
		+"	Describes = #{site.Describes},\n"
		+"	Type = #{site.Type},\n"
		+"	Status = #{site.Status},\n"
		+"	InDate = #{site.InDate},\n"
		+"	OutDate = #{site.OutDate},\n"
		+"	Kq = #{site.Kq},\n"
		+"	ModifyUser = #{site.CreateUser},\n"
		+"	ModifyTime = now(),\n"
		+" Where ID = #{site.ID}")
	void updateSite(@Param("site") Site site);

}
