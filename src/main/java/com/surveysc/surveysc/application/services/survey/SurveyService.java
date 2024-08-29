package com.surveysc.surveysc.application.services.survey;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.surveysc.surveysc.domain.entities.Survey;

public interface SurveyService {

    Survey save(Survey survey);

    Page<Survey> findAll(Pageable pageable);

    // Survey update(Long id);


}
