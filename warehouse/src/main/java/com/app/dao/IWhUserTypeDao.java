package com.app.dao;

import java.util.List;

import com.app.model.WhUserType;

public interface IWhUserTypeDao {

	public Integer saveUser(WhUserType wuser);
	public void updateUser(WhUserType wuser);
	public void deleteUser(Integer id);
	public WhUserType getOneUser(Integer id);
	public List<WhUserType> getALlUsers();
	public List<WhUserType>getWhUserTypeByType(String type);
	/*public boolean isUserCodeExist(String code);*/
	
}
