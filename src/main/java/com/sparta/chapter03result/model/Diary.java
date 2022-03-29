package com.sparta.chapter03result.model;

import com.sparta.chapter03result.domain.DiaryRequestDto;
import com.sparta.chapter03result.domain.TimeStamped;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor // 기본생성자를 만듭니다.
@Getter
@Entity // 테이블과 연계됨을 스프링에게 알려줍니다.
public class Diary extends TimeStamped {
    // 생성,수정 시간을 자동으로 만들어줍니다.

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String contents;

    @OneToMany(mappedBy = "diary", fetch = FetchType.LAZY)
    private List<Comment> commentEntityList = new ArrayList<>();




    public Diary(String username, String nickname, String title, String contents) {
        this.username = username;
        this.nickname = nickname;
        this.title = title;
        this.contents = contents;
    }

    public Diary(DiaryRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.nickname = requestDto.getNickname();
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
    }
    public void update(DiaryRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.nickname = requestDto.getNickname();
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
    }

}