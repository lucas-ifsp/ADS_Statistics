package br.edu.ifsp.poos3.DAO;

import br.edu.ifsp.poos3.model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StudentDAO implements DAO<Student, String> {

    @Override
    public void export(List<Student> list, String destinationPath) {
        try(PrintWriter out = new PrintWriter(new FileOutputStream(new File(destinationPath)))){
            for (Student student : list)
                out.append(student.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Map<String, Student> importAsMap(String sourcePath) {
        Map<String, Student> students = null;
        try (BufferedReader br = new BufferedReader(new FileReader(sourcePath))) {
            students = new LinkedHashMap<>();
            String strCurrentLine;
            while ((strCurrentLine = br.readLine()) != null) {
                String[] data = strCurrentLine.split(";");
                students.put(data[1].substring(2, 9), new Student(Integer.parseInt(data[6]), Integer.parseInt(data[3]), data[1].substring(2, 9), data[2].toUpperCase(), Double.parseDouble(data[5].replace(",", ".")), Double.parseDouble(data[4].replace(",", "."))));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public List<Student> importAsList(String sourcePath) {
        Map<String, Student> students = importAsMap(sourcePath);
        return students != null ? new ArrayList<>(students.values()) : null;
    }
}
