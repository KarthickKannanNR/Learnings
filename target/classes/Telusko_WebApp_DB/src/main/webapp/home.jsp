<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>

<form action="addUser">
<input type="number" name="userId"><br>
<input type="text" name="userName"><br>
<input type="text" name="location"><br>
<button type="submit">SUBMIT</button>
<h3 name ="message">${user}</h3>
</form>

<h2>Find User By ID</h2>
<form action="findUser">
<input type="number" name="userId1"><br>
<button type="submit">SUBMIT</button>
<h3 name ="message">${user}</h3>
</form>

<h2>Find User By Location</h2>
<form action="findUser">
<input type="text" name="location"><br>
<button type="submit">SUBMIT</button>
<h3 name ="message">${user}</h3>
</form>

<h2>Delete User</h2>
<form action="deleteUser">
<input type="number" name="userId"><br>
<button type="submit">SUBMIT</button>
<h3 name ="message">${user}</h3>
</form>
</body>
</html>