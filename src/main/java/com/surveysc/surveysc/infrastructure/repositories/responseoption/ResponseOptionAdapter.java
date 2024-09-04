package com.surveysc.surveysc.infrastructure.repositories.responseoption;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surveysc.surveysc.application.services.responseoption.ResponseOptionService;
import com.surveysc.surveysc.domain.entities.ResponseOption;

import com.surveysc.surveysc.infrastructure.repositories.question.QuestionRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

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

    @Override
    @Transactional
    public ResponseOption update(ResponseOption responseOption) {
        if (responseOptionRepository.existsById(responseOption.getId())) {
            return responseOptionRepository.save(responseOption);
        } else {
            throw new EntityNotFoundException("Response option not found with id: " + responseOption.getId());
        }
    }

	@Override
	public Optional<ResponseOption> findById(Long id) {
        return responseOptionRepository.findById(id);
		
	}

    @Override
    @Transactional
    public void remove(Long id) {
        responseOptionRepository.removeById(id);

    }

}
