package com.baselogic.aspects;

import java.lang.reflect.Method;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.MethodBeforeAdvice;

import com.baselogic.dao.OrderDAO;
import com.baselogic.domain.Order;

/**
 * AfterReturningAdvice
 * 
 * Spring supported types of pointcuts:
 * 
 * <b>execution</b> - for matching method execution join points, this is the primary pointcut designator you
 * will use when working with Spring AOP
 * 
 * <b>within</b> - limits matching to join points within certain types (simply the execution of a method
 * declared within a matching type when using Spring AOP)
 * 
 * <b>this</b> - limits matching to join points (the execution of methods when using Spring AOP) where the
 * bean reference (Spring AOP proxy) is an instance of the given type
 * 
 * <b>target</b> - limits matching to join points (the execution of methods when using Spring AOP) where the
 * target object (application object being proxied) is an instance of the given type
 * 
 * <b>args</b> - limits matching to join points (the execution of methods when using Spring AOP) where the
 * arguments are instances of the given types
 * 
 * <b>@target</b> - limits matching to join points (the execution of methods when using Spring AOP) where the
 * class of the executing object has an annotation of the given type
 * 
 * <b>@args</b> - limits matching to join points (the execution of methods when using Spring AOP) where the
 * runtime type of the actual arguments passed have annotations of the given type(s)
 * 
 * <b>@within</b> - limits matching to join points within types that have the given annotation (the execution
 * of methods declared in types with the given annotation when using Spring AOP)
 * 
 * <b>@annotation</b> - limits matching to join points where the subject of the join point (method being
 * executed in Spring AOP) has the given annotation
 * 
 * <p>Spring Certification objective: 2.1 AOP Recommendations</p>
 * <p>Spring Certification objective: 2.2 AOP Pointcuts</p>
 * <p>Spring Certification objective: 2.3 AOP Advice</p>
 * 
 * @see <a href="http://springcert.sourceforge.net/core-3/index.html#aop">Objective 2.1 AOP Recommendations</a>
 * @see <a href="http://springcert.sourceforge.net/core-3/index.html#aop">Objective 2.2 AOP Pointcuts</a>
 * @see <a href="http://springcert.sourceforge.net/core-3/index.html#aop">Objective 2.3 AOP Advice</a>
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
@Aspect
public class AfterReturningAdvice {
	
	private final Logger logger = LoggerFactory.getLogger(AfterReturningAdvice.class);
	
    /** reusable pointcut */
	@Pointcut("execution(public * *(..))")
    private void anyPublicOperation() {}
	
	@Pointcut("execution(private * *(..))")
    private void anyPrivateOperation() {}
    
    @Pointcut("within(com.baselogic.service..*)")
    private void inService() {}
    
    /** combining reusable pointcut */
    @Pointcut("anyPublicOperation() && inService()")
    private void serviceOperation() {}
    
    @Pointcut("execution(* com.baselogic.dao.*.*(..))")
    public void dataAccessOperation() {}


}