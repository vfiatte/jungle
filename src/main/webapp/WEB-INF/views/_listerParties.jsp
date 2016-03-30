<%-- 
    Document   : listerParties
    Created on : 30 mars 2016, 14:04:31
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body class="tablecentre">
        <h1>Parties en cours</h1>
        <table class="tablecentre">
            <thead>
                <tr>
                    <td>
                        Partie numero
                    </td>
                    <td>
                        Rejoindre
                    </td>
                </tr>
            </thead>
            <c:forEach items="${mesParties}" var="maPartie">
                <tr>
                    <td colspan="2">
                        ${maPartie.id}
                    </td>
                    <td>
                        <input type="button" onclick="rejoindre(${maPartie.id})" value="Rejoindre"/>
                    </td>
                </tr>
                <tr>
                    <td>

                    </td>
                    <c:forEach items="${maPartie.utilisateurs}" var="utilisateur">
                        <td>
                            ${utilisateur.nom},
                        </td>
                    </c:forEach>

                </tr>
            </c:forEach>
        </table>

    </body>
</html>
