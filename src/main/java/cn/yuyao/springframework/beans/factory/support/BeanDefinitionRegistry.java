package cn.yuyao.springframework.beans.factory.support;


public interface BeanDefinitionRegistry {

    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
