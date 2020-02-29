package com.bryan.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 使用@ConfigurationProperties明显优于 @Value
 * girl和配置文件中的名字一样 ,需要setter方法
 */
@ConfigurationProperties(prefix = "girl")
//girl和配置文件中的名字一样
public class GirlProperties {

    private String cupSize;
    private Integer age;

    private String[] nodes;

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String[] getNodes() {
        return nodes;
    }

    public void setNodes(String[] nodes) {
        this.nodes = nodes;
    }
}
