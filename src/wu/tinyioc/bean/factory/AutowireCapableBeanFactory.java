package wu.tinyioc.bean.factory;

import java.lang.reflect.Field;
import java.util.Iterator;



public class AutowireCapableBeanFactory extends AbstractBeanFactory {

	@Override
	protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
		System.out.println("doCreateBean");
		Object bean = createBeanInstance(beanDefinition);
		applyPropertyValues(bean, beanDefinition);
		return bean;
	}
	
	
	protected Object createBeanInstance(BeanDefinition beanDefinition) throws Exception {
		System.out.println("createBeanInstance");
		return beanDefinition.getBeanClass().newInstance();
	}

	
	protected void applyPropertyValues(Object bean, BeanDefinition mbd) throws Exception {
		for(PropertyValue propertyValue : mbd.getPropertValues().getPropertyValues()){
			Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
			declaredField.setAccessible(true);
			declaredField.set(bean, propertyValue.getValue());
			
		}
	}
	

	



}
