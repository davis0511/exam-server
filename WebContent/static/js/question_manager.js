
    $(function() {
        $("#question_manager").css("background", "black");
        $("#exam_manager").css("background","");
        $("#profile").css("background", ""); 
        
        var pageCount = $("#pageCount").attr("value");
        if($("#pageCount").val() == 0) {
            $(".page_header").css("visibility", "hidden");        
            var message = "<div id='searchResultMessage'>No data found!</div>";
            $(".page_header").after(message);
        }
     });

    function DeleteQuestion(str, currentPage) {
        var result = confirm("Determine delete it?");
        if (result) {
            window.location.href='deleteQuestion?id=' + str +'&currentPage=' + currentPage;
        }
    }

    function paginationGo() {
        
        if (!(/^[-]{0,1}[0-9]{1,}$/).test($("#currentPage").val())) {
        alert("Please input right page.");
            return;
        }
        window.location.href = 'showQuestion?currentPage=' + $("#currentPage").val() +'&questionTitle=' + $("#questionTitle").val();
    }
    function btnQtTitle() {
       var isSubmit = true;
       if (!$("#questionTitle").val().trim()) {
           isSubmit = false;
           window.location.href='showQuestion';
       }
       if (isSubmit) {
           $("#questionList").submit();
       }
    }