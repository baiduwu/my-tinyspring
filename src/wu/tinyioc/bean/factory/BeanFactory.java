package wu.tinyioc.bean.factory;

import sun.security.krb5.internal.crypto.DesCbcCrcEType;

/**
 * 
 * @author wuzhiqiang
 *
 */
public interface BeanFactory {

	Object getBean(String name);
	void registerBeanDefinition(String name, BeanDefinition beanDefinition);

}
