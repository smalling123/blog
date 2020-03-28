package org.polariscode.SecuritySystem.model.Office;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;
import java.util.List;
import java.util.ArrayList;
import org.polariscode.SecuritySystem.model.Office.StaffMembers;
import org.polariscode.SecuritySystem.model.Office.StaffWork;
import org.polariscode.SecuritySystem.model.Office.StaffEdu;

@Component
public class Staff implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static Staff m_Staff;

	@PostConstruct 
	public void init(){
		m_Staff=this;
		m_Staff.dictionaryService=this.dictionaryService;
	}

	private int ID = 0;
	public int getID(){
		return this.ID;
	}
	public void setID(int value){
		this.ID = value;
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
	//证件号
	public String getCardCode(){
		return this.CardCode;
	}
	public void setCardCode(String value){
		this.CardCode = value;
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

	private java.util.Date Birthday = null;
	//出生日期
	public java.util.Date getBirthday(){
		return this.Birthday;
	}
	public void setBirthday(java.util.Date value){
		this.Birthday = value;
	}

	private String Nation = "";
	//民族
	public String getNation(){
		return this.Nation;
	}
	public void setNation(String value){
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

	private int Marital = 0;
	//婚育情况
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
		Native_Convert = m_Staff.dictionaryService.convertDictionary("Province", String.valueOf(Native));
		if(Native_Convert == null) Native_Convert = "";
		return Native_Convert;
	}
	public void setNative_Convert(String value){
		this.Native_Convert = value;
	}

	private int Height = 0;
	//身高(cm)
	public int getHeight(){
		return this.Height;
	}
	public void setHeight(int value){
		this.Height = value;
	}

	private int Weight = 0;
	//体重(kg)
	public int getWeight(){
		return this.Weight;
	}
	public void setWeight(int value){
		this.Weight = value;
	}

	private String Health = "";
	//健康状况
	public String getHealth(){
		return this.Health;
	}
	public void setHealth(String value){
		this.Health = value;
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

	private String Phone = "";
	//联系电话
	public String getPhone(){
		return this.Phone;
	}
	public void setPhone(String value){
		this.Phone = value;
	}

	private String Mobile = "";
	//手机
	public String getMobile(){
		return this.Mobile;
	}
	public void setMobile(String value){
		this.Mobile = value;
	}

	private String Email = "";
	//Email
	public String getEmail(){
		return this.Email;
	}
	public void setEmail(String value){
		this.Email = value;
	}

	private String HAddress = "";
	//户籍地址
	public String getHAddress(){
		return this.HAddress;
	}
	public void setHAddress(String value){
		this.HAddress = value;
	}

	private int HType = 0;
	//户口性质
	public int getHType(){
		return this.HType;
	}
	public void setHType(int value){
		this.HType = value;
	}

	private String HType_Convert="";
	public String getHType_Convert(){
		switch(String.valueOf(HType)) {
		case "0":
			return "城镇";
		case "1":
			return "非城镇";
		}
		return HType_Convert;
	}
	public void setHType_Convert(String value){
		this.HType_Convert = value;
	}

	private String RAddress = "";
	//居住地址
	public String getRAddress(){
		return this.RAddress;
	}
	public void setRAddress(String value){
		this.RAddress = value;
	}

	private String PostCode = "";
	//邮编
	public String getPostCode(){
		return this.PostCode;
	}
	public void setPostCode(String value){
		this.PostCode = value;
	}

	private String LinkMan = "";
	//紧急联系人
	public String getLinkMan(){
		return this.LinkMan;
	}
	public void setLinkMan(String value){
		this.LinkMan = value;
	}

	private String LinkRelation = "";
	//与本人关系
	public String getLinkRelation(){
		return this.LinkRelation;
	}
	public void setLinkRelation(String value){
		this.LinkRelation = value;
	}

	private String LinkPhone = "";
	//联系电话
	public String getLinkPhone(){
		return this.LinkPhone;
	}
	public void setLinkPhone(String value){
		this.LinkPhone = value;
	}

	private String Cert1 = "";
	//持证情况One:
	public String getCert1(){
		return this.Cert1;
	}
	public void setCert1(String value){
		this.Cert1 = value;
	}

	private String Cert2 = "";
	//持证情况Two:
	public String getCert2(){
		return this.Cert2;
	}
	public void setCert2(String value){
		this.Cert2 = value;
	}

	private String Cert3 = "";
	//持证情况Three:
	public String getCert3(){
		return this.Cert3;
	}
	public void setCert3(String value){
		this.Cert3 = value;
	}

	private String WY1 = "";
	//外语水平
	public String getWY1(){
		return this.WY1;
	}
	public void setWY1(String value){
		this.WY1 = value;
	}

	private int WY1Level = 0;
	//级别
	public int getWY1Level(){
		return this.WY1Level;
	}
	public void setWY1Level(int value){
		this.WY1Level = value;
	}

	private String WY1Level_Convert="";
	public String getWY1Level_Convert(){
		switch(String.valueOf(WY1Level)) {
		case "0":
			return "无";
		case "1":
			return "四级";
		case "2":
			return "六级";
		case "3":
			return "八级";
		case "4":
			return "其它";
		}
		return WY1Level_Convert;
	}
	public void setWY1Level_Convert(String value){
		this.WY1Level_Convert = value;
	}

	private String WY2 = "";
	//语种2
	public String getWY2(){
		return this.WY2;
	}
	public void setWY2(String value){
		this.WY2 = value;
	}

	private int WY2Level = 0;
	//级别
	public int getWY2Level(){
		return this.WY2Level;
	}
	public void setWY2Level(int value){
		this.WY2Level = value;
	}

	private String WY2Level_Convert="";
	public String getWY2Level_Convert(){
		switch(String.valueOf(WY2Level)) {
		case "0":
			return "无";
		case "1":
			return "四级";
		case "2":
			return "六级";
		case "3":
			return "八级";
		case "4":
			return "其它";
		}
		return WY2Level_Convert;
	}
	public void setWY2Level_Convert(String value){
		this.WY2Level_Convert = value;
	}

	private String JSJLevel = "";
	//计算机水平
	public String getJSJLevel(){
		return this.JSJLevel;
	}
	public void setJSJLevel(String value){
		this.JSJLevel = value;
	}

	private int ExcelLevel = 0;
	//Eexcel
	public int getExcelLevel(){
		return this.ExcelLevel;
	}
	public void setExcelLevel(int value){
		this.ExcelLevel = value;
	}

	private String ExcelLevel_Convert="";
	public String getExcelLevel_Convert(){
		switch(String.valueOf(ExcelLevel)) {
		case "0":
			return "熟练";
		case "1":
			return "良好";
		case "2":
			return "一般";
		}
		return ExcelLevel_Convert;
	}
	public void setExcelLevel_Convert(String value){
		this.ExcelLevel_Convert = value;
	}

	private int WordLevel = 0;
	//Word
	public int getWordLevel(){
		return this.WordLevel;
	}
	public void setWordLevel(int value){
		this.WordLevel = value;
	}

	private String WordLevel_Convert="";
	public String getWordLevel_Convert(){
		switch(String.valueOf(WordLevel)) {
		case "0":
			return "熟练";
		case "1":
			return "良好";
		case "2":
			return "一般";
		}
		return WordLevel_Convert;
	}
	public void setWordLevel_Convert(String value){
		this.WordLevel_Convert = value;
	}

	private int PowerPointLevel = 0;
	//PowerPoint
	public int getPowerPointLevel(){
		return this.PowerPointLevel;
	}
	public void setPowerPointLevel(int value){
		this.PowerPointLevel = value;
	}

	private String PowerPointLevel_Convert="";
	public String getPowerPointLevel_Convert(){
		switch(String.valueOf(PowerPointLevel)) {
		case "0":
			return "熟练";
		case "1":
			return "良好";
		case "2":
			return "一般";
		}
		return PowerPointLevel_Convert;
	}
	public void setPowerPointLevel_Convert(String value){
		this.PowerPointLevel_Convert = value;
	}

	private String Reward = "";
	public String getReward(){
		return this.Reward;
	}
	public void setReward(String value){
		this.Reward = value;
	}

	private String Interests = "";
	public String getInterests(){
		return this.Interests;
	}
	public void setInterests(String value){
		this.Interests = value;
	}

	private String Works = "";
	public String getWorks(){
		return this.Works;
	}
	public void setWorks(String value){
		this.Works = value;
	}

	private int Insurance = 0;
	public int getInsurance(){
		return this.Insurance;
	}
	public void setInsurance(int value){
		this.Insurance = value;
	}

	private java.util.Date InsuranceDate = null;
	public java.util.Date getInsuranceDate(){
		return this.InsuranceDate;
	}
	public void setInsuranceDate(java.util.Date value){
		this.InsuranceDate = value;
	}

	private String Acc = "";
	public String getAcc(){
		return this.Acc;
	}
	public void setAcc(String value){
		this.Acc = value;
	}

	private boolean PartTimeJob = false;
	public boolean getPartTimeJob(){
		return this.PartTimeJob;
	}
	public void setPartTimeJob(boolean value){
		this.PartTimeJob = value;
	}

	private String PartTimeJobDesc = "";
	public String getPartTimeJobDesc(){
		return this.PartTimeJobDesc;
	}
	public void setPartTimeJobDesc(String value){
		this.PartTimeJobDesc = value;
	}

	private boolean NDA = false;
	public boolean getNDA(){
		return this.NDA;
	}
	public void setNDA(boolean value){
		this.NDA = value;
	}

	private String NDADesc = "";
	public String getNDADesc(){
		return this.NDADesc;
	}
	public void setNDADesc(String value){
		this.NDADesc = value;
	}

	private boolean Disputes = false;
	public boolean getDisputes(){
		return this.Disputes;
	}
	public void setDisputes(boolean value){
		this.Disputes = value;
	}

	private String DisputesDesc = "";
	public String getDisputesDesc(){
		return this.DisputesDesc;
	}
	public void setDisputesDesc(String value){
		this.DisputesDesc = value;
	}

	private boolean Penalties = false;
	public boolean getPenalties(){
		return this.Penalties;
	}
	public void setPenalties(boolean value){
		this.Penalties = value;
	}

	private String PenaltiesDesc = "";
	public String getPenaltiesDesc(){
		return this.PenaltiesDesc;
	}
	public void setPenaltiesDesc(String value){
		this.PenaltiesDesc = value;
	}

	private boolean Illness = false;
	public boolean getIllness(){
		return this.Illness;
	}
	public void setIllness(boolean value){
		this.Illness = value;
	}

	private String IllnessDesc = "";
	public String getIllnessDesc(){
		return this.IllnessDesc;
	}
	public void setIllnessDesc(String value){
		this.IllnessDesc = value;
	}

	private boolean Pregnant = false;
	public boolean getPregnant(){
		return this.Pregnant;
	}
	public void setPregnant(boolean value){
		this.Pregnant = value;
	}

	private String PregnantDesc = "";
	public String getPregnantDesc(){
		return this.PregnantDesc;
	}
	public void setPregnantDesc(String value){
		this.PregnantDesc = value;
	}

	private boolean Conn = false;
	public boolean getConn(){
		return this.Conn;
	}
	public void setConn(boolean value){
		this.Conn = value;
	}

	private String ConnDesc = "";
	public String getConnDesc(){
		return this.ConnDesc;
	}
	public void setConnDesc(String value){
		this.ConnDesc = value;
	}

	private java.util.Date RegisterDate = null;
	//入职日期
	public java.util.Date getRegisterDate(){
		return this.RegisterDate;
	}
	public void setRegisterDate(java.util.Date value){
		this.RegisterDate = value;
	}

	private String RegisterUser = "";
	//办理入职人员
	public String getRegisterUser(){
		return this.RegisterUser;
	}
	public void setRegisterUser(String value){
		this.RegisterUser = value;
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

	private int UserID = 0;
	//系统账号
	public int getUserID(){
		return this.UserID;
	}
	public void setUserID(int value){
		this.UserID = value;
	}

	private String UserID_Convert="";
	public String getUserID_Convert(){
		UserID_Convert = m_Staff.dictionaryService.convertDictionary("User", String.valueOf(UserID));
		if(UserID_Convert == null) UserID_Convert = "";
		return UserID_Convert;
	}
	public void setUserID_Convert(String value){
		this.UserID_Convert = value;
	}

	private String Photo = "";
	//照片
	public String getPhoto(){
		return this.Photo;
	}
	public void setPhoto(String value){
		this.Photo = value;
	}

	private int OrgID = 0;
	public int getOrgID(){
		return this.OrgID;
	}
	public void setOrgID(int value){
		this.OrgID = value;
	}

	private String OrgName = "";
	//部门
	public String getOrgName(){
		return this.OrgName;
	}
	public void setOrgName(String value){
		this.OrgName = value;
	}

	private List<StaffMembers> Members = new ArrayList<StaffMembers>();
	//家庭成员
	public List<StaffMembers> getMembers(){
		return this.Members;
	}
	public void setMembers(List<StaffMembers> value){
		this.Members = value;
	}

	private List<StaffWork> Work = new ArrayList<StaffWork>();
	//工作经历
	public List<StaffWork> getWork(){
		return this.Work;
	}
	public void setWork(List<StaffWork> value){
		this.Work = value;
	}

	private List<StaffEdu> Edu = new ArrayList<StaffEdu>();
	//教育情况
	public List<StaffEdu> getEdu(){
		return this.Edu;
	}
	public void setEdu(List<StaffEdu> value){
		this.Edu = value;
	}

}
