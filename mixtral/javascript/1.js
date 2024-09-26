$(document).on('click', '.message-item', function() {
    $.ajax({
        url: '/path/to/your/php_script.php',
        type: 'POST',
        dataType: 'json',
        success: function(response) {
            // Handle the response
            console.log(response);
        },
        error: function(jqXHR, textStatus, errorThrown) {
            console.log('Error:', jqXHR);
        }
    });
});