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
    String sql = "INSERT INTO CONVENIOS(NOME,CNPJ,TELEFONE,COBERTURA,DATA_INICIO_CONTRATO,DATA_FIM_CONTRATO) VALUES(?,?,?,?,?,?)";
    save(sql, objConvenios.getNomeConvenio(), objConvenios.getCnpj(), objConvenios.getTelefoneConvenio(),
        objConvenios.getCobertura(),
        new java.sql.Date(objConvenios.getDataInicioContrato().getTimeInMillis()),
        new java.sql.Date(objConvenios.getDataFimContrato().getTimeInMillis()));
  }

  public void alterar(Convenios objConvenios) {
    String sql = "UPDATE CONVENIOS SET NOME=?,CNPJ=?,TELEFONE=?,COBERTURA=?,DATA_INICIO_CONTRATO=?,DATA_FIM_CONTRATO=? WHERE CODIGO=?";
    save(sql, objConvenios.getNomeConvenio(), objConvenios.getCnpj(), objConvenios.getTelefoneConvenio(),
        objConvenios.getCobertura(),
        new java.sql.Date(objConvenios.getDataInicioContrato().getTimeInMillis()),
        new java.sql.Date(objConvenios.getDataFimContrato().getTimeInMillis()),
        objConvenios.getCodConvenio());
  }

  public void excluir(Convenios objConvenios) {
    String sql = "DELETE FROM CONVENIOS WHERE CODIGO=?";
    save(sql, objConvenios.getCodConvenio());
  }

  public Convenios buscarPorConveniosPorId(int id) {
    String sql = "SELECT * FROM CONVENIOS WHERE CODIGO=?";
    return buscarPorId(sql, new ConveniosRowMapper(), id);
  }

  public List<Convenios> buscarTodosConvenios() {
    String sql = "SELECT * FROM CONVENIOS";
    return buscarTodos(sql, new ConveniosRowMapper());
  }

  private static class ConveniosRowMapper implements RowMapper<Convenios> {

    @Override
    public Convenios mapRow(ResultSet rs) throws SQLException {
      Convenios objConvenios = new Convenios();
      objConvenios.setCodConvenio(rs.getInt("CODIGO"));
      objConvenios.setNomeConvenio(rs.getString("NOME"));
      objConvenios.setCnpj(rs.getString("CNPJ"));
      objConvenios.setTelefoneConvenio(rs.getString("TELEFONE"));
      objConvenios.setCobertura(rs.getString("COBERTURA"));

      Calendar dataInicio = Calendar.getInstance();
      dataInicio.setTime(rs.getDate("DATA_INICIO_CONTRATO"));
      objConvenios.setDataInicioContrato(dataInicio);

      Calendar dataFim = Calendar.getInstance();
      dataFim.setTime(rs.getDate("DATA_FIM_CONTRATO"));
      objConvenios.setDataFimContrato(dataFim);

      System.out.println("Mapeando o objeto: " + objConvenios.toString());
      return objConvenios;
    }

  }

}
