package com.app.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUomDao;
import com.app.model.Uom;
import com.app.service.IUomService;
@Service
public class UomServiceImpl implements IUomService{

	@Autowired
	private IUomDao dao;
	
	@Transactional
	
	public Integer saveUom(Uom uom) {
		return dao.saveUom(uom);
	}

	@Transactional
	public void updateUom(Uom uom) {
		dao.updateUom(uom);
	}

	@Transactional
	public void deletUom(Integer id) {
		dao.deletUom(id);
		
	}

	@Transactional(readOnly=true)
	public Uom getOne(Integer id) {
		return dao.getOne(id);
	}

	@Transactional(readOnly=true)
	public List<Uom> getAll() {

		List<Uom> u=dao.getAll();
		Collections.sort(u, (o1,o2)->o1.getId()-o2.getId());
		return u;
	}

	@Override
	public boolean isUomAlreadyExist(String model) {
		return dao.isUomAlreadyExist(model);
	}
 @Override
public boolean isUomConnectedWithItem(Integer id) {
	return dao.isUomConnectedWithItem(id);
}
}
