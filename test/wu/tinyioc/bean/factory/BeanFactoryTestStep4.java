package wu.tinyioc.bean.factory;

import java.util.Map;

import org.junit.Test;



import wu.io.ResourceLoader;
import wu.tinyioc.HelloWorldService;
import wu.xml.XmlBeanDefinitionReader;

public class BeanFactoryTestStep4 {

	@Test
	public void test() throws Exception{
		//1/ 读取配置
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
		xmlBeanDefinitionReader.loadBeanDefinitions("wu.xml");
		
		//2/初始化BeanFactory 并且注册bean
		BeanFactory beanFactory = new AutowireCapableBeanFactory();
		for(Map.Entry<String, BeanDefinition> beanDefiEntry : xmlBeanDefinitionReader.getRegistry().entrySet()){
			beanFactory.registerBeanDefinition(beanDefiEntry.getKey(), beanDefiEntry.getValue());
		}
		
		//3/获取bean
		HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
		helloWorldService.helloWorld();
	
}
}
