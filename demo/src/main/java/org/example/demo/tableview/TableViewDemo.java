package org.example.demo.tableview;

import javafx.application.Application;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TableViewDemo extends Application {

    @Override
    public void start(Stage stage) {
        TableView<UserAccount> table = new TableView<>();

        // Tạo cột UserName (Kiểu dữ liệu String)
        TableColumn<UserAccount, String> userNameCol = new TableColumn<>("User Name");
        userNameCol.setCellValueFactory(new PropertyValueFactory<>("userName"));

        // Tạo cột Email (Kiểu dữ liệu String)
        TableColumn<UserAccount, String> emailCol = new TableColumn<>("Email");
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));

        // Tạo cột FullName (Kiểu dữ liệu String)
        TableColumn<UserAccount, String> fullNameCol = new TableColumn<>("Full Name");

        // Tạo 2 cột con cho cột FullName
        TableColumn<UserAccount, String> firstNameCol = new TableColumn<>("First Name");
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        TableColumn<UserAccount, String> lastNameCol = new TableColumn<>("Last Name");
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        // Thêm 2 cột con vào cột FullName
        fullNameCol.getColumns().addAll(firstNameCol, lastNameCol);

        // Active Column
        TableColumn<UserAccount, Boolean> activeCol = new TableColumn<>("Active");
        activeCol.setCellValueFactory(cellData -> new SimpleBooleanProperty(cellData.getValue().isActive()));

        table.getColumns().addAll(userNameCol, emailCol, fullNameCol, activeCol);

        ObservableList<UserAccount> data = FXCollections.observableArrayList(
                new UserAccount(1L, "user1", "user1@example.com", "John", "Doe", true),
                new UserAccount(2L, "user2", "user2@example.com", "Jane", "Doe", false)
        );

        table.setItems(data);

        StackPane root = new StackPane();
        root.setPadding(new Insets(5));
        root.getChildren().add(table);

        stage.setTitle("TableView Demo");
        Scene scene = new Scene(root, 450, 300);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
