package com.surveysc.surveysc.infrastructure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.surveysc.surveysc.application.services.survey.SurveyService;
import com.surveysc.surveysc.domain.entities.Survey;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/surveyapi")
public class SurveyController {

    @Autowired
    private SurveyService surveyService;
    
    @PostMapping
    @CrossOrigin(origins = "*")
    public ResponseEntity<Survey> creaEntity(@Valid @RequestBody Survey survey){
        Survey surveynew = surveyService.save(survey);
        return ResponseEntity.status(HttpStatus.CREATED).body(surveynew);
    }
    
    @GetMapping("/allsurvey")
    public ResponseEntity<Page<Survey>> findAll(Pageable pageable){
        Page<Survey> surveyPage = surveyService.findAll(pageable);

        if (surveyPage.hasContent()) {
            return ResponseEntity.ok(surveyPage);
        }

            return ResponseEntity.notFound().build();
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping
    public ResponseEntity<String> deleteSurvey(@RequestParam String surveyName) {
        surveyService.remove(surveyName);
        return new ResponseEntity<>("Eliminado", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Survey> updateSurvey(@Valid @RequestBody Survey survey) {
            Survey updatedSurvey = surveyService.update(survey);
            return ResponseEntity.ok(updatedSurvey);
       
    }
    
}
