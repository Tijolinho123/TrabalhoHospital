/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsuldeminas.hospital.modelo.dao;

import br.edu.ifsuldeminas.hospital.modelo.entidade.Salas;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Tulio Dias
 */
public class SalasDAO extends GenericoDAO<Salas> {

  public void salvar(Salas objSalas) {
    String sql = "INSERT INTO tbl_Salas(nomeSala,setor) VALUES(?,?)";
    save(sql, objSalas.getNomeSala(), objSalas.getSetor());
  }

  public void alterar(Salas objSalas) {
    String sql = "UPDATE tbl_Salas SET nomeSala=?,setor=? WHERE codSala=?";
    save(sql, objSalas.getNomeSala(), objSalas.getSetor(), objSalas.getCodSala());
  }

  public void excluir(Salas objSalas) {
    String sql = "DELETE FROM tbl_Salas WHERE codSala=?";
    save(sql, objSalas.getCodSala());
  }

  public Salas buscarPorSalasPorId(int id) {
    String sql = "SELECT * FROM tbl_Salas WHERE codSala=?";
    return buscarPorId(sql, new SalasRowMapper(), id);
  }

  public List<Salas> buscarTodasSalas() {
    String sql = "SELECT * FROM tbl_Salas";
    return buscarTodos(sql, new SalasRowMapper());
  }

  private static class SalasRowMapper implements RowMapper<Salas> {

    @Override
    public Salas mapRow(ResultSet rs) throws SQLException {
      Salas objSalas = new Salas();
      objSalas.setCodSala(rs.getInt("codSala"));
      objSalas.setNomeSala(rs.getString("nomeSala"));
      objSalas.setSetor(rs.getString("setor"));
      System.out.println("Mapeando o objeto: " + objSalas.toString());
      return objSalas;
    }

  }

}
