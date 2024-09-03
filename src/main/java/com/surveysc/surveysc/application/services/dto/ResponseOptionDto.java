package com.surveysc.surveysc.application.services.dto;


public class ResponseOptionDto {

    private Long id;
    private String option_value;
    private String commentResponse;
    private String optionText;
    private Long questionId;


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
    public Long getQuestionId() {
        return questionId;
    }
    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    

}
