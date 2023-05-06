package cn.yuyao.springframework.beans.factory;


public interface BeanFactory {

    Object getBean(String name) throws Exception;

    Object getBean(String name, Object... args) throws Exception;
}
