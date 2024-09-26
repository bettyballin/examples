
$subject = filter_var(trim($_POST['subject']), FILTER_SANITIZE_STRING);
$comment = filter_var(trim($_POST['comment']), FILTER_SANITIZE_STRING);
$email = filter_var($email, FILTER_VALIDATE_EMAIL);

if ($email === false) {
    // Handle the error - invalid email address
}

