/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsuldeminas.hospital.controlador;

import br.edu.ifsuldeminas.hospital.modelo.dao.RemediosDAO;
import br.edu.ifsuldeminas.hospital.modelo.entidade.Remedios;
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
@WebServlet(WebConstante.BASE_PATH + "/RemediosControlador")
public class Remedioscontrolador extends HttpServlet {

  String codigoRemedio = "", nomeRemedio = "", laboratorio = "", efeitosColaterais = "";
  Remedios objRemedios;
  RemediosDAO objRemediosDAO;

  @Override
  public void init() throws ServletException {
    objRemedios = new Remedios();
    objRemediosDAO = new RemediosDAO();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      String opcao = request.getParameter("opcao");
      if (opcao == null || opcao.isEmpty()) {
        opcao = "cadastrar";
      }
      codigoRemedio = request.getParameter("codigoRemedio");
      nomeRemedio = request.getParameter("nomeRemedio");
      laboratorio = request.getParameter("laboratorio");
      efeitosColaterais = request.getParameter("efeitosColaterais");
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
    objRemedios.setNomeRemedio(nomeRemedio);
    objRemedios.setLaboratorio(laboratorio);
    objRemedios.setEfeitosColaterais(efeitosColaterais);
    objRemediosDAO.salvar(objRemedios);
    request.setAttribute("mensagem", "Remédio cadastrado com sucesso!");
    encaminharPagina(request, response);
  }

  protected void encaminharPagina(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    List<Remedios> listaRemedios = objRemediosDAO.buscarTodosRemedios();
    request.setAttribute("listaRemedios", listaRemedios);
    RequestDispatcher dispatcher = request.getRequestDispatcher("/CadastroRemedios.jsp");
    dispatcher.forward(request, response);
  }

  protected void confirmarAlterar(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setAttribute("opcao", "executarAlterar");
    request.setAttribute("codigoRemedio", codigoRemedio);
    request.setAttribute("nomeRemedio", nomeRemedio);
    request.setAttribute("laboratorio", laboratorio);
    request.setAttribute("efeitosColaterais", efeitosColaterais);
    request.setAttribute("mensagem", "Edite os dados e clique no botão Salvar");
    encaminharPagina(request, response);
  }

  protected void executarAlterar(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    objRemedios.setCodRemedio(Integer.valueOf(codigoRemedio));
    objRemedios.setNomeRemedio(nomeRemedio);
    objRemedios.setLaboratorio(laboratorio);
    objRemedios.setEfeitosColaterais(efeitosColaterais);
    objRemediosDAO.alterar(objRemedios);
    request.setAttribute("mensagem", "Cadastro do remédio alterado com sucesso!");
    encaminharPagina(request, response);
  }

  protected void confirmarExcluir(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setAttribute("opcao", "executarExcluir");
    request.setAttribute("codigoRemedio", codigoRemedio);
    request.setAttribute("nomeRemedio", nomeRemedio);
    request.setAttribute("laboratorio", laboratorio);
    request.setAttribute("efeitosColaterais", efeitosColaterais);
    request.setAttribute("mensagem", "Clique no botão Salvar para excluir");
    encaminharPagina(request, response);
  }

  protected void executarExcluir(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    objRemedios.setCodRemedio(Integer.valueOf(codigoRemedio));
    objRemedios.setNomeRemedio(nomeRemedio);
    objRemedios.setLaboratorio(laboratorio);
    objRemedios.setEfeitosColaterais(efeitosColaterais);
    objRemediosDAO.excluir(objRemedios);
    request.setAttribute("mensagem", "Cadastro do remédio excluído com sucesso!");
    encaminharPagina(request, response);
  }

  protected void cancelar(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setAttribute("opcao", "cadastrar");
    request.setAttribute("codigoRemedio", "0");
    request.setAttribute("nomeRemedio", "");
    request.setAttribute("laboratorio", "");
    request.setAttribute("efeitosColaterais", "");
    encaminharPagina(request, response);
  }

}
