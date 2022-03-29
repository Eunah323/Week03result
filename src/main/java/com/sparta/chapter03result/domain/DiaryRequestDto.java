package com.sparta.chapter03result.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DiaryRequestDto {
    private String title;
    private String username;
    private String nickname;
    private String contents;
}