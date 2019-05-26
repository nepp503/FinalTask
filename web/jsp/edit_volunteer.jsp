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
    <title><fmt:message key="edit.volunteer"/></title>
</head>
<body class="home">
<fmt:setLocale value="${sessionScope.locale}"/>
<c:import url="header.jsp"/>
<div class="edit-page">
    <div class="greeting">
        <h2><fmt:message key="edit.volunteer"/></h2>
    </div>

    <form class="edit-form" action="${pageContext.request.contextPath}/controller" method="post"
          enctype="multipart/form-data">
        <c:choose>
            <c:when test="${empty requestScope.volunteer}">
                <input type="hidden" name="command" value="create_volunteer"/>
            </c:when>
            <c:otherwise>
                <input type="hidden" name="command" value="update_volunteer"/>
                <input type="hidden" name="volunteerid" value="${requestScope.volunteer.id}"/>
            </c:otherwise>
        </c:choose>
        <div class="block">
            <label for="firstname"><fmt:message key="first.name"/></label><br>
            <input type="text" required id="firstname" class="title" name="firstname"
                   value="${requestScope.volunteer.firstName}"/>
        </div>

        <div class="block">
            <label for="lastname"><fmt:message key="last.name"/></label><br>
            <input type="text" required id="lastname" class="title" name="lastname"
                   value="${requestScope.volunteer.lastName}"/>
        </div>

        <div class="block">
            <label for="yearsofwork"><fmt:message key="years.of.work"/></label><br>
            <input type="text" required id="yearsofwork" class="title" name="yearsofwork"
                   value="${requestScope.volunteer.yearsOfWork}"/>
        </div>

        <div class="block">
            <label for="numberofoperations"><fmt:message key="number.of.operations"/></label><br>
            <input type="text" required id="numberofoperations" class="title" name="numberofoperations"
                   value="${requestScope.volunteer.numberOfOperations}"/>
        </div>

        <div class="block">
            <label for="poster">Poster</label><br/>
            <input type="file" id="poster" name="poster" height="200">
        </div>

        <c:choose>
            <c:when test="${empty requestScope.volunteer}">
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

