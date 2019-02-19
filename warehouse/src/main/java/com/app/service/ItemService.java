package com.app.service;

import java.util.List;

import com.app.model.Item;

public interface ItemService {
	public Integer saveItem(Item it);
	public void updateItem(Item it);
	public void deleteItem(Integer id);
	public Item getOneItem(Integer id);
	public List<Item> getAllItems();
}
