<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Ecommerce</title>
            <link href="https://fonts.googleapis.com/css2?family=Quicksand:wght@300;400;500;600;700&display=swap"
                rel="stylesheet">
            <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" />
            <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
            <link rel="stylesheet"
                href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css">
            <link rel="stylesheet" href="css/style.css">
            <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> -->
        </head>

        <body>
            <!-- <div class="toast" role="alert" aria-live="assertive" aria-atomic="true" data-delay="2000"
        style="position: absolute; top: 1rem; right: 1rem; z-index:100; background-color: lawngreen;">
        <div class="toast-header">

            <strong class="mr-auto">Thông báo</strong>
            <small>now</small>
            <button type="button" class="ml-2 mb-1 close" data-dismiss="toast" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
        <div class="toast-body" id="toastbody">
            Hello, world! This is a toast message.
        </div>
    </div> -->
            <div class="header">
                <div class="container">
                    <div class="navbar">
                        <div class="logo">
                            <a href="index.html"><img src="images/logo.png" alt="logo" width="125px"></a>
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
                    <div class="row">
                        <div class="col-4">
                            <h1>Welcome to Ecommerce</h1>
                            <p>Electronic, book, clothes and more...</p>
                            <!-- <a href="" class="btn">Explore Now &#8594;</a> -->
                        </div>
                        <div class="col-4">
                            <img src="images/image1.png" style="width: 100%; aspect-ratio: 1/1;">
                        </div>
                    </div>
                </div>
            </div>

            <!-- Feadtued Categories -->

            <div class="categories">
                <div class="container">
                    <h2 class="title">Danh mục sản phẩm</h2>
                    <div class="row">
                        <div class="col-3">
                            <img style="width: 100%; aspect-ratio: 1/1;" src="images/book.jpg">
                            <h4 class="text-center">Book</h4>
                        </div>
                        <div class="col-3">
                            <img style="width: 100%; aspect-ratio: 1/1;" src="images/category-2.jpg">
                            <h4 class="text-center">Shoes</h4>
                        </div>
                        <div class="col-3">
                            <img style="width: 100%; aspect-ratio: 1/1;" src="images/category-3.jpg">
                            <h4 class="text-center">Clothes</h4>
                        </div>
                        <div class="col-3">
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
                        <div class="col-3">
                            <div class="card">
                                <img class="card-img-top" src="images/book.jpg" alt="img product">
                                <div class="card-body">
                                    <h4 class="card-title">${product.book.title}</h4>
                                    <h6 class="card-text">${product.book.summary}</h6>
                                    <h5 class="card-text">${product.price}đ</h5>
                                    <div class="btn btn-primary text-center" onclick="addtocart(${product.ID}, 1)">Add
                                        to Cart</div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div><!-- Featured Products -->
            <div class="small-container">
                <h2 class="title">Magazine</h2>
                <div class="row">
                    <c:forEach items="${listMagazine}" var="product">
                        <div class="col-3">
                            <div class="card">
                                <img class="card-img-top" src="images/book.jpg" alt="img product">
                                <div class="card-body">
                                    <h4 class="card-title">${product.book.title}</h4>
                                    <h6 class="card-text">${product.book.summary}</h6>
                                    <h5 class="card-text">${product.price}đ</h5>
                                    <div class="btn btn-primary text-center" onclick="addtocart(${product.ID}, 1)">Add
                                        to Cart</div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div><!-- Featured Products -->
            <div class="small-container">
                <h2 class="title">LightNovel</h2>
                <div class="row">
                    <c:forEach items="${listLightNovel}" var="product">
                        <div class="col-3">
                            <div class="card">
                                <img class="card-img-top" src="images/book.jpg" alt="img product">
                                <div class="card-body">
                                    <h4 class="card-title">${product.book.title}</h4>
                                    <h6 class="card-text">${product.book.summary}</h6>
                                    <h5 class="card-text">${product.price}đ</h5>
                                    <div class="btn btn-primary text-center" onclick="addtocart(${product.ID}, 1)">Add
                                        to Cart</div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>

            <div class="small-container">
                <h2 class="title">Boot</h2>
                <div class="row">
                    <c:forEach items="${listBoot}" var="product">
                        <div class="col-3">
                            <div class="card">
                                <img class="card-img-top" src="images/category-2.jpg" alt="img product">
                                <div class="card-body">
                                    <h4 class="card-title">Boot</h4>
                                    <h6 class="card-text">${product.shoes.weight} g</h6>
                                    <h5 class="card-text">${product.price}đ</h5>
                                    <div class="btn btn-primary text-center" onclick="addtocart(${product.ID}, 1)">Add
                                        to Cart</div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
            <div class="small-container">
                <h2 class="title">Sandal</h2>
                <div class="row">
                    <c:forEach items="${listSandal}" var="product">
                        <div class="col-3">
                            <div class="card">
                                <img class="card-img-top" src="images/category-2.jpg" alt="img product">
                                <div class="card-body">
                                    <h4 class="card-title">Sandal</h4>
                                    <h6 class="card-text">${product.shoes.weight} g</h6>
                                    <h5 class="card-text">${product.price}đ</h5>
                                    <div class="btn btn-primary text-center" onclick="addtocart(${product.ID}, 1)">Add
                                        to Cart</div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>

            <div class="small-container">
                <h2 class="title">Sneaker</h2>
                <div class="row">
                    <c:forEach items="${listSneaker}" var="product">
                        <div class="col-3">
                            <div class="card">
                                <img class="card-img-top" src="images/category-2.jpg" alt="img product">
                                <div class="card-body">
                                    <h4 class="card-title">Sneaker</h4>
                                    <h6 class="card-text">${product.shoes.weight} g</h6>
                                    <h5 class="card-text">${product.price}đ</h5>
                                    <div class="btn btn-primary text-center" onclick="addtocart(${product.ID}, 1)">Add
                                        to Cart</div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>

            <div class="small-container">
                <h2 class="title">Jeans</h2>
                <div class="row">
                    <c:forEach items="${listJeans}" var="product">
                        <div class="col-3">
                            <div class="card">
                                <img class="card-img-top" src="images/category-3.jpg" alt="img product">
                                <div class="card-body">
                                    <h4 class="card-title">Shoes</h4>
                                    <h6 class="card-text">${product.clothes.type}</h6>
                                    <h5 class="card-text">${product.price}đ</h5>
                                    <div class="btn btn-primary text-center" onclick="addtocart(${product.ID}, 1)">Add
                                        to Cart</div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
            <div class="small-container">
                <h2 class="title">Mobile</h2>
                <div class="row">
                    <c:forEach items="${listMobile}" var="product">
                        <div class="col-3">
                            <div class="card">
                                <img class="card-img-top" src="images/electronic.jpg" alt="img product">
                                <div class="card-body">
                                    <h4 class="card-title">${product.electronic.name}</h4>
                                    <h6 class="card-text">${product.electronic.year}</h6>
                                    <h5 class="card-text">${product.price}đ</h5>
                                    <div class="btn btn-primary text-center" onclick="addtocart(${product.ID}, 1)">Add
                                        to Cart</div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
            <div class="small-container">
                <h2 class="title">Laptop</h2>
                <div class="row">
                    <c:forEach items="${listLaptop}" var="product">
                        <div class="col-3">
                            <div class="card">
                                <img class="card-img-top" src="images/electronic.jpg" alt="img product">
                                <div class="card-body">
                                    <h4 class="card-title">${product.electronic.name}</h4>
                                    <h6 class="card-text">${product.electronic.year}</h6>
                                    <h5 class="card-text">${product.price}đ</h5>
                                    <div class="btn btn-primary text-center" onclick="addtocart(${product.ID}, 1)">Add
                                        to Cart</div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
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

            <!-- javascript -->

            <script>
                function addtocart(bookItemId, quantity) {
                    $.ajax({
                        url: 'addbook',
                        type: 'POST',
                        data: {
                            bookItemId: bookItemId,
                            quantity: quantity
                        },
                        success: function (data, textStatus, xhr) {
                            if (xhr.status == 302) {
                                location.href = xhr.getResponseHeader("Location");
                                return;
                            }
                            alert(data);
                        },
                        complete: function (xhr, textStatus) {
                            console.log(xhr.status);
                        }
                    });
                }
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