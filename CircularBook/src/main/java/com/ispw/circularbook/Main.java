package com.ispw.circularbook;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.ispw.circularbook.engineering.connection.ConnectionDB;
import java.io.IOException;
import java.sql.SQLException;

public class Main extends Application {
    private static Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        setStage(stage);
        stage.setResizable(false);
        stage.setTitle("Circular Book");
        stage.setScene(scene);
        stage.show();


    }
    @Override
    public void stop() throws SQLException {
        ConnectionDB.closeConnection();
    }

    public static void main(String[] args) throws Exception {
        ConnectionDB.getConnection();
        launch();
    }

    public static void setStage(Stage stage){
        Main.stage=stage;}

    public static Stage getStage(){ return stage;}
}



