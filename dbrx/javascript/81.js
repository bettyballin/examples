$(document).ready(function() {
    if ($("#userName").val().length !== 0 && $("#password").val().length !== 0) {
        $('#submitLogin').attr('disabled', false);
    }
});