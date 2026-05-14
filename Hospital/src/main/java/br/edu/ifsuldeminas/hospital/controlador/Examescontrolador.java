/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsuldeminas.hospital.controlador;

import br.edu.ifsuldeminas.hospital.modelo.dao.ExamesDAO;
import br.edu.ifsuldeminas.hospital.modelo.entidade.Exames;
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
@WebServlet(WebConstante.BASE_PATH + "/ExamesControlador")
public class Examescontrolador extends HttpServlet {

  String codigoExame = "", nomeExame = "", descricao = "", valor = "", preparo = "";
  Exames objExames;
  ExamesDAO objExamesDAO;

  @Override
  public void init() throws ServletException {
    objExames = new Exames();
    objExamesDAO = new ExamesDAO();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      String opcao = request.getParameter("opcao");
      if (opcao == null || opcao.isEmpty()) {
        opcao = "cadastrar";
      }
      codigoExame = request.getParameter("codigoExame");
      nomeExame = request.getParameter("nomeExame");
      descricao = request.getParameter("descricao");
      valor = request.getParameter("valor");
      preparo = request.getParameter("preparo");
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
    objExames.setNomeExame(nomeExame);
    objExames.setDescricao(descricao);
    objExames.setValor(Double.valueOf(valor));
    objExames.setPreparo(preparo);
    objExamesDAO.salvar(objExames);
    request.setAttribute("mensagem", "Exame cadastrado com sucesso!");
    encaminharPagina(request, response);
  }

  protected void encaminharPagina(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    List<Exames> listaExames = objExamesDAO.buscarTodosExames();
    request.setAttribute("listaExames", listaExames);
    RequestDispatcher dispatcher = request.getRequestDispatcher("/CadastroExames.jsp");
    dispatcher.forward(request, response);
  }

  protected void confirmarAlterar(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setAttribute("opcao", "executarAlterar");
    request.setAttribute("codigoExame", codigoExame);
    request.setAttribute("nomeExame", nomeExame);
    request.setAttribute("descricao", descricao);
    request.setAttribute("valor", valor);
    request.setAttribute("preparo", preparo);
    request.setAttribute("mensagem", "Edite os dados e clique no botão Salvar");
    encaminharPagina(request, response);
  }

  protected void executarAlterar(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    objExames.setCodExame(Integer.valueOf(codigoExame));
    objExames.setNomeExame(nomeExame);
    objExames.setDescricao(descricao);
    objExames.setValor(Double.valueOf(valor));
    objExames.setPreparo(preparo);
    objExamesDAO.alterar(objExames);
    request.setAttribute("mensagem", "Cadastro do exame alterado com sucesso!");
    encaminharPagina(request, response);
  }

  protected void confirmarExcluir(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setAttribute("opcao", "executarExcluir");
    request.setAttribute("codigoExame", codigoExame);
    request.setAttribute("nomeExame", nomeExame);
    request.setAttribute("descricao", descricao);
    request.setAttribute("valor", valor);
    request.setAttribute("preparo", preparo);
    request.setAttribute("mensagem", "Clique no botão Salvar para excluir");
    encaminharPagina(request, response);
  }

  protected void executarExcluir(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    objExames.setCodExame(Integer.valueOf(codigoExame));
    objExames.setNomeExame(nomeExame);
    objExames.setDescricao(descricao);
    objExames.setValor(Double.valueOf(valor));
    objExames.setPreparo(preparo);
    objExamesDAO.excluir(objExames);
    request.setAttribute("mensagem", "Cadastro do exame excluído com sucesso!");
    encaminharPagina(request, response);
  }

  protected void cancelar(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setAttribute("opcao", "cadastrar");
    request.setAttribute("codigoExame", "0");
    request.setAttribute("nomeExame", "");
    request.setAttribute("descricao", "");
    request.setAttribute("valor", "");
    request.setAttribute("preparo", "");
    encaminharPagina(request, response);
  }

}
