package com.sparta.chapter03result.controller;

import com.sparta.chapter03result.domain.Diary;
import com.sparta.chapter03result.domain.DiaryRepository;
import com.sparta.chapter03result.domain.DiaryRequestDto;
import com.sparta.chapter03result.service.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class DiaryController {

    private final DiaryRepository diaryRepository;

    @GetMapping("/api/diaries")
    public List<Diary> getDiaries() {
        return diaryRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

//    @RequestMapping("/api/diaries/{id}")
//    public Long getDiary(@PathVariable Long id, @RequestBody DiaryRequestDto requestDto) {
//        return diaryRepository.findById();
//    }

    private final DiaryService diaryService;

    @PutMapping("/api/diaries/{id}")
    public Long updateDiary(@PathVariable Long id, @RequestBody DiaryRequestDto requestDto) {
        return diaryService.update(id, requestDto);
    }
    @DeleteMapping("/api/diaries/{id}")
    public Long deleteDiary(@PathVariable Long id) {
        diaryRepository.deleteById(id);
        return id;
    }

    // PostMapping을 통해서, 같은 주소라도 방식이 다름을 구분합니다.
    @PostMapping("/api/diaries")
    public Diary createDiary(@RequestBody DiaryRequestDto requestDto) {
        // requestDto 는, 생성 요청을 의미합니다.
        // 강의 정보를 만들기 위해서는 강의 제목과 튜터 이름이 필요하잖아요?
        // 그 정보를 가져오는 녀석입니다.

        // 저장하는 것은 Dto가 아니라 Course이니, Dto의 정보를 course에 담아야 합니다.
        // 잠시 뒤 새로운 생성자를 만듭니다.
        Diary diary = new Diary(requestDto);

        // JPA를 이용하여 DB에 저장하고, 그 결과를 반환합니다.
        return diaryRepository.save(diary);
    }
    @GetMapping("/api/diaries/{id}")
    public Diary showdiary(@PathVariable Long id){

        return diaryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("null"));}
    }
