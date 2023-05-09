package cn.yuyao.springframework.context.support;

import cn.yuyao.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.yuyao.springframework.beans.factory.xml.XmlBeanDefinitionReader;

public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) throws Exception {
        XmlBeanDefinitionReader definitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocation();
        if (configLocations != null && configLocations.length > 0) {
            definitionReader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocation();
}
