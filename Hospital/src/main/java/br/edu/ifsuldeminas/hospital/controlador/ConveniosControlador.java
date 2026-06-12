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
public class ConveniosControlador extends HttpServlet {

  ConveniosDAO objConveniosDAO;

  @Override
  public void init() throws ServletException {
    objConveniosDAO = new ConveniosDAO();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      String opcao = getParam(request, "opcao", "cadastrar");
      String codigoConvenio = getParam(request, "codigoConvenio", "0");
      String nomeConvenio = getParam(request, "nomeConvenio", "");
      String cnpj = getParam(request, "cnpj", "");
      String telefone = getParam(request, "telefoneConvenio", "");
      String cobertura = getParam(request, "cobertura", "");
      String dataInicio = getParam(request, "dataInicioContrato", "");
      String dataFim = getParam(request, "dataFimContrato", "");

      switch (opcao) {
        case "cadastrar":
          cadastrar(request, response, nomeConvenio, cnpj, telefone, cobertura, dataInicio, dataFim);
          break;
        case "confirmarAlterar":
          confirmarAlterar(request, response, codigoConvenio, nomeConvenio, cnpj, telefone, cobertura, dataInicio,
              dataFim);
          break;
        case "executarAlterar":
          executarAlterar(request, response, codigoConvenio, nomeConvenio, cnpj, telefone, cobertura, dataInicio,
              dataFim);
          break;
        case "confirmarExcluir":
          confirmarExcluir(request, response, codigoConvenio, nomeConvenio, cnpj, telefone, cobertura, dataInicio,
              dataFim);
          break;
        case "executarExcluir":
          executarExcluir(request, response, codigoConvenio, nomeConvenio, cnpj, telefone, cobertura, dataInicio,
              dataFim);
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

  // Helper to avoid repeating null checks everywhere
  private String getParam(HttpServletRequest request, String name, String defaultValue) {
    String val = request.getParameter(name);
    return (val != null) ? val : defaultValue;
  }

  private Calendar parseData(String data) throws ParseException {
    if (data == null || data.isEmpty()) {
      return Calendar.getInstance(); // defaults to today
    }
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Calendar cal = Calendar.getInstance();
    cal.setTime(sdf.parse(data));
    return cal;
  }

  private Convenios buildConvenios(String codigo, String nome, String cnpj, String telefone,
      String cobertura, String dataInicio, String dataFim) throws ParseException {
    Convenios obj = new Convenios();
    if (!codigo.equals("0"))
      obj.setCodConvenio(Integer.valueOf(codigo));
    obj.setNomeConvenio(nome);
    obj.setCnpj(cnpj);
    obj.setTelefoneConvenio(telefone);
    obj.setCobertura(cobertura);
    obj.setDataInicioContrato(parseData(dataInicio));
    obj.setDataFimContrato(parseData(dataFim));
    return obj;
  }

  protected void encaminharPagina(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    List<Convenios> lista = objConveniosDAO.buscarTodosConvenios();
    request.setAttribute("listaConvenios", lista);
    RequestDispatcher dispatcher = request.getRequestDispatcher("/CadastroConvenios.jsp");
    dispatcher.forward(request, response);
  }

  protected void cadastrar(HttpServletRequest request, HttpServletResponse response,
      String nome, String cnpj, String telefone, String cobertura,
      String dataInicio, String dataFim) throws ServletException, IOException, ParseException {

    Convenios novo = new Convenios();
    novo.setNomeConvenio(nome);
    novo.setCnpj(cnpj);
    novo.setTelefoneConvenio(telefone);
    novo.setCobertura(cobertura);
    novo.setDataInicioContrato(parseData(dataInicio));
    novo.setDataFimContrato(parseData(dataFim));

    objConveniosDAO.salvar(novo);
    request.setAttribute("mensagem", "Convênio cadastrado com sucesso!");
    encaminharPagina(request, response);
  }

  protected void confirmarAlterar(HttpServletRequest request, HttpServletResponse response,
      String codigo, String nome, String cnpj, String telefone, String cobertura,
      String dataInicio, String dataFim) throws ServletException, IOException {
    request.setAttribute("opcao", "executarAlterar");
    request.setAttribute("codigoConvenio", codigo);
    request.setAttribute("nomeConvenio", nome);
    request.setAttribute("cnpj", cnpj);
    request.setAttribute("telefoneConvenio", telefone);
    request.setAttribute("cobertura", cobertura);
    request.setAttribute("dataInicioContrato", dataInicio);
    request.setAttribute("dataFimContrato", dataFim);
    request.setAttribute("mensagem", "Edite os dados e clique no botão Salvar");
    encaminharPagina(request, response);
  }

  protected void executarAlterar(HttpServletRequest request, HttpServletResponse response,
      String codigo, String nome, String cnpj, String telefone, String cobertura,
      String dataInicio, String dataFim) throws ServletException, IOException, ParseException {
    objConveniosDAO.alterar(buildConvenios(codigo, nome, cnpj, telefone, cobertura, dataInicio, dataFim));
    request.setAttribute("mensagem", "Cadastro do convênio alterado com sucesso!");
    encaminharPagina(request, response);
  }

  protected void confirmarExcluir(HttpServletRequest request, HttpServletResponse response,
      String codigo, String nome, String cnpj, String telefone, String cobertura,
      String dataInicio, String dataFim) throws ServletException, IOException {
    request.setAttribute("opcao", "executarExcluir");
    request.setAttribute("codigoConvenio", codigo);
    request.setAttribute("nomeConvenio", nome);
    request.setAttribute("cnpj", cnpj);
    request.setAttribute("telefoneConvenio", telefone);
    request.setAttribute("cobertura", cobertura);
    request.setAttribute("dataInicioContrato", dataInicio);
    request.setAttribute("dataFimContrato", dataFim);
    request.setAttribute("mensagem", "Clique no botão Salvar para excluir");
    encaminharPagina(request, response);
  }

  protected void executarExcluir(HttpServletRequest request, HttpServletResponse response,
      String codigo, String nome, String cnpj, String telefone, String cobertura,
      String dataInicio, String dataFim) throws ServletException, IOException, ParseException {
    objConveniosDAO.excluir(buildConvenios(codigo, nome, cnpj, telefone, cobertura, dataInicio, dataFim));
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
    // Do NOT call encaminharPagina if it triggers DAO operations with null dates
    RequestDispatcher dispatcher = request.getRequestDispatcher("/CadastroConvenios.jsp");
    dispatcher.forward(request, response);
  }
}
