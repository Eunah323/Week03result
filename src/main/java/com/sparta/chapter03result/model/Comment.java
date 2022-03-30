package com.sparta.chapter03result.model;

import com.sparta.chapter03result.domain.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Setter
public class Comment extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column(nullable = false)
    private String contents;

    @ManyToOne
    @JoinColumn(name = "USER_NICKNAME")
    private User user;

    @ManyToOne
    @JoinColumn(name = "DIARY_ID")
    private Diary diary;


    public Comment(String contents, User user, Diary diary) {
        this.contents = contents;
        this.user = user;
        this.diary = diary;

    }
    public Comment(CommentRequestDto requestDto, User user) {
        this.contents = requestDto.getContents();
        this.user = user;
    }

    public long update(CommentRequestDto requestDto) {
        this.contents = requestDto.getContents();
        this.user = user;
        return commentId;
    }

}
