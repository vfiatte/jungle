<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<table>
    <tr>
        <td class="cotegauche">
        </td>
        <td class="tablecentre" background ="Images/12972955.jpg">
            <form:form modelAttribute="utilisateur" id="form" method="post">
                <form:hidden path="partie.id"/>
                Nom : <form:input path="nom"/>
                <input type="button" value="Jouer" onclick="rejoindrePost()"/>
            </form:form>
        </td>
        <td class="cotedroit">
        </td>
    </tr>
</table>



