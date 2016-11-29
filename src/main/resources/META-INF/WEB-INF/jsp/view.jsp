<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Json Reader</title>
</head>
<body>
<form action="">
    <input type="text" placeholder="Nom de la série" name="nomRecherche"></input> <br> <select name="genreRecherche">
    <option value="">Genre</option>
    <c:forEach items="${genres}" var="g">
        <option value="${g}">${g}</option>
    </c:forEach>
</select> <br> <input type="text" placeholder="Nom d'un acteur" name="acteurRecherche"></input> <br>
    <input type="checkbox" name="triAlphabetique"></input><label>Tri par ordre alphabetique</label> <br> <input type="checkbox" name="triNote"></input><label>Tri par note</label> <br> <input type="submit"></input>
</form>

<c:choose>
    <c:when test="${not empty resultats}">
        <table>
            <tbody>
            <c:forEach items="${resultats}" var="resultat">
                <tr>
                    <td>${resultat.seriesName}</td>
                    <td>${resultat.siteRating}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:when>
    <c:otherwise>
        Pas de résultat
    </c:otherwise>
</c:choose>
</body>
</html>