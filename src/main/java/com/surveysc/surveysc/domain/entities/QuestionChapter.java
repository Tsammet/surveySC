package com.surveysc.surveysc.domain.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "question_chapters")
public class QuestionChapter {

    @EmbeddedId
    private QuestionChapterPk id;

    @ManyToOne
    @JoinColumn(name = "chapter_id", insertable = false, updatable = false)
    private Chapter chapters;

    @ManyToOne
    @JoinColumn(name = "question_id", insertable = false, updatable = false)
    private Question questions;

    public QuestionChapter() {
    }

    public QuestionChapterPk getId() {
        return id;
    }

    public void setId(QuestionChapterPk id) {
        this.id = id;
    }

    public Chapter getChapters() {
        return chapters;
    }

    public void setChapters(Chapter chapters) {
        this.chapters = chapters;
    }

    public Question getQuestions() {
        return questions;
    }

    public void setQuestions(Question questions) {
        this.questions = questions;
    }

    



}
