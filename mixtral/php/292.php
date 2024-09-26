<?php
// Assuming $pdo is a valid PDO instance
$date = '2022-01-01'; // Example date
$pdo = new PDO('mysql:host=localhost;dbname=database', 'username', 'password');

$stmt = $pdo->prepare("SELECT * FROM table WHERE column AND created_at <= :date");

if ($stmt) {
    // Bind the parameter
    $stmt->bindParam(':date', $date, PDO::PARAM_STR);

    if (!$stmt->execute()) {
        print_r($pdo->errorInfo());
    } else {
        while ($row = $stmt->fetch(PDO::FETCH_ASSOC)) {
            // Process the result
            print_r($row);
        }
    }
}
?>