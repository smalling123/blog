package org.polariscode.SecuritySystem.mapper.ApplyFor;

import java.util.List;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import org.polariscode.SecuritySystem.model.ApplyFor.EmployeeApplication;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.polariscode.SecuritySystem.model.Table;

//用户申请流程
public interface DBEmployeeApplication {
	//查询用户申请流程表
	@Select("select * from EmployeeApplication\n"
		+"limit #{startIndex}, #{rowCount}")
	List<EmployeeApplication> getAllEmployeeApplication(@Param("startIndex") int startIndex, @Param("rowCount") int rowCount);

	//添加申请流程表
	@Insert("INSERT INTO employeeapplication \n"
		+"(Use_id, Account, `Name`, `Password`, \n"
		+"Gender, Birthday, Position, Education, \n"
		+"IsMarry, Mobile, IsParty, EnlistmentTime, \n"
		+"RetirementTime, TroopsName, Height, Weight, \n"
		+"PersonalSpecialty, CardNo, BankNo, Address, \n"
		+"Certificate, Img, SpeakLevel, EnglishLevel, \n"
		+"ComputerLevel, DriveLevel,OtherSkills, IsFamilyDisease, IsChronicDisease, \n"
		+"IsCriminalPunishment, IsAdministrativeSanction, IsMajorDiseases, IsExcessiveDrinking, \n"
		+"IsDrug, IsOccupationalDiseases, OccupationalDiseases, WorkAddress, \n"
		+"Department, EMail, CreateTime, Type, \n"
		+"IsClose, `Status`, Peoples, \n"
		+"DocumentImg, img1, img2, img3) \n"
		+"VALUES (#{emp.Use_id}, #{emp.Account}, #{emp.Name}, #{emp.Password}, \n"
		+"#{emp.Gender}, #{emp.Birthday}, #{emp.Position}, #{emp.Education}, \n"
		+"#{emp.IsMarry}, #{emp.Mobile}, #{emp.IsParty}, #{emp.EnlistmentTime}, \n"
		+"#{emp.RetirementTime}, #{emp.TroopsName},#{emp.Height}, #{emp.Weight}, \n"
		+"#{emp.PersonalSpecialty}, #{emp.CardNo}, #{emp.BankNo}, #{emp.Address}, \n"
		+"#{emp.Certificate}, #{emp.Img}, #{emp.SpeakLevel}, #{emp.EnglishLevel}, \n"
		+"#{emp.ComputerLevel}, #{emp.DriveLevel}, #{emp.OtherSkills},#{emp.IsFamilyDisease}, #{emp.IsChronicDisease}, \n"
		+"#{emp.IsCriminalPunishment}, #{emp.IsAdministrativeSanction}, #{emp.IsMajorDiseases}, #{emp.IsExcessiveDrinking}, \n"
		+"#{emp.IsDrug}, #{emp.IsOccupationalDiseases}, #{emp.OccupationalDiseases}, #{emp.WorkAddress}, \n"
		+"#{emp.Department}, #{emp.EMail}, Now(), #{emp.Type}, \n"
		+"#{emp.IsClose}, 0, #{emp.Peoples}, \n"
		+"#{emp.DocumentImg}, #{emp.img1}, #{emp.img2}, #{emp.img3})")
	void InsertEmployeeApplication(@Param("emp") EmployeeApplication emp);

	//审批修改
	@Update("update employeeapplication \n"
		+" set  Use_id=#{emp.Use_id},`Status` =#{emp.Status}, Peoples =#{emp.Peoples}\n"
		+" where Id =#{emp.Id}")
	void UpdateStatus(@Param("emp") EmployeeApplication emp);

	//根据ID查询用户申请流程
	@Select("select *,Certificate as Certificates,CardType as CardTypes   from EmployeeApplication\n"
		+"where Id=#{id}")
	EmployeeApplication getEmployeeApplicationById(@Param("id") int id);

	//修改用户申请流程
	@Update("<script>UPDATE employeeapplication \n"
		+" SET  Name = #{emp.Name}, Gender = #{emp.Gender}, Birthday = #{emp.Birthday}, \n"
		+" Position = #{emp.Position}, Education = #{emp.Education}, IsMarry = #{emp.IsMarry}, \n"
		+" Mobile = #{emp.Mobile}, IsParty = #{emp.IsParty}, EnlistmentTime = #{emp.EnlistmentTime}, \n"
		+" RetirementTime = #{emp.RetirementTime}, TroopsName = #{emp.TroopsName}, Height = #{emp.Height}, \n"
		+" Weight = #{emp.Weight}, PersonalSpecialty = #{emp.PersonalSpecialty}, CardNo = #{emp.CardNo}, \n"
		+" BankNo = #{emp.BankNo}, Address = #{emp.Address}, Certificate = #{Certificate}, \n"
		+" Img = #{emp.Img}, SpeakLevel = #{emp.SpeakLevel}, EnglishLevel = #{emp.EnglishLevel}, \n"
		+" ComputerLevel = #{emp.ComputerLevel}, DriveLevel = #{emp.DriveLevel},OtherSkills=#{emp.OtherSkills}, IsFamilyDisease = #{emp.IsFamilyDisease}, \n"
		+" IsChronicDisease = #{emp.IsChronicDisease}, IsCriminalPunishment = #{emp.IsCriminalPunishment}, IsAdministrativeSanction = #{emp.IsAdministrativeSanction}, \n"
		+" IsMajorDiseases = #{emp.IsMajorDiseases}, IsExcessiveDrinking = #{emp.IsExcessiveDrinking}, IsDrug = #{emp.IsDrug}, \n"
		+" IsOccupationalDiseases = #{emp.IsOccupationalDiseases}, OccupationalDiseases = #{emp.OccupationalDiseases}, WorkAddress = #{emp.WorkAddress}, \n"
		+" Department = #{emp.Department}, EMail = #{emp.EMail}, \n"
		+" Type = #{emp.Type}, CardType = #{CardType}, PeopleType = #{emp.PeopleType}, \n"
		+" IsClose = #{emp.IsClose}, \n"
		+" \n"
		+"<choose>\n"
		+"<when test='emp.getRegistrationDate() == \"\"'></when>\n"
		+"<otherwise>RegistrationDate = #{emp.RegistrationDate},</otherwise>\n"
		+"</choose>\n"
		+" DocumentImg = #{emp.DocumentImg}, img1 = #{emp.img1}, \n"
		+" img2 = #{emp.img2}, img3 = #{emp.img3} WHERE Id = #{emp.Id}</script>")
	void UpdateEmployeeApplication(@Param("emp") EmployeeApplication emp, @Param("Certificate") String Certificate, @Param("CardType") String CardType);

	//根据用户ID查询审核信息
	@Select("<script>select * from employeeapplication ell  \n"
		+" where ell.`Status` in(-1,0)  and\n"
		+" ell.Name LIKE &apos;%${name}%&apos; and ell.Education like &apos;%${education}%&apos; \n"
		+"<choose>\n"
		+"<when test='gender == \"\"'></when>\n"
		+"<otherwise>and ell.Gender=#{gender}</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+"limit #{startIndex}, #{rowCount}</script>")
	List<EmployeeApplication> getEmployeeByAccount(@Param("name") String name, @Param("education") String education, @Param("gender") String gender, @Param("startIndex") int startIndex, @Param("rowCount") int rowCount);

	@Select("select count(1) Count from EmployeeApplication\n"
		+"where Account= #{account}")
	Table getByAccount(@Param("account") String account);

	//根据账号获取ID
	@Select("select ID from EmployeeApplication\n"
		+"where Account= #{account}")
	Table getID(@Param("account") String account);

	//获取数据条数
	@Select("select count(1) Count from EmployeeApplication")
	Table getCount();

	//添加基础信息
	@Insert("insert into employeeapplication \n"
		+"(Name,Password,\n"
		+"Gender,Birthday,CardNo,Address,Status)\n"
		+"values (#{emp.Name},#{emp.Password},\n"
		+"#{emp.Gender},#{emp.Birthday},#{emp.CardNo},#{emp.Address},#{emp.Status})")
	void InsertEmployee(@Param("emp") EmployeeApplication emp);

	//根据身份证查询申请ID
	@Select("select Id from EmployeeApplication where CardNo = #{cardNo}")
	Table getEmpByCardNo(@Param("cardNo") String cardNo);

	//第二次填写信息
	@Update("<script>UPDATE employeeapplication \n"
		+" SET  Account=#{emp.Account},Position=#{emp.Position},Education=#{emp.Education},\n"
		+"IsMarry=#{emp.IsMarry},Mobile=#{emp.Mobile},IsParty=#{emp.IsParty},\n"
		+"\n"
		+"<choose>\n"
		+"<when test='emp.getEnlistmentTime() == \"\"'></when>\n"
		+"<otherwise>EnlistmentTime=#{emp.EnlistmentTime},</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+"<choose>\n"
		+"<when test='emp.getRetirementTime() == \"\"'></when>\n"
		+"<otherwise>RetirementTime=#{emp.RetirementTime},</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+"TroopsName=#{emp.TroopsName},Height=#{emp.Height},Img=#{emp.Img},\n"
		+"Weight=#{emp.Weight},PersonalSpecialty=#{emp.PersonalSpecialty},\n"
		+"Certificate=#{emp.Certificates}\n"
		+" WHERE Id =#{emp.Id}</script>")
	void UpdateTowEmployee(@Param("emp") EmployeeApplication emp);

	@Update("UPDATE employeeapplication \n"
		+" SET  SpeakLevel=#{emp.SpeakLevel},EnglishLevel=#{emp.EnglishLevel},\n"
		+" ComputerLevel=#{emp.ComputerLevel},DriveLevel=#{emp.DriveLevel},OtherSkills=#{emp.OtherSkills}\n"
		+"WHERE Id =#{emp.Id}")
	void UpdateLanguage(@Param("emp") EmployeeApplication emp);

	//添加其他
	@Update("UPDATE employeeapplication \n"
		+" SET  IsFamilyDisease=#{emp.IsFamilyDisease},IsChronicDisease=#{emp.IsChronicDisease},\n"
		+" IsCriminalPunishment=#{emp.IsCriminalPunishment},IsAdministrativeSanction=#{emp.IsAdministrativeSanction},\n"
		+" IsMajorDiseases=#{emp.IsMajorDiseases},IsExcessiveDrinking=#{emp.IsExcessiveDrinking},\n"
		+" IsDrug=#{emp.IsDrug},IsOccupationalDiseases=#{emp.IsOccupationalDiseases},\n"
		+" OccupationalDiseases=#{emp.OccupationalDiseases},IsClose=0,Status=#{emp.Status}\n"
		+"WHERE Id =#{emp.Id}")
	void UpdateRests(@Param("emp") EmployeeApplication emp);

	//获取未审批的申请人员
	@Select("<script>select * from employeeapplication ell  \n"
		+" where ell.`Status`=&apos;0&apos; or ell.`Status`=&apos;1&apos; and\n"
		+" ell.Name LIKE &apos;%${name}%&apos; and ell.Education like &apos;%${education}%&apos; and ell.Gender=#{gender}\n"
		+"limit #{startIndex}, #{rowCount}</script>")
	List<EmployeeApplication> getUnreviewedEmp(@Param("startIndex") int startIndex, @Param("rowCount") int rowCount, @Param("name") String name, @Param("education") String education, @Param("gender") String gender);

	//获取未审批总条数
	@Select("<script>select Count(*) Count from employeeapplication ell  \n"
		+" where ell.`Status`=&apos;0&apos; or ell.`Status`=&apos;1&apos; and\n"
		+" ell.Name LIKE &apos;%${name}%&apos; and ell.Education like &apos;%${education}%&apos; and ell.Gender=#{gender}</script>")
	Table getUnreviewedEmpCount(@Param("name") String name, @Param("education") String education, @Param("gender") String gender);

	//获取用户审批条数
	@Select("<script>select Count(*) Count from employeeapplication ell  \n"
		+" where ell.`Status`=&apos;0&apos; or ell.`Status`=&apos;1&apos; and\n"
		+" ell.Name LIKE &apos;%${name}%&apos; and ell.Education like &apos;%${education}%&apos; \n"
		+"<choose>\n"
		+"<when test='gender == \"\"'></when>\n"
		+"<otherwise>and ell.Gender=#{gender}</otherwise>\n"
		+"</choose>\n"
		+"</script>")
	Table getEmployeeCount(@Param("name") String name, @Param("education") String education, @Param("gender") String gender);

	//修改基础信息
	@Update("UPDATE employeeapplication \n"
		+"SET Name =#{emp.Name}, Password =#{emp.Password}, Gender =#{emp.Gender}, \n"
		+"Birthday =#{emp.Birthday}, CardNo =#{emp.CardNo}, Address =#{emp.Address}, \n"
		+"Status =#{emp.Status} \n"
		+"WHERE ID =#{id}")
	void UpdateEmployee(@Param("emp") EmployeeApplication emp, @Param("id") int id);

	//查询当前身份证的条数
	@Select("select Count(*) Count from EmployeeApplication where CardNo = #{cardNo}")
	Table getCountByCardNo(@Param("cardNo") String cardNo);

	@Update("update employeeapplication set Status= 1 where id=#{id}")
	void UpdateEmployeeByStatus(@Param("id") int id);

	//查询审核通过的员工信息
	@Select("<script>select * from employeeapplication ell  \n"
		+" where ell.`Status`=&apos;1&apos;  and\n"
		+" ell.Name LIKE &apos;%${name}%&apos; and ell.Education like &apos;%${education}%&apos; \n"
		+"<choose>\n"
		+"<when test='gender == \"\"'></when>\n"
		+"<otherwise>and ell.Gender=#{gender}</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+"limit #{startIndex}, #{rowCount}</script>")
	List<EmployeeApplication> getEmployeeT(@Param("name") String name, @Param("education") String education, @Param("gender") String gender, @Param("startIndex") int startIndex, @Param("rowCount") int rowCount);

	//查询审核通过的员工信息
	@Select("<script>select Count(*) Count from employeeapplication ell  \n"
		+" where ell.`Status`=&apos;1&apos;  and\n"
		+" ell.Name LIKE &apos;%${name}%&apos; and ell.Education like &apos;%${education}%&apos; \n"
		+"<choose>\n"
		+"<when test='gender == \"\"'></when>\n"
		+"<otherwise>and ell.Gender=#{gender}</otherwise>\n"
		+"</choose>\n"
		+"</script>")
	Table getEmployeeTByCount(@Param("name") String name, @Param("education") String education, @Param("gender") String gender);

}
