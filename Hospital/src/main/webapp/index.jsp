<%-- 
    Document   : index
    Created on : 27 de fev. de 2026, 07:39:47
    Author     : Tulio Dias
--%>
<% // código java

    int idade = 17;


%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <%            
        if (idade >= 18) {
        %>
        <h1>Entrada permitida!</h1>
        <%
        } else {
        %>
        <h1>Entrada não permitida!</h1>
        <%
            }
        %>
    </body>
</html>
