function login() {

    var isSubmitForm = true; 
    var errorMsg = ""; 
    var userNameIsNull = false;
    var passwordIsNull = false;
 
    if (!$("#userName").val()) {
        userNameIsNull = true;
        errorMsg = "Please input your user name.";
        isSubmitForm= false;
        $("#userName").css("border", "1px dashed #EB340A");
    } else {
        $("#userName").css("border", "1px solid #858585");
    }

    if (!$("#password").val()) {
        passwordIsNull = true;
        errorMsg = "Please input your password.";
        $("#password").css("border", "1px dashed #EB340A");
        isSubmitForm= false;
    } else {
        $("#password").css("border", "1px solid #858585");
    }

    if (userNameIsNull && passwordIsNull) {
        errorMsg = "Please input your user name and password.";
    }
    if (!isSubmitForm) {
        $("#errorMsg").text(errorMsg);
        $("#errorMsg").css("visibility" , "visible");
    }
    if (isSubmitForm) {
        $("#loginForm").submit();
    }
}
