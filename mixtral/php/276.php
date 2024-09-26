<?php
require 'vendor/autoload.php';
use PHPMailer\PHPMailer\PHPMailer;

$mail = new PHPMailer(true);

try {
    $mail->isSMTP();
    //Enable SMTP debugging
    // 0 = off (for production use)
    // 1 = client messages
    // 2 = client and server messages
    $mail->SMTPDebug = 0;

    //Set the hostname of the mail server
    $mail->Host = 'smtp.gmail.com';

    //Set the SMTP port number:
    // - 465 for SMTP with implicit TLS aka SSL
    // - 587 for STARTTLS
    $mail->Port = 587;

    //Whether to use SMTP authentication
    $mail->SMTPAuth = true;

    //Username (email address)
    $mail->Username = getenv('GMAIL_USERNAME');

    //Password
    $mail->Password = getenv('GMAIL_PASSWORD');

    //Set who the message is to be sent from
    $mail->setFrom(getenv('FROM_EMAIL'), 'Your Name');

    //Set an alternative reply-to address
    $replyToEmail = 'reply@example.com';
    $name = 'John Doe';
    $mail->addReplyTo($replyToEmail, $name);

    //Set who the message is to
    $mail->addAddress(getenv('TO_EMAIL'));

    //Set the subject line
    $mail->Subject = 'Test Email';

    //Set the body of the message
    $mail->Body = 'This is a test email sent via PHPMailer';

    //send the message
    $mail->send();
    echo 'Message has been sent';
} catch (Exception $e) {
    echo "Message could not be sent. Mailer Error: {$mail->ErrorInfo}";
}
?>