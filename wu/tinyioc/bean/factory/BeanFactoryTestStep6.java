package wu.tinyioc.bean.factory;

import org.junit.Test;


import src.wu.tinyioc.context.ApplicationContext;
import src.wu.tinyioc.context.ClassPathXmlApplicationContext;

import test.wu.tinyioc.bean.factory.HelloWorldService;


public class BeanFactoryTestStep6 {

	@Test
	public void test() throws Exception{
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("wu.xml");
		HelloWorldService helloWorldService = (HelloWorldService) applicationContext.getBean("helloWorldService");
	
		helloWorldService.helloWorld();
}
}
