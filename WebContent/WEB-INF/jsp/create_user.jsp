<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.augmentum.exam.util.AppPropertyUtil"%>
<%@ page import="com.augmentum.exam.util.PathUtil"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>user manager</title>
  </head>
  <body>
     <script src="<%=AppPropertyUtil.getStaticUrl()%>/js/save_user.js"> </script>
    <div class="content"> 
       <div class="mark_manager">
         <h4>User Manager &gt; create User</h4>
       </div>
       <p></p>
       <div class="creat_question">
         <div class="submit_form">
           <form action="<%=PathUtil.getFullPath("user/saveUser")%>" method="post" id="CreateUserForm" name="CreateUserForm">
             <input type="hidden" name="id" value="${requestScope.user.id}">
             &nbsp;Username: <input type="text" name="userName" id="userName" class="profile_input" value="${requestScope.user.userName}"/> 
                             <label class="xingHao">*</label>
             <p>&nbsp;&nbsp; Gender: <input type="radio" value="male" name="gender" checked="checked" />Male
               <input type="radio" value="female" name="gender" <c:if test="${requestScope.user.gender eq 'female'}">checked="checked"</c:if> />Female
             <p>Full Name: <input type="text" name="fullName" class="profile_input" value="${requestScope.user.fullName}" />
             <p>Role Type: <select size="1" id="select" name="select" class="profile_input">
                             <option value="roleType" />
                             <option value="contentAdmin">systemAdmin</option>
                             <option value="contentAdmin">contentAdmin</option>
                             <option value="student">student</option>
                             <option value="teacher">teacher</option>
                           </select>
                           <label class="xingHao">*</label>
             <p>Telephone: <input type="text" name="telephone"  class="profile_input" value="${requestScope.user.telephone}"/>
             <p>&nbsp;&nbsp;&nbsp;   Email: <input type="text" name="email"  class="profile_input" value="${requestScope.user.email}"/>
             <p>&nbsp; Address: <input type="text" name="address" class="profile_input" value="${requestScope.user.address}"/>
             <div id="errorMessage" class="errorMessage"> </div>
             <p>&nbsp;&nbsp;<input type="button" value="Submit" onclick="saveUser()" class="save_sub"/>&nbsp;
             <input type="button" value="Cancel" onclick="cancelUser(${requestScope.pagination.currentPage})" class="save_can" />
           </form>
         </div>
       </div>
    </div>
  </body>
</html>