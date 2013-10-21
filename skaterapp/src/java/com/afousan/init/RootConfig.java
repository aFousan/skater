/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afousan.init;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Contains middle-tier services, data sources, etc.
 * @author MacMini
 */
@Configuration
@EnableTransactionManagement
@ComponentScan("com.afousan.service")
@PropertySource("classpath:redis.properties")
public class RootConfig {

    private @Value("${redis.host}")
    String redis_host;
    private @Value("${redis.port}")
    int redis_port;
    private @Value("${resid.pass}")
    String redis_pass;

    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory jcFactory = new JedisConnectionFactory();
        jcFactory.setHostName(redis_host);
        jcFactory.setPort(redis_port);
        jcFactory.setPassword(redis_pass);
        return jcFactory;
    }

    @Bean
    public StringRedisTemplate redisTemplate() {
        StringRedisTemplate srTemplate = new StringRedisTemplate();
        srTemplate.setConnectionFactory(jedisConnectionFactory());
        return srTemplate;
    }
}
