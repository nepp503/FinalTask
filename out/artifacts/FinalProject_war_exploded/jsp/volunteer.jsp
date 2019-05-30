<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--<%@ taglib prefix="ctg" uri="customtags" %>--%>
<!DOCTYPE html>
<html>
    <c:choose>
        <c:when test="${not empty requestScope.volunteer}">
            <c:set value="${requestScope.volunteer}" var="volunteer"/>
        </c:when>
        <c:otherwise>
            <c:set value="${sessionScope.volunteer}" var="volunteer"/>
        </c:otherwise>
    </c:choose>
<head>
    <title>${volunteer.firstName} ${volunteer.lastName}</title>
    <meta charset="utf-8">
    <link href="${pageContext.request.contextPath}/css/personPage.css" rel="stylesheet"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body class="home">
<fmt:setLocale value="${sessionScope.locale}"/>
<jsp:useBean id="user" class="com.siniak.finaltask.entity.User" scope="session"/>

<c:import url="header.jsp"/>
<section class="section main">

    <div class="section-title">
        <h2>${volunteer.firstName} ${volunteer.lastName}
            <c:set var="admin" value="ADMIN"/>
            <c:if test="${user.userType == admin}">
                <button class="edit-by-admin-btn"><a
                        href="controller?command=edit_volunteer&volunteerid=${volunteer.id}"><i
                        class="fa fa-pencil-square-o"
                        aria-hidden="true"></i></a></button>
                <button class="delete-person-btn">
                    <a href="controller?command=delete_volunteer&volunteerid=${volunteer.id}">
                        <i class="fa fa-trash-o" aria-hidden="true"></i></a>
                </button>
            </c:if>
        </h2>
    </div>


    <section class="section-people">
        <div class="person">
            <div class="poster">
                <a href="#">
                    <img src="${pageContext.request.contextPath}/${volunteer.photo}"
                         alt="${volunteer.firstName} ${volunteer.lastName}"/>
                </a>
            </div>
            <c:if test="${not empty volunteer.yearsOfWork}">
                <p><strong><fmt:message key="years.of.work"/>: </strong>${volunteer.yearsOfWork}</p>
            </c:if>

            <c:if test="${not empty volunteer.numberOfOperations}">
                <p><strong><fmt:message key="number.of.operations"/>: </strong>${volunteer.numberOfOperations}</p>
            </c:if>

        </div>
    </section>
</section>
<c:import url="footer.jsp"/>
</body>
</html>
