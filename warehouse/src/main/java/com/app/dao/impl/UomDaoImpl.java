package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IUomDao;
import com.app.model.Item;
import com.app.model.Uom;

@Repository
public class UomDaoImpl implements IUomDao {

	@Autowired
	private HibernateTemplate ht;
	@Override
	public Integer saveUom(Uom uom) {
		return (Integer)ht.save(uom);
	}

	@Override
	public void updateUom(Uom uom) {
		ht.update(uom);
	}

	@Override
	public void deletUom(Integer id) {
		Uom u=new Uom();
		u.setId(id);
		ht.delete(u);
	}

	@Override
	public Uom getOne(Integer id) {
		return ht.get(Uom.class, id);
	}

	@Override
	public List<Uom> getAll() {
		return ht.loadAll(Uom.class);
	}

	public boolean isUomAlreadyExist(String model)
	{
		
		//select count(*)from uomtab where model=?
		
		@SuppressWarnings("unchecked")
		List<Long> countList=(List<Long>)
				ht.findByCriteria(
						DetachedCriteria.forClass(Uom.class)
						.setProjection(Projections.rowCount())
						.add(Restrictions.eq("model", model))
						
						);
				
		return countList.get(0)!=0?true:false;
	}
	public boolean isUomConnectedWithItem(Integer id)
	{
		
		//select count(*)from uomtab where model=?
		
		@SuppressWarnings("unchecked")
		List<Long> countList=(List<Long>)
				ht.findByCriteria(
						DetachedCriteria.forClass(Item.class)
						.setProjection(Projections.rowCount())
						.add(Restrictions.eq("id", id))
						
						);
				
		return countList.get(0)!=0?true:false;
	}
	
	
}
