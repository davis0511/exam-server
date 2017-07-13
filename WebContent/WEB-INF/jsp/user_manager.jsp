<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.augmentum.exam.model.Pagination"%> 
<%@ page import="com.augmentum.exam.model.User"%>
<%@ page import="com.augmentum.exam.util.PathUtil"%>
<%@ page import="com.augmentum.exam.util.AppPropertyUtil"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="/WEB-INF/block.tld" prefix="block" %>
  <script src="<%=AppPropertyUtil.getStaticUrl()%>/js/user_manager.js"></script>
  <%Pagination pagination = (Pagination)request.getAttribute("pagination");
  %>
  <div class="content"> 
    <div class="mark_manager">
      <h4>user Manager &gt; user List</h4>
    </div>
    <div class="show_question_list">
      <div class="submit_form">
        <div class="btn_user">
          <a href="<%=PathUtil.getFullPath("user/createUser")%>">
            <input type="button" value="Create User" name="btn_question" class="btn_create "/>
          </a>
        </div>
      <!-- user form start -->
        <form action="" method="Get" id="questionList" name="questionList">
          
          <!-- user list  start-->
          <div class="qt_list">
            <div id="table_header">
              <div class="name">Username</div>
              <div class="answer">Full Name</div>
              <div class="answer">Role</div>
              <div class="answer">Email</div> 
              <div class="operation">Telephone</div> 
              <div class="operation">Operations</div> 
            </div>
            <%
            int i = 0;
            List<User> userList = (List<User>)request.getAttribute("userList");
            for (User user : userList) {
                i++;
            %>
            <div id="table_content">
              <div class="name"><%=user.getUserName() %></div>
              <div class="answer"><%=user.getFullName() %></div>
              <div class="answer"><%=user.getName() %></div>
              <div class="answer"><%=user.getEmail() %></div> 
              <div class="operation"><%=user.getTelephone() %></div> 
              <div class="operation">
                <div class="is_delete">
                  <a href="<%=PathUtil.getFullPath("user/editUser")%>?id=<%=user.getId()%>">
                    <label class="is_delete">Edit</label>
                  </a>
                  <label class="is_delete"  onclick="deleteUser(<%=user.getId()%>,<%=pagination.getCurrentPage()%>)" >Delete</label>
                </div>
              </div> 
            </div>
            <%} %>
          </div>
        </form>
        <!-- question list  end-->

        <!-- question form end -->
        <br>
        <!-- page block start -->
         <block:display name="PaginationUserBlock"/>
        <!-- page block end -->
      </div>
    </div>
  </div>
