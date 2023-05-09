package cn.yuyao.springframework.context.support;

import cn.yuyao.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.yuyao.springframework.beans.factory.config.ConfigurableBeanFactory;
import cn.yuyao.springframework.beans.factory.support.DefaultListableBeanFactory;

public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {

    private DefaultListableBeanFactory beanFactory;

    @Override
    protected void refreshBeanFactory() {

    }

    private DefaultListableBeanFactory createBeanFactory (){
        return new DefaultListableBeanFactory();
    }

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) throws Exception;


    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return this.beanFactory;
    }
}
