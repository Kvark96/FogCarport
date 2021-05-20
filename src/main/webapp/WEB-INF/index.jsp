<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>

    <jsp:attribute name="header">
         Home
    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${false}" scope="request"/>
    </jsp:attribute>

    <jsp:body>


            <h2>Velkommen til Fog </h2>
            <div style="margin-top: 3em;margin-bottom: 3em;">
                <h6>Opret nemt og hurtigt en ny profil for at sende en henvendelse</h6>
            </div>
                <div class="row">

            <div class="col"> <img src="${pageContext.request.contextPath}/IMG/carport6.jpg"  class="img-fluid mx-auto d-block"   alt="FrontPic">
        </div>

       <div class="col"><img src="${pageContext.request.contextPath}/IMG/carport2.fill.jpg"  class="img-fluid  mx-auto d-block mt-5"   alt="FrontPic">
       </div>
        </div>

        <c:if test="${empty sessionScope.role}">
            <c:set var="link" scope="session" value="/fc/registerpage"/>
        </c:if>
        <c:if test="${empty sessionScope.role}">
            <c:set var="customCarport" scope="session" value="/fc/customCarport"/>
        </c:if>


        <c:choose>
            <c:when test="${sessionScope.role == 'customer'}">
                <div class="col-sm-4">
                    <a class="btn btn-primary" href="${pageContext.request.contextPath}${customCarport}" role="button">Lav en henvendelse!</a>
                </div>
            </c:when>
            <c:otherwise>
                <div class="col-sm-4">
                    <a class="btn btn-primary" href="${pageContext.request.contextPath}${link}" role="button">Lav en henvendelse!</a>
                </div>
            </c:otherwise>
        </c:choose>


            <c:if test="${sessionScope.role == 'employee' }">
                <p style="font-size: larger">This is what you can do,
                    since your are logged in as an employee</p>
                 <p><a href="fc/employeepage">Employee Page</a>
             </c:if>

             <c:if test="${sessionScope.role == 'customer' }">
                <p style="font-size: larger">This is what you can do, since your
                    are logged in as a customer</p>
                <p><a href="fc/customerpage">Customer Page</a>
            </c:if>
        </div>

    </jsp:body>
</t:genericpage>