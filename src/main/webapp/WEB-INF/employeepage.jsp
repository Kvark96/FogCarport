<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Medarbejderside
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <h1>Hej ${sessionScope.email}! </h1>
        Du er nu logget ind som en medarbejder

        <p>  <a href="${pageContext.request.contextPath}/fc/orderlist" class="btn btn-primary"> Se alle ordrer </a>
        <p>  <a href="${pageContext.request.contextPath}/fc/requestlist" class="btn btn-primary"> Se alle forespørgelser</a>


    </jsp:body>
</t:genericpage>
