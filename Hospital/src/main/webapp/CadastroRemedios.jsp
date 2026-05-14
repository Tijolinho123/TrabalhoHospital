<%-- 
    Document   : CadastroRemedios
    Author     : Tulio Dias
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Remédios</title>
    </head>

    <%@include file="menu.jsp" %>
    <body>
        <h1>Cadastro Remédios</h1>
        <form name="cadastro" method="get" action="${pageContext.request.contextPath}${URL_BASE}/RemediosControlador">
            <input type="hidden" name="opcao" value="${opcao}"/>
            <input type="hidden" name="codigoRemedio" value="${codigoRemedio}"/>
            <p><label>Nome: </label><input type="text" name="nomeRemedio" value="${nomeRemedio}" size="40"></p>
            <p><label>Laboratório: </label><input type="text" name="laboratorio" value="${laboratorio}" size="40"></p>
            <p><label>Efeitos Colaterais: </label><input type="text" name="efeitosColaterais" value="${efeitosColaterais}" size="60"></p>
            <input type="submit" value="Salvar" name="Salvar" style="float:left; margin-right: 3px">
        </form>
        <form id="cadastroForm" name="cadastro" method="get" action="${pageContext.request.contextPath}${URL_BASE}/RemediosControlador">
            <input type="submit" value="Cancelar" name="btnCancelar">
            <input type="hidden" name="opcao" value="cancelar">
        </form>
        <h2>${mensagem}</h2>

        <table border="1">
            <c:if test="${not empty listaRemedios}">
                <tr><th>CÓDIGO</th><th>NOME</th><th>LABORATÓRIO</th><th>EFEITOS COLATERAIS</th><th>ALTERAR</th><th>EXCLUIR</th></tr>
            </c:if>
            <c:forEach var="remedio" items="${listaRemedios}">
                <tr>
                    <td>${remedio.codRemedio}</td>
                    <td>${remedio.nomeRemedio}</td>
                    <td>${remedio.laboratorio}</td>
                    <td>${remedio.efeitosColaterais}</td>
                    <td>
                        <form name="cadastro" method="get" action="${pageContext.request.contextPath}${URL_BASE}/RemediosControlador">
                            <input type="hidden" name="codigoRemedio" value="${remedio.codRemedio}"/>
                            <input type="hidden" name="nomeRemedio" value="${remedio.nomeRemedio}"/>
                            <input type="hidden" name="laboratorio" value="${remedio.laboratorio}"/>
                            <input type="hidden" name="efeitosColaterais" value="${remedio.efeitosColaterais}"/>
                            <input type="hidden" name="opcao" value="confirmarAlterar"/>
                            <button type="submit">Alterar</button>
                        </form>
                    </td>
                    <td>
                        <form name="cadastro" method="get" action="${pageContext.request.contextPath}${URL_BASE}/RemediosControlador">
                            <input type="hidden" name="codigoRemedio" value="${remedio.codRemedio}"/>
                            <input type="hidden" name="nomeRemedio" value="${remedio.nomeRemedio}"/>
                            <input type="hidden" name="laboratorio" value="${remedio.laboratorio}"/>
                            <input type="hidden" name="efeitosColaterais" value="${remedio.efeitosColaterais}"/>
                            <input type="hidden" name="opcao" value="confirmarExcluir"/>
                            <button type="submit">Excluir</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
