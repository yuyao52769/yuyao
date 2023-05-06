package cn.yuyao.springframework.beans.factory.support;

import cn.yuyao.springframework.beans.factory.BeanFactory;
import cn.yuyao.springframework.beans.factory.config.BeanDefinition;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegister implements BeanFactory {

    @Override
    public Object getBean(String name) throws Exception {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) throws Exception {
       return doGetBean(name, args);
    }

    public <T> T doGetBean(final String name, final Object[] args) throws Exception{
        Object bean = getSingletonBean(name);
        if (bean != null) {
            return (T) bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T) createBean(name, beanDefinition, args);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws Exception;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws Exception;
}
