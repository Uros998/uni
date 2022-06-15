<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Spring MVC Form Validation</title>
    <style>
        .error {
            color: red
        }
    </style>
</head>
<body>

<form:form action="processForm"  modelAttribute="registraion">
    <div align="center">
        <h2>Register Here</h2>
        <table>
            <tr>
                <td>Name</td>
                <td>
                    <form:input type="text" path="name" />
                </td>
                <td>
                    <form:errors path="name" cssClass="error" />
                </td>
            </tr>
            <tr>
                <td>Car model</td>
                <td>
                    <form:input type="text" path="carModel" />
                </td>
                <td>
                    <form:errors path="carModel" cssClass="error" />
                </td>
            </tr>
            <tr>
                <td>Model</td>
                <td>
                    <form:input type="text" path="model" />
                </td>
                <td>
                    <form:errors path="model" cssClass="error" />
                </td>
            </tr>
            <tr>
                <td>Number of days </td>
                <td>
                    <form:input type="number" path="numOfDays" />
                </td>
                <td>
                    <form:errors path="numOfDays" cssClass="error" />
                </td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Submit" /></td>
            </tr>
        </table>
    </div>
</form:form>
</body>
</html>