<%-- 
    Document   : CadastroTipoPaciente
    Author     : Tulio Dias
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Tipo de Paciente</title>
    </head>

    <%@include file="menu.jsp" %>
    <body>
        <h1>Cadastro Tipo de Paciente</h1>
        <form name="cadastro" method="get" action="${pageContext.request.contextPath}${URL_BASE}/TipoPacienteControlador">
            <input type="hidden" name="opcao" value="${opcao}"/>
            <input type="hidden" name="codigoTipoPaciente" value="${codigoTipoPaciente}"/>
            <p><label>Nome: </label><input type="text" name="nomeTipoPaciente" value="${nomeTipoPaciente}" size="40"></p>
            <input type="submit" value="Salvar" name="Salvar" style="float:left; margin-right: 3px">
        </form>
        <form id="cadastroForm" name="cadastro" method="get" action="${pageContext.request.contextPath}${URL_BASE}/TipoPacienteControlador">
            <input type="submit" value="Cancelar" name="btnCancelar">
            <input type="hidden" name="opcao" value="cancelar">
        </form>
        <h2>${mensagem}</h2>

        <table border="1">
            <c:if test="${not empty listaTipoPaciente}">
                <tr><th>CÓDIGO</th><th>NOME</th><th>ALTERAR</th><th>EXCLUIR</th></tr>
            </c:if>
            <c:forEach var="tipoPaciente" items="${listaTipoPaciente}">
                <tr>
                    <td>${tipoPaciente.codPaciente}</td>
                    <td>${tipoPaciente.nomeTipoPaciente}</td>
                    <td>
                        <form name="cadastro" method="get" action="${pageContext.request.contextPath}${URL_BASE}/TipoPacienteControlador">
                            <input type="hidden" name="codigoTipoPaciente" value="${tipoPaciente.codPaciente}"/>
                            <input type="hidden" name="nomeTipoPaciente" value="${tipoPaciente.nomeTipoPaciente}"/>
                            <input type="hidden" name="opcao" value="confirmarAlterar"/>
                            <button type="submit">Alterar</button>
                        </form>
                    </td>
                    <td>
                        <form name="cadastro" method="get" action="${pageContext.request.contextPath}${URL_BASE}/TipoPacienteControlador">
                            <input type="hidden" name="codigoTipoPaciente" value="${tipoPaciente.codPaciente}"/>
                            <input type="hidden" name="nomeTipoPaciente" value="${tipoPaciente.nomeTipoPaciente}"/>
                            <input type="hidden" name="opcao" value="confirmarExcluir"/>
                            <button type="submit">Excluir</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
