package cn.yuyao.springframework.beans.factory;

public interface InitializingBean {

    void afterPropertySet() throws Exception;
}
