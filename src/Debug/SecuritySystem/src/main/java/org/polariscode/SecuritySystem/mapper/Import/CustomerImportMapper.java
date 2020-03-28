package org.polariscode.SecuritySystem.mapper.Import;

import java.util.List;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import org.polariscode.SecuritySystem.model.Base.Customer;
import org.apache.ibatis.annotations.Insert;
import org.polariscode.SecuritySystem.model.Base.Site;
import org.polariscode.SecuritySystem.model.Import.CustomerlinkmanImport;
import org.polariscode.SecuritySystem.model.Import.personnelImport;
import org.polariscode.SecuritySystem.model.Table;
import org.apache.ibatis.annotations.Update;
import org.polariscode.SecuritySystem.model.Config.District;
import org.polariscode.SecuritySystem.model.Permission.Org;
import org.polariscode.SecuritySystem.model.Permission.User;
import org.polariscode.SecuritySystem.model.Import.SitelinkmanImport;

public interface CustomerImportMapper {
	//获取人员信息表
	@Select("select * from Customer where name =#{Name}")
	Customer getCustomerByName(@Param("Name") String Name);

	@Insert("INSERT INTO customer( `Name`, `OrgID`, `Manager`, \n"
		+"`Leader`, `Address`, `District`, `Describes`, `Type`, `Status`, `Isdelete`, \n"
		+"`CreateUser`, `CreateTime`)\n"
		+"VALUES (#{c.Name},#{c.OrgID},#{c.Manager},\n"
		+"#{c.Leader},#{c.Address},#{c.District},#{c.Describes},#{c.Type},#{c.Status},\n"
		+"#{c.Isdelete},#{c.CreateUser},now());")
	void InsertCustomer(@Param("c") Customer c);

	//获得驻点信息
	@Select("select * from site where name=#{name}")
	Site getSiteByName(@Param("name") String name);

	@Insert("INSERT INTO `site`( `Name`, `CustomerID`, \n"
		+"`Leader`,Leadership, `OrgID`, `Manager`, `Address`, `District`, \n"
		+"`Describes`, `Type`, `Status`, `InDate`, `OutDate`, \n"
		+"`Kq`, `Isdelete`, `CreateUser`, `CreateTime`,LeaderName,LeaderPhone) \n"
		+"VALUES (#{s.Name},#{s.CustomerID},\n"
		+"#{s.Leader},#{s.Leadership},#{s.OrgID},#{s.Manager},#{s.Address},\n"
		+"#{s.District},#{s.Describes},#{s.Type},#{s.Status},\n"
		+"#{s.InDate},#{s.OutDate},#{s.Kq},#{s.Isdelete},#{s.CreateUser},\n"
		+"now(),#{s.LeaderName},#{s.LeaderPhone});")
	void InsertSite(@Param("s") Site s);

	@Insert("INSERT INTO customerlinkman(ID, CustomerID, Name, Gender, Phone, Wchat, QQ, Email, Type) \n"
		+"VALUES (#{c.ID}, #{c.CustomerID}, #{c.Name}, #{c.Gender}, #{c.Phone},#{c.Wchat}, #{c.QQ}, #{c.Email}, #{c.Type});")
	void Insertcustomerlinkman(@Param("c") CustomerlinkmanImport c);

	@Select("<script>select * from customerlinkman where CustomerID=#{ID} \n"
		+"<choose>\n"
		+"<when test='Phone == \"\"'></when>\n"
		+"<when test='Phone == null'></when>\n"
		+"<otherwise>and Phone=#{Phone}</otherwise>\n"
		+"</choose>\n"
		+"</script>")
	List<CustomerlinkmanImport> getCustomerlinkmanByID(@Param("ID") int ID, @Param("Phone") String Phone);

	@Select("SELECT  p.* FROM  personnel p \n"
		+"join personnelmembers pm on p.id=pm.PersonnelID\n"
		+"where p.name =#{name} and  pm.Phone=#{Phone}")
	List<personnelImport> getPersonnelByName(@Param("name") String name, @Param("Phone") String Phone);

	@Insert("INSERT INTO `personnel`( Code,`Name`, `CreateUser`, `CreateTime`) VALUES (#{p.Code},#{p.Name}, #{p.CreateUser},now());")
	void InsertPersonnel(@Param("p") personnelImport p);

	@Insert("INSERT INTO `personnelmembers`(`PersonnelID`, `Name`, `Phone`) VALUES (#{PersonnelID}, #{Name}, #{Phone});")
	void InsertPersonnelmembers(@Param("PersonnelID") int PersonnelID, @Param("Name") String Name, @Param("Phone") String Phone);

	@Select("select  max(id) as id from personnel")
	Table getInsertPersonnelID();

	@Select("select max(ID) id from Customer")
	Table getInsertCustomerID();

	@Update("UPDATE `customer` SET `Name` = #{c.Name}, `OrgID` = #{c.OrgID}, \n"
		+"`Manager` = #{c.Manager}, `Leader` = #{c.Leader}, `Address` = #{c.Address},\n"
		+" `District` = #{c.District}, `Describes` = #{c.Describes}, `Type` = #{c.Type},\n"
		+" `Status` = #{c.Status}, `ModifyUser` = #{c.CreateUser}, `ModifyTime` = now()\n"
		+"WHERE `ID` = #{c.ID};")
	void UpdateCustomer(@Param("c") Customer c);

	@Update("UPDATE `site` SET `Name` = #{s.Name}, `CustomerID` = #{s.CustomerID}, \n"
		+"`Leader` = #{s.Leader}, Leadership=#{s.Leadership},`OrgID` = #{s.OrgID}, `Manager` = #{s.Manager},\n"
		+" `Address` = #{s.Address}, `District` = #{s.District}, `Describes` = #{s.Describes}, \n"
		+"`Type` = #{s.Type}, `Status` = #{s.Status}, `ModifyUser` = #{s.CreateUser}, \n"
		+"`ModifyTime` = now() ,`LeaderName` = #{s.LeaderName}, `LeaderPhone` = #{s.LeaderPhone} \n"
		+"WHERE `ID` = #{s.ID};")
	void UpdateSite(@Param("s") Site s);

	//根据城市名匹配城市信息
	@Select("select * from district where name like'%${name}%'")
	List<District> getDistrictByName(@Param("name") String name);

	@Select("select * from org where name like '%${name}%'")
	List<Org> getOrgByName(@Param("name") String name);

	@Select("select * from user  where name=#{name}")
	List<User> getUserByname(@Param("name") String name);

	@Select("select * from sitelinkman")
	List<SitelinkmanImport> getSitelinkman();

	@Select("select  max(id) as id from Site")
	Table getInsertSiteID();

	@Insert("INSERT INTO `sitelinkman`( `SiteID`, `Name`, `Gender`, `Phone`, `Wchat`, `QQ`, `Email`, `Type`) \n"
		+"VALUES ( #{s.SiteID}, #{s.Name}, #{s.Gender}, #{s.Phone}, #{s.Wchat}, #{s.QQ}, #{s.Email}, #{s.Type});")
	void InsertSitelinkman(@Param("s") SitelinkmanImport s);

	@Select("select  COUNT(*) c  from sitelinkman where `name`=#{name} and  Phone=#{Phone}")
	@Results({
		@Result(property = "Count", column = "c")
	})
	Table getSitelinkmanByName(@Param("name") String name, @Param("Phone") String Phone);

}
