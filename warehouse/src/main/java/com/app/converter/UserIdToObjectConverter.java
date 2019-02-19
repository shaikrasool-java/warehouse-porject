package com.app.converter;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;

@Component
public class UserIdToObjectConverter implements Converter<Object, WhUserType>{
	
	@Autowired
	private IWhUserTypeService service; 
	
	
	
/*	private HashMap<Integer, WhUserType> whUserTypes;
*/	
	
	@Override
	public WhUserType convert(Object wid) {
		try {
			String s=(String) wid;
			int id=Integer.parseInt((String)wid);
			WhUserType user=service.getOneUser(id);
			return user;
		}catch (Exception e) {
			return new WhUserType();
		}

		

	
/*	@SuppressWarnings("unused")
	private WhUserType findUser(Integer id) {
		
		if(whUserTypes==null) {
			whUserTypes=new HashMap<>();
			List<WhUserType> userList=service.getALlUsers();
			for(WhUserType whu:userList) {
				whUserTypes.put(whu.getId(), whu);
			}
			
		}if(whUserTypes.containsKey(id)) {
			return whUserTypes.get(id);
		}
		
		return null;
	}
*/
	}
}
