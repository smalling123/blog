package org.polariscode.SecuritySystem.model.Finance;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;
import java.util.List;
import java.util.ArrayList;
import org.polariscode.SecuritySystem.model.Finance.Invoice;

@Component
public class Bs implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static Bs m_Bs;

	@PostConstruct 
	public void init(){
		m_Bs=this;
		m_Bs.dictionaryService=this.dictionaryService;
	}

	private List<String> ids = new ArrayList<String>();
	public List<String> getids(){
		return this.ids;
	}
	public void setids(List<String> value){
		this.ids = value;
	}

	private int id = 0;
	public int getid(){
		return this.id;
	}
	public void setid(int value){
		this.id = value;
	}

	private Invoice invoice = new Invoice();
	public Invoice getinvoice(){
		return this.invoice;
	}
	public void setinvoice(Invoice value){
		this.invoice = value;
	}

}
