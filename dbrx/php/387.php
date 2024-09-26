<?php

// Set configuration options
ini_set('session.use_only_cookies', 1);
ini_set('session.cookie_secure', 0); // Change to true if you have SSL enabled.
ini_set('session.name', 'my_session_name');
ini_set('session.gc_maxlifetime', 3600);

// Start the session and regenerate ID on every request
session_start();
if (isset($_SESSION['id'])) {
    session_regenerate_id(true);
}

// Check for CSRF token if necessary

// Perform authentication checks here e.g check username/password against a database.
if(isset($_POST['username']) && isset($_POST['password'])){
    $username = $_POST['username'];
    $password = $_POST['password'];
    // Replace with your own database connection and query
    $db_host = 'localhost';
    $db_username = 'your_username';
    $db_password = 'your_password';
    $db_name = 'your_database';

    $conn = new mysqli($db_host, $db_username, $db_password, $db_name);

    if ($conn->connect_error) {
        die("Connection failed: " . $conn->connect_error);
    }

    $sql = "SELECT id FROM users WHERE username = '$username' AND password = '$password'";
    $result = $conn->query($sql);

    if ($result->num_rows > 0) {
        while($row = $result->fetch_assoc()) {
            $id = $row["id"];
        }
        // Set user data in the session after successful login
        $_SESSION['loggedin'] = true;
        $_SESSION['name'] = $username;
        $_SESSION['id'] = $id;
        header("Location: dashboard.php"); // Redirect to dashboard
        exit;
    } else {
        echo "Invalid username or password";
    }
    $conn->close();
} else {
    echo "Please enter both username and password";
}

?>