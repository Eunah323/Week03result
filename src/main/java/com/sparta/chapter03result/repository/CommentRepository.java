package com.sparta.chapter03result.repository;

import com.sparta.chapter03result.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByDiaryIdOrderByCreatedAtDesc(Long diaryId);
}
