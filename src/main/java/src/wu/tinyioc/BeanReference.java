package src.wu.tinyioc;

public class BeanReference {

	private String name;
	private Object bean;
	
	public BeanReference(String name) {
		this.name = name;
	}
	public String getNameString() {
		return name;
	}
	public void setNameString(String nameString) {
		this.name = nameString;
	}
	public Object getBean() {
		return bean;
	}
	public void setBean(Object bean) {
		this.bean = bean;
	}
	
}
