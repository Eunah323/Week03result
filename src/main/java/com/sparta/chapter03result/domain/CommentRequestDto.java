package com.sparta.chapter03result.domain;

import com.sparta.chapter03result.model.Diary;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentRequestDto {

    private String contents;
    private Diary diaryId;
}
