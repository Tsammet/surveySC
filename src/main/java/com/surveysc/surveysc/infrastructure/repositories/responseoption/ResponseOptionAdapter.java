package com.surveysc.surveysc.infrastructure.repositories.responseoption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surveysc.surveysc.application.services.responseoption.ResponseOptionService;

import com.surveysc.surveysc.domain.entities.ResponseOption;

import com.surveysc.surveysc.infrastructure.repositories.question.QuestionRepository;

@Service
public class ResponseOptionAdapter implements ResponseOptionService {

    @Autowired
    private ResponseOptionRepository responseOptionRepository;

    @Autowired
    private QuestionRepository questionRepository;


   @Override
    public ResponseOption save(ResponseOption responseOption){
        return responseOptionRepository.save(responseOption);
    }

}
