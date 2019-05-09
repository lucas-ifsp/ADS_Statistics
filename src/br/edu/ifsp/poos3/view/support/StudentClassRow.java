package br.edu.ifsp.poos3.view.support;

import br.edu.ifsp.poos3.model.Student;
import br.edu.ifsp.poos3.model.StudentClass;

public class StudentClassRow {

    private Student student;
    private StudentClass studentClass;

    public StudentClassRow(Student s, StudentClass sc){
        student = s;
        studentClass = sc;
    }

    public int getAno() {
        return student.getAnoIngresso();
    }

    public int getPeriodo() {
        return student.getSemIngresso();
    }

    public int getPpc() {
        return studentClass.getPpc();
    }

    public String getProntuario() {
        return student.getProntuario();
    }

    public String getNome() {
        return student.getNome();
    }

    public String getNomeDisciplina() {
        return studentClass.getNome();
    }

    public String getCodigo() {
        return studentClass.getCodigo();
    }

    public double getIra() {
        return student.getIra();
    }

    public double getFrequencia() {
        return student.getFrequencia();
    }

    public Student getStudent() {
        return student;
    }

    public StudentClass getStudentClass() {
        return studentClass;
    }
}


