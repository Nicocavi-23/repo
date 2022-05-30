package com.exercise.customer.service;

import com.exercise.customer.entity.Article;
import com.exercise.customer.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private ArticleRepository repository;

    @Override
    public List<Article> findAllArticle() {
        return (List<Article>)repository.findAll();
    }

    @Override
    public Article insert(Article article) {
        return repository.save(article);
    }

    @Override
    public boolean delete(Long id) {
        try {
            repository.deleteById(id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Article findById(Long id) {
        Optional<Article> result = repository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            return null;
        }
    }

    @Override
    public void update(Article p) {
        try {
            repository.save(p);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
