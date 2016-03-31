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
    <body>
        <div>

        </div>

        <table>
            <tr>
                <td class="cotegauche">
                </td>
                <td class="tablecentre" background ="Images/12972955.jpg">
                    <h1>Liste des parties disponibles</h1>
                </td>
                <td class="cotedroit">
                </td>
            </tr>
            <tr>
                <td class="cotegauche">
                </td>
                <td>
                    <table class="tablecentre" background ="Images/12972955.jpg">
                        <tr>
                            <td>
                                Partie numero
                            </td>
                            <td>
                                Rejoindre
                            </td>
                        </tr>
                        <c:forEach items="${mesParties}" var="maPartie">
                            <tr>
                                <td>
                                    ${maPartie.id}
                                </td>
                                <td>
                                    <input type="button" onclick="rejoindre(${maPartie.id})" value="Rejoindre"/>
                                </td>
                            </tr>
                            <tr>
                                

                                    <td>
                                        <c:forEach items="${maPartie.utilisateurs}" var="utilisateur">
                                        ${utilisateur.nom} / 
                                        </c:forEach>
                                    </td>

                                
                            </tr>
                        </c:forEach>
                </td>
                <td class="cotedroit">
                </td>
            </tr>
        </table>
    </table>
</body>
</html>
