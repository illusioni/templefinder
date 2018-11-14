package com.dd.templefinder.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AppAspect {

	private static final Logger LOGGER = LogManager.getLogger(AppAspect.class);

	@Before("execution(* com.dd.templefinder.*.*.*(..))")
	public void logBefore(JoinPoint joinPoint) {
		LOGGER.info(joinPoint.getTarget().getClass().getSimpleName() + "->> Execution Started ->>"+ joinPoint.getSignature().getName());
	}

	@After("execution(* com.dd.templefinder.*.*.*(..))")
	public void logAfter(JoinPoint joinPoint) {
		LOGGER.info(joinPoint.getTarget().getClass().getSimpleName() + "->> Execution Completed ->>"+ joinPoint.getSignature().getName());
	}

}
