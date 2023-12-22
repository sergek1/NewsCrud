package com.news.News.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    /**
     * Handles requests to the root URL ("/") and redirects to the news page.
     *
     * @return Redirects to the news page.
     */
    @GetMapping("/")
    public String mainPage() {
        return "redirect:/news";
    }
}
