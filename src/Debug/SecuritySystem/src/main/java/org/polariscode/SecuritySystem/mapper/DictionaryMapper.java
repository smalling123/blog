package org.polariscode.SecuritySystem.mapper;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import org.polariscode.SecuritySystem.model.DictionaryItem;

public interface DictionaryMapper {
	@Select("Select Convert(ID, char(20)) as Code, ShortName as Name \n"
		+"From District\n"
		+"Where Name like '%${filter}%' or PinYin like '%${filter}%' or JianPin like '%${filter}%' or ID=#{filter}\n"
		+"Order By convert(ShortName using gbk) collate gbk_chinese_ci")
	List<DictionaryItem> City(@Param("filter") String filter);

	@Select("Select ShortName as Name \n"
		+"From District\n"
		+"Where ID = #{code}")
	DictionaryItem ConvertCity(@Param("code") String code);

	@Select("Select ID as Code, Name \n"
		+"From Company\n"
		+"Order By ID")
	List<DictionaryItem> Company();

	@Select("Select Name \n"
		+"From Company\n"
		+"Where ID = #{code}")
	DictionaryItem ConvertCompany(@Param("code") String code);

	@Select("Select Convert(ID, char(20)) as Code, Name as Name \n"
		+"From Customer\n"
		+"Where Name like '%${filter}%'\n"
		+"Order By convert(Name using gbk) collate gbk_chinese_ci")
	List<DictionaryItem> Customer(@Param("filter") String filter);

	@Select("Select Name as Name \n"
		+"From Customer\n"
		+"Where ID = #{code}")
	DictionaryItem ConvertCustomer(@Param("code") String code);

	@Select("Select Convert(ID, char(20)) as Code, Name as Name \n"
		+"From Equipment\n"
		+"Where Name like '%${filter}%' \n"
		+"Order By convert(Name using gbk) collate gbk_chinese_ci")
	List<DictionaryItem> Equipment(@Param("filter") String filter);

	@Select("Select Name as Name \n"
		+"From Equipment\n"
		+"Where ID = #{code}")
	DictionaryItem ConvertEquipment(@Param("code") String code);

	@Select("Select Convert(ID, char(20)) as Code, Name as Name \n"
		+"From User\n"
		+"Where Name like '%${filter}%' or LoginName like '%${filter}%'\n"
		+"Order By convert(Name using gbk) collate gbk_chinese_ci")
	List<DictionaryItem> Manager(@Param("filter") String filter);

	@Select("Select Name as Name \n"
		+"From User\n"
		+"Where ID = #{code}")
	DictionaryItem ConvertManager(@Param("code") String code);

	@Select("Select Convert(ID, char(20)) as Code, Name as Name \n"
		+"From Org")
	List<DictionaryItem> Org();

	@Select("Select Name as Name \n"
		+"From Org\n"
		+"Where ID = #{code}")
	DictionaryItem ConvertOrg(@Param("code") String code);

	@Select("Select Convert(ID, char(20)) as Code, Name as Name \n"
		+"From OrgType")
	List<DictionaryItem> OrgType();

	@Select("Select Name as Name \n"
		+"From OrgType \n"
		+"Where ID = #{code}")
	DictionaryItem ConvertOrgType(@Param("code") String code);

	@Select("Select Convert(ID, char(20)) as Code, Name as Name \n"
		+"From EmployeeApplication\n"
		+"Where Name like '%${filter}%' or Account like '%${filter}%'\n"
		+"Order By convert(Name using gbk) collate gbk_chinese_ci")
	List<DictionaryItem> Personnel(@Param("filter") String filter);

	@Select("Select Name \n"
		+"From Personnel \n"
		+"Where ID = #{code}")
	DictionaryItem ConvertPersonnel(@Param("code") String code);

	@Select("Select Convert(ID, char(20)) as Code, CONCAT(Name, SUBSTR(CardCode, 9, 2)) as Name \n"
		+"From Personnel\n"
		+"Where Name like '%${filter}%' or Code like '%${filter}%'\n"
		+"Order By convert(Name using gbk) collate gbk_chinese_ci")
	List<DictionaryItem> PersonnelEx(@Param("filter") String filter);

	@Select("Select CONCAT(Name, SUBSTR(CardCode, 9, 2)) as Name \n"
		+"From Personnel\n"
		+"Where ID = #{code}")
	DictionaryItem ConvertPersonnelEx(@Param("code") String code);

	@Select("Select Convert(ID, char(20)) as Code, ShortName as Name \n"
		+"From District\n"
		+"Where PID = 100000")
	List<DictionaryItem> Province();

	@Select("Select ShortName as Name \n"
		+"From District\n"
		+"Where ID = #{code}")
	DictionaryItem ConvertProvince(@Param("code") String code);

	@Select("Select Convert(ID, char(20)) as Code, Name as Name \n"
		+"From Site\n"
		+"Where Name like '%${filter}%'\n"
		+"Order By convert(Name using gbk) collate gbk_chinese_ci")
	List<DictionaryItem> Site(@Param("filter") String filter);

	@Select("Select Name as Name \n"
		+"From Site \n"
		+"Where ID = #{code}")
	DictionaryItem ConvertSite(@Param("code") String code);

	@Select("Select Convert(Org.ID, char(20)) as Code, Org.Name as Name \n"
		+"From Org Join OrgType On Org.OrgType = OrgType.ID And OrgType.ID = 2")
	List<DictionaryItem> SiteOrg();

	@Select("Select Name as Name \n"
		+"From Org\n"
		+"Where ID = #{code}")
	DictionaryItem ConvertSiteOrg(@Param("code") String code);

	@Select("Select Convert(ID, char(20)) as Code, Name as Name \n"
		+"From Staff\n"
		+"Order By convert(Name using gbk) collate gbk_chinese_ci")
	List<DictionaryItem> Staff();

	@Select("Select Name as Name \n"
		+"From Staff \n"
		+"Where ID = #{code}")
	DictionaryItem ConvertStaff(@Param("code") String code);

	@Select("Select Convert(ID, char(20)) as Code, Name as Name \n"
		+"From User\n"
		+"Where Name like '%${filter}%' or LoginName like '%${filter}%'  \n"
		+"Order By convert(Name using gbk) collate gbk_chinese_ci")
	List<DictionaryItem> User(@Param("filter") String filter);

	@Select("Select Name as Name \n"
		+"From User\n"
		+"Where ID = #{code}")
	DictionaryItem ConvertUser(@Param("code") String code);

}
