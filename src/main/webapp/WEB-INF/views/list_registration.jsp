<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="Menu.jsp" %>
 
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration List</title>
</head>
<body>
<h2>Registration list...</h2>
    <table border="1" cellpadding="5" cellspacing="0">
        <thead>
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Mobile</th>
                <th>Delete</th>
                <th>Update</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${registrations}" var="registration">
                <tr>
                    <td>${registration.firstname}</td>
                    <td>${registration.email}</td>
                    <td>${registration.mobile}</td>
                    <td><a href="deleteReg?id=${registration.id}">delete</a></td>
                    <td><a href="getRegById?id=${registration.id}">update</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
