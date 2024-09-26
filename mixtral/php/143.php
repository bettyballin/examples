<?php
$password = 'your_password_here'; // replace with the password to check
$hash = strtoupper(sha1($password));

$firstFive = substr($hash, 0, 5);
$lastThirtyFive = substr($hash, 5);

$url = 'https://api.pwnedpasswords.com/range/' . $firstFive;

$ch = curl_init($url);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
$response = curl_exec($ch);
curl_close($ch);

if (strpos($response, $lastThirtyFive) !== false) {
    echo 'Password is not valid (pwned)';
} else {
    echo 'Password is valid';
}
?>