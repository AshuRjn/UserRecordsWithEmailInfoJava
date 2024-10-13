<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ include file="Menu.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Registration here....</h2>
	<form action="/saveReg" method="post">
		<table>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="firstname" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td>Mobile:</td>
				<td><input type="text" name="mobile" /></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center;"><input
					type="submit" value="Save" /></td>
			</tr>
		</table>
	</form>
	${msg}
</body>
</html>