package com.generic.application.model;

public interface GenericModel <T> {
	
	void update(T model);
	
	Long getId();
	
	T generateInstance();
	
}
