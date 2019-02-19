package com.app.service;

import java.util.List;

import com.app.model.PurchaseOrder;

public interface IPurchaseOrderService {

	public Integer saveOrder(PurchaseOrder po);
	public void updateOrder(PurchaseOrder po);
	public void deleteOrder(Integer id);
	public PurchaseOrder getOneOrder(Integer id);
	public List<PurchaseOrder> getAllOrders();
}
