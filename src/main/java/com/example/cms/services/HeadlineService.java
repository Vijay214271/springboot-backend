package com.example.cms.services;

import com.example.cms.models.Headline;
import com.example.cms.repositories.HeadlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeadlineService {
    @Autowired
    private HeadlineRepository repository;

    public Headline getLatestHeadline() {
        return repository.findTopByOrderByIdDesc().orElse(new Headline(1L, "Default Headline"));
    }

    public void updateHeadline(String newHeadline) {
        repository.save(new Headline(null, newHeadline));
    }
}
