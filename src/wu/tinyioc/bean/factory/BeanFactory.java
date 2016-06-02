package wu.tinyioc.bean.factory;

import sun.security.krb5.internal.crypto.DesCbcCrcEType;

/**
 * desc 定义bean工厂的接口
 * @author wuzhiqiang
 * @date 2016-6-2 下午11:13:23
 */
public interface BeanFactory {

	Object getBean(String name);
	void registerBeanDefinition(String name, BeanDefinition beanDefinition);

}
