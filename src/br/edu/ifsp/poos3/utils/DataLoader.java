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

    /*public static void mixData() throws IOException {
        Map<String, String[]> info = new LinkedHashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader("C:/Users/lucas/Desktop/Alunos.csv"))) {
            String strCurrentLine;

            while ((strCurrentLine = br.readLine()) != null) {
                String[] data = strCurrentLine.split(";");
                data[1] = "SC" +Integer.parseInt(data[1].substring(2, 9).replace(",", ".").replace("X", "0")) + 317 ;

                int rand = ThreadLocalRandom.current().nextInt(0, 301);
                rand -= 150;
                double val = Double.parseDouble(data[5].replace(",", "."));
                val += rand /  100.0;

                createNames(data[2]);
                if(val < 0 )
                    val = 0;
                if(val > 10 )
                    val = 10;
                data[5]  = String.format("%.2f", val);

                data[6] = ThreadLocalRandom.current().nextInt(1, 3) + "";

                info.put(data[1], data);
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter("C:/Users/lucas/Desktop/FakeAlunos.csv", true));
            for (String[] strings : info.values()) {
                StringJoiner sj = new StringJoiner(";");
                strings[2] = randName(strings[2]);
                for (String datum : strings) {
                    sj.add(datum);
                }
                writer.append(sj.toString()+ "\n");
            }
            writer.close();

        } catch (IOException e) {
            throw (e);
        }

        try (BufferedReader br = new BufferedReader(new FileReader("C:/Users/lucas/Desktop/Relatorio.csv"))){
            String strCurrentLine;
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:/Users/lucas/Desktop/FakeRelatorio.csv", true));
            while ((strCurrentLine = br.readLine()) != null) {
                String[] data = strCurrentLine.split(";");
                data[1] = "SC" +Integer.parseInt(data[1].substring(2, 9).replace(",", ".").replace("X", "0")) + 317 ;
                if(!info.containsKey(data[1]))//disciplina pertence a um aluno não regular.
                    continue;
                data[2] = info.get(data[1])[2];
                StringJoiner sj = new StringJoiner(";");
                for (String datum : data)
                    sj.add(datum);
                writer.append(sj.toString()+ "\n");
            }
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static Map<Integer, String> names = new HashMap();
    static int  iNames = 0;

    public static void createNames(String fullName){
        String[] parts = fullName.split(" ");
        for (String s : parts) {
            if(s.length() > 3) {
                names.put(iNames++, s);
            }
        }
    }

    public static String randName(String s){
        String[] split = s.split(" ");
        StringJoiner sj = new StringJoiner(" ");
        for (String s1 : split) {
            sj.add(names.get(ThreadLocalRandom.current().nextInt(0, iNames)));
        }
        return sj.toString();
    }*/

}
