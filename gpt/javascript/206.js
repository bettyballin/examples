
$(document).ready(function() {
    function enableLoginIfNotEmpty() {
        if ($("#userName").val() && $.trim($('#userName').val()) !== '' && $("#password").val() && $.trim($('#password').val()) !== '') {
            $('#submitLogin').attr('disabled', false);
        } else {
            $('#submitLogin').attr('disabled', true);
        }
    }

    // Check initially if the fields are autofilled
    setTimeout(enableLoginIfNotEmpty, 100);

    // Attach event handlers for user input
    $('input').on('keyup blur', enableLoginIfNotEmpty);

    // Optional: You might want to periodically check in case the browser autofills after some delay
    setInterval(enableLoginIfNotEmpty, 500);
