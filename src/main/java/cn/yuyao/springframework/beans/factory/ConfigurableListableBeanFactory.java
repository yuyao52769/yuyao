package cn.yuyao.springframework.beans.factory;

import cn.yuyao.springframework.beans.factory.config.AutowireCapableBeanFactory;
import cn.yuyao.springframework.beans.factory.config.BeanDefinition;
import cn.yuyao.springframework.beans.factory.config.ConfigurableBeanFactory;

public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws Exception;

    void preInstantiateSingletons() throws Exception;
}
