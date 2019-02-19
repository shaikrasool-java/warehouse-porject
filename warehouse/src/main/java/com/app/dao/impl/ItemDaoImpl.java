package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.ItemDao;
import com.app.model.Item;

@Repository
public class ItemDaoImpl implements ItemDao {

	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveItem(Item it) {
		return (Integer)ht.save(it);
	}

	@Override
	public void updateItem(Item it) {
		ht.update(it);		
	}

	@Override
	public void deleteItem(Integer id) {
		Item i=new Item();
		i.setId(id);
		ht.delete(i);
	

	}
	@Override
	public Item getOneItem(Integer id) {

		return ht.get(Item.class, id);
	}
	@Override
	public List<Item> getAllItems() {
		return ht.loadAll(Item.class);
	}



}
