package com.jz.tools.config;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
@Aspect
public class AopConfig {
	private static final Logger logger = LoggerFactory.getLogger(AopConfig.class);
	private long start = 0L;
	private long end = 0L;

	@Pointcut("execution(* com.jz.tools.*.controller..*.*(..))")
	public void execute() {

	}

	// 前置通知,方法执行之前执行
	@Before("execute()")
	public void BeforeMethod(JoinPoint jp) {
		start = System.currentTimeMillis();
	}

	// 返回通知,方法正常执行完毕之后执行
	@AfterReturning(value = "execute()", returning = "result")
	public void AfterReturningMethod(JoinPoint jp, Object result) {
		end = System.currentTimeMillis();
		long time = (end - start);
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
		ServletRequestAttributes sra = (ServletRequestAttributes) ra;
		assert sra != null;
		HttpServletRequest request = sra.getRequest();
		logger.debug("当前用户IP:" + request.getRemoteHost());
		logger.debug("当前请求:" + request.getRequestURI());
		logger.debug("当前方法:" + jp.getSignature().getName());
		logger.debug("执行时间:" + time + "ms");
		logger.debug("返回值为: " + result);
		System.out.println();
	}
}
