<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.augmentum.exam.util.PathUtil"%>
<%@ page import="com.augmentum.exam.util.AppPropertyUtil"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>exam_question</title>
    <link href="<%=AppPropertyUtil.getStaticUrl()%>/css/main.css" rel="stylesheet" type="text/css">
    <link href="<%=AppPropertyUtil.getStaticUrl()%>/css/question.css" rel="stylesheet" type="text/css">
    <link href="<%=AppPropertyUtil.getStaticUrl()%>/css/exam.css" rel="stylesheet" type="text/css">
    <link href="<%=AppPropertyUtil.getStaticUrl()%>/css/page.css" rel="stylesheet" type="text/css">
     <link href="<%=AppPropertyUtil.getStaticUrl()%>/css/profile.css" rel="stylesheet" type="text/css">
  </head>
  <script src="<%=AppPropertyUtil.getStaticUrl()%>/js/jquery-1.6.4.js" ></script>
  <body>
    <div class="header">
      <h1> Online Exam System</h1>
      <div class="top_welcom">
        <h3>welcome ${sessionScope.USER.userName},
          <a href="<%=PathUtil.getFullPath("user/login")%>?mark=logout">
            <label class="top_logout">
              logout
            </label>
          </a>
        </h3>
      </div>
    </div>
    <div class="left">
      <div class="manager_question" id="user_manager" >
        <a href="<%=PathUtil.getFullPath("user/showUser")%>">User Manager</a>
      </div><br>
      <div class="profile"  id="profile" >
        <a href="<%=PathUtil.getFullPath("profile")%>">My Profile</a>
      </div><br>
    </div>
    <c:if test="${requestScope.MARK eq 'userManager' || requestScope.MARK eq null}">
      <jsp:include page="user_manager.jsp" />
    </c:if>
    <c:if test="${requestScope.MARK eq 'createUser'}">
      <jsp:include page="create_user.jsp" />
    </c:if>
    <c:if test="${requestScope.MARK eq 'updateUser'}">
      <jsp:include page="create_user.jsp" />
    </c:if>
    <c:if test="${requestScope.MARK eq 'profile'}">
      <jsp:include page="profile.jsp" />
    </c:if>
  </body>
 </html>