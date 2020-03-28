package org.polariscode.SecuritySystem.service;


import java.util.List;
import java.util.ArrayList;
import org.polariscode.SecuritySystem.model.DictionaryItem;

public interface DictionaryService{
	public List<DictionaryItem> getDictionaryItems(String dictionary, String filter);

	public String convertDictionary(String dictionary, String code);

}
