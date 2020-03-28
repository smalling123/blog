package org.polariscode.SecuritySystem.model.ApplyFor;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;
import java.util.List;
import java.util.ArrayList;
import org.polariscode.SecuritySystem.model.ApplyFor.Family;
import org.polariscode.SecuritySystem.model.ApplyFor.EducationalTraining;
import org.polariscode.SecuritySystem.model.ApplyFor.WorkExperience;
import org.polariscode.SecuritySystem.model.ApplyFor.UserImg;

//用户申请流程表
@Component
public class EmployeeApplication implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static EmployeeApplication m_EmployeeApplication;

	@PostConstruct 
	public void init(){
		m_EmployeeApplication=this;
		m_EmployeeApplication.dictionaryService=this.dictionaryService;
	}

	private int Id = 0;
	//序号
	public int getId(){
		return this.Id;
	}
	public void setId(int value){
		this.Id = value;
	}

	private int Use_id = 0;
	//用户表Id
	public int getUse_id(){
		return this.Use_id;
	}
	public void setUse_id(int value){
		this.Use_id = value;
	}

	private String Account = "";
	//账号
	public String getAccount(){
		return this.Account;
	}
	public void setAccount(String value){
		this.Account = value;
	}

	private String Name = "";
	//姓名
	public String getName(){
		return this.Name;
	}
	public void setName(String value){
		this.Name = value;
	}

	private String Password = "";
	//密码
	public String getPassword(){
		return this.Password;
	}
	public void setPassword(String value){
		this.Password = value;
	}

	private int Gender = 0;
	//性别
	public int getGender(){
		return this.Gender;
	}
	public void setGender(int value){
		this.Gender = value;
	}

	private String Gender_Convert="";
	public String getGender_Convert(){
		switch(String.valueOf(Gender)) {
		case "1":
			return "男";
		case "0":
			return "女";
		}
		return Gender_Convert;
	}
	public void setGender_Convert(String value){
		this.Gender_Convert = value;
	}

	private String Birthday = "";
	//生日
	public String getBirthday(){
		return this.Birthday;
	}
	public void setBirthday(String value){
		this.Birthday = value;
	}

	private String Position = "";
	//职位
	public String getPosition(){
		return this.Position;
	}
	public void setPosition(String value){
		this.Position = value;
	}

	private String Education = "";
	//学历
	public String getEducation(){
		return this.Education;
	}
	public void setEducation(String value){
		this.Education = value;
	}

	private String Education_Convert="";
	public String getEducation_Convert(){
		switch(String.valueOf(Education)) {
		case "0":
			return "无";
		case "1":
			return "小学";
		case "2":
			return "初中";
		case "3":
			return "高中";
		case "4":
			return "大专";
		case "5":
			return "本科";
		case "6":
			return "硕士";
		case "7":
			return "博士";
		}
		return Education_Convert;
	}
	public void setEducation_Convert(String value){
		this.Education_Convert = value;
	}

	private String IsMarry = "";
	//婚否
	public String getIsMarry(){
		return this.IsMarry;
	}
	public void setIsMarry(String value){
		this.IsMarry = value;
	}

	private String IsMarry_Convert="";
	public String getIsMarry_Convert(){
		switch(String.valueOf(IsMarry)) {
		case "0":
			return "否";
		case "1":
			return "是";
		}
		return IsMarry_Convert;
	}
	public void setIsMarry_Convert(String value){
		this.IsMarry_Convert = value;
	}

	private String Mobile = "";
	//移动电话
	public String getMobile(){
		return this.Mobile;
	}
	public void setMobile(String value){
		this.Mobile = value;
	}

	private String IsParty = "";
	//党员与否
	public String getIsParty(){
		return this.IsParty;
	}
	public void setIsParty(String value){
		this.IsParty = value;
	}

	private String IsParty_Convert="";
	public String getIsParty_Convert(){
		switch(String.valueOf(IsParty)) {
		case "0":
			return "否";
		case "1":
			return "是";
		}
		return IsParty_Convert;
	}
	public void setIsParty_Convert(String value){
		this.IsParty_Convert = value;
	}

	private String EnlistmentTime = "";
	//入伍时间
	public String getEnlistmentTime(){
		return this.EnlistmentTime;
	}
	public void setEnlistmentTime(String value){
		this.EnlistmentTime = value;
	}

	private String RetirementTime = "";
	//退伍时间
	public String getRetirementTime(){
		return this.RetirementTime;
	}
	public void setRetirementTime(String value){
		this.RetirementTime = value;
	}

	private String TroopsName = "";
	//部队名称
	public String getTroopsName(){
		return this.TroopsName;
	}
	public void setTroopsName(String value){
		this.TroopsName = value;
	}

	private String Height = "";
	//身高
	public String getHeight(){
		return this.Height;
	}
	public void setHeight(String value){
		this.Height = value;
	}

	private String Weight = "";
	//体重
	public String getWeight(){
		return this.Weight;
	}
	public void setWeight(String value){
		this.Weight = value;
	}

	private String PersonalSpecialty = "";
	//个人特长
	public String getPersonalSpecialty(){
		return this.PersonalSpecialty;
	}
	public void setPersonalSpecialty(String value){
		this.PersonalSpecialty = value;
	}

	private String CardNo = "";
	//身份证号
	public String getCardNo(){
		return this.CardNo;
	}
	public void setCardNo(String value){
		this.CardNo = value;
	}

	private String BankNo = "";
	//银行卡号
	public String getBankNo(){
		return this.BankNo;
	}
	public void setBankNo(String value){
		this.BankNo = value;
	}

	private String Address = "";
	//户籍地址
	public String getAddress(){
		return this.Address;
	}
	public void setAddress(String value){
		this.Address = value;
	}

	private List<String> Certificate = new ArrayList<String>();
	//技能证书
	public List<String> getCertificate(){
		return this.Certificate;
	}
	public void setCertificate(List<String> value){
		this.Certificate = value;
	}

	private String Img = "";
	//头像照
	public String getImg(){
		return this.Img;
	}
	public void setImg(String value){
		this.Img = value;
	}

	private String SpeakLevel = "";
	//普通话水平
	public String getSpeakLevel(){
		return this.SpeakLevel;
	}
	public void setSpeakLevel(String value){
		this.SpeakLevel = value;
	}

	private String SpeakLevel_Convert="";
	public String getSpeakLevel_Convert(){
		switch(String.valueOf(SpeakLevel)) {
		case "0":
			return "普通";
		case "1":
			return "良好";
		case "2":
			return "熟练";
		case "3":
			return "无";
		}
		return SpeakLevel_Convert;
	}
	public void setSpeakLevel_Convert(String value){
		this.SpeakLevel_Convert = value;
	}

	private String EnglishLevel = "";
	//英语水平
	public String getEnglishLevel(){
		return this.EnglishLevel;
	}
	public void setEnglishLevel(String value){
		this.EnglishLevel = value;
	}

	private String EnglishLevel_Convert="";
	public String getEnglishLevel_Convert(){
		switch(String.valueOf(EnglishLevel)) {
		case "0":
			return "普通";
		case "1":
			return "良好";
		case "2":
			return "熟练";
		case "3":
			return "无";
		}
		return EnglishLevel_Convert;
	}
	public void setEnglishLevel_Convert(String value){
		this.EnglishLevel_Convert = value;
	}

	private String ComputerLevel = "";
	//电脑水平
	public String getComputerLevel(){
		return this.ComputerLevel;
	}
	public void setComputerLevel(String value){
		this.ComputerLevel = value;
	}

	private String ComputerLevel_Convert="";
	public String getComputerLevel_Convert(){
		switch(String.valueOf(ComputerLevel)) {
		case "0":
			return "普通";
		case "1":
			return "良好";
		case "2":
			return "熟练";
		case "3":
			return "无";
		}
		return ComputerLevel_Convert;
	}
	public void setComputerLevel_Convert(String value){
		this.ComputerLevel_Convert = value;
	}

	private String DriveLevel = "";
	//驾驶水平
	public String getDriveLevel(){
		return this.DriveLevel;
	}
	public void setDriveLevel(String value){
		this.DriveLevel = value;
	}

	private String DriveLevel_Convert="";
	public String getDriveLevel_Convert(){
		switch(String.valueOf(DriveLevel)) {
		case "3":
			return "无";
		case "2":
			return "A照";
		case "1":
			return "B照";
		case "0":
			return "C照";
		}
		return DriveLevel_Convert;
	}
	public void setDriveLevel_Convert(String value){
		this.DriveLevel_Convert = value;
	}

	private String OtherSkills = "";
	//其他技能
	public String getOtherSkills(){
		return this.OtherSkills;
	}
	public void setOtherSkills(String value){
		this.OtherSkills = value;
	}

	private String IsFamilyDisease = "";
	//是否有家族遗传疾病史
	public String getIsFamilyDisease(){
		return this.IsFamilyDisease;
	}
	public void setIsFamilyDisease(String value){
		this.IsFamilyDisease = value;
	}

	private String IsFamilyDisease_Convert="";
	public String getIsFamilyDisease_Convert(){
		switch(String.valueOf(IsFamilyDisease)) {
		case "0":
			return "否";
		case "1":
			return "是";
		}
		return IsFamilyDisease_Convert;
	}
	public void setIsFamilyDisease_Convert(String value){
		this.IsFamilyDisease_Convert = value;
	}

	private String IsChronicDisease = "";
	//是否有慢性疾病
	public String getIsChronicDisease(){
		return this.IsChronicDisease;
	}
	public void setIsChronicDisease(String value){
		this.IsChronicDisease = value;
	}

	private String IsChronicDisease_Convert="";
	public String getIsChronicDisease_Convert(){
		switch(String.valueOf(IsChronicDisease)) {
		case "0":
			return "否";
		case "1":
			return "是";
		}
		return IsChronicDisease_Convert;
	}
	public void setIsChronicDisease_Convert(String value){
		this.IsChronicDisease_Convert = value;
	}

	private String IsCriminalPunishment = "";
	//是否受过刑事处罚
	public String getIsCriminalPunishment(){
		return this.IsCriminalPunishment;
	}
	public void setIsCriminalPunishment(String value){
		this.IsCriminalPunishment = value;
	}

	private String IsCriminalPunishment_Convert="";
	public String getIsCriminalPunishment_Convert(){
		switch(String.valueOf(IsCriminalPunishment)) {
		case "0":
			return "否";
		case "1":
			return "是";
		}
		return IsCriminalPunishment_Convert;
	}
	public void setIsCriminalPunishment_Convert(String value){
		this.IsCriminalPunishment_Convert = value;
	}

	private String IsAdministrativeSanction = "";
	//是否受过行政处罚
	public String getIsAdministrativeSanction(){
		return this.IsAdministrativeSanction;
	}
	public void setIsAdministrativeSanction(String value){
		this.IsAdministrativeSanction = value;
	}

	private String IsAdministrativeSanction_Convert="";
	public String getIsAdministrativeSanction_Convert(){
		switch(String.valueOf(IsAdministrativeSanction)) {
		case "0":
			return "否";
		case "1":
			return "是";
		}
		return IsAdministrativeSanction_Convert;
	}
	public void setIsAdministrativeSanction_Convert(String value){
		this.IsAdministrativeSanction_Convert = value;
	}

	private String IsMajorDiseases = "";
	//是否患过重大疾病
	public String getIsMajorDiseases(){
		return this.IsMajorDiseases;
	}
	public void setIsMajorDiseases(String value){
		this.IsMajorDiseases = value;
	}

	private String IsMajorDiseases_Convert="";
	public String getIsMajorDiseases_Convert(){
		switch(String.valueOf(IsMajorDiseases)) {
		case "0":
			return "否";
		case "1":
			return "是";
		}
		return IsMajorDiseases_Convert;
	}
	public void setIsMajorDiseases_Convert(String value){
		this.IsMajorDiseases_Convert = value;
	}

	private String IsExcessiveDrinking = "";
	//是否有酗酒习惯
	public String getIsExcessiveDrinking(){
		return this.IsExcessiveDrinking;
	}
	public void setIsExcessiveDrinking(String value){
		this.IsExcessiveDrinking = value;
	}

	private String IsExcessiveDrinking_Convert="";
	public String getIsExcessiveDrinking_Convert(){
		switch(String.valueOf(IsExcessiveDrinking)) {
		case "0":
			return "否";
		case "1":
			return "是";
		}
		return IsExcessiveDrinking_Convert;
	}
	public void setIsExcessiveDrinking_Convert(String value){
		this.IsExcessiveDrinking_Convert = value;
	}

	private String IsDrug = "";
	//是否曾有过吸毒行为
	public String getIsDrug(){
		return this.IsDrug;
	}
	public void setIsDrug(String value){
		this.IsDrug = value;
	}

	private String IsDrug_Convert="";
	public String getIsDrug_Convert(){
		switch(String.valueOf(IsDrug)) {
		case "0":
			return "否";
		case "1":
			return "是";
		}
		return IsDrug_Convert;
	}
	public void setIsDrug_Convert(String value){
		this.IsDrug_Convert = value;
	}

	private String IsOccupationalDiseases = "";
	//是否有工伤/职业病/伤残等级
	public String getIsOccupationalDiseases(){
		return this.IsOccupationalDiseases;
	}
	public void setIsOccupationalDiseases(String value){
		this.IsOccupationalDiseases = value;
	}

	private String IsOccupationalDiseases_Convert="";
	public String getIsOccupationalDiseases_Convert(){
		switch(String.valueOf(IsOccupationalDiseases)) {
		case "0":
			return "否";
		case "1":
			return "是";
		}
		return IsOccupationalDiseases_Convert;
	}
	public void setIsOccupationalDiseases_Convert(String value){
		this.IsOccupationalDiseases_Convert = value;
	}

	private String OccupationalDiseases = "";
	//工伤/职业病/伤残等级
	public String getOccupationalDiseases(){
		return this.OccupationalDiseases;
	}
	public void setOccupationalDiseases(String value){
		this.OccupationalDiseases = value;
	}

	private String WorkAddress = "";
	//项目点
	public String getWorkAddress(){
		return this.WorkAddress;
	}
	public void setWorkAddress(String value){
		this.WorkAddress = value;
	}

	private String Department = "";
	//部门
	public String getDepartment(){
		return this.Department;
	}
	public void setDepartment(String value){
		this.Department = value;
	}

	private String EMail = "";
	//邮箱
	public String getEMail(){
		return this.EMail;
	}
	public void setEMail(String value){
		this.EMail = value;
	}

	private String CreateTime = "";
	//注册时间
	public String getCreateTime(){
		return this.CreateTime;
	}
	public void setCreateTime(String value){
		this.CreateTime = value;
	}

	private String Type = "";
	//用户类型
	public String getType(){
		return this.Type;
	}
	public void setType(String value){
		this.Type = value;
	}

	private List<String> CardType = new ArrayList<String>();
	//证件类型
	public List<String> getCardType(){
		return this.CardType;
	}
	public void setCardType(List<String> value){
		this.CardType = value;
	}

	private String PeopleType = "";
	//人员类型
	public String getPeopleType(){
		return this.PeopleType;
	}
	public void setPeopleType(String value){
		this.PeopleType = value;
	}

	private String PeopleType_Convert="";
	public String getPeopleType_Convert(){
		switch(String.valueOf(PeopleType)) {
		case "0":
			return "失业";
		case "1":
			return "协保";
		case "2":
			return "应届";
		case "3":
			return "在职";
		case "4":
			return "农村富余劳动力";
		case "5":
			return "下岗";
		case "6":
			return "待退休";
		case "7":
			return "退休";
		case "8":
			return "外来务工人员";
		case "9":
			return "其它";
		}
		return PeopleType_Convert;
	}
	public void setPeopleType_Convert(String value){
		this.PeopleType_Convert = value;
	}

	private boolean IsClose = false;
	//是否使用
	public boolean getIsClose(){
		return this.IsClose;
	}
	public void setIsClose(boolean value){
		this.IsClose = value;
	}

	private String IsClose_Convert="";
	public String getIsClose_Convert(){
		switch(String.valueOf(IsClose)) {
		}
		return IsClose_Convert;
	}
	public void setIsClose_Convert(String value){
		this.IsClose_Convert = value;
	}

	private int Status = 0;
	//流程节点
	public int getStatus(){
		return this.Status;
	}
	public void setStatus(int value){
		this.Status = value;
	}

	private String Peoples = "";
	//流程处理人
	public String getPeoples(){
		return this.Peoples;
	}
	public void setPeoples(String value){
		this.Peoples = value;
	}

	private String RegistrationDate = "";
	//报到日期
	public String getRegistrationDate(){
		return this.RegistrationDate;
	}
	public void setRegistrationDate(String value){
		this.RegistrationDate = value;
	}

	private String DocumentImg = "";
	//证件照片
	public String getDocumentImg(){
		return this.DocumentImg;
	}
	public void setDocumentImg(String value){
		this.DocumentImg = value;
	}

	private String img1 = "";
	public String getimg1(){
		return this.img1;
	}
	public void setimg1(String value){
		this.img1 = value;
	}

	private String img2 = "";
	public String getimg2(){
		return this.img2;
	}
	public void setimg2(String value){
		this.img2 = value;
	}

	private String img3 = "";
	public String getimg3(){
		return this.img3;
	}
	public void setimg3(String value){
		this.img3 = value;
	}

	private String Certificates = "";
	//查询技能证书
	public String getCertificates(){
		return this.Certificates;
	}
	public void setCertificates(String value){
		this.Certificates = value;
	}

	private String Certificates_Convert="";
	public String getCertificates_Convert(){
		switch(String.valueOf(Certificates)) {
		case "3":
			return "保安员证";
		case "4":
			return "驾驶A证";
		case "5":
			return "驾驶B证";
		case "6":
			return "驾驶C证";
		case "7":
			return "建筑物消防员";
		case "8":
			return "五级保卫员证";
		case "9":
			return "四级保卫员证";
		case "10":
			return "三级保卫师证";
		case "11":
			return "二级保卫师证";
		case "12":
			return "一级保卫师证";
		}
		return Certificates_Convert;
	}
	public void setCertificates_Convert(String value){
		this.Certificates_Convert = value;
	}

	private String CardTypes = "";
	//查询证件类型
	public String getCardTypes(){
		return this.CardTypes;
	}
	public void setCardTypes(String value){
		this.CardTypes = value;
	}

	private String CardTypes_Convert="";
	public String getCardTypes_Convert(){
		switch(String.valueOf(CardTypes)) {
		case "0":
			return "身份证复印件正反面";
		case "1":
			return "学历证书原件";
		case "2":
			return "劳动手册";
		case "3":
			return "健康证";
		case "4":
			return "体检报告原件";
		case "5":
			return "照片";
		case "6":
			return "无";
		}
		return CardTypes_Convert;
	}
	public void setCardTypes_Convert(String value){
		this.CardTypes_Convert = value;
	}

	private List<Family> Familys = new ArrayList<Family>();
	//家庭信息
	public List<Family> getFamilys(){
		return this.Familys;
	}
	public void setFamilys(List<Family> value){
		this.Familys = value;
	}

	private List<EducationalTraining> EducationalTrainings = new ArrayList<EducationalTraining>();
	//教育经历信息
	public List<EducationalTraining> getEducationalTrainings(){
		return this.EducationalTrainings;
	}
	public void setEducationalTrainings(List<EducationalTraining> value){
		this.EducationalTrainings = value;
	}

	private List<WorkExperience> WorkExperiences = new ArrayList<WorkExperience>();
	//信息
	public List<WorkExperience> getWorkExperiences(){
		return this.WorkExperiences;
	}
	public void setWorkExperiences(List<WorkExperience> value){
		this.WorkExperiences = value;
	}

	private List<UserImg> UserImgs = new ArrayList<UserImg>();
	//用户图图像
	public List<UserImg> getUserImgs(){
		return this.UserImgs;
	}
	public void setUserImgs(List<UserImg> value){
		this.UserImgs = value;
	}

}
