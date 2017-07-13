function saveQuestion() {

    var isSubmitForm = true;
    var errorMsg = "";

    if (!GetRadioValue("answer")) {
        isSubmitForm = false;
        errorMsg = "Please select a answer.";
        
    }

    if (!$("#textArea").val().trim()) {
        isSubmitForm = false;
        errorMsg = "With * must be filled!";
        $("#textArea").css("border", "1px dashed #EB340A");
    } else {
        $("#textArea").css("border", "1px solid #858585");
    }

    if (!$("#selectA").val().trim()) {
        isSubmitForm = false;
        errorMsg = "With * must be filled!";
        $("#selectA").css("border", "1px dashed #EB340A");
    } else {
        $("#selectA").css("border", "1px solid #858585");
    }

    if (!$("#selectB").val().trim()) {
        isSubmitForm = false;
        errorMsg = "With * must be filled!";
        $("#selectB").css("border", "1px dashed #EB340A");
    } else {
        $("#selectB").css("border", "1px solid #858585");
    }

    if (!$("#selectC").val().trim()) {
        isSubmitForm = false;
        errorMsg = "With * must be filled!";
        $("#selectC").css("border", "1px dashed #EB340A");
    } else {
        $("#selectC").css("border", "1px solid #858585");
    }
        
    if (!$("#selectD").val().trim()) {
        isSubmitForm = false;
        errorMsg = "With * must be filled!";
        $("#selectD").css("border", "1px dashed #EB340A");
    } else {
        $("#selectD").css("border", "1px solid #858585");
    }

    if (isSubmitForm) {
        var result = confirm("Determine submit it?");
        if (result) {
            $("#createQuestion").submit(); 
        }
    } else {
        $("#errorMessage").text(errorMsg);
    }
}

function cancelQuestion(str) { 
    var result = confirm("Determine cancel it?");
    if (result) {   
        window.location.href= 'showQuestion?currentPage=' + str;
    }
}

function GetRadioValue(RadioName) {
    var obj;    
    obj= document.getElementsByName(RadioName);
    if($("#radio") != null){
        var i;
        for(i=0;i<obj.length;i++){
            if(obj[i].checked){
                return obj[i];
            }
        }
    }
    return null;
}