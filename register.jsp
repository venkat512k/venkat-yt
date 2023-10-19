<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="regForm" method="post">
		name:<input type="text" name="name1"/><br/><br/>
		email:<input type="text" name="email1"/><br/><br/>
		password:<input type="password" name="pass1"/><br/><br/>
		gender:<input type="radio" name="gender1" value="male"/>male <input type="radio" name="gender1" value="female"/>female<br/><br/>
		city:<select name="city1">
			<option>select city</option>
			<option>Hyderabad</option>
			<option>andgra pradesh</option>
			<option>mumbai</option>
		</select><br/><br/>
		<input type="submit" value="Rsgister"/>
	</form>
</body>
</html>