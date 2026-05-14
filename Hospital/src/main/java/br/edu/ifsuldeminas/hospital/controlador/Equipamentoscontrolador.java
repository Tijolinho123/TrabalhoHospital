/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsuldeminas.hospital.controlador;

import br.edu.ifsuldeminas.hospital.modelo.dao.EquipamentosDAO;
import br.edu.ifsuldeminas.hospital.modelo.entidade.Equipamentos;
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
@WebServlet(WebConstante.BASE_PATH + "/EquipamentosControlador")
public class Equipamentoscontrolador extends HttpServlet {

  String codigoEquipamentos = "", nomeEquipamentos = "";
  Equipamentos objEquipamentos;
  EquipamentosDAO objEquipamentosDAO;

  @Override
  public void init() throws ServletException {
    objEquipamentos = new Equipamentos();
    objEquipamentosDAO = new EquipamentosDAO();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      String opcao = request.getParameter("opcao");
      if (opcao == null || opcao.isEmpty()) {
        opcao = "cadastrar";
      }
      codigoEquipamentos = request.getParameter("codigoEquipamentos");
      nomeEquipamentos = request.getParameter("nomeEquipamentos");
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
    objEquipamentos.setNomeEquipamentos(nomeEquipamentos);
    objEquipamentosDAO.salvar(objEquipamentos);
    request.setAttribute("mensagem", "Equipamento cadastrado com sucesso!");
    encaminharPagina(request, response);
  }

  protected void encaminharPagina(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    List<Equipamentos> listaEquipamentos = objEquipamentosDAO.buscarTodosEquipamentos();
    request.setAttribute("listaEquipamentos", listaEquipamentos);
    RequestDispatcher dispatcher = request.getRequestDispatcher("/CadastroEquipamentos.jsp");
    dispatcher.forward(request, response);
  }

  protected void confirmarAlterar(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setAttribute("opcao", "executarAlterar");
    request.setAttribute("codigoEquipamentos", codigoEquipamentos);
    request.setAttribute("nomeEquipamentos", nomeEquipamentos);
    request.setAttribute("mensagem", "Edite os dados e clique no botão Salvar");
    encaminharPagina(request, response);
  }

  protected void executarAlterar(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    objEquipamentos.setCodEquipamentos(Integer.valueOf(codigoEquipamentos));
    objEquipamentos.setNomeEquipamentos(nomeEquipamentos);
    objEquipamentosDAO.alterar(objEquipamentos);
    request.setAttribute("mensagem", "Cadastro do equipamento alterado com sucesso!");
    encaminharPagina(request, response);
  }

  protected void confirmarExcluir(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setAttribute("opcao", "executarExcluir");
    request.setAttribute("codigoEquipamentos", codigoEquipamentos);
    request.setAttribute("nomeEquipamentos", nomeEquipamentos);
    request.setAttribute("mensagem", "Clique no botão Salvar para excluir");
    encaminharPagina(request, response);
  }

  protected void executarExcluir(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    objEquipamentos.setCodEquipamentos(Integer.valueOf(codigoEquipamentos));
    objEquipamentos.setNomeEquipamentos(nomeEquipamentos);
    objEquipamentosDAO.excluir(objEquipamentos);
    request.setAttribute("mensagem", "Cadastro do equipamento excluído com sucesso!");
    encaminharPagina(request, response);
  }

  protected void cancelar(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setAttribute("opcao", "cadastrar");
    request.setAttribute("codigoEquipamentos", "0");
    request.setAttribute("nomeEquipamentos", "");
    encaminharPagina(request, response);
  }

}
