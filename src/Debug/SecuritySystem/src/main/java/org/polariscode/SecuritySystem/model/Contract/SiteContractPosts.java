package org.polariscode.SecuritySystem.model.Contract;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;
import java.util.List;
import java.util.ArrayList;
import org.polariscode.SecuritySystem.model.Contract.SiteContractPost;

@Component
public class SiteContractPosts implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static SiteContractPosts m_SiteContractPosts;

	@PostConstruct 
	public void init(){
		m_SiteContractPosts=this;
		m_SiteContractPosts.dictionaryService=this.dictionaryService;
	}

	private int id = 0;
	public int getid(){
		return this.id;
	}
	public void setid(int value){
		this.id = value;
	}

	private List<SiteContractPost> siteContractPosts = new ArrayList<SiteContractPost>();
	public List<SiteContractPost> getsiteContractPosts(){
		return this.siteContractPosts;
	}
	public void setsiteContractPosts(List<SiteContractPost> value){
		this.siteContractPosts = value;
	}

}
