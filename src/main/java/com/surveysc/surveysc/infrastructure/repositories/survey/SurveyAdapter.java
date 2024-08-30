package com.surveysc.surveysc.infrastructure.repositories.survey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Override
    public Page<Survey> findAll(Pageable pageable) {
        return surveyRepository.findAll(pageable);
    }

    // @Override
    // public Optional<Survey> update(Long id, Survey survey){
    //     Optional <Survey> surveyOpt = surveyRepository.findById(id);
    //     if (surveyOpt.isPresent()) {
    //         Survey surveyItem = surveyOpt.orElseThrow();
    //         surveyItem.setName(survey.getName());
    //         surveyItem.setDescription(survey.getDescription());
    //         return Optional.of(surveyRepository.save(surveyItem));
    //     }
    //     return surveyOpt;
    // }

}
