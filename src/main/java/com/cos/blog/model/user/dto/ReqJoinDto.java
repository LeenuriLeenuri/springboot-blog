package com.cos.blog.model.user.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReqJoinDto {

	@Size(min = 7, max = 20, message="이름 길이가 잘못되었습니다.")
	@NotBlank(message = "이름을 입력하세요.")
	private String username;

	@Size(min = 8, max = 20, message="비밀번호 길이가 잘못되었습니다.")
	@NotBlank(message = "비밀번호를 입력하세요.")
	private String password;

	@Size(min = 5, max = 50, message="이메일 길이가 잘못되었습니다.")
	@Email(message = "이메일 양식이 틀렸습니다.")
	@NotBlank(message = "이메일을 입력하세요.")
	private String email;

}
