<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Welcome</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">



    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a>
        </h2>

        <c:forEach  items="${resourceList}" var="res">
            <tr>
                <td>${res.id}</td>
                <td><a href="/resources/${res.id}">${res.name}</a></td>
                <td>${res.content}</td>
                <td>${res.users}</td>
            </tr>
            <br>
        </c:forEach>

        <br>

        <%--<form id="addquestion" method="post" action="/addques" enctype="application/json">--%>
            <%--<p>Question<input type="text" name="question"><br></p>--%>

            <%--Add resource:<br>--%>
            <%--<input type="text" name="addResource">--%>
            <%--<select name="ansSet[0][isRightOption]">--%>
                <%--<option value="true">true</option>--%>
                <%--<option value="false">false</option>--%>
            <%--</select>--%>
            <%--<input type="submit" name="submitform">--%>

        <%--</form>--%>


        <%--<form id="addResource" method="POST" action="${pageContext.request.contextPath}/resources" class="form-signin">--%>
            <%--<h2 class="form-heading">Log in</h2>--%>

            <%--<div class="form-group ">--%>
                <%--<input name="id" type="text" class="form-control" placeholder="Id"--%>
                       <%--autofocus="true"/>--%>
                <%--<input name="name" type="text" class="form-control" placeholder="Name"/>--%>
                <%--<input name="content" type="text" class="form-control" placeholder="Content"/>--%>
                <%--&lt;%&ndash;<span>${error}</span>&ndash;%&gt;--%>
                <%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>

                <%--<button class="btn btn-lg btn-primary btn-block" type="submit">Add Resource</button>--%>
            <%--</div>--%>



        </form>

    </c:if>

</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
<%--<script src="${contextPath}/resources/js/addResourceListener.js"></script>--%>
</body>
</html>