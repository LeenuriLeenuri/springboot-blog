package com.cos.blog.model.user.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReqLoginDto {

	// 한글 뱉어내기(한글 입력 방지, dto.getUsername())
	@Pattern(regexp = "^[a-zA-Z0-9]*$", message = "유저네임에 한글이 입력될 수 없습니다.")
	@Size(min = 4, max = 20, message="이름 길이가 잘못되었습니다.")
	@NotBlank(message = "이름을 입력하세요.")
	private String username;

	@Size(min = 4, max = 20, message="비밀번호 길이가 잘못되었습니다.")
	@NotBlank(message = "비밀번호를 입력하세요.")
	private String password;
}
