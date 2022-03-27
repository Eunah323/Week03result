package com.sparta.chapter03result.domain;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class SignupRequestDto {

    @NotBlank(message = "아이디는 필수 입력 값입니다.")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-z]).{3,12}", message = "아이디는 영문자와 숫자가 적어도 1개 이상 포함되며 3자~12자여야 합니다.")
    private String username;

    @NotBlank(message = "패스워드는 필수 입력 값입니다.")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-z]).{4,12}", message = "비밀번호는 영문자와 숫자가 1개 이상 포함되며 4자~12자여야 합니다.")
    private String password;

//    @NotBlank(message = "비밀번호와 정확히 일치하게 작성해주세요.")
//    private String rePassword;

    @NotBlank(message = "이메일은 필수 입력 값입니다.")
    @Email(message = "이메일 형식에 맞지 않습니다.")
    private String email;
    @NotBlank(message = "닉네임은 필수 입력 값입니다.")
    private String nickname;
    private boolean admin = false;
    private String adminToken = "";
}
