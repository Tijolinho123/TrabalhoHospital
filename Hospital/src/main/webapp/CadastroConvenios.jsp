<%-- 
    Document   : CadastroConvenios
    Author     : Tulio Dias
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Convênios</title>
    </head>

    <%@include file="menu.jsp" %>
    <body>
        <h1>Cadastro Convênios</h1>
        <form name="cadastro" method="get" action="${pageContext.request.contextPath}${URL_BASE}/ConveniosControlador">
            <input type="hidden" name="opcao" value="${opcao}"/>
            <input type="hidden" name="codigoConvenio" value="${codigoConvenio}"/>
            <p><label>Nome: </label><input type="text" name="nomeConvenio" value="${nomeConvenio}" size="40"></p>
            <p><label>CNPJ: </label><input type="text" name="cnpj" value="${cnpj}" size="20"></p>
            <p><label>Telefone: </label><input type="text" name="telefoneConvenio" value="${telefoneConvenio}" size="20"></p>
            <p><label>Cobertura: </label><input type="text" name="cobertura" value="${cobertura}" size="60"></p>
            <p><label>Data Início Contrato: </label><input type="date" name="dataInicioContrato" value="${dataInicioContrato}"></p>
            <p><label>Data Fim Contrato: </label><input type="date" name="dataFimContrato" value="${dataFimContrato}"></p>
            <input type="submit" value="Salvar" name="Salvar" style="float:left; margin-right: 3px">
        </form>
        <form id="cadastroForm" name="cadastro" method="get" action="${pageContext.request.contextPath}${URL_BASE}/ConveniosControlador">
            <input type="submit" value="Cancelar" name="btnCancelar">
            <input type="hidden" name="opcao" value="cancelar">
        </form>
        <h2>${mensagem}</h2>

        <table border="1">
            <c:if test="${not empty listaConvenios}">
                <tr><th>CÓDIGO</th><th>NOME</th><th>CNPJ</th><th>TELEFONE</th><th>COBERTURA</th><th>INÍCIO CONTRATO</th><th>FIM CONTRATO</th><th>ALTERAR</th><th>EXCLUIR</th></tr>
            </c:if>
            <c:forEach var="convenio" items="${listaConvenios}">
                <tr>
                    <td>${convenio.codConvenio}</td>
                    <td>${convenio.nomeConvenio}</td>
                    <td>${convenio.cnpj}</td>
                    <td>${convenio.telefoneConvenio}</td>
                    <td>${convenio.cobertura}</td>
                    <td>${convenio.dataInicioContrato}</td>
                    <td>${convenio.dataFimContrato}</td>
                    <td>
                        <form name="cadastro" method="get" action="${pageContext.request.contextPath}${URL_BASE}/ConveniosControlador">
                            <input type="hidden" name="codigoConvenio" value="${convenio.codConvenio}"/>
                            <input type="hidden" name="nomeConvenio" value="${convenio.nomeConvenio}"/>
                            <input type="hidden" name="cnpj" value="${convenio.cnpj}"/>
                            <input type="hidden" name="telefoneConvenio" value="${convenio.telefoneConvenio}"/>
                            <input type="hidden" name="cobertura" value="${convenio.cobertura}"/>
                            <input type="hidden" name="dataInicioContrato" value="${convenio.dataInicioContrato}"/>
                            <input type="hidden" name="dataFimContrato" value="${convenio.dataFimContrato}"/>
                            <input type="hidden" name="opcao" value="confirmarAlterar"/>
                            <button type="submit">Alterar</button>
                        </form>
                    </td>
                    <td>
                        <form name="cadastro" method="get" action="${pageContext.request.contextPath}${URL_BASE}/ConveniosControlador">
                            <input type="hidden" name="codigoConvenio" value="${convenio.codConvenio}"/>
                            <input type="hidden" name="nomeConvenio" value="${convenio.nomeConvenio}"/>
                            <input type="hidden" name="cnpj" value="${convenio.cnpj}"/>
                            <input type="hidden" name="telefoneConvenio" value="${convenio.telefoneConvenio}"/>
                            <input type="hidden" name="cobertura" value="${convenio.cobertura}"/>
                            <input type="hidden" name="dataInicioContrato" value="${convenio.dataInicioContrato}"/>
                            <input type="hidden" name="dataFimContrato" value="${convenio.dataFimContrato}"/>
                            <input type="hidden" name="opcao" value="confirmarExcluir"/>
                            <button type="submit">Excluir</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
