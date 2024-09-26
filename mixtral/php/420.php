<?php

$connection = mysqli_connect("localhost", "username", "password", "database");

if (!$connection) {
    die("Connection failed: " . mysqli_connect_error());
}

$stmt = $connection->prepare("SELECT * FROM users WHERE ID = ?");

if ($stmt) {
    // Bind the parameter
    $stmt->bind_param('i', $_GET['id']);

    if (!$stmt->execute()) {
        die($stmt->error);
    }

    // Fetch result
    $result = $stmt->get_result();

    if ($row = $result->fetch_assoc()) {

        // Delete the user
        $deleteStmt = $connection->prepare("DELETE FROM users WHERE ID = ?");

        if (!$deleteStmt) die('Delete statement failed: ' . htmlspecialchars($connection->error));

        $the_id = $row['ID'];

        $deleteStmt->bind_param('i', $the_id);

        // Execute the delete
        if ($deleteStmt->execute()) {
            header("Location: index.php");
            exit;
        } else die($deleteStmt->error);
    } else {
        header('Location: error_page.php');
        exit;
    }
} else {
    die('Select statement failed: ' . htmlspecialchars($connection->error));
}

$connection->close();

?>