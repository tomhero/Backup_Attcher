<%-- 
    Document   : MailResult
    Created on : Apr 3, 2016, 3:05:10 PM
    Author     : goku-_000
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mail result</title>
    </head>
    <body>
        <h1> Result </h1>
        <c:if test="${result == 'Pass'}">
            <h3>Your email has been sent</h3><br>
            <span> Destination: ${requestScope['Sender']['desMail']} </span><br>
            <span> Subject: ${requestScope['Sender']['subject']} </span><br>
            <span> Content: ${requestScope['Sender']['content']} </span><br>
        </c:if>
        <c:if test="${result == 'Fail'}">
            <h3>Fail to send please try again!!</h3>
            <span> <a href="SendEmail.html"> Back </a> </span>
        </c:if>
    </body>
</html>
