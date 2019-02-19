package com.app.dao.impl;

import java.util.List;

import javax.persistence.criteria.Order;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IOrderDao;
import com.app.model.OrderMethod;
@Repository
public class OrderMethodDaoImpl implements IOrderDao{

	@Autowired
	private HibernateTemplate ht;
	@Override
	public Integer saveOrder(OrderMethod order) {
		return (Integer) ht.save(order);
	}

	@Override
	public void updateOrder(OrderMethod order) {
		ht.update(order);		
	}

	@Override
	public void deleteOrder(Integer id) {
		OrderMethod o=new OrderMethod();
		o.setId(id);
		ht.delete(o);
	}

	@Override
	public OrderMethod getOneOrder(Integer id) {
		return ht.get(OrderMethod.class, id);
	}

	@Override
	public List<OrderMethod> getAllOrders() {
		return ht.loadAll(OrderMethod.class);
	}
	@Override
	public List<OrderMethod> getOrderMethodsByMode(String mode) {

			String hql="from "+ OrderMethod.class.getName()+" where mode=?";
			
			List<OrderMethod> oms=(List<OrderMethod>)ht.find(hql, mode);
			
		return oms;
	}

	public boolean isOrderMethodCodeExist(String code) {
		
		@SuppressWarnings("unchecked")
		List<Long> rowsCount=(List<Long>)
				ht.findByCriteria(
						DetachedCriteria.forClass(OrderMethod.class)
						.setProjection(Projections.rowCount())
						.add(Restrictions.eq("code", code))
						);
				
		return rowsCount.get(0)!=0?true:false;
	}
	
}
