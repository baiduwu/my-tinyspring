package wu.tinyioc.bean.factory;

import static org.junit.Assert.*;

import org.junit.Test;

import wu.tinyioc.HelloWorldService;

public class BeanFactoryTest {

	@Test
	public void test() {
		//初始化beanFactory
		BeanFactory beanFactory = new AutowireCapableBeanFactory();
		
		//
		
		//注入bean  此时HelloWorldService 对象并没有new
		BeanDefinition beanDefinition = new BeanDefinition();
		beanDefinition.setBeanClassName("wu.tinyioc.HelloWorldService");
		//registerBeanDefinition 中加载doCreate方法生成真正的对象
		beanFactory.registerBeanDefinition("helloWorldServie", beanDefinition);
		
		//获取Bean  此时通过加载do
		HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldServie");
		helloWorldService.helloWorld();
	}

}
