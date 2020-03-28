package org.polariscode.SecuritySystem.model.SiteManage;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;

@Component
public class SitePostWeek implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static SitePostWeek m_SitePostWeek;

	@PostConstruct 
	public void init(){
		m_SitePostWeek=this;
		m_SitePostWeek.dictionaryService=this.dictionaryService;
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

	private java.util.Date D1 = null;
	public java.util.Date getD1(){
		return this.D1;
	}
	public void setD1(java.util.Date value){
		this.D1 = value;
	}

	private java.util.Date D2 = null;
	public java.util.Date getD2(){
		return this.D2;
	}
	public void setD2(java.util.Date value){
		this.D2 = value;
	}

	private java.util.Date D3 = null;
	public java.util.Date getD3(){
		return this.D3;
	}
	public void setD3(java.util.Date value){
		this.D3 = value;
	}

	private java.util.Date D4 = null;
	public java.util.Date getD4(){
		return this.D4;
	}
	public void setD4(java.util.Date value){
		this.D4 = value;
	}

	private java.util.Date D5 = null;
	public java.util.Date getD5(){
		return this.D5;
	}
	public void setD5(java.util.Date value){
		this.D5 = value;
	}

	private java.util.Date D6 = null;
	public java.util.Date getD6(){
		return this.D6;
	}
	public void setD6(java.util.Date value){
		this.D6 = value;
	}

	private java.util.Date D7 = null;
	public java.util.Date getD7(){
		return this.D7;
	}
	public void setD7(java.util.Date value){
		this.D7 = value;
	}

	private int N1 = 0;
	public int getN1(){
		return this.N1;
	}
	public void setN1(int value){
		this.N1 = value;
	}

	private int N2 = 0;
	public int getN2(){
		return this.N2;
	}
	public void setN2(int value){
		this.N2 = value;
	}

	private int N3 = 0;
	public int getN3(){
		return this.N3;
	}
	public void setN3(int value){
		this.N3 = value;
	}

	private int N4 = 0;
	public int getN4(){
		return this.N4;
	}
	public void setN4(int value){
		this.N4 = value;
	}

	private int N5 = 0;
	public int getN5(){
		return this.N5;
	}
	public void setN5(int value){
		this.N5 = value;
	}

	private int N6 = 0;
	public int getN6(){
		return this.N6;
	}
	public void setN6(int value){
		this.N6 = value;
	}

	private int N7 = 0;
	public int getN7(){
		return this.N7;
	}
	public void setN7(int value){
		this.N7 = value;
	}

	private int SPI1 = 0;
	public int getSPI1(){
		return this.SPI1;
	}
	public void setSPI1(int value){
		this.SPI1 = value;
	}

	private int SPI2 = 0;
	public int getSPI2(){
		return this.SPI2;
	}
	public void setSPI2(int value){
		this.SPI2 = value;
	}

	private int SPI3 = 0;
	public int getSPI3(){
		return this.SPI3;
	}
	public void setSPI3(int value){
		this.SPI3 = value;
	}

	private int SPI4 = 0;
	public int getSPI4(){
		return this.SPI4;
	}
	public void setSPI4(int value){
		this.SPI4 = value;
	}

	private int SPI5 = 0;
	public int getSPI5(){
		return this.SPI5;
	}
	public void setSPI5(int value){
		this.SPI5 = value;
	}

	private int SPI6 = 0;
	public int getSPI6(){
		return this.SPI6;
	}
	public void setSPI6(int value){
		this.SPI6 = value;
	}

	private int SPI7 = 0;
	public int getSPI7(){
		return this.SPI7;
	}
	public void setSPI7(int value){
		this.SPI7 = value;
	}

}
