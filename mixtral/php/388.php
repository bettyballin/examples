<?php
$servername = "localhost";
$username = "username";
$password = "password";
$dbname = "dbname";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$query = "SELECT * FROM table_name";
$raw_results = mysqli_query($conn, $query);

if(mysqli_num_rows($raw_results) > 0){
    // Fetch data
    while($row = mysqli_fetch_assoc($raw_results)) {
        print_r($row);
    }
} else {
   echo 'No results found';
}

$conn->close();
?>