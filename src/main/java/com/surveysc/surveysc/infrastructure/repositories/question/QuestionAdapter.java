package com.surveysc.surveysc.infrastructure.repositories.question;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.surveysc.surveysc.application.services.question.QuestionService;
import com.surveysc.surveysc.domain.entities.Question;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class QuestionAdapter implements QuestionService{

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Question save(Question question){
        return questionRepository.save(question);
    }

    @Override
    public Page<Question> findAll(Pageable pageable) {
        return questionRepository.findAll(pageable);
    }

    
    @Override
    @Transactional
    public void remove(Long id) {
        
        questionRepository.removeById(id);

    }

        @Override
    @Transactional
    public Question update(Question question) {
        if (questionRepository.existsById(question.getId())) {
            return questionRepository.save(question);
        } else {
            throw new EntityNotFoundException("Question not found with id: " + question.getId());
        }
    }

    @Override
    public Optional<Question> findById(Long id) {
        return questionRepository.findById(id);
    }
}
