<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
        Carport udvalg
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>
        <div class="container">
            <div class="row">
                <c:forEach items="${applicationScope.standardCarportEntities}" var="carport">
                    <h1> ${carport.name}</h1>
                    <div class="col"><img
                            src="${pageContext.request.contextPath}${carport.img}"
                            class="img-fluid  mx-auto d-block" alt="Fladt-tag">
                        <p>${carport.description} </p>
                        <p class="font-weight-bold">${carport.price} kr.</p>
                    </div>
                    <form method="post" action="${pageContext.request.contextPath}/fc/CartCommand">
                        <input type="hidden" name="standard_id"
                               value="${carport.standard_id}">
                        <input type="submit" class="btn btn-primary" value="Vælg denne carport">
                    </form>
                    <br>
                    <hr/>
                </c:forEach>
            </div>
        </div>
    </jsp:body>

</t:genericpage>

