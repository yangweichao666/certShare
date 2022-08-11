//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.corrin.certshare.component;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
    public SwaggerConfig() {
    }

    @Bean
    public Docket createRestApi() {
        return (new Docket(DocumentationType.SWAGGER_2)).apiInfo(this.apiInfo()).select().apis(RequestHandlerSelectors.basePackage("com.corrin.certshare.controller")).paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        return (new ApiInfoBuilder()).title("山东地市电子证照共享服务对接技术规范（试行）").description("山东省淄博市提供接口").contact(new Contact("王艳宁", "http://172.20.16.128:28080/CertShare/", "wyanning@linewell.com")).version("1.0.0").build();
    }
}
