<?php

$host = 'localhost';
$db   = 'myDatabase';
$user = 'myUsername';
$pass = 'myPassword';

try {
    $conn = new PDO("mysql:host=$host;dbname=$db", $user, $pass);
} catch (PDOException $e) {
    echo "Connection failed: " . $e->getMessage();
    exit;
}

if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST['upc'])) {

    // Prepare the SQL statement
    $stmt = $conn->prepare("SELECT * FROM products WHERE upc=:upc");

    // Bind parameters to avoid injection attacks
    $stmt->bindParam(':upc', $_POST['upc']);

    try {
        if ($stmt->execute()) {
            $row = $stmt->fetch(PDO::FETCH_ASSOC);
            if ($row) {
                echo json_encode($row);
            } else {
                http_response_code(404); // Not found
                echo "No product with the given UPC was found.";
            }
        } else {
            http_response_code(404); // Not found
            echo "No product with the given UPC was found.";
        }

    } catch (PDOException $e) {
        http_response_code(500); // Internal Server Error
        echo "Error: " . $e->getMessage();
    }
}
?>