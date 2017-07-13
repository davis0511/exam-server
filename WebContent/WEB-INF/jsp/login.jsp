<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.augmentum.exam.Constants"%>
<%@ page import="com.augmentum.exam.util.PathUtil"%>
<%@ page import="com.augmentum.exam.util.AppPropertyUtil"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>login</title>
    <link href="<%=AppPropertyUtil.getStaticUrl()%>/css/reset.css" rel="stylesheet" type="text/css">
    <link href="<%=AppPropertyUtil.getStaticUrl()%>/css/login.css" rel="stylesheet" type="text/css">
  </head>
  <body>
    <div class="login_form">
      <div class="login_form_title">Online Exam System <br>
    </div>
        <%
        String tipMessage = (String)request.getAttribute(Constants.TIP_MESSAGE);
        String visibility = "hidden";
        if (tipMessage != null && !tipMessage.equals("")) {
            visibility = "visible";
        }
        %>
    <form action="<%=PathUtil.getFullPath("user/login")%>" method="POST" id="loginForm" name="loginForm">
      <div class="login_username">
        <h2>UserName: <input type="text" name="userName" id="userName"  class="btn_username" /></h2><br>
      </div>
      <br><br><br>
      <div class="login_password">
        <h2>Password: <input type="password" name="password" id="password"  class="btn_password" /></h2><br>
      </div><br>
      <div id="errorMsg" class="errorMessage"> 
         <label style="visibility: <%=visibility%>">
             <%=tipMessage %>
         </label>
      </div>
      <div class="login_button">
        <input class="login_inputbutton" type="button" value="login" onclick="login()"/>
      </div>
    </form>
    </div>
    <script src="<%=AppPropertyUtil.getStaticUrl()%>/js/login.js" ></script> 
    <script src="<%=AppPropertyUtil.getStaticUrl()%>/js/jquery-1.6.4.js" ></script> 
  </body>
</html>