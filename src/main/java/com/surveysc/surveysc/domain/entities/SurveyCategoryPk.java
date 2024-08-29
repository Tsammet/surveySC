package com.surveysc.surveysc.domain.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;


@Embeddable
public class SurveyCategoryPk implements Serializable {

    @Column(name = "category_id")
    private Long categoryid;

    @Column(name = "survey_id")
    private Long surveyid;

    public SurveyCategoryPk() {
    }

    public Long getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Long categoryid) {
        this.categoryid = categoryid;
    }

    public Long getSurveyid() {
        return surveyid;
    }

    public void setSurveyid(Long surveyid) {
        this.surveyid = surveyid;
    }

}
