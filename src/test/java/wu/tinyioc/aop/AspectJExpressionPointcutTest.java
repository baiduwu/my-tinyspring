package wu.tinyioc.aop;

import org.junit.Test;

import junit.framework.Assert;
import src.wu.tinyioc.aop.AspectJExpressionPointcut;
import test.wu.tinyioc.bean.factory.HelloWorldService;
import test.wu.tinyioc.bean.factory.HelloWorldServiceImpl;

public class AspectJExpressionPointcutTest {

	@Test
	public void testClassFilter(){
		String expressionString = "execution(* test.wu.tinyioc.bean.factory.*.*(..))";
		
		AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
		
		aspectJExpressionPointcut.setExpression(expressionString);
		
		boolean matches = aspectJExpressionPointcut.getClassFilter().matches(HelloWorldService.class);
		
		Assert.assertTrue(matches);
	}
	
	@Test
    public void testMethodInterceptor() throws Exception {
        String expression = "execution(* test.wu.tinyioc.bean.factory.*.*(..))";
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression(expression);
        boolean matches = aspectJExpressionPointcut.gerMethodmatcher().matches(HelloWorldServiceImpl.class.getDeclaredMethod("helloWorld"),HelloWorldServiceImpl.class);
        Assert.assertTrue(matches);
    }
}
