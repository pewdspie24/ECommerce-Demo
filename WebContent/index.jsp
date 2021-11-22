<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ecommerce</title>
    <link href="https://fonts.googleapis.com/css2?family=Quicksand:wght@300;400;500;600;700&display=swap"
        rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
        integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css">
    <link rel="stylesheet" href="css/style.css">
</head>

<body>

    <div class="header">
        <div class="container">
            <div class="navbar">
                <div class="logo">
                    <a href="index.html"><img src="images/logo.png" alt="logo" width="125px"></a>
                </div>
                <nav>
                    <ul id="MenuItems">
                        <li><a href="">Home</a></li>
                        <li><a href="products.html">Products</a></li>
                        <li><a href="">About</a></li>
                        <li><a href="">Contact</a></li>
                        <li><a href="account.html">Account</a></li>
                    </ul>
                </nav>
                <a href="cart.html"><img src="images/cart.png" width="30px" height="30px"></a>
                <img src="images/menu.png" class="menu-icon" onclick="menutoggle()">
            </div>
            <div class="row">
                <div class="col-2">
                    <h1>Welcome to Ecommerce</h1>
                    <p>Electronic, book, clothes and more...</p>
                    <!-- <a href="" class="btn">Explore Now &#8594;</a> -->
                </div>
                <div class="col-2">
                    <img src="images/image1.png">
                </div>
            </div>
        </div>
    </div>

    <!-- Feadtued Categories -->

    <div class="categories">
        <div class="container">
            <h2 class="title">Danh mục sản phẩm</h2>
            <div class="row">
                <div class="col-4">
                    <img style="width: 100%; aspect-ratio: 1/1;" src="images/book.jpg">
                    <h4 class="text-center">Book</h4>
                </div>
                <div class="col-4">
                    <img style="width: 100%; aspect-ratio: 1/1;" src="images/category-2.jpg">
                    <h4 class="text-center">Shoes</h4>
                </div>
                <div class="col-4">
                    <img style="width: 100%; aspect-ratio: 1/1;" src="images/category-3.jpg">
                    <h4 class="text-center">Clothes</h4>
                </div>
                <div class="col-4">
                    <img style="width: 100%; aspect-ratio: 1/1;" src="images/electronic.jpg">
                    <h4 class="text-center">Electronic</h4>
                </div>
            </div>
        </div>
    </div>

    <!-- Featured Products -->
    <div class="small-container">
        <h2 class="title">Comics</h2>
        <div class="row">
            <c:forEach items="${listComics}" var="product">
                <div class="col-4">
                    <div class="card">
                        <img class="card-img-top" src="/image/book.jpg" alt="img product">
                        <div class="card-body">
                            <h5 class="card-title">${product.book.title}</h5>
                            <p class="card-text">${product.book.summary}</p>
                            <p class="card-text">${product.price}</p>
                            <a href="#" class="btn btn-primary">Add to Cart</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
    
    <!-- Featured Products -->
    <div class="small-container">
        <h2 class="title">Magazine</h2>
        <div class="row">
            <c:forEach items="${listMagazine}" var="product">
                <div class="col-4">
                    <div class="card">
                        <img class="card-img-top" src="/image/book.jpg" alt="img product">
                        <div class="card-body">
                            <h5 class="card-title">${product.title}</h5>
                            <p class="card-text">${product.summary}</p>
                            <p class="card-text">${product.price}</p>
                            <a href="#" class="btn btn-primary">Add to Cart</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>

    <!-- Offer -->
    <!-- <div class="offer">
        <div class="small-container">
            <div class="row">
                <div class="col-2">
                    <img src="images/exclusive.png" class="offer-img">
                </div>
                <div class="col-2">
                    <p>Exclusively Available on Ecommerce</p>
                    <h1>Smart Band 4</h1>
                    <small>The Mi Smart Band 4 fearures a 39.9%larger (than Mi Band 3) AMOLED color full-touch display
                        with adjustable brightness, so everything is clear as can be.<br></small>
                    <a href="products.html" class="btn">Buy Now &#8594;</a>
                </div>
            </div>
        </div>
    </div> -->

    <!-- Footer -->
    <div id="footer" style="width: 100%; height: 550px; background-color: #e8e8e8; margin-top: 30px;">
            <h3 style="font-size: 40px; text-align: center; padding: 50px 0;">About</h3>
            <div class="row">
                <div class="col-6">
                    <ul class="list-group-flush">
                        <li class="list-group-item"><h4>Liên hệ</h4></li>
                        <li class="list-group-item"><i class="fas fa-map-marker"></i>  Địa chỉ: PTIT, Hà Nội</li>
                        <li class="list-group-item"><i class="fas fa-envelope"></i>  Email: abcabcbabc@gmail.com</li>
                        <li class="list-group-item"><i class="fas fa-mobile-alt"></i>  SĐT: 0123456879</li>
                        <li class="list-group-item"><i class="fas fa-phone"></i>  Đường dây nóng: 19000099</li>
                    </ul>
                </div>

                <div class="col-6">
                    <ul class="list-group-flush">
                        <li class="list-group-item"><h4>Theo dõi chúng tôi trên</h4></li>
                        <li class="list-group-item"><i class="fab fa-facebook-square"></i>  Facebook</li>
                        <li class="list-group-item"><i class="fab fa-instagram"></i>  Instagram</li>
                        <li class="list-group-item"><i class="fab fa-twitter-square"></i>  Twiter</li>
                    </ul>
                </div>
            </div>
        </div>
        
    <!-- javascript -->

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