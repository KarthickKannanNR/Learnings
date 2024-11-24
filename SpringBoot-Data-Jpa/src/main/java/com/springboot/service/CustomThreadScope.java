package com.springboot.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

public class CustomThreadScope  implements Scope{
    CustomThreadLocal customThreadLocal = new CustomThreadLocal();


	@Override
	public Object get(String name, ObjectFactory<?> objectFactory) {
		// TODO Auto-generated method stub
		 Map<String, Object> scope = customThreadLocal.initialValue();
		Object obj = scope.get(name);
		 if (obj == null) {
			 obj = objectFactory.getObject();
	         scope.put(name, obj);
	       }
	       
		
		 
		return obj;
	}

	@Override
	public Object remove(String name) {
		// TODO Auto-generated method stub
		Map<String, Object> scope = (Map<String, Object>) customThreadLocal.get();
        return scope.remove(name);
	}

	@Override
	public void registerDestructionCallback(String name, Runnable callback) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object resolveContextualObject(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getConversationId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	class CustomThreadLocal extends ThreadLocal{
		
		protected Map<String, Object> initialValue(){
            System.out.println("Initializing ThreadLocal");
            return new HashMap<String, Object>();
		}
	}

	
  }

