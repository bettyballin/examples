<?php
// This PHP code will handle the AJAX request from the form submission

// Check if the request is POST
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    // Get the form data
    $formData = $_POST;

    // Handle the form data as needed
    // For demonstration purposes, we'll just return the data back to the client
    echo json_encode($formData);

    // Exit the script to prevent further execution
    exit;
}
?>

<!-- This HTML code will render the form and execute the JavaScript code -->

<form id="myForm">
    <!-- Your form fields here -->
    <input type="text" name="example" value="Hello, World!">
    <button type="submit">Submit</button>
</form>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<script>
    var $form = $('#myForm');

    $form.submit(function(event) {
        var request = $.post('<?php echo $_SERVER['PHP_SELF']; ?>', $form.serialize());

        request
            .done(function(data) {
                console.log('Done', data);
            })
            .fail(function(error) {
                console.log('Request fail', error);
            });

        event.preventDefault();
    });
</script>