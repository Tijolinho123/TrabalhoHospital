/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsuldeminas.hospital.modelo.entidade;

import java.util.Calendar;

/**
 *
 * @author 13711880681
 */
public class Convenios {
    private int codConvenio;
    private String nomeConvenio;
    private String cnpj;
    private String telefoneConvenio;
    private String cobertura;
    private Calendar dataInicioContrato;
    private Calendar dataFimContrato;

    public Convenios() {
    }

    public int getCodConvenio() {
        return codConvenio;
    }

    public void setCodConvenio(int codConvenio) {
        this.codConvenio = codConvenio;
    }

    public String getNomeConvenio() {
        return nomeConvenio;
    }

    public void setNomeConvenio(String nomeConvenio) {
        this.nomeConvenio = nomeConvenio;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefoneConvenio() {
        return telefoneConvenio;
    }

    public void setTelefoneConvenio(String telefoneConvenio) {
        this.telefoneConvenio = telefoneConvenio;
    }

    public String getCobertura() {
        return cobertura;
    }

    public void setCobertura(String cobertura) {
        this.cobertura = cobertura;
    }

    public Calendar getDataInicioContrato() {
        return dataInicioContrato;
    }

    public void setDataInicioContrato(Calendar dataInicioContrato) {
        this.dataInicioContrato = dataInicioContrato;
    }

    public Calendar getDataFimContrato() {
        return dataFimContrato;
    }

    public void setDataFimContrato(Calendar dataFimContrato) {
        this.dataFimContrato = dataFimContrato;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.codConvenio;
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
        final Convenios other = (Convenios) obj;
        return this.codConvenio == other.codConvenio;
    }
    
    
}
