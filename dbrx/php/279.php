<?php
$dsn = 'mysql:host=localhost;dbname=your_database';
$username = 'your_username';
$password = 'your_password';

try {
    $pdo = new PDO($dsn, $username, $password);
} catch (PDOException $e) {
    die('Connection failed: ' . $e->getMessage());
}

$stmt = $pdo->prepare("SELECT * FROM users WHERE username=:username AND password=:password");
$stmt->execute(array(':username' => $_POST['username'], ':password' => md5($_POST['password'])));
$result = $stmt->fetch();
if($result) {
    echo "User found";
} else {
    echo "No user found";
}
?>