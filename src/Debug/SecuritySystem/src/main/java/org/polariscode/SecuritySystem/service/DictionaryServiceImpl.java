package org.polariscode.SecuritySystem.service;


import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import java.util.List;
import java.util.ArrayList;
import org.polariscode.SecuritySystem.model.DictionaryItem;
import org.polariscode.SecuritySystem.mapper.DictionaryMapper;

@Service("dictionaryService")
public class DictionaryServiceImpl implements DictionaryService{
	@Autowired
	private DictionaryMapper m_DictionaryMapper;

	@Cacheable(value = { "getDictionaryItems" },key="#dictionary+'-'+#filter")
	public List<DictionaryItem> getDictionaryItems(String dictionary, String filter){
		if(dictionary.equalsIgnoreCase("City")){
			return m_DictionaryMapper.City(filter);
		}
		if(dictionary.equalsIgnoreCase("Company")){
			return m_DictionaryMapper.Company();
		}
		if(dictionary.equalsIgnoreCase("Customer")){
			return m_DictionaryMapper.Customer(filter);
		}
		if(dictionary.equalsIgnoreCase("Equipment")){
			return m_DictionaryMapper.Equipment(filter);
		}
		if(dictionary.equalsIgnoreCase("Manager")){
			return m_DictionaryMapper.Manager(filter);
		}
		if(dictionary.equalsIgnoreCase("Org")){
			return m_DictionaryMapper.Org();
		}
		if(dictionary.equalsIgnoreCase("OrgType")){
			return m_DictionaryMapper.OrgType();
		}
		if(dictionary.equalsIgnoreCase("Personnel")){
			return m_DictionaryMapper.Personnel(filter);
		}
		if(dictionary.equalsIgnoreCase("PersonnelEx")){
			return m_DictionaryMapper.PersonnelEx(filter);
		}
		if(dictionary.equalsIgnoreCase("Province")){
			return m_DictionaryMapper.Province();
		}
		if(dictionary.equalsIgnoreCase("Site")){
			return m_DictionaryMapper.Site(filter);
		}
		if(dictionary.equalsIgnoreCase("SiteOrg")){
			return m_DictionaryMapper.SiteOrg();
		}
		if(dictionary.equalsIgnoreCase("Staff")){
			return m_DictionaryMapper.Staff();
		}
		if(dictionary.equalsIgnoreCase("User")){
			return m_DictionaryMapper.User(filter);
		}
		return new ArrayList<DictionaryItem>();
	}

	@Cacheable(value = { "convertDictionary" },key="#dictionary+'-'+#code")
	public String convertDictionary(String dictionary, String code){
		DictionaryItem result = new DictionaryItem();
		if(dictionary.equalsIgnoreCase("City")){
			result = m_DictionaryMapper.ConvertCity(code);
		}
		if(dictionary.equalsIgnoreCase("Company")){
			result = m_DictionaryMapper.ConvertCompany(code);
		}
		if(dictionary.equalsIgnoreCase("Customer")){
			result = m_DictionaryMapper.ConvertCustomer(code);
		}
		if(dictionary.equalsIgnoreCase("Equipment")){
			result = m_DictionaryMapper.ConvertEquipment(code);
		}
		if(dictionary.equalsIgnoreCase("Manager")){
			result = m_DictionaryMapper.ConvertManager(code);
		}
		if(dictionary.equalsIgnoreCase("Org")){
			result = m_DictionaryMapper.ConvertOrg(code);
		}
		if(dictionary.equalsIgnoreCase("OrgType")){
			result = m_DictionaryMapper.ConvertOrgType(code);
		}
		if(dictionary.equalsIgnoreCase("Personnel")){
			result = m_DictionaryMapper.ConvertPersonnel(code);
		}
		if(dictionary.equalsIgnoreCase("PersonnelEx")){
			result = m_DictionaryMapper.ConvertPersonnelEx(code);
		}
		if(dictionary.equalsIgnoreCase("Province")){
			result = m_DictionaryMapper.ConvertProvince(code);
		}
		if(dictionary.equalsIgnoreCase("Site")){
			result = m_DictionaryMapper.ConvertSite(code);
		}
		if(dictionary.equalsIgnoreCase("SiteOrg")){
			result = m_DictionaryMapper.ConvertSiteOrg(code);
		}
		if(dictionary.equalsIgnoreCase("Staff")){
			result = m_DictionaryMapper.ConvertStaff(code);
		}
		if(dictionary.equalsIgnoreCase("User")){
			result = m_DictionaryMapper.ConvertUser(code);
		}
		return result==null ? "" : result.getName();
	}

}
