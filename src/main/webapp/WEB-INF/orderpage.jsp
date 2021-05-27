<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Se ${type}:
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>

        <h1>${type} nr. ${order.order_id} fra ${order.mail}</h1>


        <c:if test="${type == 'Forespørgsel' }">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Længde</th>
                    <th scope="col">Bredde</th>
                </tr>

                </thead>
                <tbody>

                <tr>
                    <td>${order.length}</td>
                    <td>${order.width}</td>
                </tr>
                </tbody>
            </table>
        </c:if>

        <c:if test="${type == 'Ordre' }">
            <table class="table">

                <thead>
                <tr>
                    <th scope="col">Navn</th>
                    <th scope="col">Antal</th>
                </tr>

                </thead>
                <tbody>


                <c:forEach items="${order.orderlines}" var="orderline">
                    <tr>
                        <td><c:out value="${orderline.standardCarportEntity.name}"/></td>
                        <td><c:out value="${orderline.quantity}"/></td>

                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>

        <h2>Total pris : ${order.price}</h2>
    </jsp:body>
</t:genericpage>
