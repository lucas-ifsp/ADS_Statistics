package br.edu.ifsp.poos3.controller;

import br.edu.ifsp.poos3.model.ClassStatistics;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class WindowStatisticsController {
    @FXML
    private TableView<ClassStatistics> table;
    @FXML private TableColumn<ClassStatistics, String> cCodigo;
    @FXML private TableColumn<ClassStatistics, Integer> cRegulares;
    @FXML private TableColumn<ClassStatistics, Integer> cAtrasados;
    @FXML private TableColumn<ClassStatistics, Integer> cTotal;
    @FXML private TableColumn<ClassStatistics, String> cPorcentagem;
    @FXML private TableColumn<ClassStatistics, String> cAtrasoMedio;
    @FXML private TableColumn<ClassStatistics, String> cDemanda;

    public void fill(List<ClassStatistics> data){
        cCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        cRegulares.setCellValueFactory(new PropertyValueFactory<>("numRegulares"));
        cAtrasados.setCellValueFactory(new PropertyValueFactory<>("numAtrasados"));
        cTotal.setCellValueFactory(new PropertyValueFactory<>("totalAlunos"));
        cPorcentagem.setCellValueFactory(new PropertyValueFactory<>("formattedPorcentagemAtrasados"));
        cAtrasoMedio.setCellValueFactory(new PropertyValueFactory<>("formattedAtrasoMedio"));
        cDemanda.setCellValueFactory(new PropertyValueFactory<>("formattedDemandaSemestral"));
        table.setItems(FXCollections.observableArrayList(data));
    }
}
