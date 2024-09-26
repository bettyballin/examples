<?php
// Include the Bcrypt library
require 'path_to_your_bcrypt/BCrypt.php';

$cost = 10; // Increase this value for more security but it will take longer to hash

if(isset($_POST['submit'])) {
    $username = $_POST["Username"];
    $Password = $_POST["Password"];
    $Password2 = $_POST["Password2"];

    if($Password !== $Password2){
        echo "So sorry passwords do not match!";
        exit;
    }

    // Hash the password
    $hashed_password = Bcrypt::hash($Password);

    try {
        # Connect to database
        $dsn = 'mysql:host=your_host;dbname=your_database';
        $pdo = new PDO($dsn, 'your_username', 'your_password');

        // Prepare and execute a query using prepared statements
        $stmt = $pdo->prepare('INSERT INTO your_table (username, password) VALUES (:username, :password)');
        $stmt->bindParam(':username', $username);
        $stmt->bindParam(':password', $hashed_password);

        if ($stmt->execute()){
            echo "Your account has been created successfully. \\\
Thank you for joined us!";
        }

    } catch(PDOException $e) {
        die("ERROR: Could not connect to database.  ". $e->getMessage());
    }
}
?>