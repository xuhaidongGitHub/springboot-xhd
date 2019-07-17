package com.springboot.xhd.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Configuration用于定义配置类，可替换xml配置文件，被注解的类内部包含有一个或多个被@Bean注解的方法，这些方法将会被AnnotationConfigApplicationContext或AnnotationConfigWebApplicationContext类进行扫描，并用于构建bean定义，初始化Spring容器。
 * @Configuration不可以是final类型；
 * @Configuration不可以是匿名类；
 * 嵌套的@Configuration必须是静态类。
 */
@Configuration
public class HttpConverterConfig {
    /**
     * @Bean作用于方法上，其实就相当于xml配置文件中的bean，表示创建一个Bean并交给Spring容器，方法的返回值类型表示该Bean的类型，方法名表示该Bean的ID。
     *
     * @return
     */
    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        // 1.定义一个converters转换消息的对象
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        // 2.添加fastjson的配置信息
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        // 3.解决乱码的问题
        List<MediaType> fastMediaTypes = new ArrayList<>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        fastConverter.setSupportedMediaTypes(fastMediaTypes);
        // 4.在converter中添加配置信息
        fastConverter.setFastJsonConfig(fastJsonConfig);
        // 5.将converter赋值给HttpMessageConverter
        HttpMessageConverter<?> converter = fastConverter;
        // 6.返回HttpMessageConverters对象
        return new HttpMessageConverters(converter);
    }
}
