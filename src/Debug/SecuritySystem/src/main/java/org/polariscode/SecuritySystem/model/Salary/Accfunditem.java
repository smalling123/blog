package org.polariscode.SecuritySystem.model.Salary;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;

@Component
public class Accfunditem implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static Accfunditem m_Accfunditem;

	@PostConstruct 
	public void init(){
		m_Accfunditem=this;
		m_Accfunditem.dictionaryService=this.dictionaryService;
	}

	private int ID = 0;
	public int getID(){
		return this.ID;
	}
	public void setID(int value){
		this.ID = value;
	}

	private int AccfundId = 0;
	public int getAccfundId(){
		return this.AccfundId;
	}
	public void setAccfundId(int value){
		this.AccfundId = value;
	}

	private int Year = 0;
	//年
	public int getYear(){
		return this.Year;
	}
	public void setYear(int value){
		this.Year = value;
	}

	private int Month = 0;
	//月
	public int getMonth(){
		return this.Month;
	}
	public void setMonth(int value){
		this.Month = value;
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

	private double CRate = 0.0;
	//企业比率
	public double getCRate(){
		return this.CRate;
	}
	public void setCRate(double value){
		this.CRate = value;
	}

	private double CMinValue = 0.0;
	//企业最低缴纳额
	public double getCMinValue(){
		return this.CMinValue;
	}
	public void setCMinValue(double value){
		this.CMinValue = value;
	}

	private double CMaxValue = 0.0;
	//企业最高缴纳额
	public double getCMaxValue(){
		return this.CMaxValue;
	}
	public void setCMaxValue(double value){
		this.CMaxValue = value;
	}

	private double PRate = 0.0;
	//个人比率
	public double getPRate(){
		return this.PRate;
	}
	public void setPRate(double value){
		this.PRate = value;
	}

	private double PMinValue = 0.0;
	//个人最低缴纳额
	public double getPMinValue(){
		return this.PMinValue;
	}
	public void setPMinValue(double value){
		this.PMinValue = value;
	}

	private double PMaxValue = 0.0;
	//个人最低缴纳额
	public double getPMaxValue(){
		return this.PMaxValue;
	}
	public void setPMaxValue(double value){
		this.PMaxValue = value;
	}

}
