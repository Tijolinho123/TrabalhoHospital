package br.edu.ifsuldeminas.hospital.modelo.dao;

import br.edu.ifsuldeminas.hospital.modelo.entidade.Salas;

public class SalasDao extends GenericoDAO<Salas> {

  public void salvar(Salas objSala) {
    String sql = "INSERT INTO CIDADE(NOMESALA,SETOR) VALUES(?,?)";
    save(sql, objSala.getNomeSala(), objSala.getSetor(), objSala.getCodSala());
  }
}
