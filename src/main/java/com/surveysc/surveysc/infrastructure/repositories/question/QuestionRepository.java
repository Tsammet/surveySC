package com.surveysc.surveysc.infrastructure.repositories.question;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.surveysc.surveysc.domain.entities.Chapter;
import com.surveysc.surveysc.domain.entities.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    void removeById(Long id);

    List<Question> findByChapters(Chapter chapter);

}
