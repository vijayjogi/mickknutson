package com.baselogic.tutorials.service;

//Static imports
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Matchers.any;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.core.classloader.annotations.SuppressStaticInitializationFor;
import org.powermock.modules.junit4.PowerMockRunner;

import com.baselogic.tutorials.util.ContextUtils;

/**
 * ExampleMockServiceTests
 *
 * <p>Spring Certification objective: 1.2 Lifecycle</p>
 *
 * at_see <a href="http://springcert.sourceforge.net/core-3/index.html#beans">Objective 1.2 Lifecycle</a>
 *
 * @author Mick Knutson
 * at_see <a href="http://www.baselogic.com">Blog: http://baselogic.com</a>
 * at_see <a href="http://linkedin.com/in/mickknutson">LinkedIN: http://linkedin.com/in/mickknutson</a>
 * at_see <a href="http://twitter.com/mickknutson">Twitter: http://twitter.com/mickknutson</a>
 * at_see <a href="http://github.com/mickknutson">Git hub: http://github.com/mickknutson</a>
 *
 * at_see <a href="http://www.packtpub.com/java-ee6-securing-tuning-extending-enterprise-applications-cookbook/book">JavaEE 6 Cookbook Packt</a>
 * at_see <a href="http://www.amazon.com/Cookbook-securing-extending-enterprise-applications/dp/1849683166">JavaEE 6 Cookbook Amazon</a>
 *
 * @since 2012
 *
 */
@RunWith(PowerMockRunner.class)
@SuppressStaticInitializationFor("com.baselogic.tutorials.util.ExampleUtils")
@PrepareForTest({ ContextUtils.class })
public class ExampleMockServiceTests {

	private ExampleService service;

	@Before
	public void beforeEachUnitTest(){
		service = new ExampleServiceImpl();
	}

	@After
	public void afterEachUnitTest(){
		service = null;
	}



	public void testReadOnce() throws Exception {
		assertEquals("Hello world!", service.getMessage());
	}

}
