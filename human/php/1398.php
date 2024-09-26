<?php
$epoch_time = time();
$message = "your_message_here";
$secret_token = "your_secret_token_here";

$result = $epoch_time . "." . hash_hmac("sha512", $epoch_time . $message, $secret_token);
print($result);
?>