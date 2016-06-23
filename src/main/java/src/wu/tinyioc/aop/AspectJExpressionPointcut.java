package src.wu.tinyioc.aop;

import java.lang.reflect.Method;
import org.aspectj.weaver.tools.*;

import java.security.KeyStore.Builder;
import java.util.HashSet;
import java.util.Set;

public class AspectJExpressionPointcut implements Pointcut, ClassFilter, MethodMatcher {

	private PointcutParser pointcutParser;
	private String expression;
	private PointcutExpression pointcutExpression;
	
	private static final Set<PointcutPrimitive> DEFAULT_SUPPORTED_PRIMITIVES  = new HashSet<PointcutPrimitive>();
	static {
		DEFAULT_SUPPORTED_PRIMITIVES.add(PointcutPrimitive.EXECUTION);
		DEFAULT_SUPPORTED_PRIMITIVES.add(PointcutPrimitive.ARGS);
		DEFAULT_SUPPORTED_PRIMITIVES.add(PointcutPrimitive.REFERENCE);
		DEFAULT_SUPPORTED_PRIMITIVES.add(PointcutPrimitive.THIS);
		DEFAULT_SUPPORTED_PRIMITIVES.add(PointcutPrimitive.TARGET);
		DEFAULT_SUPPORTED_PRIMITIVES.add(PointcutPrimitive.WITHIN);
		DEFAULT_SUPPORTED_PRIMITIVES.add(PointcutPrimitive.AT_ANNOTATION);
		DEFAULT_SUPPORTED_PRIMITIVES.add(PointcutPrimitive.AT_WITHIN);
		DEFAULT_SUPPORTED_PRIMITIVES.add(PointcutPrimitive.AT_ARGS);
		DEFAULT_SUPPORTED_PRIMITIVES.add(PointcutPrimitive.AT_TARGET);
	}
	
	public AspectJExpressionPointcut(){
		this(DEFAULT_SUPPORTED_PRIMITIVES);
	}
	
	public AspectJExpressionPointcut(Set<PointcutPrimitive> supportedPrimitives){
		pointcutParser = pointcutParser.getPointcutParserSupportingSpecifiedPrimitivesAndUsingContextClassloaderForResolution(supportedPrimitives);
	}
	
	protected void checkReadyToMatch(){
		if(pointcutExpression == null){
			pointcutExpression = buildPointcutExpression();
		}
	}
	
	private PointcutExpression buildPointcutExpression(){
		return pointcutParser.parsePointcutExpression(expression);
	}
	
	public void setExpression(String expression) {
		this.expression = expression;
	}
			
	public boolean matches(Method method, Class targerClass) {
		checkReadyToMatch();
		ShadowMatch shadowMatch = pointcutExpression.matchesMethodExecution(method);
		if (shadowMatch.alwaysMatches()) {
			return true;
		} else if (shadowMatch.neverMatches()) {
			return false;
		}
		// TODO:其他情况不判断了！见org.springframework.aop.aspectj.RuntimeTestWalker
		return false;
	}

	public boolean matches(Class targetClass) {
		// TODO Auto-generated method stub
		checkReadyToMatch();
		return pointcutExpression.couldMatchJoinPointsInType(targetClass);
	}

	public ClassFilter getClassFilter() {
		// TODO Auto-generated method stub
		return this;
	}

	public MethodMatcher gerMethodmatcher() {
		// TODO Auto-generated method stub
		return this;
	}

	
}
