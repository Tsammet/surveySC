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
@Table(name = "subresponse_options")
public class SubResponseOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "INT", nullable = false)
    private Long subresponseNumber;

    @Embedded
    private Audit audit = new Audit();

    @ManyToOne
    @JoinColumn(name = "responseoptions_id")
    private ResponseOption responseOptions;

    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String componentHtml;
    
    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String supresponseText;

    public SubResponseOption() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSubresponseNumber() {
        return subresponseNumber;
    }

    public void setSubresponseNumber(Long subresponseNumber) {
        this.subresponseNumber = subresponseNumber;
    }

    public Audit getAudit() {
        return audit;
    }

    public void setAudit(Audit audit) {
        this.audit = audit;
    }

    public ResponseOption getResponseOptions() {
        return responseOptions;
    }

    public void setResponseOptions(ResponseOption responseOptions) {
        this.responseOptions = responseOptions;
    }

    public String getComponentHtml() {
        return componentHtml;
    }

    public void setComponentHtml(String componentHtml) {
        this.componentHtml = componentHtml;
    }

    public String getSupresponseText() {
        return supresponseText;
    }

    public void setSupresponseText(String supresponseText) {
        this.supresponseText = supresponseText;
    }

    
}
