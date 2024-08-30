package com.surveysc.surveysc.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "response_options")
public class ResponseOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(10)", nullable = false)
    private String option_value;
    
    @ManyToOne
    @JoinColumn(name = "categorycatalog_id")
    private CategoryCatalog categoryCatalog;
    
    @Embedded
    private Audit audit = new Audit();
    
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question questions;
    
    @Column(columnDefinition = "VARCHAR(30)", nullable = false)
    private String typeComponentHtml;
    
    @Column(columnDefinition = "TEXT", nullable = false)
    private String commentResponse;
    
    @Column(columnDefinition = "TEXT", nullable = false)
    private String optionText;

    public ResponseOption() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOption_value() {
        return option_value;
    }

    public void setOption_value(String option_value) {
        this.option_value = option_value;
    }

    public CategoryCatalog getCategoriesCatalog() {
        return categoryCatalog;
    }

    public void setCategoriesCatalog(CategoryCatalog categoriesCatalog) {
        this.categoryCatalog = categoriesCatalog;
    }

    public Audit getAudit() {
        return audit;
    }

    public void setAudit(Audit audit) {
        this.audit = audit;
    }


    public Question getQuestions() {
        return questions;
    }

    public void setQuestions(Question questions) {
        this.questions = questions;
    }

    public String getTypeComponentHtml() {
        return typeComponentHtml;
    }

    public void setTypeComponentHtml(String typeComponentHtml) {
        this.typeComponentHtml = typeComponentHtml;
    }

    public String getCommentResponse() {
        return commentResponse;
    }

    public void setCommentResponse(String commentResponse) {
        this.commentResponse = commentResponse;
    }

    public String getOptionText() {
        return optionText;
    }

    public void setOptionText(String optionText) {
        this.optionText = optionText;
    }

}
