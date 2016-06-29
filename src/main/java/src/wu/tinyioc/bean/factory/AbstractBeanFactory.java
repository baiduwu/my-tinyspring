package src.wu.tinyioc.bean.factory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import src.wu.tinyioc.aop.BeanPostProcessor;






public abstract class AbstractBeanFactory implements BeanFactory {
 
	private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();
	
	private final List<String> beanDefinitionNames = new ArrayList<String>();
  
	private List<BeanPostProcessor> beanPostProcessors = new ArrayList<BeanPostProcessor>();
	public Object getBean(String name) throws Exception {

		BeanDefinition beanDefinition = beanDefinitionMap.get(name);
		if(beanDefinition == null){
			throw new IllegalArgumentException("NO Bean named" + name + "is defined");
		}
		Object bean = beanDefinition.getBean();
		if(bean == null){
			bean = doCreateBean(beanDefinition);
		}
		return bean;
	}
	
	protected Object createBeanInstance(BeanDefinition beanDefinition) throws Exception {
		return beanDefinition.getBeanClass().newInstance();
	}

	public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception {
		//System.out.println("registerBeanDefinition");

		beanDefinitionMap.put(name, beanDefinition);
		beanDefinitionNames.add(name);
	}
	
	public void preInstantiateSingletons() throws Exception{
		for(Iterator<String> it = this.beanDefinitionNames.iterator(); it.hasNext();){
			String beanName = (String) it.next();
			getBean(beanName);
		}
	}
	
	protected  Object doCreateBean(BeanDefinition beanDefinition) throws Exception{
		Object bean = createBeanInstance(beanDefinition);
		beanDefinition.setBean(bean);
		applyPropertyValues(bean, beanDefinition);
		return bean;
	};
	
	protected void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws Exception {

	}
	
	public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) throws Exception {
		this.beanPostProcessors.add(beanPostProcessor);
	}
	
	public List getBeansForType(Class<?> type) throws Exception {
		List beans = new ArrayList<Object>();
		for (String beanDefinitionName : beanDefinitionNames) {
			if (type.isAssignableFrom(beanDefinitionMap.get(beanDefinitionName).getBeanClass())) {
				beans.add(getBean(beanDefinitionName));
			}
		}
		return beans;
	}
}
