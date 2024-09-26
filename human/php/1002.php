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

$sql = 'SELECT id FROM users WHERE username = :username';
$statement = $pdo->prepare($sql);
$statement->bindParam(':username', $_POST['username']);
$statement->execute();

$result = $statement->fetch();
if ($result) {
  echo 'User ID: ' . $result['id'];
} else {
  echo 'User not found';
}


html
<form method="post">
  <label for="username">Username:</label>
  <input type="text" id="username" name="username">
  <input type="submit" value="Submit">
</form>