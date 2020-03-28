package org.polariscode.SecuritySystem.model.SiteManage;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;

@Component
public class Schedule implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static Schedule m_Schedule;

	@PostConstruct 
	public void init(){
		m_Schedule=this;
		m_Schedule.dictionaryService=this.dictionaryService;
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

	private String BeginTime = "";
	//上班时间
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
	//下班时间
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

	private java.util.Date D1Date = null;
	//1日期
	public java.util.Date getD1Date(){
		return this.D1Date;
	}
	public void setD1Date(java.util.Date value){
		this.D1Date = value;
	}

	private int D1SpiId = 0;
	//1执勤表明细ID
	public int getD1SpiId(){
		return this.D1SpiId;
	}
	public void setD1SpiId(int value){
		this.D1SpiId = value;
	}

	private int D1SID = 0;
	//1排班表ID
	public int getD1SID(){
		return this.D1SID;
	}
	public void setD1SID(int value){
		this.D1SID = value;
	}

	private int D1PID = 0;
	//1员工
	public int getD1PID(){
		return this.D1PID;
	}
	public void setD1PID(int value){
		this.D1PID = value;
	}

	private String D1PID_Convert="";
	public String getD1PID_Convert(){
		D1PID_Convert = m_Schedule.dictionaryService.convertDictionary("PersonnelEx", String.valueOf(D1PID));
		if(D1PID_Convert == null) D1PID_Convert = "";
		return D1PID_Convert;
	}
	public void setD1PID_Convert(String value){
		this.D1PID_Convert = value;
	}

	private int D1Status = 0;
	//1考勤状态
	public int getD1Status(){
		return this.D1Status;
	}
	public void setD1Status(int value){
		this.D1Status = value;
	}

	private String D1Status_Convert="";
	public String getD1Status_Convert(){
		switch(String.valueOf(D1Status)) {
		case "0":
			return "未考勤";
		case "1":
			return "正常";
		case "5":
			return "缺勤";
		}
		return D1Status_Convert;
	}
	public void setD1Status_Convert(String value){
		this.D1Status_Convert = value;
	}

	private java.util.Date D2Date = null;
	//2日期
	public java.util.Date getD2Date(){
		return this.D2Date;
	}
	public void setD2Date(java.util.Date value){
		this.D2Date = value;
	}

	private int D2SpiId = 0;
	//2执勤表明细ID
	public int getD2SpiId(){
		return this.D2SpiId;
	}
	public void setD2SpiId(int value){
		this.D2SpiId = value;
	}

	private int D2SID = 0;
	//2排班表ID
	public int getD2SID(){
		return this.D2SID;
	}
	public void setD2SID(int value){
		this.D2SID = value;
	}

	private int D2PID = 0;
	//2员工
	public int getD2PID(){
		return this.D2PID;
	}
	public void setD2PID(int value){
		this.D2PID = value;
	}

	private String D2PID_Convert="";
	public String getD2PID_Convert(){
		D2PID_Convert = m_Schedule.dictionaryService.convertDictionary("PersonnelEx", String.valueOf(D2PID));
		if(D2PID_Convert == null) D2PID_Convert = "";
		return D2PID_Convert;
	}
	public void setD2PID_Convert(String value){
		this.D2PID_Convert = value;
	}

	private int D2Status = 0;
	//2考勤状态
	public int getD2Status(){
		return this.D2Status;
	}
	public void setD2Status(int value){
		this.D2Status = value;
	}

	private String D2Status_Convert="";
	public String getD2Status_Convert(){
		switch(String.valueOf(D2Status)) {
		case "0":
			return "未考勤";
		case "1":
			return "正常";
		case "5":
			return "缺勤";
		}
		return D2Status_Convert;
	}
	public void setD2Status_Convert(String value){
		this.D2Status_Convert = value;
	}

	private java.util.Date D3Date = null;
	//3日期
	public java.util.Date getD3Date(){
		return this.D3Date;
	}
	public void setD3Date(java.util.Date value){
		this.D3Date = value;
	}

	private int D3SpiId = 0;
	//3执勤表明细ID
	public int getD3SpiId(){
		return this.D3SpiId;
	}
	public void setD3SpiId(int value){
		this.D3SpiId = value;
	}

	private int D3SID = 0;
	//3排班表ID
	public int getD3SID(){
		return this.D3SID;
	}
	public void setD3SID(int value){
		this.D3SID = value;
	}

	private int D3PID = 0;
	//3员工
	public int getD3PID(){
		return this.D3PID;
	}
	public void setD3PID(int value){
		this.D3PID = value;
	}

	private String D3PID_Convert="";
	public String getD3PID_Convert(){
		D3PID_Convert = m_Schedule.dictionaryService.convertDictionary("PersonnelEx", String.valueOf(D3PID));
		if(D3PID_Convert == null) D3PID_Convert = "";
		return D3PID_Convert;
	}
	public void setD3PID_Convert(String value){
		this.D3PID_Convert = value;
	}

	private int D3Status = 0;
	//3考勤状态
	public int getD3Status(){
		return this.D3Status;
	}
	public void setD3Status(int value){
		this.D3Status = value;
	}

	private String D3Status_Convert="";
	public String getD3Status_Convert(){
		switch(String.valueOf(D3Status)) {
		case "0":
			return "未考勤";
		case "1":
			return "正常";
		case "5":
			return "缺勤";
		}
		return D3Status_Convert;
	}
	public void setD3Status_Convert(String value){
		this.D3Status_Convert = value;
	}

	private java.util.Date D4Date = null;
	//4日期
	public java.util.Date getD4Date(){
		return this.D4Date;
	}
	public void setD4Date(java.util.Date value){
		this.D4Date = value;
	}

	private int D4SpiId = 0;
	//4执勤表明细ID
	public int getD4SpiId(){
		return this.D4SpiId;
	}
	public void setD4SpiId(int value){
		this.D4SpiId = value;
	}

	private int D4SID = 0;
	//4排班表ID
	public int getD4SID(){
		return this.D4SID;
	}
	public void setD4SID(int value){
		this.D4SID = value;
	}

	private int D4PID = 0;
	//4员工
	public int getD4PID(){
		return this.D4PID;
	}
	public void setD4PID(int value){
		this.D4PID = value;
	}

	private String D4PID_Convert="";
	public String getD4PID_Convert(){
		D4PID_Convert = m_Schedule.dictionaryService.convertDictionary("PersonnelEx", String.valueOf(D4PID));
		if(D4PID_Convert == null) D4PID_Convert = "";
		return D4PID_Convert;
	}
	public void setD4PID_Convert(String value){
		this.D4PID_Convert = value;
	}

	private int D4Status = 0;
	//4考勤状态
	public int getD4Status(){
		return this.D4Status;
	}
	public void setD4Status(int value){
		this.D4Status = value;
	}

	private String D4Status_Convert="";
	public String getD4Status_Convert(){
		switch(String.valueOf(D4Status)) {
		case "0":
			return "未考勤";
		case "1":
			return "正常";
		case "5":
			return "缺勤";
		}
		return D4Status_Convert;
	}
	public void setD4Status_Convert(String value){
		this.D4Status_Convert = value;
	}

	private java.util.Date D5Date = null;
	//5日期
	public java.util.Date getD5Date(){
		return this.D5Date;
	}
	public void setD5Date(java.util.Date value){
		this.D5Date = value;
	}

	private int D5SpiId = 0;
	//5执勤表明细ID
	public int getD5SpiId(){
		return this.D5SpiId;
	}
	public void setD5SpiId(int value){
		this.D5SpiId = value;
	}

	private int D5SID = 0;
	//5排班表ID
	public int getD5SID(){
		return this.D5SID;
	}
	public void setD5SID(int value){
		this.D5SID = value;
	}

	private int D5PID = 0;
	//5员工
	public int getD5PID(){
		return this.D5PID;
	}
	public void setD5PID(int value){
		this.D5PID = value;
	}

	private String D5PID_Convert="";
	public String getD5PID_Convert(){
		D5PID_Convert = m_Schedule.dictionaryService.convertDictionary("PersonnelEx", String.valueOf(D5PID));
		if(D5PID_Convert == null) D5PID_Convert = "";
		return D5PID_Convert;
	}
	public void setD5PID_Convert(String value){
		this.D5PID_Convert = value;
	}

	private int D5Status = 0;
	//5考勤状态
	public int getD5Status(){
		return this.D5Status;
	}
	public void setD5Status(int value){
		this.D5Status = value;
	}

	private String D5Status_Convert="";
	public String getD5Status_Convert(){
		switch(String.valueOf(D5Status)) {
		case "0":
			return "未考勤";
		case "1":
			return "正常";
		case "5":
			return "缺勤";
		}
		return D5Status_Convert;
	}
	public void setD5Status_Convert(String value){
		this.D5Status_Convert = value;
	}

	private java.util.Date D6Date = null;
	//6日期
	public java.util.Date getD6Date(){
		return this.D6Date;
	}
	public void setD6Date(java.util.Date value){
		this.D6Date = value;
	}

	private int D6SpiId = 0;
	//6执勤表明细ID
	public int getD6SpiId(){
		return this.D6SpiId;
	}
	public void setD6SpiId(int value){
		this.D6SpiId = value;
	}

	private int D6SID = 0;
	//6排班表ID
	public int getD6SID(){
		return this.D6SID;
	}
	public void setD6SID(int value){
		this.D6SID = value;
	}

	private int D6PID = 0;
	//6员工
	public int getD6PID(){
		return this.D6PID;
	}
	public void setD6PID(int value){
		this.D6PID = value;
	}

	private String D6PID_Convert="";
	public String getD6PID_Convert(){
		D6PID_Convert = m_Schedule.dictionaryService.convertDictionary("PersonnelEx", String.valueOf(D6PID));
		if(D6PID_Convert == null) D6PID_Convert = "";
		return D6PID_Convert;
	}
	public void setD6PID_Convert(String value){
		this.D6PID_Convert = value;
	}

	private int D6Status = 0;
	//6考勤状态
	public int getD6Status(){
		return this.D6Status;
	}
	public void setD6Status(int value){
		this.D6Status = value;
	}

	private String D6Status_Convert="";
	public String getD6Status_Convert(){
		switch(String.valueOf(D6Status)) {
		case "0":
			return "未考勤";
		case "1":
			return "正常";
		case "5":
			return "缺勤";
		}
		return D6Status_Convert;
	}
	public void setD6Status_Convert(String value){
		this.D6Status_Convert = value;
	}

	private java.util.Date D7Date = null;
	//7日期
	public java.util.Date getD7Date(){
		return this.D7Date;
	}
	public void setD7Date(java.util.Date value){
		this.D7Date = value;
	}

	private int D7SpiId = 0;
	//7执勤表明细ID
	public int getD7SpiId(){
		return this.D7SpiId;
	}
	public void setD7SpiId(int value){
		this.D7SpiId = value;
	}

	private int D7SID = 0;
	//7排班表ID
	public int getD7SID(){
		return this.D7SID;
	}
	public void setD7SID(int value){
		this.D7SID = value;
	}

	private int D7PID = 0;
	//7员工
	public int getD7PID(){
		return this.D7PID;
	}
	public void setD7PID(int value){
		this.D7PID = value;
	}

	private String D7PID_Convert="";
	public String getD7PID_Convert(){
		D7PID_Convert = m_Schedule.dictionaryService.convertDictionary("PersonnelEx", String.valueOf(D7PID));
		if(D7PID_Convert == null) D7PID_Convert = "";
		return D7PID_Convert;
	}
	public void setD7PID_Convert(String value){
		this.D7PID_Convert = value;
	}

	private int D7Status = 0;
	//7考勤状态
	public int getD7Status(){
		return this.D7Status;
	}
	public void setD7Status(int value){
		this.D7Status = value;
	}

	private String D7Status_Convert="";
	public String getD7Status_Convert(){
		switch(String.valueOf(D7Status)) {
		case "0":
			return "未考勤";
		case "1":
			return "正常";
		case "5":
			return "缺勤";
		}
		return D7Status_Convert;
	}
	public void setD7Status_Convert(String value){
		this.D7Status_Convert = value;
	}

}
