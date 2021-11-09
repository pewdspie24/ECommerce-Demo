<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Books Store Application</title>
</head>
<body>
 <div align="center">
  <h1>Bookstore Login</h1>
  <h2>
            <a href="/BookstoreManagement-Ex3-Lab1/registerform.jsp">Register</a>
             
        </h2>
  <form action="<%=request.getContextPath()%>/home" method="post">
   <table style="with: 100%">
    <tr>
     <td>UserName</td>
     <td><input type="text" name="username" /></td>
    </tr>
    <tr>
     <td>Password</td>
     <td><input type="password" name="password" /></td>
    </tr>

   </table>
   <input type="submit" value="Submit" />
  </form>
 </div>
</body>
</html>