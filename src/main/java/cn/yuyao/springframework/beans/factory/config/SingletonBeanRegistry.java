package cn.yuyao.springframework.beans.factory.config;

import cn.yuyao.springframework.beans.factory.support.DisposableBeanAdapter;

public interface SingletonBeanRegistry {

    Object getSingletonBean(String name);

    /**
     * 销毁单例对象
     */
    void destroySingletons();
}
