package wu.tinyioc;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class BeanFactoryTest {

	@Test
	public void test() {
		//生成bean工厂
		BeanFactory beanFactory = new BeanFactory();
		
		BeanDefinition beanDefinition = new BeanDefinition(new HelloWorldService());
		
		//注入bean
		beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);
		
		//获取bean
		HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
		
		helloWorldService.helloWorld();
	}

}
