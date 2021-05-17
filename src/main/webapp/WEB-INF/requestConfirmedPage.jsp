<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Tak for din henvendelse
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>
        <h1>Din henvendelse er nu modtaget</h1>
        <p> Du vil høre fra os, inden for 5 hverdage.</p>


        <p>  <a href="${pageContext.request.contextPath}/fc/customerpage" class="btn btn-primary"> Gå tilbage til kundesiden</a>

    </jsp:body>

</t:genericpage>

