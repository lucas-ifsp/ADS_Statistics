package br.edu.ifsp.poos3.controller;

import br.edu.ifsp.poos3.model.ClassStatistics;
import br.edu.ifsp.poos3.model.Student;
import br.edu.ifsp.poos3.model.StudentClass;
import br.edu.ifsp.poos3.utils.DataLoader;
import br.edu.ifsp.poos3.utils.StatisticsHelper;
import br.edu.ifsp.poos3.view.loaders.WindowStatistics;
import br.edu.ifsp.poos3.view.support.StudentClassRow;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class WindowClassesController {

    @FXML private TableView<StudentClassRow> table;
    @FXML private TableColumn<StudentClassRow, Integer> cAno;
    @FXML private TableColumn<StudentClassRow, Integer> cPeriodo;
    @FXML private TableColumn<StudentClassRow, String> cProntuario;
    @FXML private TableColumn<StudentClassRow, Integer> cNome;
    @FXML private TableColumn<StudentClassRow, Double> cIRA;
    @FXML private TableColumn<StudentClassRow, Double> cFrequencia;
    @FXML private TableColumn<StudentClassRow, String> cDisciplina;
    @FXML private TableColumn<StudentClassRow, String> cCodigo;
    @FXML private TableColumn<StudentClassRow, Integer> cPPC;

    @FXML private TextField txtFiltro;
    @FXML private TextField txtCodigo;
    @FXML private CheckBox ck2008;
    @FXML private CheckBox ck2018;
    @FXML private Label lbEntradas;

    private Map<String, Student> students;
    private List<StudentClassRow> tableData;
    private List<StudentClassRow> filteredTableData;

    private boolean loaded = false;

    public void load(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
        File fileStudents = fileChooser.showOpenDialog(table.getScene().getWindow());

        if(fileStudents == null)
            return;

        try {
            students = DataLoader.loadStudents(fileStudents);
            File fileStudentClasses = fileChooser.showOpenDialog(table.getScene().getWindow());

            if(fileStudentClasses == null)
                return;

            List<StudentClass> studentClasses = DataLoader.loadStudentClasses(fileStudentClasses);

            loaded = true;

            for (StudentClass studentClass : studentClasses) {
                if(students.containsKey(studentClass.getProntuario())){
                    Student student = students.get(studentClass.getProntuario());
                    student.addStudentClass(studentClass);
                }
            }

            bindTable();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void bindTable() {
        cAno.setCellValueFactory(new PropertyValueFactory<>("ano"));
        cPeriodo.setCellValueFactory(new PropertyValueFactory<>("periodo"));
        cProntuario.setCellValueFactory(new PropertyValueFactory<>("prontuario"));
        cNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        cIRA.setCellValueFactory(new PropertyValueFactory<>("ira"));
        cFrequencia.setCellValueFactory(new PropertyValueFactory<>("frequencia"));
        cDisciplina.setCellValueFactory(new PropertyValueFactory<>("nomeDisciplina"));
        cCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        cPPC.setCellValueFactory(new PropertyValueFactory<>("ppc"));
        table.setItems(FXCollections.observableArrayList(fill()));
        lbEntradas.setText("Número de entradas: " + table.getItems().size());
    }

    private List<StudentClassRow> fill() {
        tableData = new ArrayList<>();

        for(Student s : students.values()){
            Iterator<StudentClass> it = s.iteratorStudentClasses();
            while (it.hasNext())
                tableData.add(new StudentClassRow(s, it.next()));
        }

        filteredTableData = tableData;
        return tableData;
    }

    public void filter(KeyEvent keyEvent) {
        if(loaded){
            if(txtFiltro.getText().equals("") )
                filteredTableData = tableData;
            else{
                filteredTableData = new ArrayList<>();
                for (StudentClassRow cr : tableData ){
                    if(cr.getNome().contains(txtFiltro.getText().toUpperCase()) ||
                            cr.getProntuario().contains(txtFiltro.getText().toUpperCase()) ||
                            cr.getNomeDisciplina().contains(txtFiltro.getText().toUpperCase())){
                        filteredTableData.add(cr);
                    }
                }
            }
            refill(filteredTableData);
        }
    }

    private void refill(List<StudentClassRow> data) {
        table.getItems().clear();
        for (StudentClassRow r : data) {
            if((r.getPpc() == 2018 && ck2018.isSelected()||
                    r.getPpc() == 2008 && ck2008.isSelected()) &&
                    (r.getCodigo().equals("")||r.getCodigo().contains(txtCodigo.getText().toUpperCase()))){
                table.getItems().add(r);
            }
        }
        lbEntradas.setText("Número de entradas: " + table.getItems().size());
    }

    public void filterByPPC(ActionEvent actionEvent) {
        if(loaded){
            refill(filteredTableData);
        }
    }

    public void showStatisticsWindow(ActionEvent actionEvent) {
        if(loaded){
            Map<String, ClassStatistics> map = StatisticsHelper.init();

            for (StudentClassRow d : tableData) {
                ClassStatistics st = map.get(d.getCodigo());

                if(d.getStudentClass().getAtraso() > 0)
                    st.setNumAtrasados(st.getNumAtrasados() + 1);
                else
                    st.setNumRegulares(st.getNumRegulares() + 1);

                st.setTotalAtrasos(st.getTotalAtrasos() + d.getStudentClass().getAtraso());
            }

            for (ClassStatistics value : map.values()) {
                if(value.getPpc() == 2008){
                    int currentSemester = LocalDateTime.now().getMonthValue() >= 7? 2 : 1;
                    int offers = ((value.getSemestre() - 1) - ((LocalDateTime.now().getYear() - 2018) * 2 + (currentSemester - 1)));

                    value.setDemandaSemestral(offers > 0 ? value.getTotalAlunos() / (double) offers : 0);
                }else{
                    value.setDemandaSemestral(0);
                }
            }
            WindowStatistics view = new WindowStatistics();
            view.start(new ArrayList<>(map.values()));
        }
    }
}
