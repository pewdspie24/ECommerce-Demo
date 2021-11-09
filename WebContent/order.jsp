<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Books Store Application</title>
</head>
<body>
    <center>
        <h1>Your Order</h1>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Table</h2></caption>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Author</th>
                <th>Years</th>
                <th>Publication</th>
                <th>Price</th>
                <th>Numbers</th>
                <th>Total Price</th>
            </tr>
            <c:forEach var="bookitem" items="${listBook}">
                <tr>
                    <td><c:out value="${bookitem.book.ID}" /></td>
                    <td><c:out value="${bookitem.book.title}" /></td>
                    <td><c:out value="${bookitem.book.author}" /></td>
                    <td><c:out value="${bookitem.book.years}" /></td>
                    <td><c:out value="${bookitem.book.publication}" /></td>
                    <td><c:out value="${bookitem.book.price}" /></td>
                    <td><c:out value="${bookitem.numbers}" /></td>
                    <td><c:out value="${bookitem.totalPrice}" /></td>
                </tr>
            </c:forEach>
            
        </table>
        <p>Payment: <c:out value="${myOrder.payment.methodName}" /></p>
        <p>Shipment: <c:out value="${myOrder.shipment.company}" /></p>
        <p>Total Discount: <c:out value="${myOrder.getTotalDiscount()}" /></p>
        <p>Total Price: <c:out value="${myOrder.totalPrice}" /></p>
        
    </div> 
    <center>
        <a href="/BookstoreManagement-Ex3-Lab1/show">Home</a>
    </center>  
</body>
</html>