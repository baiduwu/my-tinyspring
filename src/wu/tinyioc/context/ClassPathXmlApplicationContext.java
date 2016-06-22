package src.wu.tinyioc.context;

import java.util.Map;

import javax.security.auth.Refreshable;

import src.wu.io.ResourceLoader;
import src.wu.tinyioc.bean.factory.AbstractBeanFactory;
import src.wu.tinyioc.bean.factory.AutowireCapableBeanFactory;
import src.wu.tinyioc.bean.factory.BeanDefinition;
import src.wu.tinyioc.bean.factory.BeanFactory;
import src.wu.xml.XmlBeanDefinitionReader;

public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

	private String configLocation;
	@Override
	public Object getBean(String name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	public ClassPathXmlApplicationContext(String configLocation) throws Exception {
		this(configLocation, new AutowireCapableBeanFactory());
	}
	
	public ClassPathXmlApplicationContext(String configLocation, AbstractBeanFactory beanFactory) throws Exception {
		super(beanFactory);
		this.configLocation = configLocation;
		refresh();
	}
	public void refresh() throws Exception {
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
		xmlBeanDefinitionReader.loadBeanDefinitions(configLocation);
		for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
			beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
		}
		
	}
	
	


	

}
