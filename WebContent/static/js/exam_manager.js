$(function() {
    $("#question_manager").css("background", "");
    $("#exam_manager").css("background","black");
    $("#profile").css("background", ""); 
    
    var pageCount = $("#pageCount").attr("value");
    if($("#pageCount").val() == 0) {
        $(".page_header").css("visibility", "hidden");        
        var message = "<div id='searchResultMessage'>No data found!</div>";
        $(".page_header").after(message);
    }
});

 function paginationGo() {
        
    if (!(/^[-]{0,1}[0-9]{1,}$/).test($("#currentPage").val())) {
    alert("Please input right page.");
       return;
    }
    window.location.href = 'showExam?currentPage=' + $("#currentPage").val() +'&examName=' + $("#examName").val();
}
function btnExam() {
    var isSubmit = true;
    if (!$("#examName").val().trim()) {
        isSubmit = false;
        window.location.href='showExam';
    }
    if (isSubmit) {
        $("#examList").submit();
    }
}