package com.app.service;

import java.util.List;

import com.app.model.OrderMethod;

public interface IOrderMethodService {
	public Integer saveOrder(OrderMethod order);
	public void updateOrder(OrderMethod order);
	public void deleteOrder(Integer id);
	public OrderMethod getOneOrder(Integer id);
	public List<OrderMethod> getAllOrders();
	public List<OrderMethod> getOrderMethodsByMode(String mode);
	public boolean isOrderMethodCodeExist(String code);
}
