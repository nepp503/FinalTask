<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Registration</title>
    <meta charset="UTF-8">
    <link href="${pageContext.request.contextPath}/css/registrationStyle.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet"/>
    <script src="${pageContext.request.contextPath}/js/validation.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body class="home">
<fmt:setLocale value="${sessionScope.locale}"/>
<header class="main-header">
    <nav class="site-nav">
        <ul class="site-links">
            <li>
                <a href="${pageContext.request.contextPath}/index.jsp" class="site-name">SearchingService</a>
            </li>
            <li>
                <form action="${pageContext.request.contextPath}/controller" method="post">
                    <input type="hidden" name="command" value="login">
                    <input type="text" class="login text-input" name="login"
                           placeholder="<fmt:message key="username"/>" pattern="^([a-zA-Z]+)[a-zA-Z\d_]{4,}$"
                           title="<fmt:message key="login.requirements"/>"
                           required/>
                    <input type="password" class="password text-input" name="password"
                           placeholder="<fmt:message key="user.password"/>"
                           pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{6,}$"
                           title="<fmt:message key="password.requirements"/>"
                           required/>

                    <input type="submit" class="sign-up-btn find-btn" value=
                            "<fmt:message key="login.btn"/>">
                </form>
            </li>
        </ul>
    </nav>
</header>
<div class="registration-page">
    <div class="greeting">
        <h2><fmt:message key="registration.greeting.part1"/></h2>
        <p><fmt:message key="registration.greeting.part2"/></p>
    </div>

    <form action="${pageContext.request.contextPath}/controller" method="post" class="registration-form">
        <input type="hidden" name="command" value="sign_up">
        <div class="field required">
            <input type="text" class="login" name="login"
                   placeholder="<fmt:message key="username"/>"
                   pattern="^([a-zA-Z]+)[a-zA-Z\d_]{4,}$"
                   title="<fmt:message key="login.requirements"/>"
                   required/>
        </div>
        <div class="field required">
            <input type="password" id="password" class="password" name="password"
                   placeholder="<fmt:message key="user.password"/>"
                   pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{6,}$"
                   title="<fmt:message key="password.requirements"/>"
                   required/>
        </div>
        <div class="field required">
            <input type="password" id="confirm-password" class="confirm-password"
                   placeholder="<fmt:message key="confirm.password"/>"
                   required/>
        </div>

        <div class="field required email-container">
            <input type="email" class="email" name="email"
                   title="<fmt:message key="email.requirements"/>"
                   placeholder="Email" required/>
        </div>

        <div class="field optional">
            <input type="text" class="first-name" name="firstname"
                   placeholder="<fmt:message key="first.name"/>">
        </div>

        <div class="field optional">
            <input type="text" class="last-name" name="lastname"
                   placeholder="<fmt:message key="last.name"/>">
        </div>

        <input type="submit" value="<fmt:message key="signup.btn"/>">
    </form>
    <a href="${requestScope.previous_page}"><fmt:message key="back"/></a>
</div>
<c:import url="footer.jsp"/>
</body>
</html>
