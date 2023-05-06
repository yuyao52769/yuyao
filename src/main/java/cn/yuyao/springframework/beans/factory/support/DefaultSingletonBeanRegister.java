package cn.yuyao.springframework.beans.factory.support;

import cn.yuyao.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

public class DefaultSingletonBeanRegister implements SingletonBeanRegistry {

    private Map<String, Object> singletonObjects = new HashMap<String, Object>();

    @Override
    public Object getSingletonBean(String name) {
        return singletonObjects.get(name);
    }

    protected void addSingleton(String name, Object singletonObject) {
        singletonObjects.put(name, singletonObject);
    }
}
