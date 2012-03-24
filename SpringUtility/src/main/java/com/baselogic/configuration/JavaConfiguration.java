package com.baselogic.configuration;

import java.util.LinkedList;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.baselogic.domain.Customer;
import com.baselogic.domain.Item;
import com.baselogic.domain.Order;
import com.baselogic.service.ExampleServiceInitializingBeanImpl;

/**
 * Java Configuration
 *
 * <p>Spring Certification objective: 1.5</p>
 * 
 * @see http://springcert.sourceforge.net/core-3/index.html#beans-annotation-config
 *
 * @author Mick Knutson
 * <p><a href="http://www.baselogic.com">Blog: http://baselogic.com</a></p>
 * <p><a href="http://linkedin.com/in/mickknutson">LinkedIN: http://linkedin.com/in/mickknutson</a></p>
 * <p><a href="http://twitter.com/mickknutson">Twitter: http://twitter.com/mickknutson</a></p>
 * <p><a href="http://github.com/mickknutson">Git hub: http://github.com/mickknutson</a></p>
 * 
 * @since 2012
 * 
 */
@Configuration
@PropertySource("app-2.properties")
public class JavaConfiguration {

	/*@Value("#{dataSource}")
	private javax.sql.DataSource dataSource;*/

	@Bean
	public String message() {
		return "JavaConfiguration message";
	}


	@Bean
	public Customer javaConfigCustomer() {
		
		Customer customer = new Customer();
		
		customer.setOrder(javaConfigOrder());		

		return customer;
	}

	@Bean
	@SuppressWarnings("serial")
	public Order javaConfigOrder() {
		
		Order order = new Order();
		order.setItems(
				new LinkedList<Item>(){{
					add(item());
					add(item());
					add(item());
					add(item());
				}}
		);
		
		return order;
	}

	@Bean
	@Scope("prototype")
	public Item item() {
		
		Item item = new Item();
		item.setId(new Random(1234567890L).nextLong());
		item.setPrice(new Random(1234567890L).nextDouble());
		item.setProduct(UUID.randomUUID().toString());
		
		return item;
	}
	
	@Bean
	public ExampleServiceInitializingBeanImpl exampleServiceInitializingBeanImplJavaConfig(){
		
		ExampleServiceInitializingBeanImpl exampleServiceInitializingBeanImplJavaConfig 
			= new ExampleServiceInitializingBeanImpl();
		
		exampleServiceInitializingBeanImplJavaConfig.setMessage("exampleServiceInitializingBeanImplJavaConfig");
		
		return exampleServiceInitializingBeanImplJavaConfig;
	}

}