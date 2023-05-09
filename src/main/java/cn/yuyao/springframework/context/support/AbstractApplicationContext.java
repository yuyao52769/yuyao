package cn.yuyao.springframework.context.support;

import cn.yuyao.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.yuyao.springframework.beans.factory.config.ConfigurableBeanFactory;
import cn.yuyao.springframework.context.ConfigurableApplicationContext;
import cn.yuyao.springframework.core.io.DefaultResourceLoader;

import java.util.Map;

public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {

    @Override
    public void refresh() throws Exception {

    }

    /**
     * 创建 BeanFactory，并加载 BeanDefinition
     */
    protected abstract void refreshBeanFactory();

    /**
     * 获取 BeanFactory
     * @return
     */
    protected abstract ConfigurableListableBeanFactory getBeanFactory();

    private void invokeBeanFactoryPostProcessors(ConfigurableBeanFactory beanFactory){
    }

    private void registerBeanPostProcessors(ConfigurableBeanFactory beanFactory){

    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws Exception {
        return getBeanFactory().getBeansOfType(type);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }

    @Override
    public Object getBean(String name) throws Exception {
        return getBeanFactory().getBean(name);
    }

    @Override
    public Object getBean(String name, Object... args) throws Exception {
        return getBeanFactory().getBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws Exception {
        return getBeanFactory().getBean(name, requiredType);
    }

}
