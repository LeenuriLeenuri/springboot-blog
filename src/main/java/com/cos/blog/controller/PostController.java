package com.cos.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostController {

		// 메인 주소(들어가는 주소)
		@GetMapping({"", "/", "/post"})
		public String posts() {
			return "/post/list";
		}
		
		@GetMapping("/post/{id}")
		public String post() {
			return "/post/detail";
		}
		
		@GetMapping("/post/write")
		public String write() {
			return "/post/write";
		}
		
		@GetMapping("/post/update/{id}")
		public String update() {
			return "/post/update";
		}
}
