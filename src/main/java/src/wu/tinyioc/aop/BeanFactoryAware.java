package src.wu.tinyioc.aop;

import src.wu.tinyioc.bean.factory.BeanFactory;

public interface BeanFactoryAware {

	void setBeanFactory(BeanFactory beanFactory);
}
