package com.project.david.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/*
 * 	當你透過UserController呼叫UserService方法，
 * 	實際上SpringBoot會自動產生一個代理對象，
 * 	在執行方法前後調用LoggingAspect中定義的通知方法，
 * 	從而在控制台打印日誌。(不修改業務邏輯就能統一管理日誌、權限檢查、事務管理等橫切關注)
 */

// 定義AOP切面，利用pointcut攔截
@Aspect
@Component
public class LoggingAspect {

	// 定義切入點 : 匹配 com.project.david.service 下的所有方法
	@Pointcut("execution(* com.project.david.service.*.*(..))")
	public void serviceMethods() {
	}

	// 前置通知 : 在目標方法執行前執行
	@Before("serviceMethods()")
	public void logBefore(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println("[AOP箝制通知]方法即將執行: " + methodName + "，傳入參數: " + java.util.Arrays.toString(args));
	}

	// 後置通知 : 在目標方法執行後執行
	@After("serviceMethods()")
	public void logAfter(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("[AOP箝制通知]方法已執行完成: " + methodName);
	}
}
