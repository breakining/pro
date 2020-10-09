package com.ghw.system.config;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * @description: ???
 * @author: ghwei
 * @version: 1.0 2020/9/18 14:37
 */
@Configuration
public class ApplicationConfig {

    @PostConstruct
    public void initFastDfs() throws IOException, MyException {
        ClientGlobal.initByProperties("config/fastdfs.properties");
    }
}
