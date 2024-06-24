package org.example.demo.repository;

import org.example.demo.entity.Article;

import java.sql.*;
import java.util.ArrayList;

public class ArticleRepository {
    private final String MYSQL_CONNECTION_STRING = "jdbc:mysql://localhost:3306/articles2";
    private final String MYSQL_USERNAME = "root";
    private final String MYSQL_PASSWORD = "";


    public void save(Article article) {
        try {
            Connection connection = DriverManager.getConnection(MYSQL_CONNECTION_STRING, MYSQL_USERNAME, MYSQL_PASSWORD);
            String prepareSql = "insert into articles " + "(title, description, content) " + "values " + "(?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(prepareSql);
            preparedStatement.setString(1, article.getTitle());
            preparedStatement.setString(2, article.getDescription());
            preparedStatement.setString(3, article.getContent());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error. Please try again.");
            e.printStackTrace();
        }
    }
    public ArrayList<Article> findAll(){
        ArrayList<Article> students = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(MYSQL_CONNECTION_STRING, MYSQL_USERNAME, MYSQL_PASSWORD);
            String prSql = "select * from articles";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(prSql);
            while (resultSet.next()) {
                String title = resultSet.getString("title");
                String descrpition  = resultSet.getString("description");
                String content = resultSet.getString("content");
                Article article = new Article();
                article.setTitle(title);
                article.setDescription(descrpition);
                article.setContent(content);
                students.add(article);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
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
