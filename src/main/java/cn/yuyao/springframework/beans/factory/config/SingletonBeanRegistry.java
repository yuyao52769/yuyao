package cn.yuyao.springframework.beans.factory.config;

public interface SingletonBeanRegistry {

    Object getSingletonBean(String name);
}
