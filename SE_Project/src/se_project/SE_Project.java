/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_project;

import com.sun.javafx.runtime.VersionInfo;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Salvatore Sarnelli
 */
public class SE_Project extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("calculator.fxml"));
        
        
        Scene scene = new Scene(root); 
        
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setFullScreen(false);
        stage.getIcons().add(new Image("file:MathSolverIcon.jpg"));
        stage.setTitle("Math Solver");
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
    }
    
}
