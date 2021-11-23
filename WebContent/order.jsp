<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>All Products | Ecommerce</title><link href="https://fonts.googleapis.com/css2?family=Quicksand:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css">
    <link rel="stylesheet" href="css/style.css">
</head>

<body>
    <div class="container">
        <div class="navbar">
            <div class="logo">
                <a href=""><img src="images/logo.png" alt="logo" width="125px"></a>
            </div>
            <nav>
                <ul id="MenuItems">
                    <li><a href="home">Home</a></li>
                    <li><a href="products.html">Products</a></li>
                    <li><a href="">About</a></li>
                    <li><a href="">Contact</a></li>
                    <li><a href="account.html">Account</a></li>
                </ul>
            </nav>
            <a href="cart"><img src="images/cart.png" width="30px" height="30px"></a>
            <img src="images/menu.png" class="menu-icon" onclick="menutoggle()">
        </div>
    </div>

    <!-- Cart items details -->
    <div class="small-container cart-page">
        <table>
            <tr>
                <th>Product</th>
                <th>Quantity</th>
                <th>Subtotal</th>
            </tr>
            <c:forEach items="${bookItems}" var="item" varStatus="i">
                <tr>
                    <td>
                        <div class="cart-info">
                            <img src="images/book.jpg">
                            <div>
                                <p>${item.book.title}</p>
                                <small>${item.price}</small>
                            </div>
                        </div>
                    </td>
                    <td><input type="number" value="${bookQuantity[i.index]}"></td>
                    <td>${bookPrice[i.index]}d</td>
                </tr>
            </c:forEach>
            <c:forEach items="${clothesItems}" var="item" varStatus="i">
                <tr>
                    <td>
                        <div class="cart-info">
                            <img src="images/category-1.jpg">
                            <div>
                                <p>${item.clothes.type}</p>
                                <small>${item.price}</small>
                            </div>
                        </div>
                    </td>
                    <td><input type="number" value="${clothesQuantity[i.index]}"></td>
                    <td>${clothesPrice[i.index]}d</td>
                </tr>
            </c:forEach>
            <c:forEach items="${shoesItems}" var="item" varStatus="i">
                <tr>
                    <td>
                        <div class="cart-info">
                            <img src="images/category-2.jpg">
                            <div>
                                <p>${item.shoes.material}</p>
                                <small>${item.price}</small>
                            </div>
                        </div>
                    </td>
                    <td><input type="number" value="${shoesQuantity[i.index]}"></td>
                    <td>${shoesPrice[i.index]}d</td>
                </tr>
            </c:forEach>
            <c:forEach items="${electronicItems}" var="item" varStatus="i">
                <tr>
                    <td>
                        <div class="cart-info">
                            <img src="images/electronic.jpg">
                            <div>
                                <p>${item.electronic.name}</p>
                                <small>${item.price}</small>
                            </div>
                        </div>
                    </td>
                    <td><input type="number" value="${electronicQuantity[i.index]}"></td>
                    <td>${electronicPrice[i.index]}d</td>
                </tr>
            </c:forEach>
        </table>
        <div class="total-price">
            <table>
                <tr>
                    <td>Subtotal</td>
                    <td>${totalPrice}d</td>
                </tr>
                <tr>
                    <td>Shipment</td>
                    <td>${shipmentPrice}d</td>
                </tr>
                <tr>
                    <td>Voucher Discount</td>
                    <td>${voucherDiscount}d</td>
                </tr>
                <tr>
                    <td>Discount</td>
                    <td>${discount}d</td>
                </tr>
                <tr>
                    <td>Total</td>
                    <td>${total}d</td>
                </tr>
                
            </table>
        </div>
        <!--
        <form action="some.jsp">
        <div class="row">
            <div class="col-6 text-center">
                <h2>Select payment</h2>
                <select name="payment">
                    <option selected>Cash on delivery</option>
                    <option>Paypal</option>
                    <option>Credit Card</option>
                </select>
            </div>
            <div class="col-6 text-center">
                <h2>Select shipment</h2>
                <select name="shipment">
                    <option selected>AbroadShipment</option>
                    <option>EconomicalShipment</option>
                    <option>FastShipment</option>
                </select>
            </div>
            <div class="col-6 text-center">
                <h2>Select voucher</h2>
                <select name="voucher">
                    <option selected>Amount</option>
                    <option>Percentage</option>
                </select>
            </div>
        </div>
        <div class="text-center">
            <a href="/checkout" class="btn btn-success">Order</a>
        </div>
        </form> -->
    </div>
    <div id="footer" style="width: 100%; height: 550px; background-color: #e8e8e8; margin-top: 30px;">
        <h3 style="font-size: 40px; text-align: center; padding: 50px 0;">About</h3>
        <div class="row">
            <div class="col-6">
                <ul class="list-group-flush">
                    <li class="list-group-item">
                        <h4>Liên hệ</h4>
                    </li>
                    <li class="list-group-item"><i class="fas fa-map-marker"></i> Địa chỉ: PTIT, Hà Nội</li>
                    <li class="list-group-item"><i class="fas fa-envelope"></i> Email: abcabcbabc@gmail.com</li>
                    <li class="list-group-item"><i class="fas fa-mobile-alt"></i> SĐT: 0123456879</li>
                    <li class="list-group-item"><i class="fas fa-phone"></i> Đường dây nóng: 19000099</li>
                </ul>
            </div>

            <div class="col-6">
                <ul class="list-group-flush">
                    <li class="list-group-item">
                        <h4>Theo dõi chúng tôi trên</h4>
                    </li>
                    <li class="list-group-item"><i class="fab fa-facebook-square"></i> Facebook</li>
                    <li class="list-group-item"><i class="fab fa-instagram"></i> Instagram</li>
                    <li class="list-group-item"><i class="fab fa-twitter-square"></i> Twiter</li>
                </ul>
            </div>
        </div>
    </div>

    <script>
        var MenuItems = document.getElementById("MenuItems");
        MenuItems.style.maxHeight = "0px";
        function menutoggle() {
            if (MenuItems.style.maxHeight == "0px") {
                MenuItems.style.maxHeight = "200px"
            }
            else {
                MenuItems.style.maxHeight = "0px"
            }
        }
    </script>

</body>

</html>