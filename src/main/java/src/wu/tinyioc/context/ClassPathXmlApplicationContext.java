package src.wu.tinyioc.context;

import java.util.Map;

import src.wu.io.ResourceLoader;
import src.wu.tinyioc.bean.factory.AbstractBeanFactory;
import src.wu.tinyioc.bean.factory.AutowireCapableBeanFactory;
import src.wu.tinyioc.bean.factory.BeanDefinition;
import src.wu.xml.XmlBeanDefinitionReader;

public class ClassPathXmlApplicationContext extends AbstractApplicationContext {
	
	private String configlocation;

	public ClassPathXmlApplicationContext(String configLocation) throws Exception {
		this(configLocation, new AutowireCapableBeanFactory());
		// TODO Auto-generated constructor stub
	}
	
	public ClassPathXmlApplicationContext(String configLocation, AbstractBeanFactory beanFactory) throws Exception{
		super(beanFactory);
		this.configlocation = configLocation;
		refresh();
	}
	
	public void refresh() throws Exception{
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
		xmlBeanDefinitionReader.loadBeanDefinitions(configlocation);
		for(Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()){
			beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
			
		}
	}

	

}
