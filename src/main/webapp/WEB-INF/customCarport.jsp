<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">Forespørgsel på carport.</jsp:attribute>
    <jsp:attribute name="footer"> </jsp:attribute>
    <jsp:body>
       <h1>Vælg din carport ud fra dine ønskede mål</h1>

        <form method="post" action="${pageContext.request.contextPath}/fc/">

            <label for="width">Bredte</label>
            <select name="width" id="width" class="form-select">

                    <option> Hej</option>

            </select>


            <label for="length">Længde</label>

            <br>
            <select name="lengnth" id="length" class="form-select">
               <option> Hej </option>
            </select>

            <input type="submit" class="btn btn-success align-items-md-center " value="Vælg"/>






        </form>





    </jsp:body>
</t:genericpage>
