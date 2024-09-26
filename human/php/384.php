<?php

function login($username, $password) {
  $db = new PDO('mysql:host=localhost;dbname=your_database', 'your_username', 'your_password');

  // P: Look up username, fail if it doesn't exist.
  $stmt = $db->prepare('SELECT * FROM users WHERE username = :username');
  $stmt->bindParam(':username', $username);
  $stmt->execute();
  $user = $stmt->fetch();

  if (!$user) {
    return ['status' => 'fail', 'message' => 'Username does not exist'];
  }

  // P: If it does, check stored hash against passed hash, fail if different.
  if (!password_verify($password, $user['password'])) {
    return ['status' => 'fail', 'message' => 'Incorrect password'];
  }

  // P: If ok, return some other information about the user
  $userInfo = [
    'full_name' => $user['full_name'],
    'domain_specific_stuff' => $user['domain_specific_stuff']
  ];

  // D: If ok, create/update the user record
  $stmt = $db->prepare('UPDATE users SET last_login = NOW() WHERE id = :id');
  $stmt->bindParam(':id', $user['id']);
  $stmt->execute();

  // D: If ok, then log them in
  $_SESSION['user_id'] = $user['id'];

  return ['status' => 'ok', 'user_info' => $userInfo];
}

// Usage
$username = 'your_username';
$password = 'your_password';

$result = login($username, $password);

if ($result['status'] == 'ok') {
  echo 'Logged in successfully!';
  print_r($result['user_info']);
} else {
  echo 'Login failed: ' . $result['message'];
}