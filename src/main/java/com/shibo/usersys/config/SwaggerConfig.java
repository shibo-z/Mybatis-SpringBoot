package com.shibo.usersys.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
//用于配置类，开启swagger注解
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket productApi(){
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("UserSys项目接口文档")
                .description("本文档通过swagger2维护")
                .version("0.0.1-SNAPSHOT")
                .build();
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))//扫描@ApiOperation
                .paths(PathSelectors.any())
                .build();
    }
}
