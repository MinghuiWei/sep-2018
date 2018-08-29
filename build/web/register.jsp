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
  
  <script type="text/javascript">
		  function gE(x){ return document.getElementById(x);} 
	 
	      function check(){
		   
	    	if(gE("firstname").value==""){
		        alert("firstname can not null");
		    	return false;
		    }
		    
		    
		    if(gE("lastname").value==""){
		        alert("lastname can not null");
		    	return false;
		    }
		    
		    
		   if(gE("username").value==""){
		        alert("username can not null");
		    	return false;
		    }
		    
		    
		   if(gE("password").value==""){
		        alert("password can not null");
		    	return false;
		    }
		    
		      if(gE("password").value.length<6){
		        alert("password at least six ");
		    	return false;
		    }
		    
		    return true;
		    }
	      
	    
          </script>
          
</head>
<body>
<div class="header">
  <div class="am-g">
    <h1>Journal Web Site</h1>
    <p>Please enter your information<br/>
  </div>
  <hr />
</div>
<div class="am-g">
  <div class="am-u-lg-6 am-u-md-8 am-u-sm-centered">
    <h3>Register</h3>
    <hr>

    <br>

    <form method="post" action="<%=path %>/register" class="am-form"   onsubmit="return check()">
      <label for="firstname">firstname:</label>
      <input type="text" name="firstname" id="firstname" value="">
      <br>
      <label for="lastname">lastname:</label>
      <input type="text" name="lastname" id="lastname" value="" placeholder="lastname">
      <br>
    
      <label for="password">username:</label>
      <input type="text" name="username" id="username" value="">
      <br>
      
      <label for="password">password:</label>
      <input type="password" name="password" id="password" value="" placeholder="you password must contain at least 6 character">
      <br>
      
      <a href="<%=path %>/page/login.jsp" class="am-fl">Already got an account</a>
      <br />
      <div class="am-cf">
        <input type="submit" name="" value="Register" class="am-btn am-btn-primary am-btn-sm am-fr">
        
      </div>
    </form>
    <hr>
    <p>Jouneral Web Site</p>
  </div>
</div>
</body>
</html>
