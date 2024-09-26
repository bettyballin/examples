<?php
$message = 'your_message_here';
$key = 'your_secret_key_here';

try {
    if (mb_strlen($message, '8bit') < 64) {
        throw new Exception("Invalid message length.");
    }
    $mac = mb_substr($message, 0, 64, '8bit');
    $data = mb_substr($message, 64, null, '8bit');
    $recalc = hash_hmac('sha256', $data, $key);
    if (!hash_equals($recalc, $mac)) {
        throw new Exception("Invalid MAC.");
    }
    // Now we know $data is legitimate.
    echo "Data is legitimate.";
} catch (Exception $e) {
    echo "Error: " . $e->getMessage();
}
?>