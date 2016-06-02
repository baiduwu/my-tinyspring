package wu.tinyioc.bean.factory;

import static org.junit.Assert.*;

import org.junit.Test;

import wu.tinyioc.HelloWorldService;

public class BeanFactoryTest {

	@Test
	public void test() {
		//初始化beanFactory
		BeanFactory beanFactory = new AutowireCapableBeanFactory();
		
		//注入bean  此时HelloWorldService 对象并没有new
		BeanDefinition beanDefinition = new BeanDefinition();
		beanDefinition.setBeanClassName("wu.tinyioc.HelloWorldService");
		beanFactory.registerBeanDefinition("helloWorldServie", beanDefinition);
		
		//获取Bean
		HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldServie");
		helloWorldService.helloWorld();
	}

}
