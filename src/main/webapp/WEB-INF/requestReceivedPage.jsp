<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Tak for din henvendelse eller noget i den dur
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>
        <h1>Mange tak for din henvendelse</h1>

        bredte = ${length}
        <br/>
        højde =  ${width}





    </jsp:body>

</t:genericpage>

