package com.sjjs.oasystem.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.net.Inet4Address;
import java.net.UnknownHostException;


@Configuration
@EnableSwagger2

public class SwaggerConfig {
    private final Logger logger = LoggerFactory.getLogger(SwaggerConfig.class);
    @Value("${oasystem.name}")
    public String name;
    @Value("${oasystem.version}")
    public String version;
    @Value("${oasystem.author}")
    public String author;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .host("localhost:9999")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("D:\\IdeaProject\\OASystem\\demo\\src\\main\\java\\com\\sjjs\\oasystem\\controller"))
                .paths(PathSelectors.any())
                .build();
    }

    // 构建 api文档的详细信息函数
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(name) //标题
                .version(version) //版本
                .description("系统API描述") //简介
                .contact(new Contact(author, "http://localhost:9999/swagger-ui.html", "c1111111c1@163.com"))
                .build();
    }
}
