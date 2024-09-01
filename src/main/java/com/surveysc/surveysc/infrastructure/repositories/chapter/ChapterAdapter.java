package com.surveysc.surveysc.infrastructure.repositories.chapter;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.surveysc.surveysc.application.services.chapter.ChapterService;
import com.surveysc.surveysc.domain.entities.Chapter;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class ChapterAdapter implements ChapterService {

    @Autowired
    private ChapterRepository chapterRepository;

    @Override
    public Chapter save(Chapter chapter){
        return chapterRepository.save(chapter);
    }

    @Override
    public Page<Chapter> findAll(Pageable pageable) {
        return chapterRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public void remove(Long id) {
        
        chapterRepository.removeById(id);

    }

    @Override
    @Transactional
    public Chapter update(Chapter chapter) {
        if (chapterRepository.existsById(chapter.getId())) {
            return chapterRepository.save(chapter);
        } else {
            throw new EntityNotFoundException("Chapter not found with id: " + chapter.getId());
        }
    }

    @Override
    public Optional<Chapter> findById(Long id) {
        return chapterRepository.findById(id);
    }
}
