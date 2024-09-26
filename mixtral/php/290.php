<?php
// Send the sms
$number = '1234567890'; // replace with actual phone number
$url = 'https://example-api/sendSms?message=Hello&phoneNumber=' . urlencode($number);

file_get_contents($url, false, stream_context_create(array('http' => array('ignore_errors'=>true))));

// Redirect to another page
header("Location: https://example.com/redirect-page");
exit();
?>