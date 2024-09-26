<?php

require_once 'config.php';

$email = $_POST['email'];
$password = $_POST['password'];

$stmt = $conn->prepare("SELECT id, password FROM users WHERE email=?");
$stmt->bind_param("s", $email);
$stmt->execute();
$result = $stmt->get_result();

if ($result->num_rows > 0) {
    // Fetch the user data
    while($row = $result->fetch_assoc()) {
        if (password_verify($password, $row["password"])) {
            session_start();
            $_SESSION['user_id'] = $row["id"];
            header('Location: dashboard.php');
            exit;
        } else {
            echo "Invalid password";
        }
    }
} else {
    echo "User not found";
}

$stmt->close();

?>