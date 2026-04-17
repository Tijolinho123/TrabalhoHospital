/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsuldeminas.hospital.modelo.entidade;

/**
 *
 * @author 15843968650
 */
public class Equipamentos {
	private int codEquipamentos;
	private String nomeEquipamentos;

	public Equipamentos() {
	}

	public int getCodEquipamentos() {
		return codEquipamentos;
	}

	public void setCodEquipamentos(int codEquipamentos) {
		this.codEquipamentos = codEquipamentos;
	}

	public String getNomeEquipamentos() {
		return nomeEquipamentos;
	}

	public void setNomeEquipamentos(String nomeEquipamentos) {
		this.nomeEquipamentos = nomeEquipamentos;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + this.codEquipamentos;
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
		final Equipamentos other = (Equipamentos) obj;
		return this.codEquipamentos == other.codEquipamentos;
	}
	
}
