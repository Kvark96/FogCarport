<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:genericpage>

<jsp:attribute name="header">
         Dine tidligere ordre
    </jsp:attribute>
  <jsp:attribute name="footer">
    </jsp:attribute>
  <jsp:body>

    <table class="table">
    <thead>
    <tr>
      <th scope="col"> Order id</th>
      <th scope="col"> Pris</th>
      <th scope="col"> Længde</th>
      <th scope="col"> Bredde</th>
      <th scope="col"> Oprettet</th>
    </tr>

      <tbody>
      <c:forEach items="${previousOrdersList}" var="oldList">
        <tr>
          <th scope="row"><c:out value="${oldList.order_id}"/></th>
          <td><c:out value="${oldList.price}"/></td>
          <td><c:out value="${oldList.length}"/></td>
          <td><c:out value="${oldList.width}"/></td>
          <td><c:out value="${oldList.created}"/></td>

        </tr>
      </c:forEach>
      </tbody>

    </thead>
    </table>




  </jsp:body>


</t:genericpage>