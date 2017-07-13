function saveUser() {

    var isSubmitForm = true;
    var errorMsg = "";

    if (!$("#userName").val().trim()) {
        isSubmitForm = false;
        errorMsg = "With * must be filled!";
        $("#userName").css("border", "1px dashed #EB340A");
    } else {
        $("#userName").css("border", "1px solid #858585");
    }
    
  //  var options = $("#select option:selected");
    //alert(options.val()));
   // if (!(options.text()> 1)) {
     //   isSubmitForm = false;
     //   errorMsg = "With * must be filled!";
    //}

    if (isSubmitForm) {
        var result = confirm("Determine submit it?");
        if (result) {
            $("#CreateUserForm").submit(); 
        }
    } else {
        $("#errorMessage").text(errorMsg);
    }
}

function cancelUser(str) { 
    var result = confirm("Determine cancel it?");
    if (result) {   
        window.location.href= 'showUser?currentPage=' + str;
    }
}