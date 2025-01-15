package com.icia.securitytest.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

//환경설정 클랫를 정의하면 시큐리티 로그인 안뜸
@EnableWebSecurity
@Configuration
//메소드 레벨의 보안을 구성하고 @PreAuthorize, @PostAuthorize, @Secured 등의
//어노테이션을 사용하여 메소드에 대한 접근 제어를 지원
@EnableMethodSecurity(securedEnabled = true)
@Slf4j
public class SecurityConfig {
    //필드
    @Bean //메소드의 반환객체를 Ioc컨테이너에 등록
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//        http.authorizeHttpRequests((authorizeRequests)->
//                authorizeRequests.anyRequest().permitAll());
//        return http.build();
        http.csrf(csrf -> csrf.disable());
//        http.cors(cors->cors.disable());
        http.formLogin(
                form -> form.loginPage("/member/login") //로그인페이지 열기 url
                        .loginProcessingUrl("/member/login") //로그인진행 url
                        .defaultSuccessUrl("/")
                        .failureUrl("/member/login/error") //기본값 /member/login
//                        .usernameParameter("id") //기본값 username
//                        .passwordParameter("pw")//기본값 password
        );
        http.logout(logout ->logout.logoutUrl("/member/logout")
                                    .logoutSuccessUrl("/"));
        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
