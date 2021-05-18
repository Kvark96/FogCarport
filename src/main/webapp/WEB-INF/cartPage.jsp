<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
        Indkøbskurv
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>

        <table class="table table-striped">
        <thead>
        <tr>
        <th scope="col">Navn</th>
        <th scope="col">Antal</th>
        <th scope="col">Pris</th>
        <th scope="col"></th>
        </tr>
        </thead>

        <c:forEach var="SCarport" items="${cart.carportIDs}">
            <tr>
                <td>${SCarport.name}</td>
                <td>${SCarport.quantity}</td>
                <td>${SCarport.quantity}</td>
                <td>${SCarport.calcPrice}</td>
                <td>

                    <button type="submit" class="btn btn-danger" name="delete" value="${item}">
                        Fjern

                    </button>
                </td>
            </tr>
        </c:forEach>






    </jsp:body>

</t:genericpage>

