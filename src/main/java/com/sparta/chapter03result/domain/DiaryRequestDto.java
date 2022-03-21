package com.sparta.chapter03result.domain;

import lombok.Getter;

@Getter
public class DiaryRequestDto {
    private String title;
    private String username;
    private String nickname;
    private String contents;
}
