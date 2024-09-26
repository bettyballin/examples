
// In your thank-you.php
session_start();

if (empty($_SESSION['form_submitted'])) {
    // Redirect to the form page if the form was not submitted
    header('Location: sign-up-form.php');
    exit;
}

// Rest of the code
