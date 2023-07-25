<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
		<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
		<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link href="./css/login.css" rel="stylesheet" type="text/css"/>
        <link rel="icon" href="./anhcang/cang.jpg" type="image/gif" sizes="20x20">
        <title>Đăng Ký</title>
    </head>
     <style>
    	#logreg-forms{
    width:412px;
    margin:26vh auto;
    background-color:#f3f3f3;
    box-shadow: 0 1px 3px rgba(0,0,0,0.12), 0 1px 2px rgba(0,0,0,0.24);
  transition: all 0.3s cubic-bezier(.25,.8,.25,1);
}
#logreg-forms form {
    width: 100%;
    max-width: 410px;
    padding: 15px;
    margin: auto;
}

#logreg-forms .form-control {
    position: relative;
    box-sizing: border-box;
    height: auto;
    padding: 10px;
    font-size: 16px;
}

html{
	background: url("https://img.freepik.com/free-vector/fast-food-black-background-poster_1284-14589.jpg?w=2000");
	width: 100%;
	height: 100%;
	object-fit: cover;
	overflow: hiden;
}

body{
	margin: 0;
    font-family: -apple-system,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif,"Apple Color Emoji","Segoe UI Emoji","Segoe UI Symbol";
    font-size: 1rem;
    font-weight: 400;
    line-height: 1.5;
    color: #212529;
    text-align: left;
    background-color: transparent;
}

#logreg-forms .form-signup .social-btn{ width:210px; }

#logreg-forms .form-signup input { margin-bottom: 4px;}

.form-signup .social-login{
    width:210px !important;
    margin: 0 auto;
}

.btn-success{
	color: #fff;
    background-color: #d74b33;
    border-color: #d74b33;
}
    </style>
    <body>
        <div id="logreg-forms">
            <form action="dangkyController" method="post" class="form-signup">
                <h1 class="h3 mb-3 font-weight-normal" style="text-align: center"> Đăng ký</h1>
                <input name="user" type="text" id="user-name" class="form-control" placeholder="Tendangnhap" required="" autofocus="">
                <input name="pass" type="password" id="user-pass" class="form-control" placeholder="Matkhau" required autofocus="">
                <input name="repass" type="password" id="user-repeatpass" class="form-control" placeholder="Nhaplaimatkhau" required autofocus="">
				<p class="text-danger">${tbloi}</p>
				<p class="text-danger">${tbloidk}</p>
                <button class="btn btn-primary btn-block btn-success" type="submit"><i class="fas fa-user-plus"></i> Đăng ký</button>
               	<a href="dangnhapController">Đăng nhập</a>
            </form>
            <br>

        </div>
        

        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        
    </body>
</html>