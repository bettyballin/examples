<?php
session_start();

$dsn = 'mysql:host=localhost;dbname=test';
$username = 'root';
$password = '';

try {
    $pdo = new PDO($dsn, $username, $password);
} catch (PDOException $e) {
    echo 'Connection failed: ' . $e->getMessage();
    exit();
}

function pdoSet($allowed, $values) {
    $set = '';
    foreach ($allowed as $field) {
        if (isset($values[$field])) {
            $set .= "`".str_replace("`","``",$field)."`=':{$field}', ";
        }
    }
    return rtrim($set, ', ') ?: '';
}

function update_user($values) {
    global $pdo;
    $allowed = array("name","surname","email","password"); // allowed fields
    $sql = "UPDATE users SET ".pdoSet($allowed,$values)." WHERE id = :id";
    $stm = $pdo->prepare($sql);
    $values["id"] = $_SESSION['user_id'];
    $stm->execute($values);
}

// usage:
$values = array("name" => "John", "surname" => "Doe", "email" => "john@example.com", "password" => "password123");
update_user($values);