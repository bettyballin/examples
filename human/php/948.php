<?php

// Do this somewhere
define('CSRF_SALT', '4dedMj4CWgBMNhRsoTpJlokwB5wTz7UsmF8Mq4uzFIbv');

$token = base64_encode(
    hash_hmac(
        'sha256', 
        date('Ymd') . $_SERVER['REMOTE_ADDR'] . $_SERVER['HTTP_USER_AGENT'],
        CSRF_SALT,
        true
    )
);

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    if (hash_equals($_POST['security_token'], $token)) {
        // Form passes validation
        echo "Form passes validation";
    } else {
        echo "Invalid security token";
    }
} else {
    // Generate and display the form
    ?>
    <form method="post">
        <input type="hidden" name="security_token" value="<?php echo $token; ?>">
        <input type="submit" value="Submit">
    </form>
    <?php
}