package com.surveysc.surveysc.application.services.survey;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.surveysc.surveysc.domain.entities.Survey;

public interface SurveyService {

    Optional<Survey> findById(Long id);

    Survey save(Survey survey);

    Page<Survey> findAll(Pageable pageable);

    void remove(Long id);

    Survey update(Survey survey);

}
