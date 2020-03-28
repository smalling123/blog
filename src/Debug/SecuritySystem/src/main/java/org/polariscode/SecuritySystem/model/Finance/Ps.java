package org.polariscode.SecuritySystem.model.Finance;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;
import org.polariscode.SecuritySystem.model.Finance.Pay;
import java.util.List;
import java.util.ArrayList;

@Component
public class Ps implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static Ps m_Ps;

	@PostConstruct 
	public void init(){
		m_Ps=this;
		m_Ps.dictionaryService=this.dictionaryService;
	}

	private Pay pay = new Pay();
	public Pay getpay(){
		return this.pay;
	}
	public void setpay(Pay value){
		this.pay = value;
	}

	private List<String> ids = new ArrayList<String>();
	public List<String> getids(){
		return this.ids;
	}
	public void setids(List<String> value){
		this.ids = value;
	}

}
