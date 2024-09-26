<?php

$secret_key = 'your_secret_key';
$expected_token = hash_hmac('sha256', (string)time(), $secret_key);

if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['token'])) {
  if (hash_equals($_POST['token'], $expected_token)) {
    // do the things
  } else {
    echo "Invalid token";
  }
} else {
  echo "Invalid request";
}

?>