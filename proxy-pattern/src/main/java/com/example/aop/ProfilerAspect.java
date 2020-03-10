package com.example.aop;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class ProfilerAspect {
	private static Logger logger = Logger.getLogger(ProfilerAspect.class.getName());

	@Around("@annotation(profiler)")
	public Object profileMethod(ProceedingJoinPoint pjp, Profiler profiler) throws Throwable {
		return profile(pjp, profiler);
	}

	@Around("@target(profiler) && execution(* com.example..*(..))")
	public Object profileAllClassMethods(ProceedingJoinPoint pjp, Profiler profiler) throws Throwable {
		return profile(pjp, profiler);
	}

	public Object profile(ProceedingJoinPoint pjp, Profiler profile) throws Throwable {
		String methodName = pjp.getSignature().getName();
		long start = System.nanoTime();
		Object result = pjp.proceed();
		long stop = System.nanoTime();
		long duration = stop - start;
		long convertedDuration = profile.value().convert(duration, TimeUnit.NANOSECONDS);
		logger.info(
				String.format("%s runs %d %s.", methodName, convertedDuration, profile.value().name().toLowerCase()));
		return result;
	}
}
