package lk.ijse.gymsystem.main;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class Main extends Application {
    public static  void main(String args[]){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/gymsystem/view/Login.fxml"));
        Scene mainScene =new Scene (root);
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("LogIn");
        primaryStage.centerOnScreen();
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();

        FadeTransition tempTransition = new FadeTransition(Duration.millis(2500),root);
        tempTransition.setFromValue(0.0);
        tempTransition.setToValue(1.0);
        tempTransition.play();
    }



}
