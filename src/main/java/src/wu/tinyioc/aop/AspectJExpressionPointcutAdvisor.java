package src.wu.tinyioc.aop;

import org.aopalliance.aop.Advice;

public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {

	private AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
	
	private Advice advice;
	
	public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    public void setExpression(String expression) {
    	 this.pointcut.setExpression(expression);
    }

	public Advice getAdvice() {
		// TODO Auto-generated method stub
		return advice;
	}

	public Pointcut getPointcut() {
		// TODO Auto-generated method stub
		return pointcut;
	}
	
	
}
