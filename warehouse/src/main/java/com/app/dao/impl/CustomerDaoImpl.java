package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.ICustomerDao;
import com.app.model.Customer;
@Repository
public class CustomerDaoImpl implements ICustomerDao{

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer saveCustomer(Customer cust) {
		return (Integer)ht.save(cust);
	}

	@Override
	public void updateCustomer(Customer cust) {
		ht.update(cust);
	}

	@Override
	public void deleteCustomer(Integer cId) {
	Customer c=new Customer();
	c.setcId(cId);
	ht.delete(c);
	}

	@Override
	public Customer getOneCustomer(Integer cId) {
		return ht.get(Customer.class, cId);
	}

	@Override
	public List<Customer> getAllCusts() {
		return ht.loadAll(Customer.class);
	}
@SuppressWarnings("unchecked")
@Override
public boolean isCustomerCodeExist(String code) {

	List<Long> rowCoutnt=(List<Long>)	
			ht.findByCriteria(
					
					DetachedCriteria.forClass(Customer.class)
					.setProjection(Projections.rowCount())
					.add(Restrictions.eq("custCode", code))
					
					);
			
			
			
			return false;
}
}
