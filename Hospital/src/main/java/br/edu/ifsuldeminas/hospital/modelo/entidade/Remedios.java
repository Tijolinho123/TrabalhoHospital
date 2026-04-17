/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsuldeminas.hospital.modelo.entidade;

/**
 *
 * @author 13702083677
 */
public class Remedios {
    private int codRemedio;
    private String nomeRemedio;
    private String laboratorio;
    private String efeitosColaterais;
    
    public Remedios() {
    }

    public int getCodRemedio() {
        return codRemedio;
    }

    public void setCodRemedio(int codRemedio) {
        this.codRemedio = codRemedio;
    }

    public String getNomeRemedio() {
        return nomeRemedio;
    }

    public void setNomeRemedio(String nomeRemedio) {
        this.nomeRemedio = nomeRemedio;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getEfeitosColaterais() {
        return efeitosColaterais;
    }

    public void setEfeitosColaterais(String efeitosColaterais) {
        this.efeitosColaterais = efeitosColaterais;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.codRemedio;
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
        final Remedios other = (Remedios) obj;
        return this.codRemedio == other.codRemedio;
    }
    

}
