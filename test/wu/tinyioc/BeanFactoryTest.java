package wu.tinyioc;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class BeanFactoryTest {

	@Test
	public void test() {
		//��ʼ��bean����
		BeanFactory beanFactory = new BeanFactory();
		
		BeanDefinition beanDefinition = new BeanDefinition(new HelloWorldService());
		
		//ע��bean
		beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);
		
		//��ȡbean
		HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
		
		helloWorldService.helloWorld();
	}

}
