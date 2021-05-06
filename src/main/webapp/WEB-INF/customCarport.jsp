<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">Forespørgsel på carport.</jsp:attribute>
    <jsp:attribute name="footer"> </jsp:attribute>
    <jsp:body>
       <h1>Vælg din carport ud fra dine ønskede mål</h1>

        <form method="post" action="${pageContext.request.contextPath}/fc/requestReceivedPage">

            <label for="length">længde </label>

            <select name="length" id="length" class="form-select">

                <c:forEach var="length" items="${applicationScope.meassureEntitiesList}">
                    <option value="${length.length}">${length.length}</option>
                </c:forEach>
            </select>


            <label for="width">bredte</label>

            <select name="width" id="width" class="form-select">
                <c:forEach var="width" items="${applicationScope.meassureEntitiesList}">
                    <option value="${width.width}">${width.width}</option>


                </c:forEach>


            </select>

            <br>
            <input type="submit" class="btn btn-success align-items-md-center " value="Vælg"/>

        </form>





    </jsp:body>
</t:genericpage>
