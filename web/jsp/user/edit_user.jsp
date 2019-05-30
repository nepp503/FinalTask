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
    <title><fmt:message key="edit.user"/></title>
</head>
<body class="home">
<fmt:setLocale value="${sessionScope.locale}"/>
<c:import url="../header.jsp"/>
<div class="edit-page">
    <div class="greeting">
        <h2><fmt:message key="edit.user"/></h2>
    </div>

    <form class="edit-form" action="${pageContext.request.contextPath}/controller" method="post">
        <input type="hidden" name="command" value="update_user"/>
        <input type="hidden" name="userid" value="${sessionScope.user.id}"/>

        <div class="block">
            <label for="login"><fmt:message key="login"/></label><br>
            <input type="text" required id="login" class="title" name="login"
                   pattern="^([a-zA-Z]+)[a-zA-Z\d_]{4,}$"
                   placeholder="<fmt:message key="login"/>"
                   value="${sessionScope.user.login}"/>
        </div>

        <div class="block">
            <label for="firstname"><fmt:message key="first.name"/></label><br>
            <input type="text" id="firstname" class="title" name="firstname"
                   placeholder="<fmt:message key="first.name"/>"
                   value="${sessionScope.user.firstName}"/>
        </div>

        <div class="block">
            <label for="lastname"><fmt:message key="last.name"/></label><br>
            <input type="text" id="lastname" class="title" name="lastname"
                   placeholder="<fmt:message key="last.name"/>"
                   value="${sessionScope.user.lastName}"/>
        </div>

        <div class="block">
            <label for="email"><fmt:message key="user.email"/></label><br>
            <input type="text" required id="email" class="title" name="email"
                   placeholder="<fmt:message key="user.email"/>"
                   value="${sessionScope.user.email}"/>
        </div>

        <%--        <div class="block">--%>
        <%--            <label for="poster">Poster</label><br/>--%>
        <%--            <input type="text" id="poster" name="poster" value="${requestScope.movie.poster}"/>--%>
        <%--        </div>--%>

        <div class="block">
            <input type="submit" class="edit-btn" value=<fmt:message key="edit"/>>
        </div>
    </form>
</div>
<c:import url="../footer.jsp"/>
</body>
</html>
