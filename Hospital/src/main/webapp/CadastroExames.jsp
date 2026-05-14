<%-- 
    Document   : CadastroExames
    Author     : Tulio Dias
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Exames</title>
    </head>

    <%@include file="menu.jsp" %>
    <body>
        <h1>Cadastro Exames</h1>
        <form name="cadastro" method="get" action="${pageContext.request.contextPath}${URL_BASE}/ExamesControlador">
            <input type="hidden" name="opcao" value="${opcao}"/>
            <input type="hidden" name="codigoExame" value="${codigoExame}"/>
            <p><label>Nome: </label><input type="text" name="nomeExame" value="${nomeExame}" size="40"></p>
            <p><label>Descrição: </label><input type="text" name="descricao" value="${descricao}" size="60"></p>
            <p><label>Valor: </label><input type="text" name="valor" value="${valor}" size="15"></p>
            <p><label>Preparo: </label><input type="text" name="preparo" value="${preparo}" size="60"></p>
            <input type="submit" value="Salvar" name="Salvar" style="float:left; margin-right: 3px">
        </form>
        <form id="cadastroForm" name="cadastro" method="get" action="${pageContext.request.contextPath}${URL_BASE}/ExamesControlador">
            <input type="submit" value="Cancelar" name="btnCancelar">
            <input type="hidden" name="opcao" value="cancelar">
        </form>
        <h2>${mensagem}</h2>

        <table border="1">
            <c:if test="${not empty listaExames}">
                <tr><th>CÓDIGO</th><th>NOME</th><th>DESCRIÇÃO</th><th>VALOR</th><th>PREPARO</th><th>ALTERAR</th><th>EXCLUIR</th></tr>
            </c:if>
            <c:forEach var="exame" items="${listaExames}">
                <tr>
                    <td>${exame.codExame}</td>
                    <td>${exame.nomeExame}</td>
                    <td>${exame.descricao}</td>
                    <td>${exame.valor}</td>
                    <td>${exame.preparo}</td>
                    <td>
                        <form name="cadastro" method="get" action="${pageContext.request.contextPath}${URL_BASE}/ExamesControlador">
                            <input type="hidden" name="codigoExame" value="${exame.codExame}"/>
                            <input type="hidden" name="nomeExame" value="${exame.nomeExame}"/>
                            <input type="hidden" name="descricao" value="${exame.descricao}"/>
                            <input type="hidden" name="valor" value="${exame.valor}"/>
                            <input type="hidden" name="preparo" value="${exame.preparo}"/>
                            <input type="hidden" name="opcao" value="confirmarAlterar"/>
                            <button type="submit">Alterar</button>
                        </form>
                    </td>
                    <td>
                        <form name="cadastro" method="get" action="${pageContext.request.contextPath}${URL_BASE}/ExamesControlador">
                            <input type="hidden" name="codigoExame" value="${exame.codExame}"/>
                            <input type="hidden" name="nomeExame" value="${exame.nomeExame}"/>
                            <input type="hidden" name="descricao" value="${exame.descricao}"/>
                            <input type="hidden" name="valor" value="${exame.valor}"/>
                            <input type="hidden" name="preparo" value="${exame.preparo}"/>
                            <input type="hidden" name="opcao" value="confirmarExcluir"/>
                            <button type="submit">Excluir</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
