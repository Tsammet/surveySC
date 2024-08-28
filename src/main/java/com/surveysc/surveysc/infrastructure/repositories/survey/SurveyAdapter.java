package com.surveysc.surveysc.infrastructure.repositories.survey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surveysc.surveysc.application.services.survey.SurveyService;
import com.surveysc.surveysc.domain.entities.Survey;

@Service    
public class SurveyAdapter implements SurveyService {

    @Autowired
    private SurveyRepository surveyRepository;
    

    @Override
    public Survey save(Survey survey) {
        return surveyRepository.save(survey);
    }

}
