package org.polariscode.SecuritySystem.model.Config;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;
import java.util.List;
import java.util.ArrayList;
import org.polariscode.SecuritySystem.model.Config.District;

@Component
public class District implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static District m_District;

	@PostConstruct 
	public void init(){
		m_District=this;
		m_District.dictionaryService=this.dictionaryService;
	}

	private int ID = 0;
	//区号
	public int getID(){
		return this.ID;
	}
	public void setID(int value){
		this.ID = value;
	}

	private int PID = 0;
	//上级区号
	public int getPID(){
		return this.PID;
	}
	public void setPID(int value){
		this.PID = value;
	}

	private String Name = "";
	//名称
	public String getName(){
		return this.Name;
	}
	public void setName(String value){
		this.Name = value;
	}

	private String MergerName = "";
	//全名
	public String getMergerName(){
		return this.MergerName;
	}
	public void setMergerName(String value){
		this.MergerName = value;
	}

	private String ShortName = "";
	//简称
	public String getShortName(){
		return this.ShortName;
	}
	public void setShortName(String value){
		this.ShortName = value;
	}

	private String MergerShotName = "";
	//全名简称
	public String getMergerShotName(){
		return this.MergerShotName;
	}
	public void setMergerShotName(String value){
		this.MergerShotName = value;
	}

	private int Level = 0;
	//级别
	public int getLevel(){
		return this.Level;
	}
	public void setLevel(int value){
		this.Level = value;
	}

	private String CityCode = "";
	//城市编号 
	public String getCityCode(){
		return this.CityCode;
	}
	public void setCityCode(String value){
		this.CityCode = value;
	}

	private String ZipCode = "";
	//邮政编号
	public String getZipCode(){
		return this.ZipCode;
	}
	public void setZipCode(String value){
		this.ZipCode = value;
	}

	private String PinYin = "";
	//拼音
	public String getPinYin(){
		return this.PinYin;
	}
	public void setPinYin(String value){
		this.PinYin = value;
	}

	private String JianPin = "";
	//简拼
	public String getJianPin(){
		return this.JianPin;
	}
	public void setJianPin(String value){
		this.JianPin = value;
	}

	private String FirstChar = "";
	//首字母
	public String getFirstChar(){
		return this.FirstChar;
	}
	public void setFirstChar(String value){
		this.FirstChar = value;
	}

	private double Lng = 0.0;
	public double getLng(){
		return this.Lng;
	}
	public void setLng(double value){
		this.Lng = value;
	}

	private double Lat = 0.0;
	public double getLat(){
		return this.Lat;
	}
	public void setLat(double value){
		this.Lat = value;
	}

	private List<District> Children = new ArrayList<District>();
	public List<District> getChildren(){
		return this.Children;
	}
	public void setChildren(List<District> value){
		this.Children = value;
	}

}
