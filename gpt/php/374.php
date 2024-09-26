
// In your contact-form-handler.php
session_start();

// Form validation code goes here

// If validation is successful
$_SESSION['form_submitted'] = true;

// Redirect to the download page
header('Location: thank-you.php');
exit;

