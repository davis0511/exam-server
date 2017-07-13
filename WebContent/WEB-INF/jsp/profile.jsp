<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.augmentum.exam.util.AppPropertyUtil"%>
<%@ page import="com.augmentum.exam.util.PathUtil"%>

<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>my profile</title>
    
  </head>
  <script src="<%=AppPropertyUtil.getStaticUrl()%>/js/profile.js"> </script>
  <script src="<%=AppPropertyUtil.getStaticUrl()%>/js/jquery-1.6.4.js" ></script>
  <body>
  
    <div class="content"> 
       <div class="mark_manager">
         <h4>My Profile &gt; Edit Profile</h4>
       </div>
       <p></p>
       <div class="my_profile">
         <form action="<%=PathUtil.getFullPath("profile")%>" method="GET" id="myProfile" name="myProfile">
           <div class="user_password">
             &nbsp;Username: ${sessionScope.USER.userName}
             <p>&nbsp;&nbsp; Gender: <input type="radio" value="male" name="gender" checked="checked">Male
               <input type="radio" value="female" name="gender">Female
             <p>&nbsp;Password: <input type="password" name="password" id="password" class="profile_input"/>
           </div>
             <p>Comfirm Password: <input type="password" name="comfirmpassword" id="comfirmpassword" class="profile_input"/>
           <div class="user_password">
             <p>Full Name: <input type="text" name="fullName" id="fullName" class="profile_input" />
             <p>Role Type: ${requestScope.userRole}
             <p>Telephone: <input type="text" name="telephone" id="telephone" class="profile_input"/>
             <p>&nbsp;&nbsp;&nbsp;   Email: <input type="text" name="email" id="email" class="profile_input"/>
             <p>&nbsp; Address: <input type="text" name="address" id="address" class="profile_input" />
             <div id="errorMessage" class="errorMessage"> </div>
             <p>&nbsp;&nbsp;<input type="button" value="Submit" onclick="editProfile()" class="sub_can"/>&nbsp;
             <input type="button" value="Cancel" onclick="cancelMyProfile()" class="sub_can" />
           </div>
         </form>
       </div>
    </div>    
  </body>
</html>