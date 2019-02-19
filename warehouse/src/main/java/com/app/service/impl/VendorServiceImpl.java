package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IVendorDao;
import com.app.model.Vendor;
import com.app.service.IVendorService;

@Service
public class VendorServiceImpl implements IVendorService{

	@Autowired
	private IVendorDao dao;
@Transactional
public Integer saveVendor(Vendor ven) {
		return dao.saveVendor(ven);
	}

	@Transactional
	public void updateVendor(Vendor ven) {
		dao.updateVendor(ven);
	}

	@Transactional
	public void deleteVendor(Integer id) {
		dao.deleteVendor(id);		
	}

	@Transactional(readOnly=true)
	public Vendor getOneVendor(Integer id) {
		return dao.getOneVendor(id);
	}

	@Transactional(readOnly=true)
	public List<Vendor> getAllVendors() {
		return dao.getAllVendors();
	}

}
