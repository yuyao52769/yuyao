package cn.yuyao.springframework.beans.factory;


public interface BeanFactory {

    Object getBean(String name) throws Exception;

    Object getBean(String name, Object... args) throws Exception;

    /**
     * 返回指定泛型的对象
     * @param name  要检索的bean的名称
     * @param requiredType 类型
     * @param <T>          泛型
     * @return             实例化的 Bean 对象
     * @throws Exception 不能获取 Bean 对象，则抛出异常
     */
    <T> T getBean(String name, Class<T> requiredType) throws Exception;
}
