package com.baselogic.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.baselogic.dao.OrderDAO;
import com.baselogic.domain.Order;

/**
 * {@link ExampleService} with hard-coded input data.
 */
@Component("orderService")
public class OrderServiceImpl implements OrderService {
	
	private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

	@Autowired
	private OrderDAO orderDao;
	
	//@Autowired
	private String message;


	/**
	 * Reads next record from input
	 */
	public String getMessage() {
		return message;	
	}
	
	public Order placeOrder(Order order){
		
		logger.debug("> placing order...");
		
		order.adviceGiven.add("OrderServiceImpl.placeOrder advice");
		
		somePrivateFunction(order);
		
		try {
			return orderDao.placeOrder(order);
		} catch (Exception e) {		
			logger.error(e.getMessage());
			//e.printStackTrace();
		}
		
		return null;
	}	

	public Order placeDelayedOrder(Order order, long delay){
		
		logger.debug("> placing order...");
		
		order.adviceGiven.add("OrderServiceImpl.placeDelayedOrder advice");
		
		somePrivateFunction(order);
		
		try {
			return orderDao.placeDelayedOrder(order, delay);
		} catch (Exception e) {		
			logger.error(e.getMessage());
			//e.printStackTrace();
		}
		
		return null;
	}	

	private void somePrivateFunction(Order order){
		logger.debug("somePrivateFunction...");
		order.adviceGiven.add("OrderServiceImpl.somePrivateFunction advice");
	}
	
	@PostConstruct
	public void initService(){
        if (orderDao != null) {
            logger.debug("MY DEP BEAN {}", orderDao.toString());
        }
        logger.debug("> {}: @PostConstruct <", this.getClass());
	}
	
	@PreDestroy
	public void destroyService(){
		logger.debug("> {}: @PreDestroy <", this.getClass());
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}    
}
