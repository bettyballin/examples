
session_start(); // Start or resume the session

// ... your user authentication logic ...

if ($user_authenticated) {
    // The user is authenticated, regenerate the session ID
    session_regenerate_id(true); // Pass true to delete the old session file

    $_SESSION['user_id'] = $user_id; // Set user session variables
    // ... set other session variables if needed ...

    // Redirect to the protected page
    header('Location: protected_page.php');
    exit;
} else {
    // Authentication failed
    // ... handle failed authentication ...
}

