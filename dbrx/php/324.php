<?php

function encrypt($data, $key) {
    $method = 'aes-256-cbc';
    $iv = openssl_random_pseudo_bytes(openssl_cipher_iv_length($method));
    $encrypted = openssl_encrypt($data, $method, $key, OPENSSL_RAW_DATA, $iv);
    return base64_encode($iv . $encrypted);
}

function decrypt($data, $key) {
    $method = 'aes-256-cbc';
    $data = base64_decode($data);
    $iv = substr($data, 0, openssl_cipher_iv_length($method));
    $decrypted = openssl_decrypt(substr($data, openssl_cipher_iv_length($method)), $method, $key, OPENSSL_RAW_DATA, $iv);
    return $decrypted;
}

$dsn = 'mysql:host=localhost;dbname=test';
$username = 'root';
$password = '';

$pdo = new PDO($dsn, $username, $password);

if (isset($_FILES['users_image'])) {
    $image = file_get_contents($_FILES['users_image']['tmp_name']);
    $enc_image = encrypt($image, "long secret random key");
    $stmt = $pdo->prepare("INSERT INTO table (file) VALUES (?)");
    $stmt->execute([$enc_image]);
}

$stmt = $pdo->query("SELECT file FROM table WHERE id = 1");
$row = $stmt->fetch();
$decrypted_img = decrypt($row['file'], "long secret random key");

echo '<img src="data:image/jpeg;base64,' . base64_encode($decrypted_img) . '" />';