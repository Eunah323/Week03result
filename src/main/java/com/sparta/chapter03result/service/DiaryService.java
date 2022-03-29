package com.sparta.chapter03result.service;

import com.sparta.chapter03result.model.Diary;
import com.sparta.chapter03result.domain.DiaryRepository;
import com.sparta.chapter03result.domain.DiaryRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class DiaryService {
    private final DiaryRepository diaryRepository;

    @Transactional
    public Long update(Long id, DiaryRequestDto requestDto) {
        Diary diary = diaryRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        diary.update(requestDto);
        return diary.getId();
    }
}