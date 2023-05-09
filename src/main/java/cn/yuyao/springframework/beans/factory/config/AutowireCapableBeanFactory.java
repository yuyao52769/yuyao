package cn.yuyao.springframework.beans.factory.config;

import cn.yuyao.springframework.beans.factory.BeanFactory;

public interface AutowireCapableBeanFactory extends BeanFactory {

    /**
     * 执行 BeanPostProcessors 接口实现类的 postProcessBeforeInitialization 方法
     *
     * @param existingBean
     * @param beanName
     * @return
     * @throws Exception
     */
    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws Exception;

    /**
     * 执行 BeanPostProcessors 接口实现类的 postProcessorsAfterInitialization 方法
     *
     * @param existingBean
     * @param beanName
     * @return
     * @throws Exception
     */
    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws Exception;
}
