<?php
$servername = "your_server_name";
$username = "your_username";
$password = "your_password";
$dbname = "your_database_name";

$conn = new mysqli($servername, $username, $password, $dbname);

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    // Prepare and bind
    if (isset($_POST['value'])){
        $stmt = $conn->prepare("INSERT INTO tableName (column) VALUES (?)");
        $stmt->bind_param("s", $_POST['value']);

        // Execute the statement
        try {
            $result = $stmt->execute();

            if ($result === TRUE){
                echo "Value inserted.";
            }

            $stmt->close();
            $conn->close();

        } catch (Exception $e) {
           die("Error: ". $e->getMessage());
       }
    }
}
?>