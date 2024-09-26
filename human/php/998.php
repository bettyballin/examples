<?php
$email = 'user@example.com'; // replace with the desired email
$db = new PDO('mysql:host=localhost;dbname=your_database', 'your_username', 'your_password');

$stmt = $db->prepare('SELECT count(userid) FROM users WHERE email = ?');
if ($stmt->execute([ $email ])) {
    $is_user = $stmt->fetchColumn(0);
    var_dump($is_user);
} else {
    var_dump($stmt->errorInfo());
}