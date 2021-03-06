package com.sparta.chapter03result.service;

import com.sparta.chapter03result.domain.CommentRequestDto;
import com.sparta.chapter03result.domain.DiaryRepository;
import com.sparta.chapter03result.model.Comment;
import com.sparta.chapter03result.model.Diary;
import com.sparta.chapter03result.repository.CommentRepository;
import com.sparta.chapter03result.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final DiaryRepository diaryRepository;
//
//    @Transactional
    public Long update(Long commentId, CommentRequestDto requestDto) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(
                () -> new NullPointerException("해당 댓글은 존재하지 않습니다.")
        );
        comment.update(requestDto);
        return comment.getCommentId();
    }

    public Long deleteComment(Long id) {
        commentRepository.deleteById(id);
        return id;
    }

    //댓글쓰기
    public Comment createComment(CommentRequestDto requestDto, UserDetailsImpl userDetails) {
        Diary diary = null;
        Comment comment = new Comment(requestDto.getContents(), userDetails.getUser(),diary);
        return commentRepository.save(comment);
    }
}
