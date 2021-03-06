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

        <table class="table">
            <thead>
            <tr>
                <th scope="col"> Produkt</th>
                <th scope="col"> Pris</th>
                <th scope="col"></th>
            </tr>
            </thead>

           <tbody>
            <c:forEach items="${cart.carports}" var="carport">
                <tr>
                    <th scope="row">
                        <c:out value="${carport.name}"/></th>
                    <td><c:out value="${carport.price}"/></td>
                    <td>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>


        <h1>Den samlede pris = ${cart.calcprice} DKK</h1>

        <form name="confirm" action="${pageContext.request.contextPath}/fc/cartConfirmed"  method="POST">
            <input type="hidden" name="price" value="${cart.calcprice}"/>
            <button class="btn btn-primary" type="submit" value="confirm"> Bekræft </button>
        </form>
        <br>
        <a href="${pageContext.request.contextPath}/fc/standardCarportPage" class="btn btn-primary">Gå tilbage til Standard carporte </a>






    </jsp:body>

</t:genericpage>

