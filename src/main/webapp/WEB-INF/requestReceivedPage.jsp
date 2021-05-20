<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Bekræft din forespørgsel
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>
        <h1>Mange tak for din henvendelse</h1>

         Bekræft at du ønsker du at indsende en forspørgsel, for en carport med længden ${length}cm, og med en bredden ${width}cm.
        <br>
        <br>

        <p>  <a href="${pageContext.request.contextPath}/fc/requestConfirmedPage" class="btn btn-primary"> Tryk her for at bekræfte </a>

        <form action="${pageContext.request.contextPath}/fc/drawing" method="post" name="SVGForm">
            <input type="hidden" value="780" name="length"/>
            <input type="hidden" value="600" name="width"/>
            <input type="submit" class="btn-primary" value="Se SVG">
        </form>



    </jsp:body>

</t:genericpage>

