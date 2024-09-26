
$('#download').click(function() {

    var params = $('#params_').clone();

    // Retrieve the CSRF token value
    var token = $('#csrfToken').val(); //
