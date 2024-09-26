<?php
// Include necessary files for connecting to DB
include 'db_connect.php';

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    // Validate input if needed
    if (!isset($_POST['id']) || empty($_POST['id'])) {
        http_response_code(400);
        echo json_encode(['error' => ['message' => 'Message ID is required']]);
        exit;
    }

    $messageId = $_POST['id'];

    try {
        // Update the database
        $conn = new PDO("mysql:host=localhost;dbname=your_database", "your_username", "your_password");
        $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        $sql = "UPDATE your_table SET column_name = 'new_value' WHERE id = :id";
        $stmt = $conn->prepare($sql);
        $stmt->bindParam(':id', $messageId);
        $stmt->execute();

        echo json_encode(['success' => true]);

    } catch (Exception $e) {
       http_response_code(500);
       echo json_encode([
           'error' => [
                'message' => "An error occurred while updating the database.",
                'details' => $e->getMessage()
            ]
       ]);
   }
}
?>