package org.polariscode.SecuritySystem.model.Import;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;

@Component
public class personnelImport implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static personnelImport m_personnelImport;

	@PostConstruct 
	public void init(){
		m_personnelImport=this;
		m_personnelImport.dictionaryService=this.dictionaryService;
	}

	private int ID = 0;
	public int getID(){
		return this.ID;
	}
	public void setID(int value){
		this.ID = value;
	}

	private String Code = "";
	public String getCode(){
		return this.Code;
	}
	public void setCode(String value){
		this.Code = value;
	}

	private String Name = "";
	public String getName(){
		return this.Name;
	}
	public void setName(String value){
		this.Name = value;
	}

	private String CardCode = "";
	public String getCardCode(){
		return this.CardCode;
	}
	public void setCardCode(String value){
		this.CardCode = value;
	}

	private String Birthday = "";
	public String getBirthday(){
		return this.Birthday;
	}
	public void setBirthday(String value){
		this.Birthday = value;
	}

	private int Gender = 0;
	public int getGender(){
		return this.Gender;
	}
	public void setGender(int value){
		this.Gender = value;
	}

	private int Politics = 0;
	public int getPolitics(){
		return this.Politics;
	}
	public void setPolitics(int value){
		this.Politics = value;
	}

	private int Height = 0;
	public int getHeight(){
		return this.Height;
	}
	public void setHeight(int value){
		this.Height = value;
	}

	private int Weight = 0;
	public int getWeight(){
		return this.Weight;
	}
	public void setWeight(int value){
		this.Weight = value;
	}

	private int Education = 0;
	public int getEducation(){
		return this.Education;
	}
	public void setEducation(int value){
		this.Education = value;
	}

	private int Nation = 0;
	public int getNation(){
		return this.Nation;
	}
	public void setNation(int value){
		this.Nation = value;
	}

	private int Native = 0;
	public int getNative(){
		return this.Native;
	}
	public void setNative(int value){
		this.Native = value;
	}

	private String HomeAddress = "";
	public String getHomeAddress(){
		return this.HomeAddress;
	}
	public void setHomeAddress(String value){
		this.HomeAddress = value;
	}

	private int Census = 0;
	public int getCensus(){
		return this.Census;
	}
	public void setCensus(int value){
		this.Census = value;
	}

	private String CensusAddress = "";
	public String getCensusAddress(){
		return this.CensusAddress;
	}
	public void setCensusAddress(String value){
		this.CensusAddress = value;
	}

	private int Marital = 0;
	public int getMarital(){
		return this.Marital;
	}
	public void setMarital(int value){
		this.Marital = value;
	}

	private String LinkMan = "";
	public String getLinkMan(){
		return this.LinkMan;
	}
	public void setLinkMan(String value){
		this.LinkMan = value;
	}

	private String LinkManRelation = "";
	public String getLinkManRelation(){
		return this.LinkManRelation;
	}
	public void setLinkManRelation(String value){
		this.LinkManRelation = value;
	}

	private String LinkManPhone = "";
	public String getLinkManPhone(){
		return this.LinkManPhone;
	}
	public void setLinkManPhone(String value){
		this.LinkManPhone = value;
	}

	private String Army = "";
	public String getArmy(){
		return this.Army;
	}
	public void setArmy(String value){
		this.Army = value;
	}

	private String ArmyInDate = "";
	public String getArmyInDate(){
		return this.ArmyInDate;
	}
	public void setArmyInDate(String value){
		this.ArmyInDate = value;
	}

	private String ArmyOutDate = "";
	public String getArmyOutDate(){
		return this.ArmyOutDate;
	}
	public void setArmyOutDate(String value){
		this.ArmyOutDate = value;
	}

	private boolean Z1 = false;
	public boolean getZ1(){
		return this.Z1;
	}
	public void setZ1(boolean value){
		this.Z1 = value;
	}

	private boolean Z2 = false;
	public boolean getZ2(){
		return this.Z2;
	}
	public void setZ2(boolean value){
		this.Z2 = value;
	}

	private boolean Z3 = false;
	public boolean getZ3(){
		return this.Z3;
	}
	public void setZ3(boolean value){
		this.Z3 = value;
	}

	private boolean Z4 = false;
	public boolean getZ4(){
		return this.Z4;
	}
	public void setZ4(boolean value){
		this.Z4 = value;
	}

	private boolean Z5 = false;
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
	public int getComputer(){
		return this.Computer;
	}
	public void setComputer(int value){
		this.Computer = value;
	}

	private int English = 0;
	public int getEnglish(){
		return this.English;
	}
	public void setEnglish(int value){
		this.English = value;
	}

	private boolean PartTime = false;
	public boolean getPartTime(){
		return this.PartTime;
	}
	public void setPartTime(boolean value){
		this.PartTime = value;
	}

	private boolean Disease = false;
	public boolean getDisease(){
		return this.Disease;
	}
	public void setDisease(boolean value){
		this.Disease = value;
	}

	private boolean Crime = false;
	public boolean getCrime(){
		return this.Crime;
	}
	public void setCrime(boolean value){
		this.Crime = value;
	}

	private String Appearance = "";
	public String getAppearance(){
		return this.Appearance;
	}
	public void setAppearance(String value){
		this.Appearance = value;
	}

	private String Communication = "";
	public String getCommunication(){
		return this.Communication;
	}
	public void setCommunication(String value){
		this.Communication = value;
	}

	private int Source = 0;
	public int getSource(){
		return this.Source;
	}
	public void setSource(int value){
		this.Source = value;
	}

	private String InDate = "";
	public String getInDate(){
		return this.InDate;
	}
	public void setInDate(String value){
		this.InDate = value;
	}

	private String HTBeginDate = "";
	public String getHTBeginDate(){
		return this.HTBeginDate;
	}
	public void setHTBeginDate(String value){
		this.HTBeginDate = value;
	}

	private String HTEndDate = "";
	public String getHTEndDate(){
		return this.HTEndDate;
	}
	public void setHTEndDate(String value){
		this.HTEndDate = value;
	}

	private boolean Photo = false;
	public boolean getPhoto(){
		return this.Photo;
	}
	public void setPhoto(boolean value){
		this.Photo = value;
	}

	private int PhotoCount = 0;
	public int getPhotoCount(){
		return this.PhotoCount;
	}
	public void setPhotoCount(int value){
		this.PhotoCount = value;
	}

	private boolean F1 = false;
	public boolean getF1(){
		return this.F1;
	}
	public void setF1(boolean value){
		this.F1 = value;
	}

	private boolean F2 = false;
	public boolean getF2(){
		return this.F2;
	}
	public void setF2(boolean value){
		this.F2 = value;
	}

	private boolean F3 = false;
	public boolean getF3(){
		return this.F3;
	}
	public void setF3(boolean value){
		this.F3 = value;
	}

	private boolean F4 = false;
	public boolean getF4(){
		return this.F4;
	}
	public void setF4(boolean value){
		this.F4 = value;
	}

	private boolean F5 = false;
	public boolean getF5(){
		return this.F5;
	}
	public void setF5(boolean value){
		this.F5 = value;
	}

	private boolean F6 = false;
	public boolean getF6(){
		return this.F6;
	}
	public void setF6(boolean value){
		this.F6 = value;
	}

	private boolean F7 = false;
	public boolean getF7(){
		return this.F7;
	}
	public void setF7(boolean value){
		this.F7 = value;
	}

	private boolean F8 = false;
	public boolean getF8(){
		return this.F8;
	}
	public void setF8(boolean value){
		this.F8 = value;
	}

	private boolean F9 = false;
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
	public String getGeneralComment(){
		return this.GeneralComment;
	}
	public void setGeneralComment(String value){
		this.GeneralComment = value;
	}

	private String InterViewer = "";
	public String getInterViewer(){
		return this.InterViewer;
	}
	public void setInterViewer(String value){
		this.InterViewer = value;
	}

	private boolean GivePost = false;
	public boolean getGivePost(){
		return this.GivePost;
	}
	public void setGivePost(boolean value){
		this.GivePost = value;
	}

	private String PlanSite = "";
	public String getPlanSite(){
		return this.PlanSite;
	}
	public void setPlanSite(String value){
		this.PlanSite = value;
	}

	private String PlantJob = "";
	public String getPlantJob(){
		return this.PlantJob;
	}
	public void setPlantJob(String value){
		this.PlantJob = value;
	}

	private String PlanInDate = "";
	public String getPlanInDate(){
		return this.PlanInDate;
	}
	public void setPlanInDate(String value){
		this.PlanInDate = value;
	}

	private String CheckUser = "";
	public String getCheckUser(){
		return this.CheckUser;
	}
	public void setCheckUser(String value){
		this.CheckUser = value;
	}

	private String HRUser = "";
	public String getHRUser(){
		return this.HRUser;
	}
	public void setHRUser(String value){
		this.HRUser = value;
	}

	private String JobUser = "";
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

	private String CreateTime = "";
	public String getCreateTime(){
		return this.CreateTime;
	}
	public void setCreateTime(String value){
		this.CreateTime = value;
	}

	private String ModifyUser = "";
	public String getModifyUser(){
		return this.ModifyUser;
	}
	public void setModifyUser(String value){
		this.ModifyUser = value;
	}

	private String ModifyTime = "";
	public String getModifyTime(){
		return this.ModifyTime;
	}
	public void setModifyTime(String value){
		this.ModifyTime = value;
	}

	private String DeleteUser = "";
	public String getDeleteUser(){
		return this.DeleteUser;
	}
	public void setDeleteUser(String value){
		this.DeleteUser = value;
	}

	private String DeleteTime = "";
	public String getDeleteTime(){
		return this.DeleteTime;
	}
	public void setDeleteTime(String value){
		this.DeleteTime = value;
	}

}
