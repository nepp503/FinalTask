<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
 <jsp:useBean id="searchedperson" scope="request" class="com.siniak.finaltask.entity.SearchedPerson"/>
<head>
    <title>${searchedperson.firstName} ${searchedperson.lastName}</title>
    <meta charset="utf-8">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/css/personPage.css" rel="stylesheet"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/updateReview.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body class="home">
<fmt:setLocale value="${sessionScope.locale}"/>
<jsp:useBean id="user" class="com.siniak.finaltask.entity.User" scope="session"/>

<c:import url="header.jsp"/>
<section class="section main">

    <div class="section-title">
        <h2>${searchedperson.firstName} ${searchedperson.lastName}
            <c:set var="admin" value="ADMIN"/>
            <c:if test="${user.userType == admin}">
                <button class="edit-by-admin-btn">
                    <a href="controller?command=edit_person&personid=${searchedperson.id}">
                    <i class="fa fa-pencil-square-o" aria-hidden="true"></i></a>
                </button>
                <button class="delete-person-btn">
                    <a href="controller?command=delete_person&personid=${searchedperson.id}">
                        <i class="fa fa-trash-o" aria-hidden="true"></i></a>
                </button>
            </c:if>
        </h2>
    </div>


    <section class="section-people">
        <div class="person">
            <div class="poster">
                <a href="#">
                    <img src="${pageContext.request.contextPath}/${searchedperson.photo}"
                         alt="${searchedperson.firstName} ${searchedperson.lastName}"/>
                </a>
            </div>

            <c:if test="${not empty searchedperson.birthPlace}">
                <p><strong><fmt:message key="special.signs"/>: </strong>${searchedperson.birthPlace}</p>
            </c:if>

            <c:if test="${not empty searchedperson.specialSigns}">
                <p><strong><fmt:message key="special.signs"/>: </strong>${searchedperson.specialSigns}</p>
            </c:if>

            <c:if test="${not empty searchedperson.searchArea}">
                <p><strong><fmt:message key="search.area"/>: </strong>${searchedperson.searchArea}</p>
            </c:if>

            <c:set var="addedResponse" value="false"/>

            <c:if test="${not empty requestScope.responses}">
                <c:set var="helpResponses" value="${requestScope.responses}"/>
                <p><strong><fmt:message key="responses"/> : </strong></p>
                <c:forEach var="response" items="${helpResponses}">
                    <c:choose>
                        <c:when test="${user.id == response.userId}">
                            <div class="review">
                                <h4><a href="controller?command=show_user_page&userid=${response.userId}"><c:out
                                        value="${response.userLogin}"/></a></h4>

                                <div class="btn-row">
                                    <div class="btn">
                                        <button class="edit-btn" id="${response.id}"><i class="fa fa-pencil-square-o"
                                                                                        aria-hidden="true"></i></button>
                                    </div>

                                    <form action="controller" method="post" class="delete-review-form">
                                        <input type="hidden" name="command" value="delete_help_response"/>
                                        <input type="hidden" name="responseid" value="${response.id}"/>
                                        <div class="btn">
                                            <button class="delete-btn"><i class="fa fa-trash-o" aria-hidden="true"></i>
                                            </button>
                                        </div>
                                    </form>

                                    <form action="controller" method="post" id="edit-review-form-${response.id}">
                                        <input type="hidden" name="responseid" value="${response.id}"/>
                                        <input type="hidden" name="command" value="update_help_response"/>
                                        <input type="hidden" name="review"/>

                                        <div class="btn">
                                            <button class="save-btn" name="save-btn" id="save-${response.id}"><i
                                                    class="icon-save"></i>
                                            </button>
                                        </div>

                                    </form>
                                    <c:set var="addedResponse" value="true"/>
                                </div>
                                <h3 id="title-${response.id}" class="review-title"><c:out value="${response.title}"/></h3>
                                <p id="body-${response.id}" class="review-body"><c:out value="${response.body}"/></p>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div class="review">
                                <h4><c:out value="${response.userLogin}"/></h4>
                                <h3 id="title-${response.id}" class="review-title"><c:out value="${response.title}"/></h3>
                                <p id="body-${response.id}" class="review-body"><c:out value="${response.body}"/></p>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </c:if>

            <c:if test="${user.id != 0 and not addedReview}">
                <form action="controller" method="post">
                    <input type="hidden" name="command" value="create_help_response"/>
                    <input type="hidden" name="userid" value="${user.id}"/>
                    <input type="hidden" name="personid" value="${searchedperson.id}"/>
                    <input type="hidden" name="userlogin" value="${user.login}"/>
                    <input type="text" required name="title" class="review-title-input"
                           placeholder="<fmt:message key="response.title"/>"/>
                    <textarea required cols="60" rows="5" name="body" class="review-body-input"
                              placeholder="<fmt:message key="response.body"/> "></textarea>
                    <input type="submit" class="leave-review-btn" value="<fmt:message key="leave.response"/> ">
                </form>
            </c:if>

        </div>
    </section>
</section>
<c:import url="footer.jsp"/>
</body>
</html>
