package com.cos.blog.controller;

// 시큐리티 구현 완료(테스트)

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.cos.blog.model.user.User;

@Controller
public class PostController {

	@Autowired
	private HttpSession session;

	// 메인 주소(들어가는 주소)
	@GetMapping({ "", "/", "/post" })
	public String posts() {
		return "/post/list";
	}

	@GetMapping("/post/{id}")
	public String post() {
		return "/post/detail";
	}

	// 인증 체크 필요
	@GetMapping("/post/write")
	public String write() {
		return "/post/write";
	}

	// 인증 체크, 동일인 체크 필요
	@GetMapping("/post/update/{id}")
	public String update(@PathVariable int id, @RequestParam int userid) {
		
		User principal = (User) session.getAttribute("principal");
		
		if(principal.getId() == id) {
			return "/post/update";
		}
		
		// postid 로 select해서 post 가져오기 필요 - Model에 담기 필요
		
		return "/post/update";
	}
}
