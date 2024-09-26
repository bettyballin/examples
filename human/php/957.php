<?php

$username = 'your_username';
$password = 'your_password';

$db = new PDO(
    'mysql:host=localhost;dbname=mydatabase;charset=UTF-8',
    $username,
    $password
);

// other stuff in between

$statement = $db->prepare(
    "INSERT INTO yourtable (email, username) VALUES (:email, :username);"
);
$success = $statement->execute([
    ':email'    => $_POST['email'],
    ':username' => $_POST['username']
]);

?>