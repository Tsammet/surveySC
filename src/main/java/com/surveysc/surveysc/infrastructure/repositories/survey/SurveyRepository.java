package com.surveysc.surveysc.infrastructure.repositories.survey;

import org.springframework.data.jpa.repository.JpaRepository;

import com.surveysc.surveysc.domain.entities.Survey;

public interface SurveyRepository extends JpaRepository<Survey, Long>{

}
