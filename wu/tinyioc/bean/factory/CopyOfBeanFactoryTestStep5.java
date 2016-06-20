package wu.tinyioc.bean.factory;

import java.util.Map;

import org.junit.Test;

import src.wu.io.ResourceLoader;
import src.wu.tinyioc.bean.factory.AutowireCapableBeanFactory;
import src.wu.tinyioc.bean.factory.BeanDefinition;
import src.wu.tinyioc.bean.factory.AbstractBeanFactory;
import src.wu.xml.XmlBeanDefinitionReader;
import test.wu.tinyioc.bean.factory.HelloWorldService;


public class CopyOfBeanFactoryTestStep5 {

	@Test
	public void test() throws Exception{
		System.out.println("are you ok?");
		//1/ 读取配置
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
		xmlBeanDefinitionReader.loadBeanDefinitions("wu.xml");
		
		//2/初始化BeanFactory 并且注册bean
		AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
		for(Map.Entry<String, BeanDefinition> beanDefiEntry : xmlBeanDefinitionReader.getRegistry().entrySet()){
			beanFactory.registerBeanDefinition(beanDefiEntry.getKey(), beanDefiEntry.getValue());
		}
		
		//3/ 初始化bean
		
		beanFactory.preInstantiateSingletons();
		
		//3/获取bean
		HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
		
		
		helloWorldService.helloWorld();
	
}
}
