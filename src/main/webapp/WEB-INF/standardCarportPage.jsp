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

            <div class="col">   <img src="${pageContext.request.contextPath}/IMG/CARPORT ENKELT 3,00X4,80M CAR01 FLADT TAG.png"  class="img-fluid  mx-auto d-block"   alt="Fladt-tag">

                <p>${applicationScope.standardCarportEntities.get(0).description}  </p>

                <p class="font-weight-bold">${applicationScope.standardCarportEntities.get(0).price}</p>

        </div>

            <form method="post" action="${pageContext.request.contextPath}/fc/standardCarportCommand">
        </form>



            <h1> ${applicationScope.standardCarportEntities.get(1).name}</h1>

            <div class="col">    <img src="${pageContext.request.contextPath}/IMG/CARPORT ENKELT 3,60X5,40M CAR01H HØJ REJSNING.png"  class="img-fluid  mx-auto d-block mt-5"   alt="HØJ REJSNING">



                <p>${applicationScope.standardCarportEntities.get(1).description}  </p>

                <p class="font-weight-bold">${applicationScope.standardCarportEntities.get(1).price}</p>

            </div>

            <form method="post" action="${pageContext.request.contextPath}/fc/StandartCarportCommand">

        </form>



            <h1> ${applicationScope.standardCarportEntities.get(3).name}</h1>

            <div class="col">
                <img src="${pageContext.request.contextPath}/IMG/CARPORT ENKELT 3,60X9,10M CRXL1HR MED REDSKABSRUM 3,20X3,55M.png"  class="img-fluid  mx-auto d-block"   alt="HØJ REJSNIN GMED REDSKABSRUM320">





                <p>${applicationScope.standardCarportEntities.get(2).description}  </p>

                <p class="font-weight-bold">${applicationScope.standardCarportEntities.get(2).price}</p>


            </div>




            <form method="post" action="${pageContext.request.contextPath}/fc/StandartCarportCommand">

        </form>




            <h1> ${applicationScope.standardCarportEntities.get(3).name}</h1>

            <div class="col">       <img src="${pageContext.request.contextPath}/IMG/CARPORT ENKELT 3,90X7,80M CPO01HR MED REDSKABSRUM 2,40X3,30M.png"  class="img-fluid  mx-auto d-block mt-5"   alt="HØJ REJSNIN GMED REDSKABSRUM240">




                <p>${applicationScope.standardCarportEntities.get(3).description}  </p>

                <p class="font-weight-bold">${applicationScope.standardCarportEntities.get(3).price}</p>

            </div>
            <form method="post" action="${pageContext.request.contextPath}/fc/StandartCarportCommand">


        </form>
        </div>

        </div>




    </jsp:body>

</t:genericpage>

