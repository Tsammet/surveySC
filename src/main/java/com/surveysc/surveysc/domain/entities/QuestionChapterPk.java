package com.surveysc.surveysc.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class QuestionChapterPk implements Serializable{

    @Column(name = "chapter_id")
    private Long chapterid;

    @Column(name = "question_id")
    private Long questionid;

    public QuestionChapterPk() {
    }

    public Long getChapterid() {
        return chapterid;
    }

    public void setChapterid(Long chapterid) {
        this.chapterid = chapterid;
    }

    public Long getQuestionid() {
        return questionid;
    }

    public void setQuestionid(Long questionid) {
        this.questionid = questionid;
    }

    
    

}
