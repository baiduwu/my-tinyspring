package src.wu.tinyioc.aop;

public interface PointcutAdvisor extends Advisor {

	Pointcut getPointcut();
}
