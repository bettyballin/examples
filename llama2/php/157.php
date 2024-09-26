<?php

class CustomMail {
    public function sendEmail($to, $subject, $message) {
        // Set a random X-Php-Originating-Script header
        $_SERVER['X_PHP_ORIGINATING_SCRIPT'] = bin2hex(random_bytes(10));

        // Call the mail function
        return mail($to, $subject, $message);
    }
}

$mail = new CustomMail();
$to = 'example@example.com';
$subject = 'Test Email';
$message = 'This is a test email sent using the CustomMail class.';
echo $mail->sendEmail($to, $subject, $message) ? 'Email sent successfully' : 'Error sending email';

?>