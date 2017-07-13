$(function() {
    $("#user_manager").css("background", "black");
    $("#profile").css("background", ""); 
});

function paginationGo() {
        
   if (!(/^[-]{0,1}[0-9]{1,}$/).test($("#currentPage").val())) {
       alert("Please input right page.");
       return;
    }
    window.location.href = 'showUser?currentPage=' + $("#currentPage").val();
}

 function deleteUser(str, currentPage) {
    var result = confirm("Determine delete it?");
    if (result) {
        window.location.href='deleteUser?id=' + str +'&currentPage=' + currentPage;
    }
}