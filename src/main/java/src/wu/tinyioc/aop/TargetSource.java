package src.wu.tinyioc.aop;

public class TargetSource {

	private Class<?>[] targeatClass;
	
	private Object target;

	public TargetSource( Object target, Class<?>[] classes) {

		this.targeatClass = classes;
		this.target = target;
	}

	public Class<?>[] getTargeatClass() {
		return targeatClass;
	}

	public Object getTarget() {
		return target;
	}
	
	
}
