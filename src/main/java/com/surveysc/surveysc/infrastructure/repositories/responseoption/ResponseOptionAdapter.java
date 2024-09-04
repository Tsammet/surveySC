package com.surveysc.surveysc.infrastructure.repositories.responseoption;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.surveysc.surveysc.application.services.responseoption.ResponseOptionService;
import com.surveysc.surveysc.domain.entities.Question;
import com.surveysc.surveysc.domain.entities.ResponseOption;
import com.surveysc.surveysc.infrastructure.repositories.chapter.exceptions.ResourceNotFoundException;
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
    public Page<ResponseOption> findAll(Pageable pageable) {
        return responseOptionRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public void remove(Long id) {
        responseOptionRepository.removeById(id);

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
    public List<ResponseOption> findByQuestionId(Long questionId) {
        // Encuentra la ` por ID
        Question question = questionRepository.findById(questionId)
            .orElseThrow(() -> new ResourceNotFoundException("Chapter not found"));

        // Busca los capítulos asociados a esa encuesta
        return responseOptionRepository.findByQuestions(question);
    }

    

    

   



}
