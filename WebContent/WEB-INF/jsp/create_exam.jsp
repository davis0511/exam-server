<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.augmentum.exam.util.AppPropertyUtil"%>
<%@ page import="com.augmentum.exam.util.PathUtil"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>create exam</title>
  </head> 
  <script src="<%=AppPropertyUtil.getStaticUrl()%>/js/save_exam.js"> </script>
  <body>
    <div class="content"> 
       <div class="mark_manager">
         <h4>Exam Manager &gt; Create Exam</h4>
       </div><br/>
       <div class="creat_question">
         <div class="submit_form">
           <form action="<%=PathUtil.getFullPath("exam/saveExam")%>" method="POST" id="createExam" name="createExam">
             <div class="save_name">
               Name: <input type="text" name="name" class="exam_text_name" id="name"/>
               <label class="xingHao">*</label>
             </div>
             <div class="save_description">
               <p>Description: <textarea rows="3" cols="20" class="exam_area" name="description"></textarea>
             </div>
             <p>Single Question Score: <input type="text" name="singleScore" id="singScore" class="exam_other" onblur="getTotalScore()"/>
               <label class="xingHao">*</label>
             <div class="save_quality">
               <p>Question Quality: <input type="text" name="questionQuality" id="questionQuality" class="exam_other" onblur="getTotalScore()"/>
               <label class="xingHao">*</label>
             </div>
             <div class="save_score">
               <p>Total Score:&nbsp;<label id="total"></label>
             </div>
             <div class="save_duration">
               <p>Duration: <input type="text" name="duration" id="duration" class="exam_other" />mins 
               <label class="xingHao">*</label>
             </div>
             <div id="errorMessage" class="errorMessage"> </div>
               <p>&nbsp;&nbsp;<input type="button" value="Submit" onclick="saveExam()" class="save_sub"/>&nbsp;
             <input type="button" value="Cancel" onclick="cancelExam(${requestScope.pagination.currentPage})" class="save_can"/>
           </form>
         </div>
       </div>
    </div>
  </body>
</html>