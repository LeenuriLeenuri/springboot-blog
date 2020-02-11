package com.cos.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cos.blog.model.user.User;
import com.cos.blog.repository.UserRepository;

@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	public UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("MyUserDetailService까지 진입");
		User user = userRepository.authentication(username);

		if (user == null) {
			System.out.println("MyUserDetailService의 if까지 들어옴");
			throw new UsernameNotFoundException("해당 유저가 없습니다.");
		}
		return user;
	}
}