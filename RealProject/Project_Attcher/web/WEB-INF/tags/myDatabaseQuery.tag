<%-- 
    Document   : myDatabaseQuery
    Created on : Apr 1, 2016, 9:54:16 AM
    Author     : goku-_000
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="queryCmd"%>

<%-- any content can be specified here e.g.: --%>

<sql:query var="report" scope="session" dataSource="it_15">
    ${queryCmd};
</sql:query>
    <br>
<table border="1">
    <!-- column headers -->
    <tr>
    <c:forEach var="columnName" items="${report.columnNames}">
        <th><c:out value="${columnName}"/></th>
    </c:forEach>
</tr>
<!-- column data -->
<c:forEach var="row" items="${report.rowsByIndex}">
    <tr>
    <c:forEach var="column" items="${row}">
        <td><c:out value="${column}"/></td>
    </c:forEach>
    </tr>
</c:forEach>
</table>
