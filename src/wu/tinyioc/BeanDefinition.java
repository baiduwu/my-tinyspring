package wu.tinyioc;

/**
 * 
 * @author wuzhiqiang
 *
 */
public class BeanDefinition {
  private Object bean;
  
  /**
   * 
   * @param bean
   */
  public BeanDefinition(Object bean){
	  this.bean = bean;
  }
  
  public Object getBean(){
	  return bean;
  }
}
