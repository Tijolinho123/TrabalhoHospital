/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsuldeminas.hospital.controlador;

import br.edu.ifsuldeminas.hospital.modelo.dao.ConveniosDAO;
import br.edu.ifsuldeminas.hospital.modelo.entidade.Convenios;
import br.edu.ifsuldeminas.hospital.servico.WebConstante;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Tulio Dias
 */
@WebServlet(WebConstante.BASE_PATH + "/ConveniosControlador")
public class Convenioscontrolador extends HttpServlet {

  String codigoConvenio = "", nomeConvenio = "", cnpj = "", telefoneConvenio = "",
      cobertura = "", dataInicioContrato = "", dataFimContrato = "";
  Convenios objConvenios;
  ConveniosDAO objConveniosDAO;

  @Override
  public void init() throws ServletException {
    objConvenios = new Convenios();
    objConveniosDAO = new ConveniosDAO();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      String opcao = request.getParameter("opcao");
      if (opcao == null || opcao.isEmpty()) {
        opcao = "cadastrar";
      }
      codigoConvenio = request.getParameter("codigoConvenio");
      nomeConvenio = request.getParameter("nomeConvenio");
      cnpj = request.getParameter("cnpj");
      telefoneConvenio = request.getParameter("telefoneConvenio");
      cobertura = request.getParameter("cobertura");
      dataInicioContrato = request.getParameter("dataInicioContrato");
      dataFimContrato = request.getParameter("dataFimContrato");
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
    } catch (ParseException ex) {
      response.getWriter().println("Erro no formato da data: " + ex.getMessage());
    }
  }

  private Calendar parseData(String data) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Calendar cal = Calendar.getInstance();
    cal.setTime(sdf.parse(data));
    return cal;
  }

  protected void cadastrar(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException, ParseException {
    objConvenios.setNomeConvenio(nomeConvenio);
    objConvenios.setCnpj(cnpj);
    objConvenios.setTelefoneConvenio(telefoneConvenio);
    objConvenios.setCobertura(cobertura);
    objConvenios.setDataInicioContrato(parseData(dataInicioContrato));
    objConvenios.setDataFimContrato(parseData(dataFimContrato));
    objConveniosDAO.salvar(objConvenios);
    request.setAttribute("mensagem", "Convênio cadastrado com sucesso!");
    encaminharPagina(request, response);
  }

  protected void encaminharPagina(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    List<Convenios> listaConvenios = objConveniosDAO.buscarTodosConvenios();
    request.setAttribute("listaConvenios", listaConvenios);
    RequestDispatcher dispatcher = request.getRequestDispatcher("/CadastroConvenios.jsp");
    dispatcher.forward(request, response);
  }

  protected void confirmarAlterar(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setAttribute("opcao", "executarAlterar");
    request.setAttribute("codigoConvenio", codigoConvenio);
    request.setAttribute("nomeConvenio", nomeConvenio);
    request.setAttribute("cnpj", cnpj);
    request.setAttribute("telefoneConvenio", telefoneConvenio);
    request.setAttribute("cobertura", cobertura);
    request.setAttribute("dataInicioContrato", dataInicioContrato);
    request.setAttribute("dataFimContrato", dataFimContrato);
    request.setAttribute("mensagem", "Edite os dados e clique no botão Salvar");
    encaminharPagina(request, response);
  }

  protected void executarAlterar(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException, ParseException {
    objConvenios.setCodConvenio(Integer.valueOf(codigoConvenio));
    objConvenios.setNomeConvenio(nomeConvenio);
    objConvenios.setCnpj(cnpj);
    objConvenios.setTelefoneConvenio(telefoneConvenio);
    objConvenios.setCobertura(cobertura);
    objConvenios.setDataInicioContrato(parseData(dataInicioContrato));
    objConvenios.setDataFimContrato(parseData(dataFimContrato));
    objConveniosDAO.alterar(objConvenios);
    request.setAttribute("mensagem", "Cadastro do convênio alterado com sucesso!");
    encaminharPagina(request, response);
  }

  protected void confirmarExcluir(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setAttribute("opcao", "executarExcluir");
    request.setAttribute("codigoConvenio", codigoConvenio);
    request.setAttribute("nomeConvenio", nomeConvenio);
    request.setAttribute("cnpj", cnpj);
    request.setAttribute("telefoneConvenio", telefoneConvenio);
    request.setAttribute("cobertura", cobertura);
    request.setAttribute("dataInicioContrato", dataInicioContrato);
    request.setAttribute("dataFimContrato", dataFimContrato);
    request.setAttribute("mensagem", "Clique no botão Salvar para excluir");
    encaminharPagina(request, response);
  }

  protected void executarExcluir(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException, ParseException {
    objConvenios.setCodConvenio(Integer.valueOf(codigoConvenio));
    objConvenios.setNomeConvenio(nomeConvenio);
    objConvenios.setCnpj(cnpj);
    objConvenios.setTelefoneConvenio(telefoneConvenio);
    objConvenios.setCobertura(cobertura);
    objConvenios.setDataInicioContrato(parseData(dataInicioContrato));
    objConvenios.setDataFimContrato(parseData(dataFimContrato));
    objConveniosDAO.excluir(objConvenios);
    request.setAttribute("mensagem", "Cadastro do convênio excluído com sucesso!");
    encaminharPagina(request, response);
  }

  protected void cancelar(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setAttribute("opcao", "cadastrar");
    request.setAttribute("codigoConvenio", "0");
    request.setAttribute("nomeConvenio", "");
    request.setAttribute("cnpj", "");
    request.setAttribute("telefoneConvenio", "");
    request.setAttribute("cobertura", "");
    request.setAttribute("dataInicioContrato", "");
    request.setAttribute("dataFimContrato", "");
    encaminharPagina(request, response);
  }

}
