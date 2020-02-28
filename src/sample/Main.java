package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Random;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("");
        primaryStage.setScene(new Scene(root, 650, 500));
        primaryStage.show();
    }
    public static void main(String[] args) {
        /*Field field = new Field();
        Random rnd = new Random();
        field.print();
        field.shuffle();
        int count = 0;
        while (!field.isWinner()) {
            field.toggleTile1(rnd.nextInt(15));
            count++;
        }
        field.print();
        System.out.println(count);*/
        launch(args);
    }
}
