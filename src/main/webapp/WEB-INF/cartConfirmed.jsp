<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
        Tak for din bestilling
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>
      <h1> Mange tak for din bestilling</h1>
        <p1> Din carport vil være klar til afhentning inden for 24 timer</p1>



        <a href="${pageContext.request.contextPath}/fc/customerpage" class="btn btn-primary"> Gå tilbage til kundesiden</a>





    </jsp:body>

</t:genericpage>

