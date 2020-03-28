package org.polariscode.SecuritySystem.model.Permission;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;
import java.util.List;
import java.util.ArrayList;
import org.polariscode.SecuritySystem.model.Permission.Menu;

//菜单
@Component
public class Menu implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static Menu m_Menu;

	@PostConstruct 
	public void init(){
		m_Menu=this;
		m_Menu.dictionaryService=this.dictionaryService;
	}

	private int ID = 0;
	public int getID(){
		return this.ID;
	}
	public void setID(int value){
		this.ID = value;
	}

	private int PID = 0;
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

	private String Title = "";
	//标题
	public String getTitle(){
		return this.Title;
	}
	public void setTitle(String value){
		this.Title = value;
	}

	private String Icon = "";
	//图标
	public String getIcon(){
		return this.Icon;
	}
	public void setIcon(String value){
		this.Icon = value;
	}

	private int Openby = 0;
	//打开方式
	public int getOpenby(){
		return this.Openby;
	}
	public void setOpenby(int value){
		this.Openby = value;
	}

	private String Openby_Convert="";
	public String getOpenby_Convert(){
		switch(String.valueOf(Openby)) {
		case "0":
			return "Tab页";
		case "1":
			return "iframe弹窗";
		}
		return Openby_Convert;
	}
	public void setOpenby_Convert(String value){
		this.Openby_Convert = value;
	}

	private String Url = "";
	//关联地址
	public String getUrl(){
		return this.Url;
	}
	public void setUrl(String value){
		this.Url = value;
	}

	private String FloatPrompt = "";
	//浮动提示
	public String getFloatPrompt(){
		return this.FloatPrompt;
	}
	public void setFloatPrompt(String value){
		this.FloatPrompt = value;
	}

	private int TabType = 0;
	//类型
	public int getTabType(){
		return this.TabType;
	}
	public void setTabType(int value){
		this.TabType = value;
	}

	private String TabType_Convert="";
	public String getTabType_Convert(){
		switch(String.valueOf(TabType)) {
		case "0":
			return "单例";
		case "1":
			return "多例";
		}
		return TabType_Convert;
	}
	public void setTabType_Convert(String value){
		this.TabType_Convert = value;
	}

	private String Describes = "";
	//描述
	public String getDescribes(){
		return this.Describes;
	}
	public void setDescribes(String value){
		this.Describes = value;
	}

	private boolean Isdelete = false;
	//是否停用
	public boolean getIsdelete(){
		return this.Isdelete;
	}
	public void setIsdelete(boolean value){
		this.Isdelete = value;
	}

	private int Sequence = 0;
	//顺序
	public int getSequence(){
		return this.Sequence;
	}
	public void setSequence(int value){
		this.Sequence = value;
	}

	private List<Menu> Children = new ArrayList<Menu>();
	//下级菜单
	public List<Menu> getChildren(){
		return this.Children;
	}
	public void setChildren(List<Menu> value){
		this.Children = value;
	}

}
