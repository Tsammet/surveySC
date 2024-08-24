package com.surveysc.surveysc.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "response_questions")
public class ResponseQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "response_id")
    private ResponseOption responseOptions;

    @ManyToOne
    @JoinColumn(name = "subresponses_id")
    private SubResponseOption subResponseOptions;

    @Column(columnDefinition = "VARCHAR(80)", nullable = false)
    private String responseText;

    public ResponseQuestion() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ResponseOption getResponseOptions() {
        return responseOptions;
    }

    public void setResponseOptions(ResponseOption responseOptions) {
        this.responseOptions = responseOptions;
    }

    public SubResponseOption getSubResponseOptions() {
        return subResponseOptions;
    }

    public void setSubResponseOptions(SubResponseOption subResponseOptions) {
        this.subResponseOptions = subResponseOptions;
    }

    public String getResponseText() {
        return responseText;
    }

    public void setResponseText(String responseText) {
        this.responseText = responseText;
    }

}
