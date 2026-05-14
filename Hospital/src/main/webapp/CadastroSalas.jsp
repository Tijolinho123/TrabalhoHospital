<%-- 
    Document   : CadastroSalas
    Author     : Tulio Dias
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Salas</title>
    </head>

    <%@include file="menu.jsp" %>
    <body>
        <h1>Cadastro Salas</h1>
        <form name="cadastro" method="get" action="${pageContext.request.contextPath}${URL_BASE}/SalasControlador">
            <input type="hidden" name="opcao" value="${opcao}"/>
            <input type="hidden" name="codigoSala" value="${codigoSala}"/>
            <p><label>Nome da Sala: </label><input type="text" name="nomeSala" value="${nomeSala}" size="40"></p>
            <p><label>Setor: </label><input type="text" name="setor" value="${setor}" size="40"></p>
            <input type="submit" value="Salvar" name="Salvar" style="float:left; margin-right: 3px">
        </form>
        <form id="cadastroForm" name="cadastro" method="get" action="${pageContext.request.contextPath}${URL_BASE}/SalasControlador">
            <input type="submit" value="Cancelar" name="btnCancelar">
            <input type="hidden" name="opcao" value="cancelar">
        </form>
        <h2>${mensagem}</h2>

        <table border="1">
            <c:if test="${not empty listaSalas}">
                <tr><th>CÓDIGO</th><th>NOME</th><th>SETOR</th><th>ALTERAR</th><th>EXCLUIR</th></tr>
            </c:if>
            <c:forEach var="sala" items="${listaSalas}">
                <tr>
                    <td>${sala.codSala}</td>
                    <td>${sala.nomeSala}</td>
                    <td>${sala.setor}</td>
                    <td>
                        <form name="cadastro" method="get" action="${pageContext.request.contextPath}${URL_BASE}/SalasControlador">
                            <input type="hidden" name="codigoSala" value="${sala.codSala}"/>
                            <input type="hidden" name="nomeSala" value="${sala.nomeSala}"/>
                            <input type="hidden" name="setor" value="${sala.setor}"/>
                            <input type="hidden" name="opcao" value="confirmarAlterar"/>
                            <button type="submit">Alterar</button>
                        </form>
                    </td>
                    <td>
                        <form name="cadastro" method="get" action="${pageContext.request.contextPath}${URL_BASE}/SalasControlador">
                            <input type="hidden" name="codigoSala" value="${sala.codSala}"/>
                            <input type="hidden" name="nomeSala" value="${sala.nomeSala}"/>
                            <input type="hidden" name="setor" value="${sala.setor}"/>
                            <input type="hidden" name="opcao" value="confirmarExcluir"/>
                            <button type="submit">Excluir</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
