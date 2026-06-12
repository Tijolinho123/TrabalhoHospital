/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsuldeminas.hospital.modelo.dao;

import br.edu.ifsuldeminas.hospital.modelo.entidade.Remedios;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Tulio Dias
 */
public class RemediosDAO extends GenericoDAO<Remedios> {

  public void salvar(Remedios objRemedios) {
    String sql = "INSERT INTO tbl_Remedios(nomeRemedio,laboratorio,efeitosColaterais) VALUES(?,?,?)";
    save(sql, objRemedios.getNomeRemedio(), objRemedios.getLaboratorio(), objRemedios.getEfeitosColaterais());
  }

  public void alterar(Remedios objRemedios) {
    String sql = "UPDATE tbl_Remedios SET nomeRemedio=?,laboratorio=?,efeitosColaterais=? WHERE codRemedio=?";
    save(sql, objRemedios.getNomeRemedio(), objRemedios.getLaboratorio(), objRemedios.getEfeitosColaterais(),
        objRemedios.getCodRemedio());
  }

  public void excluir(Remedios objRemedios) {
    String sql = "DELETE FROM tbl_Remedios WHERE codRemedio=?";
    save(sql, objRemedios.getCodRemedio());
  }

  public Remedios buscarPorRemediosPorId(int id) {
    String sql = "SELECT * FROM tbl_Remedios WHERE codRemedio=?";
    return buscarPorId(sql, new RemediosRowMapper(), id);
  }

  public List<Remedios> buscarTodosRemedios() {
    String sql = "SELECT * FROM tbl_Remedios";
    return buscarTodos(sql, new RemediosRowMapper());
  }

  private static class RemediosRowMapper implements RowMapper<Remedios> {

    @Override
    public Remedios mapRow(ResultSet rs) throws SQLException {
      Remedios objRemedios = new Remedios();
      objRemedios.setCodRemedio(rs.getInt("codRemedio"));
      objRemedios.setNomeRemedio(rs.getString("nomeRemedio"));
      objRemedios.setLaboratorio(rs.getString("laboratorio"));
      objRemedios.setEfeitosColaterais(rs.getString("efeitosColaterais"));
      System.out.println("Mapeando o objeto: " + objRemedios.toString());
      return objRemedios;
    }

  }

}
