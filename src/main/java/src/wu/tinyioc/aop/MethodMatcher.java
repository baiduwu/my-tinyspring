package src.wu.tinyioc.aop;

import java.lang.reflect.Method;

public interface MethodMatcher {

	boolean matches(Method method, Class targerClass);
}
