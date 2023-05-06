package cn.yuyao.springframework.core.io;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import cn.yuyao.springframework.util.ClassUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ClassPathResource implements Resource {

    private final String path;

    private ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path, null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        this.path = path;
        this.classLoader = classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader();
    }

    @Override
    public InputStream getInputStream() throws IOException {
        InputStream is = classLoader.getResourceAsStream(path);
        if (is == null) {
            throw  new FileNotFoundException("file not found: " + path);
        }
        return is;
    }
}
