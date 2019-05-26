<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<jsp:useBean id="user" scope="session" class="com.siniak.finaltask.entity.User"/>
<head>
    <title>${user.login}</title>
    <meta charset="utf-8">
    <link href="${pageContext.request.contextPath}/css/personPage.css" rel="stylesheet"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
</head>
<body class="home">
<fmt:setLocale value="${sessionScope.locale}"/>

<c:import url="header.jsp"/>
<section class="section main">
    <div class="section-title">
        <h2>${user.login}</h2>
    </div>
    <section class="section-people">
        <div class="movie">
            <c:set var="admin" value="ADMIN"/>
            <c:if test="${user.userType == admin}">
                <h3><a href="controller?command=edit_person"><fmt:message key="add.person"/></a></h3>
                <h3><a href="controller?command=edit_volunteer"><fmt:message key="add.volunteer"/></a></h3>
            </c:if>
            <button class="edit-by-admin-btn"><a href="controller?command=edit_user&userid=${user.id}">
                <i class="fa fa-pencil-square-o" aria-hidden="true"></i></a></button>

            <c:if test="${not empty user.firstName}">
                <p><strong><fmt:message key="first.name"/>: </strong>${user.firstName}</p>
            </c:if>

            <c:if test="${not empty user.lastName}">
                <p><strong><fmt:message key="last.name"/>: </strong>${user.lastName}</p>
            </c:if>

            <c:if test="${not empty user.email}">
                <p><strong><fmt:message key="user.email"/>: </strong>${user.email}</p>
            </c:if>

            <c:if test="${not empty requestScope.responses}">
                <c:set var="helpResponses" value="${requestScope.responses}"/>
                <p><strong><fmt:message key="responses"/> : </strong></p>
                <c:forEach var="response" items="${helpResponses}">
                    <div class="review" style="background: #d0cecd">
                        <h4><a href="controller?command=show_person_page&personid=${response.searchedPersonId}">
                            <fmt:message key="show.person"/></a></h4>
                        <h3 class="review-title"><c:out value="${response.title}"/></h3>
                        <p class="review-body"><c:out value="${response.body}"/></p>
                    </div>
                </c:forEach>
            </c:if>
    </section>
</section>
<c:import url="footer.jsp"/>
</body>
</html>
