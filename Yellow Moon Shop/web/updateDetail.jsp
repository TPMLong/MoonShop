<%-- 
    Document   : updateDetail
    Created on : Oct 11, 2020, 2:30:22 PM
    Author     : ACER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Create new</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/Moon.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    </head>

    <body>
        <header class="page-header">
            <nav class="navbar smart-scroll navbar-expand-lg navbar-dark bg-primary">
                <a class="navbar-brand" href="#">Brand</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#main_nav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="main_nav">
                    <ul class="navbar-nav">
                        <li class="nav-item"><a class="nav-link" href="showPost">Home </a> </li>
                        <li class="nav-item"><a class="nav-link" href="update"> Update </a></li>
                        <li class="nav-item"><a class="nav-link" href="#"> Services </a></li>
                    </ul>
                    <form action="searchValue" class="categoryForm" >
                        <input type="text" name="txtSearch" id="lDivSearch" value="${param.txtSearch}" class="form-control" id="InputSearch" style="width: 500px;" placeholder="Search..." >      
                        <button type="submit" class="btn btn-primary" id="lDivSearchs" name="btAction" value="Search Post">Search</button>
                        <select name="cboBook">                                                 
                            <option value="category">
                                category                     
                            </option>   
                            <option value="price">
                                money                              
                            </option>   
                            <option value="name">
                                name                          
                            </option>
                        </select>
                        <c:set var="name" value="${sessionScope.NAME}"/>
                        <c:if test="${not empty name}">
                            <font color ="white" id="welcome">Welcome, ${sessionScope.NAME}
                            </font>
                        </c:if>
                    </form>
                    <c:if test="${empty name}">
                        <form action="try">
                            <button type="submit" class="btn btn-primary" id="lDivSearchs" name="btAction" value="Log in">Login</button>
                        </form><br/>
                    </c:if>
                    <c:if test="${not empty name}">
                        <form action="logout">
                            <button type="submit" class="btn btn-primary" id="lDivSearchs" name="btAction" value="Log out">Logout</button>
                        </form><br/>
                    </c:if>
                </div>
        </header>
        <h1 style="text-align: center">Update new cake</h1>
        <!--        <form action="DispatcherController" method="POST">
                    Email* <input type="text" name="txtEmail" value="" />(e.g. 6 - 20 chars)</br>
                    Name* <input type="text" name="txtName" value="" />(e.g. 6 - 20 chars)</br>
                    Password* <input type="password" name="txtPassword" value="" />(e.g. 6 - 20 chars)</br>
                    Confirm* <input type="password" name="txtConfirm" value="" /></br>
        
                    <input type="submit" value="Create New Account" name="btAction"/>
                    <input type="reset" value="Reset" />
                </form>-->
        <a href="searchPage">Back</a>
        <form action="updateShow" method="POST" >
            <c:set var="result" value="${requestScope.CAKEDETAIL}"/>
            <c:if test="${not empty result}">
                <c:forEach var="dto" items="${result}" varStatus="counter">
                    <div class="form-group" style="width: 50%;margin: 0 auto;">
                        <input type="hidden" name="txtID" value="${dto.productID}" />
                        <small id="nameHelp" class="form-text text-muted">Old cake name</small>                    
                        <input type="text" name="txtName" class="form-control" aria-describedby="nameHelp" style="width: 500px" value="${dto.name}">
                        <small id="priceHelp" class="form-text text-muted">Old cake price</small>                    
                        <input type="text" name="txtPrice" class="form-control" aria-describedby="priceHelp" style="width: 500px" value="${dto.price}">
                        <small id="quantityHelp" class="form-text text-muted">Old cake quantity</small>                    
                        <input type="text" name="txtQuantity" class="form-control" aria-describedby="quantityHelp" style="width: 500px" value="${dto.quantity}">
                        <small id="imageHelp" class="form-text text-muted">Old cake image</small>                    
                        <input type="text" name="txtImage" class="form-control" aria-describedby="imageHelp" style="width: 500px" value="${dto.image}">
                        <small id="cdayHelp" class="form-text text-muted">Old cake create day</small>                    
                        <input type="text" name="txtCreateDay" class="form-control" aria-describedby="cdayHelp" style="width: 500px" value="${dto.createDate}">
                        <small id="edayHelp" class="form-text text-muted">Old cake expiration day</small>                    
                        <input type="text" name="txtExpirationDay" class="form-control" aria-describedby="edayHelp" style="width: 500px" value="${dto.expirationDate}">
                    </div>             
                    <c:set var="category" value="${requestScope.CAKECATEGORY}"/>
                    <c:if test="${not empty category}">
                        <select name="cbxCaterogy">
                            <c:forEach var="itemName" items="${category}" varStatus="counter">
                                <option  value="${itemName}">${itemName}</option>
                            </c:forEach>
                        </select>
                    </c:if>
                    <c:set var="status" value="${requestScope.CAKESTATUS}"/>
                    <c:if test="${not empty status}">
                        <select name="cbxStatus">
                            <c:forEach var="itemName" items="${status}" varStatus="counter">
                                <option  value="${itemName}">${itemName}</option>
                            </c:forEach>
                        </select>
                    </c:if>
                </c:forEach>
                <button type="submit" class="btn btn-primary" style="margin-left: 50%;" name="btAction" value="Create New Account">Submit</button>
                <button type="reset" class="btn btn-primary" style="margin-left: 50%;" name="btAction" value="">reset</button>
            </c:if>
        </form>
        <!--    <script>
                function myFunction() {
                    txtEmail.setCustomValidity(txtEmail.value.length <= 0 ? "Please enter Email." : "");
                    txtName.setCustomValidity(txtEmail.value.length <= 0 ? "Please enter your name." : "");
                    txtPassword.setCustomValidity(txtEmail.value.length <= 0 ? "Please enter password." : "");
                }
            </script>-->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>
