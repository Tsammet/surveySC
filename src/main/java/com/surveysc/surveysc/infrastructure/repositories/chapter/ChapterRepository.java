package com.surveysc.surveysc.infrastructure.repositories.chapter;

import org.springframework.data.jpa.repository.JpaRepository;

import com.surveysc.surveysc.domain.entities.Chapter;

public interface ChapterRepository extends JpaRepository<Chapter, Long >{

    void removeById(Long id);


}
