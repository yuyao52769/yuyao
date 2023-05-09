package cn.yuyao.springframework.beans.factory.support;

import cn.hutool.core.util.StrUtil;
import cn.yuyao.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.yuyao.springframework.beans.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements ConfigurableListableBeanFactory, BeanDefinitionRegistry {

    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();


    @Override
    public BeanDefinition getBeanDefinition(String beanName) throws Exception {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) {
            throw new Exception("Could not find name " + beanName + "bean");
        }
        return beanDefinition;
    }

    @Override
    public void preInstantiateSingletons() throws Exception {
        Set<String> beanNames = beanDefinitionMap.keySet();
        for (String beanName : beanNames) {
            getBean(beanName);
        }
    }

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    @Override
    public boolean containsBeanDefinition(String beanName) {
        if (StrUtil.isEmpty(beanName)){
            return false;
        }
        return this.beanDefinitionMap.containsKey(beanName);
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws Exception {
        Map<String, T> result = new HashMap<>();
        for (String beanName : beanDefinitionMap.keySet()) {
            if (type.isAssignableFrom(beanDefinitionMap.get(beanName).getBeanClass())){
                result.put(beanName, (T) getBean(beanName));
            }
        }
        return result;
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return beanDefinitionMap.keySet().toArray(new String[0]);
    }
}
