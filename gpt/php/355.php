
if (isset($_SESSION['loggedInUser']) && $_SESSION['loggedInUser']->user_id) {
    // The user is logged in, proceed with the form processing.
} else {
    // The user is not logged in, redirect to the login page or return an error.
    header("Location: login.php");
    exit();
}

