package br.edu.ifsp.poos3.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Student {
    private int semIngresso, anoIngresso;
    private String prontuario, nome;
    private double ira, frequencia;

    private List<StudentClass> classes = new ArrayList<>();

    public Student() {
    }

    public Student(int semIngresso, int anoIngresso, String prontuario, String nome, double ira, double frequencia) {
        this.semIngresso = semIngresso;
        this.anoIngresso = anoIngresso;
        this.prontuario = prontuario;
        this.nome = nome;
        this.ira = ira;
        this.frequencia = frequencia;
    }

    public void addStudentClass(StudentClass s){
        s.setAtraso((getCurrentSemester() - s.getModulo()) > 0 ? getCurrentSemester() - s.getModulo() : 0 );
        s.setPpc(anoIngresso >= 2018 ? 2018 : 2008);
        classes.add(s);
    }

    public Iterator<StudentClass> iteratorStudentClasses(){
        return classes.iterator();
    }

    private int getCurrentSemester(){
        int sem = LocalDateTime.now().getMonthValue() >= 7 ? 2 : 1;
        return  (LocalDateTime.now().getYear() - anoIngresso) * 2 + (sem - semIngresso) + 1;
    }

    public int getSemIngresso() {
        return semIngresso;
    }

    public void setSemIngresso(int semIngresso) {
        this.semIngresso = semIngresso;
    }

    public int getAnoIngresso() {
        return anoIngresso;
    }

    public void setAnoIngresso(int anoIngresso) {
        this.anoIngresso = anoIngresso;
    }

    public String getProntuario() {
        return prontuario;
    }

    public void setProntuario(String prontuario) {
        this.prontuario = prontuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getIra() {
        return ira;
    }

    public void setIra(double ira) {
        this.ira = ira;
    }

    public double getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(double frequencia) {
        this.frequencia = frequencia;
    }

    public String toString(){
        return  "1;"+prontuario+";"+ nome +";" + anoIngresso + ";" + frequencia +";"+ ira + ";" +semIngresso+"\n";
    }
}
