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

        <table class="table">
            <thead>
            <tr>
                <th scope="col">Produkt nr</th>
                <th scope="col">Antal</th>
            </tr>

            </thead>
            <tbody>
            <c:forEach items="${orderlines}" var="orderline">
                <tr>
                    <td><c:out value="${orderline.product_id}"/></td>
                    <td><c:out value="${orderline.quantity}"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <h2>Total pris : ${price}</h2>
    </jsp:body>
</t:genericpage>
