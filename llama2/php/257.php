<?php
$dsn = 'mysql:host=localhost;dbname=your_database';
$username = 'your_username';
$password = 'your_password';

try {
    $pdo = new PDO($dsn, $username, $password);
} catch (PDOException $e) {
    echo 'Connection failed: ' . $e->getMessage();
    exit();
}

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $entries = filter_var($_POST['entries'], FILTER_VALIDATE_IP);
    $username = filter_var($_POST['username'], FILTER_SANITIZE_STRING);
    $message = filter_var($_POST['message'], FILTER_SANITIZE_STRING);

    $stmt = $pdo->prepare('SELECT * FROM users WHERE username = :username');
    $stmt->bindValue(':username', $username, PDO::PARAM_STR);
    $stmt->execute();

    $user = $stmt->fetch();

    if ($user) {
        echo "User found!";
    } else {
        echo "User not found!";
    }
}
?>
<form method="post">
    <input type="text" name="entries" placeholder="IP Address">
    <input type="text" name="username" placeholder="Username">
    <input type="text" name="message" placeholder="Message">
    <input type="submit" value="Submit">
</form>