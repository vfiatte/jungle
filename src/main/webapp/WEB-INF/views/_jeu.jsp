

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<font color="red">Partie numero : ${maPartie.id} <br> Joueur en cours : ${joueur.nom}</font>
<table>


    <tr>
        <c:forEach items="${maPartie.utilisateurs}" var="utilisateur">
            <td width="300px" background ="Images/12972955.jpg">
                ${utilisateur.nom}
            </td>
        </c:forEach>
    </tr>
    <tr>
        <td width="300px" height="300px" bgcolor ="${couleur1}">

        </td>

        <td width="300px" height="300px" bgcolor ="${couleur2}">

        </td>
    </tr> 



</table>
