<?php
session_start();

function createToken($length = 60) {
    return bin2hex(openssl_random_pseudo_bytes($length));
}

$token = createToken();
$_SESSION['emailConfirmationToken'] = $token;

// Send an email with a link containing this token
$mailTo = "recipient@example.com";
$mailSubject = "Email Confirmation";
$mailBody = "Please confirm your email address by clicking this link: http://example.com/confirm-email.php?token=$token";
$mailHeaders = "From: sender@example.com";

mail($mailTo, $mailSubject, $mailBody, $mailHeaders);

echo "Email sent with token: $token";



// confirm-email.php
<?php
session_start();

if (isset($_GET['token']) && $_GET['token'] === $_SESSION['emailConfirmationToken']) {
    // Token is valid, confirm email address
    echo "Email address confirmed!";
} else {
    // Token is invalid, do not confirm email address
    echo "Invalid token!";
}