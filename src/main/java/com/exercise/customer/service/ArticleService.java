package com.exercise.customer.service;

import java.util.List;
import com.exercise.customer.entity.Article;

public interface ArticleService {
    List<Article> findAllArticle();
    Article findById(Long id);
    Article insert(Article article);
    boolean delete(Long id);
    void update(Article p);
}
