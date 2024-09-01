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
import com.surveysc.surveysc.domain.entities.Chapter;
import com.surveysc.surveysc.domain.entities.Survey;
import com.surveysc.surveysc.infrastructure.repositories.chapter.exceptions.ResourceNotFoundException;
import com.surveysc.surveysc.infrastructure.repositories.survey.SurveyRepository;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/chapterapi")
public class ChapterController {

    @Autowired
    private ChapterService chapterService;

    @Autowired
    private SurveyRepository surveyRepository;

    @PostMapping
    public ResponseEntity<Chapter> creaEntity(@Valid @RequestBody ChapterDto chapterDTO) {
        Survey survey = surveyRepository.findById(chapterDTO.getSurveyId()).orElseThrow(() -> new ResourceNotFoundException("Survey not found"));

        Chapter chapter = new Chapter();
        chapter.setChapterNumber(chapterDTO.getChapterNumber());
        chapter.setChapterTitle(chapterDTO.getChapterTitle());
        chapter.setSurveys(survey);

        Chapter newChapter = chapterService.save(chapter);
        return ResponseEntity.status(HttpStatus.CREATED).body(newChapter);
    }

    @GetMapping("/allchapter")
    public ResponseEntity<Page<Chapter>> findAll(Pageable pageable){
        Page<Chapter> chapterPage = chapterService.findAll(pageable);

        if (chapterPage.hasContent()) {
            return ResponseEntity.ok(chapterPage);
        }

            return ResponseEntity.notFound().build();
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping
    public ResponseEntity<String> deleteSurvey(@RequestParam Long chapterId) {
        chapterService.remove(chapterId);
        return new ResponseEntity<>("Eliminado", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Chapter> updateChapter(@Valid @RequestBody ChapterDto chapterDto) {
        // Buscar el capítulo existente
        Chapter existingChapter = chapterService.findById(chapterDto.getId())
            .orElseThrow(() -> new ResourceNotFoundException("Chapter not found"));
    
        // Buscar la encuesta asociada
        Survey survey = surveyRepository.findById(chapterDto.getSurveyId())
            .orElseThrow(() -> new ResourceNotFoundException("Survey not found"));
    
        // Actualizar el capítulo
        existingChapter.setChapterNumber(chapterDto.getChapterNumber());
        existingChapter.setChapterTitle(chapterDto.getChapterTitle());
        existingChapter.setSurveys(survey); // Actualizar la encuesta asociada
    
        // Guardar el capítulo actualizado
        Chapter updatedChapter = chapterService.save(existingChapter);
    
        return ResponseEntity.ok(updatedChapter);
    }
}
