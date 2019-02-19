package com.app.dao;

import java.util.List;

import com.app.model.Item;

public interface ItemDao {

	public Integer saveItem(Item it);
	public void updateItem(Item it);
	public void deleteItem(Integer id);
	public Item getOneItem(Integer id);
	public List<Item> getAllItems();
}
