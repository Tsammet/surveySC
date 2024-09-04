package com.surveysc.surveysc.application.services.responseoption;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.surveysc.surveysc.domain.entities.ResponseOption;

public interface ResponseOptionService {

    Optional<ResponseOption> findById(Long id);

    ResponseOption save(ResponseOption responseOption);

    ResponseOption update(ResponseOption responseOption);

    void remove(Long id);

    Page<ResponseOption> findAll(Pageable pageable);

    List<ResponseOption> findByQuestionId(Long responseOptionId);



}
