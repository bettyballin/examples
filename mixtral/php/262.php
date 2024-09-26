<?php
$form_data = [
    'username' => $_POST['username'],
    'email' => filter_var($_POST['email'], FILTER_VALIDATE_EMAIL)
];

// Perform additional validation and sanitization as needed

extract($form_data);