
<?php

// Assume $connection is your database connection

if ($_SERVER['REQUEST_METHOD'] == 'POST' && isset($_POST['id'])) {
    $the_id = $_POST['id'];

    // Check if the ID exists in the database
    $stmt = $connection->prepare("SELECT COUNT(*) FROM users WHERE ID = ?");
    $stmt->bind_param('s', $the_id); // 's' is for string, use 'i' if your ID is an integer
    $stmt->execute();
    $stmt->bind_result($count);
    $stmt->fetch();
    $stmt->close();

    if ($count == 0) {
        // ID does not exist, redirect to an error page
        header("Location: error_page.php");
        exit;
    }

    // If ID exists, proceed with delete
    $stmt = $connection->prepare("DELETE FROM users WHERE
