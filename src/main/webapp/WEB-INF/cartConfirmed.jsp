<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
        Ordre gennemført

    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>
      <h1>Tak for din ordre!</h1>
        <p> Du får tilsendt en kvittering på din mail. </p>
        <p> Forventet leveringstid er: 7 dage </p>
        <a href="${pageContext.request.contextPath}/fc/customerpage" class="btn btn-primary"> Gå tilbage til kundesiden</a>

    </jsp:body>

</t:genericpage>

