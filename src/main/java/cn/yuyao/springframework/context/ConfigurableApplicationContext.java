package cn.yuyao.springframework.context;

public interface ConfigurableApplicationContext extends ApplicationContext {


    /**
     * 刷新容器
     *
     * @throws Exception
     */
    void refresh() throws Exception;


}
