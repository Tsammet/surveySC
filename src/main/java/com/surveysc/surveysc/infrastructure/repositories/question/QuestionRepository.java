package com.surveysc.surveysc.infrastructure.repositories.question;

import org.springframework.data.jpa.repository.JpaRepository;

import com.surveysc.surveysc.domain.entities.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    void removeById(Long id);

}
