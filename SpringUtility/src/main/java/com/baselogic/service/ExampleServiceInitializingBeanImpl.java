package com.baselogic.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.baselogic.annotations.Timestamp;
import com.baselogic.dao.OrderDAO;
import com.baselogic.util.ExampleUtils;

import com.baselogic.common.SimpleBean;

/**
 * ExampleServiceInitializingBeanImpl InitializingBean and DisposableBean
 * 
 * NOTE: A BeanFactoryPostProcessor modifies bean definitions, 
 * while a BeanPostProcessor replaces bean instances (such as when creating a proxy).
 *
 * <p>Spring Certification objective: 1.2</p>
 * 
 * @see http://springcert.sourceforge.net/core-3/index.html#beans
 *
 * @author Mick Knutson
 * <p><a href="http://www.baselogic.com">Blog: http://baselogic.com</a></p>
 * <p><a href="http://linkedin.com/in/mickknutson">LinkedIN: http://linkedin.com/in/mickknutson</a></p>
 * <p><a href="http://twitter.com/mickknutson">Twitter: http://twitter.com/mickknutson</a></p>
 * <p><a href="http://github.com/mickknutson">Git hub: http://github.com/mickknutson</a></p>
 * 
 * @see http://www.packtpub.com/java-ee6-securing-tuning-extending-enterprise-applications-cookbook/book
 * @see http://www.amazon.com/Cookbook-securing-extending-enterprise-applications/dp/1849683166
 * @see http://baselogic.com
 * @see http://linkedin.com/in/mickknutson
 * @see http://twitter.com/mickknutson
 * @see http://github.com/mickknutson
 * 
 * @since 2012
 * 
 */
@Component
public class ExampleServiceInitializingBeanImpl 
implements ExampleService, InitializingBean, DisposableBean {
	
	private static final Logger logger = LoggerFactory.getLogger(ExampleServiceInitializingBeanImpl.class);
	
	@Autowired
	String message;
	
	SimpleBean simpleBean;

	Date creationDate;

	List<String> initializationOrder = new ArrayList<String>();
		
	@Timestamp
	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getMessage() {
		return message;	
	}
	
	public void setMessage(String msg){
		this.message = msg;
	}
		
	public SimpleBean getSimpleBean() {
		return simpleBean;
	}

	public void setSimpleBean(SimpleBean simpleBean) {
		this.simpleBean = simpleBean;
	}

	@PostConstruct
	public void postConstruct(){
        logger.debug("> pc > {}: @PostConstruct <<<<<", this.getClass());
        initializationOrder.add("postConstruct");
	}
	
	@PreDestroy
	public void preDestroy(){
		logger.debug("> pd > {}: @PreDestroy <<<<<", this.getClass());
		initializationOrder.add("preDestroy");
	}

	/**
	 * PostConstruct and init-method are BeanPostProcessors
	 * 
	 * @PostConstruct is a JSR-250 annotaion while init-method is Spring's way of having an initializing method
	 * 
	 * If you have @PostConstruct, this will be called first before the init methods are called
	 * 
	 * If your bean implements initializing bean and overrides afterPropertiesSet:
	 * 		first post constructed is called, 
	 * 		then the afterPropertiesSet 
	 * 		and then init-method.
	 * @deprecated if using JSR-250 annotations, use @PostConstruct instead of init.
	 */
    public void init() {
        logger.debug(">>>>> {}: Init-Method Attribute <<<<<", this.getClass());
        initializationOrder.add("init");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.debug("> aps > {}: afterPropertiesSet <<<<<", this.getClass());
        initializationOrder.add("afterPropertiesSet");
    }

    @Override
    public void destroy() throws Exception {
    	message += ": destroy";
    	logger.debug("> d > {}: destroy, message: {} <<<<<", this.getClass(), message);
  	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}