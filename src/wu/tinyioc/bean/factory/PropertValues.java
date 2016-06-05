package wu.tinyioc.bean.factory;

import java.util.ArrayList;
import java.util.List;



public class PropertValues {

	private final List<PropertyValue> propertyValueList = new ArrayList<PropertyValue>();
	
	public PropertValues(){}
	
	public void addPropertyValue(PropertyValue pv) {
		System.out.print("heh");
		this.propertyValueList.add(pv);
	}
	
	public List<PropertyValue> getPropertyValues(){
		return this.propertyValueList ;
	}
}
