<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Forespørgselsliste
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
                <th scope="col"> Kunde</th>
                <th scope="col"> Type</th>
                <th scope="col"></th>
            </tr>

            </thead>
            <tbody>
            <c:forEach items="${requestList}" var="req">
                <tr>
                    <th scope="row"><c:out value="${req.order_id}"/></th>

                    <td><c:out value="${req.created}"/></td>
                    <td><c:out value="${req.price}"/></td>
                    <td><c:out value="${req.mail}"/></td>
                    <td><c:out value="${req.type}"/></td>
                    <td>
                        <form name="orderpage" action="${pageContext.request.contextPath}/fc/orderpage" method="post">
                            HERE WE HAVE SOME HIDDEN VARIABLES
                            <input type="hidden" name="order_id" value="${req.order_id}"/>
                            <input type="hidden" name="typeOfOrder" value="request"/>
                            <button class="btn btn-sm  btn-outline-secondary" type="submit" value="seOrdrer"> Se ordre </button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </jsp:body>
</t:genericpage>
