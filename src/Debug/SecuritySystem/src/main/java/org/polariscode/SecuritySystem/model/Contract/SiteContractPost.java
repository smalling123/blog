package org.polariscode.SecuritySystem.model.Contract;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;

@Component
public class SiteContractPost implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static SiteContractPost m_SiteContractPost;

	@PostConstruct 
	public void init(){
		m_SiteContractPost=this;
		m_SiteContractPost.dictionaryService=this.dictionaryService;
	}

	private int ID = 0;
	public int getID(){
		return this.ID;
	}
	public void setID(int value){
		this.ID = value;
	}

	private int SiteContractId = 0;
	public int getSiteContractId(){
		return this.SiteContractId;
	}
	public void setSiteContractId(int value){
		this.SiteContractId = value;
	}

	private String Post = "";
	public String getPost(){
		return this.Post;
	}
	public void setPost(String value){
		this.Post = value;
	}

	private int Schedule = 0;
	public int getSchedule(){
		return this.Schedule;
	}
	public void setSchedule(int value){
		this.Schedule = value;
	}

	private int Type = 0;
	public int getType(){
		return this.Type;
	}
	public void setType(int value){
		this.Type = value;
	}

	private String BeginTime = "";
	public String getBeginTime(){
		return this.BeginTime;
	}
	public void setBeginTime(String value){
		this.BeginTime = value;
	}

	private String EndTime = "";
	public String getEndTime(){
		return this.EndTime;
	}
	public void setEndTime(String value){
		this.EndTime = value;
	}

	private int PosNumber = 0;
	public int getPosNumber(){
		return this.PosNumber;
	}
	public void setPosNumber(int value){
		this.PosNumber = value;
	}

	private int ContractNumber = 0;
	public int getContractNumber(){
		return this.ContractNumber;
	}
	public void setContractNumber(int value){
		this.ContractNumber = value;
	}

	private double WorkNumber = 0.0;
	public double getWorkNumber(){
		return this.WorkNumber;
	}
	public void setWorkNumber(double value){
		this.WorkNumber = value;
	}

	private java.util.Date BeginDate = null;
	public java.util.Date getBeginDate(){
		return this.BeginDate;
	}
	public void setBeginDate(java.util.Date value){
		this.BeginDate = value;
	}

	private java.util.Date EndDate = null;
	public java.util.Date getEndDate(){
		return this.EndDate;
	}
	public void setEndDate(java.util.Date value){
		this.EndDate = value;
	}

	private boolean Day1 = false;
	public boolean getDay1(){
		return this.Day1;
	}
	public void setDay1(boolean value){
		this.Day1 = value;
	}

	private boolean Day2 = false;
	public boolean getDay2(){
		return this.Day2;
	}
	public void setDay2(boolean value){
		this.Day2 = value;
	}

	private boolean Day3 = false;
	public boolean getDay3(){
		return this.Day3;
	}
	public void setDay3(boolean value){
		this.Day3 = value;
	}

	private boolean Day4 = false;
	public boolean getDay4(){
		return this.Day4;
	}
	public void setDay4(boolean value){
		this.Day4 = value;
	}

	private boolean Day5 = false;
	public boolean getDay5(){
		return this.Day5;
	}
	public void setDay5(boolean value){
		this.Day5 = value;
	}

	private boolean Day6 = false;
	public boolean getDay6(){
		return this.Day6;
	}
	public void setDay6(boolean value){
		this.Day6 = value;
	}

	private boolean Day7 = false;
	public boolean getDay7(){
		return this.Day7;
	}
	public void setDay7(boolean value){
		this.Day7 = value;
	}

	private boolean DayH = false;
	public boolean getDayH(){
		return this.DayH;
	}
	public void setDayH(boolean value){
		this.DayH = value;
	}

	private int CalcTime = 0;
	public int getCalcTime(){
		return this.CalcTime;
	}
	public void setCalcTime(int value){
		this.CalcTime = value;
	}

	private String Describes = "";
	public String getDescribes(){
		return this.Describes;
	}
	public void setDescribes(String value){
		this.Describes = value;
	}

	private int FullTime = 0;
	public int getFullTime(){
		return this.FullTime;
	}
	public void setFullTime(int value){
		this.FullTime = value;
	}

	private int SalaryType = 0;
	public int getSalaryType(){
		return this.SalaryType;
	}
	public void setSalaryType(int value){
		this.SalaryType = value;
	}

	private double SalaryBase = 0.0;
	public double getSalaryBase(){
		return this.SalaryBase;
	}
	public void setSalaryBase(double value){
		this.SalaryBase = value;
	}

}
