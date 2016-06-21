package src.wu.xml;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import src.wu.tinyioc.AbstractBeanDefinitionReader;
import src.wu.tinyioc.BeanReference;
import src.wu.io.ResourceLoader;
import src.wu.tinyioc.bean.factory.PropertyValue;



import src.wu.io.ResourceLoader;
import src.wu.tinyioc.AbstractBeanDefinitionReader;
import src.wu.tinyioc.bean.factory.BeanDefinition;
import src.wu.tinyioc.bean.factory.PropertyValue;

public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

	public XmlBeanDefinitionReader(ResourceLoader resourceLoader) {
		super(resourceLoader);
		// TODO Auto-generated constructor stub
	}

	public void loadBeanDefinitions(String location) throws Exception {
		InputStream inputStream = getResourceLoader().getResource(location).getInputStream();
		doLoadBeanDefinitions(inputStream);
		
	}

	private void doLoadBeanDefinitions(InputStream inputStream) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = factory.newDocumentBuilder();
		Document doc = documentBuilder.parse(inputStream);
		
		//解析bean
		registerBeanDefinitions(doc);
		inputStream.close();
		
		
		
	}

	private void registerBeanDefinitions(Document doc) {
		Element root = doc.getDocumentElement();
		//System.out.println();
		parseBeanDefinitions(root);
		
	}

	private void parseBeanDefinitions(Element root) {
		NodeList nlList = root.getChildNodes();
		for(int i = 0; i < nlList.getLength(); i++){
			Node node = nlList.item(i);
			if(node instanceof Element){
				Element ele = (Element) node;
				processBeanDefinition(ele);
			}
		}
		
	}

	private void processBeanDefinition(Element ele) {
		String name = ele.getAttribute("name");
		String className = ele.getAttribute("class");
		
		BeanDefinition beanDefinition = new BeanDefinition();
		processproperty(ele, beanDefinition);
		beanDefinition.setBeanClassName(className);
		getRegistry().put(name, beanDefinition);
		
	}

	private void processproperty(Element ele, BeanDefinition beanDefinition) {
		NodeList propertyNode = ele.getElementsByTagName("property");
		for (int i = 0; i < propertyNode.getLength(); i++) {
			Node node = propertyNode.item(i);
			if(node instanceof Element){
				Element propertyElement = (Element) node;
				
				String name = propertyElement.getAttribute("name");
				String value = propertyElement.getAttribute("value");
				/*System.out.println(name);
				System.out.println(value);
				System.out.println(beanDefinition);*/
				if(value != null && value.length()>0){
					beanDefinition.getPropertValues().addPropertyValue(new PropertyValue(name, value));
				}else {
					String ref = propertyElement.getAttribute("ref");
					if(ref == null || ref.length() == 0){
						throw new IllegalArgumentException("Configuration problem: <property> element for property '"
								+ name + "' must specify a ref or value");
					}
					BeanReference beanReference = new BeanReference(ref);
					beanDefinition.getPropertValues().addPropertyValue(new PropertyValue(name, beanReference));
				}
			
			}
		}
		
	}

}
