package com.surveysc.surveysc.application.services.responseoption;

import java.util.Optional;

import com.surveysc.surveysc.domain.entities.ResponseOption;

public interface ResponseOptionService {

    Optional<ResponseOption> findById(Long id);

    ResponseOption save(ResponseOption responseOption);

    ResponseOption update(ResponseOption responseOption);

}
