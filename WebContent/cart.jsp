<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Meta Commerce</title>
        <style> 
        	body{
        		font-size: 1rem;
        		line-height: 1.2;
        		color: rgba(0, 0, 0, 0.8);
        		background-color: rgb(245,245,245);
        	}
        	div{
        		display: block;
        	}
        	ul{
        	    margin-block-start: 1em;
			    margin-block-end: 1em;
			    margin-inline-start: 0px;
			    margin-inline-end: 0px;
			    padding-inline-start: 40px;
        	}
        	.container {
			    margin-right: auto;
			    margin-left: auto;
			    width: 1200px;
			}
            .navbar{
            	display: flex;
            	background: #ee4d2d;
            	
            	justify-content: space-between;
            	width: 100%;
            	color: #fff;
            	align-items: center;
            	min-width: 1200px;
            }
            .header-topleft{
            	display: flex;
            	box-sizing: border-box;
            	align-items:center;
            }
            .header-topright{
            	display: flex;
            	
            	align-items:center;
            	padding: 0;
            	margin: 0;
            	list-style: none;
            }
            .cart-top{
            	display: flex;
            	background: #fff;
            	border-bottom: solid 1px rgba(0,0,0,0.9);
            	height: 6.25rem;
            	min-width: 1200px;
            	align-items: center;
            }
            .cart-page-header {
			    padding-left: 1.125rem;
			    display: flex;
			    flex: 1;
			}
			.cart-page-searchbar {
			    width: 38.8125rem;
			    position: relative;
			}
			.cart-page-logo {
			    text-decoration: none;
			    color: rgba(0,0,0,.87);
			    display: block;
			    display: flex;
			    align-items: flex-end;
			}
			.cart-page-logo__page-name {
			    margin-left: 0.9375rem;
			    border-left: 0.0625rem solid #ee4d2d;
			    color: #ee4d2d;
			    font-size: 1.25rem;
			    line-height: 1.875rem;
			    height: 1.875rem;
			    padding-left: 0.9375rem;
			    margin-bottom: 0.0625rem;
			    text-transform: capitalize;
    		}
    		.cart-page-searchbar {
			    width: 38.8125rem;
			    position: relative;
			    padding: 0;
    			border: 2px solid #ee4d2d;
    			display: flex;
    			align-items: stretch;
			    justify-content: space-between;
			    height: 2.5rem;
			    box-sizing: border-box;
			    border-radius: 2px;
			    background: #fff;
			    flex:1;
			}
			.shopee-searchbar-input {
			    display: flex;
			    flex: 1;
			    box-sizing: border-box;
			    padding-left: 0.625rem;
			}
			.shopee-searchbar-input__input {
			    display: flex;
			    flex: 1;
			    align-items: center;
			    outline: none;
			    border: 0;
			    padding: 0;
			    margin: 0;
			}
			.btn {
			    overflow: hidden;
			    display: -webkit-box;
			    text-overflow: ellipsis;
			    -webkit-line-clamp: 1;
			    flex-direction: column;
			    font-size: 14px;
			    -moz-box-sizing: border-box;
			    box-sizing: border-box;
			    box-shadow: 0 1px 1px 0 rgb(0 0 0 / 9%);
			    border-radius: 2px;
			    border: 0;
			    display: flex;
			    align-items: center;
			    justify-content: center;
			    text-transform: capitalize;
			    outline: 0;
			    cursor: pointer;
			}
    		.btn-solid-primary {
			    color: #fff;
			    background: #ee4d2d;
			}
			.btn--s {
			    height: 38px;
			    padding: 0 15px;
			    min-width: 60px;
			    max-width: 190px;
			}
			.btn--inline {
    			display: inline-flex;
			}
			.div-main{
				display: flex;
			    flex-direction: column;
			    color: rgba(0,0,0,.8);
			    padding-top: 20px;
			}
			.list-top{
			    display: flex;
			    align-items: center;
			    box-shadow: 0 1px 1px 0 rgb(0 0 0 / 5%);
			    overflow: hidden;
			    border-radius: 3px;
			    height: 55px;
			    font-size: 18px;
			    background: #fff;
			    text-transform: capitalize;
			    margin-bottom: 12px;
			    color: #888;
			    padding: 0 20px;
			}
			.top-row-name{
				width:35%; 
				color:rgba(0,0,0,0.8); 
				text-align: center;
				border-right: 0.0625rem solid rgb(136,136,136);
			}
			.list-main{
				box-shadow: 0 1px 1px 0 rgb(0 0 0 / 5%);
			    border-radius: 0.125rem;
			    overflow: hidden;
			    background: #fff;
			    overflow: visible;
			    margin-bottom: 0.9375rem;
			}
			.list-item{
				position: relative;
				padding-bottom: 20px;
				padding-top: 15px;
				text-decoration: none;
			    color: rgba(0,0,0,.87);
			    padding: 0 20px 15px;
			    margin-top: 15px;
			    display: flex;
			    align-items: center;
			    text-align: center;
			    
			}
			.item-name{
				text-decoration: none;
			    color: rgba(0,0,0,.87);
			    margin-bottom: 5px;
			    max-height: 32px;
			    text-overflow: ellipsis;
			    word-break: break-all;
			    display: -webkit-box;
			    -webkit-box-orient: vertical;
			    -webkit-line-clamp: 2;
			}
			.footer-general{
				border-top-color: #ee4d2d;
				min-width: 75rem;
    			border-top: 4px solid #ee4d2d;
    			background-color: #fbfbfb;
    			color: rgba(0,0,0,.54);
			}
			.footer-table{
				margin: 0 -0.3125rem;
    			padding: 0.3125rem;
    			width: 100%;
    			align-items: flex-start;
    			display: flex;
    			background-color: #fbfbfb;
			}
			.footer-column{
				width: 25%;
	    		padding: 0.3125rem;
	    		box-sizing: border-box;
	    		background-color: #fbfbfb;
			}
			.footer-column-top{
				font-size: .75rem;
			    font-weight: 700;
			    color: rgba(0,0,0,.54);
			    margin-bottom: 1.25rem;
			    margin-top: 2.5rem;
			    text-transform: uppercase;
			}
			.footer-column-content{
				text-decoration: none;
			    display: block;
			    color: rgba(0,0,0,.54);
			    list-style-type: none;
			    margin: 0 0 1.5625rem;
			    padding-right: 100px;
			    font-size: .9rem;
			}
			.checkout-main{
				display: grid;
			    grid-template-columns: 1fr 20.3125rem 11.875rem;
			    align-items: center;
			    -moz-box-sizing: border-box;
			    box-sizing: border-box;
			    background: #fff;
			    width: 100%;
			    flex: 1;
			    font-size: 1rem;
			    position: relative;
			    margin-top: 0.75rem;
			    z-index: 2;
			    position: sticky;
			    bottom: 0;
			}
			.checkout-tab{
				padding: 12px 0;
			    grid-column-start: 1;
			    grid-column-end: 4;
			    display: flex;
			    align-items: center;
			    flex: 1;
			    width: 100%;
			}
			.checkout-btn{
				padding: 13px 36px;
			    margin: 0 22px 0 15px;
			    text-transform: capitalize;
			    font-weight: 300;
			    height: 2.5rem;
			    font-size: .875rem;
			    border-radius: 5px;
			    width: 13.125rem;
			    background: #ee4d2d;
			    cursor: pointer;
			    color: #fff;
			    outline: none;
			    border: none;
			}
        </style>
    </head>
    <body>
            <%-- <a href="/BookstoreManagement-Ex3-Lab1/cart">Show Cart</a> --%>
            <!-- Topmost header -->
            <div class="navbar">
            	<div class="header-topleft">
            		<div style="display: flex; font-weight: 300; padding: 0 0 .4375rem;">Connect with us thru Meta & Instagram </div>
            		
            	</div>
            	<ul class="header-topright">
            		<a href="/BookstoreManagement-Ex3-Lab1/logout" style ="padding: 0 0.4375rem; text-decoration: none; color: #fff;">Logout</a>
            	</ul>
            </div>
            
            
            
        	<div>
        	
        	<!-- Navigation bar and searchbar -->
        	
        		<div class="cart-top">
        			<div class="container">
        				<div style="display:flex; align-items: center;">
        					<div class="cart-page-header">
        						<a class="cart-page-logo" href="/">
        							<div class ="cart-page-logo__page-name" style="padding-left: 0.3rem; border-left: 0; margin-left: 0.05rem;">
        								<b>Home</b>
        							</div>
        						</a>
        						<div class ="cart-page-logo__page-name">
        							Cart
        						</div>
        					</div>
        					<div class="cart-page-searchbar">
        						<form action="#"class="shopee-searchbar-input" autocomplete="off">
        							<input class="shopee-searchbar-input__input" autocomplete="off" placeholder="SEARCH FOR A PRODUCT" name="product">
        							<button type="submit" class="btn btn-solid-primary btn--s btn--inline">
        								Search
        							</button>
        						</form>
        					</div>
        					
        				</div>
        			</div>
        		</div>
        		
        		<!-- End of navigation bar and searchbar -->
        		<!-- Start of the item list pane -->
        		
        		<div class="container">
        			<div class="div-main" style="margin-bottom: 0px;">
        				<div class="list-top">
        					<div class="top-row-name"> Product name </div>
        					<div class="top-row-name" style="width: 15%;"> Unit price </div>
        					<div class="top-row-name" style="width: 15%;"> Quantity </div>
        					<div class="top-row-name" style="width: 15%;"> Price </div>
        					<div class="top-row-name" style="width: 12%; border-right: 0px"> Action </div>  
        				</div>
        				
        				<!-- Wrap the list-main with a loop to display user's item list-->
        				
        				<div class="list-main">
        					<div class="list-item">
        						<div style="width: 35%; box-sizing: border-box; position: relative; flex-direction: column; text-align: left;">
        							<a class="item-name" href="#"> noice stuff 1</a>
        						</div>
        						<div style="width:15%; align-items: center; justify-content: center;">
        							25.00
        						</div>
        						<div style="width:15%; align-items: center; justify-content: center;">
        							1
        						</div>
        						<div style="width:15%; align-items: center; justify-content: center;">
        							25.00
        						</div>
        						<div style="width:12%; align-items: center; justify-content: center; text-transform: capitalize;">
        							<a href="#" style="text-decoration: none;">&ltInsert link to remove the corresponding product&gt</a>
        						</div>
        					</div>
        				</div>
        				<div class="list-main">
        					<div class="list-item">
        						<div style="width: 35%; box-sizing: border-box; position: relative; flex-direction: column; text-align: left;">
        							<a class="item-name" href="#"> noice stuff 2</a>
        						</div>
        						<div style="width:15%; align-items: center; justify-content: center;">
        							30.00
        						</div>
        						<div style="width:15%; align-items: center; justify-content: center;">
        							2
        						</div>
        						<div style="width:15%; align-items: center; justify-content: center;">
        							60.00
        						</div>
        						<div style="width:12%; align-items: center; justify-content: center; padding-right: 0; text-transform: capitalize;">
        							<a href="#" style="text-decoration: none;">&ltInsert link to remove the corresponding product&gt</a>
        						</div>
        					</div>
        				</div>
        			</div>
        			<!-- End of the item list pane -->
        			<div class="checkout-main">
        				<div class="checkout-tab">
        					<div style="display: flex; flex-direction: column; align-items: center; justify-content: flex-end; font-size: 16px; line-height: 19px; color: #222; padding-left: 1.5rem;">
        						Total: &ltExtract total from controller&gt
        					</div>
        					<div style="display:flex; width: 100%;"> </div>
        					<input type="submit" onclick="window.location='/BookstoreManagement-Ex3-Lab1/selectsp';" class="checkout-btn" value="Checkout">
        					</input>
        				</div>
        			</div>
        			
        		</div>
        		
        		
        		<footer class="footer-general">
        			<div style="background-color: #fbfbfb; width:75rem; margin:auto;">
        				<div class="footer-table">
        					<div class="footer-column">
        						<div class="footer-column-top">about us</div>
        						<div class="footer-column-content">
        							5 members from group 10, from strangers to a group of friends
        						</div>
        					</div>
        					<div class="footer-column">
        						<div class="footer-column-top">our goal</div>
        						<div class="footer-column-content">
        							To get that sweet A that we promised to ourselves
        						</div>
        					</div>
        					<div class="footer-column">
        						<div class="footer-column-top">our members</div>
        						<ul class="footer-column-content" style="align-content: center; padding-inline-start: 0px;">
        							<li> Quang Tran</li>
        							<li> Ngoc Ninh </li>
        							<li> Nam Nguyen </li>
        							<li> Nhat Nguyen </li>
        							<li> Nguyen Dao</li>
        						</ul>
        					</div>
        					<div class="footer-column">
        						<div class="footer-column-top">contact us</div>
        					</div>
        				</div>
        			</div>
        		</footer>
        	</div>
    </body>
</html>
