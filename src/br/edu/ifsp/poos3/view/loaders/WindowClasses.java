package br.edu.ifsp.poos3.view.loaders;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class WindowClasses extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader =  new FXMLLoader();
        Pane graph = loader.load(getClass().getResource("/br/edu/ifsp/poos3/view/fxml/FXMLClasses.fxml"));

        Scene scene = new Scene(graph, 1400, 900);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Classes vs Students");
        primaryStage.show();
    }
}
