<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
        Kunde oversigt
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>
        <h1>Hej ${sessionScope.email} </h1>
        <p> Velkommen til din kundeoversigt</p>



        <p>  <a href="${pageContext.request.contextPath}/fc/customCarport" class="btn btn-primary"> Vælg carport ud fra mål </a>
        <br/>
        Role: ${sessionScope.role}

    </jsp:body>

</t:genericpage>

