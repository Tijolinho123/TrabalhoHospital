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
    String sql = "INSERT INTO EXAMES(NOME,DESCRICAO,VALOR,PREPARO) VALUES(?,?,?,?)";
    save(sql, objExames.getNomeExame(), objExames.getDescricao(), objExames.getValor(), objExames.getPreparo());
  }

  public void alterar(Exames objExames) {
    String sql = "UPDATE EXAMES SET NOME=?,DESCRICAO=?,VALOR=?,PREPARO=? WHERE CODIGO=?";
    save(sql, objExames.getNomeExame(), objExames.getDescricao(), objExames.getValor(), objExames.getPreparo(),
        objExames.getCodExame());
  }

  public void excluir(Exames objExames) {
    String sql = "DELETE FROM EXAMES WHERE CODIGO=?";
    save(sql, objExames.getCodExame());
  }

  public Exames buscarPorExamesPorId(int id) {
    String sql = "SELECT * FROM EXAMES WHERE CODIGO=?";
    return buscarPorId(sql, new ExamesRowMapper(), id);
  }

  public List<Exames> buscarTodosExames() {
    String sql = "SELECT * FROM EXAMES";
    return buscarTodos(sql, new ExamesRowMapper());
  }

  private static class ExamesRowMapper implements RowMapper<Exames> {

    @Override
    public Exames mapRow(ResultSet rs) throws SQLException {
      Exames objExames = new Exames();
      objExames.setCodExame(rs.getInt("CODIGO"));
      objExames.setNomeExame(rs.getString("NOME"));
      objExames.setDescricao(rs.getString("DESCRICAO"));
      objExames.setValor(rs.getDouble("VALOR"));
      objExames.setPreparo(rs.getString("PREPARO"));
      System.out.println("Mapeando o objeto: " + objExames.toString());
      return objExames;
    }

  }

}
