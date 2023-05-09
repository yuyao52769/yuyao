package cn.yuyao.springframework.context;

import cn.yuyao.springframework.beans.factory.Aware;

public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws Exception;
}
