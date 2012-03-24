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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.baselogic.service.ExampleServiceInitializingBeanImpl;

/**
 * BeanFactoryPostProcessorTests
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
 * @since 2012
 * 
 */
@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class BeanFactoryPostProcessorTests {
	
	private final Logger logger = LoggerFactory
			.getLogger(BeanFactoryPostProcessorTests.class);

	@Autowired
	ExampleServiceInitializingBeanImpl exampleServiceInitializingBeanImpl;

	@Autowired
	@Qualifier("exampleServiceInitializingBeanImplBeanFactoryPostProcessed")
	ExampleServiceInitializingBeanImpl exampleServiceInitializingBeanImplBeanFactoryPostProcessed;

	@Autowired
	ApplicationContext applicationContext;

	@Test
	public void testAddBeanFactoryPostProcessorAlias(){
		logger.info(">>>------------------------------------------------->>>");
		logger.info("testAddBeanFactoryPostProcessorAlias");
		
		assertThat(exampleServiceInitializingBeanImplBeanFactoryPostProcessed, is(notNullValue()));
	}

}