
$email = $_POST['email'];

// Validate the email address
if (filter_var($email, FILTER_VALIDATE_EMAIL)) {
    // Sanitize the email address
    $sanitized_email = filter_var($email, FILTER_SANITIZE_EMAIL);

    // Now you can use $sanitized_email for further processing or storing
} else {
    // The email
