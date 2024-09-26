
// Sanitize the message content
$message = filter_input(INPUT_POST, 'feedback', FILTER_SANITIZE_STRING);

// Sanitize and validate additional headers if there are any
$headers = 'From: myself@blah.com';
$headers = filter_var($headers, FILTER_SANITIZE_EMAIL);

// Use the sanitized message and headers in the mail function
if ($message !== false && $headers !== false) {
    mail("me@
