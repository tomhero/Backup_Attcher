<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@taglib prefix="db" tagdir="/WEB-INF/tags/"%>
<%-- 
    Document   : DatabaseReport
    Created on : Apr 1, 2016, 9:36:06 AM April Fool's Day
    Author     : Chayut
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Database Query</title>
    </head>
    <body>
    <center>
        <h1> Database Report </h1>
        <form action="DatabaseReport.jsp">
            Input your SQL command below.<br><br>
            <textarea name="cmd" rows="5" cols="50" required>${param['cmd']}</textarea>
            <br><br>
            <!--<input name="cmd" type="text" > <br><br>-->
            <input type="submit" value="run Statement" >
        </form>
        <c:catch var="catcher">
            <db:myDatabaseQuery queryCmd="${param['cmd']}"/>
        </c:catch>
        <br>
        <strong><c:out value="Have a Problem? : ${catcher}" default="nope"/></strong>
    </center>
</body>
</html>
