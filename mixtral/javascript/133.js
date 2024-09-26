$(document).ready(function(){
    // Check if username and password are filled on load
    checkLoginInputs();

    $('input').on('keyup blur mouseenter', function (e) {
        checkLoginInputs();
    });
});

// Function to enable/disable login button based on input values
function checkLoginInputs() {
    if($("#userName").val().length !== 0 && $.trim($('#userName').val()) !== ''
        && $("#password").val().length !== 0 && $.trim($('#password').val()) !== ''){
        $('#submitLogin').attr('disabled', false);
    } else {
        $('#submitLogin').attr('disabled', true);
    }
}