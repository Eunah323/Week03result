package com.sparta.chapter03result.controller;

import com.sparta.chapter03result.domain.CommentRequestDto;
import com.sparta.chapter03result.model.Comment;
import com.sparta.chapter03result.repository.CommentRepository;
import com.sparta.chapter03result.security.UserDetailsImpl;
import com.sparta.chapter03result.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentService commentService;
    private final CommentRepository commentRepository;


    @GetMapping("/api/diaries/{id}/comments")
    public List<Comment> getComments() {

        return commentRepository.findAll(Sort.by(Sort.Direction.DESC, "modifiedAt"));
    }

    @PostMapping("/api/diaries/{id}/comments")
    public Comment createComment(@RequestBody CommentRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return commentService.createComment(requestDto, userDetails);
    }


    @DeleteMapping("/comments")
    public Long deleteComment(@PathVariable Long id) {
        return commentService.deleteComment(id);
    }

    @PutMapping("/comments")
    public Long updateComment(@PathVariable Long id, @RequestBody CommentRequestDto requestDto) {
        return commentService.update(id, requestDto);
    }
}
