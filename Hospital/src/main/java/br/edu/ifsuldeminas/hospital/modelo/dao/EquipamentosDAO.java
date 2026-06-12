/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsuldeminas.hospital.modelo.dao;

import br.edu.ifsuldeminas.hospital.modelo.entidade.Equipamentos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Tulio Dias
 */
public class EquipamentosDAO extends GenericoDAO<Equipamentos> {

  public void salvar(Equipamentos objEquipamentos) {
    String sql = "INSERT INTO tbl_Equipamentos(nomeEquipamento) VALUES(?)";
    save(sql, objEquipamentos.getNomeEquipamentos());
  }

  public void alterar(Equipamentos objEquipamentos) {
    String sql = "UPDATE tbl_Equipamentos SET nomeEquipamento=? WHERE codEquipamento=?";
    save(sql, objEquipamentos.getNomeEquipamentos(), objEquipamentos.getCodEquipamentos());
  }

  public void excluir(Equipamentos objEquipamentos) {
    String sql = "DELETE FROM tbl_Equipamentos WHERE codEquipamento=?";
    save(sql, objEquipamentos.getCodEquipamentos());
  }

  public Equipamentos buscarPorEquipamentosPorId(int id) {
    String sql = "SELECT * FROM tbl_Equipamentos WHERE codEquipamento=?";
    return buscarPorId(sql, new EquipamentosRowMapper(), id);
  }

  public List<Equipamentos> buscarTodosEquipamentos() {
    String sql = "SELECT * FROM tbl_Equipamentos";
    return buscarTodos(sql, new EquipamentosRowMapper());
  }

  private static class EquipamentosRowMapper implements RowMapper<Equipamentos> {

    @Override
    public Equipamentos mapRow(ResultSet rs) throws SQLException {
      Equipamentos objEquipamentos = new Equipamentos();
      objEquipamentos.setCodEquipamentos(rs.getInt("codEquipamento"));
      objEquipamentos.setNomeEquipamentos(rs.getString("nomeEquipamento"));
      System.out.println("Mapeando o objeto: " + objEquipamentos.toString());
      return objEquipamentos;
    }

  }

}
