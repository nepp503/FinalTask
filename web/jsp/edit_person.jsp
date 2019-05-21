<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="${pageContext.request.contextPath}/css/editPage.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <title><fmt:message key="edit.person"/></title>
</head>
<body class="home">
<fmt:setLocale value="${sessionScope.locale}"/>
<c:import url="header.jsp"/>
<div class="edit-page">
    <div class="greeting">
        <h2><fmt:message key="edit.person"/></h2>
    </div>

    <form class="edit-form" action="${pageContext.request.contextPath}/controller" method="post">
        <c:choose>
            <c:when test="${empty requestScope.searchedperson}">
                <input type="hidden" name="command" value="create_searched_person"/>
            </c:when>
            <c:otherwise>
                <input type="hidden" name="command" value="update_searched_person"/>
                <input type="hidden" name="personid" value="${requestScope.searchedperson.id}"/>
            </c:otherwise>
        </c:choose>
        <div class="block">
            <label for="firstname"><fmt:message key="first.name"/></label><br>
            <input type="text" required id="firstname" class="title" name="firstname"
                   value="${requestScope.searchedperson.firstName}"/>
        </div>

        <div class="block">
            <label for="lastname"><fmt:message key="last.name"/></label><br>
            <input type="text" required id="lastname" class="title" name="lastname"
                   value="${requestScope.searchedperson.lastName}"/>
        </div>

        <div class="block">
            <label for="birthplace"><fmt:message key="birth.place"/></label><br>
            <input type="text" required id="birthplace" class="title" name="birthplace"
                   value="${requestScope.searchedperson.birthPlace}"/>
        </div>

        <div class="block">
            <label for="searcharea"><fmt:message key="search.area"/></label><br>
            <input type="text" required id="searcharea" class="title" name="searcharea"
                   value="${requestScope.searchedperson.searchArea}"/>
        </div>

        <div class="block">
            <label for="specialsigns"><fmt:message key="special.signs"/></label><br>
            <input type="text" required id="specialsigns" class="title" name="specialsigns"
                   value="${requestScope.searchedperson.specialSigns}"/>
        </div>

<%--        <div class="block">--%>
<%--            <label for="poster">Poster</label><br/>--%>
<%--            <input type="text" id="poster" name="poster" value="${requestScope.movie.poster}"/>--%>
<%--        </div>--%>
        <c:choose>
            <c:when test="${empty requestScope.searchedperson}">
                <div class="block">
                    <input type="submit" class="edit-btn" value=<fmt:message key="create"/>>
                </div>
            </c:when>
            <c:otherwise>
                <div class="block">
                    <input type="submit" class="edit-btn" value=<fmt:message key="edit"/>>
                </div>
            </c:otherwise>
        </c:choose>
    </form>
</div>
<c:import url="footer.jsp"/>
</body>
</html>
