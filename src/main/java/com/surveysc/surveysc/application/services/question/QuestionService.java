package com.surveysc.surveysc.application.services.question;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.surveysc.surveysc.domain.entities.Question;

public interface QuestionService {
    
    Optional<Question> findById(Long id);

    Question save(Question question);

    Page<Question> findAll(Pageable pageable);

    void remove(Long id);

    Question update(Question chapter);
    
}
