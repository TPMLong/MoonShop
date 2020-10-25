<%-- 
    Document   : history
    Created on : Oct 18, 2020, 3:03:40 PM
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
                            <option value="id">
                                member                        
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
        <c:set var="result" value="${requestScope.SEARCHRESULT}"/>
        <c:set var="results" value="${requestScope.SEARCHRESULTS}"/>
        <c:if test="${not empty result}">
            <div class="row row-cols-3 row-cols-md-3">
                <c:forEach var="dto" items="${result}" varStatus="counter">
                    <form action="cart" method="POST">
                        <div class="col mb-4">
                            <div class="card h-100">                                    
                                <div class="card-body">
                                    <h5 class="card-title" id="myText">OrderID:${dto.orderId}</h5>
                                    <p class="card-text">Name:${dto.userId}<br/>
                                    <p class="card-text">Date:${dto.date}<br/>     
                                    <p class="card-text">Address:${dto.address}<br/>
                                    <p class="card-text">Payment method: offline<br/>
                                    <p class="card-text">Payment status: none<br/>
                                        <c:forEach var="product" items="${results}" varStatus="counter">
                                            Product:${product}<br/>
                                        </c:forEach>
                                </div>
                            </div>
                        </div>
                    </form>
                </c:forEach>
            </div>
            <div id="myDIV">
            </div>
        </c:if>  
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>