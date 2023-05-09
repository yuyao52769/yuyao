package cn.yuyao.springframework.context.support;

import java.util.Map;

public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext {

    private String[] configLocations;

    public ClassPathXmlApplicationContext(){}

    /**
     * 从 XML 中加载 BeanDefinition，并刷新上下文
     *
     * @param configLocations
     * @throws Exception
     */
    public ClassPathXmlApplicationContext(String configLocations) throws Exception {
        this(new String[]{configLocations});
    }


    /**
     * 从 XML 中加载 BeanDefinition，并刷新上下文
     * @param configLocations
     * @throws Exception
     */
    public ClassPathXmlApplicationContext(String[] configLocations) throws Exception {
        this.configLocations = configLocations;
        refresh();
    }




    @Override
    protected String[] getConfigLocation() {
        return configLocations;
    }

}
