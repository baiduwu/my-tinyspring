package wu.tinyioc;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BeanFactory {
	
	private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

	/**
	 * desc 注册bean
	 * @param name
	 * @param beanDefinition
	 */
	public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
		beanDefinitionMap.put(name, beanDefinition);
	}
	
	/**
	 * desc  获取Bean
	 * @param name
	 * @return
	 */
	public Object getBean(String name) {
		return beanDefinitionMap.get(name).getBean();
	}
}
