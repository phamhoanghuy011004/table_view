package org.example.demo;

import org.example.demo.entity.Article;
import org.example.demo.repository.ArticleRepository;

public class Application {
    public static void main(String[] args) {
        ArticleRepository articleRepository = new ArticleRepository();
        Article article = new Article();
        article.setTitle("Title");
        article.setDescription("Description");
        article.setContent("Content");
        articleRepository.save(article);
        System.out.println("Save success!");
    }
}
