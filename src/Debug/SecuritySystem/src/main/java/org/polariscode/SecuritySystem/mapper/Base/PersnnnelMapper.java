package org.polariscode.SecuritySystem.mapper.Base;

import java.util.List;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import org.polariscode.SecuritySystem.model.Base.PersonnelEx;
import org.polariscode.SecuritySystem.model.Base.Personnel;
import org.polariscode.SecuritySystem.model.Table;
import org.polariscode.SecuritySystem.model.Base.PersonnelJob;
import org.polariscode.SecuritySystem.model.Base.PersonnelMembers;
import org.polariscode.SecuritySystem.model.Base.PersonnelPhoto;
import org.polariscode.SecuritySystem.model.Base.PersonnelCert;
import org.polariscode.SecuritySystem.model.Base.PersonnelContract;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;

public interface PersnnnelMapper {
	//获取所有员工信息
	@Select("<script>Select P.ID, P.FileNumber, Site.Name As SiteName, P.Name, P.Gender, P.CardCode, P.CardDate, P.Native, P.Phone, SP.Job, SP.Level, P.InDate, P.HTBeginDate,  P.HTEndDate, P.OutDate, P.PoliticalTrial, P.Status, P.Reference, P.PhotoCount, P.CreateUser, P.CreateTime\n"
		+"From Personnel P Left Join SitePersonnel SP On P.ID = SP.PID And SP.IsMain = 1\n"
		+"				Left Join Site On SP.SIteID = Site.ID \n"
		+"Where P.Name like &apos;%${name}%&apos;  \n"
		+"	\n"
		+"<choose>\n"
		+"<when test='gender == \"\"'></when>\n"
		+"<otherwise>And Gender = #{gender}</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+"	And CardCode like &apos;%${cardcode}%&apos;\n"
		+"	\n"
		+"<choose>\n"
		+"<when test='native1 == \"\"'></when>\n"
		+"<otherwise>And Native = #{native1}</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+"	\n"
		+"<choose>\n"
		+"<when test='age1 == 0'></when>\n"
		+"<otherwise>And Birthday &gt;= DATE_SUB(CURDATE(),INTERVAL #{age1} Year)</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+"	\n"
		+"<choose>\n"
		+"<when test='age2 == 0'></when>\n"
		+"<otherwise>And Birthday &lt; DATE_SUB(CURDATE(),INTERVAL #{age2}+1 Year)</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+"	\n"
		+"<choose>\n"
		+"<when test='weight == 0'></when>\n"
		+"<otherwise>And Weight &gt;= #{weight}</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+"	\n"
		+"<choose>\n"
		+"<when test='height == 0'></when>\n"
		+"<otherwise>And Height &gt;= #{height}</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+"	\n"
		+"<choose>\n"
		+"<when test='status == \"\"'></when>\n"
		+"<otherwise>And P.Status = #{status}</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+"	\n"
		+"<choose>\n"
		+"<when test='education == \"\"'></when>\n"
		+"<otherwise>And Education = #{education}</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+"	\n"
		+"<choose>\n"
		+"<when test='indate1 == \"\"'></when>\n"
		+"<otherwise>And P.InDate &gt;= #{indate1}</otherwise>\n"
		+"</choose>\n"
		+" \n"
		+"<choose>\n"
		+"<when test='indate2 == \"\"'></when>\n"
		+"<otherwise>And P.InDate &lt;= #{indate2}</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+"	\n"
		+"<choose>\n"
		+"<when test='outdate1 == \"\"'></when>\n"
		+"<otherwise>And P.OutDate &gt;= #{outdate1}</otherwise>\n"
		+"</choose>\n"
		+" \n"
		+"<choose>\n"
		+"<when test='outdate2 == \"\"'></when>\n"
		+"<otherwise>And P.OUtDate &lt;= #{outdate2}</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+"	\n"
		+"<choose>\n"
		+"<when test='bankcard == \"\"'></when>\n"
		+"<when test='bankcard == \"2\"'>And LENGTH(BankCard)=0</when>\n"
		+"<otherwise>And LENGTH(BankCard)&gt;0</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+"	\n"
		+"<choose>\n"
		+"<when test='siteid == \"\"'></when>\n"
		+"<otherwise>And SP.SiteID = #{siteid}</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+"	\n"
		+"<choose>\n"
		+"<when test='politicaltrial == \"\"'></when>\n"
		+"<otherwise>And PoliticalTrial = #{politicaltrial}</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+"	\n"
		+"<choose>\n"
		+"<when test='f1 == \"\"'></when>\n"
		+"<otherwise>And F1 = #{f1}</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+"	\n"
		+"<choose>\n"
		+"<when test='photo == \"\"'></when>\n"
		+"<otherwise>And Photo = #{photo}</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+"limit #{startIndex}, #{rowCount}</script>")
	List<PersonnelEx> getAllPersonnels(@Param("name") String name, @Param("gender") String gender, @Param("cardcode") String cardcode, @Param("native1") String native1, @Param("age1") int age1, @Param("age2") int age2, @Param("weight") int weight, @Param("height") int height, @Param("status") String status, @Param("education") String education, @Param("indate1") String indate1, @Param("indate2") String indate2, @Param("outdate1") String outdate1, @Param("outdate2") String outdate2, @Param("bankcard") String bankcard, @Param("siteid") String siteid, @Param("politicaltrial") String politicaltrial, @Param("f1") String f1, @Param("photo") String photo, @Param("startIndex") int startIndex, @Param("rowCount") int rowCount);

	//获取指定员工信息
	@Select("Select * From Personnel Where ID = #{id}")
	Personnel getPersonnelOne(@Param("id") int id);

	//获取员工合计数
	@Select("<script>Select Count(1) As Count \n"
		+"From Personnel P Left Join SitePersonnel SP On P.ID = SP.PID And SP.IsMain = 1\n"
		+"Where Name like &apos;%${name}%&apos;  \n"
		+"	\n"
		+"<choose>\n"
		+"<when test='gender == \"\"'></when>\n"
		+"<otherwise>And Gender = #{gender}</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+"	And CardCode like &apos;%${cardcode}%&apos;\n"
		+"	\n"
		+"<choose>\n"
		+"<when test='native1 == \"\"'></when>\n"
		+"<otherwise>And Native = #{native1}</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+"	\n"
		+"<choose>\n"
		+"<when test='age1 == 0'></when>\n"
		+"<otherwise>And Birthday &gt;= DATE_SUB(CURDATE(),INTERVAL #{age1} Year)</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+"	\n"
		+"<choose>\n"
		+"<when test='age2 == 0'></when>\n"
		+"<otherwise>And Birthday &lt; DATE_SUB(CURDATE(),INTERVAL #{age2}+1 Year)</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+"	\n"
		+"<choose>\n"
		+"<when test='weight == 0'></when>\n"
		+"<otherwise>And Weight &gt;= #{weight}</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+"	\n"
		+"<choose>\n"
		+"<when test='height == 0'></when>\n"
		+"<otherwise>And Height &gt;= #{height}</otherwise>\n"
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
		+"<when test='education == \"\"'></when>\n"
		+"<otherwise>And Education = #{education}</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+"	\n"
		+"<choose>\n"
		+"<when test='indate1 == \"\"'></when>\n"
		+"<otherwise>And InDate &gt;= #{indate1}</otherwise>\n"
		+"</choose>\n"
		+" \n"
		+"<choose>\n"
		+"<when test='indate2 == \"\"'></when>\n"
		+"<otherwise>And InDate &lt;= #{indate2}</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+"	\n"
		+"<choose>\n"
		+"<when test='outdate1 == \"\"'></when>\n"
		+"<otherwise>And OutDate &gt;= #{outdate1}</otherwise>\n"
		+"</choose>\n"
		+" \n"
		+"<choose>\n"
		+"<when test='outdate2 == \"\"'></when>\n"
		+"<otherwise>And OUtDate &lt;= #{outdate2}</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+"	\n"
		+"<choose>\n"
		+"<when test='bankcard == \"\"'></when>\n"
		+"<when test='bankcard == \"2\"'>And LENGTH(BankCard)=0</when>\n"
		+"<otherwise>And LENGTH(BankCard)&gt;0</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+"	\n"
		+"<choose>\n"
		+"<when test='siteid == \"\"'></when>\n"
		+"<otherwise>And SP.SiteID = #{siteid}</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+"	\n"
		+"<choose>\n"
		+"<when test='politicaltrial == \"\"'></when>\n"
		+"<otherwise>And PoliticalTrial = #{politicaltrial}</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+"	\n"
		+"<choose>\n"
		+"<when test='f1 == \"\"'></when>\n"
		+"<otherwise>And F1 = #{f1}</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+"	\n"
		+"<choose>\n"
		+"<when test='photo == \"\"'></when>\n"
		+"<otherwise>And Photo = #{photo}</otherwise>\n"
		+"</choose>\n"
		+"</script>")
	Table getPersonnelCount(@Param("name") String name, @Param("gender") String gender, @Param("cardcode") String cardcode, @Param("native1") String native1, @Param("age1") int age1, @Param("age2") int age2, @Param("weight") int weight, @Param("height") int height, @Param("status") String status, @Param("education") String education, @Param("indate1") String indate1, @Param("indate2") String indate2, @Param("outdate1") String outdate1, @Param("outdate2") String outdate2, @Param("bankcard") String bankcard, @Param("siteid") String siteid, @Param("politicaltrial") String politicaltrial, @Param("f1") String f1, @Param("photo") String photo);

	@Select("Select * From PersonnelJob Where PersonnelId = #{id}")
	List<PersonnelJob> getPersonnelJob(@Param("id") int id);

	@Select("Select * From PersonnelMembers Where PersonnelId = #{id}")
	List<PersonnelMembers> getPersonnelMembers(@Param("id") int id);

	@Select("Select * From PersonnelPhoto Where PersonnelId = #{id}")
	List<PersonnelPhoto> getPersonnelPhoto(@Param("id") int id);

	@Select("Select * From PersonnelCert Where PersonnelId = #{id}")
	List<PersonnelCert> getPersonnelCert(@Param("id") int id);

	@Select("Select * From PersonnelContract Where PersonnelId = #{id}")
	List<PersonnelContract> getPersonnelContract(@Param("id") int id);

	@Insert("Insert Into Personnel(Code, Name, CardCode, CardDate, Birthday, Gender, Politics, Height, Weight, Education, Nation, Native, Phone, HomeAddress, Census, CensusAddress, Marital, LinkMan, LinkManRelation, LinkManPhone, Army, ArmyInDate, ArmyOutDate, Z1, Z2, Z3, Z4, Z5, Z6, Z7, Z8, Computer, English, PartTime, Disease, Crime, Appearance, Communication, Source, Reference, InDate, HTBeginDate, HTEndDate, Photo, PhotoCount, F1, F2, F3, F4, F5, F6, F7, F8, F9, F10, GeneralComment, InterViewer, GivePost, PlanSite, PlantJob, PlanInDate, CheckUser, HRUser, JobUser, CreateUser, CreateTime, ModifyUser, ModifyTime, DeleteUser, DeleteTime, CompanyId, Status, OutDate, BankCard, PoliticalTrial, FileNumber)\n"
		+" Values(#{personnel.Code}, #{personnel.Name}, #{personnel.CardCode}, #{personnel.CardDate}, #{personnel.Birthday}, #{personnel.Gender}, #{personnel.Politics}, #{personnel.Height}, #{personnel.Weight}, #{personnel.Education}, #{personnel.Nation}, #{personnel.Native}, #{personnel.Phone}, #{personnel.HomeAddress}, #{personnel.Census}, #{personnel.CensusAddress}, #{personnel.Marital}, #{personnel.LinkMan}, #{personnel.LinkManRelation}, #{personnel.LinkManPhone}, #{personnel.Army}, #{personnel.ArmyInDate}, #{personnel.ArmyOutDate}, #{personnel.Z1}, #{personnel.Z2}, #{personnel.Z3}, #{personnel.Z4}, #{personnel.Z5}, #{personnel.Z6}, #{personnel.Z7}, #{personnel.Z8}, #{personnel.Computer}, #{personnel.English}, #{personnel.PartTime}, #{personnel.Disease}, #{personnel.Crime}, #{personnel.Appearance}, #{personnel.Communication}, #{personnel.Source}, #{personnel.Reference}, #{personnel.InDate}, #{personnel.HTBeginDate}, #{personnel.HTEndDate}, #{personnel.Photo}, #{personnel.PhotoCount}, #{personnel.F1}, #{personnel.F2}, #{personnel.F3}, #{personnel.F4}, #{personnel.F5}, #{personnel.F6}, #{personnel.F7}, #{personnel.F8}, #{personnel.F9}, #{personnel.F10}, #{personnel.GeneralComment}, #{personnel.InterViewer}, #{personnel.GivePost}, #{personnel.PlanSite}, #{personnel.PlantJob}, #{personnel.PlanInDate}, #{personnel.CheckUser}, #{personnel.HRUser}, #{personnel.JobUser}, #{personnel.CreateUser}, #{personnel.CreateTime}, #{personnel.ModifyUser}, #{personnel.ModifyTime}, #{personnel.DeleteUser}, #{personnel.DeleteTime}, #{personnel.CompanyId}, #{personnel.Status}, #{personnel.OutDate}, #{personnel.BankCard}, #{personnel.PoliticalTrial}, #{personnel.FileNumber})")
	void insertPersonnel(@Param("personnel") Personnel personnel);

	@Update("Update Personnel Set\n"
		+"	Code = #{personnel.Code},\n"
		+"	Name = #{personnel.Name},\n"
		+"	CardCode = #{personnel.CardCode},\n"
		+"	CardDate = #{personnel.CardDate},\n"
		+"	Birthday = #{personnel.Birthday},\n"
		+"	Gender = #{personnel.Gender},\n"
		+"	Politics = #{personnel.Politics},\n"
		+"	Height = #{personnel.Height},\n"
		+"	Weight = #{personnel.Weight},\n"
		+"	Education = #{personnel.Education},\n"
		+"	Nation = #{personnel.Nation},\n"
		+"	Native = #{personnel.Native},\n"
		+"	Phone = #{personnel.Phone},\n"
		+"	HomeAddress = #{personnel.HomeAddress},\n"
		+"	Census = #{personnel.Census},\n"
		+"	CensusAddress = #{personnel.CensusAddress},\n"
		+"	Marital = #{personnel.Marital},\n"
		+"	LinkMan = #{personnel.LinkMan},\n"
		+"	LinkManRelation = #{personnel.LinkManRelation},\n"
		+"	LinkManPhone = #{personnel.LinkManPhone},\n"
		+"	Army = #{personnel.Army},\n"
		+"	ArmyInDate = #{personnel.ArmyInDate},\n"
		+"	ArmyOutDate = #{personnel.ArmyOutDate},\n"
		+"	Z1 = #{personnel.Z1},\n"
		+"	Z2 = #{personnel.Z2},\n"
		+"	Z3 = #{personnel.Z3},\n"
		+"	Z4 = #{personnel.Z4},\n"
		+"	Z5 = #{personnel.Z5},\n"
		+"	Z6 = #{personnel.Z6},\n"
		+"	Z7 = #{personnel.Z7},\n"
		+"	Z8 = #{personnel.Z8},\n"
		+"	Computer = #{personnel.Computer},\n"
		+"	English = #{personnel.English},\n"
		+"	PartTime = #{personnel.PartTime},\n"
		+"	Disease = #{personnel.Disease},\n"
		+"	Crime = #{personnel.Crime},\n"
		+"	Appearance = #{personnel.Appearance},\n"
		+"	Communication = #{personnel.Communication},\n"
		+"	Source = #{personnel.Source},\n"
		+"	Reference = #{personnel.Reference},\n"
		+"	InDate = #{personnel.InDate},\n"
		+"	HTBeginDate = #{personnel.HTBeginDate},\n"
		+"	HTEndDate = #{personnel.HTEndDate},\n"
		+"	Photo = #{personnel.Photo},\n"
		+"	PhotoCount = #{personnel.PhotoCount},\n"
		+"	F1 = #{personnel.F1},\n"
		+"	F2 = #{personnel.F2},\n"
		+"	F3 = #{personnel.F3},\n"
		+"	F4 = #{personnel.F4},\n"
		+"	F5 = #{personnel.F5},\n"
		+"	F6 = #{personnel.F6},\n"
		+"	F7 = #{personnel.F7},\n"
		+"	F8 = #{personnel.F8},\n"
		+"	F9 = #{personnel.F9},\n"
		+"	F10 = #{personnel.F10},\n"
		+"	GeneralComment = #{personnel.GeneralComment},\n"
		+"	InterViewer = #{personnel.InterViewer},\n"
		+"	GivePost = #{personnel.GivePost},\n"
		+"	PlanSite = #{personnel.PlanSite},\n"
		+"	PlantJob = #{personnel.PlantJob},\n"
		+"	PlanInDate = #{personnel.PlanInDate},\n"
		+"	CheckUser = #{personnel.CheckUser},\n"
		+"	HRUser = #{personnel.HRUser},\n"
		+"	JobUser = #{personnel.JobUser},\n"
		+"	CreateUser = #{personnel.CreateUser},\n"
		+"	CreateTime = #{personnel.CreateTime},\n"
		+"	ModifyUser = #{personnel.ModifyUser},\n"
		+"	ModifyTime = #{personnel.ModifyTime},\n"
		+"	DeleteUser = #{personnel.DeleteUser},\n"
		+"	DeleteTime = #{personnel.DeleteTime},\n"
		+"	CompanyId = #{personnel.CompanyId},\n"
		+"	Status = #{personnel.Status},\n"
		+"	OutDate = #{personnel.OutDate},\n"
		+"	BankCard = #{personnel.BankCard},\n"
		+"	PoliticalTrial = #{personnel.PoliticalTrial},\n"
		+"	FileNumber = #{personnel.FileNumber}\n"
		+" Where ID = #{personnel.ID}")
	void updatePersonnel(@Param("personnel") Personnel personnel);

	@Insert("<script>Insert Into PersonnelJob(PersonnelID, Company, Job, InDate, OutDate, LinkMan, LinkManPhone) Values\n"
		+"<foreach collection='personneljob' item='c' index='index' separator=','>\n"
		+"(#{id}, #{c.Company}, #{c.Job}, #{c.InDate}, #{c.OutDate}, #{c.LinkMan}, #{c.LinkManPhone})\n"
		+"</foreach>\n"
		+"</script>")
	void insertPersonnelJob(@Param("personneljob") List<PersonnelJob> personneljob, @Param("id") int id);

	@Insert("<script>Insert Into PersonnelMembers(PersonnelID, Name, Relation, Phone, Age, Company) Values\n"
		+"<foreach collection='personnelmembers' item='c' index='index' separator=','>\n"
		+"(#{id}, #{c.Name}, #{c.Relation}, #{c.Phone}, #{c.Age}, #{c.Company})\n"
		+"</foreach>\n"
		+"</script>")
	void insertPersonnelMembers(@Param("personnelmembers") List<PersonnelMembers> personnelmembers, @Param("id") int id);

	@Insert("<script>Insert Into PersonnelPhoto(PersonnelID, PhotoName, PhotoUrl) Values\n"
		+"<foreach collection='personnelphoto' item='c' index='index' separator=','>\n"
		+"(#{id}, #{c.PhotoName}, #{c.PhotoUrl})\n"
		+"</foreach>\n"
		+"</script>")
	void insertPersonnelPhoto(@Param("personnelphoto") List<PersonnelPhoto> personnelphoto, @Param("id") int id);

	@Insert("<script>Insert Into PersonnelCert(PersonnelID, CertType, CertUrl, Level, CreateUser, CreateTime) Values\n"
		+"<foreach collection='personnelcert' item='c' index='index' separator=','>\n"
		+"(#{id}, #{c.CertType}, #{c.CertUrl}, #{c.Level}, #{c.CreateUser}, Now())\n"
		+"</foreach>\n"
		+"</script>")
	void insertPersonnelCert(@Param("personnelcert") List<PersonnelCert> personnelcert, @Param("id") int id);

	@Insert("<script>Insert Into PersonnelContract(PersonnelID, Type, BeginDate, EndDate, CompanyId) Values\n"
		+"<foreach collection='personnelcontract' item='c' index='index' separator=','>\n"
		+"(#{id}, #{c.Type}, #{c.BeginDate}, #{c.EndDate}, #{c.CompanyId})\n"
		+"</foreach>\n"
		+"</script>")
	void insertPersonnelContract(@Param("personnelcontract") List<PersonnelContract> personnelcontract, @Param("id") int id);

	@Delete("Delete From PersonnelJob Where PersonnelId = #{id}")
	void DeletePersonnelJob(@Param("id") int id);

	@Delete("Delete From PersonnelMembers Where PersonnelId = #{id}")
	void DeletePersonnelMembers(@Param("id") int id);

	@Delete("Delete From PersonnelPhoto Where PersonnelId = #{id}")
	void DeletePersonnelPhoto(@Param("id") int id);

	@Delete("Delete From PersonnelCert Where PersonnelId = #{id}")
	void DeletePersonnelCert(@Param("id") int id);

	@Delete("Delete From PersonnelContract Where PersonnelId = #{id}")
	void DeletePersonnelContract(@Param("id") int id);

}
