package com.surveysc.surveysc.infrastructure.repositories.chapter;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.surveysc.surveysc.domain.entities.Chapter;
import com.surveysc.surveysc.domain.entities.Survey;

public interface ChapterRepository extends JpaRepository<Chapter, Long >{

    void removeById(Long id);

    List<Chapter> findBySurveys(Survey survey);


}
