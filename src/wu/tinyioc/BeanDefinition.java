package wu.tinyioc;

/**
 * desc 
 * @author wuzhiqiang
 * @date 2016-6-2 下午10:39:59
 */
public class BeanDefinition {
  private Object bean;
  
  /**
   * desc 构造方法
   * @param bean
   */
  public BeanDefinition(Object bean){
	  this.bean = bean;
  }
  
  public Object getBean(){
	  return bean;
  }
}
