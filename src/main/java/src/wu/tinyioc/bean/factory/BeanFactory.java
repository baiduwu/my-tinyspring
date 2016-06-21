package src.wu.tinyioc.bean.factory;


/**
 * desc ����bean�����Ľӿ�
 * @author wuzhiqiang
 * @date 2016-6-2 ����11:13:23
 */
public interface BeanFactory {

	Object getBean(String name) throws Exception;

}
