package com.surveysc.surveysc.infrastructure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.surveysc.surveysc.application.services.dto.ResponseOptionDto;
import com.surveysc.surveysc.application.services.responseoption.ResponseOptionService;

import com.surveysc.surveysc.domain.entities.Question;
import com.surveysc.surveysc.domain.entities.ResponseOption;
import com.surveysc.surveysc.infrastructure.repositories.chapter.exceptions.ResourceNotFoundException;
import com.surveysc.surveysc.infrastructure.repositories.question.QuestionRepository;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/responseoptionapi")

public class ResponseOptionController {

    @Autowired
    private ResponseOptionService responseOptionService;

    @Autowired
    private QuestionRepository questionRepository;

    @PostMapping
    public ResponseEntity<ResponseOption> creaEntity(@Valid @RequestBody ResponseOptionDto responseOptionDto) {
        Question question = questionRepository.findById(responseOptionDto.getQuestionId()).orElseThrow(() -> new ResourceNotFoundException("Question not found"));

        ResponseOption responseOption = new ResponseOption();
        responseOption.setOption_value(responseOptionDto.getOption_value());
        responseOption.setCommentResponse(responseOptionDto.getCommentResponse());
        responseOption.setOptionText(responseOptionDto.getOptionText());
        responseOption.setQuestions(question);

        ResponseOption newResponseOption = responseOptionService.save(responseOption);
        return ResponseEntity.status(HttpStatus.CREATED).body(newResponseOption);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping
    public ResponseEntity<String> deleteResponseOption(@RequestParam Long responseOption) {
        responseOptionService.remove(responseOption);
        return new ResponseEntity<>("Eliminado", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ResponseOption> updateChapter(@Valid @RequestBody ResponseOptionDto responseOptionDto) {
        // Buscar el capítulo existente
        ResponseOption existingResponseOption = responseOptionService.findById(responseOptionDto.getId()).orElseThrow(() -> new ResourceNotFoundException("Response option not found"));
    
        // Buscar la encuesta asociada
        Question question = questionRepository.findById(responseOptionDto.getQuestionId())
            .orElseThrow(() -> new ResourceNotFoundException("Survey not found"));
    
        // Actualizar el capítulo
        existingResponseOption.setOption_value(responseOptionDto.getOption_value());
        existingResponseOption.setCommentResponse(responseOptionDto.getCommentResponse());
        existingResponseOption.setOptionText(responseOptionDto.getOptionText());
        existingResponseOption.setQuestions(question);
       
    
        ResponseOption updateResponseOption = responseOptionService.save(existingResponseOption);
    
        return ResponseEntity.ok(updateResponseOption);
    }








}
