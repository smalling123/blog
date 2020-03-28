package org.polariscode.SecuritySystem.model.Base;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;
import java.util.List;
import java.util.ArrayList;
import org.polariscode.SecuritySystem.model.Base.PersonnelJob;
import org.polariscode.SecuritySystem.model.Base.PersonnelMembers;
import org.polariscode.SecuritySystem.model.Base.PersonnelPhoto;
import org.polariscode.SecuritySystem.model.Base.PersonnelCert;
import org.polariscode.SecuritySystem.model.Base.PersonnelContract;

//员工信息
@Component
public class Personnel implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static Personnel m_Personnel;

	@PostConstruct 
	public void init(){
		m_Personnel=this;
		m_Personnel.dictionaryService=this.dictionaryService;
	}

	private int ID = 0;
	public int getID(){
		return this.ID;
	}
	public void setID(int value){
		this.ID = value;
	}

	private String Code = "";
	//编号
	public String getCode(){
		return this.Code;
	}
	public void setCode(String value){
		this.Code = value;
	}

	private String Name = "";
	//姓名
	public String getName(){
		return this.Name;
	}
	public void setName(String value){
		this.Name = value;
	}

	private String CardCode = "";
	//身份证
	public String getCardCode(){
		return this.CardCode;
	}
	public void setCardCode(String value){
		this.CardCode = value;
	}

	private java.util.Date CardDate = null;
	//身份证有效期
	public java.util.Date getCardDate(){
		return this.CardDate;
	}
	public void setCardDate(java.util.Date value){
		this.CardDate = value;
	}

	private java.util.Date Birthday = null;
	//生日
	public java.util.Date getBirthday(){
		return this.Birthday;
	}
	public void setBirthday(java.util.Date value){
		this.Birthday = value;
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

	private int Politics = 0;
	//政治面貌
	public int getPolitics(){
		return this.Politics;
	}
	public void setPolitics(int value){
		this.Politics = value;
	}

	private String Politics_Convert="";
	public String getPolitics_Convert(){
		switch(String.valueOf(Politics)) {
		case "0":
			return "群众";
		case "1":
			return "中共党员";
		case "2":
			return "预备党员";
		case "3":
			return "共青团员";
		case "4":
			return "民主党派";
		}
		return Politics_Convert;
	}
	public void setPolitics_Convert(String value){
		this.Politics_Convert = value;
	}

	private int Height = 0;
	//身高
	public int getHeight(){
		return this.Height;
	}
	public void setHeight(int value){
		this.Height = value;
	}

	private int Weight = 0;
	//体重
	public int getWeight(){
		return this.Weight;
	}
	public void setWeight(int value){
		this.Weight = value;
	}

	private int Education = 0;
	//文化程度
	public int getEducation(){
		return this.Education;
	}
	public void setEducation(int value){
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

	private int Nation = 0;
	//民族
	public int getNation(){
		return this.Nation;
	}
	public void setNation(int value){
		this.Nation = value;
	}

	private String Nation_Convert="";
	public String getNation_Convert(){
		switch(String.valueOf(Nation)) {
		case "0":
			return "汉族";
		case "1":
			return "满族";
		case "2":
			return "蒙古族";
		case "3":
			return "回族";
		case "4":
			return "藏族";
		case "5":
			return "维吾尔族";
		case "6":
			return "苗族";
		case "7":
			return "彝族";
		case "8":
			return "壮族";
		case "9":
			return "布依族";
		case "10":
			return "侗族";
		case "11":
			return "瑶族";
		case "12":
			return "白族";
		case "13":
			return "土家族";
		case "14":
			return "哈尼族";
		case "15":
			return "哈萨克族";
		case "16":
			return "傣族";
		case "17":
			return "黎族";
		case "18":
			return "傈僳族";
		case "19":
			return "佤族";
		case "20":
			return "畲族";
		case "21":
			return "高山族";
		case "22":
			return "拉祜族";
		case "23":
			return "水族";
		case "24":
			return "东乡族";
		case "25":
			return "纳西族";
		case "26":
			return "景颇族";
		case "27":
			return "柯尔克孜族";
		case "28":
			return "土族";
		case "29":
			return "达斡尔族";
		case "30":
			return "仫佬族";
		case "31":
			return "羌族";
		case "32":
			return "布朗族";
		case "33":
			return "撒拉族";
		case "34":
			return "毛南族";
		case "35":
			return "仡佬族";
		case "36":
			return "锡伯族";
		case "37":
			return "阿昌族";
		case "38":
			return "普米族";
		case "39":
			return "朝鲜族";
		case "40":
			return "塔吉克族";
		case "41":
			return "怒族";
		case "42":
			return "乌孜别克族";
		case "43":
			return "俄罗斯族";
		case "44":
			return "鄂温克族";
		case "45":
			return "德昂族";
		case "46":
			return "保安族";
		case "47":
			return "裕固族";
		case "48":
			return "京族";
		case "49":
			return "塔塔尔族";
		case "50":
			return "独龙族";
		case "51":
			return "鄂伦春族";
		case "52":
			return "赫哲族";
		case "53":
			return "门巴族";
		case "54":
			return "珞巴族";
		case "55":
			return "基诺族";
		}
		return Nation_Convert;
	}
	public void setNation_Convert(String value){
		this.Nation_Convert = value;
	}

	private String Native = "";
	//籍贯
	public String getNative(){
		return this.Native;
	}
	public void setNative(String value){
		this.Native = value;
	}

	private String Native_Convert="";
	public String getNative_Convert(){
		Native_Convert = m_Personnel.dictionaryService.convertDictionary("Province", String.valueOf(Native));
		if(Native_Convert == null) Native_Convert = "";
		return Native_Convert;
	}
	public void setNative_Convert(String value){
		this.Native_Convert = value;
	}

	private String Phone = "";
	//电话
	public String getPhone(){
		return this.Phone;
	}
	public void setPhone(String value){
		this.Phone = value;
	}

	private String HomeAddress = "";
	//住址
	public String getHomeAddress(){
		return this.HomeAddress;
	}
	public void setHomeAddress(String value){
		this.HomeAddress = value;
	}

	private int Census = 0;
	//户籍
	public int getCensus(){
		return this.Census;
	}
	public void setCensus(int value){
		this.Census = value;
	}

	private String Census_Convert="";
	public String getCensus_Convert(){
		Census_Convert = m_Personnel.dictionaryService.convertDictionary("Province", String.valueOf(Census));
		if(Census_Convert == null) Census_Convert = "";
		return Census_Convert;
	}
	public void setCensus_Convert(String value){
		this.Census_Convert = value;
	}

	private String CensusAddress = "";
	//户籍地址
	public String getCensusAddress(){
		return this.CensusAddress;
	}
	public void setCensusAddress(String value){
		this.CensusAddress = value;
	}

	private int Marital = 0;
	//婚姻情况
	public int getMarital(){
		return this.Marital;
	}
	public void setMarital(int value){
		this.Marital = value;
	}

	private String Marital_Convert="";
	public String getMarital_Convert(){
		switch(String.valueOf(Marital)) {
		case "0":
			return "未婚";
		case "1":
			return "已婚未育";
		case "2":
			return "已婚已育";
		case "3":
			return "离异";
		}
		return Marital_Convert;
	}
	public void setMarital_Convert(String value){
		this.Marital_Convert = value;
	}

	private String LinkMan = "";
	//紧急联系人
	public String getLinkMan(){
		return this.LinkMan;
	}
	public void setLinkMan(String value){
		this.LinkMan = value;
	}

	private String LinkManRelation = "";
	//联系人关系
	public String getLinkManRelation(){
		return this.LinkManRelation;
	}
	public void setLinkManRelation(String value){
		this.LinkManRelation = value;
	}

	private String LinkManRelation_Convert="";
	public String getLinkManRelation_Convert(){
		switch(String.valueOf(LinkManRelation)) {
		case "0":
			return "父";
		case "1":
			return "母";
		case "2":
			return "配偶";
		case "3":
			return "子女";
		case "4":
			return "兄弟";
		case "5":
			return "姐妹";
		case "6":
			return "其它";
		}
		return LinkManRelation_Convert;
	}
	public void setLinkManRelation_Convert(String value){
		this.LinkManRelation_Convert = value;
	}

	private String LinkManPhone = "";
	//联系人电话
	public String getLinkManPhone(){
		return this.LinkManPhone;
	}
	public void setLinkManPhone(String value){
		this.LinkManPhone = value;
	}

	private String Army = "";
	//部队名称
	public String getArmy(){
		return this.Army;
	}
	public void setArmy(String value){
		this.Army = value;
	}

	private java.util.Date ArmyInDate = null;
	//入伍日期
	public java.util.Date getArmyInDate(){
		return this.ArmyInDate;
	}
	public void setArmyInDate(java.util.Date value){
		this.ArmyInDate = value;
	}

	private java.util.Date ArmyOutDate = null;
	//退伍日期
	public java.util.Date getArmyOutDate(){
		return this.ArmyOutDate;
	}
	public void setArmyOutDate(java.util.Date value){
		this.ArmyOutDate = value;
	}

	private boolean Z1 = false;
	//保安员证
	public boolean getZ1(){
		return this.Z1;
	}
	public void setZ1(boolean value){
		this.Z1 = value;
	}

	private boolean Z2 = false;
	//监控证
	public boolean getZ2(){
		return this.Z2;
	}
	public void setZ2(boolean value){
		this.Z2 = value;
	}

	private boolean Z3 = false;
	//电梯证
	public boolean getZ3(){
		return this.Z3;
	}
	public void setZ3(boolean value){
		this.Z3 = value;
	}

	private boolean Z4 = false;
	//消防证
	public boolean getZ4(){
		return this.Z4;
	}
	public void setZ4(boolean value){
		this.Z4 = value;
	}

	private boolean Z5 = false;
	//驾驶执照
	public boolean getZ5(){
		return this.Z5;
	}
	public void setZ5(boolean value){
		this.Z5 = value;
	}

	private boolean Z6 = false;
	public boolean getZ6(){
		return this.Z6;
	}
	public void setZ6(boolean value){
		this.Z6 = value;
	}

	private boolean Z7 = false;
	public boolean getZ7(){
		return this.Z7;
	}
	public void setZ7(boolean value){
		this.Z7 = value;
	}

	private boolean Z8 = false;
	public boolean getZ8(){
		return this.Z8;
	}
	public void setZ8(boolean value){
		this.Z8 = value;
	}

	private int Computer = 0;
	//电脑技能
	public int getComputer(){
		return this.Computer;
	}
	public void setComputer(int value){
		this.Computer = value;
	}

	private String Computer_Convert="";
	public String getComputer_Convert(){
		switch(String.valueOf(Computer)) {
		case "0":
			return "无";
		case "1":
			return "一般";
		case "2":
			return "熟练";
		case "3":
			return "精通";
		}
		return Computer_Convert;
	}
	public void setComputer_Convert(String value){
		this.Computer_Convert = value;
	}

	private int English = 0;
	//英语能力
	public int getEnglish(){
		return this.English;
	}
	public void setEnglish(int value){
		this.English = value;
	}

	private String English_Convert="";
	public String getEnglish_Convert(){
		switch(String.valueOf(English)) {
		case "0":
			return "熟练";
		case "1":
			return "良好";
		case "2":
			return "一般";
		}
		return English_Convert;
	}
	public void setEnglish_Convert(String value){
		this.English_Convert = value;
	}

	private boolean PartTime = false;
	//是否在其它单位兼职
	public boolean getPartTime(){
		return this.PartTime;
	}
	public void setPartTime(boolean value){
		this.PartTime = value;
	}

	private boolean Disease = false;
	//是否有重大疾病
	public boolean getDisease(){
		return this.Disease;
	}
	public void setDisease(boolean value){
		this.Disease = value;
	}

	private boolean Crime = false;
	//是否有犯罪记录
	public boolean getCrime(){
		return this.Crime;
	}
	public void setCrime(boolean value){
		this.Crime = value;
	}

	private String Appearance = "";
	//仪容仪表
	public String getAppearance(){
		return this.Appearance;
	}
	public void setAppearance(String value){
		this.Appearance = value;
	}

	private String Communication = "";
	//沟通能力
	public String getCommunication(){
		return this.Communication;
	}
	public void setCommunication(String value){
		this.Communication = value;
	}

	private int Source = 0;
	//招聘来源
	public int getSource(){
		return this.Source;
	}
	public void setSource(int value){
		this.Source = value;
	}

	private String Source_Convert="";
	public String getSource_Convert(){
		switch(String.valueOf(Source)) {
		case "0":
			return "网站";
		case "1":
			return "员工推荐";
		case "2":
			return "领导安排";
		case "3":
			return "队长推荐";
		case "4":
			return "客户推荐";
		case "5":
			return "其它";
		}
		return Source_Convert;
	}
	public void setSource_Convert(String value){
		this.Source_Convert = value;
	}

	private String Reference = "";
	//推荐人
	public String getReference(){
		return this.Reference;
	}
	public void setReference(String value){
		this.Reference = value;
	}

	private java.util.Date InDate = null;
	//入职日期
	public java.util.Date getInDate(){
		return this.InDate;
	}
	public void setInDate(java.util.Date value){
		this.InDate = value;
	}

	private java.util.Date HTBeginDate = null;
	//合同开始日期
	public java.util.Date getHTBeginDate(){
		return this.HTBeginDate;
	}
	public void setHTBeginDate(java.util.Date value){
		this.HTBeginDate = value;
	}

	private java.util.Date HTEndDate = null;
	//合同结束日期
	public java.util.Date getHTEndDate(){
		return this.HTEndDate;
	}
	public void setHTEndDate(java.util.Date value){
		this.HTEndDate = value;
	}

	private boolean Photo = false;
	//照片
	public boolean getPhoto(){
		return this.Photo;
	}
	public void setPhoto(boolean value){
		this.Photo = value;
	}

	private int PhotoCount = 0;
	//几张
	public int getPhotoCount(){
		return this.PhotoCount;
	}
	public void setPhotoCount(int value){
		this.PhotoCount = value;
	}

	private boolean F1 = false;
	//身份证复印件
	public boolean getF1(){
		return this.F1;
	}
	public void setF1(boolean value){
		this.F1 = value;
	}

	private boolean F2 = false;
	//培训表
	public boolean getF2(){
		return this.F2;
	}
	public void setF2(boolean value){
		this.F2 = value;
	}

	private boolean F3 = false;
	//劳动手册
	public boolean getF3(){
		return this.F3;
	}
	public void setF3(boolean value){
		this.F3 = value;
	}

	private boolean F4 = false;
	//无犯罪记录证明
	public boolean getF4(){
		return this.F4;
	}
	public void setF4(boolean value){
		this.F4 = value;
	}

	private boolean F5 = false;
	//转正小结
	public boolean getF5(){
		return this.F5;
	}
	public void setF5(boolean value){
		this.F5 = value;
	}

	private boolean F6 = false;
	//外住表
	public boolean getF6(){
		return this.F6;
	}
	public void setF6(boolean value){
		this.F6 = value;
	}

	private boolean F7 = false;
	//体检报告
	public boolean getF7(){
		return this.F7;
	}
	public void setF7(boolean value){
		this.F7 = value;
	}

	private boolean F8 = false;
	//交金证明
	public boolean getF8(){
		return this.F8;
	}
	public void setF8(boolean value){
		this.F8 = value;
	}

	private boolean F9 = false;
	//健康证
	public boolean getF9(){
		return this.F9;
	}
	public void setF9(boolean value){
		this.F9 = value;
	}

	private boolean F10 = false;
	public boolean getF10(){
		return this.F10;
	}
	public void setF10(boolean value){
		this.F10 = value;
	}

	private String GeneralComment = "";
	//总体评语
	public String getGeneralComment(){
		return this.GeneralComment;
	}
	public void setGeneralComment(String value){
		this.GeneralComment = value;
	}

	private String InterViewer = "";
	//面试人
	public String getInterViewer(){
		return this.InterViewer;
	}
	public void setInterViewer(String value){
		this.InterViewer = value;
	}

	private boolean GivePost = false;
	//是否任用
	public boolean getGivePost(){
		return this.GivePost;
	}
	public void setGivePost(boolean value){
		this.GivePost = value;
	}

	private String PlanSite = "";
	//拟派单位
	public String getPlanSite(){
		return this.PlanSite;
	}
	public void setPlanSite(String value){
		this.PlanSite = value;
	}

	private String PlantJob = "";
	//拟派职务 
	public String getPlantJob(){
		return this.PlantJob;
	}
	public void setPlantJob(String value){
		this.PlantJob = value;
	}

	private java.util.Date PlanInDate = null;
	//拟报到时间
	public java.util.Date getPlanInDate(){
		return this.PlanInDate;
	}
	public void setPlanInDate(java.util.Date value){
		this.PlanInDate = value;
	}

	private String CheckUser = "";
	//核准人
	public String getCheckUser(){
		return this.CheckUser;
	}
	public void setCheckUser(String value){
		this.CheckUser = value;
	}

	private String HRUser = "";
	//人事部核准人
	public String getHRUser(){
		return this.HRUser;
	}
	public void setHRUser(String value){
		this.HRUser = value;
	}

	private String JobUser = "";
	//任用部门核准人
	public String getJobUser(){
		return this.JobUser;
	}
	public void setJobUser(String value){
		this.JobUser = value;
	}

	private String CreateUser = "";
	public String getCreateUser(){
		return this.CreateUser;
	}
	public void setCreateUser(String value){
		this.CreateUser = value;
	}

	private java.util.Date CreateTime = null;
	public java.util.Date getCreateTime(){
		return this.CreateTime;
	}
	public void setCreateTime(java.util.Date value){
		this.CreateTime = value;
	}

	private String ModifyUser = "";
	public String getModifyUser(){
		return this.ModifyUser;
	}
	public void setModifyUser(String value){
		this.ModifyUser = value;
	}

	private java.util.Date ModifyTime = null;
	public java.util.Date getModifyTime(){
		return this.ModifyTime;
	}
	public void setModifyTime(java.util.Date value){
		this.ModifyTime = value;
	}

	private String DeleteUser = "";
	public String getDeleteUser(){
		return this.DeleteUser;
	}
	public void setDeleteUser(String value){
		this.DeleteUser = value;
	}

	private java.util.Date DeleteTime = null;
	public java.util.Date getDeleteTime(){
		return this.DeleteTime;
	}
	public void setDeleteTime(java.util.Date value){
		this.DeleteTime = value;
	}

	private int CompanyId = 0;
	//合同签署单位
	public int getCompanyId(){
		return this.CompanyId;
	}
	public void setCompanyId(int value){
		this.CompanyId = value;
	}

	private String CompanyId_Convert="";
	public String getCompanyId_Convert(){
		CompanyId_Convert = m_Personnel.dictionaryService.convertDictionary("Company", String.valueOf(CompanyId));
		if(CompanyId_Convert == null) CompanyId_Convert = "";
		return CompanyId_Convert;
	}
	public void setCompanyId_Convert(String value){
		this.CompanyId_Convert = value;
	}

	private int Status = 0;
	//状态
	public int getStatus(){
		return this.Status;
	}
	public void setStatus(int value){
		this.Status = value;
	}

	private String Status_Convert="";
	public String getStatus_Convert(){
		switch(String.valueOf(Status)) {
		case "0":
			return "待分配";
		case "1":
			return "在职";
		case "2":
			return "离职";
		}
		return Status_Convert;
	}
	public void setStatus_Convert(String value){
		this.Status_Convert = value;
	}

	private java.util.Date OutDate = null;
	//离职日期
	public java.util.Date getOutDate(){
		return this.OutDate;
	}
	public void setOutDate(java.util.Date value){
		this.OutDate = value;
	}

	private String BankCard = "";
	//银行卡号
	public String getBankCard(){
		return this.BankCard;
	}
	public void setBankCard(String value){
		this.BankCard = value;
	}

	private int PoliticalTrial = 0;
	//政审
	public int getPoliticalTrial(){
		return this.PoliticalTrial;
	}
	public void setPoliticalTrial(int value){
		this.PoliticalTrial = value;
	}

	private String PoliticalTrial_Convert="";
	public String getPoliticalTrial_Convert(){
		switch(String.valueOf(PoliticalTrial)) {
		case "0":
			return "未做政审";
		case "1":
			return "政审通过";
		case "2":
			return "政审不通过";
		}
		return PoliticalTrial_Convert;
	}
	public void setPoliticalTrial_Convert(String value){
		this.PoliticalTrial_Convert = value;
	}

	private String FileNumber = "";
	//档案号
	public String getFileNumber(){
		return this.FileNumber;
	}
	public void setFileNumber(String value){
		this.FileNumber = value;
	}

	private List<PersonnelJob> PersonnelJob = new ArrayList<PersonnelJob>();
	//工作经历
	public List<PersonnelJob> getPersonnelJob(){
		return this.PersonnelJob;
	}
	public void setPersonnelJob(List<PersonnelJob> value){
		this.PersonnelJob = value;
	}

	private List<PersonnelMembers> PersonnelMembers = new ArrayList<PersonnelMembers>();
	//家庭成员
	public List<PersonnelMembers> getPersonnelMembers(){
		return this.PersonnelMembers;
	}
	public void setPersonnelMembers(List<PersonnelMembers> value){
		this.PersonnelMembers = value;
	}

	private List<PersonnelPhoto> PersonnelPhoto = new ArrayList<PersonnelPhoto>();
	//照片
	public List<PersonnelPhoto> getPersonnelPhoto(){
		return this.PersonnelPhoto;
	}
	public void setPersonnelPhoto(List<PersonnelPhoto> value){
		this.PersonnelPhoto = value;
	}

	private List<PersonnelCert> PersonnelCert = new ArrayList<PersonnelCert>();
	//证书
	public List<PersonnelCert> getPersonnelCert(){
		return this.PersonnelCert;
	}
	public void setPersonnelCert(List<PersonnelCert> value){
		this.PersonnelCert = value;
	}

	private List<PersonnelContract> PersonnelContract = new ArrayList<PersonnelContract>();
	//合同
	public List<PersonnelContract> getPersonnelContract(){
		return this.PersonnelContract;
	}
	public void setPersonnelContract(List<PersonnelContract> value){
		this.PersonnelContract = value;
	}

}
