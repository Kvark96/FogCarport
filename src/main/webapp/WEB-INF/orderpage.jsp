<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Se ${typeOfOrder}:
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>

        <h1>${typeOfOrder} nr. ${order_id} fra ${user_email}</h1>




        <c:if test="${typeOfOrder == 'Forespørgsel' }">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Længde</th>
                    <th scope="col">Bredde</th>
                </tr>

                </thead>
                <tbody>

                <tr>
                    <td>${length}</td>
                    <td>${width}</td>
                </tr>
                </tbody>
            </table>
        </c:if>

        <c:if test="${typeOfOrder == 'Ordre' }">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Beskrivelse</th>
                    <th scope="col">Antal</th>
                </tr>

                </thead>
                <tbody>

                <tr>
                    <td>${length}</td>
                    <td>${width}</td>
                </tr>
                </tbody>
            </table>
        </c:if>

        <h2>Total pris : ${price}</h2>
    </jsp:body>
</t:genericpage>
