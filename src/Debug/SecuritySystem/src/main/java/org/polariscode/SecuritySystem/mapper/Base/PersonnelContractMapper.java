package org.polariscode.SecuritySystem.mapper.Base;

import java.util.List;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import org.polariscode.SecuritySystem.model.Base.PersonnelContractView;
import org.polariscode.SecuritySystem.model.Table;
import org.apache.ibatis.annotations.Insert;
import org.polariscode.SecuritySystem.model.Base.PersonnelContract;
import org.apache.ibatis.annotations.Update;

public interface PersonnelContractMapper {
	@Select("<script>select s.name Sname,p.name Pname,p.InDate,pc.* from personnel p\n"
		+"LEFT join personnelcontract pc on p.id=pc.PersonnelID\n"
		+"LEFT join sitepersonnel sp on p.id=sp.PID\n"
		+"LEFT join site s on s.id =sp.SiteId\n"
		+"where 1=1 and (pc.id&gt;0 or pc.EndDate&gt;now() ) \n"
		+"\n"
		+"<choose>\n"
		+"<when test='month == \"\"'></when>\n"
		+"<when test='month == \"2\"'>and  pc.EndDate&lt;=date(date_add(now(), interval ${month} MONTH)) and pc.EndDate&gt;date(date_add(now(), interval 1 MONTH))</when>\n"
		+"<otherwise>and  pc.EndDate&lt;=date(date_add(now(), interval ${month} MONTH)) and pc.EndDate&gt;date(now())</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+"limit #{startIndex}, #{rowCount}</script>")
	List<PersonnelContractView> getAllPersonnelContract(@Param("month") String month, @Param("End") String End, @Param("startIndex") int startIndex, @Param("rowCount") int rowCount);

	@Select("<script>select count(*) Count from personnel p\n"
		+"LEFT join personnelcontract pc on p.id=pc.PersonnelID\n"
		+"LEFT join sitepersonnel sp on p.id=sp.PID\n"
		+"LEFT join site s on s.id =sp.SiteId\n"
		+"where 1=1 and (pc.id&gt;0 or pc.EndDate&gt;now() )\n"
		+"\n"
		+"<choose>\n"
		+"<when test='month == \"\"'></when>\n"
		+"<when test='month == \"2\"'>and  pc.EndDate&lt;=date(date_add(now(), interval ${month} MONTH)) and pc.EndDate&gt;date(date_add(now(), interval 1 MONTH))</when>\n"
		+"<otherwise>and  pc.EndDate&lt;=date(date_add(now(), interval ${month} MONTH)) and pc.EndDate&gt;date(now())</otherwise>\n"
		+"</choose>\n"
		+"</script>")
	Table getAllPersonnelContractCount(@Param("month") String month, @Param("End") String End);

	@Insert("INSERT INTO `personnelcontract`( `PersonnelID`, `Type`, `BeginDate`, `EndDate`, `CompanyId`) \n"
		+"VALUES (#{pc.PersonnelID}, #{pc.Type}, #{pc.BeginDate}, #{pc.EndDate}, #{pc.CompanyId});")
	void InsertPersonnelContract(@Param("pc") PersonnelContract pc);

	@Update("UPDATE `personnelcontract` SET \n"
		+"`PersonnelID` = #{pc.PersonnelID},\n"
		+" `Type` = #{pc.Type}, \n"
		+"`BeginDate` = #{pc.BeginDate}, \n"
		+"`EndDate` = #{pc.EndDate}, \n"
		+"`CompanyId` = #{pc.CompanyId}\n"
		+" WHERE `ID` = #{pc.ID};")
	void UpdatePersonnelContract(@Param("pc") PersonnelContract pc);

	@Select("select * from PersonnelContract where id=#{id}")
	PersonnelContract getPersonnelContractById(@Param("id") int id);

}
