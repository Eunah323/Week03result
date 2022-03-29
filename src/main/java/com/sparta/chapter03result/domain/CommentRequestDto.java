package com.sparta.chapter03result.domain;

import lombok.Getter;

@Getter
public class CommentRequestDto {

    private String contents;
    private Long diaryId;
}
