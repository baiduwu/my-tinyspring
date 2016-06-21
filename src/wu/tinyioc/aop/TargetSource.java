package src.wu.tinyioc.aop;

public class TargetSource {

	private Class targeatClass;
	
	private Object target;

	public TargetSource(Class<?> targeatClass, Object target) {

		this.targeatClass = targeatClass;
		this.target = target;
	}

	public Class getTargeatClass() {
		return targeatClass;
	}

	public Object getTarget() {
		return target;
	}
	
	
}
