package com.surveysc.surveysc.application.services.dto;

public class ChapterDto {

    private Long id;
    private String chapterNumber;
    private String chapterTitle;
    private Long surveyId;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
    public Long getSurveyId() {
        return surveyId;
    }
    public void setSurveyId(Long surveyId) {
        this.surveyId = surveyId;
    }

    

}
