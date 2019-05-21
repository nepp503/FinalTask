<%@ page isErrorPage="true" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Error</title>
    <meta charset="utf-8">
    <link href="${pageContext.request.contextPath}/css/errorPage.css" rel="stylesheet"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body class="home">
<fmt:setLocale value="${sessionScope.locale}"/>

<c:import url="header.jsp"/>
<section class="section main">

    <div class="section-title">
        <h4><fmt:message key="error.short.msg"/><br/></h4>
    </div>
    <section class="section-people">
        <div class="person">
            <p><fmt:message key="error.long.msg"/></p>
            ${requestScope.errorMessage}<br/>
        </div>
        <a href="${pageContext.request.contextPath}/index.jsp"><fmt:message key="index.page"/></a><br/>
    </section>
</section>
<c:import url="footer.jsp"/>
</body>
</html>
