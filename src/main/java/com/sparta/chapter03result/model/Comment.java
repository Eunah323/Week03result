package com.sparta.chapter03result.model;

import com.sparta.chapter03result.domain.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@NoArgsConstructor
@Getter
@Entity
@Setter
public class Comment extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;
    @Column(nullable = false)
    private String nickname;
    @Column(nullable = false)
    private String contents;
    @Column(nullable = false)
    private Long diaryId;
    @javax.persistence.Id
    private Long id;

    public Comment(CommentRequestDto requestDto, String nickname) {
        this.contents = requestDto.getContents();
        this.diaryId = requestDto.getDiaryId();
        this.nickname = nickname;
    }

    public long update (CommentRequestDto requestDto){
        this.contents = requestDto.getContents();
        this.diaryId = requestDto.getDiaryId();
        return commentId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
