package src.wu.tinyioc.bean.factory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import sun.org.mozilla.javascript.internal.ast.NewExpression;





public abstract class AbstractBeanFactory implements BeanFactory {
 
	private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();
	
	private final List<String> beanDefinitionNames = new ArrayList<String>();
  

	public Object getBean(String name) {
		// TODO Auto-generated method stub
		return beanDefinitionMap.get(name).getBean();
	}

	public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception {
		System.out.println("registerBeanDefinition");
		Object bean = doCreateBean(beanDefinition);
		beanDefinition.setBean(bean);
		beanDefinitionMap.put(name, beanDefinition);
	}
	
	public void preInstantiateSingletons(){
		for(Iterator it = this.beanDefinitionNames.iterator(); it.hasNext();){
			String beanName = (String) it.next();
			getBean(beanName);
		}
	}
	
	protected abstract Object doCreateBean(BeanDefinition beanDefinition) throws Exception;
}
