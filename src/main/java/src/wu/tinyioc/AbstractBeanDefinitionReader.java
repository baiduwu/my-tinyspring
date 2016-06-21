package src.wu.tinyioc;

import java.util.HashMap;
import java.util.Map;

import src.wu.io.ResourceLoader;
import src.wu.tinyioc.bean.factory.BeanDefinition;

public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

	private Map<String, BeanDefinition> registry;
	
	private ResourceLoader resourceLoader;

	public AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
		this.registry = new HashMap<String, BeanDefinition>();
		this.resourceLoader = resourceLoader;
	}

	public Map<String, BeanDefinition> getRegistry() {
		return registry;
	}

	public ResourceLoader getResourceLoader() {
		return resourceLoader;
	}
	
	
}
