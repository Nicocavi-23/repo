package com.exercise.customer.controller;

import java.util.List;
import com.exercise.customer.entity.Article;
import com.exercise.customer.service.ArticleService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/article")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("")
    public List<Article> getAllPeople() {
        return articleService.findAllArticle();
    }

    @GetMapping("{id}")
    public Article getArticle(@PathVariable Long id) {
        return articleService.findById(id);
    }

    @PostMapping("")
    public String insert(@Valid @RequestBody Article article) {

        if(article != null) {
            articleService.insert(article);
            return "Added an article";
        } else {
            return "Request does not contain a body";
        }

    }

    @DeleteMapping("{id}")
    public String deleteArticle(@PathVariable("id") Long id) {

        if(id > 0) {
            if(articleService.delete(id)) {
                return "Deleted the article.";
            } else {
                return "Cannot delete the article.";
            }
        }
        return "The id is invalid for the article.";
    }

    @PutMapping("")
    public String updateArticle(@RequestBody Article article) {
        if(article != null) {
            articleService.update(article);
            return "Updated article.";
        } else {
            return "Request does not contain a body";
        }
    }
}
