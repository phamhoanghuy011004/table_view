package org.example.demo.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import org.example.demo.entity.Article;
import org.example.demo.repository.ArticleRepository;

import java.awt.*;

public class ArticleForm {

    public TextField txtTitle;
    public TextField txtDescription;
    public TextField txtContent;
    private ArticleRepository articleRepository = new ArticleRepository();

    public void processSave (ActionEvent actionEvent) {
// validate
        Article article = new Article();
        article.setTitle(txtTitle.getText());
        article.setDescription (txtDescription.getText());
        article.setContent(txtContent.getText());
        articleRepository.save(article);
        Alert alert = new Alert (Alert.AlertType.INFORMATION);
        alert.setTitle("Action success");
        alert.setHeaderText("Article saved!");
        alert.show();
        reset();
    }
    public void processReset (ActionEvent actionEvent) {
        reset();
    }
    private void reset() {
        txtTitle.clear();
        txtDescription.clear();
        txtContent.clear();
    }
}
