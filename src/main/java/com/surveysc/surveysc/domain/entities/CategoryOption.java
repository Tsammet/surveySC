package com.surveysc.surveysc.domain.entities;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "category_options")
public class CategoryOption {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne 
    @JoinColumn(name = "categoriescatalog_id")
    private CategoryCatalog categoriesCatalog;

    @ManyToOne
    @JoinColumn(name = "option_id")
    private Option options;

    @Embedded
    private Audit audit = new Audit();

    public CategoryOption() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CategoryCatalog getCategoriesCatalog() {
        return categoriesCatalog;
    }

    public void setCategoriesCatalog(CategoryCatalog categoriesCatalog) {
        this.categoriesCatalog = categoriesCatalog;
    }

    public Option getOptions() {
        return options;
    }

    public void setOptions(Option options) {
        this.options = options;
    }

    public Audit getAudit() {
        return audit;
    }

    public void setAudit(Audit audit) {
        this.audit = audit;
    }

    





}
