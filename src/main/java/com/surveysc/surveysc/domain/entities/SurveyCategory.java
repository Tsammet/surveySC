package com.surveysc.surveysc.domain.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "survey_category")
public class SurveyCategory {

    @EmbeddedId
    private SurveyCategoryPk id;

    @ManyToOne
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    private CategoryCatalog categoriescatalog;

    @ManyToOne
    @JoinColumn(name = "survey_id", insertable = false, updatable = false)
    private Survey surveys;

    public SurveyCategory() {
    }

    public SurveyCategoryPk getId() {
        return id;
    }

    public void setId(SurveyCategoryPk id) {
        this.id = id;
    }

    public CategoryCatalog getCategoriescatalog() {
        return categoriescatalog;
    }

    public void setCategoriescatalog(CategoryCatalog categoriescatalog) {
        this.categoriescatalog = categoriescatalog;
    }

    public Survey getSurveys() {
        return surveys;
    }

    public void setSurveys(Survey surveys) {
        this.surveys = surveys;
    }








}
