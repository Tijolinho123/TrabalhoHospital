/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsuldeminas.hospital.modelo.dao;

import br.edu.ifsuldeminas.hospital.modelo.entidade.TipoPaciente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Tulio Dias
 */
public class TipoPacienteDAO extends GenericoDAO<TipoPaciente> {

  public void salvar(TipoPaciente objTipoPaciente) {
    String sql = "INSERT INTO TIPO_PACIENTE(NOME) VALUES(?)";
    save(sql, objTipoPaciente.getNomeTipoPaciente());
  }

  public void alterar(TipoPaciente objTipoPaciente) {
    String sql = "UPDATE TIPO_PACIENTE SET NOME=? WHERE CODIGO=?";
    save(sql, objTipoPaciente.getNomeTipoPaciente(), objTipoPaciente.getCodPaciente());
  }

  public void excluir(TipoPaciente objTipoPaciente) {
    String sql = "DELETE FROM TIPO_PACIENTE WHERE CODIGO=?";
    save(sql, objTipoPaciente.getCodPaciente());
  }

  public TipoPaciente buscarPorTipoPacientePorId(int id) {
    String sql = "SELECT * FROM TIPO_PACIENTE WHERE CODIGO=?";
    return buscarPorId(sql, new TipoPacienteRowMapper(), id);
  }

  public List<TipoPaciente> buscarTodosTipoPacientes() {
    String sql = "SELECT * FROM TIPO_PACIENTE";
    return buscarTodos(sql, new TipoPacienteRowMapper());
  }

  private static class TipoPacienteRowMapper implements RowMapper<TipoPaciente> {

    @Override
    public TipoPaciente mapRow(ResultSet rs) throws SQLException {
      TipoPaciente objTipoPaciente = new TipoPaciente();
      objTipoPaciente.setCodPaciente(rs.getInt("CODIGO"));
      objTipoPaciente.setNomeTipoPaciente(rs.getString("NOME"));
      System.out.println("Mapeando o objeto: " + objTipoPaciente.toString());
      return objTipoPaciente;
    }

  }

}
