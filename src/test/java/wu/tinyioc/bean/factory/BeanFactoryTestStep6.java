package wu.tinyioc.bean.factory;

import org.junit.Test;


import src.wu.tinyioc.aop.AdvisedSupport;
import src.wu.tinyioc.aop.JdkDynamicAopProxy;
import src.wu.tinyioc.aop.TargetSource;
import src.wu.tinyioc.context.ApplicationContext;
import src.wu.tinyioc.context.ClassPathXmlApplicationContext;

import test.wu.tinyioc.bean.factory.HelloWorldService;


public class BeanFactoryTestStep6 {

	@Test
	public void test() throws Exception{
		/*System.out.println("ces");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("wu.xml");
		HelloWorldService helloWorldService = (HelloWorldService) applicationContext.getBean("helloWorldService");
	
		helloWorldService.helloWorld();*/
		
		// --------- helloWorldService with AOP
				
}
}
