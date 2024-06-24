package org.example.demo.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import org.example.demo.entity.Article;
import org.example.demo.entity.Student;
import org.example.demo.repository.ArticleRepository;
import org.example.demo.repository.StudentRepository;

import java.net.URL;
import java.util.ResourceBundle;

public class DemoTableView implements Initializable {

    public TableView tableView;

    private ArticleRepository articleRepository = new ArticleRepository();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<Article> data = FXCollections.observableArrayList(articleRepository.findAll());
        tableView.setItems(data);
    }
}