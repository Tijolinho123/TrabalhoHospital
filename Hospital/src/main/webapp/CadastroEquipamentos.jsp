<%-- 
    Document   : CadastroEquipamentos
    Author     : Tulio Dias
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Equipamentos</title>
    </head>

    <%@include file="menu.jsp" %>
    <body>
        <h1>Cadastro Equipamentos</h1>
        <form name="cadastro" method="get" action="${pageContext.request.contextPath}${URL_BASE}/EquipamentosControlador">
            <input type="hidden" name="opcao" value="${opcao}"/>
            <input type="hidden" name="codigoEquipamentos" value="${codigoEquipamentos}"/>
            <p><label>Nome: </label><input type="text" name="nomeEquipamentos" value="${nomeEquipamentos}" size="40"></p>
            <input type="submit" value="Salvar" name="Salvar" style="float:left; margin-right: 3px">
        </form>
        <form id="cadastroForm" name="cadastro" method="get" action="${pageContext.request.contextPath}${URL_BASE}/EquipamentosControlador">
            <input type="submit" value="Cancelar" name="btnCancelar">
            <input type="hidden" name="opcao" value="cancelar">
        </form>
        <h2>${mensagem}</h2>

        <table border="1">
            <c:if test="${not empty listaEquipamentos}">
                <tr><th>CÓDIGO</th><th>NOME</th><th>ALTERAR</th><th>EXCLUIR</th></tr>
            </c:if>
            <c:forEach var="equipamento" items="${listaEquipamentos}">
                <tr>
                    <td>${equipamento.codEquipamentos}</td>
                    <td>${equipamento.nomeEquipamentos}</td>
                    <td>
                        <form name="cadastro" method="get" action="${pageContext.request.contextPath}${URL_BASE}/EquipamentosControlador">
                            <input type="hidden" name="codigoEquipamentos" value="${equipamento.codEquipamentos}"/>
                            <input type="hidden" name="nomeEquipamentos" value="${equipamento.nomeEquipamentos}"/>
                            <input type="hidden" name="opcao" value="confirmarAlterar"/>
                            <button type="submit">Alterar</button>
                        </form>
                    </td>
                    <td>
                        <form name="cadastro" method="get" action="${pageContext.request.contextPath}${URL_BASE}/EquipamentosControlador">
                            <input type="hidden" name="codigoEquipamentos" value="${equipamento.codEquipamentos}"/>
                            <input type="hidden" name="nomeEquipamentos" value="${equipamento.nomeEquipamentos}"/>
                            <input type="hidden" name="opcao" value="confirmarExcluir"/>
                            <button type="submit">Excluir</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
