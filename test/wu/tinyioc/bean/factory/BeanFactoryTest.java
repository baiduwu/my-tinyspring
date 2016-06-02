package wu.tinyioc.bean.factory;

import static org.junit.Assert.*;

import org.junit.Test;

import wu.tinyioc.HelloWorldService;

public class BeanFactoryTest {

	@Test
	public void test() {
		//��ʼ��beanFactory
		BeanFactory beanFactory = new AutowireCapableBeanFactory();
		
		//ע��bean  ��ʱHelloWorldService ����û��new
		BeanDefinition beanDefinition = new BeanDefinition();
		beanDefinition.setBeanClassName("wu.tinyioc.HelloWorldService");
		beanFactory.registerBeanDefinition("helloWorldServie", beanDefinition);
		
		//��ȡBean
		HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldServie");
		helloWorldService.helloWorld();
	}

}
