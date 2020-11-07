<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<c:set var="cxt" value="${pageContext.request.contextPath }" />
</head>
<body>
<h2>Liste des Magasins</h2>
<table border="1">
    <c:forEach items="${liste}" var="m">
     <tr>
      <td>${m.id }</td><td>${m.nom }</td>
     <td><a href="${cxt}/produits/${m.id}">Liste des produits</a></td>
     </tr>
        </c:forEach>
</table>
<p><a href="${cxt}/ajout">Ajouter un Produit</a> </p>
</body>
</html>