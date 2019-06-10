package br.edu.ifsp.poos3.utils;

import br.edu.ifsp.poos3.model.Student;
import br.edu.ifsp.poos3.model.StudentClass;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DataLoader {

    public static Map<String, Student> loadStudents(File file) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            Map<String, Student> students = new LinkedHashMap<>();
            String strCurrentLine;
            while ((strCurrentLine = br.readLine()) != null) {
                String[] data = strCurrentLine.split(";");
                students.put(data[1].substring(2, 9), new Student(Integer.parseInt(data[6]), Integer.parseInt(data[3]), data[1].substring(2, 9), data[2].toUpperCase(), Double.parseDouble(data[5].replace(",", ".")), Double.parseDouble(data[4].replace(",", "."))));
            }
            return students;
        } catch (IOException e) {
            throw (e);
        }
    }

    public static List<StudentClass> loadStudentClasses(File file) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            List<StudentClass> studentClasses = new ArrayList<>();
            String strCurrentLine;
            while ((strCurrentLine = br.readLine()) != null) {
                String[] data = strCurrentLine.split(";");

                String matricula = data[1].substring(2, 9);
                String codigo = data[3].substring(11, 16);
                int modulo = Integer.parseInt(data[4]);
                String nome = data[5].toUpperCase();

                studentClasses.add(new StudentClass(nome, codigo, matricula, modulo));
            }
            return studentClasses;
        } catch (IOException e) {
            throw (e);
        }
    }
}
