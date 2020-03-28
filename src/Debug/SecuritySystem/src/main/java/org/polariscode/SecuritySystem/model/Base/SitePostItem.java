package org.polariscode.SecuritySystem.model.Base;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;

//执勤配置表明细
@Component
public class SitePostItem implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static SitePostItem m_SitePostItem;

	@PostConstruct 
	public void init(){
		m_SitePostItem=this;
		m_SitePostItem.dictionaryService=this.dictionaryService;
	}

	private int ID = 0;
	public int getID(){
		return this.ID;
	}
	public void setID(int value){
		this.ID = value;
	}

	private int SitePostId = 0;
	public int getSitePostId(){
		return this.SitePostId;
	}
	public void setSitePostId(int value){
		this.SitePostId = value;
	}

	private String Post = "";
	//岗位
	public String getPost(){
		return this.Post;
	}
	public void setPost(String value){
		this.Post = value;
	}

	private int Schedule = 0;
	//班次
	public int getSchedule(){
		return this.Schedule;
	}
	public void setSchedule(int value){
		this.Schedule = value;
	}

	private String Schedule_Convert="";
	public String getSchedule_Convert(){
		switch(String.valueOf(Schedule)) {
		case "0":
			return "白班";
		case "1":
			return "夜班";
		}
		return Schedule_Convert;
	}
	public void setSchedule_Convert(String value){
		this.Schedule_Convert = value;
	}

	private int Type = 0;
	//类型
	public int getType(){
		return this.Type;
	}
	public void setType(int value){
		this.Type = value;
	}

	private String Type_Convert="";
	public String getType_Convert(){
		switch(String.valueOf(Type)) {
		case "0":
			return "全年无休";
		case "1":
			return "作五休二";
		case "2":
			return "特殊";
		}
		return Type_Convert;
	}
	public void setType_Convert(String value){
		this.Type_Convert = value;
	}

	private String BeginTime = "";
	//开始时间
	public String getBeginTime(){
		return this.BeginTime;
	}
	public void setBeginTime(String value){
		this.BeginTime = value;
	}

	private String BeginTime_Convert="";
	public String getBeginTime_Convert(){
		switch(String.valueOf(BeginTime)) {
		case "0000":
			return "00:00";
		case "0030":
			return "00:30";
		case "0100":
			return "01:00";
		case "0130":
			return "01:30";
		case "0200":
			return "02:00";
		case "0230":
			return "02:30";
		case "0300":
			return "03:00";
		case "0330":
			return "03:30";
		case "0400":
			return "04:00";
		case "0430":
			return "04:30";
		case "0500":
			return "05:00";
		case "0530":
			return "05:30";
		case "0600":
			return "06:00";
		case "0630":
			return "06:30";
		case "0700":
			return "07:00";
		case "0730":
			return "07:30";
		case "0800":
			return "08:00";
		case "0830":
			return "08:30";
		case "0900":
			return "09:00";
		case "0930":
			return "09:30";
		case "1000":
			return "10:00";
		case "1030":
			return "10:30";
		case "1100":
			return "11:00";
		case "1130":
			return "11:30";
		case "1200":
			return "12:00";
		case "1230":
			return "12:30";
		case "1300":
			return "13:00";
		case "1330":
			return "13:30";
		case "1400":
			return "14:00";
		case "1430":
			return "14:30";
		case "1500":
			return "15:00";
		case "1530":
			return "15:30";
		case "1600":
			return "16:00";
		case "1630":
			return "16:30";
		case "1700":
			return "17:00";
		case "1730":
			return "17:30";
		case "1800":
			return "18:00";
		case "1830":
			return "18:30";
		case "1900":
			return "19:00";
		case "1930":
			return "19:30";
		case "2000":
			return "20:00";
		case "2030":
			return "20:30";
		case "2100":
			return "21:00";
		case "2130":
			return "21:30";
		case "2200":
			return "22:00";
		case "2230":
			return "22:30";
		case "2300":
			return "23:00";
		case "2330":
			return "23:30";
		}
		return BeginTime_Convert;
	}
	public void setBeginTime_Convert(String value){
		this.BeginTime_Convert = value;
	}

	private String EndTime = "";
	//结束时间
	public String getEndTime(){
		return this.EndTime;
	}
	public void setEndTime(String value){
		this.EndTime = value;
	}

	private String EndTime_Convert="";
	public String getEndTime_Convert(){
		switch(String.valueOf(EndTime)) {
		case "0000":
			return "00:00";
		case "0030":
			return "00:30";
		case "0100":
			return "01:00";
		case "0130":
			return "01:30";
		case "0200":
			return "02:00";
		case "0230":
			return "02:30";
		case "0300":
			return "03:00";
		case "0330":
			return "03:30";
		case "0400":
			return "04:00";
		case "0430":
			return "04:30";
		case "0500":
			return "05:00";
		case "0530":
			return "05:30";
		case "0600":
			return "06:00";
		case "0630":
			return "06:30";
		case "0700":
			return "07:00";
		case "0730":
			return "07:30";
		case "0800":
			return "08:00";
		case "0830":
			return "08:30";
		case "0900":
			return "09:00";
		case "0930":
			return "09:30";
		case "1000":
			return "10:00";
		case "1030":
			return "10:30";
		case "1100":
			return "11:00";
		case "1130":
			return "11:30";
		case "1200":
			return "12:00";
		case "1230":
			return "12:30";
		case "1300":
			return "13:00";
		case "1330":
			return "13:30";
		case "1400":
			return "14:00";
		case "1430":
			return "14:30";
		case "1500":
			return "15:00";
		case "1530":
			return "15:30";
		case "1600":
			return "16:00";
		case "1630":
			return "16:30";
		case "1700":
			return "17:00";
		case "1730":
			return "17:30";
		case "1800":
			return "18:00";
		case "1830":
			return "18:30";
		case "1900":
			return "19:00";
		case "1930":
			return "19:30";
		case "2000":
			return "20:00";
		case "2030":
			return "20:30";
		case "2100":
			return "21:00";
		case "2130":
			return "21:30";
		case "2200":
			return "22:00";
		case "2230":
			return "22:30";
		case "2300":
			return "23:00";
		case "2330":
			return "23:30";
		}
		return EndTime_Convert;
	}
	public void setEndTime_Convert(String value){
		this.EndTime_Convert = value;
	}

	private int PosNumber = 0;
	//在岗人数
	public int getPosNumber(){
		return this.PosNumber;
	}
	public void setPosNumber(int value){
		this.PosNumber = value;
	}

	private int ContractNumber = 0;
	//合同人数
	public int getContractNumber(){
		return this.ContractNumber;
	}
	public void setContractNumber(int value){
		this.ContractNumber = value;
	}

	private double WorkNumber = 0.0;
	//编制人数
	public double getWorkNumber(){
		return this.WorkNumber;
	}
	public void setWorkNumber(double value){
		this.WorkNumber = value;
	}

	private java.util.Date BeginDate = null;
	//开始日期
	public java.util.Date getBeginDate(){
		return this.BeginDate;
	}
	public void setBeginDate(java.util.Date value){
		this.BeginDate = value;
	}

	private java.util.Date EndDate = null;
	//结束日期
	public java.util.Date getEndDate(){
		return this.EndDate;
	}
	public void setEndDate(java.util.Date value){
		this.EndDate = value;
	}

	private boolean Day1 = false;
	//一
	public boolean getDay1(){
		return this.Day1;
	}
	public void setDay1(boolean value){
		this.Day1 = value;
	}

	private boolean Day2 = false;
	//二
	public boolean getDay2(){
		return this.Day2;
	}
	public void setDay2(boolean value){
		this.Day2 = value;
	}

	private boolean Day3 = false;
	//三
	public boolean getDay3(){
		return this.Day3;
	}
	public void setDay3(boolean value){
		this.Day3 = value;
	}

	private boolean Day4 = false;
	//四
	public boolean getDay4(){
		return this.Day4;
	}
	public void setDay4(boolean value){
		this.Day4 = value;
	}

	private boolean Day5 = false;
	//五
	public boolean getDay5(){
		return this.Day5;
	}
	public void setDay5(boolean value){
		this.Day5 = value;
	}

	private boolean Day6 = false;
	//六
	public boolean getDay6(){
		return this.Day6;
	}
	public void setDay6(boolean value){
		this.Day6 = value;
	}

	private boolean Day7 = false;
	//日
	public boolean getDay7(){
		return this.Day7;
	}
	public void setDay7(boolean value){
		this.Day7 = value;
	}

	private boolean DayH = false;
	//节假日
	public boolean getDayH(){
		return this.DayH;
	}
	public void setDayH(boolean value){
		this.DayH = value;
	}

	private int CalcTime = 0;
	//核算工时
	public int getCalcTime(){
		return this.CalcTime;
	}
	public void setCalcTime(int value){
		this.CalcTime = value;
	}

	private int FullTime = 0;
	//满勤工时
	public int getFullTime(){
		return this.FullTime;
	}
	public void setFullTime(int value){
		this.FullTime = value;
	}

	private String Describes = "";
	//备注
	public String getDescribes(){
		return this.Describes;
	}
	public void setDescribes(String value){
		this.Describes = value;
	}

	private int OldId = 0;
	public int getOldId(){
		return this.OldId;
	}
	public void setOldId(int value){
		this.OldId = value;
	}

}
