/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Mamoun kubur
 */
public class Main extends Application {
    private static Stage stg;

    @Override
    public void start(Stage stage) throws Exception {
        stg=stage;
        Parent root = FXMLLoader.load(getClass().getResource("booksmain.fxml"));
        stage.setResizable(false);
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
    }
    public static Stage getStg(){
        return stg;
    };


    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        launch(args);
    }

}
