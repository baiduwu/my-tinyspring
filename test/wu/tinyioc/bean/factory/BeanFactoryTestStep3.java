package test.wu.tinyioc.bean.factory;

import org.junit.Test;

import src.wu.tinyioc.bean.factory.AutowireCapableBeanFactory;
import src.wu.tinyioc.bean.factory.BeanDefinition;
import src.wu.tinyioc.bean.factory.BeanFactory;
import src.wu.tinyioc.bean.factory.PropertValues;
import src.wu.tinyioc.bean.factory.PropertyValue;


public class BeanFactoryTestStep3 {

	@Test
	public void test() throws Exception{
		//1 初始化beanfactory
		BeanFactory beanFactory = new AutowireCapableBeanFactory();
		
		//2/ bean定义
		BeanDefinition beanDefinition = new BeanDefinition();
		beanDefinition.setBeanClassName("test.wu.tinyioc.bean.factory.HelloWorldService");
		
		//3、 设置属性
		PropertValues propertyValues = new PropertValues();
		propertyValues.addPropertyValue(new PropertyValue("text", "hello world !"));
		
	    beanDefinition.setPropertValues(propertyValues);
	    
	    //4、生成bean
	    beanFactory.registerBeanDefinition("helloWordService", beanDefinition);
	    
	    //5、获取Bean
	    HelloWorldService helloWorldService = (HelloWorldService)beanFactory.getBean("helloWordService");
	    helloWorldService.helloWorld();
	}
	
	
	
	
	
	
	
	
	
	
}
