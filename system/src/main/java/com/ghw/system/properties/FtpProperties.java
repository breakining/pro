package com.ghw.system.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 参数
 *
 * @author ghw
 */
@PropertySource(value = "classpath:config/ftp.properties", encoding = "utf-8")
@Data
@Configuration
public class FtpProperties {

    @Value("${FTP_ADDRESS}")
    private String ftpAddress;

    @Value("${FTP_PORT}")
    private String ftpPort;

    @Value("${FTP_USERNAME}")
    private String ftpUsername;

    @Value("${FTP_PASSWORD}")
    private String ftpPassword;

    @Value("${FTP_BASEPATH}")
    private String ftpBasePath;

    @Value("${IMAGE_BASE_URL}")
    private String imageBaseUrl;
}
