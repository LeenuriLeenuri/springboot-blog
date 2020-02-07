package com.cos.blog.repository;

import com.cos.blog.model.user.User;
import com.cos.blog.model.user.dto.ReqJoinDto;
import com.cos.blog.model.user.dto.ReqLoginDto;

public interface UserRepository {

	int save(ReqJoinDto dto);
	// 유저네임만 찾아서 준 거
	int findByUsername(String username);
	// 유저네임과 비밀번호 찾아서 준 거
	User findByUsernameAndPassword(ReqLoginDto dto);
}
