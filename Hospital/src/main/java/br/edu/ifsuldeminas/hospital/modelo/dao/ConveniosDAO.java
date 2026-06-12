/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsuldeminas.hospital.modelo.dao;

import br.edu.ifsuldeminas.hospital.modelo.entidade.Convenios;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Tulio Dias
 */
public class ConveniosDAO extends GenericoDAO<Convenios> {

  public void salvar(Convenios objConvenios) {
    String sql = "INSERT INTO tbl_Convenios(nomeConvenio,cnpj,telefoneConvenio,cobertura,dataInicioContrato,dataFimContrato) VALUES(?,?,?,?,?,?)";
    save(sql, objConvenios.getNomeConvenio(), objConvenios.getCnpj(), objConvenios.getTelefoneConvenio(),
        objConvenios.getCobertura(),
        new java.sql.Date(objConvenios.getDataInicioContrato().getTimeInMillis()),
        new java.sql.Date(objConvenios.getDataFimContrato().getTimeInMillis()));
  }

  public void alterar(Convenios objConvenios) {
    String sql = "UPDATE tbl_Convenios SET nomeConvenio=?,cnpj=?,telefoneConvenio=?,cobertura=?,dataInicioContrato=?,dataFimContrato=? WHERE codConvenio=?";
    save(sql, objConvenios.getNomeConvenio(), objConvenios.getCnpj(), objConvenios.getTelefoneConvenio(),
        objConvenios.getCobertura(),
        new java.sql.Date(objConvenios.getDataInicioContrato().getTimeInMillis()),
        new java.sql.Date(objConvenios.getDataFimContrato().getTimeInMillis()),
        objConvenios.getCodConvenio());
  }

  public void excluir(Convenios objConvenios) {
    String sql = "DELETE FROM tbl_Convenios WHERE codConvenio=?";
    save(sql, objConvenios.getCodConvenio());
  }

  public Convenios buscarPorConveniosPorId(int id) {
    String sql = "SELECT * FROM tbl_Convenios WHERE codConvenio=?";
    return buscarPorId(sql, new ConveniosRowMapper(), id);
  }

  public List<Convenios> buscarTodosConvenios() {
    String sql = "SELECT * FROM tbl_Convenios";
    return buscarTodos(sql, new ConveniosRowMapper());
  }

  private static class ConveniosRowMapper implements RowMapper<Convenios> {

    @Override
    public Convenios mapRow(ResultSet rs) throws SQLException {
      Convenios objConvenios = new Convenios();
      objConvenios.setCodConvenio(rs.getInt("codConvenio"));
      objConvenios.setNomeConvenio(rs.getString("nomeConvenio"));
      objConvenios.setCnpj(rs.getString("cnpj"));
      objConvenios.setTelefoneConvenio(rs.getString("telefoneConvenio"));
      objConvenios.setCobertura(rs.getString("cobertura"));

      Calendar dataInicio = Calendar.getInstance();
      dataInicio.setTime(rs.getDate("dataInicioContrato"));
      objConvenios.setDataInicioContrato(dataInicio);

      Calendar dataFim = Calendar.getInstance();
      dataFim.setTime(rs.getDate("dataFimContrato"));
      objConvenios.setDataFimContrato(dataFim);

      System.out.println("Mapeando o objeto: " + objConvenios.toString());
      return objConvenios;
    }

  }

}
