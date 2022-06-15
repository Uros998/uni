<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title><spring:message code="text.title" text="Welcome" /></title>
</head>
    <body>
        <h1><spring:message code="text.title" text="Welcome" /> ${name}</h1>
        <p><spring:message code="text.data" text="Data :" /> ${carModel}, ${model}, ${numOfDays}.</p>
    </body>
</html>
