package src.wu.tinyioc.bean.factory;

import java.lang.reflect.Field;
import java.util.Iterator;

import src.wu.tinyioc.BeanReference;



public class AutowireCapableBeanFactory extends AbstractBeanFactory {

	@Override
	protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
		//System.out.println("doCreateBean");
		Object bean = createBeanInstance(beanDefinition);
		
		beanDefinition.setBean(bean);
		
		applyPropertyValues(bean, beanDefinition);
		return bean;
	}
	
	
	protected Object createBeanInstance(BeanDefinition beanDefinition) throws Exception {
		//System.out.println("createBeanInstance");
		return beanDefinition.getBeanClass().newInstance();
	}

	
	protected void applyPropertyValues(Object bean, BeanDefinition mbd) throws Exception {
		for(PropertyValue propertyValue : mbd.getPropertValues().getPropertyValues()){
			Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
			declaredField.setAccessible(true);
			
			Object value = propertyValue.getValue();
			//System.out.println("propertyValue"+value);
			if(value instanceof BeanReference){
				BeanReference beanReference = (BeanReference) value;
				//System.out.println("referrence name:"+beanReference.getNameString());
				value = getBean(beanReference.getNameString());
			}
			
			declaredField.set(bean, value);
			
		}
	}
	

	



}
