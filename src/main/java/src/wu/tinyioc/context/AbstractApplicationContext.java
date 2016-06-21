package src.wu.tinyioc.context;

import src.wu.tinyioc.bean.factory.AbstractBeanFactory;

public abstract class AbstractApplicationContext implements ApplicationContext {

	protected AbstractBeanFactory beanFactory;
	
	
	
	public AbstractApplicationContext(AbstractBeanFactory beanFactory) {
		this.beanFactory = beanFactory;
	}


	public void refresh() throws Exception{}

	public Object getBean(String name) throws Exception {
		// TODO Auto-generated method stub
		return beanFactory.getBean(name);
	}

}
