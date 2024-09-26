<?php
$to = 'recipient@example.com';
$subject = 'Testing';
$message = 'Some body text';
$headers = 'Cc: spamrecipient@example.com' . "\r\n";

mail($to, $subject, $message, $headers);
?>