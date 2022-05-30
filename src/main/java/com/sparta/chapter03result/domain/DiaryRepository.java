package com.sparta.chapter03result.domain;

import com.sparta.chapter03result.model.Diary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryRepository extends JpaRepository<Diary, Long> {
}