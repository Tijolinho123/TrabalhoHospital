/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsuldeminas.hospital.modelo.entidade;

/**
 *
 * @author 13711880681
 */
public class cargos {
    private int codCargos;
    private String nomeCargos;
    private float salarioInicial;
    private String atribuicoes;

     public cargos() {
    }
    
    public int getCodCargos() {
        return codCargos;
    }

    public void setCodCargos(int codCargos) {
        this.codCargos = codCargos;
    }

    public String getNomeCargos() {
        return nomeCargos;
    }

    public void setNomeCargos(String nomeCargos) {
        this.nomeCargos = nomeCargos;
    }

    public float getSalarioInicial() {
        return salarioInicial;
    }

    public void setSalarioInicial(float salarioInicial) {
        this.salarioInicial = salarioInicial;
    }

    public String getAtribuicoes() {
        return atribuicoes;
    }

    public void setAtribuicoes(String atribuicoes) {
        this.atribuicoes = atribuicoes;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + this.codCargos;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final cargos other = (cargos) obj;
        return this.codCargos == other.codCargos;
    }

}
