package com.cos.blog.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cos.blog.model.RespCM;
import com.cos.blog.model.ReturnCode;
import com.cos.blog.model.user.User;
import com.cos.blog.model.user.dto.ReqJoinDto;
import com.cos.blog.model.user.dto.ReqLoginDto;
import com.cos.blog.service.UserService;

@Controller
public class UserController {

	private static final String TAG = "UserController: ";

	@Autowired
	private UserService userService;

	@Autowired
	private HttpSession session;

	@GetMapping("/user/join")
	public String join() {
		System.out.println("진입1");
		return "/user/join";
	}

	@GetMapping("/user/login")
	public String login() {
		return "/user/login";
	}

	@GetMapping("/user/logout")
	public String logout() {
		session.invalidate();
		// redirect:/는 location.href와 같다.(함수를 때리는 거다!!, 데이터 들고 감, PostController에 있는
		// 메인주소로 들어가는 방법이다.)
		return "redirect:/";
	}

	// 인증 체크, 동일인 체크 필요
	@GetMapping("/user/profile/{id}")
	public String profile(@PathVariable int id) {

		User principal = (User) session.getAttribute("principal");

		if (principal.getId() == id) {
			return "/user/profile";
		} else {
			// 잘못된 접근입니다. 권한이 없습니다.
			// 메시지 띄우고 싶으면 PrintWrite걸고 out 쓰면 된다. return은 null
			return "/user/login";
		}
	}

	// 메시지 컨버터는 request 받을 때 setter로 호출한다.
	@PostMapping("/user/join")
	public ResponseEntity<?> join(@Valid @RequestBody ReqJoinDto dto, BindingResult bindingResult) {
		System.out.println("진입2");
		System.out.println(TAG + dto.getUsername());
		System.out.println(TAG + dto.getPassword());
		System.out.println(TAG + dto.getEmail());

		// 한글 뱉어내기(한글 입력 방지, dto.getUsername())

		if (bindingResult.hasErrors()) {
			Map<String, String> errorMap = new HashMap<>();

			for (FieldError error : bindingResult.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}

			return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
		}

		System.out.println("1");
		int result = userService.회원가입(dto);

		if (result == -2) {
			return new ResponseEntity<RespCM>(new RespCM(ReturnCode.아이디중복, "아이디중복"), HttpStatus.OK);
		} else if (result == 1) {
			return new ResponseEntity<RespCM>(new RespCM(200, "ok"), HttpStatus.OK);
		} else {
			return new ResponseEntity<RespCM>(new RespCM(500, "fail"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/user/login")
	public ResponseEntity<?> login(@Valid @RequestBody ReqLoginDto dto, BindingResult bindingResult) {
		System.out.println("로그인 컨트롤러까지 진입");

		// request 검증 = AOP로 처리

		// 서비스 호출
		// principal: 접근 인증된 주체
		User principal = userService.로그인(dto);
		System.out.println("로그인 서비스 들어갔다가 나옴");

		if (principal != null) {
			session.setAttribute("principal", principal);
			System.out.println("로그인 진입 - ok");
			return new ResponseEntity<RespCM>(new RespCM(200, "ok"), HttpStatus.OK);
		} else {
			System.out.println("로그인 진입 - fail");
			return new ResponseEntity<RespCM>(new RespCM(400, "fail"), HttpStatus.BAD_REQUEST);
		}
	}
}
