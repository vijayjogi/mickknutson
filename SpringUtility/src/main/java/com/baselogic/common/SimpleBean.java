package com.baselogic.common;

import org.springframework.context.annotation.Scope;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;

@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SimpleBean {
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "SimpleBean [message=" + message + "]";
	}	
}