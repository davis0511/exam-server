$(function() {
    $("#question_manager").css("background", "");
    $("#exam_manager").css("background","");
    $("#profile").css("background", "black"); 
});
function editProfile() {
    var isSubmitForm = true;
    var errorMsg = "";

    if (!$("#password").val().trim()) {
        isSubmitForm = false;
        errorMsg = "Marquee must be filled!";
        $("#password").css("border", "1px dashed #EB340A");
    } else {
        $("#password").css("border", "1px solid #858585");
    }

    if (!$("#comfirmpassword").val().trim()) {
        isSubmitForm = false;
        errorMsg = "Marquee must be filled!";
        $("#comfirmpassword").css("border", "1px dashed #EB340A");
    } else {
        $("#comfirmpassword").css("border", "1px solid #858585");
    }

    if (!$("#fullName").val().trim()) {
        isSubmitForm = false;
        errorMsg = "Marquee must be filled!";
        $("#fullName").css("border", "1px dashed #EB340A");
    } else {
        $("#fullName").css("border", "1px solid #858585");
    }

    if (!$("#telephone").val().trim()) {
        isSubmitForm = false;
        errorMsg = "Marquee must be filled!";
        $("#telephone").css("border", "1px dashed #EB340A");
    } else {
        $("#telephone").css("border", "1px solid #858585");
    }
    
    
    if (!$("#email").val().trim()) {
        isSubmitForm = false;
        errorMsg = "Marquee must be filled!";
        $("#email").css("border", "1px dashed #EB340A");
    } else {
        $("#email").css("border", "1px solid #858585");
    }
    
    if (!$("#address").val().trim()) {
        isSubmitForm = false;
        errorMsg = "Marquee must be filled!";
        $("#address").css("border", "1px dashed #EB340A");
    } else {
        $("#address").css("border", "1px solid #858585");
    }
    
    if ($("#password").val() != $("#comfirmpassword").val()) {
        isSubmitForm = false;
        errorMsg = "password different with confirmpassword!";
    }
    
    if (isSubmitForm) {
        var result = confirm("Determine submit it?");
        if (result) {
            $("#myProfile").submit();
        }
    } else {
        $("#errorMessage").text(errorMsg);
    }
}

function cancelMyProfile() {
   
    if ($("#password").val().trim()) {
        $("#password").val("");
    }

    if ($("#comfirmpassword").val().trim()) {
        $("#comfirmpassword").val("");
    } 

    if ($("#fullName").val().trim()) {
        $("#fullName").val("");
    }

    if ($("#telephone").val().trim()) {
        $("#telephone").val("");
    } 
    
    if ($("#email").val().trim()) {
        $("#email").val("");
    } 
    
    if ($("#address").val().trim()) {
        $("#address").val("");
    } 
}