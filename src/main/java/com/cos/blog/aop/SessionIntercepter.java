package com.cos.blog.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

// 백종원 = 어댑터 패턴
// @Controller, @Configuration, @Service, @Repository
// @Component: 개발자가 직접 작성한 Class를 Bean에 등록하기위한 어노테이션
public class SessionIntercepter extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("principal") == null) {
			System.out.println("인증이 되지 않았습니다, 돌아가시오.");
			response.sendRedirect("/user/login");
			return false;
		}
		
		System.out.println("인증되었습니다.");
		// false면 아예 접근조차 못 한다, true면 접근 가능
		return true;
	}
}
