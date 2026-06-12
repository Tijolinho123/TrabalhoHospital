/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsuldeminas.hospital.controlador;

import br.edu.ifsuldeminas.hospital.modelo.dao.SalasDAO;
import br.edu.ifsuldeminas.hospital.modelo.entidade.Salas;
import br.edu.ifsuldeminas.hospital.servico.WebConstante;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Tulio Dias
 */
@WebServlet(WebConstante.BASE_PATH + "/SalasControlador")
public class SalasControlador extends HttpServlet {

  String codigoSala = "", nomeSala = "", setor = "";
  Salas objSalas;
  SalasDAO objSalasDAO;

  @Override
  public void init() throws ServletException {
    objSalas = new Salas();
    objSalasDAO = new SalasDAO();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      String opcao = request.getParameter("opcao");
      if (opcao == null || opcao.isEmpty()) {
        opcao = "cadastrar";
      }
      codigoSala = request.getParameter("codigoSala");
      nomeSala = request.getParameter("nomeSala");
      setor = request.getParameter("setor");
      switch (opcao) {
        case "cadastrar":
          cadastrar(request, response);
          break;
        case "confirmarAlterar":
          confirmarAlterar(request, response);
          break;
        case "executarAlterar":
          executarAlterar(request, response);
          break;
        case "confirmarExcluir":
          confirmarExcluir(request, response);
          break;
        case "executarExcluir":
          executarExcluir(request, response);
          break;
        case "cancelar":
          cancelar(request, response);
          break;
        default:
          throw new IllegalArgumentException("Opção Inválida: " + opcao);
      }
    } catch (NumberFormatException ex) {
      response.getWriter().println("Erro: " + ex.getMessage());
    } catch (IllegalArgumentException ex) {
      response.getWriter().println("Erro: " + ex.getMessage());
    }
  }

  protected void cadastrar(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    objSalas.setNomeSala(nomeSala);
    objSalas.setSetor(setor);
    objSalasDAO.salvar(objSalas);
    request.setAttribute("mensagem", "Sala cadastrada com sucesso!");
    encaminharPagina(request, response);
  }

  protected void encaminharPagina(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    List<Salas> listaSalas = objSalasDAO.buscarTodasSalas();
    request.setAttribute("listaSalas", listaSalas);
    RequestDispatcher dispatcher = request.getRequestDispatcher("/CadastroSalas.jsp");
    dispatcher.forward(request, response);
  }

  protected void confirmarAlterar(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setAttribute("opcao", "executarAlterar");
    request.setAttribute("codigoSala", codigoSala);
    request.setAttribute("nomeSala", nomeSala);
    request.setAttribute("setor", setor);
    request.setAttribute("mensagem", "Edite os dados e clique no botão Salvar");
    encaminharPagina(request, response);
  }

  protected void executarAlterar(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    objSalas.setCodSala(Integer.valueOf(codigoSala));
    objSalas.setNomeSala(nomeSala);
    objSalas.setSetor(setor);
    objSalasDAO.alterar(objSalas);
    request.setAttribute("mensagem", "Cadastro da sala alterado com sucesso!");
    encaminharPagina(request, response);
  }

  protected void confirmarExcluir(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setAttribute("opcao", "executarExcluir");
    request.setAttribute("codigoSala", codigoSala);
    request.setAttribute("nomeSala", nomeSala);
    request.setAttribute("setor", setor);
    request.setAttribute("mensagem", "Clique no botão Salvar para excluir");
    encaminharPagina(request, response);
  }

  protected void executarExcluir(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    objSalas.setCodSala(Integer.valueOf(codigoSala));
    objSalas.setNomeSala(nomeSala);
    objSalas.setSetor(setor);
    objSalasDAO.excluir(objSalas);
    request.setAttribute("mensagem", "Cadastro da sala excluído com sucesso!");
    encaminharPagina(request, response);
  }

  protected void cancelar(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setAttribute("opcao", "cadastrar");
    request.setAttribute("codigoSala", "0");
    request.setAttribute("nomeSala", "");
    request.setAttribute("setor", "");
    encaminharPagina(request, response);
  }

}
