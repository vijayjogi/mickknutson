package com.baselogic.components;

/**
 * @see http://springindepth.com/book/in-depth-ioc-constructor-setter-injection.html
 * @see http://springindepth.com/book/in-depth-ioc-multiple-parameter-constructor-injection.html
 * @author mknuts6173c
 *
 */
public class ConstructorInjectionComponent {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ConstructorInjectionComponent [message=" + message + "]";
	}	
}