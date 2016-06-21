package wu.tinyioc.aop;

import org.junit.Test;

import src.wu.tinyioc.aop.AdvisedSupport;
import src.wu.tinyioc.aop.JdkDynamicAopProxy;
import src.wu.tinyioc.aop.TargetSource;
import src.wu.tinyioc.context.ApplicationContext;
import src.wu.tinyioc.context.ClassPathXmlApplicationContext;
import test.wu.tinyioc.bean.factory.HelloWorldService;
import wu.tinyioc.bean.factory.TimerInterceptor;

public class JdkDynamicAopProxyTest {

	@Test
	public void testInterceptor() throws Exception{
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("wu.xml");
		
		HelloWorldService helloWorldService = (HelloWorldService) applicationContext.getBean("helloWorldService");
		helloWorldService.helloWorld();
		
		// 1. 设置被代理对象(Joinpoint)
		AdvisedSupport advisedSupport = new AdvisedSupport();
		TargetSource targetSource = new TargetSource(helloWorldService, HelloWorldService.class);
		advisedSupport.setTargetSource(targetSource);

		// 2. 设置拦截器(Advice)
		TimerInterceptor timerInterceptor = new TimerInterceptor();
		advisedSupport.setMethodInterceptor(timerInterceptor);

		// 3. 创建代理(Proxy)
		JdkDynamicAopProxy jdkDynamicAopProxy = new JdkDynamicAopProxy(advisedSupport);
		HelloWorldService helloWorldServiceProxy = (HelloWorldService) jdkDynamicAopProxy.getProxy();

        // 4. 基于AOP的调用
        helloWorldServiceProxy.helloWorld();
	}	
}
