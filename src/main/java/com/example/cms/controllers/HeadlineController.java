package com.example.cms.controllers;

import com.example.cms.services.HeadlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cms")
public class HeadlineController {
    @Autowired
    private HeadlineService service;

    @GetMapping
    public String showCMSPage(Model model) {
        model.addAttribute("headline", service.getLatestHeadline().getHeadline());
        return "cms";
    }

    @PostMapping("/update")
    public String updateHeadline(@RequestParam String headline) {
        service.updateHeadline(headline);
        return "redirect:/cms";
    }

    @RestController
    @RequestMapping("/api/headline")
    public static class HeadlineRestController {
        @Autowired
        private HeadlineService service;

        @GetMapping
        public String getHeadline() {
            return service.getLatestHeadline().getHeadline();
        }

        @PostMapping
        public void updateHeadline(@RequestBody String headline) {
            service.updateHeadline(headline);
        }
    }
}
