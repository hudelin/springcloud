package com.hu.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author hudelin
 * @date 2021/3/2
 */
@ConfigurationProperties("com.hu")
public class HelloProperties {

    private String prefix;
    private String suffix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
