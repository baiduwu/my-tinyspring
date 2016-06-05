package wu.tinyioc.bean.factory;

import java.lang.reflect.Field;
import java.util.Iterator;



public class AutowireCapableBeanFactory extends AbstractBeanFactory {

	@Override
	protected Object doCreateBean(BeanDefinition beanDefinition) {
		
		Object beanObject;
		try {
			beanObject = beanDefinition.getBeanClass().newInstance();
			return beanObject;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	protected Object createBeanInstance(BeanDefinition beanDefinition) throws Exception {
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
