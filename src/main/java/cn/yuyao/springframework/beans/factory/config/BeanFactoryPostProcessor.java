package cn.yuyao.springframework.beans.factory.config;

import cn.yuyao.springframework.beans.factory.ConfigurableListableBeanFactory;

public interface BeanFactoryPostProcessor {

    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws Exception;
}
