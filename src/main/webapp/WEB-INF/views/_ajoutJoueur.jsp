<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<form:form modelAttribute="utilisateur" id="form" method="post">
    <form:hidden path="partie.id"/>
    Nom : <form:input path="nom"/>
    <input type="button" value="Jouer" onclick="rejoindrePost()"/>
</form:form>
<input type="button" onclick ="init()" value="Home"/>

