package cn.yuyao.springframework.beans.factory.support;

import cn.yuyao.springframework.beans.factory.DisposableBean;
import cn.yuyao.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DefaultSingletonBeanRegister implements SingletonBeanRegistry {

    private Map<String, Object> singletonObjects = new HashMap<String, Object>();

    protected static final Object NULL_OBJECT = new Object();

    private Map<String, DisposableBeanAdapter> disposableBeans = new HashMap<>();

    @Override
    public Object getSingletonBean(String name) {
        return singletonObjects.get(name);
    }

    @Override
    public void destroySingletons() {
        Set<String> keySet = this.disposableBeans.keySet();
        Object[] disposableBeanNames = keySet.toArray();

        for (int i = disposableBeanNames.length - 1; i >= 0; i--) {
            Object beanName = disposableBeanNames[i];
            DisposableBean disposableBean = disposableBeans.remove(beanName);
            try {
                disposableBean.destroy();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }


    public void registerDisposableBean(String beanName, DisposableBeanAdapter adapter) {
        disposableBeans.put(beanName, adapter);
    }

    protected void addSingleton(String name, Object singletonObject) {
        singletonObjects.put(name, singletonObject);
    }
}
