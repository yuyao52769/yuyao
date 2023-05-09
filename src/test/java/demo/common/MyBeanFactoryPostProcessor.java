package demo.common;

import cn.yuyao.springframework.beans.PropertyValue;
import cn.yuyao.springframework.beans.PropertyValues;
import cn.yuyao.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.yuyao.springframework.beans.factory.config.BeanDefinition;
import cn.yuyao.springframework.beans.factory.config.BeanFactoryPostProcessor;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws Exception {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company", "改为：字节跳动"));
    }
}
