/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsuldeminas.hospital.modelo.dao;

import br.edu.ifsuldeminas.hospital.modelo.entidade.Exames;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Tulio Dias
 */
public class ExamesDAO extends GenericoDAO<Exames> {

  public void salvar(Exames objExames) {
    String sql = "INSERT INTO tbl_Exames(nomeExame,descricao,valor,preparo) VALUES(?,?,?,?)";
    save(sql, objExames.getNomeExame(), objExames.getDescricao(), objExames.getValor(), objExames.getPreparo());
  }

  public void alterar(Exames objExames) {
    String sql = "UPDATE tbl_Exames SET nomeExame=?,descricao=?,valor=?,preparo=? WHERE codExame=?";
    save(sql, objExames.getNomeExame(), objExames.getDescricao(), objExames.getValor(), objExames.getPreparo(),
        objExames.getCodExame());
  }

  public void excluir(Exames objExames) {
    String sql = "DELETE FROM tbl_Exames WHERE codExame=?";
    save(sql, objExames.getCodExame());
  }

  public Exames buscarPorExamesPorId(int id) {
    String sql = "SELECT * FROM tbl_Exames WHERE codExame=?";
    return buscarPorId(sql, new ExamesRowMapper(), id);
  }

  public List<Exames> buscarTodosExames() {
    String sql = "SELECT * FROM tbl_Exames";
    return buscarTodos(sql, new ExamesRowMapper());
  }

  private static class ExamesRowMapper implements RowMapper<Exames> {

    @Override
    public Exames mapRow(ResultSet rs) throws SQLException {
      Exames objExames = new Exames();
      objExames.setCodExame(rs.getInt("codExame"));
      objExames.setNomeExame(rs.getString("nomeExame"));
      objExames.setDescricao(rs.getString("descricao"));
      objExames.setValor(rs.getDouble("valor"));
      objExames.setPreparo(rs.getString("preparo"));
      System.out.println("Mapeando o objeto: " + objExames.toString());
      return objExames;
    }

  }

}
