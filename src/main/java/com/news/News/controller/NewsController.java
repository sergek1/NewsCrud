package com.news.News.controller;

import com.news.News.model.dto.NewsDto;
import com.news.News.model.dto.NewsPostDto;
import com.news.News.model.entities.News;
import com.news.News.model.mapper.NewsMapper;
import com.news.News.service.NewsService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    /**
     * Handles requests to retrieve news based on specified page size and current page number.
     *
     * @param pageSize    Number of news items per page (default is 10).
     * @param currentPage Current page number (default is 1).
     * @param session     HTTP session to retrieve stored news color.
     * @param model       Model to add attributes for Thymeleaf rendering.
     * @return Thymeleaf template name for rendering the news page.
     */
    @GetMapping()
    public String getNews(
            @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
            @RequestParam(name = "currentPage", defaultValue = "1") int currentPage,
            HttpSession session,
            Model model) {

        // Retrieve news color from the session, if available
        String newsColor = (String) session.getAttribute("newsColor");

        // Add news color to the model for Thymeleaf rendering
        model.addAttribute("newsColor", newsColor);

        // Get news for the current page, considering the specified number of news items per page
        List<NewsDto> newsDtoList = newsService.getNewsDtos(pageSize, currentPage);

        // Get the total number of pages
        int pagesCount = newsService.getPagesCount(pageSize);

        // Add attributes to the model for Thymeleaf rendering
        model.addAttribute("newsList", newsDtoList);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", pagesCount);
        return "news";
    }

    /**
     * Handles requests to display the form for adding news.
     *
     * @param model Model to add attributes for Thymeleaf rendering.
     * @return Thymeleaf template name for rendering the add news page.
     */
    @GetMapping("/add")
    public String addNews(Model model) {
        model.addAttribute("addNews", new NewsDto());
        return "add_news";
    }

    /**
     * Handles requests to add a new news post.
     *
     * @param addNews NewsPostDto containing information for the new news.
     * @return Redirects to the news page.
     */
    @PostMapping("/add")
    public String addPeer(@ModelAttribute(name = "addNews") NewsPostDto addNews) {
        News news = NewsMapper.newsPostDtoToNews(addNews);
        newsService.add(news);
        return "redirect:/news";
    }

    /**
     * Handles requests to delete a news by ID.
     *
     * @param id ID of the news to be deleted.
     * @return Redirects to the news page.
     */
    @PostMapping("/delete/{id}")
    public String deleteNews(@PathVariable Long id) {
        newsService.deleteById(id);
        return "redirect:/news";
    }

    /**
     * Handles requests to display the form for updating a news post.
     *
     * @param id    ID of the news to be updated.
     * @param model Model to add attributes for Thymeleaf rendering.
     * @return Thymeleaf template name for rendering the update news page.
     */
    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        // Retrieve information about the news post by ID and add it to the model
        NewsDto newsDto = newsService.findNewsDtoById(id);
        model.addAttribute("updateNews", newsDto);
        return "update_news";
    }

    /**
     * Handles requests to save the updated news post.
     *
     * @param updatedNews NewsPostDto containing updated information for the news.
     * @return Redirects to the news page.
     */
    @PostMapping("/update")
    public String updateNews(@ModelAttribute(name = "updateNews") NewsPostDto updatedNews) {
        News news = NewsMapper.newsPostDtoToNews(updatedNews);
        newsService.add(news);
        return "redirect:/news";
    }

    /**
     * Handles requests to save selected colors to the session.
     *
     * @param newsColor Selected news color.
     * @param session   HTTP session to store the selected news color.
     * @return Redirects to the news page.
     */
    @PostMapping("/saveColors")
    public String saveColors(@RequestParam("newsColor") String newsColor,
                             HttpSession session) {
        // Save the selected colors to the session
        session.setAttribute("newsColor", newsColor);
        return "redirect:/news";
    }
}
