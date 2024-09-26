<?php
$mysqli = new mysqli("localhost", "username", "password", "database");

$stmt = $mysqli->prepare("SELECT * FROM table WHERE column=?");
$stmt->bind_param('s', $_POST['data']);

// execute query
if ($stmt->execute()) {
    $result = $stmt->get_result();
    while ($row = $result->fetch_assoc()) {
        print_r($row);
    }
} else {
    echo "Error: " . $mysqli->error;
}

$stmt->close();
$mysqli->close();
?>