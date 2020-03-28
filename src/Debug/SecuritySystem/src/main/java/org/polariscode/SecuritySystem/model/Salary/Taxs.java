package org.polariscode.SecuritySystem.model.Salary;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;

@Component
public class Taxs implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static Taxs m_Taxs;

	@PostConstruct 
	public void init(){
		m_Taxs=this;
		m_Taxs.dictionaryService=this.dictionaryService;
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

	private double Base = 0.0;
	//起征点
	public double getBase(){
		return this.Base;
	}
	public void setBase(double value){
		this.Base = value;
	}

	private int Mid = 0;
	public int getMid(){
		return this.Mid;
	}
	public void setMid(int value){
		this.Mid = value;
	}

	private double MinVM = 0.0;
	//下限
	public double getMinVM(){
		return this.MinVM;
	}
	public void setMinVM(double value){
		this.MinVM = value;
	}

	private double MaxVM = 0.0;
	//上限
	public double getMaxVM(){
		return this.MaxVM;
	}
	public void setMaxVM(double value){
		this.MaxVM = value;
	}

	private int Rate = 0;
	//税率
	public int getRate(){
		return this.Rate;
	}
	public void setRate(int value){
		this.Rate = value;
	}

	private int Yid = 0;
	public int getYid(){
		return this.Yid;
	}
	public void setYid(int value){
		this.Yid = value;
	}

	private double MinVY = 0.0;
	//下限
	public double getMinVY(){
		return this.MinVY;
	}
	public void setMinVY(double value){
		this.MinVY = value;
	}

	private double MaxVY = 0.0;
	//上限
	public double getMaxVY(){
		return this.MaxVY;
	}
	public void setMaxVY(double value){
		this.MaxVY = value;
	}

	private double Value = 0.0;
	//速扣数
	public double getValue(){
		return this.Value;
	}
	public void setValue(double value){
		this.Value = value;
	}

}
