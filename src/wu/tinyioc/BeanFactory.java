package wu.tinyioc;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BeanFactory {
	
	private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

	/**
	 * ע��bean����ָ����key��
	 * @param name
	 * @param beanDefinition
	 */
	public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
		beanDefinitionMap.put(name, beanDefinition);
	}
	
	/**
	 * desc ��ȡָ��key��bean����
	 * @param name
	 * @return
	 */
	public Object getBean(String name) {
		return beanDefinitionMap.get(name).getBean();
	}
}
