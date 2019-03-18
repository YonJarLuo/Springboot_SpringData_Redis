package com.yonjar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by LuoYJ on 2019/1/22.
 * swagger的配置类
 * @Configuration
 * @EnableSwagger2
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .select().apis(RequestHandlerSelectors.basePackage("com.yonjar.controller"))  //注意此处，只需要精确到controller包名（精确到具体的controller类无效）
                .paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo(){  // 创建API的基本信息，这些信息会在Swagger UI中进行显示
        return new ApiInfoBuilder().title("自我学习Redis")// API 标题
                .description("努力学习Redis中")// API描述
                .version("1.0")// 版本号
                .build();
    }
}
