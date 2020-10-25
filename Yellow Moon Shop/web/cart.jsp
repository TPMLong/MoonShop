<%-- 
    Document   : cart
    Created on : Oct 16, 2020, 10:56:56 AM
    Author     : ACER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
        <link rel="stylesheet" href="css/Moon.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <script src="includes/jquery-1.6.2.js" type="text/javascript"></script>
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
                        <c:set var="names" value="${sessionScope.NAME}"/>
                        <c:if test="${not empty names}">
                            <font color ="white" id="welcome">Welcome, ${sessionScope.NAME}
                            </font>
                        </c:if>
                    </form>
                    <c:set var="message" value="${sessionScope.NULLDETAIL}"/>
                    <c:if test="${empty message}">
                        Total: ${sessionScope.PRICE}
                    </c:if>

                    <c:if test="${empty names}">
                        <form action="try">
                            <button type="submit" class="btn btn-primary" id="lDivSearchs" name="btAction" value="Log in">Login</button>
                        </form><br/>
                    </c:if>
                    <c:if test="${not empty names}">
                        <form action="logout">
                            <button type="submit" class="btn btn-primary" id="lDivSearchs" name="btAction" value="Log out">Logout</button>
                        </form><br/>
                    </c:if>
                </div>
        </header>
        <c:set var="message" value="${sessionScope.NULLDETAIL}"/>
        <c:if test="${empty message}">
            <c:set var="result" value="${sessionScope.CAKEDETAIL}"/>
            <c:if test="${not empty result}">          
                <div class="row row-cols-3 row-cols-md-3">
                    <c:forEach var="dto" items="${result}" varStatus="counter">
                        <div class="col mb-4">
                            <div class="card h-100">
                                <img src="img/${dto.image}" class="card-img-top" style="height: 300px" alt="...">
                                <div class="card-body">
                                    <h5 class="card-title" id="myText">${dto.name}    </h5>
                                    <p class="card-text">$${dto.price}<br/>
                                    <p class="card-text">Total: $${dto.price*dto.numberCart}<br/>
                                    <form action="quantityCart" method="POST">
                                        <c:set var="error" value="${sessionScope.ERROR}"/>
                                        <c:if test="${not empty error}">
                                            ${error}<br/>
                                        </c:if>                  
                                        <input type="number" value="${dto.numberCart}" name="quantityOrder">
                                        <button type="submit" class="btn btn-primary" id="lDivSearchs" name="btAction" value="Log out">Update</button>
                                        <input type="hidden" name="updateCart" value="${dto.productID}" />                                     
                                    </form>
                                    <form action="confirm" method="POST">
                                        <button type="submit" class="btn btn-primary" id="lDivSearchs" name="btAction" value="Log out">Confirm</button>
                                        <input type="hidden" name="removeCart" value="${dto.productID}" />
                                    </form>
                                    <form action="delete" method="POST">
                                        <button type="submit" class="btn btn-primary" id="lDivSearchs" name="btAction" value="Log out">Delete</button>
                                        <input type="hidden" name="removeCart" value="${dto.productID}" />
                                    </form>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </c:if>
        </c:if>
        <c:if test="${not empty message}">
            <h1 class="card-title" id="myText">${message}</h1>
        </c:if>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>
