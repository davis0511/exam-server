function saveExam() {

    var isSubmitForm = true;
    var errorMsg = "";

    if (!$("#name").val().trim()) {
        isSubmitForm = false;
        errorMsg = "With * must be filled!";
        $("#name").css("border", "1px dashed #EB340A");
    } else {
        $("#name").css("border", "1px solid #858585");
    }

    if (!$("#singScore").val().trim()) {
        isSubmitForm = false;
        errorMsg = "With * must be filled!";
        $("#singScore").css("border", "1px dashed #EB340A");
    } else {
        $("#singScore").css("border", "1px solid #858585");
    }

    if (!$("#questionQuality").val().trim()) {
        isSubmitForm = false;
        errorMsg = "With * must be filled!";
        $("#questionQuality").css("border", "1px dashed #EB340A");
    } else {
        $("#questionQuality").css("border", "1px solid #858585");
    }

    if (!$("#duration").val().trim()) {
        isSubmitForm = false;
        errorMsg = "With * must be filled!";
        $("#duration").css("border", "1px dashed #EB340A");
    } else {
        $("#duration").css("border", "1px solid #858585");
    }
    
    if (isSubmitForm) {
        var result = confirm("Determine submit it?");
        if (result) {
            $("#createExam").submit(); 
        }
    } else {
        $("#errorMessage").text(errorMsg);
    }
}
function cancelExam(str) { 
    var result = confirm("Determine cancel it?");
    if (result) {   
        window.location.href= 'showExam?currentPage=' + str;
    }
}
function getTotalScore() {
    var singleScore = $("#singScore").val();
    var quanlity = $("#questionQuality").val();
    if (singleScore != '' && quanlity != '') {
        $("#total").text(singleScore*quanlity);
    }
}