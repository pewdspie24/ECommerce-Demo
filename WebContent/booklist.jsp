<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Books Store Application</title>
</head>
<body>
    <center>
        <h1>Bookstore</h1>
    </center>
    <left>
    	<a href="/BookstoreManagement-Ex3-Lab1/logout">Logout</a>
    </left>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Books</h2></caption>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Author</th>
                <th>Years</th>
                <th>Publication</th>
                <th>Price</th>
                <th>Numbers</th>
                <th>Action</th>
            </tr>
            <c:forEach var="book" items="${listBook}">
                <tr>
                    <td><c:out value="${book.ID}" /></td>
                    <td><c:out value="${book.title}" /></td>
                    <td><c:out value="${book.author}" /></td>
                    <td><c:out value="${book.years}" /></td>
                    <td><c:out value="${book.publication}" /></td>
                    <td><c:out value="${book.price}" /></td>
                    <form action="addbook" method="post">
                    	<td><input type="text" name="numbers" maxlength="4" size="4"/></td>
                    	<input type="text" name="id" value= ${book.ID} style="display: none"/>
                    	<td><input type="submit" value="Add Item"><td>
                    </form>
                </tr>
            </c:forEach>
            <a href="/BookstoreManagement-Ex3-Lab1/cart">Show Cart</a>
        </table>
    </div>   
</body>
</html>