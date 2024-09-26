<?php
$message = 'your_message_here';
$length = strlen($message);
$key = 'your_key_here';
$character = 1; // adjust this value as needed
for ($i = 0; $i < $length; $i++) {
    for ($j = 0; $j < $character; $j++) {
        echo chr((ord($message[$length - (($i+1) * $character + $j)]) ^ (ord($key[0]))));
    }
}
?>