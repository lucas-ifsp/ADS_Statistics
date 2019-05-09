package br.edu.ifsp.poos3.view.loaders;

import br.edu.ifsp.poos3.controller.WindowStatisticsController;
import br.edu.ifsp.poos3.model.ClassStatistics;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class WindowStatistics {

    public void start(List<ClassStatistics> data){
        FXMLLoader loader =  new FXMLLoader();
        try {
            Pane graph = loader.load(getClass().getResource("/br/edu/ifsp/poos3/view/fxml/FXMLStatistics.fxml").openStream());
            Scene scene = new Scene(graph, 1100, 800);

            WindowStatisticsController ctrl = loader.getController();
            ctrl.fill(data);

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Classes Statistics");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
