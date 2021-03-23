package com.mhj.demo.config;


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

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                // 为controller包路径
                .apis(RequestHandlerSelectors.basePackage("com.mhj.demo.controller"))//配置扫描的控制器类包
                .paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("MHJ的学习日志")//标题
                .description("项目API")//描述
                .license("MIT")
                .licenseUrl("http://opensource.org/licenses/MIT")
                .contact(new Contact("MHJ的学习日志", "www.baidu.com", "735689793@qq.com"))
                .version("1.0")//版本号
                .build();
        return apiInfo;
    }

}