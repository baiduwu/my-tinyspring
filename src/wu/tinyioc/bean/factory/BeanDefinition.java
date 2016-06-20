package src.wu.tinyioc.bean.factory;


public class BeanDefinition {

	private Object bean;
    private Class beanClass;
	
	private String beanClassName;
	
	private PropertValues propertValues = new PropertValues();
	
	

	public BeanDefinition(){
		
	}
	
	public Object getBean() {
		return bean;
	}

	public void setBean(Object bean) {
		this.bean = bean;
	}

	public Class getBeanClass() {
		return beanClass;
	}

	public void setBeanClass(Class beanClass) {
		this.beanClass = beanClass;
	}

	public String getBeanClassName() {
		return beanClassName;
	}

	public void setBeanClassName(String beanClassName) {
		this.beanClassName = beanClassName;
		try {
			this.beanClass = Class.forName(beanClassName);
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public PropertValues getPropertValues() {
		return propertValues;
	}
	
	public void setPropertValues(PropertValues propertValues) {
		this.propertValues = propertValues;
	}
	
	

	
	

}
