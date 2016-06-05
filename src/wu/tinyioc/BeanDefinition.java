package wu.tinyioc;

/**
 * desc 
 * @author wuzhiqiang
 * @date 2016-6-2 
 */
public class BeanDefinition {
  private Object bean;
  
  /**
   * desc 
   * @param bean
   */
  public BeanDefinition(Object bean){
	  this.bean = bean;
  }
  
  public Object getBean(){
	  return bean;
  }
}
