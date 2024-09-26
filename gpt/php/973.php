
<?php
$servername = "localhost";
$username = "username";
$password = "password";
$dbname = "myDB";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);

// Check connection
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}

// Check if value is posted
if ($_SERVER["REQUEST_METHOD"] == "POST") {
  // Prepare the SQL statement
  $stmt = $conn->prepare("INSERT INTO MyTable (myValue) VALUES (?)");
  
  // Bind the parameter to the SQL
