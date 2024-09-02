package com.surveysc.surveysc.application.services.chapter;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.surveysc.surveysc.domain.entities.Chapter;
import com.surveysc.surveysc.domain.entities.Survey;

public interface ChapterService {

    Optional<Chapter> findById(Long id);

    Chapter save(Chapter chapter);

    Page<Chapter> findAll(Pageable pageable);

    void remove(Long id);

    Chapter update(Chapter chapter);

    List<Chapter> findBySurveyId(Long surveyId);

    
}
