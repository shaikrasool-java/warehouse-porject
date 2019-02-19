package com.app.service;

import java.util.List;

import com.app.model.Vendor;

public interface IVendorService {

	public Integer saveVendor(Vendor ven);
	public void updateVendor(Vendor ven);
	public void deleteVendor(Integer id);
	public Vendor getOneVendor(Integer id);
	public List<Vendor> getAllVendors();
}
