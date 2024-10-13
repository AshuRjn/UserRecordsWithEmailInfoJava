<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="Menu.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Registration...</title>
</head>
<body>
<h2>Update Registration here..</h2>
<form action="/updateReg" method="post">
	<table>
	<tr>
			<td><input type="hidden" name="id" value="${registrations.id}" /></td>
		</tr>
	<tr>
			<td>Name:</td>
			<td><input type="text" name="firstname" value="${registrations.firstname}" /></td>
		</tr>
		<tr>
			<td>Email:</td>
			<td><input type="text" name="email" value="${registrations.email}" /></td>
		</tr>
		<tr>
			<td> Updated Mobile No :</td>
			<td><input type="text" name="mobile" value="${registrations.mobile}"/></td>
		</tr>
		<tr>
			<td colspan="2" style="text-align: center;">
			<input type="submit"value="update" /></td>
		</tr>

	</table>
	</form>

</body>
</html>