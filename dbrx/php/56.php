<?php
$dsn = 'mysql:host=localhost;dbname=your_database';
$username = 'your_username';
$password = 'your_password';

try {
    $pdo = new PDO($dsn, $username, $password);
    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
} catch (PDOException $e) {
    echo 'Connection failed: ' . $e->getMessage();
    exit();
}

$stmt = $pdo->prepare('INSERT INTO posts (post) VALUES (:post)');
$stmt->execute([':post' => $_REQUEST['post']]);

echo 'Post added successfully!';


bash
# to run this code, save it in a file (e.g. add_post.php) and run in the terminal:
php -S localhost:8000
# then open in your browser: http://localhost:8000/add_post.php?post=Your%20new%20post