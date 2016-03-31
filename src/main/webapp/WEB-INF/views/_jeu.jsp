

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<font color="red">Partie numero : ${maPartie.id} <br> Joueur en cours : ${joueur.nom}</font>
<table>
    <tr>
        <c:forEach items="${maPartie.utilisateurs}" var="utilisateur">
        <tr>
            <td width="300px" background ="Images/12972955.jpg">
                ${utilisateur.nom}
            </td>
        </tr>
        </c:forEach>
        <td width="50px" background ="Images/12972955.jpg">
            ${nbCartesi} cartes
        </td>


        <td width="50px" background ="Images/12972955.jpg">
            ${nbCartesj} cartes
        </td>
        <c:forEach items="${carteJ}" var="carte">
            <tr>
                <!--                <td width="300px" height="300px">
                
                                </td>-->
            </tr>

        
    </c:forEach>
</tr>
</table>
