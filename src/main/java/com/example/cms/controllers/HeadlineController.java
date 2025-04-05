package com.example.cms.controllers;

import java.util.Collections;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cms.services.HeadlineService;

@Controller
@RequestMapping("/api/headline")
@RestController
public class HeadlineController {

    private HeadlineService service;

    public HeadlineController(HeadlineService service) {
        this.service = service;
    }

    @GetMapping
    public Map<String,String> getHeadline() {
        String currentHeadline = service.getLatestHeadline();
        return Collections.singletonMap("headline", currentHeadline);
    }

    @PostMapping
    public ResponseEntity<?> updateHeadline(@RequestBody Map<String, String> body) {
        String newHeadline = body.get("headline");
        if(newHeadline == null || newHeadline.isEmpty()) {
            return ResponseEntity.badRequest().body("Headline Cannot be empty");
        }
        else {
            service.updateHeadline(newHeadline);
            return ResponseEntity.ok("Headline updated successfully");
        }
    }
}
