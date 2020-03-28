package org.polariscode.SecuritySystem.model.Salary;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;

@Component
public class InsuranceItem implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static InsuranceItem m_InsuranceItem;

	@PostConstruct 
	public void init(){
		m_InsuranceItem=this;
		m_InsuranceItem.dictionaryService=this.dictionaryService;
	}

	private int ID = 0;
	public int getID(){
		return this.ID;
	}
	public void setID(int value){
		this.ID = value;
	}

	private int InsuranceId = 0;
	//社保
	public int getInsuranceId(){
		return this.InsuranceId;
	}
	public void setInsuranceId(int value){
		this.InsuranceId = value;
	}

	private int Year = 0;
	//年
	public int getYear(){
		return this.Year;
	}
	public void setYear(int value){
		this.Year = value;
	}

	private String Year_Convert="";
	public String getYear_Convert(){
		switch(String.valueOf(Year)) {
		case "2019":
			return "2019";
		case "2020":
			return "2020";
		case "2021":
			return "2021";
		case "2022":
			return "2022";
		case "2023":
			return "2023";
		case "2024":
			return "2024";
		case "2025":
			return "2025";
		case "2026":
			return "2026";
		case "2027":
			return "2027";
		case "2028":
			return "2028";
		case "2029":
			return "2029";
		case "2030":
			return "2030";
		case "2031":
			return "2031";
		case "2032":
			return "2032";
		case "2033":
			return "2033";
		case "2034":
			return "2034";
		case "2035":
			return "2035";
		case "2036":
			return "2036";
		case "2037":
			return "2037";
		case "2038":
			return "2038";
		case "2039":
			return "2039";
		case "2040":
			return "2040";
		}
		return Year_Convert;
	}
	public void setYear_Convert(String value){
		this.Year_Convert = value;
	}

	private int Month = 0;
	//月
	public int getMonth(){
		return this.Month;
	}
	public void setMonth(int value){
		this.Month = value;
	}

	private String Month_Convert="";
	public String getMonth_Convert(){
		switch(String.valueOf(Month)) {
		case "1":
			return "01";
		case "2":
			return "02";
		case "3":
			return "03";
		case "4":
			return "04";
		case "5":
			return "05";
		case "6":
			return "06";
		case "7":
			return "07";
		case "8":
			return "08";
		case "9":
			return "09";
		case "10":
			return "10";
		case "11":
			return "11";
		case "12":
			return "12";
		}
		return Month_Convert;
	}
	public void setMonth_Convert(String value){
		this.Month_Convert = value;
	}

	private double BaseMin = 0.0;
	//最低基数
	public double getBaseMin(){
		return this.BaseMin;
	}
	public void setBaseMin(double value){
		this.BaseMin = value;
	}

	private double BaseMax = 0.0;
	//最高基数
	public double getBaseMax(){
		return this.BaseMax;
	}
	public void setBaseMax(double value){
		this.BaseMax = value;
	}

	private double CTotalRate = 0.0;
	//企业总比率
	public double getCTotalRate(){
		return this.CTotalRate;
	}
	public void setCTotalRate(double value){
		this.CTotalRate = value;
	}

	private double CTotalValue = 0.0;
	//企业总缴纳额
	public double getCTotalValue(){
		return this.CTotalValue;
	}
	public void setCTotalValue(double value){
		this.CTotalValue = value;
	}

	private double C1Rate = 0.0;
	//企业养老比率
	public double getC1Rate(){
		return this.C1Rate;
	}
	public void setC1Rate(double value){
		this.C1Rate = value;
	}

	private double C1Value = 0.0;
	//企业养老最低缴纳额
	public double getC1Value(){
		return this.C1Value;
	}
	public void setC1Value(double value){
		this.C1Value = value;
	}

	private double C2Rate = 0.0;
	//企业医疗比率
	public double getC2Rate(){
		return this.C2Rate;
	}
	public void setC2Rate(double value){
		this.C2Rate = value;
	}

	private double C2Value = 0.0;
	//企业医疗最低缴纳额
	public double getC2Value(){
		return this.C2Value;
	}
	public void setC2Value(double value){
		this.C2Value = value;
	}

	private double C3Rate = 0.0;
	//企业失业比率
	public double getC3Rate(){
		return this.C3Rate;
	}
	public void setC3Rate(double value){
		this.C3Rate = value;
	}

	private double C3Value = 0.0;
	//企业失业最低缴纳额
	public double getC3Value(){
		return this.C3Value;
	}
	public void setC3Value(double value){
		this.C3Value = value;
	}

	private double C4Rate = 0.0;
	//企业工伤比率
	public double getC4Rate(){
		return this.C4Rate;
	}
	public void setC4Rate(double value){
		this.C4Rate = value;
	}

	private double C4Value = 0.0;
	//企业工伤最低缴纳额
	public double getC4Value(){
		return this.C4Value;
	}
	public void setC4Value(double value){
		this.C4Value = value;
	}

	private double C5Rate = 0.0;
	//企业生育比率
	public double getC5Rate(){
		return this.C5Rate;
	}
	public void setC5Rate(double value){
		this.C5Rate = value;
	}

	private double C5Value = 0.0;
	//企业生育最低缴纳额
	public double getC5Value(){
		return this.C5Value;
	}
	public void setC5Value(double value){
		this.C5Value = value;
	}

	private double C6Rate = 0.0;
	//企业残疾比率
	public double getC6Rate(){
		return this.C6Rate;
	}
	public void setC6Rate(double value){
		this.C6Rate = value;
	}

	private double C6Value = 0.0;
	//企业残疾最低缴纳额
	public double getC6Value(){
		return this.C6Value;
	}
	public void setC6Value(double value){
		this.C6Value = value;
	}

	private double P1Rate = 0.0;
	//个人养老比率
	public double getP1Rate(){
		return this.P1Rate;
	}
	public void setP1Rate(double value){
		this.P1Rate = value;
	}

	private double P1Value = 0.0;
	//个人养老最低缴纳额
	public double getP1Value(){
		return this.P1Value;
	}
	public void setP1Value(double value){
		this.P1Value = value;
	}

	private double P2Rate = 0.0;
	//个人医疗比率
	public double getP2Rate(){
		return this.P2Rate;
	}
	public void setP2Rate(double value){
		this.P2Rate = value;
	}

	private double P3Rate = 0.0;
	//个人医疗最低缴纳额
	public double getP3Rate(){
		return this.P3Rate;
	}
	public void setP3Rate(double value){
		this.P3Rate = value;
	}

	private double P2Value = 0.0;
	//个人失业比率
	public double getP2Value(){
		return this.P2Value;
	}
	public void setP2Value(double value){
		this.P2Value = value;
	}

	private double P3Value = 0.0;
	//个人失业最低缴纳额
	public double getP3Value(){
		return this.P3Value;
	}
	public void setP3Value(double value){
		this.P3Value = value;
	}

}
