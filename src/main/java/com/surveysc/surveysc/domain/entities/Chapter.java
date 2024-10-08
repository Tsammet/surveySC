package com.surveysc.surveysc.domain.entities;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "chapters")
public class Chapter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Audit audit = new Audit();

    @ManyToOne
    @JoinColumn(name = "survey_id")
    private Survey surveys;

    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    private String chapterNumber;

    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    private String chapterTitle;

    @OneToMany(mappedBy = "chapters", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore // Evitar que se serialice la lista de capítulos
    private List<Question> questions;

    public Chapter() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Audit getAudit() {
        return audit;
    }

    public void setAudit(Audit audit) {
        this.audit = audit;
    }

    public Survey getSurveys() {
        return surveys;
    }

    public void setSurveys(Survey surveys) {
        this.surveys = surveys;
    }

    public String getChapterNumber() {
        return chapterNumber;
    }

    public void setChapterNumber(String chapterNumber) {
        this.chapterNumber = chapterNumber;
    }

    public String getChapterTitle() {
        return chapterTitle;
    }

    public void setChapterTitle(String chapterTitle) {
        this.chapterTitle = chapterTitle;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }


    

}
