<?php

// Generate token and store it in database
$token = bin2hex(random_bytes(32));
$member_id = 1; // Replace with actual member ID
$expiration = time() + 3600; // Token expires in 1 hour
$hashedToken = password_hash($token, PASSWORD_DEFAULT);
$key_for_verify = 'secret_key'; // Replace with actual secret key

// Store in database (example using PDO)
$dsn = 'mysql:host=localhost;dbname=example';
$username = 'username';
$password = 'password';
$pdo = new PDO($dsn, $username, $password);
$stmt = $pdo->prepare('INSERT INTO tokens (member_id, token, expiration) VALUES (:member_id, :token, :expiration)');
$stmt->execute([':member_id' => $member_id, ':token' => $hashedToken, ':expiration' => $expiration]);

// Later when verifying
$stmt = $pdo->prepare('SELECT hashedToken, expiration FROM tokens WHERE member_id = :member_id');
$stmt->execute([':member_id' => $member_id]);
$row = $stmt->fetch();

if ($row['expiration'] > time() && password_verify($key_for_verify . $token, $row['hashedToken'])) {
    echo 'TRUE';
} else {
    echo 'FALSE';
}

?>