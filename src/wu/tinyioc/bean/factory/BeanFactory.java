package wu.tinyioc.bean.factory;

import sun.security.krb5.internal.crypto.DesCbcCrcEType;

/**
 * desc ����bean�����Ľӿ�
 * @author wuzhiqiang
 * @date 2016-6-2 ����11:13:23
 */
public interface BeanFactory {

	Object getBean(String name);
	void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception;

}
