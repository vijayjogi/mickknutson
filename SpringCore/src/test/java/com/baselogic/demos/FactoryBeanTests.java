package com.baselogic.demos;

//Hamcrest
//import static org.hamcrest.CoreMatchers.*;
//import static org.hamcrest.core.IsNull.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

//JUnit
//import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

//Mockito
import static org.mockito.Matchers.any;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

//PowerMock
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.core.classloader.annotations.SuppressStaticInitializationFor;
import org.powermock.modules.junit4.PowerMockRunner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.baselogic.domain.Customer;
import com.baselogic.domain.Item;
import com.baselogic.domain.Order;

/**
 * FactoryBean Tests
 *
 * <p>Spring Certification objective: 1.2</p>
 * 
 * @see <a href="http://springcert.sourceforge.net/core-3/index.html#beans">Objective 1.2</a>
 *
 * @author Mick Knutson
 * @see <a href="http://www.baselogic.com">Blog: http://baselogic.com</a>
 * @see <a href="http://linkedin.com/in/mickknutson">LinkedIN: http://linkedin.com/in/mickknutson</a>
 * @see <a href="http://twitter.com/mickknutson">Twitter: http://twitter.com/mickknutson</a>
 * @see <a href="http://github.com/mickknutson">Git hub: http://github.com/mickknutson</a>
 * 
 * @see <a href="http://www.packtpub.com/java-ee6-securing-tuning-extending-enterprise-applications-cookbook/book">JavaEE 7 Cookbook Packt</a>
 * @see <a href="http://www.amazon.com/Cookbook-securing-extending-enterprise-applications/dp/1849683166">JavaEE 7 Cookbook Amazon</a>
 * 
 * @since 2012
 * 
 */
@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class FactoryBeanTests {

	private final Logger logger = LoggerFactory.getLogger(FactoryBeanTests.class);

	@Autowired
	ApplicationContext applicationContext;

	@Test
	public void testCustomerWithXmlFactoryOrder(){
		logger.info(">>>------------------------------------------------->>>");
		
		//TODO: get bean ordering:
		
		Customer customer = applicationContext.getBean("customer", Customer.class);
		
		logger.info("customer: {}", customer.toString());
		logger.info("order: {}", applicationContext.getBean("order", Order.class));
		
		logger.info("item1: {}", applicationContext.getBean("item1", Item.class));
		logger.info("item2: {}", applicationContext.getBean("item2", Item.class));

		assertThat(customer.getFirstName(), is("Mick"));
		assertThat(customer.getLastName(), is("Knutson"));

		assertThat(customer.getOrder().getItems().size(), is(2));
	}

	@Test
	public void testCustomerWithJavaConfigFactoryOrder(){
		logger.info(">>>------------------------------------------------->>>");
		
		//TODO: get bean ordering:
		
		Customer customer = applicationContext.getBean("javaConfigCustomer", Customer.class);
		
		logger.info("customer: {}", customer.toString());
		logger.info("order: {}", applicationContext.getBean("javaConfigOrder", Order.class));

		assertThat(customer.getOrder().getItems().size(), is(4));
	}
}