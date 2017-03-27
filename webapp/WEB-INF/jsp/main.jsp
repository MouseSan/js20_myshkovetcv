<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Spring MVC application</title>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="bootstrap/js/bootstrap.min.js"></script>

</head>
<body>



<p>
    Goods.
</p>

<%--<form action="/editBook/find" method="GET">--%>
    <%--Book Name: <input type="text" name="name" >--%>
    <%--<br />--%>
<%--</form>--%>

<table style="border: 1px solid black;" cellpadding="6" cellspacing="0">
    <tr valign="baseline" bgcolor="#404060">
        <th align="center"> ID</th>
        <th align="left"> Name</th>
        <th align="center"> VIEW</th>
        <th align="right"> EDIT</th>
    </tr>

    <c:forEach var="item" items="${goods}" varStatus="lineInfo">

        <c:choose>
            <c:when test="${lineInfo.count % 2 == 0}"> <tr bgcolor="#f7f7e7"> </c:when>
            <c:otherwise> <tr bgcolor="white"> </c:otherwise>
        </c:choose>

        <td align="center"> ${item.id} </td>
        <td align="left"> ${item.name} </td>
        <%--<td align="left"><a href="/books/${item.id}">view</a></td>--%>
        <%--<sec:authorize access="hasRole('ROLE_ADMIN')">--%>
            <%--<td align="left"><a href="/editBook/${book.id}">edit</a></td>--%>
        <%--</sec:authorize>--%>


        </tr>

    </c:forEach>
</table>
<%--<sec:authorize access="hasRole('ROLE_ADMIN')">--%>
    <%--<a href="/editBook/create">Create new book</a>--%>
<%--</sec:authorize>--%>
<br/>
<%--<a href="<c:url value="j_spring_security_logout" />" > Logout</a>--%>


</body>
</html>
