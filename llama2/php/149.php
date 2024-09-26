<?php

// User registers with username and password; assume they're already validated
$username_entered = 'example_username';
$password_entered = 'example_password';

function create_hash($password) {
  $salt = bin2hex(random_bytes(16));
  $hash = hash_pbkdf2('sha256', $password, $salt, 100000, 32, true);
  return [
    'salt' => $salt,
    'hash' => bin2hex($hash)
  ];
}

$password = create_hash($password_entered);
$salt = $password['salt'];
$hashed_password = $password['hash'];

$dsn = 'sqlite:example.db'; // replace with your database connection
$pdo = new PDO($dsn);
$pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

$statement = $pdo->prepare("
  INSERT INTO users (username, password, salt)
  VALUES (:username, :password, :salt)
");

$statement->execute(array(
  ':username'  => $username_entered,
  ':password'  => $hashed_password,
  ':salt'     => $salt
));

?>