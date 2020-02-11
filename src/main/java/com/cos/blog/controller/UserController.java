package com.cos.blog.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cos.blog.model.RespCM;
import com.cos.blog.model.ReturnCode;
import com.cos.blog.model.user.User;
import com.cos.blog.model.user.dto.ReqJoinDto;
import com.cos.blog.service.UserService;

@Controller
public class UserController {

	private static final String TAG = "UserController: ";
	
	@Value("${file.path}")
	private String fileRealPath;  // 서버에 배포하면 경로 변경해야함.

	@Autowired
	private UserService userService;

	@GetMapping("/user/join")
	public String join() {
		System.out.println("진입1");
		return "/user/join";
	}

	@GetMapping("/user/login")
	public String login() {
		return "/user/login";
	}

	// 인증 체크, 동일인 체크 필요
	@GetMapping("/user/profile/{id}")
	public String profile(@PathVariable int id, @AuthenticationPrincipal User principal) {

		System.out.println("UserController : profile :  "+principal.getProfile());
		
		if (principal.getId() == id) {
			return "/user/profile";
		} else {
			// 잘못된 접근입니다. 권한이 없습니다.
			// 메시지 띄우고 싶으면 PrintWrite걸고 out 쓰면 된다. return은 null
			return "/user/login";
		}
	}

	// 메시지 컨버터(Jackson Mapper)는 request 받을 때 setter로 호출한다.
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

		if (result == -ReturnCode.아이디중복) {
			return new ResponseEntity<RespCM>(new RespCM(ReturnCode.아이디중복, "아이디중복"), HttpStatus.OK);
		} else if (result == ReturnCode.성공) {
			return new ResponseEntity<RespCM>(new RespCM(200, "ok"), HttpStatus.OK);
		} else {
			return new ResponseEntity<RespCM>(new RespCM(500, "fail"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

//	@PostMapping("/user/login")
//	public ResponseEntity<?> login(@Valid @RequestBody ReqLoginDto dto, BindingResult bindingResult) {
//		System.out.println("로그인 컨트롤러까지 진입");
//
//		// request 검증 = AOP로 처리
//
//		// 서비스 호출
//		// principal: 접근 인증된 주체
//		User principal = userService.로그인(dto);
//		System.out.println("로그인 서비스 들어갔다가 나옴");
//
//		if (principal != null) {
//			session.setAttribute("principal", principal);
//			System.out.println("로그인 진입 - ok");
//			return new ResponseEntity<RespCM>(new RespCM(200, "ok"), HttpStatus.OK);
//		} else {
//			System.out.println("로그인 진입 - fail");
//			return new ResponseEntity<RespCM>(new RespCM(400, "fail"), HttpStatus.BAD_REQUEST);
//		}
//	}
	
	// form:form 사용함!!
	@PutMapping("/user/profile")
	public @ResponseBody String profile(
			@RequestParam int id, 
			@RequestParam String password,
			@RequestParam MultipartFile profile,
			@AuthenticationPrincipal User principal){
		
		UUID uuid = UUID.randomUUID();
		String uuidFilename = uuid+"_"+profile.getOriginalFilename();
		
		// nio 객체!!
		Path filePath = Paths.get(fileRealPath+uuidFilename);
		try {
			Files.write(filePath, profile.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int result = userService.수정완료(id, password, uuidFilename, principal);
		
		StringBuffer sb = new StringBuffer();
		if(result == 1) {
			sb.append("<script>");
			sb.append("alert('수정완료');");
			sb.append("location.href='/';");
			sb.append("</script>");
			return sb.toString();
		}else {
			sb.append("<script>");
			sb.append("alert('수정실패');");
			sb.append("history.back();");
			sb.append("</script>");
			return sb.toString();
		}	

	}
}
