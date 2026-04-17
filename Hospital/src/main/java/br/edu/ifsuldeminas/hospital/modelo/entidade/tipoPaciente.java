/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsuldeminas.hospital.modelo.entidade;

import java.util.Objects;

/**
 *
 * @author 15843968650
 */
public class TipoPaciente {
	private int codPaciente;
	private String nomeTipoPaciente;

	public TipoPaciente() {
	}

	public int getCodPaciente() {
		return codPaciente;
	}

	public void setCodPaciente(int codPaciente) {
		this.codPaciente = codPaciente;
	}

	public String getNomeTipoPaciente() {
		return nomeTipoPaciente;
	}

	public void setNomeTipoPaciente(String nomeTipoPaciente) {
		this.nomeTipoPaciente = nomeTipoPaciente;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 37 * hash + this.codPaciente;
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
		final TipoPaciente other = (TipoPaciente) obj;
		return this.codPaciente == other.codPaciente;
	}

}
