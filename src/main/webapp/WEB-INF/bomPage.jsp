<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Forslag til stykliste
    </jsp:attribute>

    <jsp:body>
    <table class="table">
        <thead>
        <tr>
            <th scope="col"> Beskrivelse</th>
            <th scope="col"> Længde</th>
            <th scope="col"> Antal</th>
            <th scope="col"> Enhed</th>
            <th scope="col"> Beskrivelse</th>
        </tr>

        </thead>
        <tbody>

        <c:forEach items="${materialList}" var="mat">
            <tr>
                <th scope="row"><c:out value="${mat.name}"/></th>

                <td><c:out value="${mat.length}"/></td>
                <td><c:out value="${mat.unit}"/></td>
                <td><c:out value="${mat.description}"/></td>


            </tr>
        </c:forEach>

        </tbody>
    </table>
    </jsp:body>

</t:genericpage>