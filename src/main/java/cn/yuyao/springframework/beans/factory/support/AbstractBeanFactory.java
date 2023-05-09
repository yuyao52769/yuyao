package cn.yuyao.springframework.beans.factory.support;

import cn.yuyao.springframework.beans.factory.config.BeanDefinition;
import cn.yuyao.springframework.beans.factory.config.BeanPostProcessor;
import cn.yuyao.springframework.beans.factory.config.ConfigurableBeanFactory;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegister implements ConfigurableBeanFactory {

    /** BeanPostProcessors to apply in createBean */
    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

    @Override
    public Object getBean(String name) throws Exception {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) throws Exception {
       return doGetBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws Exception {
        return (T) getBean(name);
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


    /**
     * Return the list of BeanPostProcessors that will get applied
     * to beans created with this factory.
     */
    public List<BeanPostProcessor> getBeanPostProcessors() {
        return this.beanPostProcessors;
    }

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor){
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }

}
