<?php
// Connect to the database
$conn = mysqli_connect("localhost", "username", "password", "database");

// Check connection
if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}

// Process login form
if (isset($_POST['submit'])) {
    $username = $_POST['username'];

    // Assuming there is a password field in the form
    $password = $_POST['password'];

    // Query to check username and password
    $query = "SELECT * FROM users WHERE username = '$username' AND password = '$password'";
    $result = mysqli_query($conn, $query);

    // Check if user exists
    if (mysqli_num_rows($result) > 0) {
        echo "Login successful!";
    } else {
        echo "Invalid username or password!";
    }
}

// Close the connection
mysqli_close($conn);
?>