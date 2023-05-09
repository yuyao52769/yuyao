package cn.yuyao.springframework.beans.factory;

public interface BeanFactoryAware extends Aware{

    void setBeanFactory(BeanFactory beanFactory) throws Exception;
}
