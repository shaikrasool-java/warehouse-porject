package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IWhUserTypeDao;
import com.app.model.WhUserType;

@Repository
public class WhUserTypeDaoImpl implements IWhUserTypeDao {

		@Autowired
		private HibernateTemplate ht;
	
	
	@Override
	public Integer saveUser(WhUserType wuser) {
		return (Integer)ht.save(wuser);
	}

	@Override
	public void updateUser(WhUserType wuser) {
		ht.update(wuser);
	}

	@Override
	public void deleteUser(Integer id) {
		WhUserType u=new WhUserType();
		u.setId(id);
		ht.delete(u);
		
	}

	@Override
	public WhUserType getOneUser(Integer id) {
		return ht.get(WhUserType.class, id);
	}

	@Override
	public List<WhUserType> getALlUsers() {
		return ht.loadAll(WhUserType.class);
	}
	@Override
	public List<WhUserType> getWhUserTypeByType(String type) {
		String hql=" from "+WhUserType.class.getName()+" where type=? ";
		List<WhUserType> list=(List<WhUserType>)ht.find(hql, type);
		return list;
	}
/*@Override
	public boolean isUserCodeExist(String code) {

		List<Long> rowCount=(List<Long>)
				ht.findByCriteria(
						
						DetachedCriteria.forClass(WhUserType.class)
						.setProjection(Projections.rowCount())
						.add(Restrictions.eq("code", code))
						
						
						);
				
				
				
	
	return rowCount.get(0)!=0?true:false;
	}	*/
}
