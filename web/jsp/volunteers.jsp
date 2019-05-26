<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Volunteers</title>
    <meta charset="utf-8">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body class="home">
<fmt:setLocale value="${sessionScope.locale}"/>
<c:import url="header.jsp"/>
<section class="section main">
    <div class="section-title">
        <h2><fmt:message key="volunteers"/></h2>
    </div>
    <section class="section-people">
        <ol>
            <c:forEach var="volunteer" items="${requestScope.listvolunteer}">
                <li>
                    <div class="person">
                        <a href="controller?command=show_volunteer_page&volunteerid=${volunteer.id}">
                            <h4 class="title"><c:out value="${volunteer.firstName} ${volunteer.lastName}"/></h4>
                        </a>
                        <div>
                            <a href="#">
                                <img src="${pageContext.request.contextPath}/${volunteer.photo}"
                                     alt="${volunteer.firstName} ${volunteer.lastName}"/>
                            </a>
                        </div>
                    </div>
                </li>
            </c:forEach>
        </ol>
    </section>
</section>
<c:import url="footer.jsp"/>
</body>
</html>
