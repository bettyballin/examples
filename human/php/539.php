<?php
// Assuming you have a database connection established
$conn = mysqli_connect("localhost", "username", "password", "database");

// Check connection
if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}

// Assuming you have a query to fetch data
$query = "SELECT Password_Hash, Salt FROM your_table";
$result = mysqli_query($conn, $query);

if (mysqli_num_rows($result) > 0) {
    while($rows = mysqli_fetch_assoc($result)) {
        $db_pass_hash = trim($rows['Password_Hash']);
        $db_salt = trim($rows['Salt']);

        // Now you can use $db_pass_hash and $db_salt
        echo "Password Hash: $db_pass_hash\n";
        echo "Salt: $db_salt\n";
    }
} else {
    echo "0 results";
}

mysqli_close($conn);
?>