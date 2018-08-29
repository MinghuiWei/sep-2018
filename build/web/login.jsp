<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%>


<!DOCTYPE html>
<html>
<head lang="en">
  <meta charset="UTF-8">
  <title>Login Page | Amaze UI Example</title>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="format-detection" content="telephone=no">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="alternate icon" type="image/png" href="<%=path %>/assets/i/favicon.png">
  <link rel="stylesheet" href="<%=path %>/assets/css/amazeui.min.css"/>
  <style>
    .header {
      text-align: center;
    }
    .header h1 {
      font-size: 200%;
      color: #333;
      margin-top: 30px;
    }
    .header p {
      font-size: 14px;
    }
  </style>
</head>
<body>
<div class="header">
  <div class="am-g">
    <h1>Hospital Web Site</h1>
    <p>Please login to use this system<br/>
  </div>
  <hr />
</div>
<div class="am-g">
  <div class="am-u-lg-6 am-u-md-8 am-u-sm-centered">
    <h3>Login</h3>
    <hr>
    

    <br>

    <form method="post" action="<%=path %>/login" class="am-form">
      <label for="loginPw">UserName:</label>
      <input type="text" name="loginName" id="loginName" value="">
      <br>
      <label for="loginPw">Password:</label>
      <input type="password" name="loginPw" id="loginPw" value="">
      <br>
      <label for="remember-me">
        <input id="remember-me" type="checkbox">
        Remember me
      </label>
      <a href="<%=path %>/page/register.jsp" style="float:right">I don't have account</a>
      <br />
      <div class="am-cf">
        <input type="submit" name="" value="Login" class="am-btn am-btn-primary am-btn-sm am-fl">
      <!-- <input type="submit" name="" value="Forget Password" class="am-btn am-btn-default am-btn-sm am-fr"> -->  
      </div>
    </form>
    <hr>
    <p>Hospital Web Site</p>
  </div>
</div>
</body>
</html>
