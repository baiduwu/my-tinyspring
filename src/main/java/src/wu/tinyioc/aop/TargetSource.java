package src.wu.tinyioc.aop;

public class TargetSource {

	private Class targeatClass;
	
	private Object target;

	public TargetSource( Object target, Class<?> targeatClass) {
		this.target = target;
		this.targeatClass = targeatClass;
		
	}

	public Class getTargeatClass() {
		return targeatClass;
	}

	public Object getTarget() {
		return target;
	}
	
	
}
