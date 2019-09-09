<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
     <form action="RegisterPage"method="post">
        <table cellpadding="3pt">
            <tr>
                <td>User Name :</td>
                <td><input type="text" name="fname" size="30" /></td>
                <td><input type="text" name="lname" size="30" /></td>
                
            </tr>
            <tr>
                <td>Password :</td>
                <td><input type="password" name="upass" size="30" /></td>
            </tr>
            <tr>
                <td>email :</td>
                <td><input type="text" name="uemail" size="30" /></td>
            </tr>
            <tr>
                <td>Phone :</td>
                <td><input type="text" name="umobile" size="30" /></td>
            </tr>
        </table>
        <p />
        <input type="submit" value="Register" />
    </form>   
</body>
</html>