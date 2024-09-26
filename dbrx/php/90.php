<?php

$to = 'test@domain.com'; // replace with your test email

$allowedRecipients = ['admin@domain.com', 'support@domain.com'];
if (!in_array($to, $allowedRecipients)) {
    echo "Email not allowed";
    return false;
} else {
    echo "Email allowed";
}