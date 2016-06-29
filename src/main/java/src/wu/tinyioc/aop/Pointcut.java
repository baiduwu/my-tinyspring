package src.wu.tinyioc.aop;

import java.lang.reflect.Method;

public interface Pointcut {

	ClassFilter getClassFilter();
	MethodMatcher getMethodMatcher();
}
