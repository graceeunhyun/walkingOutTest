package jpabook.jpashop;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration	// 스프링 실행시 설정파일 읽어드리기 위한 어노테이션
@EnableSwagger2	// Swagger2를 사용하겠다는 어노테이션
@SuppressWarnings("unchecked")	// warning밑줄 제거를 위한 태그
//아래는 swagger url 테스트
// http://localhost:8080/swagger-ui.html?urls.primaryName=%EC%A0%84%EC%B2%B4#/member-api-controller
public class SwaggerConfig extends WebMvcConfigurationSupport {

    //리소스 핸들러 설정
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }


    // API마다 구분짓기 위한 설정.
    @Bean
    public Docket productApi() {
        return getDocket("유저", Predicates.or(
            PathSelectors.regex("/user.*")));
    }


    @Bean
    public Docket searchApi() {
        return getDocket("예약", Predicates.or(
            PathSelectors.regex("/reservation.*")));
    }


    @Bean
    public Docket commonApi() {
        return getDocket("공통", Predicates.or(
            PathSelectors.regex("/test.*")));

    }

    @Bean
    public Docket allApi() {
        return getDocket("전체", Predicates.or(
            PathSelectors.regex("/*.*")));
    }

        /*
    Docket: Swagger 설정의 핵심이 되는 Bean
    useDefaultResponseMessages: Swagger 에서 제공해주는 기본 응답 코드 (200, 401, 403, 404). false 로 설정하면 기본 응답 코드를 노출하지 않음
    apis: api 스펙이 작성되어 있는 패키지 (Controller) 를 지정
    paths: apis 에 있는 API 중 특정 path 를 선택
    apiInfo:Swagger UI 로 노출할 정보
    */

    //swagger 설정.
    public Docket getDocket(String groupName, Predicate<String> predicate) {
        return new Docket(DocumentationType.SWAGGER_2)
            .groupName(groupName)
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(predicate)
            .build();
    }

    //swagger ui 설정.
    @Bean
    public UiConfiguration uiConfig() {
        return UiConfigurationBuilder.builder()
            .displayRequestDuration(true)
            .validatorUrl("")
            .build();
    }

}
