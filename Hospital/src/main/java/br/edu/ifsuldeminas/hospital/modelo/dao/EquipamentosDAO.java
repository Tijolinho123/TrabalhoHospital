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
    String sql = "INSERT INTO EQUIPAMENTOS(NOME) VALUES(?)";
    save(sql, objEquipamentos.getNomeEquipamentos());
  }

  public void alterar(Equipamentos objEquipamentos) {
    String sql = "UPDATE EQUIPAMENTOS SET NOME=? WHERE CODIGO=?";
    save(sql, objEquipamentos.getNomeEquipamentos(), objEquipamentos.getCodEquipamentos());
  }

  public void excluir(Equipamentos objEquipamentos) {
    String sql = "DELETE FROM EQUIPAMENTOS WHERE CODIGO=?";
    save(sql, objEquipamentos.getCodEquipamentos());
  }

  public Equipamentos buscarPorEquipamentosPorId(int id) {
    String sql = "SELECT * FROM EQUIPAMENTOS WHERE CODIGO=?";
    return buscarPorId(sql, new EquipamentosRowMapper(), id);
  }

  public List<Equipamentos> buscarTodosEquipamentos() {
    String sql = "SELECT * FROM EQUIPAMENTOS";
    return buscarTodos(sql, new EquipamentosRowMapper());
  }

  private static class EquipamentosRowMapper implements RowMapper<Equipamentos> {

    @Override
    public Equipamentos mapRow(ResultSet rs) throws SQLException {
      Equipamentos objEquipamentos = new Equipamentos();
      objEquipamentos.setCodEquipamentos(rs.getInt("CODIGO"));
      objEquipamentos.setNomeEquipamentos(rs.getString("NOME"));
      System.out.println("Mapeando o objeto: " + objEquipamentos.toString());
      return objEquipamentos;
    }

  }

}
