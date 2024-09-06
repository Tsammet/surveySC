package com.surveysc.surveysc.infrastructure.repositories.survey;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.surveysc.surveysc.application.services.survey.SurveyService;
import com.surveysc.surveysc.domain.entities.Survey;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

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

    @Override
    @Transactional
    public void remove(Long id) {
        
        surveyRepository.removeById(id);

    }

    @Override
    @Transactional
    public Survey update(Survey survey) {
        if (surveyRepository.existsById(survey.getId())) {
            return surveyRepository.save(survey);
        } else {
            throw new EntityNotFoundException("Survey not found with id: " + survey.getId());
        }
    }

	@Override
	public Optional<Survey> findById(Long id) {
		throw new UnsupportedOperationException("Unimplemented method 'findById'");
	}

}
