package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ItemDao;
import com.app.model.Item;
import com.app.service.ItemService;

@Service
public class ItemSreviceImpl implements ItemService{
	
	@Autowired
private ItemDao dao;
	@Transactional
	public Integer saveItem(Item it) {
		return dao.saveItem(it);
	}

	@Transactional
	public void updateItem(Item it) {
dao.updateItem(it);		
	}

	@Transactional
	public void deleteItem(Integer id) {
dao.deleteItem(id);		
	}

	@Transactional(readOnly=true)
	public Item getOneItem(Integer id) {
		return dao.getOneItem(id);
	}

	@Transactional(readOnly=true)
	public List<Item> getAllItems() {
		return dao.getAllItems();
	}

	
	

}
