package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IWhUserTypeDao;
import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;

@Service
public class WhUserTypeServiceImpl implements IWhUserTypeService{

	
	@Autowired
	private IWhUserTypeDao dao;
	@Transactional
	public Integer saveUser(WhUserType wuser) {
		return dao.saveUser(wuser);
	}
	@Transactional
	public void updateUser(WhUserType wuser) {
	dao.updateUser(wuser);
	}

	@Transactional
	public void deleteUser(Integer id) {
		dao.deleteUser(id);
	}

	@Transactional(readOnly=true)
	public WhUserType getOneUser(Integer id) {
		return dao.getOneUser(id);
	}
	@Transactional(readOnly=true)
	public List<WhUserType> getALlUsers() {
		return dao.getALlUsers();
	}

	@Transactional
	public List<WhUserType> getWhUserTypeByType(String type) {
		return dao.getWhUserTypeByType(type);
	}	
	
}
