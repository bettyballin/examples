<?php
// Configuration
$host = 'your_host';
$dbname = 'your_database';
$username = 'your_username';
$password = 'your_password';

// Create PDO connection
$pdo = new PDO("mysql:host=$host;dbname=$dbname", $username, $password);

// Check for POST request
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $messageId = $_POST['messageId'];

    // Validate and sanitize $messageId
    $messageId = filter_var($messageId, FILTER_VALIDATE_INT);
    if ($messageId === false) {
        http_response_code(400);
        echo 'Invalid message ID';
        exit;
    }

    // Update message status
    $stmt = $pdo->prepare("UPDATE messages SET is_read = 1 WHERE id = :id");
    $stmt->execute([':id' => $messageId]);

    // Return success response
    http_response_code(200);
    echo 'Message marked as read';
} else {
    http_response_code(405);
    echo 'Method not allowed';
}