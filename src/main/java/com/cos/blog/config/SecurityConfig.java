package com.cos.blog.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.cos.blog.model.RespCM;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// Bean을 걸어두면 @Autowired로 가져다 쓰면 된다, Bean은 스프링에서 관리한다.
	// static 쓰면 모두의 것이 되서, 충돌난다.(절대 사용 금지!!)
	@Bean
	public BCryptPasswordEncoder encode() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		
		http.authorizeRequests()
				.antMatchers(
						"/user/profile/**", 
						"/post/write/**", 
						"/post/detail/**", 
						"/post/update/**", 
						"/post/delete/**").authenticated()
				.antMatchers("/admin/**").access("hashRole('ROLE_ADMIN') or hashRole('ROLE_MANAGER')")
				.anyRequest().permitAll()
		.and()
				.formLogin()
				// GET으로 로그인 '페이지' 진입할 때
				.loginPage("/user/login")
				// POST로 로그인 하고 진입할 때
				// POST만 낚아 챈다.
				.loginProcessingUrl("/user/loginProc")
				// successHandler를 사용할 수 있다.
				// defaultSuccessUrl 사용할 수 있다.
				.failureHandler(new AuthenticationFailureHandler() {
					
					@Override
					public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
							AuthenticationException exception) throws IOException, ServletException {
						System.out.println(exception.getMessage());
						
					}
				})
				.successHandler(new AuthenticationSuccessHandler() {
					
					@Override
					public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
							Authentication authentication) throws IOException, ServletException {
							System.out.println("SecurityConfig 진입 성공");
							PrintWriter out = response.getWriter();
							
							ObjectMapper mapper = new ObjectMapper();
							
							// String 으로 저장
							String jsonString = mapper.writeValueAsString(new RespCM(200, "ok"));
							System.out.println("jsonString" + jsonString);
							out.print(jsonString);
							out.flush();
					}
				});
	}
	
	@Autowired
	private UserDetailsService userDetailService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailService).passwordEncoder(encode());
	}
}
