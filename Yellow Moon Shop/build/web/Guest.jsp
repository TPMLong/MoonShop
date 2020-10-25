<%-- 
    Document   : Guest
    Created on : Oct 18, 2020, 3:56:04 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Create new</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    </head>
    <body>
        <h1 style="text-align: center">Order Information</h1>
        <a href="login.html">Back</a>
        <form action="history" method="POST">
            <div class="form-group" style="width: 50%;margin: 0 auto;">
                <input type="text" name="txtName" class="form-control" id="InputEmail1" style="width: 500px" placeholder="Name" required>
                <small id="emailHelp" class="form-text text-muted">Input name</small>
            </div>
            <div class="form-group" style="width: 50%;margin: 0 auto;">
                <input type="text" name="txtAddress" class="form-control" id="InputPassword1" style="width: 500px;"  placeholder="Address" required>
                <small id="nameHelp" class="form-text text-muted">Input address</small>
            </div>
            <button type="submit" class="btn btn-primary" style="margin-left: 50%;" name="btAction" value="Create New Account">Submit</button>
        </form>

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>
