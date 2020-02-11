package com.cos.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.ReturnCode;
import com.cos.blog.model.user.User;
import com.cos.blog.model.user.dto.ReqJoinDto;
import com.cos.blog.model.user.dto.ReqLoginDto;
import com.cos.blog.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Transactional
	public int 회원가입(ReqJoinDto dto) {

		// result = 0 비정상, 1 정상, -1 DB 오류, -2 아이디 중복
		try {
			int result = userRepository.findByUsername(dto.getUsername());
			System.out.println("result:" + result);
			System.out.println("-----------------------------------------------------------");
			if (result == 1) {
				return ReturnCode.아이디중복;
			} else {
				// password 암호화하기
				String encodePassword = passwordEncoder.encode(dto.getPassword());

				dto.setPassword(encodePassword);
				return userRepository.save(dto);
			}

		} catch (Exception e) {
			System.out.println("***********************************************************");
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public User 로그인(ReqLoginDto dto) {
		System.out.println("로그인 서비스까지 진입");
		System.out.println("dto:" + dto);

		return userRepository.findByUsernameAndPassword(dto);
	}

	public int 수정완료(int id, String password, String profile, User principal) {

		String ecodePassword = passwordEncoder.encode(password);
		int result = userRepository.update(id, ecodePassword, profile);

		if (result == 1) { // 수정 성공
			User user = userRepository.findById(id);
			principal.setPassword(user.getPassword());
			principal.setProfile(user.getProfile());

			return 1;
		} else { // 수정 실패
			return -1;
		}
	}
}
