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
            <th scope="col"> Noter</th>
        </tr>

        </thead>
        <tbody>

        <c:forEach items="${descriptionEntities}" var="description">
            <tr>
                <th scope="row"><c:out value="${description}"/></th>

                <td><c:out value="${getDescription}"/>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
    </jsp:body>

</t:genericpage>