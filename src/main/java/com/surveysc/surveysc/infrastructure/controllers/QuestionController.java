package com.surveysc.surveysc.infrastructure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.surveysc.surveysc.application.services.chapter.ChapterService;
import com.surveysc.surveysc.application.services.dto.ChapterDto;
import com.surveysc.surveysc.application.services.dto.QuestionDto;
import com.surveysc.surveysc.application.services.question.QuestionService;
import com.surveysc.surveysc.domain.entities.Chapter;
import com.surveysc.surveysc.domain.entities.Question;
import com.surveysc.surveysc.domain.entities.Survey;
import com.surveysc.surveysc.infrastructure.repositories.chapter.ChapterRepository;
import com.surveysc.surveysc.infrastructure.repositories.chapter.exceptions.ResourceNotFoundException;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/questionapi")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private ChapterRepository chapterRepository;

    
    @PostMapping
    public ResponseEntity<Question> creaEntity(@Valid @RequestBody QuestionDto questionDto) {
        Chapter chapter = chapterRepository.findById(questionDto.getChapterId()).orElseThrow(() -> new ResourceNotFoundException("Chapter not found"));

        Question question = new Question();
        question.setQuestionNumber(questionDto.getQuestionNumber());
        question.setResponseType(questionDto.getResponseType());
        question.setCommentQuestion(questionDto.getCommentQuestion());
        question.setQuestionText(questionDto.getQuestionText());
        question.setChapters(chapter);


        Question newQuestion = questionService.save(question);
        return ResponseEntity.status(HttpStatus.CREATED).body(newQuestion);
    }

    @GetMapping("/allquestion")
    public ResponseEntity<Page<Question>> findAll(Pageable pageable){
        Page<Question> questionPage = questionService.findAll(pageable);

        if (questionPage.hasContent()) {
            return ResponseEntity.ok(questionPage);
        }

            return ResponseEntity.notFound().build();
    }

    
    @CrossOrigin(origins = "*")
    @DeleteMapping
    public ResponseEntity<String> deleteQuestion(@RequestParam Long questionId) {
        questionService.remove(questionId);
        return new ResponseEntity<>("Eliminado", HttpStatus.OK);
    }


    @PutMapping
    public ResponseEntity<Question> updateChapter(@Valid @RequestBody QuestionDto questionDto) {
        // Buscar el capítulo existente
        Question existingQuestion = questionService.findById(questionDto.getId())
            .orElseThrow(() -> new ResourceNotFoundException("Question not found"));
    
        // Buscar la encuesta asociada
        Chapter chapter = chapterRepository.findById(questionDto.getChapterId())
            .orElseThrow(() -> new ResourceNotFoundException("Survey not found"));
    
        // Actualizar el capítulo
        existingQuestion.setQuestionNumber(questionDto.getQuestionNumber());
        existingQuestion.setResponseType(questionDto.getResponseType());
        existingQuestion.setQuestionText(questionDto.getQuestionText());
        existingQuestion.setCommentQuestion(questionDto.getCommentQuestion());
        existingQuestion.setChapters(chapter);
    
        Question updateQuestion = questionService.save(existingQuestion);
    
        return ResponseEntity.ok(updateQuestion);
    }
}
