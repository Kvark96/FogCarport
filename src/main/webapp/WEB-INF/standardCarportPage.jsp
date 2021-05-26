<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
        Caport udvalg
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>
        <div class="container">
            <div class="row">


                <h1> ${applicationScope.standardCarportEntities.get(0).name}</h1>

                <div class="col"><img
                        src="${pageContext.request.contextPath}${applicationScope.standardCarportEntities.get(0).img}"
                        class="img-fluid  mx-auto d-block" alt="Fladt-tag">

                    <p>${applicationScope.standardCarportEntities.get(0).description} </p>

                    <p class="font-weight-bold">${applicationScope.standardCarportEntities.get(0).price}</p>

                </div>

                <form method="post" action="${pageContext.request.contextPath}/fc/CartCommand">

                    <input type="hidden" name="standard_id"
                           value="${applicationScope.standardCarportEntities.get(0).standard_id}">

                    <input type="submit" class="btn btn-primary" value="Vælg denne carport">

                </form>




                    <h1> ${applicationScope.standardCarportEntities.get(1).name}</h1>

                    <div class="col"><img
                            src="${pageContext.request.contextPath}${applicationScope.standardCarportEntities.get(1).img}"
                            class="img-fluid  mx-auto d-block mt-5" alt="HØJ REJSNING">


                        <p>${applicationScope.standardCarportEntities.get(1).description} </p>

                        <p class="font-weight-bold">${applicationScope.standardCarportEntities.get(1).price}</p>

                    </div>

                    <form method="post" action="${pageContext.request.contextPath}/fc/CartCommand">

                        <input type="hidden" name="standard_id"
                               value="${applicationScope.standardCarportEntities.get(1).standard_id}">

                        <input type="submit" class="btn btn-primary" value="Vælg denne carport">

                    </form>


                    <h1> ${applicationScope.standardCarportEntities.get(3).name}</h1>

                    <div class="col">
                        <img src="${pageContext.request.contextPath}${applicationScope.standardCarportEntities.get(2).img}"
                             class="img-fluid  mx-auto d-block" alt="HØJ REJSNIN GMED REDSKABSRUM320">


                        <p>${applicationScope.standardCarportEntities.get(2).description} </p>

                        <p class="font-weight-bold">${applicationScope.standardCarportEntities.get(2).price}</p>


                    </div>


                </div>


                <form method="post" action="${pageContext.request.contextPath}/fc/CartCommand">

                    <input type="hidden" name="standard_id"
                           value="${applicationScope.standardCarportEntities.get(2).standard_id}">

                    <input type="submit" class="btn btn-primary" value="Vælg denne carport">


                </form>


                <h1> ${applicationScope.standardCarportEntities.get(3).name}</h1>


                <div class="col"><img
                        src="${pageContext.request.contextPath}${applicationScope.standardCarportEntities.get(3).img}"
                        class="img-fluid  mx-auto d-block mt-5" alt="HØJ REJSNIN GMED REDSKABSRUM240">


                    <p>${applicationScope.standardCarportEntities.get(3).description} </p>

                    <p class="font-weight-bold">${applicationScope.standardCarportEntities.get(3).price}</p>

                </div>
                <form method="post" action="${pageContext.request.contextPath}/fc/CartCommand">

                    <input type="hidden" name="standard_id"
                           value="${applicationScope.standardCarportEntities.get(3).standard_id}">

                    <input type="submit" class="btn btn-primary" value="Vælg denne carport">

                </form>
            </div>

        </div>


    </jsp:body>

</t:genericpage>

