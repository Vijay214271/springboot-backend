package com.example.cms.services;

import com.example.cms.models.Headline;
import com.example.cms.repositories.HeadlineRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeadlineService {
    @Autowired
    private HeadlineRepository repository;

    public HeadlineService(HeadlineRepository repository) {
        this.repository = repository;
    }


    public String getLatestHeadline() {
        return repository.findTopByOrderByIdDesc().map(Headline::getHeadline).orElse("Hyper boost your Revenue Management, Marketing and Commercial Functions with Business Ready AI");
    }

    public void updateHeadline(String newHeadline) {
        Headline headline = new Headline();
        headline.setHeadline(newHeadline);
        repository.save(headline);
    }
}
