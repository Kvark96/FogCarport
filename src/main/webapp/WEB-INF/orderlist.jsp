<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Ordreliste
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <table class="table">
            <thead>
            <tr>
                <th scope="col"> Ordre nr</th>
                <th scope="col"> Oprettet</th>
                <th scope="col"> Pris</th>
                <th scope="col"> Bruger nr</th>
                <th scope="col"> Type</th>
            </tr>

            </thead>
            <tbody>
            <c:forEach items="${orders}" var="order">
                <tr>
                    <th scope="row"><c:out value="${order.order_id}"/></th>
                    <td><c:out value="${order.created}"/></td>
                    <td><c:out value="${order.price}"/></td>
                    <td><c:out value="${order.user_id}"/></td>
                    <td><c:out value="${order.type}"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </jsp:body>
</t:genericpage>
