package org.polariscode.SecuritySystem.mapper.Import;

import java.util.List;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.polariscode.SecuritySystem.model.Import.personnelImport;
import org.apache.ibatis.annotations.Update;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Select;
import org.polariscode.SecuritySystem.model.Table;
import org.polariscode.SecuritySystem.model.Import.SitepersonnelImport;

public interface PersonnelImportMapper {
	@Insert("<script>INSERT INTO `personnel`( `Code`, `Name`, `CardCode`, `Birthday`, `Gender`, \n"
		+"`Politics`, `Height`, `Weight`, `Education`, `Nation`, `Native`, `HomeAddress`,\n"
		+" `Census`, `CensusAddress`, `Marital`, `LinkMan`, `LinkManRelation`, `LinkManPhone`,\n"
		+" `Army`, `ArmyInDate`, `ArmyOutDate`, `Z1`, `Z2`, `Z3`, `Z4`, `Z5`, `Z6`, `Z7`, `Z8`, `Computer`,\n"
		+" `English`, `PartTime`, `Disease`, `Crime`, `Appearance`, `Communication`, `Source`, `InDate`, \n"
		+"`HTBeginDate`, `HTEndDate`, `Photo`, `PhotoCount`, `F1`, `F2`, `F3`, `F4`, `F5`, `F6`, `F7`, `F8`,\n"
		+" `F9`, `F10`, `GeneralComment`, `InterViewer`, `GivePost`, `PlanSite`, `PlantJob`, `PlanInDate`,\n"
		+" `CheckUser`, `HRUser`, `JobUser`, `CreateUser`, `CreateTime`)\n"
		+"VALUES (#{p.Code},#{p.Name},#{p.CardCode},\n"
		+"<choose>\n"
		+"<when test='p.getBirthday() == \"\"'>substring(#{p.CardCode},7,8)</when>\n"
		+"<otherwise>#{p.Birthday}</otherwise>\n"
		+"</choose>\n"
		+",\n"
		+"<choose>\n"
		+"<when test='p.getGender() == 0'>MOD(SUBSTR(#{p.CardCode},17,1),2)</when>\n"
		+"<otherwise>#{p.Gender}</otherwise>\n"
		+"</choose>\n"
		+",\n"
		+"#{p.Politics},#{p.Height},#{p.Weight},#{p.Education},#{p.Nation},\n"
		+"<choose>\n"
		+"<when test='p.getNative() == 0'>CONCAT(SUBSTR(#{p.CardCode},1,2),'0000'),</when>\n"
		+"<otherwise>#{p.Native}</otherwise>\n"
		+"</choose>\n"
		+",#{p.HomeAddress},\n"
		+"#{p.Census},#{p.CensusAddress},#{p.Marital},#{p.LinkMan},#{p.LinkManRelation},#{p.LinkManPhone},\n"
		+"#{p.Army},\n"
		+"<choose>\n"
		+"<when test='p.getArmyInDate() == \"\"'>'1900-01-01'</when>\n"
		+"<when test='p.getArmyOutDate() == null'>'1900-01-01'</when>\n"
		+"<otherwise>#{p.ArmyInDate}</otherwise>\n"
		+"</choose>\n"
		+",\n"
		+"<choose>\n"
		+"<when test='p.getArmyOutDate() == \"\"'>'1900-01-01'</when>\n"
		+"<when test='p.getArmyOutDate() == null'>'1900-01-01'</when>\n"
		+"<otherwise>#{p.ArmyOutDate}</otherwise>\n"
		+"</choose>\n"
		+",#{p.Z1},#{p.Z2},#{p.Z3},#{p.Z4},#{p.Z5},#{p.Z6},\n"
		+"#{p.Z7},#{p.Z8},#{p.Computer},#{p.English},#{p.PartTime},#{p.Disease},#{p.Crime},#{p.Appearance},\n"
		+"#{p.Communication},#{p.Source},\n"
		+"<choose>\n"
		+"<when test='p.getInDate() == \"\"'>'1900-01-01'</when>\n"
		+"<when test='p.getInDate() == null'>'1900-01-01'</when>\n"
		+"<otherwise>#{p.InDate}</otherwise>\n"
		+"</choose>\n"
		+",\n"
		+"<choose>\n"
		+"<when test='p.getHTBeginDate() == \"\"'>'1900-01-01'</when>\n"
		+"<when test='p.getHTBeginDate() == null'>'1900-01-01'</when>\n"
		+"<otherwise>#{p.HTBeginDate}</otherwise>\n"
		+"</choose>\n"
		+",\n"
		+"<choose>\n"
		+"<when test='p.getHTEndDate() == \"\"'>'1900-01-01'</when>\n"
		+"<when test='p.getHTBeginDate() == null'>'1900-01-01'</when>\n"
		+"<otherwise>#{p.HTEndDate}</otherwise>\n"
		+"</choose>\n"
		+",#{p.Photo},\n"
		+"#{p.PhotoCount},#{p.F1},#{p.F2},#{p.F3},#{p.F4},#{p.F5},#{p.F6},#{p.F7},#{p.F8},#{p.F9},#{p.F10},\n"
		+"#{p.GeneralComment},#{p.InterViewer},#{p.GivePost},#{p.PlanSite},#{p.PlantJob},\n"
		+"<choose>\n"
		+"<when test='p.getPlanInDate() == 0'>'1900-01-01'</when>\n"
		+"<when test='p.getPlanInDate() == 0'>'1900-01-01'</when>\n"
		+"<otherwise>#{p.PlanInDate}</otherwise>\n"
		+"</choose>\n"
		+",\n"
		+"#{p.CheckUser},#{p.HRUser},#{p.JobUser},#{p.CreateUser},Now());</script>")
	void InsertPersonnel(@Param("p") personnelImport p);

	@Update("<script>UPDATE `personnel` SET `Code` = #{p.Code}, `Name` = #{p.Name}, `CardCode` = #{p.CardCode},\n"
		+"\n"
		+"<choose>\n"
		+"<when test='p.getBirthday() == \"\"'></when>\n"
		+"<otherwise>`Birthday` = #{p.Birthday},</otherwise>\n"
		+"</choose>\n"
		+" \n"
		+"<choose>\n"
		+"<when test='p.getGender() == 0'></when>\n"
		+"<otherwise>`Gender` = #{p.Gender},</otherwise>\n"
		+"</choose>\n"
		+" `Politics` = #{p.Politics}, `Height` = #{p.Height}, `Weight` = #{p.Weight},\n"
		+"`Education` = #{p.Education}, `Nation` = #{p.Nation}, \n"
		+"<choose>\n"
		+"<when test='p.getNative() == 0'></when>\n"
		+"<otherwise>`Native` = #{p.Native},</otherwise>\n"
		+"</choose>\n"
		+" `HomeAddress` = #{p.HomeAddress},\n"
		+" `Census` = #{p.Census}, `CensusAddress` = #{p.CensusAddress}, `Marital` = #{p.Marital}, `LinkMan` = #{p.LinkMan},\n"
		+" `LinkManRelation` = #{p.LinkManRelation}, `LinkManPhone` = #{p.LinkManPhone}, `Army` = #{p.Army},\n"
		+" `ArmyInDate` = \n"
		+"<choose>\n"
		+"<when test='p.getArmyInDate() == \"\"'>'1900-01-01'</when>\n"
		+"<when test='p.getArmyInDate() == null'>'1900-01-01'</when>\n"
		+"<otherwise>#{p.ArmyInDate}</otherwise>\n"
		+"</choose>\n"
		+", `ArmyOutDate` = \n"
		+"<choose>\n"
		+"<when test='p.getArmyOutDate() == \"\"'>'1900-01-01'</when>\n"
		+"<when test='p.getArmyOutDate() == null'>'1900-01-01'</when>\n"
		+"<otherwise>#{p.ArmyOutDate}</otherwise>\n"
		+"</choose>\n"
		+", `Z1` = #{p.Z1}, `Z2` = #{p.Z2},\n"
		+" `Z3` = #{p.Z3}, `Z4` = #{p.Z4}, `Z5` = #{p.Z5} ,`Z6` = #{p.Z6}, `Z7` = #{p.Z7}, `Z8` = #{p.Z8},\n"
		+"`Computer` = #{p.Computer}, `English` = #{p.English}, `PartTime` = #{p.PartTime}, `Disease` = #{p.Disease},\n"
		+" `Crime` = #{p.Crime}, `Appearance` = #{p.Appearance}, `Communication` = #{p.Communication},\n"
		+"`Source` = #{p.Source}, `InDate` = \n"
		+"<choose>\n"
		+"<when test='p.getInDate() == \"\"'>'1900-01-01'</when>\n"
		+"<when test='p.getInDate() == null'>'1900-01-01'</when>\n"
		+"<otherwise>#{p.InDate}</otherwise>\n"
		+"</choose>\n"
		+", `HTBeginDate` = \n"
		+"<choose>\n"
		+"<when test='p.getHTBeginDate() == \"\"'>'1900-01-01'</when>\n"
		+"<when test='p.getHTBeginDate() == null'>'1900-01-01'</when>\n"
		+"<otherwise>#{p.HTBeginDate}</otherwise>\n"
		+"</choose>\n"
		+",\n"
		+"`HTEndDate` = \n"
		+"<choose>\n"
		+"<when test='p.getHTEndDate() == \"\"'>'1900-01-01'</when>\n"
		+"<when test='p.getHTEndDate() == null'>'1900-01-01'</when>\n"
		+"<otherwise>#{p.HTEndDate}</otherwise>\n"
		+"</choose>\n"
		+", `Photo` = #{p.Photo}, `PhotoCount` = #{p.PhotoCount},\n"
		+"`F1` = #{p.F1}, `F2` =#{p.F2}, `F3` =#{p.F3}, `F4` = #{p.F4}, `F5` = #{p.F5}, `F6` = #{p.F6},\n"
		+" `F7` = #{p.F7}, `F8` = #{p.F8}, `F9` = #{p.F9}, `F10` = #{p.F10}, `GeneralComment` = #{p.GeneralComment},\n"
		+" `InterViewer` = #{p.InterViewer}, `GivePost` = #{p.GivePost}, `PlanSite` = #{p.PlanSite}, `PlantJob` = #{p.PlantJob},\n"
		+"`PlanInDate` = \n"
		+"<choose>\n"
		+"<when test='p.getPlanInDate() == \"\"'>'1900-01-01'</when>\n"
		+"<when test='p.getPlanInDate() == null'>'1900-01-01'</when>\n"
		+"<otherwise>#{p.PlanInDate}</otherwise>\n"
		+"</choose>\n"
		+", `CheckUser` = #{p.CheckUser}, `HRUser` = #{p.HRUser}, `JobUser` = #{p.JobUser},\n"
		+"`ModifyUser` = #{p.CreateUser}, `ModifyTime` = now()\n"
		+" WHERE `ID` =#{p.ID};</script>")
	void UpdatePersonnel(@Param("p") personnelImport p);

	@Select("select * from Personnel  where CardCode=#{CardCode}")
	personnelImport getPersonnelByCardCode(@Param("CardCode") String CardCode);

	@Select("select * from Personnel  where Code=#{Code}")
	personnelImport getPersonnelByCode(@Param("Code") String Code);

	@Insert("INSERT INTO `sitepersonnel`( `SiteId`, `PID`,  `IsMain`, `Job`,`CreateUser`, `CreateTime`,`Level`) \n"
		+"VALUES((select id from site WHERE name=#{SiteName}),(select id from personnel WHERE CardCode=#{CardCode}),1,#{Job},#{CreateUser},now(),'01');")
	void InsertSitepersonnel(@Param("CardCode") String CardCode, @Param("Job") String Job, @Param("CreateUser") String CreateUser, @Param("SiteName") String SiteName);

	@Select("select  max(id) ID  from personnel")
	Table insertPersonnelByID();

	@Update("UPDATE Sitepersonnel 	SET Job = #{Job}  WHERE PID =(select id from personnel WHERE CardCode=#{CardCode}) and  Siteid=(select id from site WHERE name=#{SiteName})")
	void UpdateSitepersonnel(@Param("Job") String Job, @Param("CardCode") String CardCode, @Param("SiteName") String SiteName);

	@Select("select * from Sitepersonnel WHERE PID =(select id from personnel WHERE CardCode=#{CardCode}) and  Siteid=(select id from site WHERE name=#{SiteName})")
	List<SitepersonnelImport> getSitepersonnelByPID(@Param("CardCode") String CardCode, @Param("SiteName") String SiteName);

	@Update("UPDATE personnel set Birthday= substring(CardCode,7,8),Gender=mod( substring(CardCode,17,1) ,2) ,Native=concat(substring(CardCode,1,2),'0000') where substring(CardCode,7,8) like '19%' or substring(CardCode,7,8) like '20%';")
	void UpdatePersonnelAll();

	@Select("<script>SELECT  p.id from  \n"
		+"personnel p\n"
		+"left join sitepersonnel sp on p.id =sp.PID\n"
		+"join site s on s.id=sp.SiteId\n"
		+"where \n"
		+"<choose>\n"
		+"<when test='Phone == \"\"'></when>\n"
		+"<otherwise>p.Phone=#{Phone} and</otherwise>\n"
		+"</choose>\n"
		+" p.`Name`=#{PName} or(s.`Name`=#{SName} and p.`Name`=#{PName}  )  LIMIT 0,1</script>")
	Table getSiteLeaderByPhone(@Param("Phone") String Phone, @Param("SName") String SName, @Param("PName") String PName);

}
