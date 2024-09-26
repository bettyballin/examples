
if(password_verify($pass, $row['password'])) { // If the password was correct
    $_SESSION['user_authenticated'] = true; // Set a flag that the user is authenticated
    // You may also want to store the user's ID or username to identify the user in subsequent requests
    $_SESSION['user_id'] = $row['user_id'];
}

