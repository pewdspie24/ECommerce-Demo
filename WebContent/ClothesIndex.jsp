<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Meta Ecommerce</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css">
</head>

<body>
    <div id="main">
        <!-- header -->
        <div id="header" class="navbar navbar-expand-lg navbar-dark fixed-top" style="background-color: orangered">
            <ul class="navbar-nav col-md-11">
                <a class="navbar-brand font-weight-bolder" href="#">Meta Ecommerce</a>
                <li class="nav-item"><a class="nav-link text-white" href="#">Trang chủ</a></li>
                <li class="nav-item"><a class="nav-link text-white" href="#content">About</a></li>
            </ul>
            <div class="col-md-1 text-white">
                Logout
                <i class="fas fa-sign-out-alt"></i>
            </div>
        </div>
        <!-- end header -->

        <!-- jumbotron -->
        <div class="jumbotron text-center bg-white mt-2">
            <h1>Meta Ecommerce</h1>
            <form action="">
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="Tìm kiếm" required>
                    <div class="input-group-append">
                        <button type="button" class="btn btn-danger">search</button>
                    </div>
                </div>
            </form>
        </div>
        <!-- end jumbotron -->


        <!-- content -->
        <div id="content">
            <div class="row">
                <div class="col-md-2">
                    <div class="bg-dark mb-3">
                        <div class="card-header bg-success text-white text-uppercase"><i class="fa fa-list"></i>
                            Categories</div>
                        <ul class="list-group">
                            <li class="list-group-item"><a href="index.jsp" style="color: #000;">All product</a></li>
                            <li class="list-group-item"><a href="BookIndex.jsp" style="color: #000;">Book</a></li>
                            <li class="list-group-item"><a href="ShoesIndex.jsp" style="color: #000;">Shoes</a></li>
                            <li class="list-group-item"><a href="ElectronicIndex.jsp" style="color: #000;">Electronic</a></li>
                            <li class="list-group-item active"><a href="ClothesIndex.jsp" style="color: #000;">Clothes</a></li>
                        </ul>
                    </div>
                </div>

                <div class="col-9">
                    <div class="row">
                        <c:forEach items="${listClothesProducts}" var="o">
                            <div class="col-12">
                                <div class="card">
                                    <img class="card-img-top" src="${o.image}" alt="img product">
                                    <div class="card-body">
                                        <h4 class="card-title"><a href="productDetail.jsp" title="View Product">${o.type}</a></h4>
                                        <div class="row">
                                            <div class="col">
                                                <p class="btn btn-danger btn-block">${o.price} price$</p>
                                            </div>
                                            <div class="col">
                                                <a href="#" class="btn btn-success btn-block">Add to cart</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>

            </div>
        </div>
        <!-- end content -->

        <!-- footer -->
        <div id="footer" style="width: 100%; height: 550px; background-color: #fff; margin-top: 30px;">
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

        <!-- end footer -->
    </div>
</body>

</html>