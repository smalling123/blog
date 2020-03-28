package org.polariscode.SecuritySystem.mapper.Office;

import java.util.List;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import org.polariscode.SecuritySystem.model.Office.Staff;
import org.polariscode.SecuritySystem.model.Office.StaffE;
import org.polariscode.SecuritySystem.model.Table;
import org.polariscode.SecuritySystem.model.Office.StaffMembers;
import org.polariscode.SecuritySystem.model.Office.StaffWork;
import org.polariscode.SecuritySystem.model.Office.StaffEdu;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;

public interface StaffMapper {
	@Select("Select Staff.*, ifnull(Org.ID, 0) As OrgID, ifnull(Org.Name, '') As OrgName\n"
		+"From Staff  Left Join UserRole on Staff.UserID = UserRole.UserID And UserRole.isMain = 1\n"
		+"		Left Join OrgRole On OrgRole.ID = UserRole.OrgRoleID\n"
		+"		Left Join Org On Org.ID = OrgRole.OrgID\n"
		+"Where Staff.ID = #{id}")
	Staff getStaffByID(@Param("id") int id);

	@Select("<script>Select Staff.ID, Staff.Name, Staff.CardCode, Staff.Gender, Staff.Birthday, Staff.Status, Staff.RegisterDate, ifnull(Org.ID, 0) As OrgID, ifnull(Org.Name, &apos;&apos;) As OrgName, Staff.Photo\n"
		+"From Staff  Left Join UserRole on Staff.UserID = UserRole.UserID And UserRole.isMain = 1\n"
		+"		Left Join OrgRole On OrgRole.ID = UserRole.OrgRoleID\n"
		+"		Left Join Org On Org.ID = OrgRole.OrgID\n"
		+"Where \n"
		+"<choose>\n"
		+"<when test='name == \"\"'>1=1</when>\n"
		+"<otherwise>Staff.name like &apos;%${name}%&apos;</otherwise>\n"
		+"</choose>\n"
		+" \n"
		+"	\n"
		+"<choose>\n"
		+"<when test='orgname == \"\"'></when>\n"
		+"<otherwise>and Org.Name like &apos;%${orgname}%&apos;</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+"	\n"
		+"<choose>\n"
		+"<when test='status == \"\"'></when>\n"
		+"<otherwise>and Staff.Status = #{status}</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+"Order By convert(Staff.Name using gbk) collate gbk_chinese_ci\n"
		+"limit #{startIndex} ,  #{rowCount}</script>")
	List<StaffE> getAllStaff(@Param("name") String name, @Param("orgname") String orgname, @Param("status") String status, @Param("startIndex") int startIndex, @Param("rowCount") int rowCount);

	@Select("<script>Select Count(1) As Count\n"
		+"From Staff  Left Join UserRole on Staff.UserID = UserRole.UserID And UserRole.isMain = 1\n"
		+"		Left Join OrgRole On OrgRole.ID = UserRole.OrgRoleID\n"
		+"		Left Join Org On Org.ID = OrgRole.OrgID\n"
		+"Where \n"
		+"<choose>\n"
		+"<when test='name == \"\"'>1=1</when>\n"
		+"<otherwise>Staff.name like &apos;%${name}%&apos;</otherwise>\n"
		+"</choose>\n"
		+" \n"
		+"	\n"
		+"<choose>\n"
		+"<when test='orgname == \"\"'></when>\n"
		+"<otherwise>and Org.Name like &apos;%${orgname}%&apos;</otherwise>\n"
		+"</choose>\n"
		+"\n"
		+"	\n"
		+"<choose>\n"
		+"<when test='status == \"\"'></when>\n"
		+"<otherwise>and Staff.Status = #{status}</otherwise>\n"
		+"</choose>\n"
		+"</script>")
	Table getStaffCount(@Param("name") String name, @Param("orgname") String orgname, @Param("status") String status);

	@Select("Select * From StaffMembers Where StaffID = #{id}")
	List<StaffMembers> getStaffMembers(@Param("id") int id);

	@Select("Select * From StaffWork Where StaffID = #{id}")
	List<StaffWork> getStaffWork(@Param("id") int id);

	@Select("Select * from StaffEdu Where StaffID = #{id}")
	List<StaffEdu> getStaffEdu(@Param("id") int id);

	@Insert("Insert Into Staff(Name, CardCode, Gender, Birthday, Nation, Marital, Native, Height, Health, Politics, Phone, Mobile, Email, HAddress, RAddress, HType, PostCode, LinkMan, LinkRelation, LinkPhone, Cert1, Cert2, Cert3, WY1, WY1Level, WY2, WY2Level, JSJLevel, ExcelLevel, WordLevel, PowerPointLevel,RegisterDate, RegisterUser, Status, UserID, Photo)\n"
		+"Values(#{staff.Name}, #{staff.CardCode}, #{staff.Gender}, #{staff.Birthday}, #{staff.Nation}, #{staff.Marital}, #{staff.Native}, #{staff.Height}, #{staff.Health}, #{staff.Politics}, #{staff.Phone}, #{staff.Mobile}, #{staff.Email}, #{staff.HAddress}, #{staff.RAddress}, #{staff.HType}, #{staff.PostCode}, #{staff.LinkMan}, #{staff.LinkRelation}, #{staff.LinkPhone}, #{staff.Cert1}, #{staff.Cert2}, #{staff.Cert3}, #{staff.WY1}, #{staff.WY1Level}, #{staff.WY2}, #{staff.WY2Level}, #{staff.JSJLevel}, #{staff.ExcelLevel}, #{staff.WordLevel}, #{staff.PowerPointLevel}, #{staff.RegisterDate}, #{staff.RegisterUser}, #{staff.Status}, #{staff.UserID}, #{staff.Photo})")
	void InsertStaff(@Param("staff") Staff staff);

	@Update("Update Staff set Name=#{staff.Name}, \n"
		+"CardCode=#{staff.CardCode}, \n"
		+"Gender=#{staff.Gender}, \n"
		+"Birthday=#{staff.Birthday}, \n"
		+"Nation=#{staff.Nation},\n"
		+"Marital=#{staff.Marital}, \n"
		+"Native=#{staff.Native},\n"
		+"Height=#{staff.Height}, \n"
		+"Health=#{staff.Health}, \n"
		+"Politics=#{staff.Politics}, \n"
		+"Phone=#{staff.Phone}, \n"
		+"Mobile=#{staff.Mobile}, \n"
		+"Email=#{staff.Email}, \n"
		+"HAddress=#{staff.HAddress}, \n"
		+"RAddress=#{staff.RAddress}, \n"
		+"HType=#{staff.HType}, \n"
		+"PostCode=#{staff.PostCode}, \n"
		+"LinkMan=#{staff.LinkMan}, \n"
		+"LinkRelation=#{staff.LinkRelation}, \n"
		+"LinkPhone=#{staff.LinkPhone}, \n"
		+"Cert1=#{staff.Cert1}, \n"
		+"Cert2=#{staff.Cert2}, \n"
		+"Cert3=#{staff.Cert3}, \n"
		+"WY1=#{staff.WY1}, \n"
		+"WY1Level=#{staff.WY1Level}, \n"
		+"WY2=#{staff.WY2}, \n"
		+"WY2Level=#{staff.WY2Level},\n"
		+"JSJLevel= #{staff.JSJLevel}, \n"
		+"ExcelLevel=#{staff.ExcelLevel}, \n"
		+"WordLevel=#{staff.WordLevel}, \n"
		+"PowerPointLevel=#{staff.PowerPointLevel}, \n"
		+"RegisterDate=#{staff.RegisterDate}, \n"
		+"RegisterUser=#{staff.RegisterUser}, \n"
		+"Status=#{staff.Status}, \n"
		+"UserID=#{staff.UserID},\n"
		+"Photo=#{staff.Photo}\n"
		+"Where ID = #{staff.ID}")
	void UpdateStaff(@Param("staff") Staff staff);

	@Delete("Delete From StaffMembers Where StaffID = #{id}")
	void DeleteStaffmembers(@Param("id") int id);

	@Insert("<script>Insert Into StaffMembers(StaffID, Name, Appellation, Age, Company, Post, Phone) Values\n"
		+"<foreach collection='staffmembers' item='c' index='index' separator=','>\n"
		+"(#{staffid}, #{c.Name}, #{c.Appellation}, #{c.Age}, #{c.Company}, #{c.Post}, #{c.Phone})\n"
		+"</foreach>\n"
		+"</script>")
	void insertStaffMembers(@Param("staffmembers") List<StaffMembers> staffmembers, @Param("staffid") int staffid);

	@Insert("<script>Insert Into StaffWork(StaffID, Date, Company, Post, Salary, Phone, Leaving) Values\n"
		+"<foreach collection='staffwork' item='c' index='index' separator=','>\n"
		+"(#{staffid}, #{c.Date}, #{c.Company}, #{c.Post}, #{c.Salary}, #{c.Phone}, #{c.Leaving})\n"
		+"</foreach>\n"
		+"</script>")
	void insertStaffWork(@Param("staffwork") List<StaffWork> staffwork, @Param("staffid") int staffid);

	@Insert("<script>Insert Into StaffEdu(StaffID, Date, School, Major, Degree, Study, Cert) Values\n"
		+"<foreach collection='staffedu' item='c' index='index' separator=','>\n"
		+"(#{staffid}, #{c.Date}, #{c.School}, #{c.Major}, #{c.Degree}, #{c.Study}, #{c.Cert})\n"
		+"</foreach>\n"
		+"</script>")
	void insertStaffEdu(@Param("staffedu") List<StaffEdu> staffedu, @Param("staffid") int staffid);

	@Delete("Delete From StaffWork Where StaffID = #{id}")
	void DeleteStaffWork(@Param("id") int id);

	@Delete("Delete From StaffEdu Where StaffID = #{id}")
	void DeleteStaffEdu(@Param("id") int id);

}
