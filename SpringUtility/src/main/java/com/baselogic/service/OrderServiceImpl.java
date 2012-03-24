package com.baselogic.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.baselogic.dao.OrderDAO;
import com.baselogic.domain.Order;
import com.baselogic.util.ExampleUtils;


/**
 * {@link ExampleService} with hard-coded input data.
 */
@Component
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDAO orderDao;
	
	@Autowired
	private String message;
	
	@Autowired
	private ExampleUtils exampleUtils;


	/**
	 * Reads next record from input
	 */
	public String getMessage() {
		return message;	
	}
	
	public Order placeOrder(Order order){
		
		return orderDao.placeOrder(order);
	}

	//----- Mockable methods --------------------------------------------------------//
	
	public static String staticFunction(){
		return "staticFunction";
	}
	
	public String localFunction(){
		
		String result = "OrderServiceImpl: localFunction";
		
		try {
			
			result += ": " + exampleUtils.nestedFunction();
			
		} catch (Exception e){
			
			result += ": " + e.getMessage();
		}
		
		return result;
	}
	
	public String voidedFunction(){
		
		String result = "OrderServiceImpl: localFunction";
		
		try {
			
			exampleUtils.voidMethod();

		} catch (Exception e){
			
			result += ": " + e.getMessage();
		}
		
		return result;
	}

	public String staticFunctions(){
		
		String result = "OrderServiceImpl: function()";
		
		result += ": " + ExampleUtils.staticFunction();
		
		result += ": " + staticFunction();
		
		return result;
	}

	public String complexFunctions(){
		
		String result = "OrderServiceImpl: nestedFunction()";
		
		result += ": " + privateFunction("privateFunction");
		
		result += ": " + localFunction();
		
		result += ": " + ExampleUtils.staticFunction();
		
		result += ": " + exampleUtils.nestedFunctionTwo();
		
		return result;
	}

	public String duplicateCallsFunction(){
		
		String result = "OrderServiceImpl: duplicateCallsFunction()";

		for(int i = 0; i < 4; i++){
			
			result += ": " + exampleUtils.nestedFunction();
		}

		return result;
	}

	/*public String shadowedeFunction(){
		
		String result = "OrderServiceImpl: shadowedeFunction()";
		
		result = exampleUtils.nestedFunction();
		
		result = localFunction();

		return result;
	}*/

	public String executeInternalPrivate(){
		
		String result = "OrderServiceImpl: executeInternalPrivate()";
		
		result += ": " + privateFunction();
		
		result += ": " + privateFunction("privateFunction");
		
		return result;
	}

	private String privateFunction() {
		return "OrderServiceImpl: privateFunction";
	}

	private String privateFunction(String privateString) {
		return "OrderServiceImpl: privateFunction: " + privateString;
	}
	

}