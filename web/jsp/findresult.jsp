<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>People</title>
    <meta charset="utf-8">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body class="home">
<fmt:setLocale value="${sessionScope.locale}"/>
<c:import url="header.jsp"/>
<section class="section main">
    <div class="section-title">
        <h2>
            <c:choose>
                <c:when test="${not empty requestScope.findlist}">
                    <fmt:message key="result.prefix"/> "${requestScope.searchName}":
                </c:when>
                <c:otherwise>
                    <fmt:message key="result.null"/>
                </c:otherwise>
            </c:choose>
        </h2>
    </div>
    <section class="section-people">
        <c:forEach var="person" items="${requestScope.findlist}">
            <ul>
                <li>
                    <div class="person">
                        <a href="controller?command=show_person_page&personid=${person.id}">
                            <h4 class="title"><c:out value="${person.firstName} ${person.lastName}"/></h4>
                        </a>

                        <div class="poster">
                            <a href="#">
                                <img src="${pageContext.request.contextPath}/${person.photo}"
                                     alt="${person.firstName} ${person.lastName}"/>
                            </a>
                        </div>

                        <p class="description"><c:out value="${person.searchArea}"/></p>
                    </div>
                </li>
            </ul>
        </c:forEach>
    </section>
</section>
<c:import url="footer.jsp"/>
</body>
</html>
