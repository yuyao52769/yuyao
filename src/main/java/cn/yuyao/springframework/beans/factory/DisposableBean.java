package cn.yuyao.springframework.beans.factory;

public interface DisposableBean {

    void destroy() throws Exception;
}
