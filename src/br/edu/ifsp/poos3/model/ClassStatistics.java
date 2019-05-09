package br.edu.ifsp.poos3.model;

public class ClassStatistics {
    private int numAtrasados, numRegulares, totalAtrasos, ppc, semestre;
    private double demandaSemestral;
    private String codigo;

    public ClassStatistics(String codigo){
        this.codigo = codigo;
        this.ppc = codigo.charAt(3) == 'T' ? 2008 : 2018;
        this.semestre = Integer.parseInt(codigo.charAt(4)+"");
    }

    public String getFormattedAtrasoMedio(){
        return String.format("%.2f", getAtrasoMedio());
    }

    public String getFormattedPorcentagemAtrasados(){
        return String.format("%.2f", 100 * getPorcentagemAtrasados())+ "%";
    }

    public String getFormattedDemandaSemestral(){
        return String.format("%.2f", getDemandaSemestral());
    }

    public double getPorcentagemAtrasados(){
        return numAtrasados/(double) getTotalAlunos();
    }

    public int getTotalAlunos() {
        return numAtrasados + numRegulares;
    }

    public double getAtrasoMedio(){
        return getNumAtrasados() > 0? getTotalAtrasos() / (double) getNumAtrasados() : 0;
    }

    public int getNumAtrasados() {
        return numAtrasados;
    }

    public void setNumAtrasados(int numAtrasados) {
        this.numAtrasados = numAtrasados;
    }

    public int getNumRegulares() {
        return numRegulares;
    }

    public void setNumRegulares(int numRegulares) {
        this.numRegulares = numRegulares;
    }

    public int getTotalAtrasos() {
        return totalAtrasos;
    }

    public void setTotalAtrasos(int totalAtrasos) {
        this.totalAtrasos = totalAtrasos;
    }

    public int getPpc() {
        return ppc;
    }

    public void setPpc(int ppc) {
        this.ppc = ppc;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public double getDemandaSemestral() {
        return demandaSemestral;
    }

    public void setDemandaSemestral(double demandaSemestral) {
        this.demandaSemestral = demandaSemestral;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
