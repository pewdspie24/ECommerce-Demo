<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Books Store Application</title>
</head>
<body>
<div align="center">
 <h1>Bookstore Login</h1>
 <h2>
           <a href="/BookstoreManagement-Ex3-Lab1/show">Home</a>
            
       </h2>
       <div align="center">
       <table border="1" cellpadding="5">
           <caption><h2>List of Payments</h2></caption>
           <tr>
               <th>ID</th>
               <th>Method Name</th>
               <th>Discount</th>
           </tr>
           <c:forEach var="payment" items="${listPayment}">
               <tr>
                   <td><c:out value="${payment.ID}" /></td>
                   <td><c:out value="${payment.methodName}" /></td>
                   <td><c:out value="${payment.discount}" /></td>
               </tr>
           </c:forEach>
       </table>
       <table border="1" cellpadding="5">
           <caption><h2>List of Shipments</h2></caption>
           <tr>
               <th>ID</th>
               <th>Company name</th>
               <th>Price</th>
           </tr>
           <c:forEach var="shipment" items="${listShipment}">
               <tr>
                   <td><c:out value="${shipment.ID}" /></td>
                   <td><c:out value="${shipment.company}" /></td>
                   <td><c:out value="${shipment.shipmentPrice}" /></td>
               </tr>
           </c:forEach>
       </table>
   </div>
  <form action="<%=request.getContextPath()%>/order" method="post">
   <table style="with: 100%">
    <tr>
     <td>Payment ID</td>
     <td><input type="text" name="payment" /></td>
    </tr>
    <tr>
     <td>Shipment ID</td>
     <td><input type="text" name="shipment" /></td>
    </tr>

   </table>
   <input type="submit" value="Get Order!" />
  </form>
 </div>
</body>
</html>