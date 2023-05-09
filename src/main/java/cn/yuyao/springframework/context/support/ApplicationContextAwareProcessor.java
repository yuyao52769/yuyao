package cn.yuyao.springframework.context.support;

import cn.yuyao.springframework.beans.factory.config.BeanPostProcessor;
import cn.yuyao.springframework.context.ApplicationContext;
import cn.yuyao.springframework.context.ApplicationContextAware;

public class ApplicationContextAwareProcessor implements BeanPostProcessor {

    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }



    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception {
        if (bean instanceof ApplicationContextAware){
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws Exception {
        return bean;
    }
}
