package com.surveysc.surveysc.infrastructure.repositories.responseoption;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.surveysc.surveysc.domain.entities.Question;
import com.surveysc.surveysc.domain.entities.ResponseOption;

public interface ResponseOptionRepository extends JpaRepository<ResponseOption, Long>{

    void removeById(Long id);

    List<ResponseOption> findByQuestions(Question question);


}

