package src.wu.tinyioc.aop;

public interface BeanPostProcessor {

	Object postProcessBeforeInitialization(Object bean, String beanName) ;
	
	Object postProcessAfterInitialization(Object bean, String beanName) throws Exception;
}
