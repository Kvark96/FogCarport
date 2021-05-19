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
        <h1>Hej ${sessionScope.name} </h1>
        <p> Velkommen til din kundeoversigt</p>




        <br>
        <p>  <a href="${pageContext.request.contextPath}/fc/customCarport" class="btn btn-primary"> Vælg carport ud special mål </a>
        <br>
        <a href="${pageContext.request.contextPath}/fc/standardCarportPage" class="btn btn-primary"> Standard carporte </a>


    </jsp:body>

</t:genericpage>

