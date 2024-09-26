<?php
$connection = new mysqli("localhost", "username", "password", "database");

if ($connection->connect_error) {
    die("Connection failed: " . $connection->connect_error);
}

$stmt = $connection->prepare("SELECT * FROM users WHERE ID = ?");
$stmt->bind_param("s", $the_id);
$the_id = $_GET['id'];
$stmt->execute();
$result = $stmt->get_result();

if ($result->num_rows > 0) {
    $delete_stmt = $connection->prepare("DELETE FROM users WHERE ID = ?");
    $delete_stmt->bind_param("s", $the_id);
    $delete_stmt->execute();
    header("Location: success_page.php");
    exit;
} else {
    header("Location: error_page.php");
    exit;
}

$stmt->close();
$connection->close();
?>