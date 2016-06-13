package wu.tinyioc.bean.factory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public abstract class AbstractBeanFactory implements BeanFactory {
 
	private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();
	
  

	@Override
	public Object getBean(String name) {
		// TODO Auto-generated method stub
		return beanDefinitionMap.get(name).getBean();
	}

	@Override
	public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception {
		System.out.println("registerBeanDefinition");
		Object bean = doCreateBean(beanDefinition);
		beanDefinition.setBean(bean);
		beanDefinitionMap.put(name, beanDefinition);
	}
	
	protected abstract Object doCreateBean(BeanDefinition beanDefinition) throws Exception;
}
