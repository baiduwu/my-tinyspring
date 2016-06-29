package src.wu.tinyioc.aop;

import java.util.List;

import org.aopalliance.intercept.MethodInterceptor;


import src.wu.tinyioc.bean.factory.AbstractBeanFactory;
import src.wu.tinyioc.bean.factory.BeanFactory;

public class AspectJAwareAdvisorAutoProxyCreator implements BeanPostProcessor, BeanFactoryAware {

	private AbstractBeanFactory beanFactory;
	
	public Object postProcessBeforeInitialization(Object bean, String beanName) {
		// TODO Auto-generated method stub
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws Exception {
		if(bean instanceof AspectJExpressionPointcutAdvisor){
			return bean;
		}
		if(bean instanceof MethodInterceptor){
			return bean;
		}
		List<AspectJExpressionPointcutAdvisor> advisors = beanFactory.getBeansForType(AspectJExpressionPointcutAdvisor.class);
	
		for(AspectJExpressionPointcutAdvisor advisor : advisors){
			if(advisor.getPointcut().getClassFilter().matches(bean.getClass())){
				AdvisedSupport advisedSupport = new AdvisedSupport();
				advisedSupport.setMethodInterceptor((MethodInterceptor) advisor.getAdvice());
				advisedSupport.setMethodMatcher(advisor.getPointcut().getMethodMatcher());

				TargetSource targetSource = new TargetSource(bean, bean.getClass().getInterfaces());
				advisedSupport.setTargetSource(targetSource);

				return new JdkDynamicAopProxy(advisedSupport).getProxy();
			}
		}
		return bean;
	}

	public void setBeanFactory(BeanFactory beanFactory) {
		this.beanFactory = (AbstractBeanFactory) beanFactory;
		
	}

}
