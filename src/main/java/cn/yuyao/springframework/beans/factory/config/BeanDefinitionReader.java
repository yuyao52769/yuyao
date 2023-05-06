package cn.yuyao.springframework.beans.factory.config;

import cn.yuyao.springframework.beans.factory.support.BeanDefinitionRegistry;
import cn.yuyao.springframework.core.io.Resource;
import cn.yuyao.springframework.core.io.ResourceLoader;

public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws Exception;

    void loadBeanDefinitions(Resource... resources) throws Exception;

    void loadBeanDefinitions(String location) throws Exception;
}
