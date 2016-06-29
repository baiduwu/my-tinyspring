package wu.tinyioc.aop;

import src.wu.tinyioc.aop.BeanPostProcessor;

public class BeanInitializeLogger implements BeanPostProcessor {

	public Object postProcessBeforeInitialization(Object bean, String beanName) {
		System.out.println("Initialize bean "+ beanName + "start!");
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) {
		System.out.println("Initialize bean " + beanName + " end!");
		return bean;
	}

}
